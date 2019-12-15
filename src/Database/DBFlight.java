//NEW: Nog niet juist, check import datetime en de getter ervan
package Database;
    
//IMPORTS
import static Database.DBBooking.getBooking;
import Logic.Booking;
import Logic.CreateBooking;
import Logic.Flight;
import Logic.InfoTraject;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBFlight {

//METHODES
//Tabellen zijn al aangemaakt in MySQL
    
    public static Flight getFlight(int ID) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id, trajectId, legId, duration, co2, departure, arrival, airlineId, machineId, priceperflight "
	+ "FROM flights "
	+ "WHERE id = " + ID;

      ResultSet srs = stmt.executeQuery(sql);
      int flightnumber, trajectID, legID, co2, airlineID, machineID;
      double priceperflight;
      Time duration; //??
      LocalDateTime departure, arrival; //??
      
      if (srs.next()) {
        flightnumber = srs.getInt("id");
        trajectID = srs.getInt("trajectId");
        legID = srs.getInt("legId");
        duration = srs.getTime("duration");
        co2 = srs.getInt("co2");
        //departure = srs.getLocalDateTime("departure"); // YYYY-MM-DD HH:MM:SS
        //arrival = srs.getLocalDateTime("arrival"); //?
        airlineID = srs.getInt("airlineId");
        machineID = srs.getInt("machineId");
        priceperflight = srs.getDouble("priceperflight");
        
        Date arrDate = srs.getDate("arrival");
        Timestamp arrTimestamp = new Timestamp(arrDate.getTime());
        arrival = arrTimestamp.toLocalDateTime();
        
        Date depDate = srs.getDate("departure");
        Timestamp depTimestamp = new Timestamp(arrDate.getTime());
        departure = depTimestamp.toLocalDateTime();
        
      } 
      
      else {
	Database.DBConnector.closeConnection(con);
	return null;
      }
      
      Flight flight = new Flight(flightnumber, trajectID, legID, duration, co2, departure, arrival, airlineID, machineID, priceperflight);
      Database.DBConnector.closeConnection(con);
      return flight;
    }    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
    }
    }

    
 //RETOURNEERT EEN ARRAY LIST VAN FLIGHTS
  public static ArrayList<Flight> getFlights() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM flights ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Flight> flights = new ArrayList<Flight>();
      while (srs.next())
        flights.add(getFlight(srs.getInt("id")));
      
      DBConnector.closeConnection(con);
      return flights;
      
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