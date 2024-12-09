

package utils;

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

public class MainDataManager<T> {
    private final List<T> items;
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

    /**
     * Loads data from the JSON file into the items list.
     */
    private void loadData() {
        try (Reader reader = new FileReader(filePath)) {
            List<T> loadedItems = gson.fromJson(reader, itemType);
            if (loadedItems != null) {
                items.addAll(loadedItems);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath + ". Starting with an empty list.");
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    /**
     * Saves the items list to the JSON file.
     */
    private void saveData() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(items, writer);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    /**
     * Adds a new item to the manager and saves changes to the file.
     *
     * @param item the item to add
     */
    public void addItem(T item) {
        items.add(item);
        saveData();
    }

    /**
     * Removes an item from the manager based on the provided predicate.
     *
     * @param predicate a condition to identify the item to remove
     * @return true if an item was removed, false otherwise
     */
    public boolean removeItem(java.util.function.Predicate<T> predicate) {
        boolean removed = items.removeIf(predicate);
        if (removed) {
            saveData();
        }
        return removed;
    }

    /**
     * Updates an existing item in the manager.
     *
     * @param predicate   a condition to identify the item to update
     * @param updatedItem the new item to replace the existing one
     * @return true if the item was updated, false otherwise
     */
    public boolean updateItem(java.util.function.Predicate<T> predicate, T updatedItem) {
        Optional<T> existingItem = items.stream().filter(predicate).findFirst();
        if (existingItem.isPresent()) {
            int index = items.indexOf(existingItem.get());
            items.set(index, updatedItem);
            saveData();
            return true;
        }
        return false;
    }

    /**
     * Retrieves all items managed by this instance.
     *
     * @return an unmodifiable list of items
     */
    public List<T> getItems() {
        return Collections.unmodifiableList(items);
    }
}
