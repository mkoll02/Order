package it22049.helpers;

import java.util.Random;

public class IdGenerator {
    
    
    // Method to generate a random 3-digit ID
    public static int generateRandomId(){
        Random rand = new Random();
        return rand.nextInt(999);
    }
}
