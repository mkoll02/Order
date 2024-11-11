package it22049.models;

import it22049.helpers.IdGenerator;

public class ProductInOrder {
    
    private int id;
    
    private Product product;
    
    private int quantity;

    public ProductInOrder( Product product, int quantity) {
        this.id = IdGenerator.generateRandomId();
        this.product = product;
        this.quantity = quantity;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "" + product + ", ποσότητα:" + quantity + '}';
    }
    
}
