package it22049.stores;

import it22049.models.Driver;
import it22049.models.Order;
import it22049.models.ProductInOrder;
import java.util.ArrayList;
import java.util.List;

public class OrderStore {
    
    //List to keep our data
    public static List<Order> orders = new ArrayList<>();
       
    // Method to list our objects
    public static Order findOrderById(int id){
        for (Order order : orders){
            if(order.getId() == id){
                return order;
            }
            
        }
        System.out.println("Δεν βρέθηκε παραγγελία με αυτό τον κωδικό");
        return null;
    }
    
    // Method to find an object
    public static Order findOrderByCustomerFullName(String fullName){
        String[] nameParts = fullName.trim().split("\\s+");
        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];
        for (Order order : orders){
            if(order.getCustomer().getFirstName().equals(firstName) && order.getCustomer().getLastName().equals(lastName)){
                return order;
            }
            
        }
        System.out.println("Δεν βρέθηκε παραγγελία με αυτό τον πελάτη");
        return null;
    }
    
    public static void getSumProductInOrderQuantity(){
        int food_sum = 0;
        int beverage_sum = 0;
        int detergent_sum = 0;
        int hygiene_product_sum = 0;
        
        for (Order order : orders){
            for(ProductInOrder product : order.getProducts()){
                switch (product.getProduct().getCategory()) {
                    case BEVERAGE:
                        beverage_sum = beverage_sum + product.getQuantity();
                        break;
                    case DETERGENT:
                        detergent_sum = detergent_sum + product.getQuantity();                    
                        break;
                    case FOOD:
                        food_sum = food_sum + product.getQuantity();
                        break;
                    default:
                        hygiene_product_sum = hygiene_product_sum + product.getQuantity();
                        break;
                }
            }
        }
        
        System.out.println("Φαγητό: " + food_sum);
        System.out.println("Ποτό: " + beverage_sum);
        System.out.println("Είδη υγιεινής: " + hygiene_product_sum);
        System.out.println("Απορυπαντικό: " + detergent_sum);
    }
    
    public static void getOrdersNumberByDriver(){
        for (Driver driver : DriverStore.drivers){
            int sum = 0 ;
            for (Order order : orders){
                if(driver == order.getDriver()){
                    sum = sum + 1;
                }
            }
            System.out.println("Οδηγός "+ driver.getFirstName() + " " + driver.getLastName() + " αριθμός παραγγελιών: " + sum);
        }
    }
    public static void getOrdersNumberByAddressDeliveryChoice(){
        int sum1 = 0;
        int sum2 = 0;
        for (Order order : orders){
            if(order.getDeliveryPlace()!= null){
                sum1 = sum1 + 1;
            }else{
               sum2 = sum2 + 1; 
            }
        }
        System.out.println("Πλήθος παραγγελιών που πήγαν σε lockers "+ sum1 + ", Πλήθος παραγγελιών που πήγαν στο χώρο του πελάτη: " + sum2);
        
    }
}
