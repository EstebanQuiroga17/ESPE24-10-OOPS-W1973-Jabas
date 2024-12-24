package ec.edu.espe.surefinventory.model;

import java.util.Calendar;
/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
public class Invoice {
    private Calendar date;
    private Customer customer;
    private String header;
    private int id;
    private double price;
    private final int iva = 0;
    private Order order;

    public Invoice(Calendar date, Customer customer, String header, int id, double price, Order order) {
        this.date = date;
        this.customer = customer;
        this.header = header;
        this.id = id;
        this.price = price;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Invoice Details:\n" +
               "-------------------------\n" +
               "Date: " + date.getTime() + "\n" +
               "Customer: " + customer + "\n" +
               "Header: " + header + "\n" +
               "ID: " + id + "\n" +
               "Price: $" + price + "\n" +
               "IVA: " + iva + "%\n" +
               "Order: " + order + "\n" +
               "Total: $" + calculateTotal() + "\n" +
               "-------------------------";
    }

    public double calculateTotal() {
        return price + (price * iva / 100.0);
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIva() {
        return iva;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
