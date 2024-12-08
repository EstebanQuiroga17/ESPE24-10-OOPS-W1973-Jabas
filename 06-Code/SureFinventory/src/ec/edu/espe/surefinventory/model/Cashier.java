package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Matias Rojas
 */
public class Cashier {
    private String username;
    private String password;

    public Cashier(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public void closeCashRegister() {
        System.out.println("Cash register closed by " + username);
    }

    // Getters and setters 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

