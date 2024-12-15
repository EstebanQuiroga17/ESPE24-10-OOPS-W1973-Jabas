package ec.edu.espe.surefinventory.utils;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Inventory;

import java.lang.reflect.Type;
import java.util.List;

public class InventoryDataManager {
    private static final String inventoryFilePath = "data/inventory.json";
    private static final Type inventoryListType = new TypeToken<List<Inventory>>() {}.getType();

    private final MainDataManager<Inventory> inventoryManager;

    public InventoryDataManager() {
        this.inventoryManager = new MainDataManager<>(inventoryFilePath, inventoryListType);
    }

    public MainDataManager<Inventory> getInventoryManager() {
        return inventoryManager;
    }
}
