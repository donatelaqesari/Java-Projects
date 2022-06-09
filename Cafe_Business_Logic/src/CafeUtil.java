import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;



public class CafeUtil{

    public int getStreakGoal(int numWeek) {
        int sum=0;
        for ( int i = 0; i <= numWeek; i++){
            sum = sum + i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i =0; i< menuItems.size(); i++){
            String myArray = menuItems.get(i); // to access an element in an ArrayList using an index
            System.out.println(i + " " + myArray);
        }
    }

    public void addCustomer(ArrayList<String> customer){
        System.out.println("Please enter your name:");
        String userName =  System.console().readLine();
        System.out.printf("Hello, %s !", userName);
        System.out.printf(" There are %s people ahead of you. ", customer.size());
        customer.add(userName);
        System.out.println(customer);

    }

    public void printPriceChart(String product, double price, int maxQuantity){
            System.out.println(product);
            // // // --- Original Task----
            for ( int i=1; i<=maxQuantity; i++){
             System.out.println(i + " - $" + i * price);
             }

            // // // --- Senpai Bonus, Sensei Bonus----
            for ( int i=1; i<=maxQuantity; i++){
                NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.US);
                String formattedString = franceFormat.format(i*price - 0.50 * (i-1));
                System.out.println(i + " -" + formattedString);
            }
        }


    public boolean displayMenu (ArrayList<String> menuItems, ArrayList<Double> prices){
        if(menuItems.size() == prices.size()){
            int i;
            for( i= 0; i <menuItems.size() && i<prices.size(); i++){
                System.out.println(i + " " + menuItems.get(i) + " -- " + " $" + prices.get(i));
            }

            return true;
        }
        else return false;
    }
}


