//OK
package Database;

import static Database.DBAirline.getAirline;
import Logic.Airline;
import Logic.Airport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBAirport {
    
    public static Airport getAirport(String airpCode) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT airportcode, country, timezone "
	+ "FROM airports "
	+ "WHERE airportcode = " + airpCode;

      ResultSet srs = stmt.executeQuery(sql);
      String airportcode, country, timezone;

      
      if (srs.next()) {
	airportcode = srs.getString("airportcode");
	country = srs.getString("country");
        timezone = srs.getString("timezone");
      } 
      
      else {// we verwachten slechts 1 rij...
	Database.DBConnector.closeConnection(con);
	return null;
      }
      
      Airport airport = new Airport(airportcode, country, timezone);
      Database.DBConnector.closeConnection(con);
      return airport;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
    }
  }
    
//RETOURNEERT EEN ARRAY LIST VAN AIRPORTS
  public static ArrayList<Airport> getAirports() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM airports ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Airport> airports = new ArrayList<Airport>();
      while (srs.next())
        airports.add(getAirport(srs.getString("airportcode")));
      
      DBConnector.closeConnection(con);
      return airports;
      
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
