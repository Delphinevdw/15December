//NEW OK
package Logic;

public class Booking {
  
//INSTANTIEVARIABELEN
  private int bookingreference;
  private int ticketId;
  private String travelerId;

//CONSTRUCTOR
    public Booking(int bookingreference, int ticketId, String travelerId) {
        this.bookingreference = bookingreference;
        this.ticketId = ticketId;
        this.travelerId = travelerId;
    }

//GETTERS EN SETTERS
   
  public int getBookingreference() {
    return bookingreference;
  }
                  
  public int getTicketId() {
    return ticketId;
  }
                    
  public String getTravelerId() {
    return travelerId;
  }
  
  public void setBookingreference(int bookingreference) {
    this.bookingreference = bookingreference;
  }

  public void setTicketId(int ticketId) {
    this.ticketId = ticketId;
  }

  public void setTravelerId(String travelerId) {
    this.travelerId = travelerId;
  }   
}