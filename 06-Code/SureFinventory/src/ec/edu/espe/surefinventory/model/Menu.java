
package ec.edu.espe.surefinventory.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.surefinventory.utils.JsonFileManager;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author abner
 */
public class Menu {
    
    private final String name = "Menu";
    private ArrayList<Dish> productList;

    public Menu() {

        Path filePath = Paths.get("data","dishesMenu.json"); 
        JsonFileManager menuFileManager = new JsonFileManager(filePath);
        
        productList = menuFileManager.decerializeJson(Dish.class);
        this.setProductList(productList);
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
     * @param productList the productList to set
     */
    public void setProductList(ArrayList<Dish> productList) {
        this.productList = productList;
    }
    
    

}
