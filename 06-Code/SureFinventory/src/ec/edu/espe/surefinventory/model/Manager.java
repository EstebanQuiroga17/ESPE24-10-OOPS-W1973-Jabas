package ec.edu.espe.surefinventory.model;

import java.util.Scanner;
import ec.edu.espe.surefinventory.utils.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Matias Rojas
 */
public class Manager {
    private String username;
    private String password;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    @Override
    public String toString() {
        return "Manager{" + "username=" + username + ", password=" + password + '}';
    }
    
    public void chanMenu(Menu menu){
        //TODO code method
    }
    
    public Order takeOrder(Customer customer, ArrayList<Dish> dishes){
      //TODO code method 
        Order order = null;      
        return order;
        
    }
    
    public Cashier createCashier(String username, String password){
       //TODO code method
        Cashier cashier = null;       
        return cashier;      
    }
    
    public void logIn(){
        //TODO code method
    }
    
    public void cancelOrder(Order order){
        //TODO code method
    }
    
    public void addExpense(){
        //TODO code method
    }
    
    public AccountingReport createAccountingReport(Calendar fromDate, Calendar toDate){
        //TODO code method
        return null;
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
