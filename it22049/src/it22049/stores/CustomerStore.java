package it22049.stores;

import it22049.models.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerStore {
    
    //List to keep our data
    public static List<Customer> customers = new ArrayList<>();
    
    //Methos to list our data
    public static void listCustomers(){
        for (Customer customer : customers){
            System.out.println(customer.toString());
        }
    }
    //Method to find an object
    public static Customer findCustomerByFullName(String firstName,String lastName){
        for (Customer customer : customers){
            if(customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)){
                return customer;
            }
            
        }
        return null;
    }
    
}
