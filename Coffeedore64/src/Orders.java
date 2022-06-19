import java.util.ArrayList;

public class Orders {
    private String name;
    private boolean ready;
    private ArrayList<Items> items = new ArrayList<Items>();

    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Orders() {
        this.name = "Guest";
        this.ready = false;
    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Orders(String name) {
        this.name = name;
        this.ready = false;
    }


    // ORDER METHODS
    public void addItem(Items item) {
        this.items.add(item);
    }

    public String getStatusMessage() {
        if (this.ready == true) {
            return "Your order is ready";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double total = 0.0;
        for (Items i : this.items) {
            total = total + i.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.printf("Customer name: %s", this.name);
        for (Items i : this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.printf("Total: %s $", this.getOrderTotal());
    }


    // GETTERS & SETTERS
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Items> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
}
