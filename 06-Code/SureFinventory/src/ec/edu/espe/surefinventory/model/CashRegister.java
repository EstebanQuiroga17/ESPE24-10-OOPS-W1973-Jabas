package ec.edu.espe.surefinventory.model;

import utils.TransactionManager;
import utils.InvoiceManager;
import java.util.Calendar;
import java.util.List;

public class CashRegister {
    private Calendar date;
    private final TransactionManager transactionManager;
    private final InvoiceManager invoiceManager;

    public CashRegister() {
        this.date = Calendar.getInstance();
        this.transactionManager = new TransactionManager();
        this.invoiceManager = new InvoiceManager();
    }

    public void addIncome(Income income) {
        transactionManager.addIncome(income);
    }

    public void addExpense(Expense expense) {
        transactionManager.addExpense(expense);
    }

    public Income createIncomeReport() {
        double totalIncome = transactionManager.calculateTotalIncome();
        return new Income(totalIncome, "Income Report", Calendar.getInstance());
    }

    public Expense createExpenseReport() {
        double totalExpenses = transactionManager.calculateTotalExpenses();
        return new Expense(totalExpenses, "Expense Report", Calendar.getInstance());
    }

    public List<Income> getAllIncomes() {
        return transactionManager.getIncomes();
    }

    public List<Expense> getAllExpenses() {
        return transactionManager.getExpenses();
    }

    public void addInvoice(Invoice invoice) {
        invoiceManager.getInvoiceManager().addItem(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoiceManager.getInvoiceManager().getItems();
    }
}