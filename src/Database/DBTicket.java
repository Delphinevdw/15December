package Database;

import static Database.DBFlightcode.getFlightcode;
import Logic.Flightcode;
import Logic.Ticket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTicket {
    
    public static Ticket getTicket(int ID) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id, price "
	+ "FROM tickets "
	+ "WHERE id = " + ID;

      ResultSet srs = stmt.executeQuery(sql);
      int ticketID, price;

      
      if (srs.next()) {
        ticketID = srs.getInt("id");
        price = srs.getInt("price");
      } 
      
      else {// we verwachten slechts 1 rij...
	DBConnector.closeConnection(con);
	return null;
      }
      
      Ticket ticket = new Ticket(ticketID, price);
      DBConnector.closeConnection(con);
      return ticket;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
  } 
    
    public static void save(Ticket t) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id "
              + "FROM tickets "
              + "WHERE id = " + t.getId();
      ResultSet srs = stmt.executeQuery(sql);
      if (srs.next()) {
        // UPDATE
	sql = "UPDATE tickets "
                + "SET id = '" + t.getId() + "'"
		+ ", price = " + t.getPrice();
        stmt.executeUpdate(sql);
      } else {
	// INSERT
	sql = "INSERT into tickets "
                + "(id, price) "
		+ "VALUES (" + t.getId()
		+ ", '" + t.getPrice() + "'";
        stmt.executeUpdate(sql);
      }
      DBConnector.closeConnection(con);
    } catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
  }
    
        
//RETOURNEERT EEN ARRAY LIST VAN TICKETS
  public static ArrayList<Ticket> getTickets() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM tickets ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Ticket> tickets = new ArrayList<Ticket>();
      while (srs.next())
        tickets.add(getTicket(srs.getInt("id")));
      
      DBConnector.closeConnection(con);
      return tickets;
      
    } catch (DBException dbe) {
      dbe.printStackTrace();
      DBConnector.closeConnection(con);
      throw dbe;
    } catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
  }
}
