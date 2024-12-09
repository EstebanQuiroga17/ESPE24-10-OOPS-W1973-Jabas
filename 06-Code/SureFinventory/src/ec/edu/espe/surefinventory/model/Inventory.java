package ec.edu.espe.surefinventory.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Esteban Quiroga
 */
public class Inventory {
   
    int  id;
    String name;
    LocalDate creationDate;
    ArrayList<Product> productList;
    
    public String openInventory(Inventory inventory){
        //This function should return a String with the inventory
        String inventoryString;
        return inventoryString;
    }
    
    public void updateInventory(Inventory inventory){
        
    }
    
    public void deleteInventory(Inventory inventory){
        
    }
    
    public void removeInventory(Inventory inventory){
        
    }
    
}
