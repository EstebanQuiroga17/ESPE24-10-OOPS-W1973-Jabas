package ec.edu.espe.surefinventory.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matias Rojas
 */
public class Menu {
    private int id;
    private List<Product> products;

    public Menu(int id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Producto añadido exitosamente: " + product.getName());
    }

    public void removeProduct(int productId) {
        boolean removed = products.removeIf(product -> product.getId() == productId);
        if (removed) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void displayMenu() {
        System.out.println("Menú ID: " + id);
        if (products.isEmpty()) {  
            System.out.println("El menú está vacío.");
        } else {
            System.out.println("Productos en el menú:");
            for (Product product : products) {
                System.out.println("- " + product);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

