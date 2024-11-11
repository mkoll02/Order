package it22049.models;

import it22049.helpers.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class DeliveryPlace {
    private int id;
    
    private String address;
    
    private List<Locker> lockers;

    public DeliveryPlace(String address) {
        this.id = IdGenerator.generateRandomId();
        this.address = address;
        this.lockers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Locker> getLockers() {
        return lockers;
    }

    public void setLockers(List<Locker> lockers) {
        this.lockers = lockers;
    }
    
    // Method to make locker unavailable
    public void closeLocker(int index){
        for (Locker locker : lockers){
            if (locker.getIndex() == index){
                locker.setIsEmpty(false);
            }
        }
    }
    // Method to make locker available
    public void openLocker(int index){
        for (Locker locker : lockers){
            if (locker.getIndex() == index){
                locker.setIsEmpty(true);
            }
        }
    }
    
    // Method to add multiple lockers by the given number
    public void addEmptyLockers(int lockersNumber){
        for (int i = 1; i<=lockersNumber; i++){
            lockers.add(new Locker(i,true));
        }
    }
    
    // Method to get a locker by its ID
    public Locker getLocker(int lockerId) {
        for (Locker locker : lockers) {
            if (locker.getIndex() == lockerId) {
                return locker;
            }
        }
        return null; // Locker not found
    }

    // Method to remove a locker by its ID
    public void removeLocker(int lockerId) {
        lockers.removeIf(locker -> locker.getIndex() == lockerId);
    }

    // Method to check if a locker exists by its ID
    public boolean hasLocker(int lockerId) {
        for (Locker locker : lockers){
            if (locker.getIndex() == lockerId){
                return true;
            }
        }
        return false;    
    }

    // Method to get the number of lockers
    public int getNumberOfLockers() {
        return lockers.size();
    }
    
    // Method to check if an empty locker exists
    public boolean hasEmptyLocker() {
        for (Locker locker : lockers){
            if (locker.getIsEmpty()){
                return true;
            }
        }
        return false;
    }
    
    // Method to return the first empty locker
    public Locker getEmptyLocker() {
        for (Locker locker : lockers){
            if (locker.getIsEmpty()){
                return locker;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "Διεύθυνση: " + address ;
    }

}
