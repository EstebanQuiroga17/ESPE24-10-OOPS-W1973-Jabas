package ec.edu.espe.easyorder.controller;

import ec.edu.espe.easyorder.model.Customer;
import ec.edu.espe.easyorder.model.Dish;
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
    
    public List<Expense> sortExpensesByDate(Calendar beginningDate, Calendar endingDate){
        List<Expense> sortedExpenses = new ArrayList<>();
        List<Expense> allExpenses = new ArrayList<>();
        List<Document> expenseDocuments = new ArrayList<>();
        Calendar expenseDate;
        
        expenseDocuments = MongoDbManager.getAll("Expenses");
        allExpenses = ExpenseController.docListToExpense(expenseDocuments);
        
        for(Expense expense : allExpenses){
            expenseDate = Calendar.getInstance();
            if(expenseDate.compareTo(endingDate) < 0 && expenseDate.compareTo(beginningDate)>0){
               sortedExpenses.add(expense);
            }
        }
        return sortedExpenses;
    }
      public List<Invoice> getInvoicesByDateRange(Calendar beginningDate, Calendar endingDate) {
        List<Invoice> invoicesInRange = new ArrayList<>();
        List<Document> invoiceDocuments = MongoDbManager.getAll("Invoice");

        for (Document doc : invoiceDocuments) {
            // Recuperar la fecha como long y convertirla a Calendar
            long currentDateMillis = doc.getLong("currentDate");
            Calendar invoiceDate = Calendar.getInstance();
            invoiceDate.setTimeInMillis(currentDateMillis);

            // Verificar si la fecha está dentro del rango
            if (invoiceDate.compareTo(beginningDate) >= 0 && invoiceDate.compareTo(endingDate) <= 0) {
                // Recuperar los demás datos de la factura
                String id = doc.getString("id");
                Document customerDoc = (Document) doc.get("customer");
                Customer customer = new Customer(
                        customerDoc.getString("name"),
                        customerDoc.getInteger("id"),
                        customerDoc.getString("phoneNumber")
                );
               float totalPrice = doc.getDouble("totalPrice").floatValue();
                Document orderDoc = (Document) doc.get("order");
                String orderId = orderDoc.getString("id");
                List<Document> dishDocs = (List<Document>) orderDoc.get("dishes");
                List<Dish> dishes = new ArrayList<>();
                for (Document dishDoc : dishDocs) {
                    dishes.add(new Dish(
                            dishDoc.getString("name"),
                            dishDoc.getDouble("price").floatValue(),
                            dishDoc.getInteger("quantity")
                    ));
                }
                Order order = new Order(dishes.size(), orderId, (ArrayList<Dish>) dishes, invoiceDate);
                String header = doc.getString("header");

                // Crear la factura y agregarla a la lista
                Invoice invoice = new Invoice(customer, order, totalPrice);
                invoice.setCurrentDate(invoiceDate);
                invoice.setHeader(header);
                invoicesInRange.add(invoice);
            }
        }

        return invoicesInRange;
    }

    
}