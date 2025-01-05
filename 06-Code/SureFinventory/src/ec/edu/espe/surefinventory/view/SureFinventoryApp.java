
package ec.edu.espe.surefinventory.view;

import ec.edu.espe.surefinventory.model.Cashier;
import ec.edu.espe.surefinventory.model.DashBoard;
import ec.edu.espe.surefinventory.model.Manager;
import ec.edu.espe.surefinventory.utils.JsonFileManager;

/**
 *
 * @author Esteban Quiroga 
 */
public class SureFinventoryApp {
    public static void main(String[] args) {
        DashBoard dashBoard = new DashBoard();
        
        dashBoard.printLogInDashBoard();
        
        
    }
}
