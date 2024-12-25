
package ec.edu.espe.sureinveoryapp.model;

import java.util.ArrayList;

/**
 *
 * @author abner
 */
public class Menu {
    
    private String name;
    private ArrayList<Dish> productList;

    public Menu(String name, ArrayList<Dish> productList) {
        this.name = name;
        this.productList = productList;
    }
    

    public String generateMenuString() {
    StringBuilder dishesString = new StringBuilder();
    for (Dish productListDishes : productList) {
        dishesString.append(String.format("%-10d | %-20s | $%-10.2f%n",
                productListDishes.getId(), productListDishes.getName(), productListDishes.getPrice()));
    }

    return String.format(
            "Name: %s%nDishes:%n%s",
            name, dishesString.toString());
}


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the productList
     */
    public ArrayList<Dish> getProductList() {
        return productList;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(ArrayList<Dish> productList) {
        this.productList = productList;
    }
    
    

}
