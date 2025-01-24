package ec.edu.espe.easyorder.controller;

import ec.edu.espe.easyorder.model.Expense;
import ec.edu.espe.easyorder.model.Invoice;
import ec.edu.espe.easyorder.model.Order;
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

   

    public boolean createExpense(Expense expense) {
        Document doc = new Document()
                .append("date", expense.getDate().getTime())
                .append("price", expense.getPrice())
                .append("description", expense.getDescription())
                .append("name", expense.getName())
                .append("id", expense.getId());
        return MongoDbManager.insert("Expenses", doc);
    }

    

    public List<Expense> readExpenses() {
        List<Document> docs = MongoDbManager.getAll("Expenses");
        List<Expense> expenses = new ArrayList<>();
        for (Document doc : docs) {
            Expense expense = new Expense(
                    doc.getDouble("price").floatValue(),
                    doc.getString("description"),
                    doc.getString("name"),
                    Calendar.getInstance(),
                    doc.getInteger("id")
            );
            expenses.add(expense);
        }
        return expenses;
    }

    

    public boolean updateExpense(Expense updatedExpense) {
        Document updatedDoc = new Document()
                .append("date", updatedExpense.getDate().getTime())
                .append("price", updatedExpense.getPrice())
                .append("description", updatedExpense.getDescription())
                .append("name", updatedExpense.getName());
        return MongoDbManager.updateById("Expenses", updatedExpense.getId(), updatedDoc);
    }

    public boolean deleteInvoice(int id) {
        return MongoDbManager.deleteById("Invoices", id);
    }

    public boolean deleteExpense(int id) {
        return MongoDbManager.deleteById("Expenses", id);
    }
    
  

     public boolean deleteInvoiceWithConfirmation(int id) {
        boolean isConfirmed = confirmAction("Estas seguroo de borrar el ingreso que tiene como ID: " + id + "?");
        if (isConfirmed) {
            boolean isDeleted = MongoDbManager.deleteDocumentById("Invoices", id);

            if (isDeleted) {
                System.out.println("Ingreso eliminado.");
                return true;
            } else {
                System.err.println("Error: Ingreso con ID:" + id + " no se encuentra.");
                return false;
            }
        } else {
            System.out.println("Eliminacion de ingreso ha sido cancelada.");
            return false;
        }
    }

    private boolean confirmAction(String message) {
        System.out.println(message);
        System.out.println("Ingresa 'si' para confirmar o 'no' para cancelar:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("si");
    }
    
}
