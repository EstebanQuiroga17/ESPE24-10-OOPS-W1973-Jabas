

package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Income> incomes;
    private List<Expense> expenses;
    private String filePath; // New attribute for file path

    public TransactionManager() {
        this.incomes = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.filePath = "transactions.json"; // Default file path
    }

    /**
     * Constructor with file path.
     *
     * @param filePath Path where the JSON file will be saved/loaded.
     */
    public TransactionManager(String filePath) {
        this.incomes = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.filePath = filePath;
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public double calculateTotalIncome() {
        return incomes.stream().mapToDouble(Income::getAmount).sum();
    }

    public double calculateTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double calculateNetBalance() {
        return calculateTotalIncome() - calculateTotalExpenses();
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    /**
     * Sets the file path for saving/loading JSON data.
     *
     * @param filePath The file path to use.
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Gets the current file path.
     *
     * @return The file path being used.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Saves the incomes and expenses to a JSON file.
     */
    public void saveToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(this, writer);
            System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    /**
     * Loads the incomes and expenses from a JSON file.
     */
    public void loadFromFile() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(filePath)) {
            TransactionManager loadedData = gson.fromJson(reader, TransactionManager.class);
            this.incomes = loadedData.incomes;
            this.expenses = loadedData.expenses;
            System.out.println("Data loaded from " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("File not found at " + filePath + ". Starting with empty data.");
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }
}
