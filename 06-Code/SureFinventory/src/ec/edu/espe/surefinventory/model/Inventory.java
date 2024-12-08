package ec.edu.espe.surefinventory.model;


import java.time.LocalDateTime;

/**
 *
 * @author Esteban Quiroga
 */
public class Inventory {
   
    
    private LocalDateTime lastUpdated;
    private Product productList;
    private int totalQuantity;

    public Inventory(LocalDateTime lastUpdated, Product productList, int totalQuantity) {
        this.lastUpdated = lastUpdated;
        this.productList = productList;
        this.totalQuantity = totalQuantity;
    }

    @Override
    public String toString() {
        return "Inventory{" + "lastUpdated=" + lastUpdated + ", productList=" + productList + ", totalQuantity=" + totalQuantity + '}';
    }
    
    /**
     * @return the lastUpdated
     */
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the productList
     */
    public Product getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(Product productList) {
        this.productList = productList;
    }

    /**
     * @return the totalQuantity
     */
    public int getTotalQuantity() {
        return totalQuantity;
    }

    /**
     * @param totalQuantity the totalQuantity to set
     */
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    
    public void updateInventory(Inventory inventory){
        
    }
    
    public void deleteInventory(Inventory inventory){
        
    }

    
}
