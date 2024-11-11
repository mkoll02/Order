package it22049.models;

import it22049.helpers.IdGenerator;
import java.time.LocalDateTime;
import java.util.List;


public class Order {
    
    private int id;
    
    private Customer customer;
    
    private Driver driver;
    
    private List<ProductInOrder> products;
    
    private OrderStatus status;
    
    private LocalDateTime date;
    
    private String deliveryAddress;
    
    private DeliveryPlace deliveryPlace;

    private Locker locker;
    
    public Order(Customer customer,Driver driver, List<ProductInOrder> products, String deliveryAddress, DeliveryPlace deliveryPlace,Locker locker) {
        this.id = IdGenerator.generateRandomId();
        this.customer = customer;
        this.driver = driver;
        this.products = products;
        this.status = OrderStatus.PENDING;
        this.date = LocalDateTime.now();
        this.deliveryAddress = deliveryAddress;
        this.deliveryPlace = deliveryPlace;
        this.locker = locker;
    }
    public Order(int id,Customer customer,Driver driver, List<ProductInOrder> products, String deliveryAddress, DeliveryPlace deliveryPlace,Locker locker) {
        this.id = id;
        this.customer = customer;
        this.driver = driver;
        this.products = products;
        this.status = OrderStatus.PENDING;
        this.date = LocalDateTime.now();
        this.deliveryAddress = deliveryAddress;
        this.deliveryPlace = deliveryPlace;
        this.locker = locker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    
    
    public List<ProductInOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInOrder> products) {
        this.products = products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public DeliveryPlace getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(DeliveryPlace deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }
    
    
    // Method to add locker
    public void addProduct(ProductInOrder orderProduct){
        if(products.size()< 3){
            products.add(orderProduct);
        }else{
            System.out.println("Συγγνώμη δεν μπορείτε να προσθέσετε άλλο προιόν. Το μέγιστο όριο είναι 2 προιόντα ανά παραγγελία");
        }
    }

    @Override
    public String toString() {
        String showStatus;
        if(status == OrderStatus.PENDING) showStatus = "ΕΚΚΡΕΜΕΙ";
        else showStatus = "ΟΛΟΚΛΗΡΩΘΗΚΕ";
        String showAddress;
        if(deliveryAddress == null) showAddress = deliveryPlace + " " + locker;
        else showAddress = deliveryAddress;
        return "Κωδικός παραγγελίας: " + id + ", πελάτης: " + customer + ", οδηγός: " + driver + ", προιόντα: " + products + ", ημερομηνία παραγγελίας: " + date + ", διεύθυνση παράδοσης: " + showAddress + ", κατάσταση παραγγελίας: " + showStatus;
    }    
    
}
