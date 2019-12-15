//NEW OK
package Logic;

public class Machine {
    
    private String id, type;
    private int capacity;

    public Machine(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}