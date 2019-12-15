package Database;

//IMPORTS
import Database.*;
import java.sql.*;

public class DBConnector {

//INSTANTIEVARIABELEN
    private static final String DB_NAME = "db2019_13";
    private static final String DB_PASS = "knenfndh";

//METHODE
    public static Connection getConnection() throws DBException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String protocol = "jdbc";
            String subProtocol = "mysql";
            String myDatabase = "//pdbmbook.com/" + DB_NAME;
            String URL = protocol + ":" + subProtocol + ":" + myDatabase + "?useSSL=false";

            con = DriverManager.getConnection(URL, DB_NAME, DB_PASS);
            return con;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            closeConnection(con);
            throw new DBException(sqle);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            closeConnection(con);
            throw new DBException(cnfe);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
		 if(con != null)
            	con.close();
        } catch (SQLException sqle) {
            //do nothing
        }
    }
}
