package ec.edu.espe.easyorder.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import ec.edu.espe.easyorder.view.FrmOrder;

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

    public Invoice(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
        this.header = "PADMITOS VEGETARIAN AND VEGAN FOOD";  
        this.id = order.getId();  
        this.currentDate = Calendar.getInstance();  
        this.totalPrice = calculateTotalPrice(order.getDishes());  
    }

    private float calculateTotalPrice(ArrayList<Dish> dishes) {
        float total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public String generateInvoice() {
        StringBuilder invoice = new StringBuilder();
        
        invoice.append("\n")
               .append("****************************************************\n")
               .append("*                ").append(header).append("                *\n")
               .append("****************************************************\n\n");
        
        invoice.append("Invoice ID: ").append(id).append("\n");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        invoice.append("Date: ").append(dateFormat.format(currentDate.getTime())).append("\n");
        
        invoice.append("\nCustomer Details:\n")
               .append("Name: ").append(customer.getName()).append("\n")
               .append("Customer ID: ").append(customer.getId()).append("\n")
               .append("Phone: ").append(customer.getPhoneNumber()).append("\n");
        
        invoice.append("\nOrder Details:\n")
               .append("Dishes Ordered:\n");
        for (Dish dish : order.getDishes()) {
            invoice.append("  - ").append(dish.getName())
                   .append(" ($").append(dish.getPrice()).append(")\n");
        }
        
        invoice.append("\n----------------------------------------------------\n")
               .append("Total Price: $").append(totalPrice).append("\n")
               .append("IVA: $0.00\n")
               .append("Total to Pay: $").append(totalPrice).append("\n");
        
        invoice.append("\n****************************************************\n")
               .append("*                   THANK YOU!                    *\n")
               .append("****************************************************\n");
        
        return invoice.toString();
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
        public Document toDocument() {
        Document customerDoc = new Document("name", customer.getName())
                .append("id", customer.getId())
                .append("phoneNumber", customer.getPhoneNumber());
        
        List<Document> dishDocs = new ArrayList<>();
        for (Dish dish : order.getDishes()) {
            dishDocs.add(new Document("name", dish.getName()).append("price", dish.getPrice()));
        }

        Document orderDoc;
        orderDoc = new Document("id", order.getId())
                .append("dishes", dishDocs)
                ;

        return new Document("id", id)
                .append("date", currentDate.getTimeInMillis())
                .append("customer", customerDoc)
                .append("totalPrice", totalPrice)
                .append("order", orderDoc)
                .append("header", header);
    }

}
