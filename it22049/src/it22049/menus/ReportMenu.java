package it22049.menus;

import it22049.helpers.Validator;
import it22049.models.Order;
import it22049.models.OrderRating;
import it22049.models.OrderStatus;
import it22049.stores.OrderRatingStore;
import it22049.stores.OrderStore;
import java.util.Scanner;

public class ReportMenu {
    
    // main menu to let user select what he wants to do
    public static void runMenu(){
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Τι θα θέλατε να κάνετε;");
            System.out.println("1. Καταχώρηση αξιολόγησης");
            System.out.println("2. Προβολή παραγγελίας");
            System.out.println("3. Προβολή αναφοράς διαχειριστή");
            System.out.println("4. Πίσω");

            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                addRating();
            } else if (input.equals("2")) {
                viewOrder();
            } else if (input.equals("3")) {
                viewReports();
            } else if (input.equals("4")) {
                HomeMenu.runMenu();
                break;
            } else {
                System.out.println("Λάθος επιλογή.");
            }
        }
    }
    public static void addRating(){
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        while (true) {
            System.out.print("Παρακαλώ εισάγετε το κωδικό της παραγγελίας την οποία θα θέλατε να αξιολογήσετε: ");
            String input = scanner.nextLine(); // Read input as a string
            try {
                id = Integer.parseInt(input); // Try to parse the input as an integer
                break;
            } catch (NumberFormatException e) {
                // If parsing fails, inform the user and prompt for input again
                System.out.println("Λάθος εισαγωγή. Παρακαλώ προσπαθήστε ξανά!");
            }
        }
        Order order = OrderStore.findOrderById(id);
        int rating = 0;
        // Check if we found any order object
        if(order != null){
            // Check order status and inform user that he can't make a review for order that has pending status
            if (order.getStatus().equals(OrderStatus.PENDING)) {
                System.out.println("Δεν μπορείτε να κάνετε αξιολόγηση σε παραγγελία που εκκρεμεί!");
                return;
            }
            // Add rating number
            while (true) {
                System.out.print("Παρακαλώ εισάγετε την βαθμολογία (1-10) της αξιολόγησης: ");
                String input = scanner.nextLine(); // Read input as a string
                try {
                    rating = Integer.parseInt(input); // Try to parse the input as an integer
                    if (rating >= 1 && rating <= 10) {
                        break;
                    } else {
                        System.out.println("Λάθος αριθμός. Η βαθμολογία πρέπει να είναι ανάμεσα στο 1 και 10!");
                    }
                } catch (NumberFormatException e) {
                    // If parsing fails, inform the user and prompt for input again
                    System.out.println("Λάθος εισαγωγή. Παρακαλώ προσπαθήστε ξανά!");
                }
            } 
            // Create new Rating object
            OrderRating orderRating =  new OrderRating(order,rating);
            // Add the rating object to our static list
            OrderRatingStore.ratings.add(orderRating);
            System.out.println("Η αξιολόγηση καταχωρήθηκε επιτυχώς!");
        }
        
    }
    public static void viewOrder(){
        Scanner scanner = new Scanner(System.in);
        boolean searchById = true;
        int id = 0;
        String fullName;
        Order order = null;
        // ask user with what keyword he wants to search
        while (true) {
            System.out.println("Με τι θα θέλατε να κάνετε αναζήτηση παραγγελίας;");
            System.out.println("1. Ονοματεπώνυμο πελάτη");
            System.out.println("2. Κωδικό παραγγελίας");

            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                searchById = false;
                break;
            } else if (input.equals("2")) {
                searchById = true;
                break;
            } else {
                System.out.println("Λάθος επιλογή.");
            }
        }
        
        if (searchById){
            // Ask user to give the order code
            while (true) {
                System.out.print("Παρακαλώ εισάγετε το κωδικό της παραγγελίας: ");
                String input = scanner.nextLine(); // Read input as a string
                try {
                    id = Integer.parseInt(input); // Try to parse the input as an integer
                    break;
                } catch (NumberFormatException e) {
                    // If parsing fails, inform the user and prompt for input again
                    System.out.println("Λάθος εισαγωγή. Παρακαλώ προσπαθήστε ξανά!");
                }
            }
            order = OrderStore.findOrderById(id);
        }else{
            // Ask user to give the customer full name
            while (true) {
                System.out.print("Παρακαλώ εισάγετε το ονοματεπώνυμο πελάτη της παραγγελίας: ");
                fullName = scanner.nextLine();
                if (Validator.isValidFullName(fullName)) {
                    break;
                } else {
                    System.out.println("Μη έγκυρο ονοματεπώνυμο. Παρακαλώ δοκιμάστε ξανά");
                }
            }
            order = OrderStore.findOrderByCustomerFullName(fullName);
        }
        // Show order to user if it is exists
        if(order != null) System.out.println(order.toString());
    }
    public static void viewReports(){
        System.out.println("Πλήθος παραγγελιών: " + OrderStore.orders.size());
        System.out.println("Συνολική ποσότητα ανά κατηγορία:" );
        OrderStore.getSumProductInOrderQuantity();
        System.out.println("Πλήθος παραγγελιών ανά οδηγό:" );
        OrderStore.getOrdersNumberByDriver();
        OrderStore.getOrdersNumberByAddressDeliveryChoice();
        OrderRatingStore.getAverageRatingNumber();
        OrderRatingStore.getMInMaxRatingNumber();
    }
    
}
