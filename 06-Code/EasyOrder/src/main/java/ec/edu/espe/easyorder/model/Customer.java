package ec.edu.espe.easyorder.model;

/**
 *
 * @author Matias Rojas
 */
public class Customer {
    private String name;
    private int id;
    private int phoneNumber;

    public Customer(String name, int id, int phoneNumber) {
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
    public String getNaeme() {
        return name;
    }

    /**
     * @param naeme the naeme to set
     */
    public void setNaeme(String naeme) {
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
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
