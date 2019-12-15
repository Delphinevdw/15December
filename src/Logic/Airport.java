//NEW OK
package Logic;

public class Airport {
  
//INSTANTIEVARIABELEN
  private String airportcode;
  private String country;
  private String timezone;

//CONSTRUCTOR
    public Airport(String airportcode, String country, String timezone) {
        this.airportcode = airportcode;
        this.country  = country;
        this.timezone = timezone;
    }

//GETTERS EN SETTERS
  public String getAirportCode() {
    return airportcode;
  }
                  
  public String getCountry() {
    return country;
  }
    
    public String getTimezone() {
    return timezone;
  }   
}