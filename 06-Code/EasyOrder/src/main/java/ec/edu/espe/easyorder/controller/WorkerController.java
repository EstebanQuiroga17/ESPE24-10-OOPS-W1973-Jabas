
package ec.edu.espe.easyorder.controller;

import ec.edu.espe.easyorder.model.Customer;
import ec.edu.espe.easyorder.model.Dish;
import ec.edu.espe.easyorder.model.Order;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Esteban Quiroga 
 */
public class WorkerController {
    
    public static boolean logIn(List<Document> workers, String userName, String password) {
        
        for(Document worker : workers){
            if (worker.getString("userName").equals(userName)){
               
                if(worker.getString("password").equals(password)){
                   
                   return true; 
                }
                
            }
        }
        return false;
    }
    
    public int getType(List<Document> workers, String userName, String password){
       for(Document worker : workers){
            if (worker.getString("userName").equals(userName)){
               
                if(worker.getString("password").equals(password)){
                   
                   return worker.getInteger("type"); 
                }
                
            }
        }
        return 0;
    } 
    public Order takeOrder(Customer customer, ArrayList<Dish> dishes) {
        int itemQuantity = dishes.size(); // Calculate quantity based on list size
        int id = (int) (Math.random() * 10000); // Generate a unique ID
        Calendar CurrentDate = null;
        Order order = new Order(itemQuantity, id, dishes, CurrentDate);
        System.out.println("Orden tomada del cliente: " + customer.getName());
    return order;
}
    
      
}
