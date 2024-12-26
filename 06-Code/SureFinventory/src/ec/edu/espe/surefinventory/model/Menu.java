
package ec.edu.espe.surefinventory.model;

import ec.edu.espe.surefinventory.utils.JsonFileManager;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        
        Path filePath = Paths.get("data","menu.json"); 
        JsonFileManager menuFileManager = new JsonFileManager(filePath);
        
        productList = menuFileManager.decerializeJson(Dish.class);
        this.productList = productList;
    }
    


    public void showMenu() {
    
    JsonFileManager.printJson(productList);
    
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
