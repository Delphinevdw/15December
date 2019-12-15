//NEW - NOG NIET OK, check datetime!! + constructor lijkt niet te kloppen?
package Logic;

//IMPORTS
import java.time.LocalDateTime;
import java.sql.Time;

public class Flight {

//INSTANTIEVARIABELEN
private int flightnumber;
private int trajectID;
private int legID;
private int co2;
private int airlineID;
private int machineID;
private Time duration; //??
private LocalDateTime departure; //??
private LocalDateTime arrival; //??
private double priceperflight;

//CONSTRUCTOR
public Flight(int flightnumber, int trajectID, int legID, Time duration, int co2, LocalDateTime departure, LocalDateTime arrival, int airlineID, int machineID, double priceperflight){
    this.flightnumber = flightnumber;
    this.trajectID = trajectID;
    this.legID = legID;
    this.machineID = machineID;
    this.airlineID = airlineID;
    this.co2 = co2;
    this.duration = duration;
    this.departure = departure;
    this.arrival = arrival;
    this.priceperflight = priceperflight;
    }

//GETTERS EN SETTERS

  public int getCo2(){
      return co2;
  }
   
  public int getFlightnumber() {
    return flightnumber;
  }
  
  public int getTrajectID() {
    return trajectID;
  }
  
  public int getLegID() {
    return legID;
  }
  
  public int getMachineID() {
    return machineID;
  }
  
  public int getAirlineID() {
    return airlineID;
  }
  
  public Time getDuration() {
    return duration;
  }
  
  public LocalDateTime getArrival() {
    return arrival;
  }
  
  public LocalDateTime getDeparture() {
    return departure;
  }  
  
  public Double getPriceperflight(){
      return priceperflight;
  }
}