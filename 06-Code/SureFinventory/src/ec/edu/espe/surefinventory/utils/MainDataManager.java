package ec.edu.espe.surefinventory.utils;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MainDataManager<DataType> {
    private final List<DataType> items;
    private final String filePath;
    private final Gson gson;
    private final Type itemType;

    public MainDataManager(String filePath, Type itemType) {
        this.filePath = filePath;
        this.itemType = itemType;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.items = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        try (Reader reader = new FileReader(filePath)) {
            List<DataType> loadedItems = gson.fromJson(reader, itemType);
            if (loadedItems != null) {
                items.addAll(loadedItems);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath + ". Starting with an empty list.");
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private void saveData() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(items, writer);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public void addItem(DataType item) {
        items.add(item);
        saveData();
    }

    public boolean removeItem(java.util.function.Predicate<DataType> predicate) {
        boolean removed = items.removeIf(predicate);
        if (removed) {
            saveData();
        }
        return removed;
    }

    public boolean updateItem(java.util.function.Predicate<DataType> predicate, DataType updatedItem) {
        Optional<DataType> existingItem = items.stream().filter(predicate).findFirst();
        if (existingItem.isPresent()) {
            int index = items.indexOf(existingItem.get());
            items.set(index, updatedItem);
            saveData();
            return true;
        }
        return false;
    }

    public List<DataType> getItems() {
        return Collections.unmodifiableList(items);
    }
}
