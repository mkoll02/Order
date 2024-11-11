package it22049.models;

public class OrderRating {
    
    private Order order;
    
    private int rating;

    public OrderRating(Order order, int rating) {
        this.order = order;
        this.rating = rating;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Παραγγελία: " + order.getId() + ", αξιολόγηση: " + rating;
    }
}
