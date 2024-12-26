
package ec.edu.espe.surefinventory.model;

import ec.edu.espe.surefinventory.utils.JsonFileManager;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author abner
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
        return "Manager{" + "username=" + username +
                ", password=" + password + '}';
        
    }
    
    public void changeMenu(Menu menu){
        System.out.println("El menú ha sido actualizado: " + menu.generateMenuString());
    }
    
      public Order takeOrder(Customer customer, ArrayList<Dish> dishes){
        Order order = new Order(customer, dishes);
        System.out.println("Orden tomada del cliente: " + customer.getName());
        return order;
        
    }
      
      public Cashier createCashier(String username, String password){
        Cashier cashier = new Cashier(username, password);
        System.out.println("Nuevo cajero creado con username: " + username);
        return cashier;    
    }
      
      public static boolean logIn(){
        Path filePath = Paths.get("data","manager.json");
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
      public void cancelOrder(Order order){
        System.out.println("La orden con ID " + order.getId() + " ha sido cancelada.");
    }
      public void addExpense(Expense expense){
        System.out.println("Se ha añadido un gasto: " + expense.toString());
      }
      
      public AccountingReport createAccountingReport(Calendar fromDate, Calendar toDate){
        ArrayList<Invoice> incomes = new ArrayList<>(); 
        ArrayList<Expense> expenses = new ArrayList<>(); 
        incomes.add(new Invoice(1000, fromDate));
        expenses.add(new Expense(500, "Compra de suministros", fromDate, "Suministros", 1));

        AccountingReport report = new AccountingReport(Calendar.getInstance(), incomes, expenses);
        System.out.println("Informe contable creado desde " + fromDate.getTime() + " hasta " + toDate.getTime());
        return report;
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
    public String getUsername() {
        return username;
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
    public void setUsername(String username) {
        this.username = username;
    }
    
    
    

}
