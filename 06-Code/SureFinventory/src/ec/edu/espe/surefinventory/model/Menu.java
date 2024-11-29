package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Matias Rojas
 */
import ec.edu.espe.surefinventory.model.Product;
import java.util.List;

public class Menu {
    private List<Product> productList;
    private int id;

    public Menu(List<Product> productList, int id) {
        this.productList = productList;
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
