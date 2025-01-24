package ec.edu.espe.easyorder.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.easyorder.view.FrmMenu;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import utils.MongoDbManager;

/**
 *
 * @author abner
 */
public class MenuController {

    public void loadDishesFromDatabase() {
        List<Document> dishes = MongoDbManager.getAll("Menu");

        for (Document dish : dishes) {
            int id = dish.getInteger("id");
            String name = dish.getString("name");
            float price = dish.getDouble("price").floatValue();

            FrmMenu.AddRowToJTableDish(new Object[]{id, name, price});
        }
    }

    public static boolean insertDish(int id, String name, float price) {
        try {
            MongoCollection<Document> collection = MongoDbManager.getDatabase().getCollection("Menu");

            Document dishDocument = new Document("id", id)
                    .append("name", name)
                    .append("price", price);

            collection.insertOne(dishDocument);
            System.out.println("Dish inserted into collection: Menu");
            return true;
        } catch (Exception e) {
            System.err.println("Error inserting dish: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteDish(int id) {
        try {
            MongoCollection<Document> collection = MongoDbManager.getDatabase().getCollection("Menu");

            Bson filter = Filters.eq("id", id);

            DeleteResult result = collection.deleteOne(filter);

            if (result.getDeletedCount() > 0) {
                System.out.println("Dish deleted from collection: Menu");

                List<Document> dishes = MongoDbManager.getAll("Menu");

                FrmMenu.getTableModel().setRowCount(0);

                for (Document dish : dishes) {
                    int dishId = dish.getInteger("id");
                    String name = dish.getString("name");
                    float price = dish.getDouble("price").floatValue();
                    FrmMenu.getTableModel().addRow(new Object[]{dishId, name, price});
                }

                return true;
            } else {
                System.out.println("Dish with id " + id + " not found.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error deleting dish: " + e.getMessage());
            return false;
        }
    }
    
    public static Document findDishById(int id) {
    try {
        MongoCollection<Document> collection = MongoDbManager.getDatabase().getCollection("Menu");

        Document dish = collection.find(Filters.eq("id", id)).first();

        if (dish != null) {
            System.out.println("Dish found: " + dish.toJson());
        } else {
            System.out.println("No dish found with ID: " + id);
        }

        return dish;
    } catch (Exception e) {
        System.err.println("Error finding dish: " + e.getMessage());
        return null;
    }
}


}
