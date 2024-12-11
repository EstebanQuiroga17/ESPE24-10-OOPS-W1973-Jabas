package ec.edu.espe.surefinventory.view;

import ec.edu.espe.surefinventory.model.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class DashBoard {
    private final CashRegister cashRegister;
    private final Map<String, String> userCredentials;
    private final List<MainDish> mainDishes;
    private final List<Order> orders;
    private final List<Invoice> invoices;
    private final List<Cashier> cashiers;

    public DashBoard() {
        this.cashRegister = new CashRegister();
        this.userCredentials = new HashMap<>();
        this.mainDishes = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.invoices = new ArrayList<>();
        this.cashiers = new ArrayList<>();
        userCredentials.put("admin", hashPassword("admin123")); // Default credentials for testing
    }

    public void displayMainMenu() {
        while (!login()) {
            System.out.println("Login failed. Please try again.");
        }

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== Surefinventory Management Dashboard ======");
            System.out.println("1. Manage Menu");
            System.out.println("2. Manage Cash Register");
            System.out.println("3. Manage Cashiers");
            System.out.println("4. Manage Orders and Invoices");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> manageMenu();
                case 2 -> manageCashRegister();
                case 3 -> manageCashiers();
                case 4 -> manageOrdersAndInvoices();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    private boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====== Login ======");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String hashedPassword = hashPassword(password);

        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(hashedPassword)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    private void manageMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== Menu Management ======");
            System.out.println("1. Add Main Dish");
            System.out.println("2. View All Main Dishes");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addMainDish();
                case 2 -> viewAllMainDishes();
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private void addMainDish() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Main Dish ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Main Dish Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Main Dish Price: ");
        double price = scanner.nextDouble();

        MainDish mainDish = new MainDish(id, name, price);
        mainDishes.add(mainDish);
        System.out.println("Main dish added successfully: " + mainDish);
    }

    private void viewAllMainDishes() {
        if (mainDishes.isEmpty()) {
            System.out.println("No main dishes available.");
        } else {
            System.out.println("====== All Main Dishes ======");
            for (MainDish dish : mainDishes) {
                System.out.println(dish);
            }
        }
    }
    private void manageCashRegister() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== Cash Register Management ======");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Generate Balance Report");
            System.out.println("4. View All Incomes");
            System.out.println("5. View All Expenses");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addIncome();
                case 2 -> addExpense();
                case 3 -> generateBalanceReport();
                case 4 -> viewAllIncomes();
                case 5 -> viewAllExpenses();
                case 6 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

        private void addIncome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter income amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter income description: ");
        String description = scanner.nextLine();

        Income income = new Income(amount, description, Calendar.getInstance());
        cashRegister.addIncome(income);
        System.out.println("Income added successfully: " + income);
    }

        private void addExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();

        Expense expense = new Expense(amount, description, Calendar.getInstance());
        cashRegister.addExpense(expense);
        System.out.println("Expense added successfully: " + expense);
    }

        private void generateBalanceReport() {
        Income incomeReport = cashRegister.createIncomeReport();
        Expense expenseReport = cashRegister.createExpenseReport();

        double balance = incomeReport.getAmount() - expenseReport.getAmount();
        System.out.println("====== Balance Report ======");
        System.out.println("Total Income: $" + incomeReport.getAmount());
        System.out.println("Total Expenses: $" + expenseReport.getAmount());
        System.out.println("Net Balance: $" + balance);
    }

        private void viewAllIncomes() {
        List<Income> incomes = cashRegister.getAllIncomes();

        if (incomes.isEmpty()) {
            System.out.println("No incomes recorded.");
        } else {
            System.out.println("====== All Incomes ======");
            for (Income income : incomes) {
                System.out.println(income);
            }
        }
    }

        private void viewAllExpenses() {
        List<Expense> expenses = cashRegister.getAllExpenses();

        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("====== All Expenses ======");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    private void manageCashiers() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== Cashier Management ======");
            System.out.println("1. Add Cashier");
            System.out.println("2. View All Cashiers");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addCashier();
                case 2 -> viewAllCashiers();
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private void addCashier() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Cashier Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Cashier Password: ");
        String password = scanner.nextLine();

        Cashier cashier = new Cashier(username, password);
        cashiers.add(cashier);
        System.out.println("Cashier added successfully: " + username);
    }

    private void viewAllCashiers() {
        if (cashiers.isEmpty()) {
            System.out.println("No cashiers available.");
        } else {
            System.out.println("====== All Cashiers ======");
            for (Cashier cashier : cashiers) {
                System.out.println("Username: " + cashier.getUsername());
            }
        }
    }

   

    private void manageOrdersAndInvoices() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== Orders and Invoices Management ======");
            System.out.println("1. Create Order");
            System.out.println("2. Create Invoice");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createOrder();
                case 2 -> createInvoice();
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private void createOrder() {
        Scanner scanner = new Scanner(System.in);
        List<MainDish> dishesInOrder = new ArrayList<>();

        System.out.println("Enter dishes for the order:");
        String choice;
        do {
            System.out.print("Enter Main Dish ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Main Dish Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Main Dish Price: ");
            double price = scanner.nextDouble();

            MainDish dish = new MainDish(id, name, price);
            dishesInOrder.add(dish);
            System.out.print("Add another dish? (yes/no): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("yes"));

        double totalPrice = dishesInOrder.stream().mapToDouble(MainDish::getPrice).sum();
        int itemCount = dishesInOrder.size();
        Order order = new Order(totalPrice, itemCount, orders.size() + 1, dishesInOrder, Calendar.getInstance());

        orders.add(order);
        System.out.println("Order created successfully!");
        order.printOrder();
    }

   private void createInvoice() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter Customer ID: ");
    int customerId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Customer Name: ");
    String customerName = scanner.nextLine();
    System.out.print("Enter Customer Phone Number: ");
    int phoneNumber = scanner.nextInt();

    Customer customer = new Customer(customerId, customerName, phoneNumber);

    System.out.println("Select an order for the invoice:");
    for (Order order : orders) {
        System.out.println("Order ID: " + order.getId());
        order.printOrder();
    }
    System.out.print("Enter Order ID: ");
    int orderId = scanner.nextInt();

    Order selectedOrder = orders.stream().filter(o -> o.getId() == orderId).findFirst().orElse(null);

    if (selectedOrder == null) {
        System.out.println("Invalid Order ID.");
        return;
    }

    System.out.print("Enter Payment Method: ");
    scanner.nextLine();
    String paymentMethod = scanner.nextLine();

    // Set IVA to 0 (no tax)
    double iva = 0.0;
    double total = selectedOrder.getTotalPrice() + iva;

    Invoice invoice = new Invoice(customer, paymentMethod, invoices.size() + 1, selectedOrder);
    invoice.setIva(iva);  // Set IVA to 0
    invoice.setTotal(total);

    invoices.add(invoice);
    System.out.println("Invoice created successfully!");
    invoice.printInvoice();
}


    public static void main(String[] args) {
        DashBoard dashboard = new DashBoard();
        dashboard.displayMainMenu();
    }
}
