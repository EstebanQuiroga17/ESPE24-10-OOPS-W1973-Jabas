
package ec.edu.espe.sureinveoryapp.model;

import ec.edu.espe.sureinveoryapp.utils.JsonFileManager;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author abner
 */
public class Cashier {
    private String userName;
    private String password;


    public Cashier(String username, String password) {
        this.userName = username;
        this.password = password;    
    }

    @Override
    public String toString() {
        return "Cashier{" + "userName=" + userName + ", password=" + password + '}';
    }


    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the username
     */
    public String getuserName() {
        return userName;
    }


    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param username the username to set
     */
    public void setuserName(String username) {
        this.userName = username;
    }
    
    public static boolean logIn(Cashier cashier){
        
        Path filePath  = Paths.get("data","cashier.json");
        
        JsonFileManager jsonFileManager = new JsonFileManager(filePath);
        
        ArrayList<Cashier> cashiers = jsonFileManager.decerializeJson(Cashier.class);
        
        if (cashiers == null || cashiers.isEmpty()) {
            System.out.println(" No existe ningun usuario. ");
            return false;
        }
        
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingresa tu nombre de usuario: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Ingresa tu contrasena: ");
            String inputPassword = scanner.nextLine();

            for (Cashier cashierUser : cashiers) {
                if (cashierUser.getuserName().equals(inputUsername) && cashierUser.getPassword().equals(inputPassword)) {
                    System.out.println("¡Qué bueno verte, " + inputUsername + "!");
                    cashier.setuserName(inputUsername);
                    cashier.setPassword(inputPassword);
                    return true;
                }
            }

            System.out.println("Algo anda mal! --> Revisa tu usuario o contrasena.");
        }
    }
    
    public Order takeOrder(Customer customer, Menu menu){
        
        DashBoard dashBoard = new DashBoard();         
        ArrayList<Dish> dishes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Selecciona un plato por su indice.");
        JsonFileManager.printJson(menu.getProductList());              
        
        int option = scanner.nextInt();
        
        do{
        Dish dish;
        dish = JsonFileManager.searchObjectByIndex(menu.getProductList(), option);
        dishes.add(dish);
        
        
        System.out.println("Agrega otro producto.");
        System.out.println("O pulsa 0 para salir.");
        
        option = scanner.nextInt();
        
        }while(option != 0);
        
        int orderId;
        System.out.println("Ingrese un numero para esta orden.");
        orderId = scanner.nextInt();
        Order order =  new Order(dishes.size(), orderId, dishes, customer);
        
    public static Order chooseOrder(ArrayList<Order> orders) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una orden por su ID:");
        for (Order order : orders) {
            System.out.println(order);
    }

        int selectedId = scanner.nextInt();
        for (Order order : orders) {
        if (order.getId() == selectedId) {
            return order;
        }
    }
         System.out.println("Orden no encontrada.");
         return null;
    }   
        
        return order;
    }

public static void createAndSaveInvoice(Order order) {
    if (order == null) {
        System.out.println("No se puede crear una factura para una orden nula.");
        return;
    }
    
    Invoice invoice = new Invoice("Factura Generada", order.getId(), order);
    saveInvoiceToJson(invoice);
}

public static void saveInvoiceToJson(Invoice invoice) {
    Path filePath = Paths.get("data", "invoice.json");
    JsonFileManager jsonFileManager = new JsonFileManager(filePath);
    ArrayList<Invoice> invoices = jsonFileManager.decerializeJson(Invoice.class);

    if (invoices == null) {
        invoices = new ArrayList<>();
    }

    invoices.add(invoice);
    jsonFileManager.updateJsonFile(invoices);
    System.out.println("Factura guardada exitosamente.");
}
        

 }

