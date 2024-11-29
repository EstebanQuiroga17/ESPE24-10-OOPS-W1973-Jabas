package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Esteban Quiroga
 */
public class Manager {
    private String username;
    private int id;
    private String password;
    
   
    
    

    public Manager(String username, int id, String password) {
        this.username = username;
        this.id = id;
        this.password = password;
    }
    
    
    public void changeInventory(Inventory inventory){
        //TODO code method
    }
    
    public void createCashier(Cashier cashier){
        //TODO code method
    }
    
    public void updateInventory(Inventory inventory){
        //TODO code method
    }
    
    public void closeCashRegister(){
        //TODO code method
    }
    
    public void editMenu(Menu menu){
        //TODO code method
        
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
   
}
