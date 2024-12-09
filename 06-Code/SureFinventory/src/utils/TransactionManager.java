
package utils;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */

import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Expense;
import ec.edu.espe.surefinventory.model.Income;

import java.lang.reflect.Type;
import java.util.List;

public class TransactionManager {
    private static final String INCOME_FILE_PATH = "data/incomes.json";
    private static final String EXPENSE_FILE_PATH = "data/expenses.json";

    private static final Type INCOME_LIST_TYPE = new TypeToken<List<Income>>() {}.getType();
    private static final Type EXPENSE_LIST_TYPE = new TypeToken<List<Expense>>() {}.getType();

    private final MainDataManager<Income> incomeManager;
    private final MainDataManager<Expense> expenseManager;

    public TransactionManager() {
        this.incomeManager = new MainDataManager<>(INCOME_FILE_PATH, INCOME_LIST_TYPE);
        this.expenseManager = new MainDataManager<>(EXPENSE_FILE_PATH, EXPENSE_LIST_TYPE);
    }

    public void addIncome(Income income) {
        incomeManager.addItem(income);
        System.out.println("Income added successfully: " + income);
    }

    public void addExpense(Expense expense) {
        expenseManager.addItem(expense);
        System.out.println("Expense added successfully: " + expense);
    }

    public double calculateTotalIncome() {
        return incomeManager.getItems().stream().mapToDouble(Income::getAmount).sum();
    }

    public double calculateTotalExpenses() {
        return expenseManager.getItems().stream().mapToDouble(Expense::getAmount).sum();
    }

    public List<Income> getIncomes() {
        return incomeManager.getItems();
    }

    public List<Expense> getExpenses() {
        return expenseManager.getItems();
    }
}
