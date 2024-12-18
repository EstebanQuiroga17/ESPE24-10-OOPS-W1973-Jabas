package ec.edu.espe.surefinventory.model;

import java.util.Calendar;
import java.util.List;

public class Order {
    private double totalPrice;
    private int itemQuantity;
    private int id;
    private List<Dish> mainDishes;
    private Calendar date;

    @Override
    public String toString() {
        return String.format(
        "%-15s | %-15s | %-10s | %-20s | %-20s%n" +
        "----------------------------------------------------------------------------------%n" +
        "$%-14.2f | %-15d | %-10d | %-20s | %-20s",
        "Total Price", "Item Quantity", "ID", "Main Dishes", "Date",
        totalPrice, itemQuantity, id, mainDishes, date.toString()
    );
}


    public Order(double totalPrice, int itemQuantity, int id, List<Dish> mainDishes, Calendar date) {
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
        for (Dish mainDish : mainDishes) {
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

    public List<Dish> getMainDishList() {
        return mainDishes;
    }

    public void setMainDishList(List<Dish> mainDishList) {
        this.mainDishes = mainDishList;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}