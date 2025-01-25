

package ec.edu.espe.easyorder.controller;
import ec.edu.espe.easyorder.model.Customer;
import ec.edu.espe.easyorder.model.Dish;
import ec.edu.espe.easyorder.model.Invoice;
import ec.edu.espe.easyorder.model.Order;
import org.bson.Document;
import utils.MongoDbManager;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InvoiceController {

    public List<String> getCustomerList() {
        List<String> customerList = new ArrayList<>();
        try {
            List<Document> customers = MongoDbManager.getAll("Customer");
            if (customers.isEmpty()) {
                return customerList;
            }
            for (Document customerDoc : customers) {
                String name = customerDoc.getString("name");
                int id = customerDoc.getInteger("id");
                String customerDisplay = id + " - " + name;
                customerList.add(customerDisplay);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading customers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customerList;
    }

    public List<String> getOrderIdList() {
        List<String> orderIdList = new ArrayList<>();
        try {
            List<Document> orders = MongoDbManager.getAll("Order");
            if (orders.isEmpty()) {
                return orderIdList;
            }
            for (Document orderDoc : orders) {
                String orderId = orderDoc.getString("orderId");
                if (orderId != null && !orderId.isEmpty()) {
                    orderIdList.add(orderId);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading orders: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return orderIdList;
    }

    public Invoice generateInvoice(String selectedCustomer, String selectedOrderId) {
        try {
            String[] customerParts = selectedCustomer.split(" - ");
            int customerId = Integer.parseInt(customerParts[0]);

            Document customerDoc = MongoDbManager.getDocumentByField("Customer", "id", customerId);
            if (customerDoc == null) {
                JOptionPane.showMessageDialog(null, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            Customer customer = new Customer(
                    customerDoc.getString("name"),
                    customerDoc.getInteger("id"),
                    customerDoc.get("phoneNumber").toString()
            );

            Document orderDoc = MongoDbManager.getDocumentByField("Order", "orderId", selectedOrderId);
            if (orderDoc == null) {
                JOptionPane.showMessageDialog(null, "Order not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            ArrayList<Dish> dishes = new ArrayList<>();
            List<Document> dishDocs = (List<Document>) orderDoc.get("dishes");
            for (Document dishDoc : dishDocs) {
                String dishName = dishDoc.getString("name");
                float dishPrice = ((Number) dishDoc.get("price")).floatValue();
                int quantity = dishDoc.getInteger("quantity");
                dishes.add(new Dish(dishName, dishPrice, quantity));
            }

            String orderId = orderDoc.getString("orderId");
            Order order = new Order(dishes.size(), orderId, dishes, Calendar.getInstance());

            return new Invoice(customer, order);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generating invoice: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void saveInvoice(String customer, String orderId, String invoiceText) {
        try {
            Document invoiceDoc = new Document()
                    .append("customer", customer)
                    .append("orderId", orderId)
                    .append("invoiceText", invoiceText)
                    .append("dateGenerated", new Date());

            MongoDbManager.insertDocument("Invoice", invoiceDoc);
            JOptionPane.showMessageDialog(null, "Invoice saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving invoice: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
