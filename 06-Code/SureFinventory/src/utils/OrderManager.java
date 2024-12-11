package utils;

import ec.edu.espe.surefinventory.model.Order;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class OrderManager {
    private static final String orderFilePath = "data/orders.json";
    private static final Type orderListType = new TypeToken<List<Order>>() {}.getType();
    private static final MainDataManager<Order> orderDataManager = new MainDataManager<>(orderFilePath, orderListType);

    public static MainDataManager<Order> getOrderDataManager() {
        return orderDataManager;
    }
}
