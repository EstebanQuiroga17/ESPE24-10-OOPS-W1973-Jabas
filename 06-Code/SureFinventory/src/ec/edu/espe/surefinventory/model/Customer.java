package ec.edu.espe.surefinventory.model;

import ec.edu.espe.surefinventory.utils.JsonFileManager;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Esteban Quiroga
 */
public class Customer {
   private String name;
   private String lastName;
   private int phoneNumber;
   private int id;

   public static Customer searchCustomerByLastName(String lastName){
       
       ArrayList<Customer> customers = new ArrayList<>();
       ArrayList<Customer> commonCustomers = new ArrayList<>();
       Path filePath = Paths.get("data","customer.json");
       Scanner scanner = new Scanner(System.in); 
       int index;
       
       JsonFileManager customerFileManager = new JsonFileManager(filePath);
       customers = customerFileManager.decerializeJson(Customer.class);

       for(Customer customer : customers){
           if(customer.getLastName().equals(lastName)){
               
            commonCustomers.add(customer);
               
           }
       }
       
       JsonFileManager.printJson(commonCustomers);
       
       System.out.println("Seleccione un cliente.");
       index = scanner.nextInt();
       
       return JsonFileManager.searchObjectByIndex(commonCustomers, index);
   }
   
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", id=" + id + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
}