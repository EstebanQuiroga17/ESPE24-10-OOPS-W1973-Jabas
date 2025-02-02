package ec.edu.espe.easyorder.controller;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import ec.edu.espe.easyorder.model.Order;
import utils.MongoDbManager;
import org.bson.Document;
import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class OrderController {

    public List<String> getMenuDishes() {
        List<Document> menuItems = MongoDbManager.getAll("Menu");
        List<String> dishNames = new ArrayList<>();
        for (Document dish : menuItems) {
            dishNames.add(dish.getString("name"));
        }
        return dishNames;
    }

    public String generateOrderId() {
        return new SimpleDateFormat("yyyyMMdd-HHmmss").format(Calendar.getInstance().getTime()) + "-" + System.currentTimeMillis();
    }

    public String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }

    public void resetOrderDetails(DefaultTableModel model, JComboBox<String> dishComboBox, JTextField quantityField, JLabel orderIdLabel, JLabel dateLabel) {
        model.setRowCount(0);
        if (dishComboBox.getItemCount() > 0) {
            dishComboBox.setSelectedIndex(0);
        }
        quantityField.setText("");
        orderIdLabel.setText(" " + generateOrderId());
        dateLabel.setText(" " + getCurrentDate());
    }

    public void saveOrder(String orderId, String orderDate, DefaultTableModel model) {
        try {
            List<Document> dishesList = new ArrayList<>();
            for (int i = 0; i < model.getRowCount(); i++) {
                String dishName = (String) model.getValueAt(i, 0);
                int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());

                Document menuItem = MongoDbManager.getDocumentByField("Menu", "name", dishName);
                if (menuItem == null) {
                    JOptionPane.showMessageDialog(null, "Plato no encontrado: " + dishName, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                float price = menuItem.getDouble("price").floatValue();
                dishesList.add(new Document("name", dishName)
                        .append("quantity", quantity)
                        .append("price", price));
            }

            Order order = new Order(model.getRowCount(), orderId, dishesList, Calendar.getInstance());
            MongoDbManager.insertDocument("Order", new Document()
                    .append("orderId", order.getId())
                    .append("date", order.getCurrentDate().getTime())
                    .append("dishes", dishesList));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<String[]> getOrderList() {
        List<String[]> orderData = new ArrayList<>();
        try {
            List<Document> orders = MongoDbManager.getAll("Order");
            for (Document order : orders) {
                String orderId = order.getString("orderId");

                Date dateObject = order.getDate("date");
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateObject);

                List<Document> dishes = (List<Document>) order.get("dishes");

                StringBuilder dishDetails = new StringBuilder();
                for (Document dish : dishes) {
                    dishDetails.append(dish.getString("name"))
                            .append(" (")
                            .append(dish.getInteger("quantity"))
                            .append("), ");
                }
                if (dishDetails.length() > 2) {
                    dishDetails.setLength(dishDetails.length() - 2);
                }
                orderData.add(new String[]{orderId, date, dishDetails.toString()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando ordenes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return orderData;
    }

    public void addDishToTable(DefaultTableModel model, String selectedDish, int quantity) {
        model.addRow(new Object[]{selectedDish, quantity});
    }
}
