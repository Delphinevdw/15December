//OK
package Database;

//IMPORTS
import static Database.DBFlightcode.getFlightcode;
import Logic.Flightcode;
import Logic.Traveler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;


//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBTraveler {
  
    public static Traveler getTraveler(String pasNum) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT passport, firstname, lastname, gender, nationality, email, dateofbirth "
	+ "FROM travelers "
	+ "WHERE passport = " + pasNum;

      ResultSet srs = stmt.executeQuery(sql);
      String passportnr, nationality, lastname, firstname, gender, email;
      Date dateofbirth;
      
      if (srs.next()) {
	passportnr = srs.getString("passport");
	nationality = srs.getString("nationality");
	lastname = srs.getString("lastname");
	firstname = srs.getString("fistname");
	dateofbirth = srs.getDate("dateofbirth");
        gender = srs.getString("gender");
        email = srs.getString("email");
      } 
      
      else {
	DBConnector.closeConnection(con);
	return null;
      }
      
      Traveler traveler = new Traveler(passportnr, firstname, lastname, gender, nationality, email, dateofbirth);
      DBConnector.closeConnection(con);
      return traveler;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }
  
    //METHODE MET 2 DELEN: update een traveller en maak een nieuwe traveler aan
    public static void save(Traveler t) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT passport "
              + "FROM travelers "
              + "WHERE passport = " + t.getPassportnr();
      ResultSet srs = stmt.executeQuery(sql);
      
      // UPDATE
      if (srs.next()) {
	sql = "UPDATE travelers "
                + "SET nationality = '" + t.getNationality() + "'"
		+ ", lastname = " + t.getLastname()
		+ ", fistname = " + t.getFirstname()
                + ", gender = " + t.getGender()
		+ ", dateofbirth = " + t.getDateofbirth()
		+ ", email = '" + t.getEmail() + "'"
                + "WHERE passport = " + t.getPassportnr();
        stmt.executeUpdate(sql);
      } 
      
      // INSERT
      else {
	sql = "INSERT into travelers "
                + "(passportnr, firstname, lastname, gender, nationality, email, dateofbirth) "
		+ "VALUES (" + t.getPassportnr()
		+ ", '" + t.getNationality() + "'"
		+ ", " + t.getLastname()
                + ", " + t.getFirstname()
                + ", " + t.getDateofbirth()
                + ", " + t.getGender()
		+ ", '" + t.getEmail() + "')";
        stmt.executeUpdate(sql);
      }
      
      DBConnector.closeConnection(con);
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }
    
    //VERWIJDERT EEN TRAVELER UIT DE DATABASE
    public static void deleteTraveler(int passNum) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "delete from db2019_13.travelers where passport = " + passNum;
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }
        
  //RETOURNEERT EEN ARRAY LIST VAN TRAVELERS
  public static ArrayList<Traveler> getTravelers() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT * "
              + "FROM travelers ";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Traveler> travelers = new ArrayList<Traveler>();
      while (srs.next())
        travelers.add(getTraveler(srs.getString("passport")));
      
      DBConnector.closeConnection(con);
      return travelers;
      
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