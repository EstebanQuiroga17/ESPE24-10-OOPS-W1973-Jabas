
package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import model.Item;

/**
 *
 * @author abner
 */
public class FileManager {
    private static final String FILE_NAME = "inventory.json";
    
    public static void saveToFile(List<Item> items) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = new Gson();
            gson.toJson(items, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Item> loadFromFile() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Gson gson = new Gson();
            java.lang.reflect.Type listType = new TypeToken<List<Item>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

