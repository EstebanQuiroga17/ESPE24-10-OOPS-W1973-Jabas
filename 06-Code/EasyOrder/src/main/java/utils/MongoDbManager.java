package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


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
}
