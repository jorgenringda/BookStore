package BookStore;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user.
 *
 * @author Ultrareidar
 * @version 1.0
 */
public class ApplicationUI {

    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    MagazineRegister magazine = new MagazineRegister();
    private String[] menuItems = {
        "1. Add new magazine",
        "2. List all magazine",
        "3. Search magazine by title",
        "4. Search a magazine by publisher",
        "5. Remove a magazine by title",};

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() {
        this.init();

        boolean quit = false;

        while (!quit) {
            try {
                int menuSelection = this.showMenu();
                switch (menuSelection) {
                    case 1:
                        this.addNewProduct();
                        break;

                    case 2:
                        this.listAllProducts();
                        break;

                    case 3:
                        this.searchProductByTitle();
                        break;

                    case 4:
                        this.searchProductByPublisher();
                        break;

                    case 5:
                        this.removeProductByTitle();
                        break;

                    case 6:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
                if (!quit) {
                    typeToContinue();
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     * @throws InputMismatchException if user enters an invalid number/menu
     * choice
     */
    private int showMenu() throws InputMismatchException {

        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): \n");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    private String getStringInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        System.out.println();

        return input;
    }

    private int getIntInput() {
        Scanner reader = new Scanner(System.in);
        int input = 0;
        try {
            input = reader.nextInt();
        } catch (InputMismatchException error) {
            System.out.println("Please enter a valid number");
            input = getIntInput();
        }
        return input;
    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---
    /**
     * Initializes the application. Typically you would create the
     * LiteratureRegistrer-instance here
     */
    private void init() {

    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllProducts() {
        Iterator<Magazine> test = magazine.listAllMagazine().iterator();
        while (test.hasNext()) {
            System.out.println(getDetails(test.next()));
        }
        System.out.println(magazine.clock());
    }

    /**
     * Add a new product/literature to the register. In this method you have to
     * add code to ask the user for the necessary information you need to create
     * an instance of the product, which you then send as a parameter to the
     * addNewspaper()- method of the register. Remember to also handle invalid
     * input from the user!!
     */
    private void addNewProduct() {
        System.out.println("Set title of magazine: ");
        String title = getStringInput();
        System.out.println("Set publisher of magazine: ");
        String publisher = getStringInput();
        System.out.println("Set category of magazine: ");
        String category = getStringInput();
        System.out.println("Set release per year of magazine: ");
        int releasePerYear = getIntInput();
        magazine.addMagazine(title, publisher, category, releasePerYear);
    }

    /**
     * Find and display a product based om name (title). As with the
     * addNewProduct()-method, you have to ask the user for the string
     * (name/title/publisher) to search for, and then use this string as input-
     * parameter to the method in the register-object. Then, upon return from
     * the register, you need to print the details of the found item.
     */
    private void searchProductByTitle() {
        System.out.println("type title of magazine: ");
        String title = getStringInput();
        Iterator<Magazine> test = magazine.getMagazineByTitle(title).iterator();
        while (test.hasNext()) {
            System.out.println(getDetails(test.next()));
        }
        System.out.println(magazine.clock());
    }

    private void searchProductByPublisher() {
        System.out.println("type publisher of magazine: ");
        String publisher = getStringInput();
        Iterator<Magazine> test = magazine.getMagazineByPublisher(publisher).iterator();
        while (test.hasNext()) {
            System.out.println(getDetails(test.next()));
        }
        System.out.println(magazine.clock());
    }

    private void removeProductByTitle() {
        System.out.println("type title of magazine to be removed: ");
        String title = getStringInput();
        magazine.removeMagazineByTitle(title);
    }

    private void typeToContinue() {
        System.out.println();
        System.out.println("type anything to contine ");
        try {
            System.in.read();
        } catch (IOException error) {
            System.out.println("No key enter");
        }
    }

    private StringBuilder getDetails(Magazine publication) {
        StringBuilder details = new StringBuilder();
        details.append("\nTitle: ");
        details.append(publication.getTitle());
        details.append("\nPublisher: ");
        details.append(publication.getPublisher());
        details.append("\nCategory: ");
        details.append(publication.getCategory());
        details.append("\nRelease Per Year: ");
        details.append(publication.getReleasePerYear());
        details.append("\n");
        return details;
    }
}
