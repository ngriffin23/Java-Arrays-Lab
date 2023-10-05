import java.util.Random;

public class ItalianRestaurant {
    public static void main(String[] args) {
        // Italian menu items and prices for appetizers, entrees, and desserts
        String[] appetizers = {
                "Bruschetta", "Caprese Salad", "Garlic Bread", "Mozzarella Sticks", "Stuffed Mushrooms"
        };

        double[] appetizerPrices = { 7.99, 9.99, 5.99, 6.99, 8.49 };

        String[] entrees = {
                "Spaghetti Carbonara", "Lasagna", "Fettuccine Alfredo", "Chicken Marsala", "Osso Buco"
        };

        double[] entreePrices = { 14.99, 16.99, 15.99, 17.99, 22.99 };

        String[] desserts = {
                "Tiramisu", "Cannoli", "Gelato", "Chocolate Lava Cake", "Panna Cotta"
        };

        double[] dessertPrices = { 6.99, 4.99, 5.49, 6.99, 7.49 };

        // Drive-through worker's script
        String script = "Benvenuti! Welcome to our Italian restaurant!\n";
        script += "Here's our Italian menu:\n";

        script += "Appetizers:\n";
        for (int i = 0; i < appetizers.length; i++) {
            script += (i + 1) + ". " + appetizers[i] + " - $" + appetizerPrices[i] + "\n";
        }

        script += "Entrees:\n";
        for (int i = 0; i < entrees.length; i++) {
            script += (i + 1) + ". " + entrees[i] + " - $" + entreePrices[i] + "\n";
        }

        script += "Desserts:\n";
        for (int i = 0; i < desserts.length; i++) {
            script += (i + 1) + ". " + desserts[i] + " - $" + dessertPrices[i] + "\n";
        }

        script += "Please place your order by stating the item number.";

        // Display the script for the drive-through worker
        System.out.println("Drive-Through Worker's Script:");
        System.out.println("-------------------------------");
        System.out.println(script);

        // Initialize order arrays and total sales
        String[] orders = new String[20];
        double totalSales = 0;

        // Simulate 20 orders
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomIndex = random.nextInt(appetizers.length + entrees.length + desserts.length);
            String item;
            double price;

            if (randomIndex < appetizers.length) {
                item = appetizers[randomIndex];
                price = appetizerPrices[randomIndex];
            } else if (randomIndex < appetizers.length + entrees.length) {
                int index = randomIndex - appetizers.length;
                item = entrees[index];
                price = entreePrices[index];
            } else {
                int index = randomIndex - appetizers.length - entrees.length;
                item = desserts[index];
                price = dessertPrices[index];
            }

            orders[i] = item;
            totalSales += price;
        }

        // Calculate the percentage of sales for each item
        int[] itemCounts = new int[appetizers.length + entrees.length + desserts.length];
        for (String order : orders) {
            int index = -1;
            for (int i = 0; i < appetizers.length + entrees.length + desserts.length; i++) {
                if (order.equals(appetizers[i]) || order.equals(entrees[i]) || order.equals(desserts[i])) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                itemCounts[index]++;
            }
        }

        // Print the summary
        System.out.println("\nDrive-Through Orders Summary:");
        System.out.println("-------------------------------");
        System.out.printf("Total money made: $%.2f%n", totalSales);
        System.out.println("Percentage of sales for each item:");
        for (int i = 0; i < appetizers.length + entrees.length + desserts.length; i++) {
            double percentage = (double) itemCounts[i] / 20 * 100;
            String item;
            double price;

            if (i < appetizers.length) {
                item = appetizers[i];
                price = appetizerPrices[i];
            } else if (i < appetizers.length + entrees.length) {
                int index = i - appetizers.length;
                item = entrees[index];
                price = entreePrices[index];
            } else {
                int index = i - appetizers.length - entrees.length;
                item = desserts[index];
                price = dessertPrices[index];
            }

            System.out.printf("%s - $%.2f: %.2f%% (%d orders)%n", item, price, percentage, itemCounts[i]);
        }
    }
}
