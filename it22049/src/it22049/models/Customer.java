package it22049.models;

import it22049.helpers.IdGenerator;

public class Customer {
    private int id;
    
    private String firstName;
    
    private String lastName;
    
    private String address;
    
    private String email;

    public Customer(String firstName, String lastName, String address, String email) {
        this.id = IdGenerator.generateRandomId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Όνοματεπώνυμο: " + firstName + " " + lastName;
    }
}
