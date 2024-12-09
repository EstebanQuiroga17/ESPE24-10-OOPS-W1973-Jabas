package ec.edu.espe.surefinventory.view;

import ec.edu.espe.surefinventory.model.Inventory;
import ec.edu.espe.surefinventory.model.Product;
import ec.edu.espe.surefinventory.model.Manager;
<<<<<<< HEAD
import utils.AdminDataManager;
import utils.InventoryDataManager;
=======
import ec.edu.espe.surefinventory.model.Menu;
import ec.edu.espe.surefinventory.model.Product;
>>>>>>> 2121b9f47d4935a9d32ad2e44b48ecaa31f77676

import java.time.LocalDateTime;
import java.util.Scanner;

public class DashBoard {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InventoryDataManager inventoryDataManager = new InventoryDataManager();

    public static void initMainDashboard() {
        while (true) {
            System.out.println("""
                SureFinventory
                Selecciona una opcion para continuar:
                1. Ingresar como manager.
                2. Salir.
                """);

            int option = getIntInput("Selecciona una opción: ");

            switch (option) {
                case 1 -> {
                    Manager mainManager = new Manager("Manager", "admin123");
                    initManagerDashboard(mainManager);
                }
<<<<<<< HEAD
=======
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
>>>>>>> 2121b9f47d4935a9d32ad2e44b48ecaa31f77676
                case 2 -> {
                    System.out.println("Saliendo del sistema...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    public static void initManagerDashboard(Manager manager) {
        if (!authenticateManager(manager)) {
            System.out.println("Demasiados intentos fallidos. Regresando al menú principal.");
            return;
        }

        while (true) {
            System.out.println("""
                Bienvenido %s
                1. Modificar el inventario.
                2. Crear un cajero.
                3. Ver todos los cajeros.
                4. Salir.
                """.formatted(manager.getUsername()));

            int option = getIntInput("Selecciona una opción: ");

            switch (option) {
                case 1 -> initInventoryDashboard();
                case 2 -> createCashier();
                
                case 4 -> {
                    System.out.println("Regresando al menú principal...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta nuevamente.");
            }
<<<<<<< HEAD
        }
=======
                     
                case 4 -> DashBoard.initMainDashboard();
                
            }
        } while(dashboardOption<1 || dashboardOption>4);
    }
    
    public DashBoard(int menuOption) {
        this.dashboardOption = menuOption;
>>>>>>> 2121b9f47d4935a9d32ad2e44b48ecaa31f77676
    }

    private static void initInventoryDashboard() {
        while (true) {
            System.out.println("""
                Gestión de Inventario:
                1. Ver Inventario.
                2. Añadir Producto.
                3. Actualizar Producto.
                4. Eliminar Producto.
                5. Regresar al menú anterior.
                """);

            int option = getIntInput("Selecciona una opción: ");

            switch (option) {
                case 1 -> inventoryDataManager.getInventoryManager().getItems().forEach(System.out::println);
                case 2 -> addProductToInventory();
                case 3 -> updateProductInInventory();
                case 4 -> removeProductFromInventory();
                case 5 -> {
                    System.out.println("Regresando al menú anterior...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    private static void addProductToInventory() {
        System.out.println("Añadiendo un nuevo producto...");
        Product newProduct = createProduct();
        int quantity = getIntInput("Cantidad total del producto: ");
        Inventory newInventory = new Inventory(LocalDateTime.now(), newProduct, quantity);
        inventoryDataManager.getInventoryManager().addItem(newInventory);
        System.out.println("Producto añadido exitosamente.");
    }

    private static void updateProductInInventory() {
        System.out.print("Ingresa el ID del producto a actualizar: ");
        int productId = getIntInput("ID del producto: ");
        InventoryDataManager inventoryManager = inventoryDataManager;

        boolean updated = inventoryManager.getInventoryManager().updateItem(
                inventory -> inventory.getProductList().getId() == productId,
                new Inventory(
                        LocalDateTime.now(),
                        createProduct(),
                        getIntInput("Cantidad total del producto actualizada: ")
                )
        );

        System.out.println(updated ? "Producto actualizado con éxito." : "Producto no encontrado.");
    }

    private static void removeProductFromInventory() {
        System.out.print("Ingresa el ID del producto a eliminar: ");
        int productId = getIntInput("ID del producto: ");
        boolean removed = inventoryDataManager.getInventoryManager()
                .removeItem(inventory -> inventory.getProductList().getId() == productId);
        System.out.println(removed ? "Producto eliminado con éxito." : "Producto no encontrado.");
    }

    private static void createCashier() {
        System.out.println("Creando un nuevo cajero...");
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        AdminDataManager.addCashier(new ec.edu.espe.surefinventory.model.Cashier(username, password));
    }

    

    private static boolean authenticateManager(Manager manager) {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Ingresa tu contraseña: ");
            String password = scanner.next();
            if (manager.getPassword().equals(password)) {
                return true;
            }
            System.out.println("Contraseña incorrecta. Intenta nuevamente.");
            attempts++;
        }
        return false;
    }

    private static Product createProduct() {
        System.out.print("ID del Producto: ");
        int id = getIntInput("ID del producto: ");
        System.out.print("Nombre del Producto: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Precio: ");
        float price = scanner.nextFloat();
        System.out.print("Peso (en g): ");
        float weight = scanner.nextFloat();
        System.out.print("Cantidad disponible: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return new Product(id, name, price, weight, quantity);
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
            }
        }
    }
}
