package it22049.models;

import it22049.helpers.IdGenerator;
import java.util.Random;

public class Product {
    private int id;
    
    private String barcode;
    
    private String name;
    
    private ProductCategory category;
    
    private String brandName;

    public Product(String name, ProductCategory category, String brandName) {
        this.id = IdGenerator.generateRandomId();
        this.barcode = generateBarcode();
        this.name = name;
        this.category = category;
        this.brandName = brandName;
    }
    // method to generate random barcode
    private String generateBarcode(){
        Random random = new Random();
        
        // Generate random numbers for each part
        int part1 = random.nextInt(900000) + 100000; // Random 6-digit number
        int part2 = random.nextInt(900000) + 100000; // Random 6-digit number
        
        // Format the barcode string
        return String.format("0 %06d %06d", part1, part2);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Barcode: " + barcode + ", Όνομα: " + name + ", Brand: " + brandName;
    }
    
    
    
    
    
    
}
