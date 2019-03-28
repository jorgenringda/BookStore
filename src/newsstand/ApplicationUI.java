/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand;

import newsstand.Menu.StaffMenuUI;
import newsstand.Menu.ShopUI;
import java.util.InputMismatchException;
import newsstand.register.LiteratureRegister;

/**
 *
 * @author Ishmael
 */
public class ApplicationUI {

    /**
     * Creates a variable of ShopUI, StaffMenuUI and LiteratureRegister.
     */
    ShopUI shopUI;
    StaffMenuUI mainMenuUI;
    LiteratureRegister literature;

    /**
     * The menu that will be displayed.
     */
    private final String[] startMenu;

    /**
     * Constructor. Creates an Instance of ShopUI, StaffMenuUI and
     * LiteratureRegister. Also address value to the string[] startMenu.
     */
    public ApplicationUI() {
        shopUI = new ShopUI();
        mainMenuUI = new StaffMenuUI();
        literature = new LiteratureRegister();
        this.startMenu = new String[]{
            "Enter staff menu",
            "Enter shop menu",
            "Exit"};
    }

    /**
     * This is the main menu. But to access you need to get the code right.
     */
    public void start() {
        System.out.println("Welcome to this application!  0 0"
                + "\n                               o "
                + "\n                             |___|\n");
        boolean quit = shopUI.code();
        while (quit) {
            try {
                int menuSelection = shopUI.showMenu(this.startMenu);
                switch (menuSelection) {
                    case 1:
                        this.literature = mainMenuUI.mainMenu(literature);
                        break;
                    case 2:

                        this.literature = shopUI.enterShop(literature);

                        break;
                    case 3:
                        System.out.println("\nThank you for using "
                                + "Application v2.1 Bye!\n");
                        quit = false;
                        break;
                }

            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number "
                        + "between 1 and " + this.startMenu.length + "..\n");
            }
        }
    }

}
