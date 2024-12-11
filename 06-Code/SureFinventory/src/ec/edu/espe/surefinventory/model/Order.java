package ec.edu.espe.surefinventory.model;

import java.util.Calendar;
import java.util.List;

public class Order {
    private double totalPrice;
    private int itemQuantity;
    private int id;
    private List<MainDish> mainDishes;
    private Calendar date;

    public Order(double totalPrice, int itemQuantity, int id, List<MainDish> mainDishes, Calendar date) {
        this.totalPrice = totalPrice;
        this.itemQuantity = itemQuantity;
        this.id = id;
        this.mainDishes = mainDishes;
        this.date = date;
    }

    public void printOrder() {
        System.out.println("Order ID: " + id);
        System.out.println("Date: " + date.getTime());
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Items:");
        for (MainDish mainDish : mainDishes) {
            System.out.println("- " + mainDish.getName() + " (Price: $" + mainDish.getPrice() + ")");
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MainDish> getMainDishList() {
        return mainDishes;
    }

    public void setMainDishList(List<MainDish> mainDishList) {
        this.mainDishes = mainDishList;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}