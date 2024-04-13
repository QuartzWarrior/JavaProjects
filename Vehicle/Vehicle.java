package Vehicle;
public class Vehicle {
    private int location;

    public Vehicle() {
        this.location = 0;
    }

    public Vehicle(int loc) {
        if (loc >= -20 && loc <= 20) {
            this.location = loc;
        } else {
            this.location = 0;
        }
    }

    public void forward() {
        if (location < 20) {
            location++;
        } else {
            location = 20;
        }
    }

    public void backward() {
        if (location > -20) {
            location--;
        } else {
            location = -20;
        }
    }

    public int getLocation() {
        return location;
    }

    public String toString() {
        String representation = "";

        for (int i = -20; i < location; i++) {
            representation += ("_,");
        }

        representation += "@";

        return representation;
    }
}
