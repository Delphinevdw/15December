//NEW OK
package Logic;

public class Leg {
  
//INSTANTIEVARIABELEN
  private int id;
  private int trajectID;
  private String origin;
  private String destination;

//CONSTRUCTOR
public Leg(int id, int trajectID, String origin, String destination){
    this.id = id;
    this.trajectID = trajectID;
    this.origin = origin;
    this.destination = destination;
  }

//GETTERS EN SETTERS
  public int getId() {
    return id;
  }
                  
  public int getTrajectID() {
    return trajectID;
  }
  
  public String getOrigin(){
      return origin;
  }
  
  public String getDestination(){
      return destination;
  }  
}