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
                    printMenuDashBoard(); //TODO
                    break;
                case 2:
                    printOrderDashBoard();  //DONE                    
                    break;
                case 3:
                    printManageUsersDashBoard();  //DONE
                    break;
                case 4:
                    printAccountingReportDashBoard();   //TODO                
                    break;
                case 5:
                    System.out.println("Saliendo del sistema con exito....");
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
                    int id;
                    Path invoicePath = Paths.get("data","invoice.json");
                    JsonFileManager invoiceFileManager = new JsonFileManager(invoicePath);
                    ArrayList<Invoice> invoices = new ArrayList<>();
                    order = cashier.chooseOrder();
                    
                    System.out.println("Ingrese el id de la factura.");
                    id = scanner.nextInt();
                    
                    Invoice invoice = new Invoice(id, order);
                    
                    invoices = invoiceFileManager.decerializeJson(Invoice.class);
                    invoices.add(invoice);
                    invoiceFileManager.updateJsonFile(invoices);
                    
                    System.out.println("Factura creada con exito.");
                    validOption = true;
                    break;


                case 3:
                    printLogInDashBoard();
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
                    System.out.println("Saliendo del sistema con exito....");
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
        Path filePath = Paths.get("data", "order.json");
        JsonFileManager orderFileManager = new JsonFileManager(filePath);
        ArrayList<Order> orders = orderFileManager.decerializeJson(Order.class);

        while (!validOption) {
            System.out.println("====== Ordenes ======");
            System.out.println("1. Tomar un pedido.");
            System.out.println("2. Cancelar un pedido.");
            System.out.println("3. Crear una factura.");
            System.out.println("4. Salir.");

            dashBoardOption = getValidIntInput("Seleccione una opción:");

            switch (dashBoardOption) {
                case 1:
                    Scanner scanner = new Scanner(System.in);
                
                    System.out.print("Ingrese el apellido del cliente: ");
                    String lastName = scanner.nextLine();
                    Customer customer = Customer.searchCustomerByLastName(lastName);

                    Menu menu = new Menu();
                    ArrayList<Dish> selectedDishes = new ArrayList<>();
                    System.out.println("Seleccione los platos para el pedido.");
                    JsonFileManager.printJson(menu.getProductList());

                    int option;
                    do {
                    System.out.print("Seleccione el índice del plato (0 para salir): ");
                    option = scanner.nextInt();

                    if (option != 0) {
                        Dish dish = JsonFileManager.searchObjectByIndex(menu.getProductList(), option);
                        selectedDishes.add(dish);
                    }
                    } while (option != 0);

                    if (!selectedDishes.isEmpty()) {
                    Order order = new Order(selectedDishes.size(), (int) (Math.random() * 10000), selectedDishes, customer);
                    order.saveOrder();
                    System.out.println("Pedido tomado exitosamente: " + order);
                    } else {
                    System.out.println("No se seleccionaron platos. El pedido no se registró.");
                    }
                    validOption = true;
                    break;
                case 2:
                    scanner = new Scanner(System.in);

                    if (orders == null || orders.isEmpty()) {
                    System.out.println("No hay órdenes disponibles para cancelar.");
                    break;
                    }

                    System.out.println("Seleccione la orden a cancelar por ID:");
                    JsonFileManager.printJson(orders);

                    int selectedId = scanner.nextInt();
                    Order orderToCancel = JsonFileManager.searchObjectByIndex(orders, selectedId);

                    if (orderToCancel != null) {
                    orders.remove(orderToCancel);
                    orderFileManager.updateJsonFile(orders);
                    System.out.println("Orden cancelada: " + orderToCancel);
                    } else {
                    System.out.println("Orden no encontrada.");
                    }
                    validOption = true;
                    break;
                case 3:                
                    Path orderFilePath = Paths.get("data", "order.json");
                    if (orders != null && !orders.isEmpty()) {
                    JsonFileManager.printJson(orders);
                    Scanner inputScanner = new Scanner(System.in);
                    System.out.print("Selecciona un pedido (por ID): ");
                    int orderId = inputScanner.nextInt();
                
                    Order selectedOrder = null;
                    for (Order order : orders) {
                     if (order.getId() == orderId) {
                    selectedOrder = order;
                    break;
            }
        }
        
                    if (selectedOrder != null) {
                    Invoice invoice = new Invoice(orders.indexOf(selectedOrder) + 1, selectedOrder);  
                    invoice.saveInvoice(); 
            
                    System.out.println("Factura creada con éxito: " + invoice);
                    } else 
        {
                    System.out.println("No se encontró un pedido con el ID proporcionado.");
              }
                    } else        
        {
                    System.out.println("No hay pedidos disponibles.");
                }
                    validOption = true;
                    break;
                case 4:
                    System.out.println("Saliendo del sistema con exito....");
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
        
        Path filePath = Paths.get("data", "cashier.json");
        JsonFileManager jsonFileManager = new JsonFileManager(filePath);

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
                    System.out.print("Ingrese el nombre de usuario para el nuevo cajero: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Ingrese la contraseña para el nuevo cajero: ");
                    String newPassword = scanner.nextLine();
           
                    Cashier newCashier = new Manager("", "").createCashier(newUsername, newPassword);
                
                    ArrayList<Cashier> cashiers = jsonFileManager.decerializeJson(Cashier.class);
                    if (cashiers == null) {
                    cashiers = new ArrayList<>();
                    }
                    cashiers.add(newCashier);
                    jsonFileManager.updateJsonFile(cashiers);
                    System.out.println("Cajero creado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de usuario del cajero a modificar: ");
                    String usernameToChange = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre de usuario: ");
                    String newUsernameForCashier = scanner.nextLine();
              
                    ArrayList<Cashier> cashiersForUpdate = jsonFileManager.decerializeJson(Cashier.class);
                     if (cashiersForUpdate != null) {
                        for (Cashier cashier : cashiersForUpdate) {
                          if (cashier.getuserName().equals(usernameToChange)) {
                            JsonFileManager.changeAttribute(cashier, "userName", newUsernameForCashier);
                            jsonFileManager.updateJsonFile(cashiersForUpdate);
                            System.out.println("Nombre de usuario cambiado con éxito.");
                            break;
                        }
                    }
                }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de usuario del cajero para cambiar la contraseña: ");
                    String usernameForPasswordChange = scanner.nextLine();
                    System.out.print("Ingrese la nueva contraseña: ");
                    String newPasswordForCashier = scanner.nextLine();
                
                    ArrayList<Cashier> cashiersForPasswordChange = jsonFileManager.decerializeJson(Cashier.class);
                     if (cashiersForPasswordChange != null) {
                        for (Cashier cashier : cashiersForPasswordChange) {
                          if (cashier.getuserName().equals(usernameForPasswordChange)) {
                            JsonFileManager.changeAttribute(cashier, "password", newPasswordForCashier);
                            jsonFileManager.updateJsonFile(cashiersForPasswordChange);
                            System.out.println("Contraseña cambiada con éxito.");
                            break;
                        }
                    }
                }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema con exito....");
                    validOption = true;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    public Customer printCustomerDashBoard() {
        System.out.println("====== Gestion de clientes ======");
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
