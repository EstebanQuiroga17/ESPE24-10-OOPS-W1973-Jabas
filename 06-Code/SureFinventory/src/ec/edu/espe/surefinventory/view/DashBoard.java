package ec.edu.espe.surefinventory.view;

import java.util.Scanner;
import ec.edu.espe.surefinventory.model.Manager;


/**
 *
 * @author Esteban Quiroga
 */
public class DashBoard {
    
    private int dashboardOption;
    public static Scanner scanner = new Scanner(System.in);
    
    public static void initMainDashboard(){
        
        System.out.println("SureFinventory \n"
        +   "Selecciona una opcion para continuar...\n"
        + "1. Ingresar como manager.\n"
        + "2. Ingresar como mesero. \n");
        
        Scanner scanner = new Scanner(System.in);
        int dashboardOption = scanner.nextInt();        
        
        do{
            switch (dashboardOption) {
                case 1 -> {
                    Manager mainManager = new Manager("Manager", "juanito123");
                    DashBoard.initManagerDashboard(mainManager, dashboardOption);
                }
                case 2 -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while(dashboardOption > 2 || dashboardOption < 1);
       
       
       
    }
    
    public static void initManagerDashboard(Manager manager, int option){
        
        System.out.println("Ingresa tu contrasena para iniciar: \n");
        
        String password = scanner.next();
        
        while(password.equals(manager.getPassword()) == false){
           
            System.out.println("Contrasena incorrecta, intentalo de nuevo...");
            password = scanner.next();
        }
        
        System.out.println("Bienvenido "+ manager.getUsername() + "\n");
        
        do{
            
            System.out.println("1. Modificar el inventario. \n"
                               +"2. Crear un cajero. \n"                               
                               +"3. Editar el Menu.\n"
                               +"4. Volver al inicio. \n");
            option = scanner.nextInt();
            switch(option){
                case 1: //TODO create inventory dashboard
                break;
                
                case 2: manager.createCashier();
                break;
                
                case 3: //TODO create menu dashboard
                break;
                
                case 4: DashBoard.initMainDashboard();
                break;
                
                default: DashBoard.initMainDashboard();
                break;
            }
            
        }while(option<1 && option >5 );
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
