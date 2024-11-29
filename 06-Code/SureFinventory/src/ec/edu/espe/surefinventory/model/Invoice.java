
package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
class Invoice {
    private Customer customer;
    private String paymentMethod;
    private int id;

    @Override
    public String toString() {
        return "Invoice{" + "customer=" + customer + ", paymentMethod=" + paymentMethod + ", id=" + id + ", description=" + description + '}';
    }

    public Invoice(Customer customer, String paymentMethod, int id, Order description) {
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.id = id;
        this.description = description;
    }
    private Order description;

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
    
}
