
package ec.edu.espe.surefinventory.view;

import ec.edu.espe.surefinventory.model.Cashier;
import ec.edu.espe.surefinventory.model.DashBoard;
import ec.edu.espe.surefinventory.model.Manager;

/**
 *
 * @author Esteban Quiroga 
 */
public class SureFinventoryApp {
    public static void main(String[] args) {
        DashBoard dashboard = new DashBoard();
        
        dashboard.printLogInDashBoard();
        
        switch(dashboard.getDashBoardOption()){
            
            case 1: {
                if (Manager.logIn()) {
                System.out.println("Access granted ");
                System.out.println("Accessing the system");
                } else System.out.println("Acceso denegado");
            }
            break;
            case 2: {
                if (Cashier.logIn()) {
                System.out.println("Access granted ");
                System.out.println("Accessing the system");
                } else System.out.println("Acceso denegado");            
            }
            break;
            
        }
        
    }
}
