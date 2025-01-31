package ec.edu.espe.easyorder.controller;

import com.google.gson.Gson;
import ec.edu.espe.easyorder.model.Expense;
import java.text.SimpleDateFormat;
import org.bson.Document;
import utils.MongoDbManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Matias Rojas
 */

public class ExpenseController {
    
    public static Expense docToExpense(Document doc){
        String json = doc.toJson();
        double doublePrice = doc.getDouble("price");
        float price = (float) doublePrice;
        String description = doc.getString("description");
        String name = doc.getString("name");
        Calendar date = MongoDbManager.descerializeDate(doc);
        int id = doc.getInteger("id");
        
        Expense expense = new Expense(price, description, name, date, id);
        return expense;
    }
    
    public static List<Expense> docListToExpense(List<Document> docs){
        List<Expense> expenses = new ArrayList<>();
        Expense expense;
        for(Document doc : docs){
            expense = ExpenseController.docToExpense(doc);
            expenses.add(expense);
        }
        return expenses;
    }
    public boolean addExpense(Expense expense) {
    try {
        String json;
        Gson gson = new Gson();
        Document doc;
        boolean success;
        
        json = gson.toJson(expense);
        doc = Document.parse(json);
        success = MongoDbManager.insert("Expenses", doc);
        
        return success;
    } catch (Exception e) {
        System.err.println("Error : " + e.getMessage());
        return false;
    }
}


public List<Expense> getAllExpenses() {
    List<Expense> expenses = new ArrayList<>();
    try {
        List<Document> documents = MongoDbManager.getAll("Expenses");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 

        for (Document doc : documents) {
            try {
                float price = ((Double) doc.getDouble("price")).floatValue(); 
                String description = doc.getString("description");
                String name = doc.getString("name"); 
                int id = doc.getInteger("id"); 

                String formattedDate = doc.getString("date"); 
                Calendar date = Calendar.getInstance();
                date.setTime(dateFormat.parse(formattedDate)); 

                Expense expense = new Expense(price, description, name, date, id);
                expenses.add(expense);
            } catch (Exception e) {
                System.err.println("Error al procesar un documento: " + e.getMessage());
            }
        }
    } catch (Exception e) {
        System.err.println("Error al obtener los gastos: " + e.getMessage());
    }
    return expenses;
}




public boolean deleteExpense(int id) {
        try {
            return MongoDbManager.deleteById("Expenses", id);
        } catch (Exception e) {
            System.err.println("Error deleting expense: " + e.getMessage());
            return false;
        }
    }

public Expense searchExpense(int id) {
    try {
        Document doc = MongoDbManager.getDocumentByField("Expenses", "id", id);

        if (doc != null) {
            float price = ((Double) doc.getDouble("price")).floatValue();
            String description = doc.getString("description");
            String name = doc.getString("name");
            Calendar date = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = doc.getString("date"); 
            date.setTime(dateFormat.parse(formattedDate));
            int expenseId = doc.getInteger("id");

            return new Expense(price, description, name, date, expenseId);
        }
    } catch (Exception e) {
        System.err.println("Error searching for expense: " + e.getMessage());
    }
    return null;
}



   public boolean updateExpense(Expense expense) {
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(expense.getDate().getTime()); 

        Document updatedDocument = new Document("price", expense.getPrice())
                .append("description", expense.getDescription())
                .append("name", expense.getName())
                .append("date", formattedDate) 
                .append("id", expense.getId());

        return MongoDbManager.updateById("Expenses", expense.getId(), updatedDocument);
    } catch (Exception e) {
        System.err.println("Error updating expense: " + e.getMessage());
        return false;
    }
}

}

