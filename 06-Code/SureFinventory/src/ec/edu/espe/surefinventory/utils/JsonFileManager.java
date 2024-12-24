
package ec.edu.espe.surefinventory.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;


/**
 *
 * @author Esteban Quiroga 
 */
public class JsonFileManager {
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Path filePath;
    
    
    public <T> ArrayList<T> decerializeJson(Class<T> clazz) {
        try (FileReader reader = new FileReader(filePath.toString())) {
         
            Type listType = TypeToken.getParameterized(ArrayList.class, clazz).getType();           
            
            ArrayList<T> objects = gson.fromJson(reader, listType);
            
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public <T> void printJson(ArrayList<T> arrayList){
        int index = 1; 
            for(T object : arrayList)
            {
                System.out.println(index + ":" + object);
                index++;
            }
    }
            
    public static <T> T searchObjectByIndex(ArrayList<T> objects,int index){
        
        T object = objects.get(index-1);
        return object;
    }
    
            
    public static <T> void changeAttribute(T object, String attributeName, Object newValue) {
        try {
           
            Class<?> clazz = object.getClass();
                      
            Field field = clazz.getDeclaredField(attributeName);
            field.setAccessible(true);  

            field.set(object, newValue);
            
            System.out.println("Atributo cambiado con exito.");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Error al cambiar el atributo.");
        }
    }
    
    public static <T> void deleteObjectByIndex(int index, ArrayList<T> objects){
        objects.remove(index-1); 
    }
    
    
    public <T> void updateJsonFile(ArrayList<T> objects) {
        try (FileWriter writer = new FileWriter(filePath.toString())) {            
            String json = gson.toJson(objects);          
            writer.write(json);
            writer.flush();

            System.out.println("Archivo JSON actualizado correctamente.");
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo JSON: " + ex.getMessage());

            ex.printStackTrace();
        }
    }
    
    
    public JsonFileManager(Path filePath) {
        this.filePath = filePath;
    }
    
}


