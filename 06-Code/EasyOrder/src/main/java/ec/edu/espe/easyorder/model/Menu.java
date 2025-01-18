
package ec.edu.espe.easyorder.model;

import java.util.ArrayList;

/**
 *
 * @author Esteban Quiroga 
 */
public class Menu {
    private final String name = "Menu";
    private ArrayList<Dish> productList;

    public ArrayList<Dish> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Dish> productList) {
        this.productList = productList;
    }
    
    
}
