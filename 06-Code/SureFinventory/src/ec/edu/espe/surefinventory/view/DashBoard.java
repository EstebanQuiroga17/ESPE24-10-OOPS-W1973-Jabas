package ec.edu.espe.surefinventory.view;

import java.util.Scanner;
import ec.edu.espe.surefinventory.model.Manager;


/**
 *
 * @author Esteban Quiroga
 */
public class DashBoard {
    
    private int dashboardOption;
    
    public void initMainDashboard(){
        System.out.println("SureFinventory \n"
        +   "Selecciona una opcion para continuar...\n"
        + "1. Ingresar como admin.\n"
        + "2. Ingresar como mesero. \n");
        
       Scanner scanner = new Scanner(System.in);
       
       this.setDashboardOption(scanner.nextInt());
       
    }
    
    public void initAdminDashboard(Manager manager){
        
        System.out.println("Ingresa tu contrasena para iniciar: ");
        
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        
        while(password.equals(manager.getPassword()) == false){
           
            System.out.println("Contrasena incorrecta, intentalo de nuevo...");
            password = scanner.next();
        }
        
        System.out.println("Bienvenido "+ manager.getUsername());
        
        
    }

    public DashBoard(int menuOption) {
        this.dashboardOption = menuOption;
    }

    public int getDashboardOption() {
        return dashboardOption;
    }

    public void setDashboardOption(int dashboardOption) {
        this.dashboardOption = dashboardOption;
    }
    
        
    
}
