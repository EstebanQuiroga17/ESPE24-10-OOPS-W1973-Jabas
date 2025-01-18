
package ec.edu.espe.easyorder.controller;

import ec.edu.espe.easyorder.model.Customer;
import ec.edu.espe.easyorder.model.Dish;
import ec.edu.espe.easyorder.model.Order;
import java.util.ArrayList;
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
    
     
   
}
