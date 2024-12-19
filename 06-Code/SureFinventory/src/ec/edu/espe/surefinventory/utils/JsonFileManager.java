
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
import java.util.Scanner;


/**
 *
 * @author Esteban Quiroga 
 */
public class JsonFileManager {
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String filePath;
    
    
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
        
        JsonFileManager customerFileManager = new JsonFileManager("C:\\Users\\TEVS\\ESPE2410-OOPSW1973-JABAS\\06-Code\\SureFinventory\\data\\customer.json");
        ArrayList<Customer> customers;
        
        customers = customerFileManager.decerializeJson(Customer.class); 
        
        customerFileManager.printJson(customers);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Que objeto desea imprimir?");
        
        int index;
        
        index = scanner.nextInt();
        
        Customer customer1;
        
        customer1 = JsonFileManager.searchObjectByIndex(customers, index);
        
        System.out.println("Customer 1 es --> \n"+customer1);
        
        JsonFileManager.changeAttribute(customer1, "phoneNumber", 1234);
        
        System.out.println("Customer a cambiado su nombre...\n"+ customer1);
        
        customerFileManager.printJson(customers);
        
        System.out.println("Ingrese el indice del objeto que quiere borrar.");
        
        index = scanner.nextInt();
        
        JsonFileManager.deleteObjectByIndex(index, customers);
        
        System.out.println("La nueva lista es: \n");
        customerFileManager.printJson(customers);
        
        Gson gson1 = new Gson();
        String json = gson1.toJson(customers);
        customerFileManager.updateJsonFile(json);
    }
}


