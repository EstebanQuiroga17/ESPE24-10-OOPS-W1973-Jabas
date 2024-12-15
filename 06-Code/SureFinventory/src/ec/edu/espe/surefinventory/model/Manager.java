package ec.edu.espe.surefinventory.model;

import java.util.Scanner;
import ec.edu.espe.surefinventory.utils.AdminDataManager;

/**
 *
 * @author Esteban Quiroga
 */
public class Manager {
    private String username;
    private String password;

    
    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
    public void changeInventory(Inventory inventory){
        //TODO code method
    }
    
    public void createCashier(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre de usuario.");
            String newUsername = scanner.nextLine();
        
        System.out.println("Ingrese una contrasena.");
            String newPassword = scanner.nextLine();
        
        Cashier cashier = new Cashier(username, password);
        
        AdminDataManager.addCashier(cashier);
        
        System.out.println(cashier +"Creado con exito");
        
    }
    
    public void updateInventory(Inventory inventory){
        //TODO code method
    }
    
    public void closeCashRegister(){
        //TODO code method
    }
    
    public void editMenu(Menu menu){
        //TODO code method
        
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
   
}
