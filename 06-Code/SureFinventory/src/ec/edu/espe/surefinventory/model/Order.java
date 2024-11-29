package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Matias Rojas 
 */
import ec.edu.espe.surefinventory.model.Inventory;
import ec.edu.espe.surefinventory.model.Product;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private float price;
    private int itemQuantity;
    private int id;
    private List<Product> productList;
    private LocalDate date;

    public Order(float price, int itemQuantity, int id, List<Product> productList, LocalDate date) {
        this.price = price;
        this.itemQuantity = itemQuantity;
        this.id = id;
        this.productList = productList;
        this.date = date;
    }

    public void printOrder() {
        System.out.println("Order ID: " + id);
        System.out.println("Date: " + date);
        System.out.println("Total Price: $" + price);
        System.out.println("Items:");
        for (Product product : productList) {
            System.out.println("- " + product.getName());
        }
    }

    public void removeInventoryProducts(Inventory inventory) {
        for (Product product : productList) {
            inventory.removeProduct(product);
        }
    }

    // Getters and setters 

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

    
