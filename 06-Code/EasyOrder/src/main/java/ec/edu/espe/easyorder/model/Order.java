package ec.edu.espe.easyorder.model;

import java.util.Calendar;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Matias Rojas
 */
public class Order {

    private int itemQuantity;
    private String id;
    private List<Document> dishes;
    private Calendar currentDate;

    public Order(int itemQuantity, String id, List<Document> dishes, Calendar currentDate) {
        this.itemQuantity = itemQuantity;
        this.id = id;
        this.dishes = dishes;
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return "Order{"
                + "itemQuantity=" + itemQuantity
                + ", id='" + id + '\''
                + ", dishes=" + dishes
                + ", currentDate=" + currentDate.getTime()
                + '}';
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Document> getDishes() {
        return dishes;
    }

    public void setDishes(List<Document> dishes) {
        this.dishes = dishes;
    }

    public Calendar getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Calendar currentDate) {
        this.currentDate = currentDate;
    }
}
