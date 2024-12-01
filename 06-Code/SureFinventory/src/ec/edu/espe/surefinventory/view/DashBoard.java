package ec.edu.espe.surefinventory.view;

import java.util.Scanner;
import ec.edu.espe.surefinventory.model.Manager;


/**
 *
 * @author Esteban Quiroga
 */
public class DashBoard {
    
    private int dashboardOption;
     Scanner scanner = new Scanner(System.in);
    
    public void initMainDashboard(){
        System.out.println("SureFinventory \n"
        +   "Selecciona una opcion para continuar...\n"
        + "1. Ingresar como admin.\n"
        + "2. Ingresar como mesero. \n");
        
      
       
       this.setDashboardOption(scanner.nextInt());
       
    }
    
    public void initManagerDashboard(Manager manager, int option){
        
        System.out.println("Ingresa tu contrasena para iniciar: \n");
        
        String password = scanner.next();
        
        while(password.equals(manager.getPassword()) == false){
           
            System.out.println("Contrasena incorrecta, intentalo de nuevo...");
            password = scanner.next();
        }
        
        System.out.println("Bienvenido "+ manager.getUsername()"\n");
        
        do{
            
            System.out.println("1. Modificar el inventario. \n"
                               +"2. Crear un cajero. \n"
                               +"3. Abrir la caja registradora. \n"
                               +"4. Editar el Menu.\n"
                               + "5. Salir. \n");
            option = scanner.nextInt();
            switch(option){
                case 1:
                
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
