package ec.edu.espe.surefinventory.model;

import ec.edu.espe.surefinventory.model.Customer;
import ec.edu.espe.surefinventory.model.DashBoard;
import ec.edu.espe.surefinventory.model.Dish;
import ec.edu.espe.surefinventory.model.Invoice;
import ec.edu.espe.surefinventory.model.Menu;
import ec.edu.espe.surefinventory.model.Order;
import ec.edu.espe.surefinventory.utils.JsonFileManager;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author abner
 */
public class Cashier {

    private String userName;
    private String password;

    public Cashier(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cashier{" + "userName=" + userName + ", password=" + password + '}';
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

    public static boolean logIn(Cashier cashier) {

        Path filePath = Paths.get("data", "cashier.json");

        JsonFileManager jsonFileManager = new JsonFileManager(filePath);

        ArrayList<Cashier> cashiers = jsonFileManager.decerializeJson(Cashier.class);

        if (cashiers == null || cashiers.isEmpty()) {
            System.out.println(" No existe ningun usuario. ");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingresa tu nombre de usuario: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Ingresa tu contrasena: ");
            String inputPassword = scanner.nextLine();

            for (Cashier cashierUser : cashiers) {
                if (cashierUser.getuserName().equals(inputUsername) && cashierUser.getPassword().equals(inputPassword)) {
                    System.out.println("¡Qué bueno verte, " + inputUsername + "!");
                    cashier.setuserName(inputUsername);
                    cashier.setPassword(inputPassword);
                    return true;
                }
            }

            System.out.println("Algo anda mal! --> Revisa tu usuario o contrasena.");
        }
    }

    public Order takeOrder(Customer customer, Menu menu) {

        DashBoard dashBoard = new DashBoard();
        ArrayList<Dish> dishes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona un plato por su indice.");
        JsonFileManager.printJson(menu.getProductList());

        int option = scanner.nextInt();

        do {
            Dish dish;
            dish = JsonFileManager.searchObjectByIndex(menu.getProductList(), option);
            dishes.add(dish);

            System.out.println("Agrega otro producto.");
            System.out.println("O pulsa 0 para salir.");

            option = scanner.nextInt();

        } while (option != 0);

        int orderId;
        System.out.println("Ingrese un numero para esta orden.");
        orderId = scanner.nextInt();
        Order order = new Order(dishes.size(), orderId, dishes, customer);
        
        return order;
    }

    public Order chooseOrder() {

        Path filePath = Paths.get("data", "order.json");
        JsonFileManager orderFileManager = new JsonFileManager(filePath);
        ArrayList<Order> orders = orderFileManager.decerializeJson(Order.class);
        Order order;

        if (orders == null || orders.isEmpty()) {
            System.out.println("No hay órdenes disponibles.");
            return null;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una orden por su ID:");

        JsonFileManager.printJson(orders);

        int selectedId = scanner.nextInt();

        order = JsonFileManager.searchObjectByIndex(orders, selectedId);

        return order;
    }

    
    public void saveInvoiceToJson(Invoice invoice) {
        Path filePath = Paths.get("data", "invoice.json");
        JsonFileManager jsonFileManager = new JsonFileManager(filePath);
        ArrayList<Invoice> invoices = jsonFileManager.decerializeJson(Invoice.class);

        invoices.add(invoice);
        jsonFileManager.updateJsonFile(invoices);
        System.out.println("Factura guardada exitosamente.");
    }
    
}
    
