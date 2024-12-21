package ec.edu.espe.surefinventory.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int id;
    private List<Dish> mainDishes;

    public Menu(int id) {
        this.id = id;
        this.mainDishes = new ArrayList<>();
    }

    // Add a MainDish to the menu
    public void addMainDish(Dish mainDish) {
        mainDishes.add(mainDish);
    }

    // Get the list of MainDishes
    public List<Dish> getMainDishes() {
        return mainDishes;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMainDishes(List<Dish> mainDishes) {
        this.mainDishes = mainDishes;
    }

    String toMenuString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
