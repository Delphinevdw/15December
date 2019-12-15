//OK
package Database;

//IMPORTS
import static Database.DBFlightcode.getFlightcode;
import Logic.Flightcode;
import Logic.Leg;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBLeg {
    
    public static Leg getLeg(int ID) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id, trajectId, origin, destination "
	+ "FROM legs "
	+ "WHERE id = " + ID;

      ResultSet srs = stmt.executeQuery(sql);
      String origin, destination;
      int id, trajectID;
      
      if (srs.next()) {
        id = srs.getInt("id");
	trajectID = srs.getInt("trajectId");
	origin = srs.getString("origin");
        destination = srs.getString("destination");
      } 
      
      else {
	Database.DBConnector.closeConnection(con);
	return null;
      }
      
      Leg leg = new Leg(id, trajectID, origin, destination);
      Database.DBConnector.closeConnection(con);
      return leg;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
    }
    }
         
//RETOURNEERT EEN ARRAY LIST VAN LEGS
  public static ArrayList<Leg> getLegs() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM legs ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Leg> legs = new ArrayList<Leg>();
      while (srs.next())
        legs.add(getLeg(srs.getInt("id")));
      
      DBConnector.closeConnection(con);
      return legs;
      
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