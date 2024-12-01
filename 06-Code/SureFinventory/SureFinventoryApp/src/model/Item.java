
package model;

/**
 *
 * @author abner
 */
public class Item {
    private String personsName;
    private String orderName;
    private float price;

    @Override
    public String toString() {
        return "Item{" + "personsName=" + personsName + ", orderName=" + orderName + ", price=" + price + '}';
    }

    public Item(String personsName, String orderName, float price) {
        this.personsName = personsName;
        this.orderName = orderName;
        this.price = price;
    }
    

    /**
     * @return the personsName
     */
    public String getPersonsName() {
        return personsName;
    }

    /**
     * @param personsName the personsName to set
     */
    public void setPersonsName(String personsName) {
        this.personsName = personsName;
    }

    /**
     * @return the orderName
     */
    public String getOrderName() {
        return orderName;
    }

    /**
     * @param orderName the orderName to set
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
