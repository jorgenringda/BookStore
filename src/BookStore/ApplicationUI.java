package BookStore;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user
 *
 * @author Ultrareidar
 * @version 1.0
 */
public class ApplicationUI {

    MagazineRegister magazine;

    /**
     * The menu that will be displayed.
     */
    private final String[] menuItems;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {

        this.magazine = new MagazineRegister();
        this.menuItems = new String[]{
            "1. Add new magazine",
            "2. List all magazine",
            "3. Search magazine by title",
            "4. Search a magazine by publisher",
            "5. Remove a magazine by title"};
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() {
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
                        System.out.println("\nThank you for using "
                                + "Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
                if (!quit) {
                    typeToContinue();
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number "
                        + "between 1 and " + this.menuItems.length + "..\n");
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

    /**
     * method that returns input from user as a string
     *
     * @return input returns input typed by user as a string
     */
    private String getStringInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        System.out.println();

        return input;
    }

    /**
     * method that returns input from user as a integer
     *
     * @return input returns input typed by user as a integer
     */
    private int getIntInput() {
        Scanner reader = new Scanner(System.in);
        int input;
        try {
            input = reader.nextInt();
        } catch (InputMismatchException error) {
            System.out.println("Please enter a valid number");
            input = getIntInput();
        }
        return input;
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllProducts() {
        Iterator<Magazine> test = magazine.listAllMagazine();
        while (test.hasNext()) {
            System.out.println(getDetails(test.next()));
        }
        System.out.println(magazine.clock());
    }

    /**
     * Add a new product/literature to the register. First reading the input
     * value and stores it. When all variable is set its add the magazine if the
     * inputs are valid.
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
     * find the magazine or magazines that contains the title typed by user
     */
    private void searchProductByTitle() {
        System.out.println("type title of magazine: ");
        String title = getStringInput();
        Iterator<Magazine> test = magazine.getMagazineByTitle(title);
        while (test.hasNext()) {
            System.out.println(getDetails(test.next()));
        }
        System.out.println(magazine.clock());
    }

    /**
     * find the magazine or magazines that contains the publisher typed by user
     */
    private void searchProductByPublisher() {
        System.out.println("type publisher of magazine: ");
        String publisher = getStringInput();
        Iterator<Magazine> test = magazine.getMagazineByPublisher(publisher);
        while (test.hasNext()) {
            System.out.println(getDetails(test.next()));
        }
        System.out.println(magazine.clock());
    }

    /**
     * removes the magazine that has the equals title to the input typed by user
     */
    private void removeProductByTitle() {
        System.out.println("type title of magazine to be removed: ");
        String title = getStringInput();
        magazine.removeMagazineByTitle(title);
    }

    /**
     * method to stop the application until any key is typed. this is for not
     * displaying the menu list, before the user have read the error message or
     * other messages.
     */
    private void typeToContinue() {
        System.out.println();
        System.out.println("type anything to contine ");
        try {
            System.in.read();
        } catch (IOException error) {
            System.out.println("No key enter");
        }
    }

    /**
     * builds a string which contains all info about the magazine we set
     *
     * @param publication magazine that we want to get information about
     * @return details Returns all details about the magazine that is set.
     */
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
