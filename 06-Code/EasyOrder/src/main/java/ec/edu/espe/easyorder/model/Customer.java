package ec.edu.espe.easyorder.model;

/**
 *
 * @author Matias Rojas
 */
public class Customer {
    private String name;
    private int id;
    private String phoneNumber;

    public Customer(String name, int id, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "naeme=" + name + ", id=" + id + ", phoneNumber=" + phoneNumber + '}';
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
    
    
}
