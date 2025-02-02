package ec.edu.espe.easyorder.controller;

import ec.edu.espe.easyorder.model.Customer;
import ec.edu.espe.easyorder.model.Dish;
import ec.edu.espe.easyorder.model.Invoice;
import ec.edu.espe.easyorder.model.Order;
import org.bson.Document;
import utils.MongoDbManager;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Invoice Controller Author: Benjamin Robalino
 */
public class InvoiceController {

    private float calculateTotalPrice(List<Document> dishes) {
        float total = 0;
        for (Document dish : dishes) {
            float price = ((Number) dish.get("price")).floatValue();
            int quantity = dish.getInteger("quantity", 1);
            total += price * quantity;
        }
        return total;
    }

    public Invoice generateInvoice(String selectedCustomer, String selectedOrderId) {
        try {
            int customerId = Integer.parseInt(selectedCustomer.split(" - ")[0]);
            Document customerDoc = CustomerController.findCustomerById(customerId);
            Document orderDoc = MongoDbManager.getDocumentByField("Order", "orderId", selectedOrderId);

            if (customerDoc == null || orderDoc == null) {
                JOptionPane.showMessageDialog(null, "No encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            Customer customer = new Customer(
                    customerDoc.getString("name"),
                    customerDoc.getInteger("id"),
                    customerDoc.get("phoneNumber").toString()
            );

            List<Document> dishDocs = (List<Document>) orderDoc.get("dishes");
            ArrayList<Dish> dishes = new ArrayList<>();
            for (Document dishDoc : dishDocs) {
                dishes.add(new Dish(
                        dishDoc.getString("name"),
                        ((Number) dishDoc.get("price")).floatValue(),
                        dishDoc.getInteger("quantity", 1)
                ));
            }

            Order order = new Order(dishes.size(), selectedOrderId, dishDocs, Calendar.getInstance());
            return new Invoice(customer, order, calculateTotalPrice(dishDocs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    public String generateInvoiceText(Invoice invoice) {
        StringBuilder invoiceText = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        invoiceText.append("\n****************************************************\n")
                .append("*                ").append(invoice.getHeader()).append("                *\n")
                .append("****************************************************\n\n")
                .append("Factura No: ").append(invoice.getId()).append("\n")
                .append("Fecha: ").append(dateFormat.format(invoice.getCurrentDate().getTime())).append("\n\n")
                .append("Datos Cliente:\n")
                .append("Nombre: ").append(invoice.getCustomer().getName()).append("\n")
                .append("ID: ").append(invoice.getCustomer().getId()).append("\n")
                .append("Numero Celular: ").append(invoice.getCustomer().getPhoneNumber()).append("\n\n")
                .append("Detalles Orden:\n")
                .append(String.format("%-12s %-30s %-15s %-10s\n", "Cantidad", "Plato", "Precio Unitario", "Total"))
                .append("----------------------------------------------------\n");
        for (Document dish : invoice.getOrder().getDishes()) {
            int quantity = dish.getInteger("quantity");
            String name = dish.getString("name");
            float price = dish.getDouble("price").floatValue();
            float total = price * quantity;
            invoiceText.append(String.format("%-12d %-30s %-15.2f %-10.2f\n", quantity, name, price, total));
        }
        invoiceText.append("\n----------------------------------------------------\n")
                .append("Sub Total: $").append(invoice.getTotalPrice()).append("\n")
                .append("IVA: $0.00\n")
                .append("Total: $").append(invoice.getTotalPrice()).append("\n")
                .append("\n****************************************************\n")
                .append("*                   Gracias por preferirnos!                  *\n")
                .append("****************************************************\n");
        return invoiceText.toString();
    }

    public void saveInvoice(Invoice invoice) {
        try {
            Calendar currentDate = invoice.getCurrentDate();
            Document dateDocument = new Document()
                    .append("year", currentDate.get(Calendar.YEAR))
                    .append("month", currentDate.get(Calendar.MONTH) + 1)
                    .append("dayOfMonth", currentDate.get(Calendar.DAY_OF_MONTH))
                    .append("hourOfDay", currentDate.get(Calendar.HOUR_OF_DAY))
                    .append("minute", currentDate.get(Calendar.MINUTE))
                    .append("second", currentDate.get(Calendar.SECOND));

            Document invoiceDocument = new Document("id", invoice.getId())
                    .append("currentDate", dateDocument)
                    .append("customer", new Document("name", invoice.getCustomer().getName())
                            .append("id", invoice.getCustomer().getId())
                            .append("phoneNumber", invoice.getCustomer().getPhoneNumber()))
                    .append("totalPrice", invoice.getTotalPrice())
                    .append("order", new Document("id", invoice.getOrder().getId())
                            .append("dishes", invoice.getOrder().getDishes()))
                    .append("header", invoice.getHeader());

            MongoDbManager.insertDocument("Invoice", invoiceDocument);
            JOptionPane.showMessageDialog(null, "Factura guardada con éxito!", "Ok", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
