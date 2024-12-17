package ec.edu.espe.surefinventory.model;

/**
 *
 * @author abner
 */
public class Customer {
   private String name;
   private int phoneNumber;
   private int idNumber;

    public Customer(String name, int phoneNumber, int idNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
    }
   

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the idNumber
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", phoneNumber=" + phoneNumber + ", idNumber=" + idNumber + '}';
    }

    
   
}