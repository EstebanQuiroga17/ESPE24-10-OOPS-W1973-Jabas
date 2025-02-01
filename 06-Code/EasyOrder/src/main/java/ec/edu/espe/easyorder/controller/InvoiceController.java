

package ec.edu.espe.easyorder.controller;
import ec.edu.espe.easyorder.model.Customer;
import ec.edu.espe.easyorder.model.Dish;
import ec.edu.espe.easyorder.model.Expense;
import ec.edu.espe.easyorder.model.Invoice;
import ec.edu.espe.easyorder.model.Order;
import java.text.SimpleDateFormat;
import org.bson.Document;
import utils.MongoDbManager;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InvoiceController {

    private float calculateTotalPrice(ArrayList<Dish> dishes) {
        float total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice() * dish.getQuantity();
        }
        return total;
    }
    public String generateInvoiceText(Invoice invoice) {
        StringBuilder invoiceText = new StringBuilder();

        invoiceText.append("\n")
                .append("****************************************************\n")
                .append("*                ").append(invoice.getHeader()).append("                *\n")
                .append("****************************************************\n\n");

        invoiceText.append("N° Factura: ").append(invoice.getId()).append("\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        invoiceText.append("Fecha: ").append(dateFormat.format(invoice.getCurrentDate().getTime())).append("\n");

        Customer customer = invoice.getCustomer();
        invoiceText.append("\nDatos del Cliente:\n")
                .append("Nombre: ").append(customer.getName()).append("\n")
                .append("ID: ").append(customer.getId()).append("\n")
                .append("Número: ").append(customer.getPhoneNumber()).append("\n");

        Order order = invoice.getOrder();
        invoiceText.append("\nDetalles del Pedido:\n")
                .append("Platos ordenados:\n");
        invoiceText.append(String.format("%-12s %-30s %-15s %-10s\n", "Cantidad", "Plato", "Precio c/u", "Total"));
        invoiceText.append(String.format("%-12s %-30s %-15s %-10s\n", "--------", "------------------------------", "---------------", "----------"));

        for (Dish dish : order.getDishes()) {
            double total = dish.getPrice() * dish.getQuantity();
            invoiceText.append(String.format("%-12d %-30s %-15.2f %-10.2f\n",
                    dish.getQuantity(),
                    dish.getName(),
                    dish.getPrice(),
                    total));
        }

        invoiceText.append("\n----------------------------------------------------\n")
                .append("Precio total: $").append(invoice.getTotalPrice()).append("\n")
                .append("IVA: $0.00\n")
                .append("Total a Pagar: $").append(invoice.getTotalPrice()).append("\n");

        invoiceText.append("\n****************************************************\n")
                .append("*                   GRACIAS POR PREFERIRNOS!                    *\n")
                .append("****************************************************\n");

        return invoiceText.toString();
    }
    
    public Invoice generateInvoice(String selectedCustomer, String selectedOrderId) {
        try {
            int customerId = Integer.parseInt(selectedCustomer.split(" - ")[0]);

            Document customerDoc = CustomerController.findCustomerById(customerId);
            if (customerDoc == null) {
                JOptionPane.showMessageDialog(null, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            Customer customerObj = new Customer(
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
                int quantity = dishDoc.getInteger("quantity", 1); // Default to 1 if not specified
                dishes.add(new Dish(dishName, dishPrice, quantity));
            }

            Order orderObj = new Order(dishes.size(), selectedOrderId, dishes, Calendar.getInstance());

            return new Invoice(customerObj, orderObj, calculateTotalPrice(dishes));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generating invoice: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    public void saveInvoice(String customerInfo, String orderId) {
        try {
            int customerId = Integer.parseInt(customerInfo.split(" - ")[0]);

            Document customerDoc = CustomerController.findCustomerById(customerId);
            Document orderDoc = MongoDbManager.getDocumentByField("Order", "orderId", orderId);

            if (customerDoc == null || orderDoc == null) {
                JOptionPane.showMessageDialog(null, "Cliente o Pedido no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Customer customerObj = new Customer(
                    customerDoc.getString("name"),
                    customerDoc.getInteger("id"),
                    customerDoc.get("phoneNumber").toString()
            );

            List<Dish> dishes = new ArrayList<>();
            List<Document> dishDocs = (List<Document>) orderDoc.get("dishes");
            for (Document dishDoc : dishDocs) {
                dishes.add(new Dish(
                        dishDoc.getString("name"),
                        ((Number) dishDoc.get("price")).floatValue(),
                        dishDoc.getInteger("quantity", 1)
                ));
            }

            Order orderObj = new Order(dishes.size(), orderId, (ArrayList<Dish>) dishes, Calendar.getInstance());
            float totalPrice = calculateTotalPrice((ArrayList<Dish>) dishes);
            Invoice invoice = new Invoice(customerObj, orderObj, totalPrice);
            Calendar currentDate = invoice.getCurrentDate();
            Document dateDocument = new Document()
                    .append("year", currentDate.get(Calendar.YEAR))
                    .append("month", currentDate.get(Calendar.MONTH))
                    .append("dayOfMonth", currentDate.get(Calendar.DAY_OF_MONTH))
                    .append("hourOfDay", currentDate.get(Calendar.HOUR_OF_DAY))
                    .append("minute", currentDate.get(Calendar.MINUTE))
                    .append("second", currentDate.get(Calendar.SECOND));

            Document invoiceDocument = new Document("id", invoice.getId())
                    .append("currentDate", dateDocument)
                    .append("customer", new Document("name", customerObj.getName())
                            .append("id", customerObj.getId())
                            .append("phoneNumber", customerObj.getPhoneNumber()))
                    .append("totalPrice", invoice.getTotalPrice())
                    .append("order", new Document("id", orderObj.getId())
                            .append("dishes", dishDocs))
                    .append("header", invoice.getHeader());

            MongoDbManager.insertDocument("Invoice", invoiceDocument);

            JOptionPane.showMessageDialog(null, "Factura guardada con éxito!", "Listo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Guardando Factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    

}
