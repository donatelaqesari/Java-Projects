import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Items> menu = new ArrayList<>();
    private ArrayList<Orders> orders = new ArrayList<>();

    public CoffeeKiosk() {
    }

    public void addMenuItem(String name, Double price) {
        Items newItem = new Items(name, price); //create a new item object with the given name and price.
        menu.add(newItem);
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
    }

    public void displayMenu() {
        for (Items i : this.menu) {
            System.out.println(i.getIndex() + " " + i.getName() + " -- $" + i.getPrice());
        }
    }

    public void newOrder() {

        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // Your code:
        // Create a new order with the given input string
        Orders newOrder = new Orders(name);
        orders.add(newOrder);
        // Show the user the menu, so they can choose items to add.
        displayMenu();

        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        // Write a while loop to collect all user's order items
        while (!itemNumber.equals("q")) {

            // Get the item object from the menu, and add the item to the order
            int i = Integer.parseInt(itemNumber);
            if (i < this.menu.size()) {
                Items orderedItem = menu.get(i);
                newOrder.addItem(orderedItem);
            } else {
                System.out.println("There is an error!");
            }

            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Enter a new item index or press q to exit: ");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details
        // as the example below. You may use the order's display method.
        newOrder.display();
        this.orders.add(newOrder);
    }

}
