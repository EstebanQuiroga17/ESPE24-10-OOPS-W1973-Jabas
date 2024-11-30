package ec.edu.espe.surefinventory.view;

import ec.edu.espe.surefinventory.model.Manager;

/**
 *
 * @author Esteban Quiroga
 */
public class SureFinventoryApp {

    public static void main(String[] args) {
        DashBoard dashboard = new DashBoard(0);
        int option;

        do {
            dashboard.initMainDashboard();
            option = dashboard.getDashboardOption();

            if (option == 1) {
                Manager mainManager = new Manager("Manager", 103, "juanito123");
                dashboard.initAdminDashboard(mainManager);
            } else if (option == 0) {
                System.out.println("Exiting application...");
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0); 
  }
}
