//OK
package Database;

import Logic.Machine;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMachine {
    
public static Machine getMachine(int ID) throws Database.DBException {
    Connection con = null;
    try {
      con = Database.DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT id, type, capacity "
	+ "FROM machines "
	+ "WHERE id = " + ID;

      ResultSet srs = stmt.executeQuery(sql);
      String machineID, type; 
      int capacity;

      if (srs.next()) {
	machineID = srs.getString("id");
	type = srs.getString("type");
	capacity = srs.getInt("capacity");
      } 
      
      else {// we verwachten slechts 1 rij...
	Database.DBConnector.closeConnection(con);
	return null;
      }
      
      Machine machine = new Machine(machineID, type, capacity);
      Database.DBConnector.closeConnection(con);
      return machine;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      Database.DBConnector.closeConnection(con);
      throw new Database.DBException(ex);
    }
  }
}
