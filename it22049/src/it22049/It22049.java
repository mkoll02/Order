package it22049;

import it22049.menus.HomeMenu;
import it22049.stores.InitializeData;


public class It22049 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InitializeData.init();
        HomeMenu.runMenu();
    }
    
}
