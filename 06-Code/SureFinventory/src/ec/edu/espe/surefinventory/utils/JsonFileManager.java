
package ec.edu.espe.surefinventory.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Customer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 *
 * @author Esteban Quiroga 
 */
public class JsonFileManager {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String filePath;
    FileReader reader;
    
    
    public <T> ArrayList<T> decerializeJson(Class<T> clazz) {
        try (FileReader reader = new FileReader(filePath)) {
         
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
            
    public static <T> T searchObjectByIndex(ArrayList<T> arrayList,int index){
        
        T object = arrayList.get(index-1);
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
    
    
    public void updateJsonFile(String json){
        try{
            FileWriter writer = new FileWriter(filePath);
            
            writer.write(json);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    
    public JsonFileManager(String filePath) {
        this.filePath = filePath;
    }
    
    
    public static void main(String[] args) {
        
        JsonFileManager customerFileManager = new JsonFileManager("06-Code/SureFinventory/data/customer.json");
        ArrayList<Customer> customers;
        
        customers = customerFileManager.decerializeJson(Customer.class);     
    }
}


