//OK
package Database;

//IMPORTS
import static Database.DBFlight.getFlight;
import Logic.Airline;
import Logic.Flight;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBAirline {
    
    public static Airline getAirline(int ID) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id, companyname, airlinecode "
	+ "FROM airlines "
	+ "WHERE id = " + ID;

      ResultSet srs = stmt.executeQuery(sql);
      String companyname, airlinecode;
      int airlineID;
      
      if (srs.next()) {
        airlineID = srs.getInt("id");
	companyname = srs.getString("companyname");
	airlinecode = srs.getString("airlinecode");
      } 
      
      else {
	Database.DBConnector.closeConnection(con);
	return null;
      }
      
      Airline airline = new Airline(airlineID, companyname, airlinecode);
      Database.DBConnector.closeConnection(con);
      return airline;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
    }
    }
    
//RETOURNEERT EEN ARRAY LIST VAN AIRLINES
  public static ArrayList<Airline> getAirlines() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM airlines ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Airline> airlines = new ArrayList<Airline>();
      while (srs.next())
        airlines.add(getAirline(srs.getInt("id")));
      
      DBConnector.closeConnection(con);
      return airlines;
      
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