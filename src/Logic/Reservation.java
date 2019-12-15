//NEW OK
package Logic;

public class Reservation {

//INSTANTIEVARIABELEN
  private int id;
  private int ticketID;
  private int flightID;

//CONSTRUCTOR

  public Reservation(int id, int ticketID, int flightID) {
        this.id = id;
        this.ticketID = ticketID;
        this.flightID = flightID;
  }

//GETTERS EN SETTERS
  public int getId() {
    return id;
  }
  
  public int getTicketID() {
    return ticketID;
  }
  
  public int getFlightID() {
    return flightID;
  }
  
  public void setId(int id){
    this.id = id;
  }
  
  public void setTicketID(int ticketID){
    this.ticketID = ticketID;
  }
  
  public void setFlightID(int fligthID){
    this.flightID = flightID;
  }
}