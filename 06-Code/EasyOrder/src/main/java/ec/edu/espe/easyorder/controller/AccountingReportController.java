package ec.edu.espe.easyorder.controller;

import ec.edu.espe.easyorder.model.Expense;
import ec.edu.espe.easyorder.model.Invoice;
import org.bson.Document;
import utils.MongoDbManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * Author Matias Rojas
 */

public class AccountingReportController {

   public List<Expense> getExpensesByDate(Calendar beginningDate, Calendar endingDate){
       List<Document> expensesDoc = new ArrayList<>();
       List<Expense> expenses = new ArrayList<>();
       List<Expense> sortedExpenses = new ArrayList<>();
       
       expensesDoc = MongoDbManager.getAll("Expenses");
       expenses = MongoDbManager.getAllObjects(expensesDoc, Expense.class);
       
       for(Expense expense : expenses){
           Calendar expenseDate;
           expenseDate = expense.getDate();
           if(expenseDate.before(endingDate) && expenseDate.after(beginningDate)){
               sortedExpenses.add(expense);
            }
        }
        return sortedExpenses;  
    }
   
   public List<Invoice> getInvoicesByDate(Calendar beginningDate, Calendar endingDate){
       List<Document> invoicesDoc = new ArrayList<>();
       List<Invoice> invoices = new ArrayList<>();
       List<Invoice> sortedInvoices = new ArrayList<>();
       
       invoicesDoc = MongoDbManager.getAll("Invoice");
       invoices = MongoDbManager.getAllObjects(invoicesDoc, Invoice.class);
       
       for(Invoice invoice : invoices){
           Calendar expenseDate;
           expenseDate = invoice.getCurrentDate();
           if(expenseDate.before(endingDate) && expenseDate.after(beginningDate)){
               sortedInvoices.add(invoice);
            }
        }
        return sortedInvoices;  
    }
   
}