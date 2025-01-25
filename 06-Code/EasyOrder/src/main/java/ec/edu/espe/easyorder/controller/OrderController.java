

package ec.edu.espe.easyorder.controller;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import utils.MongoDbManager;
import org.bson.Document;
import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class OrderController {
    
        public String generateOrderId() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String date = dateFormat.format(calendar.getTime());
            SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss");
            String time = timeFormat.format(calendar.getTime());
            long timestamp = System.currentTimeMillis();
            return date + "-" + time + "-" + timestamp;
        }

        public String getCurrentDate() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(calendar.getTime());
        }

        public List<String> getMenuDishes() {
            try {
                List<Document> menuItems = MongoDbManager.getAll("Menu");
                List<String> dishNames = new ArrayList<>();
                for (Document dish : menuItems) {
                    dishNames.add(dish.getString("name"));
                }
                return dishNames;
            } catch (Exception e) {
                throw new RuntimeException("Error loading menu: " + e.getMessage());
            }
        }

        public void saveOrder(String orderId, String orderDate, List<Document> dishesList) {
            try {
                Document orderDocument = new Document("orderId", orderId)
                        .append("date", orderDate)
                        .append("dishes", dishesList);

                MongoDbManager.insertDocument("Order", orderDocument);
            } catch (Exception e) {
                throw new RuntimeException("Error saving order: " + e.getMessage());
            }
        }
        public void addDishToTable(DefaultTableModel model, String selectedDish, int quantity) {
        model.addRow(new Object[]{selectedDish, quantity});
    }
}