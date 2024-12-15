package ec.edu.espe.surefinventory.utils;

import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Cashier;
import ec.edu.espe.surefinventory.model.Manager;

import java.lang.reflect.Type;
import java.util.List;

public class AdminDataManager {
    private static final String cashierFilePath = "data/cashiers.json";
    private static final String managerFilePath = "data/managers.json";

    private static final Type cashierListType = new TypeToken<List<Cashier>>() {}.getType();
    private static final Type managerListType = new TypeToken<List<Manager>>() {}.getType();

    private static final MainDataManager<Cashier> cashierManager = new MainDataManager<>(cashierFilePath, cashierListType);
    private static final MainDataManager<Manager> managerManager = new MainDataManager<>(managerFilePath, managerListType);

    public static void addCashier(Cashier cashier) {
        cashierManager.addItem(cashier);
        System.out.println("Cashier added successfully: " + cashier);
    }

    public static MainDataManager<Cashier> getCashierManager() {
        return cashierManager;
    }

    public static MainDataManager<Manager> getManagerManager() {
        return managerManager;
    }
}
