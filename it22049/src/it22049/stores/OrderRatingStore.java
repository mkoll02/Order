package it22049.stores;

import it22049.models.OrderRating;
import java.util.ArrayList;
import java.util.List;

public class OrderRatingStore {
    //List to keep our data
    public static List<OrderRating> ratings = new ArrayList<>();

    //Method to get the average rating number
    public static void getAverageRatingNumber(){
        int sum = 0;
        for (OrderRating rating : ratings) {
            sum += rating.getRating();
        }

        System.out.println("Η μέση αξιολόγηση της υπηρεσίας διανομής είναι: " + (double) sum / ratings.size());
    }
    
    //Method to get the min and max rating number
    public static void getMInMaxRatingNumber(){
        int min = 10;
        String min_fullname = "";
        int max = 0;
        String max_fullname = "";
        for (OrderRating rating : ratings) {
            if (rating.getRating()>max){
                max = rating.getRating();
                max_fullname = rating.getOrder().getCustomer().getFirstName() + " " + rating.getOrder().getCustomer().getLastName();
            }
            if(rating.getRating()< min){
                min = rating.getRating();
                min_fullname = rating.getOrder().getCustomer().getFirstName() + " " + rating.getOrder().getCustomer().getLastName();
            }
        }

        System.out.println("Η μικρότερη αξιολόγηση της υπηρεσίας διανομής είναι: " + min + " από τον: " + min_fullname);
        System.out.println("Η μεγαλύτερη αξιολόγηση της υπηρεσίας διανομής είναι: " + max + " από τον: " + max_fullname);

    }
}
