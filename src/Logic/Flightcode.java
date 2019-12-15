//NEW OK
package Logic;

public class Flightcode {

//INSTANTIEVARIABELEN
private int flightID;
private String code;
private String number;
 
//CONSTRUCTOR
    public Flightcode(int flightID, String code, String number) {
        this.flightID = flightID;
        this.code = code;
        this.number = number;
    }

//GETTERS EN SETTERS
  public int getFlightID() {
    return flightID;
  }
                  
  public String getCode() {
    return code;
  }

  public String getNumber() {
    return number;
  }
}