package ec.edu.espe.surefinventory.view;

import ec.edu.espe.surefinventory.model.Manager;

/**
 *
 * @author Esteban Quiroga
 */
public class SureFinventoryApp {

    
    public static void main(String[] args) {
        
        //TODO englobe menu into a dowhile
            DashBoard dashboard = new DashBoard(0);

            dashboard.initMainDashboard();
        
            if(1 == dashboard.getDashboardOption()){
                
                Manager mainManager = new Manager("Manager", 103, "juanito123");
                dashboard.initAdminDashboard(mainManager);
            }        
    }
}