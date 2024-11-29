package ec.edu.espe.surefinventory.model;

import java.time.LocalDate;

/**
 *
 * @author Esteban Quiroga
 */
public class Inventory {
   
    int  id;
    String name;
    LocalDate creationDate;
    Product productList;
    
    public void stockStatus(){
        //TODO code stockStatus method
    }

    public void removeProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
