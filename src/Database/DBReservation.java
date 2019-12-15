//OK
package Database;

import static Database.DBBooking.getBooking;
import static Database.DBFlightcode.getFlightcode;
import Logic.Booking;
import Logic.Flightcode;
import Logic.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBReservation {
    
    public static Reservation getReservation(int ID) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id, ticketId, flightId "
	+ "FROM reservations "
	+ "WHERE id = " + ID;

      ResultSet srs = stmt.executeQuery(sql);
      int id, ticketID, flightID;
      
      if (srs.next()) {
        id = srs.getInt("id");
	ticketID = srs.getInt("ticketId");
	flightID = srs.getInt("flightId");
      } 
      
      else {
	Database.DBConnector.closeConnection(con);
	return null;
      }
      
      Reservation reservation = new Reservation(id, ticketID, flightID);
      Database.DBConnector.closeConnection(con);
      return reservation;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
    }
    }
    
    
  //METHODE MET 2 VERSCHILLENDE DELEN: update en aanmaken
  public static void save(Reservation r) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id "
              + "FROM reservations "
              + "WHERE id = " + r.getId();
      ResultSet srs = stmt.executeQuery(sql);
      if (srs.next()) {
        // UPDATE
	sql = "UPDATE reservations "
                + "SET id = '" + r.getId() + "'"
		+ ", ticketId = " + r.getTicketID()
		+ ", flightId = " + r.getFlightID() + "'"
                + "WHERE id = " + r.getId();
        stmt.executeUpdate(sql);
      } else {
	// INSERT
	sql = "INSERT into reservations "
                + "(id, ticketId, flightId) "
		+ "VALUES (" + r.getId()
		+ ", '" + r.getTicketID() + "'"
		+ ", '" + r.getFlightID() + "')";
        stmt.executeUpdate(sql);
      }
      DBConnector.closeConnection(con);
    } catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
  }
   
         
//RETOURNEERT EEN ARRAY LIST VAN RESERVATIONS
  public static ArrayList<Reservation> getReservations() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM reservations ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Reservation> reservations = new ArrayList<Reservation>();
      while (srs.next())
        reservations.add(getReservation(srs.getInt("id")));
      
      DBConnector.closeConnection(con);
      return reservations;
      
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