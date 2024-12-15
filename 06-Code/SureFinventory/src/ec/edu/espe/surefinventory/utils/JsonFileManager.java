
package ec.edu.espe.surefinventory.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Esteban Quiroga 
 */
public class JsonFileManager {
    Gson gson = new Gson();
    String filePath;
    FileReader reader;
    
    
    public <T> ArrayList<T> decerializeJson(){
        try(FileReader reader = new FileReader(filePath)){

            Type arrayList = new TypeToken<T>() {}.getType();
            
            ArrayList<T> objects = gson.fromJson(reader, arrayList);
            
            return objects;
            
            }catch(IOException e) {
                e.printStackTrace();
            }
        
        return null;
    }
    
    public <T> void updateObject(String attribute, T newValue){
        try{
            FileReader reader = new FileReader(filePath);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
            
            while(jsonObject.has(attribute)==false)
            {
                System.out.println("No se encontro el atributo."
                        + "\n Ingresa uno nuevo.\n");
                Scanner scanner = new Scanner(System.in);
                attribute = scanner.next();
            }
            
            if(newValue instanceof Number){
                jsonObject.addProperty(attribute, (Number) newValue);
            }
            else if(newValue instanceof String){
                jsonObject.addProperty(attribute, (String) newValue);
            }
            
            FileWriter writer = new FileWriter(filePath);
                gson.toJson(jsonObject, writer);
                writer.close();
            
            System.out.println("Atributo actualizado correctamente.\n");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonFileManager(String filePath) {
        this.filePath = filePath;
    }

    
    public static void main(String[] args) {
        JsonFileManager incomesManager = new JsonFileManager("C:\\Users\\TEVS\\ESPE2410-OOPSW1973-JABAS\\06-Code\\SureFinventory\\data\\incomes.json");
        
        System.out.println(incomesManager.decerializeJson());
    }
}


