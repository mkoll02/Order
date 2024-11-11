package it22049.models;

public class Locker {
    
    private int index;
    
    private Boolean isEmpty;
    
    public Locker(int index, Boolean isEMpty) {
        this.index = index;
        this.isEmpty = isEMpty;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public String toString() {
        String isEmptyToString;
        if (isEmpty){
            isEmptyToString = "Άδειο";
        }else{
            isEmptyToString = "Καταχωρημένο";
        }
        return "Αριθμός θυρίδας: " + index;
    }
    
    
    
}
