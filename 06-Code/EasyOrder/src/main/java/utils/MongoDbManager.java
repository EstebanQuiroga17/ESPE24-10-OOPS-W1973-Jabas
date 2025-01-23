package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
public class MongoDbManager {

    private static final String CONNECTION_STRING = "mongodb+srv://arobalino:arobalino@cluster0.uhcya.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        try {

            mongoClient = MongoClients.create(CONNECTION_STRING);

            database = mongoClient.getDatabase("EasyOrder");
            System.out.println("Connected to MongoDB database: EasyOrder");
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e.getMessage());
        }
    }

    public static boolean insert(String collectionName, Document document) {
        try {

            MongoCollection<Document> collection = database.getCollection(collectionName);

            collection.insertOne(document);
            System.out.println("Document inserted into collection: " + collectionName);
            return true;
        } catch (Exception e) {
            System.err.println("Error inserting document: " + e.getMessage());
            return false;
        }
    }

    public static void showAll(String collectionName) {
        try {

            MongoCollection<Document> collection = database.getCollection(collectionName);

            System.out.println("\nDocuments in collection: " + collectionName);
            for (Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving documents: " + e.getMessage());
        }
    }

    public static List<Document> getAll(String collectionName) {
        List<Document> resultList = new ArrayList<>();
        try {

            MongoCollection<Document> collection = database.getCollection(collectionName);

            for (Document doc : collection.find()) {
                resultList.add(doc);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving documents: " + e.getMessage());
        }
        return resultList;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed.");
        }
    }

    public static boolean insertDish(int id, String name, float price) {
        try {
            MongoCollection<Document> collection = database.getCollection("Menu");

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
            MongoCollection<Document> collection = database.getCollection("Menu");

            Bson filter = Filters.eq("id", id);

            DeleteResult result = collection.deleteOne(filter);

            if (result.getDeletedCount() > 0) {
                System.out.println("Dish deleted from collection: Menu");
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
            MongoCollection<Document> collection = database.getCollection("Menu");

            return collection.find(Filters.eq("id", id)).first();
        } catch (Exception e) {
            System.err.println("Error finding dish: " + e.getMessage());
            return null;
        }
    }

    public static boolean insertCustomer(int id, String name, String lastname, int phoneNumber) {
        try {

            MongoCollection<Document> collection = database.getCollection("Customer");

            Document customerDocument = new Document("id", id)
                    .append("name", name)
                    .append("lastname", lastname)
                    .append("phoneNumber", phoneNumber);

            collection.insertOne(customerDocument);
            System.out.println("Customer inserted into collection: Customer");

            return true;
        } catch (Exception e) {

            System.err.println("Error inserting customer: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteCustomer(int id) {
        try {
            MongoCollection<Document> collection = database.getCollection("Customer");

            Bson filter = Filters.eq("id", id);

            DeleteResult result = collection.deleteOne(filter);

            if (result.getDeletedCount() > 0) {
                System.out.println("Customer deleted from collection: Customer");
                return true;
            } else {
                System.out.println("Customer with id " + id + " not found.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error deleting customer: " + e.getMessage());
            return false;
        }
    }
    
    
   public static Document findCustomerById(int id) {
    try {
        MongoCollection<Document> collection = database.getCollection("Customer");
        
        // Se busca por el campo "id" que has definido en el documento
        return collection.find(Filters.eq("id", id)).first();
    } catch (Exception e) {
        System.err.println("Error finding customer: " + e.getMessage());
        return null;
    }
}
}


