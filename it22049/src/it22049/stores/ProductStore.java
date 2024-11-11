package it22049.stores;

import it22049.models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductStore {
    //List to keep our data
    public static List<Product> products = new ArrayList<>();
    
    // Method to list our objects
    public static void listProducts(){
        for (Product product : products){
            System.out.println(product.toString());
        }
    }
    // Method to find an object
    public static Product findProductByBarcode(String barcode){
        for (Product product : products){
            if(product.getBarcode().equals(barcode)){
                return product;
            }
            
        }
        System.out.println("Δεν βρέθηκε προιόν με αυτό το barcode");
        return null;
    }
}
