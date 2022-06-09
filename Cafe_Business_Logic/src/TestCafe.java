import java.util.ArrayList;
//import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {

    /*
      You will need add 1 line to this file to create an instance
      of the CafeUtil class.
      Hint: it will need to correspond with the variable name used below..
    */

        CafeUtil appTest = new CafeUtil();

        /* ============ App Test Cases ============= */

        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(10));

        System.out.println("\n----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));

        System.out.println("\n----- Display Menu Test-----");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // // // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println(" ");
        }

        System.out.println("\n----- Ninja Bonus----");

        appTest.printPriceChart("Columbian Coffee Grounds", 2.00, 4);

        System.out.println("\n----- Display Menu Test-----");
        ArrayList<String> menu1 = new ArrayList<String>();
        menu1.add("drip coffee");
        menu1.add("cappuccino");
        menu1.add("latte");
        menu1.add("mocha");
        ArrayList<Double> price = new ArrayList<Double>();
        price.add(1.50);
        price.add(3.50);
        price.add(4.50);
        price.add(3.50);
        appTest.displayMenu(menu1, price);
    }}