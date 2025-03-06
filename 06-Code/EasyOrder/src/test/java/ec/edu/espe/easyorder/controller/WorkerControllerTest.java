
package ec.edu.espe.easyorder.controller;

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
        List<Document> workers = null;
        String userName = "";
        String password = "";
        boolean expResult = false;
        boolean result = WorkerController.logIn(workers, userName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class WorkerController.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        List<Document> workers = null;
        String userName = "";
        String password = "";
        WorkerController instance = new WorkerController();
        int expResult = 0;
        int result = instance.getType(workers, userName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
