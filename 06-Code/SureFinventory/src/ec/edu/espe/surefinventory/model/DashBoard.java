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

    public int getValidIntInput(String prompt) {
        int input = -1;
        while (true) {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Entrada no valida. Por favor, intente otra vez");
            }
        }

        return input;
    }

    public void printLogInDashBoard() {
        boolean validOption = false;

        while (!validOption) {
            System.out.println("====== Login ======");
            System.out.println("1. Ingresar como admin.");
            System.out.println("2. Ingresar como cajero.");

            dashBoardOption = getValidIntInput("Seleccione una opcion:");

            switch (dashBoardOption) {
                case 1:
                    if (Manager.logIn()) {
                        printManagerDashBoard();
                    }
                    validOption = true;
                    break;

                case 2:
                    Cashier cashier = new Cashier("", "");
                    if (Cashier.logIn(cashier)) {
                        printCashierDashBoard(cashier);
                    }
                    validOption = true;
                    break;

                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public void printManagerDashBoard() {
        boolean validOption = false;

        while (!validOption) {
            System.out.println("====== Bienvenido Manager! ======");
            System.out.println("1. Administrar el Menu.");
            System.out.println("2. Pedidos.");
            System.out.println("3. Cajeros.");
            System.out.println("4. Contabilidad.");
            System.out.println("5. Salir");

            dashBoardOption = getValidIntInput("Seleccione una opcion:");

            switch (dashBoardOption) {
                case 1:
                    validOption = true;
                    break;
                case 2:
                    validOption = true;
                    break;
                case 3:
                    validOption = true;
                    break;
                case 4:
                    validOption = true;
                    break;
                case 5:
                    validOption = true;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public void printCashierDashBoard(Cashier cashier) {
        boolean validOption = false;

        while (!validOption) {
            System.out.println("====== Bienvenido Cajero! ======");
            System.out.println("1. Crear una orden.");
            System.out.println("2. Crear una factura.");
            System.out.println("3. Salir.");

            dashBoardOption = getValidIntInput("Seleccione una opcion:");

            switch (dashBoardOption) {
                case 1:
                    Customer customer;
                    Order order;

                    Menu menu = new Menu();
                    customer = printCustomerDashBoard();

                    order = cashier.takeOrder(customer, menu);
                    order.saveOrder();

                    System.out.println("Orden creada con exito.");
                    System.out.println("Crea una factura cuando sea pagada.");
                    validOption = true;
                    break;

                case 2:
                    validOption = true;
                    break;

                case 3:
                    validOption = true;
                    break;

                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public void printMenuDashBoard() {
        boolean validOption = false;

        while (!validOption) {
            System.out.println("====== MENU ====== ");
            System.out.println("1. Anadir un plato.");
            System.out.println("2. Ver todo el Menu.");
            System.out.println("3. Salir.");
            System.out.print("Ingrese su opción: ");

            dashBoardOption = getValidIntInput("Seleccione una opción:");

            switch (dashBoardOption) {
                case 1:
                    validOption = true;
                    break;
                case 2:
                    validOption = true;
                    break;
                case 3:
                    validOption = true;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public void printAccountingReportDashBoard() {
        boolean validOption = false;

        while (!validOption) {
            System.out.println("====== Contabilidad ======");
            System.out.println("1. Ingresos.");
            System.out.println("2. Egresos.");
            System.out.println("3. Crear un reporte.");
            System.out.println("4. Salir.");

            dashBoardOption = getValidIntInput("Seleccione una opción:");

            switch (dashBoardOption) {
                case 1:
                    validOption = true;
                    break;
                case 2:
                    validOption = true;
                    break;
                case 3:
                    validOption = true;
                    break;
                case 4:
                    validOption = true;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public void printExpenseDashBoard() {
        boolean validOption = false;

        while (!validOption) {
            System.out.println("====== Egresos ======");
            System.out.println("1. Ver todos los egresos.");
            System.out.println("2. Agregar un egreso.");
            System.out.println("3. Eliminar un egreso.");
            System.out.println("4. Modificar un egreso.");
            System.out.println("5. Salir.");

            dashBoardOption = getValidIntInput("Seleccione una opción:");

            switch (dashBoardOption) {
                case 1:
                    validOption = true;
                    break;
                case 2:
                    validOption = true;
                    break;
                case 3:
                    validOption = true;
                    break;
                case 4:
                    validOption = true;
                    break;
                case 5:
                    validOption = true;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public void printOrderDashBoard() {
        boolean validOption = false;

        while (!validOption) {
            System.out.println("====== Ordenes ======");
            System.out.println("1. Tomar un pedido.");
            System.out.println("2. Cancelar un pedido.");
            System.out.println("3. Crear una factura.");
            System.out.println("4. Salir.");

            dashBoardOption = getValidIntInput("Seleccione una opción:");

            switch (dashBoardOption) {
                case 1:
                    validOption = true;
                    break;
                case 2:
                    validOption = true;
                    break;
                case 3:
                    validOption = true;
                    break;
                case 4:
                    validOption = true;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public void printManageUsersDashBoard() {
        boolean validOption = false;

        while (!validOption) {
            System.out.println("====== Administrador de usuarios ======");
            System.out.println("====== Que vamos a hacer hoy!? ======");
            System.out.println("1. Crear un cajero.");
            System.out.println("2. Cambiar un nombre de usuario.");
            System.out.println("3. Cambiar una contrasena.");
            System.out.println("4. Salir.");

            dashBoardOption = getValidIntInput("Seleccione una opción:");

            switch (dashBoardOption) {
                case 1:
                    validOption = true;
                    break;
                case 2:
                    validOption = true;
                    break;
                case 3:
                    validOption = true;
                    break;
                case 4:
                    validOption = true;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public Customer printCustomerDashBoard() {
        System.out.println("1. Buscar un cliente por su apellido.");
        System.out.println("2. Agregar un nuevo cliente.");
        System.out.println("3. Borrar un cliente.");
        System.out.println("4. Editar un cliente.");
        System.out.println("5. salir");

        dashBoardOption = getValidIntInput("Seleccione una opción:");

        Customer customer = null;

        switch(dashBoardOption) {
            case 1:
                System.out.println("Ingrese el apellido del cliente que quiere buscar.");
                String lastName = scanner.nextLine();
                customer = Customer.searchCustomerByLastName(lastName);
                break;
            default:
                break;
        }

        return customer;
    }

    public int getDashBoardOption() {
        return dashBoardOption;
    }
}
