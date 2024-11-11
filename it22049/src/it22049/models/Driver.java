package it22049.models;

import it22049.helpers.IdGenerator;

public class Driver {
    
    private int id;
    
    private String firstName;
    
    private String lastName;
    
    private String address;
    
    private String email;
    
    private String vat;
    
    private String carLicenseΝumber;
    
    private Boolean lockersDelivery;

    public Driver(String firstName, String lastName, String address, String email, String vat, String carLicenseΝumber, Boolean lockersDelivery) {
        this.id = IdGenerator.generateRandomId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.vat = vat;
        this.carLicenseΝumber = carLicenseΝumber;
        this.lockersDelivery = lockersDelivery;
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

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getCarLicenseΝumber() {
        return carLicenseΝumber;
    }

    public void setCarLicenseΝumber(String carLicenseΝumber) {
        this.carLicenseΝumber = carLicenseΝumber;
    }

    public Boolean getLockersDelivery() {
        return lockersDelivery;
    }

    public void setLockersDelivery(Boolean lockersDelivery) {
        this.lockersDelivery = lockersDelivery;
    }

    @Override
    public String toString() {
        String lockersDeliveryToString;
        if (lockersDelivery){
            lockersDeliveryToString = "ΝΑΙ";
        }else{
            lockersDeliveryToString = "ΟΧΙ";
        }
        return "Όνοματεπώνυμο: "+ firstName + " " + lastName + ", Δυνατότητα παράδοσης σε θυρίδα: " + lockersDeliveryToString;
    }
    
}
