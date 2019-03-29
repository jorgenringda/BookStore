package newsstand;

import newsstand.Menu.StaffMenuUI;
import newsstand.Menu.ShopUI;
import java.util.InputMismatchException;
import newsstand.register.publicationRegister;

/**
 *
 * @author UltraReidar
 */
public class ApplicationUI {

    /**
     * Creates a variable of ShopUI, StaffMenuUI and publicationRegister.
     */
    ShopUI shopUI;
    StaffMenuUI mainMenuUI;
    publicationRegister publication;

    /**
     * The menu that will be displayed.
     */
    private final String[] startMenu;

    /**
     * Constructor. Creates an Instance of ShopUI, StaffMenuUI and
     * PublicationRegister. Also address value to the string[] startMenu.
     */
    public ApplicationUI() {
        shopUI = new ShopUI();
        mainMenuUI = new StaffMenuUI();
        publication = new publicationRegister();
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
                        this.publication = mainMenuUI.mainMenu(publication);
                        break;
                    case 2:

                        this.publication = shopUI.enterShop(publication);

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
