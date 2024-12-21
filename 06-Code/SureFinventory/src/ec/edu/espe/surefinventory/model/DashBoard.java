    package ec.edu.espe.surefinventory.model;

import ec.edu.espe.surefinventory.model.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class DashBoard {
    int dashBoardOption;
    Scanner scanner = new Scanner(System.in);
    
    public void printLogInDashBoard() {

        System.out.println("====== Login ======");
        System.out.println("1. Ingresar como admin.");
        System.out.println("2. Ingresar como cajero.");
        
        dashBoardOption = scanner.nextInt();
    }

    public void printManagerDashBoard() {
               
        System.out.println("====== Bienvenido Manager! ======");
        System.out.println("1. Administrar el Menu.");  
        System.out.println("2. Pedidos.");
        System.out.println("3. Cajeros.");
        System.out.println("4. Contabilidad.");
        System.out.println("5. Salir");
        
        dashBoardOption = scanner.nextInt();

    }

    public void printCahierMenu(){
        System.out.println("====== Bienvenido Cajero! ======");
        System.out.println("1. Crear una orden.");
        System.out.println("2. Crear una factura.");
        System.out.println("3. Salir.");
        
        dashBoardOption = scanner.nextInt();
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
        System.out.println("1. Tomar una pedido.");
        System.out.println("2. Cancelar un pedido.");
        System.out.println("3. Crear una factura.");
        System.out.println("4. Salir");
        
        dashBoardOption = scanner.nextInt();
    }
}
