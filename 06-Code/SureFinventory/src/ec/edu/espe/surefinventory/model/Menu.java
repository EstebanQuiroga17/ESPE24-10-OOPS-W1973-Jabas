
package sureinventoryapp.model;

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
    
    public void addDish(Dish dish) {
        productList.add(dish);
    }

    @Override
    public String toString() {
        StringBuilder menuString = new StringBuilder();
        
        menuString.append(String.format(
            "%-20s | %-20s%n" +
            "-----------------------------------------%n",
            "Product List", "Menu Name"));

        for (Dish dish : productList) {
            menuString.append(String.format("%-20s | %-20d | $%-10.2f%n", 
                    dish.getName(), dish.getId(), dish.getPrice()));
        }

        if (productList.isEmpty()) {
            menuString.append("No dishes available\n");
        }
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
