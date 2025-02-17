package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
public class MongoDbManager {

    private static final String CONNECTION_STRING = "mongodb+srv://arobalino:arobalino@cluster0.uhcya.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);  // Insert a single document into the collection
    }

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
    public static Document getDocumentByField(String collectionName, String fieldName, Object value) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            return collection.find(Filters.eq(fieldName, value)).first();
        } catch (Exception e) {
            System.err.println("Error retrieving document from collection: " + e.getMessage());
            return null;
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

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static boolean updateById(String collectionName, int id, Document updatedDoc) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Bson filter = Filters.eq("id", id);
            collection.updateOne(filter, new Document("$set", updatedDoc));
            System.out.println("Documento actualizado en la coleccion: " + collectionName);
            return true;
        } catch (Exception e) {
            System.err.println("Error al actualizar el documento: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteById(String collectionName, int id) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Bson filter = Filters.eq("id", id);
            DeleteResult result = collection.deleteOne(filter);
            if (result.getDeletedCount() > 0) {
                System.out.println("Eliminado de la coleccion: " + collectionName);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error al eliminar el documento: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteDocumentById(String collectionName, int id) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);

            Bson filter = Filters.eq("id", id);

            DeleteResult result = collection.deleteOne(filter);

            if (result.getDeletedCount() > 0) {
                System.out.println("Document deleted from collection: " + collectionName);
                return true;
            } else {
                System.out.println("Document with ID " + id + " not found in collection: " + collectionName);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error deleting document: " + e.getMessage());
            return false;
        }
    }
    
    public static Calendar descerializeDate(Document doc){
        Calendar calendar = Calendar.getInstance();
        int year;
        int month;
        int dayOfMonth;
        int hourOfDay;
        int minute;
        int second;
        Document date = (Document)doc.get("date");
        
        year = date.getInteger("year");
        month = date.getInteger("month");
        dayOfMonth = date.getInteger("dayOfMonth");
        hourOfDay = date.getInteger("hourOfDay");
        minute = date.getInteger("minute");
        second = date.getInteger("second");
        
        calendar.set(year, month, dayOfMonth, hourOfDay, minute, second);
        
        return calendar;
    }
}
