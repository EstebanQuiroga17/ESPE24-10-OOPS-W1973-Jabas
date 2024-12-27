
package ec.edu.espe.surefinventory.model;

import ec.edu.espe.surefinventory.utils.JsonFileManager;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import ec.edu.espe.surefinventory.model.Menu;


/**
 *
 * @author abner
 */
public class Cashier {
    private String userName;
    private String password;
    private int id;

    public Cashier(String username, String password, int id) {
        this.userName = username;
        this.password = password;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-10s%n" +
            "---------------------------------%n" +
            "%-10d | %-15s | %-10s",
            "ID", "Username", "Password",
            id, userName, password,
            "\n"
        );
    }
       
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
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
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
    
    public static boolean logIn(){
        
        Path filePath = Paths.get("data","cashier.json");
        
        JsonFileManager jsonFileManager = new JsonFileManager(filePath);
        
        ArrayList<Cashier> cashiers = jsonFileManager.decerializeJson(Cashier.class);
        
        if (cashiers == null || cashiers.isEmpty()) {
            System.out.println(" There is no data in the JSON file ");
            return false;
        }
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String inputPassword = scanner.nextLine();
        
        for (Cashier cashier : cashiers) {
            
            if (cashier.getuserName().equals(inputUsername) && cashier.getPassword().equals(inputPassword)) {
                System.out.println("Login successful. WELCOME! " + inputUsername + "!");
                return true;
            }
        }
        
        System.out.println("INCORRECT ---> check username and password");
        return false;
    }
    
    public Order takeOrder(Customer customer, Menu menu){
        
        ArrayList<Dish> dishes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        menu.showMenu();
        
        System.out.println("Selecciona un plato por su indice.");
        int option = scanner.nextInt();
        
        Dish dish;
        dish = JsonFileManager.searchObjectByIndex(menu.getProductList(), option);
        dishes.add(dish);
        
        
        System.out.println("Agrega otro producto.");
        System.out.println("O pulsa 0 para salir.");
        
        while(option != 0){
            
        option = scanner.nextInt();
        dish = JsonFileManager.searchObjectByIndex(menu.getProductList(), option);
        dishes.add(dish);
        }
        
        int orderId;
        System.out.println("Ingrese un numero para esta orden.");
        orderId = scanner.nextInt();
        Order order =  new Order(dishes.size(), orderId, dishes, customer);
        return order;
    }

}
