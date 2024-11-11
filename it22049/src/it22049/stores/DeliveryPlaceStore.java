package it22049.stores;

import it22049.models.DeliveryPlace;
import it22049.models.Locker;
import java.util.ArrayList;
import java.util.List;

public class DeliveryPlaceStore {
    //List to keep our data
    public static List<DeliveryPlace> delivryPlaces = new ArrayList<>();
    
    // Methos to find an empty delivery place
    public static DeliveryPlace findEmptyDeliveryPlace(){
        for (DeliveryPlace deliveryPlace : delivryPlaces){
            if(deliveryPlace.hasEmptyLocker()){
                return deliveryPlace;
            }
        }
        System.out.println("Δεν βρέθηκε κάποιος χώρος με άδειο locker. Η παραγγελία ακυρώθηκε!");
        return null;
    }
    //Method to find an empty locker from a delivery place object
    public static Locker findEmptyLocker(DeliveryPlace deliveryPlace){
        return deliveryPlace.getEmptyLocker();
        
    }
    
}
