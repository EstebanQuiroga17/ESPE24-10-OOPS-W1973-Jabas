package ec.edu.espe.surefinventory.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
public class Invoice {
    private Calendar date;
    private String header;
    private int id;
    private float price;
    private Order order;

    @Override
    public String toString() {
        return "Invoice{" + "date=" + date + ", header=" + header + ", id=" + id + ", price=" + price + ", order=" + order + '}';
    }

    public Invoice(String header, int id, Order order) {
        date = Calendar.getInstance();
        this.setDate(date);
        
        
        header = "Nueva factura";
        this.setHeader(header);
        

        this.id = id;
        
        for(Dish dish : order.getDishes()){
           price += dish.getPrice();    
        }
        this.setPrice(price);
        
        this.order = order;
    }


    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


}
