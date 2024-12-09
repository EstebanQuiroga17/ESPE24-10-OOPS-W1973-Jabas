

package utils;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */

import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Cashier;
import ec.edu.espe.surefinventory.model.Manager;

import java.lang.reflect.Type;
import java.util.List;

public class AdminDataManager {
    private static final String CASHIER_FILE_PATH = "data/cashiers.json";
    private static final String MANAGER_FILE_PATH = "data/managers.json";

    private static final Type CASHIER_LIST_TYPE = new TypeToken<List<Cashier>>() {}.getType();
    private static final Type MANAGER_LIST_TYPE = new TypeToken<List<Manager>>() {}.getType();

    private static final MainDataManager<Cashier> cashierManager = new MainDataManager<>(CASHIER_FILE_PATH, CASHIER_LIST_TYPE);
    private static final MainDataManager<Manager> managerManager = new MainDataManager<>(MANAGER_FILE_PATH, MANAGER_LIST_TYPE);

    /**
     * Adds a new Cashier to the system and saves the data.
     *
     * @param cashier the Cashier object to add
     */
    public static void addCashier(Cashier cashier) {
        cashierManager.addItem(cashier);
        System.out.println("Cashier added successfully: " + cashier);
    }

    /**
     * Retrieves the Cashier data manager.
     *
     * @return MainDataManager for Cashiers
     */
    public static MainDataManager<Cashier> getCashierManager() {
        return cashierManager;
    }

    /**
     * Retrieves the Manager data manager.
     *
     * @return MainDataManager for Managers
     */
    public static MainDataManager<Manager> getManagerManager() {
        return managerManager;
    }
}