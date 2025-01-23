

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

public class OrderController {

    /**
     * Generates a unique order ID based on the current date and time.
     * Format: YYYYMMDD-HHMMSS-<timestamp>
     * Example: 20250123-154530-1632948500205
     * 
     * @return A unique order ID string
     */
    public String generateOrderId() {
        Calendar calendar = Calendar.getInstance();
        
        // Get current date in format YYYYMMDD
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormat.format(calendar.getTime());
        
        // Get current time in format HHMMSS
        SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss");
        String time = timeFormat.format(calendar.getTime());
        
        // Generate a unique timestamp
        long timestamp = System.currentTimeMillis();
        
        // Combine date, time, and timestamp to form a unique ID
        String orderId = date + "-" + time + "-" + timestamp;
        
        return orderId;
    }
    
    /**
     * Retrieves the current date in YYYY-MM-DD format.
     * 
     * @return Current date in YYYY-MM-DD format.
     */
    public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());
    }
}