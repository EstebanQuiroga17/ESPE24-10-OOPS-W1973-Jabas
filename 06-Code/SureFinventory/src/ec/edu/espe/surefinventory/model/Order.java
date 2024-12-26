package ec.edu.espe.surefinventory.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order {
    private int itemQuantity;
    private int id;
    private ArrayList<Dish> dishes;
    private Customer customer;
    
    public Invoice createInvoice(){
        
    Invoice invoice = new Invoice()
    return invoice;
    }
    
    @Override
    public String toString() {
        return "Order{" + "itemQuantity=" + itemQuantity + ", id=" + id + ", dishes=" + dishes + ", customer=" + customer + '}';
    }

    public Order(int itemQuantity, int id, ArrayList<Dish> dishes, Customer customer) {
        this.itemQuantity = itemQuantity;
        this.id = id;
        this.dishes = dishes;
        this.customer = customer;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
}