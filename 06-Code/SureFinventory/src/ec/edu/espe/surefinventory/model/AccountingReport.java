
package ec.edu.espe.surefinventory.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Matias Rojas
 */
public class AccountingReport {
    private Calendar creationDate;
    private ArrayList<Invoice> incomes;
    private ArrayList<Expense> expenses;

    public AccountingReport(Calendar creationDate, ArrayList<Invoice> incomes, ArrayList<Expense> expenses) {
        this.creationDate = creationDate;
        this.incomes = incomes;
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "AccountingReport{" + "creationDate=" + creationDate 
                + ", incomes=" + incomes + ", expenses=" + expenses + '}';
    }
    
    

    /**
     * @return the creationDate
     */
    public Calendar getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the incomes
     */
    public ArrayList<Invoice> getIncomes() {
        return incomes;
    }

    /**
     * @param incomes the incomes to set
     */
    public void setIncomes(ArrayList<Invoice> incomes) {
        this.incomes = incomes;
    }

    /**
     * @return the expenses
     */
    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    /**
     * @param expenses the expenses to set
     */
    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }
    
}
