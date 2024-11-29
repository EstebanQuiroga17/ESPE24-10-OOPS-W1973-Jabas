package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Matias Rojas
 */
public class Cashier {
    private String username;
    private int id;
    private String password;

    public Cashier(String username, int id, String password) {
        this.username = username;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

