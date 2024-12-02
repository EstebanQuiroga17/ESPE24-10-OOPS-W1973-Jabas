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

            switch (option) {
                case 1 -> {
                    Manager mainManager = new Manager("Manager", 103, "juanito123");
                    dashboard.initManagerDashboard(mainManager, option);
                }
                case 0 -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0); 
  }
    
    
}
    