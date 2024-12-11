package ec.edu.espe.surefinventory.model;

/**
 * @author abner
 */
public class Product {
    private int id;
    private String name;
    private float price; 
    private float weight; 
    private int quantity;

    public Product(int id, String name, float price, float weight, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Precio: $" + price + ", Peso: " + weight + "g, Cantidad: " + quantity;
    }
}