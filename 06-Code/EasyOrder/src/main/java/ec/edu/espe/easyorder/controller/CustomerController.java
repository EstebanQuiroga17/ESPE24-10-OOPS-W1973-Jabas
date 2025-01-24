package ec.edu.espe.easyorder.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.easyorder.view.FrmCustomer;
import ec.edu.espe.easyorder.view.FrmFoundCustomer;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import utils.MongoDbManager;

/**
 *
 * @author abner
 */
public class CustomerController {

    public void loadCustomersFromDatabase() {
        List<Document> customers = MongoDbManager.getAll("Customer");

        for (Document customer : customers) {
            int id = customer.getInteger("id");
            String name = customer.getString("name");
            String lastname = customer.getString("lastname");
            int phoneNumber = customer.getInteger("phoneNumber");

            FrmCustomer.AddRowToJTableCustomer(new Object[]{id, name, lastname, phoneNumber});
        }
    }

    public static boolean insertCustomer(int id, String name, String lastname, int phoneNumber) {
        try {
            MongoCollection<Document> collection = MongoDbManager.getDatabase().getCollection("Customer");

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
            MongoCollection<Document> collection = MongoDbManager.getDatabase().getCollection("Customer");

            Bson filter = Filters.eq("id", id);

            DeleteResult result = collection.deleteOne(filter);

            if (result.getDeletedCount() > 0) {
                System.out.println("Customer deleted from collection: Customer");

                List<Document> customers = MongoDbManager.getAll("Customer");

                FrmCustomer.getTableModel().setRowCount(0);

                for (Document customer : customers) {
                    int customerId = customer.getInteger("id");
                    String name = customer.getString("name");
                    String lastname = customer.getString("lastname");
                    int phoneNumber = customer.getInteger("phoneNumber");
                    FrmCustomer.getTableModel().addRow(new Object[]{customerId, name, lastname, phoneNumber});
                }

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
        MongoCollection<Document> collection = MongoDbManager.getDatabase().getCollection("Customer");

        Document customer = collection.find(Filters.eq("id", id)).first();

        if (customer != null) {
            System.out.println("Customer found: " + customer.toJson());
        } else {
            System.out.println("No customer found with ID: " + id);
        }

        return customer;
    } catch (Exception e) {
        System.err.println("Error finding customer: " + e.getMessage());
        return null;
    }
}

}
