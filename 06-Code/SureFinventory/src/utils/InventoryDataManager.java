

package utils;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Inventory;

import java.lang.reflect.Type;
import java.util.List;

public class InventoryDataManager {
    private static final String INVENTORY_FILE_PATH = "data/inventory.json";
    private static final Type INVENTORY_LIST_TYPE = new TypeToken<List<Inventory>>() {}.getType();

    private final MainDataManager<Inventory> inventoryManager;

    public InventoryDataManager() {
        this.inventoryManager = new MainDataManager<>(INVENTORY_FILE_PATH, INVENTORY_LIST_TYPE);
    }

    public MainDataManager<Inventory> getInventoryManager() {
        return inventoryManager;
    }

    // Add additional inventory-specific methods here if needed
}
