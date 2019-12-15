//NEW OK
package Logic;

public class Traject {
 
//INSTANTIEVARIABELEN
private int id;
private String origin;
private String destination;

//CONSTRUCTOR
public Traject(int id, String origin, String destination) {
    this.id = id;
    this.origin = origin;
    this.destination = destination;
}

//GETTERS EN SETTERS
   
  public int getId() {
    return id;
  }
                  
  public String getOrigin() {
    return origin;
  }
                    
  public String getDestination() {
    return destination;
  }      
}