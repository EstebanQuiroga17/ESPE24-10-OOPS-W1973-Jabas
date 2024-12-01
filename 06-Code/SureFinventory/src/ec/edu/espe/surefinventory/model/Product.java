
package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Abner
 * @version 0.1.0
 */
public class Product {
    private String name;
    private double cost;
    private int quantity;
    private double weight;

   //Constructor for Inventory
 public Product(String name, int quantity, double weight) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }
 //Constructor for Invoice 
    public Product(String name, double cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", cost=" + cost +
               ", quantity=" + quantity +
               '}';
    }
    
}