package ec.edu.espe.easyorder.model;

import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author Matias Rojas
 */
public class Order {
     private int itemQuantity;
     private int id;
     private ArrayList<Dish> dishes;
     private Customer customer;

    public Order(int itemQuantity, int id, ArrayList<Dish> dishes, Customer customer) {
    this.itemQuantity = itemQuantity;
    this.id = id;
    this.dishes = dishes;
    this.customer = customer;

    }

    @Override
    public String toString() {
        return "Order{" + "itemQuantity=" + itemQuantity + ", id=" + id + ", dishes=" + dishes + ", customer=" + customer + '}';
    }

    /**
     * @return the itemQuantity
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * @param itemQuantity the itemQuantity to set
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the dishes
     */
    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    /**
     * @param dishes the dishes to set
     */
    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

<<<<<<< HEAD
    /**
     * @return the CurrentDate
     */
=======
>>>>>>> 16650937cbcf3a060fdc85b83c0d0ef2cd92b080
    public Customer getCustomer() {
        return customer;
    }

<<<<<<< HEAD
    /**
     * @param CurrentDate the CurrentDate to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
     
       
=======
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
   
>>>>>>> 16650937cbcf3a060fdc85b83c0d0ef2cd92b080
    
}
