

package utils;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Cashier;
import ec.edu.espe.surefinventory.model.Manager;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class InfoManager {
    private static final String JSON_FILE_PATH = "data/info.json";
    private static final Gson gson = new Gson();

    private static List<Cashier> cashiers = new ArrayList<>();
    private static List<Manager> managers = new ArrayList<>();

    // Load data from JSON file
    public static void loadData() {
        if (Files.notExists(Paths.get(JSON_FILE_PATH))) {
            System.out.println("No existing data found. Starting fresh.");
            return;
        }

        try (FileReader reader = new FileReader(JSON_FILE_PATH)) {
            Type dataType = new TypeToken<DataContainer>() {}.getType();
            DataContainer data = gson.fromJson(reader, dataType);
            if (data != null) {
                cashiers = Optional.ofNullable(data.getCashiers()).orElse(new ArrayList<>());
                managers = Optional.ofNullable(data.getManagers()).orElse(new ArrayList<>());
            }
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    // Save data to JSON file
    private static void saveData() {
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            DataContainer data = new DataContainer(cashiers, managers);
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    // Add a new cashier
    public static void addCashier(Cashier cashier) {
        cashiers.add(cashier);
        saveData();
    }

    // Add a new manager
    public static void addManager(Manager manager) {
        managers.add(manager);
        saveData();
    }

    // Remove a cashier by ID
    public static boolean removeCashier(int id) {
        boolean removed = cashiers.removeIf(cashier -> cashier.getId() == id);
        if (removed) saveData();
        return removed;
    }

    // Remove a manager by ID
    public static boolean removeManager(int id) {
        boolean removed = managers.removeIf(manager -> manager.getId() == id);
        if (removed) saveData();
        return removed;
    }

    // Update cashier details
    public static boolean updateCashier(int id, Cashier updatedCashier) {
        Optional<Cashier> existingCashier = cashiers.stream()
                .filter(cashier -> cashier.getId() == id)
                .findFirst();

        if (existingCashier.isPresent()) {
            int index = cashiers.indexOf(existingCashier.get());
            cashiers.set(index, updatedCashier);
            saveData();
            return true;
        }
        return false;
    }

    // Update manager details
    public static boolean updateManager(int id, Manager updatedManager) {
        Optional<Manager> existingManager = managers.stream()
                .filter(manager -> manager.getId() == id)
                .findFirst();

        if (existingManager.isPresent()) {
            int index = managers.indexOf(existingManager.get());
            managers.set(index, updatedManager);
            saveData();
            return true;
        }
        return false;
    }

    // Get all cashiers
    public static List<Cashier> getCashiers() {
        return Collections.unmodifiableList(cashiers);
    }

    // Get all managers
    public static List<Manager> getManagers() {
        return Collections.unmodifiableList(managers);
    }

    // Inner class to manage JSON serialization
    private static class DataContainer {
        private List<Cashier> cashiers;
        private List<Manager> managers;

        public DataContainer(List<Cashier> cashiers, List<Manager> managers) {
            this.cashiers = cashiers;
            this.managers = managers;
        }

        public List<Cashier> getCashiers() {
            return cashiers;
        }

        public List<Manager> getManagers() {
            return managers;
        }
    }
}

