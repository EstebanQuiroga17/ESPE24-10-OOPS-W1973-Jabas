
package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
class Invoice {
    private Customer customer;
    private String paymentMethod;
    private int id;
    private double total;
    private double iva;
     private Order description;

    @Override
    public String toString() {
        return "Invoice{" + "customer=" + customer + ", paymentMethod=" + paymentMethod + ", id=" + id + ", total=" + total + ", iva=" + iva + ", description=" + description + '}';
    }
    

    

    public Invoice(Customer customer, String paymentMethod, int id, Order description) {
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.id = id;
        this.description = description;
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
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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
     * @return the description
     */
    public Order getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(Order description) {
        this.description = description;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }
    public void printInvoice() {
    System.out.println("========== Invoice ==========");
    System.out.println("Customer: " + customer);
    System.out.println("Payment Method: " + paymentMethod);
    System.out.println("Invoice ID: " + id);
    System.out.println("Description: " + description);
    System.out.printf("IVA: $%.2f%n", iva);
    System.out.printf("Total: $%.2f%n", total);
    System.out.println("=============================");
}
}
