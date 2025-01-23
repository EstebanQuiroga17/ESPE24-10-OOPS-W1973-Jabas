package ec.edu.espe.easyorder.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.easyorder.model.Expense;
import org.bson.Document;
import utils.MongoDbManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author Matias Rojas
 */

public class ExpenseController {

    public boolean addExpense(Expense expense) {
        try {
            Document document = new Document("price", expense.getPrice())
                    .append("description", expense.getDescription())
                    .append("name", expense.getName())
                    .append("date", expense.getDate().getTimeInMillis()) 
                    .append("id", expense.getId());

            return MongoDbManager.insert("Expenses", document);
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            return false;
        }
    }

public List<Expense> getAllExpenses() {
    List<Expense> expenses = new ArrayList<>();
    try {
        List<Document> documents = MongoDbManager.getAll("Expenses");

        for (Document doc : documents) {
            float price = ((Double) doc.getDouble("price")).floatValue(); 
            String description = doc.getString("description");
            String name = doc.getString("name");
            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(doc.getLong("date"));
            int id = doc.getInteger("id");

            Expense expense = new Expense(price, description, name, date, id);
            expenses.add(expense);
        }
    } catch (Exception e) {
        System.err.println("Error : " + e.getMessage());
    }
    return expenses;
}

}

