package ec.edu.espe.easyorder.model;

/**
 *
 * @author Abner Proaño
 */
public class Dish {
    private String name;
    private int id;
    private float price;
    private int quantity;

    public Dish(String name, float price) {
        this.name = name;
        this.price = price;
    }

        public Dish(String name, float price, int quantity) {
        this.name = name;
        this.price = price;  // You can set a default price or fetch it from another source
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Dish{" + "name=" + name + ", id=" + id + ", price=" + price + '}';
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
    
}
