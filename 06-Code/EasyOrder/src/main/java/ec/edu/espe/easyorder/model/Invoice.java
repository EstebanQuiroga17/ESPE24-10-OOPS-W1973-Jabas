package ec.edu.espe.easyorder.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

/**
 *
 * @author Abner Proaño
 */
public class Invoice {
    
    private Calendar currentDate;
    private String id;
    private Customer customer;
    private float totalPrice;
    private Order order;
    private String header;

    public Invoice(Customer customer, Order order, float totalPrice) {
        this.customer = customer;
        this.order = order;
        this.header = "PADMITOS VEGETARIAN AND VEGAN FOOD";  
        this.id = order.getId();  
        this.currentDate = Calendar.getInstance();  
        this.totalPrice = totalPrice;  
    }

    /**
     * @return the currentDate
     */
    public Calendar getCurrentDate() {
        return currentDate;
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(Calendar currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the totalPrice
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }
   
}
