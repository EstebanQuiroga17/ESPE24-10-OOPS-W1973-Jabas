package ec.edu.espe.surefinventory.model;

import java.util.Scanner;
import ec.edu.espe.surefinventory.utils.*;

/**
 *
 * @author Esteban Quiroga
 */
public class Manager {
    private String username;
    private String password;

       @Override
    public String toString() {
        return String.format(
        "%-20s | %-20s | %-20s%n" +
        "--------------------------------------------------%n" +
        "%-20s | %-20s",
        "Username", "Password", 
        username, password +
                "\n"
    );
}

    
    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
  
    
    public void createCashier(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre de usuario.");
            String newUsername = scanner.nextLine();
        
        System.out.println("Ingrese una contrasena.");
            String newPassword = scanner.nextLine();
        
        Cashier cashier = new Cashier(username, password);
        
        
        
        System.out.println(cashier +"Creado con exito");
        
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
