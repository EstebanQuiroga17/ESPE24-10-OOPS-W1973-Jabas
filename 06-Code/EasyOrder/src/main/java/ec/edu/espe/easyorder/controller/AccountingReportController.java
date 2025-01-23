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

    public boolean createInvoice(Invoice invoice) {
        Document doc = new Document()
                .append("date", invoice.getDate().getTime())
                .append("price", invoice.getPrice())
                .append("header", invoice.getHeader())
                .append("id", invoice.getId());
        return MongoDbManager.insert("Invoices", doc);
    }

    public boolean createExpense(Expense expense) {
        Document doc = new Document()
                .append("date", expense.getDate().getTime())
                .append("price", expense.getPrice())
                .append("description", expense.getDescription())
                .append("name", expense.getName())
                .append("id", expense.getId());
        return MongoDbManager.insert("Expenses", doc);
    }

    public List<Invoice> readInvoices() {
        List<Document> docs = MongoDbManager.getAll("Invoices");
        List<Invoice> invoices = new ArrayList<>();
        for (Document doc : docs) {
            Invoice invoice = new Invoice(
                    Calendar.getInstance(),
                    doc.getDouble("price").floatValue(),
                    null,
                    doc.getString("header"),
                    doc.getInteger("id")
            );
            invoices.add(invoice);
        }
        return invoices;
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

    public boolean updateInvoice(Invoice updatedInvoice) {
        Document updatedDoc = new Document()
                .append("date", updatedInvoice.getDate().getTime())
                .append("price", updatedInvoice.getPrice())
                .append("header", updatedInvoice.getHeader());
        return MongoDbManager.updateById("Invoices", updatedInvoice.getId(), updatedDoc);
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
    
    public boolean addInvoiceWithConfirmation(String header, Object order, float price, int id) {
       
        boolean isConfirmed = confirmAction("Estas seguro de guardar la informacion?");
        if (isConfirmed) {
            
            Invoice invoice = new Invoice(Calendar.getInstance(), price, (Order) order, header, id);

           
            Document document = new Document()
                    .append("header", header)
                    .append("order", order.toString()) 
                    .append("price", price)
                    .append("id", id)
                    .append("date", Calendar.getInstance().getTime()); 

           
            boolean isInserted = MongoDbManager.insert("Invoices", document);
            if (isInserted) {
                System.out.println("Invoice successfully added.");
                return true;
            } else {
                System.err.println("Error while adding invoice.");
                return false;
            }
        } else {
            System.out.println("Invoice creation canceled.");
            return false;
        }
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
