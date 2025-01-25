package ec.edu.espe.easyorder.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Matias Rojas
 */
public class AccountingReport {
    private Calendar creationDate;
    private Calendar beginningDate;
    private Calendar endingDate;
    private ArrayList<Invoice> incomes;
    private ArrayList<Expense> expenses;
    private String name;

    public AccountingReport(Calendar creationDate, Calendar beginningDate, Calendar endingDate, ArrayList<Invoice> incomes, ArrayList<Expense> expenses, String name) {
        this.creationDate = creationDate;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.incomes = incomes;
        this.expenses = expenses;
        this.name = name;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the beginningDate
     */
    public Calendar getBeginningDate() {
        return beginningDate;
    }

    /**
     * @param beginningDate the beginningDate to set
     */
    public void setBeginningDate(Calendar beginningDate) {
        this.beginningDate = beginningDate;
    }

    /**
     * @return the endingDate
     */
    public Calendar getEndingDate() {
        return endingDate;
    }

    /**
     * @param endingDate the endingDate to set
     */
    public void setEndingDate(Calendar endingDate) {
        this.endingDate = endingDate;
    }
    
    
    
    
}
