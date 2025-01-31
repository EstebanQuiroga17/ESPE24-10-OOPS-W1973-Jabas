package ec.edu.espe.easyorder.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Matias Rojas
 */
public class AccountingReport {
    private Calendar creationDate;
    private Calendar beginningDate;
    private Calendar endingDate;
    private List<Invoice> incomes;
    private List<Expense> expenses;
    private String name;

    public AccountingReport(Calendar creationDate, Calendar beginningDate, Calendar endingDate, List<Invoice> incomes, List<Expense> expenses, String name) {
        this.creationDate = creationDate;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.incomes = incomes;
        this.expenses = expenses;
        this.name = name;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Calendar getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Calendar beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Calendar getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Calendar endingDate) {
        this.endingDate = endingDate;
    }

    public List<Invoice> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Invoice> incomes) {
        this.incomes = incomes;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
