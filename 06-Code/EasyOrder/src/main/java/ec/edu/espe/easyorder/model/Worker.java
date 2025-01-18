package ec.edu.espe.easyorder.model;

/**
 *
 * @author Esteban Quiroga
 */
public class Worker {

    private String userName;
    private String password;
    private char type;

    public Worker(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cashier{" + "userName=" + userName + ", password=" + password + '}';
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
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
    public String getuserName() {
        return userName;
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
    public void setuserName(String username) {
        this.userName = username;
    }


    
}
    
