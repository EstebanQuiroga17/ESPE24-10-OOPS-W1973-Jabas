package ec.edu.espe.easyorder.model;

/**
 *
 * @author Esteban Quiroga
 */
public class Worker {

    private String userName;
    private String password;
    private int type[]; // 1 is for Manager, 0 for cashier

    public Worker(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cashier{" + "userName=" + userName + ", password=" + password + '}';
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
    
