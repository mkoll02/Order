package it22049.stores;

import it22049.models.Driver;
import java.util.ArrayList;
import java.util.List;

public class DriverStore {
    
    // List to keep our data
    public static List<Driver> drivers = new ArrayList<>();
    
    //Method to list data
    public static void listDrivers(){
        for (Driver driver : drivers){
            System.out.println(driver.toString());
        }
    }
    // Method to find an object from list
    public static Driver findDriverByFullName(String firstName,String lastName){
        for (Driver driver : drivers){
            if(driver.getFirstName().equals(firstName) && driver.getLastName().equals(lastName)){
                return driver;
            }
            
        }
        return null;
    }
    
}

