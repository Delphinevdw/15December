
package Database;

//IMPORTS
import static Database.DBFlight.getFlight;
import Logic.Flight;
import Logic.Flightcode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBFlightcode {
    
    public static Flightcode getFlightcode(int ID) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT flightId, code, number "
	+ "FROM flightcode "
	+ "WHERE flightId = " + ID;

      ResultSet srs = stmt.executeQuery(sql);
      String code, number;
      int flightID;
      
      if (srs.next()) {
        flightID = srs.getInt("flightId");
	code = srs.getString("code");
	number = srs.getString("number");
      } 
      
      else {
	Database.DBConnector.closeConnection(con);
	return null;
      }
      
      Flightcode flightcode = new Flightcode(flightID, code, number);
      Database.DBConnector.closeConnection(con);
      return flightcode;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
    }
    }
    
//RETOURNEERT EEN ARRAY LIST VAN FLIGHTCODES
  public static ArrayList<Flightcode> getFlightcodes() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM flightcode ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Flightcode> flightcodes = new ArrayList<Flightcode>();
      while (srs.next())
        flightcodes.add(getFlightcode(srs.getInt("id")));
      
      DBConnector.closeConnection(con);
      return flightcodes;
      
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