
import java.util.ArrayList;
import java.util.List;
import model.Item;
import service.FileManager;



/**
 *
 * @author abner
 */
public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("person1", "Baked Portobello Mushrooms", (float) 12.00));
        items.add(new Item("person2", "Pickled Artichoke", (float) 12.00));
        items.add(new Item("person3", "Baked Eggplant", (float) 12.00));
        items.add(new Item("person4", "Baked Artichoke", (float) 12.00));
        items.add(new Item("person5", "Stuffed baked Tomatoes", (float) 12.00));
        items.add(new Item("person6", "Baked succini", (float) 12.00));
        
        FileManager.saveToFile(items);
        System.out.println("Inventario guardado en archivo JSON.");
        
        List<Item> loadedItems = FileManager.loadFromFile();
        
        if (loadedItems != null) {
            System.out.println("\nInventario cargado desde el archivo:");
            for (Item item : loadedItems) {
                System.out.println(item.getPersonsName() + ": " + item.getOrderName() + " unidades a $" + item.getPrice());
            }
        }
        else {
            System.out.println("No se pudo cargar el inventario.");
        }
        
    }
}
    
