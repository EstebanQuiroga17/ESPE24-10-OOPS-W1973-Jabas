package ec.edu.espe.surefinventory.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int id;
    private List<MainDish> mainDishes;

    public Menu(int id) {
        this.id = id;
        this.mainDishes = new ArrayList<>();
    }

    // Add a MainDish to the menu
    public void addMainDish(MainDish mainDish) {
        mainDishes.add(mainDish);
    }

    // Get the list of MainDishes
    public List<MainDish> getMainDishes() {
        return mainDishes;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMainDishes(List<MainDish> mainDishes) {
        this.mainDishes = mainDishes;
    }
}
