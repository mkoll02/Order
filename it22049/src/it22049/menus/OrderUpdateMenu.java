package it22049.menus;

import it22049.helpers.Validator;
import static it22049.menus.OrderEntryMenu.addDriver;
import it22049.models.Driver;
import it22049.models.Order;
import it22049.models.OrderStatus;
import it22049.stores.DriverStore;
import it22049.stores.OrderStore;
import java.util.Scanner;

public class OrderUpdateMenu {
    
     public static void runMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Τι θα θέλατε να κάνετε;");
            System.out.println("1. Αλλαγή οδηγού παραγγελίας");
            System.out.println("2. Αλλαγή διεύθυνσης παράδοης παραγγελίας");
            System.out.println("3. Αλλαγή κατάστασης παρραγελίας");
            System.out.println("4. Πίσω");

            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                changeOrderDriver();
            } else if (input.equals("2")) {
                changeOrderDeliveryAddress();
            } else if (input.equals("3")) {
                changeOrderStatus();
            } else if (input.equals("4")) {
                HomeMenu.runMenu();
                break;
            } else {
                System.out.println("Λάθος επιλογή.");
            }
        }  
        
    }
    public static void changeOrderDriver(){
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        while (true) {
            System.out.print("Παρακαλώ εισάγετε το κωδικό της παραγγελίας που θα θέλατε να αλλάξετε οδηγό: ");
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
        if (order!=null){
            String driverFullName;
            while (true) {
                System.out.print("Παρακαλώ δώστε το ονοματεπώνυμο του νέου οδηγού: ");
                driverFullName = scanner.nextLine();
                if (Validator.isValidFullName(driverFullName)) {
                    break;
                } else {
                    System.out.println("Μη έγκυρο ονοματεπώνυμο. Παρακαλώ δοκιμάστε ξανά");
                }
            }
            String[] nameParts2 = driverFullName.trim().split("\\s+");
            String driverFirstName = nameParts2[0];
            String driverLastName = nameParts2[nameParts2.length - 1];
            Driver driver = DriverStore.findDriverByFullName(driverFirstName, driverLastName);
            if (driver == null){
               driver = addDriver(driverFirstName,driverLastName);
            }
            System.out.println("Η παραγγελία ενημερώθηκε επιτυχώς!");
            order.setDriver(driver);
        }
         
    }
    public static void changeOrderDeliveryAddress(){
        Scanner scanner = new Scanner(System.in);
        boolean searchById = true;
        int id = 0;
        String fullName, deliveryAddress;
        Order order = null;
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
            while (true) {
                System.out.print("Παρακαλώ εισάγετε το κωδικό της παραγγελίας που θα θέλατε να αλλάξετε διεύθυνση παράδοσης: ");
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
            while (true) {
                System.out.print("Παρακαλώ εισάγετε το ονοματεπώνυμο πελάτη της παραγγελίας που θα θέλατε να αλλάξετε διεύθυνση παράδοσης: ");
                fullName = scanner.nextLine();
                if (Validator.isValidFullName(fullName)) {
                    break;
                } else {
                    System.out.println("Μη έγκυρο ονοματεπώνυμο. Παρακαλώ δοκιμάστε ξανά");
                }
            }
            order = OrderStore.findOrderByCustomerFullName(fullName);
        }
        // Check if an order has been found
        if (order!=null){
            // Check if where the order will be delivered at
            if(order.getDeliveryAddress() != null){
                while (true) {
                    System.out.print("Παρακαλώ εισάγετε την διέυθυνση παράδοσης: ");
                    deliveryAddress = scanner.nextLine();

                    if (Validator.isValidAddress(deliveryAddress)) {
                        break;
                    } else {
                        System.out.println("Η διεύθυνση δεν είναι έγκυρη. Παρακαλώ προσπαθήστε ξανά.");
                    }
                }
                order.setDeliveryAddress(deliveryAddress);
                System.out.println("Η παραγγελία ενημερώθηκε επιτυχώς!");
                System.out.println(order.toString());
            }else{
                System.out.println("Αυτή η παραγγελία θα παραδοθεί σε θυρίδα. Δεν μπορείτε να αλλάξετε διεύθυνση παράδοσης!");
            }
        }
         
    }
    public static void changeOrderStatus(){
        Scanner scanner = new Scanner(System.in);
        int id = 0;
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
        Order order = OrderStore.findOrderById(id);
        if(order != null){
            //Change order status
            order.setStatus(OrderStatus.COMPLETED);
            // Check if the order has been delivered in locker and make locker available again
            if (order.getDeliveryPlace() != null){
                order.getDeliveryPlace().openLocker(order.getLocker().getIndex());
                order.setLocker(null);
            }
            String showAddress;
            if(order.getDeliveryAddress() == null) showAddress = order.getDeliveryPlace().toString();
            else showAddress = order.getDeliveryAddress();
            System.out.println("Η παραγγελία ενημερώθηκε επιτυχώς!");
            System.out.println("Κωδικός παραγγελίας: " + order.getId() + ", οδηγός: " + order.getDriver() + ", διευθυνση παράδοσης: " + showAddress + " κατάσταση παραγγελίας: ΟΛΟΚΛΗΡΩΘΗΚΕ" );
        }
    }
    
}
