package ec.edu.espe.surefinventory.model;
/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
public class Dish {
    private String name;
    private int id;
    private float price;

    // Constructor
    public Dish(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price =  price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" + "name=" + name + ", id=" + id + ", price=" + price + '}';
    }

   
    

}

