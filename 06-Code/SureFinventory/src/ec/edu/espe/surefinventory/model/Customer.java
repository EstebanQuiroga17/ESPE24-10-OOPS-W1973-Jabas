package ec.edu.espe.surefinventory.model;

/**
 *
 * @author abner
 */
public class Customer {
   private String name;
   private int phoneNumber;
   private int id;

    public Customer(String name, int phoneNumber, int id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
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
        return id;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(int idNumber) {
        this.id = idNumber;
    }

    @Override
    public String toString() {
    return String.format(
        "%-10s | %-15s | %-10s%n" +
        "---------------------------------%n" +
        "%-10s | %-15s | %-10s",
        "Name", "Phone", "ID", 
        name, phoneNumber, id+
                "\n"
         
    );
}

    
   
}