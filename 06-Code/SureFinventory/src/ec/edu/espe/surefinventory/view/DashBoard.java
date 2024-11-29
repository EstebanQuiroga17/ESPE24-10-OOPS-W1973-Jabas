package ec.edu.espe.surefinventory.view;

import java.util.Scanner;

/**
 *
 * @author Esteban Quiroga
 */
public class DashBoard {
    
    private int menuOption;
    
    public void initMainMenu(DashBoard menu){
        System.out.println("SureFinventory \n"
        +   "Selecciona una opción para continuar...\n"
        + "1. Ingresar como admin.\n"
        + "2. Ingresar como mesero. \n");
        
       Scanner scanner = new Scanner(System.in);
       
       menu.setMenuOption(scanner.nextInt());
       
    }

    public DashBoard(int menuOption) {
        this.menuOption = menuOption;
    }

    /**
     * @return the menuOption
     */
    public int getMenuOption() {
        return menuOption;
    }

    /**
     * @param menuOption the menuOption to set
     */
    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }

   
    
    
        
    
}
