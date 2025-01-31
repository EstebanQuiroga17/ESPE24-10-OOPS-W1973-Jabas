package ec.edu.espe.easyorder.model;

/**
 *
 * @author Matias Rojas
 */
public class Customer {
    private String name;
    private int id;
    private String phoneNumber;
    private String lastName;

    public Customer(String name, int id, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, int id, String phoneNumber, String lastName) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", id=" + id + ", phoneNumber=" + phoneNumber + ", lastName=" + lastName + '}';
    }

    
    /**
     * @return the naeme
     */
    public String getName() {
        return name;
    }

    /**
     * @param naeme the naeme to set
     */
    public void setName(String naeme) {
        this.name = naeme;
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
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
