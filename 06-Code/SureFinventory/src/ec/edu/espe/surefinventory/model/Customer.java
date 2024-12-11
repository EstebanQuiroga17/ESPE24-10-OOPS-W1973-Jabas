package ec.edu.espe.surefinventory.model;

/**
 *
 * @author abner
 */
public class Customer {
   int id;
   String name;
   int phoneNumber;

    public Customer(int id, String name, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + '}';
    }
   
}