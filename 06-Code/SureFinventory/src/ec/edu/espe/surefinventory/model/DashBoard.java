
package ec.edu.espe.surefinventory.model;

import ec.edu.espe.surefinventory.utils.JsonFileManager;
import static java.awt.SystemColor.menu;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Esteban Quiroga 
 */
public class DashBoard {
    int dashBoardOption;
    Scanner scanner = new Scanner(System.in);
    
    public void printLogInDashBoard() {

        System.out.println("====== Login ======");
        System.out.println("1. Ingresar como admin.");
        System.out.println("2. Ingresar como cajero.");
        
        dashBoardOption = scanner.nextInt();
        
        switch(dashBoardOption){
            case 1: {
                if(Manager.logIn()) printManagerDashBoard();
            }
            break;
            
            case 2: {
                Cashier cashier = new Cashier("null", "null");
                
                if(Cashier.logIn(cashier)) printCashierDashBoard(cashier);
            }
            break;
            
            default: System.out.println("Opcion no valida");
            break;
                    
        }
  
    }

    public void printManagerDashBoard() {
               
        System.out.println("====== Bienvenido Manager! ======");
        System.out.println("1. Administrar el Menu.");  
        System.out.println("2. Pedidos.");
        System.out.println("3. Cajeros.");
        System.out.println("4. Contabilidad.");
        System.out.println("5. Salir");
        
        dashBoardOption = scanner.nextInt();

        switch(dashBoardOption){
            case 1: 
        }
    }

    public void printCashierDashBoard(Cashier cashier){
        System.out.println("====== Bienvenido Cajero! ======");
        System.out.println("1. Crear una orden.");
        System.out.println("2. Crear una factura.");
        System.out.println("3. Salir.");
        
        dashBoardOption = scanner.nextInt();
        
        switch(dashBoardOption){
            case 1: {
                Customer customer;
                
                Menu menu = new Menu();
                customer = printCustomerDashBoard();
                
                cashier.takeOrder(customer, menu);
            }            
        }
    }
    

    public void printMenuDashBoard() {

        System.out.println("====== MENU ====== ");
        System.out.println("====== Que vamos a hacer hoy!? ======");
        System.out.println("1. Anadir un plato.");
        System.out.println("2. Ver todo el Menu.");
        System.out.println("3. Salir.");
        System.out.print("Enter your choice: ");
        
        dashBoardOption = scanner.nextInt();
            
    }
    
    public void printAccountingReportDashBoard(){
        System.out.println("====== Contabilidad ======");
        System.out.println("====== Que vamos a hacer hoy!? ======");
        System.out.println("1. Ingresos. ");
        System.out.println("2. Egresos.");
        System.out.println("3. Crear un reporte.");
        System.out.println("4. Salir.");
        
        dashBoardOption = scanner.nextInt();
    }
            
    public void printExpenseDashBoard(){
        System.out.println("====== Egresos ======");
        System.out.println("====== Que vamos a hacer hoy!? ======");
        System.out.println("1. Ver todos los egresos. ");
        System.out.println("2. Agregar un egreso.");
        System.out.println("3. Eliminar un egreso.");
        System.out.println("4. Modificar un egreso.");
        System.out.println("5. Salir");
        
        dashBoardOption = scanner.nextInt();
    }
    
    public void printOrderDashBoard(){
        System.out.println("====== Ordenes ======");
        System.out.println("====== Que vamos a hacer hoy!? ======");
        System.out.println("1. Tomar un pedido.");
        System.out.println("2. Cancelar un pedido.");
        System.out.println("3. Crear una factura.");
        System.out.println("4. Salir");
        
        dashBoardOption = scanner.nextInt();
    }
    
    public void printManageUsersDashBoard(){
        System.out.println("====== Administrador de usuarios ======");
        System.out.println("====== Que vamos a hacer hoy!? ======");
        System.out.println("1. Crear un cajero.");
        System.out.println("2. Cambiar un nombre de usuario.");
        System.out.println("3. Cambiar una contrasena.");
        System.out.println("4. Salir");
        
        dashBoardOption = scanner.nextInt();
    }
    
    public Customer printCustomerDashBoard(){
        
        System.out.println("1. Buscar un cliente por su apellido.");
        System.out.println("2. Agregar un nuevo cliente.");
        System.out.println("3. Borrar un cliente.");
        System.out.println("4. Editar un cliente.");
        System.out.println("5. salir");
        
        dashBoardOption = scanner.nextInt();
        scanner.nextLine();
        
        Customer customer;
        
        switch(dashBoardOption){
            case 1: {
                
                System.out.println("Ingrese el apellido del cliente que quiere buscar.");
                String lastName;
                lastName = scanner.nextLine();
                
                customer = Customer.searchCustomerByLastName(lastName);
                
                
            return customer;
            }
        }
        
        return null;
     
    }

    public int getDashBoardOption() {
        return dashBoardOption;
    }
}
