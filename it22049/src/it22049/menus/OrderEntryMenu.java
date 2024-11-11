package it22049.menus;

import it22049.models.Customer;
import it22049.models.Driver;
import it22049.models.DeliveryPlace;
import it22049.models.Product;
import it22049.models.ProductCategory;

import it22049.helpers.Validator;
import it22049.models.Locker;
import it22049.models.Order;
import it22049.models.ProductInOrder;
import it22049.stores.CustomerStore;
import it22049.stores.DeliveryPlaceStore;
import it22049.stores.DriverStore;
import it22049.stores.OrderStore;
import it22049.stores.ProductStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderEntryMenu {
    public static void runMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Τι θα θέλατε να κάνετε;");
            System.out.println("1. Καταχώρηση οδηγού");
            System.out.println("2. Καταχώρηση προιόντος");
            System.out.println("3. Καταχώρηση χώρου με lockers");
            System.out.println("4. Καταχώρηση νέας παραγγελίας");
            System.out.println("5. Πίσω");

            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                addDriver(null,null);
            } else if (input.equals("2")) {
                addProduct();
            } else if (input.equals("3")) {
                addDeliveryPlace();
            } else if (input.equals("4")) {
                addOrder();
            } else if (input.equals("5")) {
                HomeMenu.runMenu();
                break;
            } else {
                System.out.println("Λάθος επιλογή.");
            }
        }
    }
    
    public static Driver addDriver(String firstName,String lastName){
        Scanner scanner = new Scanner(System.in);
        String email,address,vat,carLicenseΝumber;
        Boolean lockersDelivery = false;
        if(firstName == null){
            while (true) {
            System.out.print("Παρακαλώ εισάγετε το όνομα του οδηγόυ: ");
            firstName = scanner.nextLine();

            if (Validator.isAlphabetic(firstName)) {
                break;
            } else {
                System.out.println("Το όνομα δεν είναι έγκυρο. Απαιτούνται μόνο γράμματα.");
            }
        }
        }
        if(lastName == null){
            while (true) {
                System.out.print("Παρακαλώ εισάγετε το επίθετο του οδηγού: ");
                lastName = scanner.nextLine();

                if (Validator.isAlphabetic(lastName)) {
                    break;
                } else {
                    System.out.println("Το επίθετο δεν είναι έγκυρο. Απαιτούνται μόνο γράμματα.");
                }
            }
        }
        while (true) {
            System.out.print("Παρακαλώ εισάγετε email για τον οδηγό: ");
            email = scanner.nextLine();

            if (Validator.isValidEmail(email)) {
                break;
            } else {
                System.out.println("Το email δεν είναι έγκυρο. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        while (true) {
            System.out.print("Παρακαλώ εισάγετε την διέυθυνση του οδηγού: ");
            address = scanner.nextLine();

            if (Validator.isValidAddress(address)) {
                break;
            } else {
                System.out.println("Η διεύθυνση δεν είναι έγκυρη. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        while (true) {
            System.out.print("Παρακαλώ εισάγετε το ΑΦΜ του οδηγού: ");
            vat = scanner.nextLine();

            if (Validator.isValidVatNumber(vat)) {
                break;
            } else {
                System.out.println("Το ΑΦΜ δεν είναι έγκυρο. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        while (true) {
            System.out.print("Παρακαλώ εισάγετε τον αριθμό πινακίδας οχημάτος του οδηγού(Πρέπει να εχει την μορφη XXX-0, XXX-00, XXX-000: ");
            carLicenseΝumber = scanner.nextLine();

            if (Validator.isValidCarLicense(carLicenseΝumber)) {
                break;
            } else {
                System.out.println("Δεν είναι έγκυρο. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        while (true) {
            System.out.println("Ο οδηγός μπορεί να παραδώσει σε θυρίδα; (1 για ΝΑΙ, 2 για OXI): ");
            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                lockersDelivery = true;
                break;
            } else if (input.equals("2")) {
                lockersDelivery = false;
                break;
            } else {
                System.out.println("Λάθος επιλογή. Παρακαλώ πατήστε '1' για ΝΑΙ ή '2' για ΟΧΙ.");
            }
        }
        Driver driver = new Driver(firstName,lastName,address,email,vat,carLicenseΝumber,lockersDelivery);
        DriverStore.drivers.add(driver);
        System.out.println("Ο οδηγός καταχωρήθηκε επιτυχώς!");
        System.out.println(driver.toString());

        return driver;
    }
    public static void addProduct(){
        Scanner scanner = new Scanner(System.in);
        String name,brandName;
        ProductCategory category;
        while (true) {
            System.out.print("Παρακαλώ εισάγετε το όνομα του προιόντος: ");
            name = scanner.nextLine();
            if (Validator.isAlphabetic(name)) {
                break;
            } else {
                System.out.println("To όνομα δεν πρέπει να περιέχει αριθμούς και σύμβολα. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        while (true) {
            System.out.println("Παρακαλώ επιλέξτε την κατηγορία του προιόντος;");
            System.out.println("1. Τροφιμο");
            System.out.println("2. Απορρυπαντικο");
            System.out.println("3. Ειδος υγιεινης");
            System.out.println("4. Ποτο");

            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                category = ProductCategory.FOOD;
                break;
            } else if (input.equals("2")) {
                category = ProductCategory.DETERGENT;
                break;
            } else if (input.equals("3")) {
                category = ProductCategory.HYGIENE_PRODUCT;
                break;
            } else if (input.equals("4")) {
                category = ProductCategory.BEVERAGE;
                break;
            } else {
                System.out.println("Λάθος επιλογή.");
            }
        }
        while (true) {
            System.out.print("Παρακαλώ εισάγετε το brand όνομα του προιόντος: ");
            brandName = scanner.nextLine();
            if (Validator.isAlphabetic(brandName)) {
                break;
            } else {
                System.out.println("To brand όνομα δεν πρέπει να περιέχει αριθμούς και σύμβολα. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        Product product = new Product(name,category,brandName);
        ProductStore.products.add(product);
        System.out.println("To προιον καταχωρήθηκε επιτυχώς!");
        System.out.println(product.toString());
        runMenu();
    }
    public static void addDeliveryPlace(){
        Scanner scanner = new Scanner(System.in);
        String address;
        int lockersNumber= 0;

        while (true) {
            System.out.print("Παρακαλώ εισάγετε την διέυθυνση του χώρου με θυρίδες: ");
            address = scanner.nextLine();
            if (Validator.isValidAddress(address)) {
                break;
            } else {
                System.out.println("Η διεύθυνση δεν είναι έγκυρη. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        // Loop until a valid integer is entered
        while (true) {
            System.out.print("Παρακαλώ εισάγετε πόσες θυρίδες υπάρχουν: ");
            String input = scanner.nextLine(); // Read input as a string

             try {
                lockersNumber = Integer.parseInt(input); // Try to parse the input as an integer
                break;
            } catch (NumberFormatException e) {
                // If parsing fails, inform the user and prompt for input again
                System.out.println("Λάθος εισαγωγή. Παρακαλώ δώστε μόνο τον αριθμό των lockers");
            }
        }
        DeliveryPlace deliveryPlace = new DeliveryPlace(address);
        deliveryPlace.addEmptyLockers(lockersNumber);
        DeliveryPlaceStore.delivryPlaces.add(deliveryPlace);
        System.out.println("Ο χώρος με θυρίδες καταχωρήθηκε επιτυχώς!");
        System.out.println(deliveryPlace.toString());
        runMenu();
    }
    
    public static Customer addCustomer(String firstName,String lastName){
        Scanner scanner = new Scanner(System.in);
        String email,address;
        if (firstName == null){
            while (true) {
                System.out.print("Παρακαλώ εισάγετε το όνομα του πελάτη: ");
                firstName = scanner.nextLine();

                if (Validator.isAlphabetic(firstName)) {
                    break;
                } else {
                    System.out.println("Το όνομα δεν είναι έγκυρο. Απαιτούνται μόνο γράμματα.");
                }
            }
        }
        if (lastName == null){
            while (true) {
                System.out.print("Παρακαλώ εισάγετε το επίθετο του πελάτη: ");
                lastName = scanner.nextLine();

                if (Validator.isAlphabetic(lastName)) {
                    break;
                } else {
                    System.out.println("Το επίθετο δεν είναι έγκυρο. Απαιτούνται μόνο γράμματα.");
                }
            }
        }
        while (true) {
            System.out.print("Παρακαλώ εισάγετε email του πελάτη: ");
            email = scanner.nextLine();

            if (Validator.isValidEmail(email)) {
                break;
            } else {
                System.out.println("Το email δεν είναι έγκυρο. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        while (true) {
            System.out.print("Παρακαλώ εισάγετε την διέυθυνση του πελάτη: ");
            address = scanner.nextLine();

            if (Validator.isValidAddress(address)) {
                break;
            } else {
                System.out.println("Η διεύθυνση δεν είναι έγκυρη. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        Customer customer = new Customer(firstName,lastName,address,email);
        CustomerStore.customers.add(customer);
        return customer;
    }
    public static void addOrder(){
        //scanner
        Scanner scanner = new Scanner(System.in);
        // empty products list
        List<ProductInOrder> products = new ArrayList<>();
        
        Customer customer = null;
        Driver driver = null;
        DeliveryPlace deliveryPlace = null;
        Locker locker = null;
        // inputs
        String barcode,customerFirstName,customerLastName,driverFirstName,driverLastName;
        String deliveryAddress = null;
        //list products
        System.out.print("Παρακαλώ επιλέξτε κάποιο από τα παρακάτω προιόντα:\n");
        ProductStore.listProducts();
        
        //get product 1
        Product product1 = null;
        int quantity1 = 0;
        while (product1 == null) {
            System.out.print("Παρακαλώ εισάγετε το barcode του προιόντος της παραγγελίας: ");
            barcode = scanner.nextLine();
            product1 = ProductStore.findProductByBarcode(barcode);
            if (product1 != null) {
                break;
            } else {
                System.out.println("Δεν υπάρχει προιόν με αυτό το barcode. Παρακαλώ προσπαθήστε ξανά.");
            }
        }
        // get quantity of product1
        // Loop until a valid integer is entered
        while (true) {
            System.out.print("Παρακαλώ εισάγετε ποσότητα: ");
            String input = scanner.nextLine(); // Read input as a string
            try {
                quantity1 = Integer.parseInt(input); // Try to parse the input as an integer
                break;
            } catch (NumberFormatException e) {
                // If parsing fails, inform the user and prompt for input again
                System.out.println("Λάθος εισαγωγή. Παρακαλώ δώστε μόνο τον αριθμό των lockers");
            }
        }
        products.add(new ProductInOrder(product1,quantity1));
        boolean manyProducts = false;
        while (true) {
            System.out.println("θα θέλατε να καταχωρήσετε κι άλλο προιόν στην παραγγελία; (1 για ΝΑΙ, 2 για OXI): ");
            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                manyProducts = true;
                break;
            } else if (input.equals("2")) {
                manyProducts = false;
                break;
            } else {
                System.out.println("Λάθος επιλογή. Παρακαλώ πατήστε '1' για ΝΑΙ ή '2' για ΟΧΙ.");
            }
        }
        
        if (manyProducts){
            //get product 1
            Product product2 = null;
            int quantity2 = 0;
            while (product2 == null) {
                System.out.print("Παρακαλώ εισάγετε το barcode του προιόντος της παραγγελίας: ");
                barcode = scanner.nextLine();
                product2 = ProductStore.findProductByBarcode(barcode);
                if (product2 != null) {
                    break;
                } else {
                    System.out.println("Δεν υπάρχει προιόν με αυτό το barcode. Παρακαλώ προσπαθήστε ξανά.");
                }
            }
            // get quantity of product1
            // Loop until a valid integer is entered
            while (true) {
                System.out.print("Παρακαλώ εισάγετε ποσότητα: ");
                String input = scanner.nextLine(); // Read input as a string
                try {
                    quantity2 = Integer.parseInt(input); // Try to parse the input as an integer
                    break;
                } catch (NumberFormatException e) {
                    // If parsing fails, inform the user and prompt for input again
                    System.out.println("Λάθος εισαγωγή. Παρακαλώ δώστε μόνο τον αριθμό των lockers");
                }
            }
            products.add(new ProductInOrder(product2,quantity2));
        }
        boolean orderInLocker = false;
        while (true) {
            System.out.println("θα θέλατε η παράδοση να γίνει σε θυρίδα; (1 για ΝΑΙ, 2 για OXI): ");
            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                orderInLocker = true;
                break;
            } else if (input.equals("2")) {
                orderInLocker = false;
                break;
            } else {
                System.out.println("Λάθος επιλογή. Παρακαλώ πατήστε '1' για ΝΑΙ ή '2' για ΟΧΙ.");
            }
        }
        if (orderInLocker){
            deliveryPlace = DeliveryPlaceStore.findEmptyDeliveryPlace();
            if (deliveryPlace == null) runMenu();
            locker = DeliveryPlaceStore.findEmptyLocker(deliveryPlace);
        }else{
            while (true) {
                System.out.print("Παρακαλώ εισάγετε την διέυθυνση παράδοσης: ");
                deliveryAddress = scanner.nextLine();

                if (Validator.isValidAddress(deliveryAddress)) {
                    break;
                } else {
                    System.out.println("Η διεύθυνση δεν είναι έγκυρη. Παρακαλώ προσπαθήστε ξανά.");
                }
            }
            
        }
        String customerFullName;
        while (true) {
            System.out.print("Παρακαλώ δώστε το ονοματεπώνυμο του Πελάτη: ");
            customerFullName = scanner.nextLine();
            if (Validator.isValidFullName(customerFullName)) {
                break;
            } else {
                System.out.println("Μη έγκυρο ονοματεπώνυμο. Παρακαλώ δοκιμάστε ξανά");
            }
        }
        String[] nameParts = customerFullName.trim().split("\\s+");
        customerFirstName = nameParts[0];
        customerLastName = nameParts[nameParts.length - 1];
        customer = CustomerStore.findCustomerByFullName(customerFirstName, customerLastName);
        if (customer == null){
           customer = addCustomer(customerFirstName,customerLastName);
        }
        String driverFullName;
        while (true) {
            System.out.print("Παρακαλώ δώστε το ονοματεπώνυμο του οδηγού: ");
            driverFullName = scanner.nextLine();
            if (Validator.isValidFullName(driverFullName)) {
                break;
            } else {
                System.out.println("Μη έγκυρο ονοματεπώνυμο. Παρακαλώ δοκιμάστε ξανά");
            }
        }
        String[] nameParts2 = driverFullName.trim().split("\\s+");
        driverFirstName = nameParts2[0];
        driverLastName = nameParts2[nameParts2.length - 1];
        driver = DriverStore.findDriverByFullName(driverFirstName, driverLastName);
        if (driver == null){
           driver = addDriver(driverFirstName,driverLastName);
        }
        
        Order order = new Order(customer,driver,products,deliveryAddress,deliveryPlace,locker);
        OrderStore.orders.add(order);
        if (locker != null && deliveryPlace != null){
            deliveryPlace.closeLocker(locker.getIndex());
        }
        System.out.println("H παραγγελία καταχωρήθηκε επιτυχώς!");
        System.out.println(order.toString());
        runMenu();
    }
}
