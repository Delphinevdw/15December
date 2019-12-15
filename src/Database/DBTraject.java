//OK
package Database;

import static Database.DBFlightcode.getFlightcode;
import Logic.Flightcode;
import Logic.Traject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTraject {
     
    public static Traject getTraject(int ID) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id, origin, destination "
	+ "FROM trajects "
	+ "WHERE id = " + ID;

      ResultSet srs = stmt.executeQuery(sql);
      String origin, destination;
      int id;
      
      if (srs.next()) {
        id = srs.getInt("id");
	origin = srs.getString("origin");
	destination = srs.getString("destination");
      } 
      
      else {
	Database.DBConnector.closeConnection(con);
	return null;
      }
      
      Traject traject = new Traject(id, origin, destination);
      Database.DBConnector.closeConnection(con);
      return traject;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
    }
    }

         
//RETOURNEERT EEN ARRAY LIST VAN TRAJECTEN
  public static ArrayList<Traject> getTrajects() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM trajects ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Traject> trajects = new ArrayList<Traject>();
      while (srs.next())
        trajects.add(getTraject(srs.getInt("id")));
      
      DBConnector.closeConnection(con);
      return trajects;
      
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