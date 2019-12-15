//NEW OK
package Logic;

public class Ticket {
 
//INSTANTIEVARIABELEN
private int id, price;

//CONSTRUCTOR
    public Ticket(int id, int price) {
        this.id = id;
        this.price = price;
    }

//GETTERS EN SETTERS
    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }    
}