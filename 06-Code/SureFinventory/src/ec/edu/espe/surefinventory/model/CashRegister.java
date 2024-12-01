package ec.edu.espe.surefinventory.model;

import java.time.LocalDate;

/**
 *
 * @author Esteban Quiroga
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CashRegister {
    private LocalDate date;
    private List<Invoice> invoiceList; // To store invoices
    private TransactionManager transactionManager; // To manage incomes and expenses

    public CashRegister() {
        this.date = LocalDate.now();
        this.invoiceList = new ArrayList<>();
        this.transactionManager = new TransactionManager();
    }

    /**
     * Adds a new income to the cash register.
     *
     * @param income The income to add.
     */
    public void addIncome(Income income) {
        transactionManager.addIncome(income);
        System.out.println("Income added: " + income);
    }

    /**
     * Adds a new expense to the cash register.
     *
     * @param expense The expense to add.
     */
    public void addExpense(Expense expense) {
        transactionManager.addExpense(expense);
        System.out.println("Expense added: " + expense);
    }

    /**
     * Generates an income report by summing up all incomes.
     *
     * @return An Income object representing the total income report.
     */
    public Income createIncomeReport() {
        double totalIncome = transactionManager.calculateTotalIncome();
        return new Income(totalIncome, "Income Report", LocalDate.now());
    }

    /**
     * Generates an expense report by summing up all expenses.
     *
     * @return An Expense object representing the total expense report.
     */
    public Expense createExpenseReport() {
        double totalExpenses = transactionManager.calculateTotalExpenses();
        return new Expense(totalExpenses, "Expense Report", LocalDate.now());
    }

    public List<Income> getAllIncomes() {
        return transactionManager.getIncomes();
    }

    public List<Expense> getAllExpenses() {
        return transactionManager.getExpenses();
    }

    /**
     * Adds an invoice to the cash register.
     *
     * @param invoice The invoice to add.
     */
    public void addInvoice(Invoice invoice) {
        invoiceList.add(invoice);
        System.out.println("Invoice added: " + invoice);
    }

    public List<Invoice> getInvoices() {
        return invoiceList;
    }
}
