package it22049.menus;

import java.util.Scanner;

public class HomeMenu {
    public static void runMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Καλώς ήρθατε στην εφαρμογή Java LastMile!");

        while (true) {
            System.out.println("Τι θα θέλατε να κάνετε;");
            System.out.println("1. Καταχώρηση παραγγελίας");
            System.out.println("2. Ενημέρωση παραγγελίας");
            System.out.println("3. Αναζήτηση πληροφοριών και Δημιουργία αναφορών");
            System.out.println("4. Έξοδος");

            String input = scanner.nextLine().trim();
            
            if (input.equals("1")) {
                OrderEntryMenu.runMenu();
                break;
            } else if (input.equals("2")) {
                OrderUpdateMenu.runMenu();
                break;
            } else if (input.equals("3")) {
                ReportMenu.runMenu();
                break;
            } else if (input.equals("4")) {
                System.out.println("Ευχαριστούμε που χρησιμοποιείτε την την εφαρμογή Java_LastMile για τις παραγγελίες σας.");
                System.exit(0);  // Exit with status code 0
                break;
            } else {
                System.out.println("Λάθος επιλογή.");
            }
        }
    }
}
