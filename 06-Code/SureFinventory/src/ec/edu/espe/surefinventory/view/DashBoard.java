package ec.edu.espe.surefinventory.view;

import java.util.Scanner;
import ec.edu.espe.surefinventory.model.Manager;
import ec.edu.espe.surefinventory.model.Menu;
import ec.edu.espe.surefinventory.model.Product;


/**
 *
 * @author Esteban Quiroga
 */
public class DashBoard {
    
    private static int dashboardOption;
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
                
                case 3: DashBoard.initMenuDashboard();
                break;
                
                case 4: DashBoard.initMainDashboard();
                break;
                
                default: DashBoard.initMainDashboard();
                break;
            }
            
        }while(option<1 && option >5 );
    }

    public static void initMenuDashboard(){
        do{
            System.out.println("1. Ver el Menu. \n"+
                               "2. Añadir un nuevo producto.\n"+
                               "3. Remover un producto.\n"+
                               "4. Regresar al inicio.\n");
            System.out.print("Selecciona una opción: ");
            
            dashboardOption = scanner.nextInt();
            Menu menu = new Menu(1);
            switch(dashboardOption){
                case 1 -> {
                System.out.println("Visualizando el Menú:");
                menu.displayMenu();
            } 
                case 2 -> {
                System.out.println("Añadiendo un nuevo producto...");
                System.out.print("Ingresa el ID del producto: ");
                int id = scanner.nextInt();
                System.out.print("Ingresa el nombre del producto: ");
                scanner.nextLine(); 
                String name = scanner.nextLine();
                System.out.print("Ingresa el precio del producto: ");
                float price = scanner.nextFloat(); 
                System.out.print("Ingresa el peso del producto (en g): ");
                float weight = scanner.nextFloat(); 
                System.out.print("Ingresa la cantidad disponible del producto: ");
                int quantity = scanner.nextInt();

                Product newProduct = new Product(id, name, price, weight, quantity);
                menu.addProduct(newProduct);
            }
                
                case 3 -> {
                System.out.println("Remover un producto...");
                System.out.print("Ingresa el ID del producto a eliminar: ");
                int id = scanner.nextInt();
                menu.removeProduct(id);
            }
                     
                case 4 -> DashBoard.initMainDashboard();
                
            }
        } while(dashboardOption<1 || dashboardOption>4);
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
