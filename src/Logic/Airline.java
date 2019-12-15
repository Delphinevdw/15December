//NEW OK
package Logic;

public class Airline {
  
//INSTANTIEVARIABELEN
  private String companyname;
  private int airlineID;
  private String airlinecode;

//CONSTRUCTOR
    public Airline(int airlineID, String companyname, String airlinecode) {
        this.airlineID = airlineID;
        this.companyname = airlinecode;
        this.airlinecode = airlinecode;
    }

//GETTERS EN SETTERS
  public String getAirlinecode() {
    return airlinecode;
  }
                  
  public String getCompanyName() {
    return companyname;
  }

  public int getAirlineId() {
    return airlineID;
  } 
}