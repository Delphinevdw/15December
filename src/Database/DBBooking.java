//OK
package Database;

//IMPORTS
import static Database.DBAirport.getAirport;
import Logic.Airport;
import Logic.Booking;
import Logic.Flight;
import Logic.Traveler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBBooking {

    public static Booking getBooking(int ID) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id, ticketId, travelerId "
	+ "FROM bookings "
	+ "WHERE id = " + ID;
      
      ResultSet srs = stmt.executeQuery(sql);
      int bookingreference, ticketId; 
      String travelerId; 
      
      
      if (srs.next()) {
	bookingreference = srs.getInt("id");
	ticketId = srs.getInt("ticketId");
	travelerId = srs.getString("travelerId");
      } 
      
      else {
	DBConnector.closeConnection(con);
	return null;
      }
      
      Booking booking = new Booking(bookingreference, ticketId, travelerId);
      DBConnector.closeConnection(con);
      return booking;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
        }
    }
    
    //SLAAT EEN BOOKING OP MET VAN EEN BEPAALDE TRAVELER MET EEN BEPAALD TICKETID
    public static void saveBooking(Traveler traveler, int ticketID) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement();

            String sql = "INSERT into db2019_13.bookings "
                    + "(ticketId, travelerId)"
                    + "VALUES "
                    + "('" + ticketID + "', '" + traveler.getPassportnr() + "')";
            System.out.println(sql + "Check");
            stmt.executeUpdate(sql);

            DBConnector.closeConnection(con);
        } catch (DBException | SQLException ex) {
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }
     
//RETOURNEERT EEN ARRAY LIST VAN BOOKINGS
  public static ArrayList<Booking> getBookings() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM bookings ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Booking> bookings = new ArrayList<Booking>();
      while (srs.next())
        bookings.add(getBooking(srs.getInt("id")));
      
      DBConnector.closeConnection(con);
      return bookings;
      
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