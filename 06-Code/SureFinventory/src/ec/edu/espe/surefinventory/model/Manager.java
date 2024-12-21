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
    
    public void changeMenu(Menu menu){
        System.out.println("El menú ha sido actualizado: " + menu.toMenuString());
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
    
    public void logIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String inputPassword = scanner.nextLine();

        if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido " + username + ".");
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
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
