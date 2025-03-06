
package ec.edu.espe.easyorder.controller;

import utils.MongoDbManager;
import java.util.List;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Esteban Quiroga
 */
public class WorkerControllerTest {
    
    
    public WorkerControllerTest() {
    }

    /**
     * Test of logIn method, of class WorkerController.
     */
    @Test
    public void testLogIn() {
        System.out.println("logIn");
        List<Document> workers = MongoDbManager.getAll("Worker");
        String userName = "juan";
        String password = "juan123";
        boolean expResult = false;
        boolean result = WorkerController.logIn(workers, userName, password);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getType method, of class WorkerController.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        List<Document> workers = MongoDbManager.getAll("Worker");
        String userName = "pepe";
        String password = "pepe2";
        WorkerController instance = new WorkerController();
        int expResult = 0;
        int result = instance.getType(workers, userName, password);
        assertEquals(expResult, result);
        
    }
    
}
