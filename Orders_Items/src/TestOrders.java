
public class TestOrders {
        public static void main(String[] args) {

            // Menu items
        Items item1 = new Items();
        item1.name = "mocha";
        item1.price = 3.15;

        Items item2 = new Items();
        item2.name = "latte";
        item2.price = 3.75;

        Items item3 = new Items();
        item3.name = "drip coffee";
        item3.price = 2.25;

        Items item4 = new Items();
        item4.name = "cappuccino";
        item4.price = 4.5;

        // Order variables -- order1, order2 etc.
        Orders order1 = new Orders();
        System.out.println(order1.total);
        order1.name ="Cindhuri";

        Orders order2 = new Orders();
        order2.name="Jimmy";

        Orders order3 = new Orders();
        order3.name = "Noah";

        Orders order4 = new Orders();
        order4.name = "Sam";

            // Application Simulations
                // Add the item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
        order2.total = order2.total + item1.price;

        order3.items.add(item4);
        order3.total = order3.total + item4.price;

        order4.items.add(item2);
        order4.total += item2.price;

        // Cindhuri’s order is now ready.  Update her status.
         order1.ready = true;

         // Sam ordered more drinks -- 2 lattes. Update their order as well.
         order4.items.add(item2);
         order4.items.add(item2);
         order4.total += item2.price * 2;

         // Jimmy’s order is now ready. Update his status.
         order2.ready = true;

                // Use this example code to test various orders' updates
                System.out.printf("Name: %s\n", order1.name);
                System.out.printf("Total: %s\n", order1.total);
                System.out.printf("Ready: %s\n", order1.ready);

                System.out.printf("Name: %s\n", order2.name);
                System.out.printf("Total: %s\n", order2.total);
                System.out.printf("Ready: %s\n", order2.ready);

                System.out.printf("Name: %s\n", order3.name);
                System.out.printf("Total: %s\n", order3.total);
                System.out.printf("Ready: %s\n", order3.ready);

                System.out.printf("Name: %s\n", order4.name);
                System.out.printf("Total: %s\n", order4.total);
                System.out.printf("Ready: %s\n", order4.ready);
        }


}
