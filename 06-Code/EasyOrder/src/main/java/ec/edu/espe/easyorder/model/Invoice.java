package ec.edu.espe.easyorder.model;

import java.util.Calendar;

/**
 *
 * @author Abner Proaño
 */
public class Invoice {
    
    private Calendar date;
    private float price;
    private Order order;
    private String header;
    private int id;

    public Invoice(Calendar date, float price, Order order, String header, int id) {
        this.date = date;
        this.price = price;
        this.order = order;
        this.header = header;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Invoice{" + "date=" + date + ", price=" + price + ", order=" + order + ", header=" + header + ", id=" + id + '}';
    }
    

    /**
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
    
}
