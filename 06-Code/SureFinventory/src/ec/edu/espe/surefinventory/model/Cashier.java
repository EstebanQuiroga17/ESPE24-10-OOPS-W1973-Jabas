
package sureinventoryapp.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author abner
 */
public class Cashier {
    private String username;
    private String password;
    private int id;

    public Cashier(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10s | %-15s | %-10s%n" +
            "---------------------------------%n" +
            "%-10d | %-15s | %-10s",
            "ID", "Username", "Password",
            id, username, password,
            "\n"
        );
    }
    
    
    
    public static boolean logIn(String inputUsername, String inputPassword, String jsonFilePath){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));
            String jsonUsername = rootNode.get("userName").asText();
            String jsonPassword = rootNode.get("password").asText();
            
            return inputUsername.equals(jsonUsername) && inputPassword.equals(jsonPassword);
            
        }catch (IOException e) {
        System.err.println("Error reading JSON file: " + e.getMessage());
        }
          return false;         
        }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    

}
