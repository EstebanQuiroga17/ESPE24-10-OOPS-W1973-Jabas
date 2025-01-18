package ec.edu.espe.easyorder.model;

import java.util.Calendar;

/**
 *
 * @author Matias Rojas
 */
public class Expense {
    private float price;
    private String description;
    private String name;
    private Calendar date;
    private int id;

    public Expense(float price, String description, String name, Calendar date, int id) {
        this.price = price;
        this.description = description;
        this.name = name;
        this.date = date;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Expense{" + "price=" + price + ", description=" + description + ", name=" + name + ", date=" + date + ", id=" + id + '}';
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
