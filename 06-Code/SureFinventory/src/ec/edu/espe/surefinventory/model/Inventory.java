package ec.edu.espe.surefinventory.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Inventory {
    private Calendar lastUpdated;
    private List<Product> products;

    public Inventory(Calendar lastUpdated) {
        this.lastUpdated = lastUpdated;
        this.products = new ArrayList<>();
    }

    // Getters
    public Calendar getLastUpdated() {
        return lastUpdated;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Setters
    public void setLastUpdated(Calendar lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    // Methods for managing products
    public void addProduct(Product product) {
        Product existingProduct = findProductById(product.getId());
        if (existingProduct != null) {
            existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
        } else {
            products.add(product);
        }
        lastUpdated = Calendar.getInstance();
    }

    public boolean removeProduct(int productId) {
        return products.removeIf(product -> product.getId() == productId);
    }

    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (Product product : products) {
            totalQuantity += product.getQuantity();
        }
        return totalQuantity;
    }
}
