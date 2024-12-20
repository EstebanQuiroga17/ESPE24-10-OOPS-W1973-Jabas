package ec.edu.espe.surefinventory.model;

public class Dish {
    private String name;
    private int id;
    private double price;

    // Constructor
    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public void setPrice(double price) {
        this.price = price;
    }

   
    public void updateDetails(String newName, double newPrice) {
        this.name = newName;
        this.price = newPrice;
    }

    
    @Override
    public String toString() {
        return String.format(
        "%-10s | %-20s | %-10s%n" +
        "---------------------------------%n" +
        "%-10d | %-20s | $%-10.2f",
        "ID", "Name", "Price", 
        id, name, price,
                "\n"
    );
        }

}

