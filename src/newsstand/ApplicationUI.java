package newsstand;

import newsstand.literature.Literature;
import newsstand.view.NewspaperView;
import newsstand.view.BookView;
import newsstand.literature.Newspaper;
import newsstand.literature.Magazine;
import newsstand.literature.Book;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import newsstand.view.MagazineView;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user
 *
 * @author Ultrareidar
 * @version 1.0
 */
public class ApplicationUI {

    NewspaperView newspaper;
    BookView book;
    MagazineView magazine;
    Register literature;
    ArrayList<Literature> removeMagazinesList;
    boolean back;

    /**
     * defining variables to use in switch-case for print out error message.
     */
    private enum ErrorMessage {
        noTitle, emptyList, noMagazine, noPublisher,
        notRemovedTitle, magazineNotAdded,
    }

    /**
     * The menu that will be displayed.
     */
    private final String[] menuItems;
    private final String[] typeLiterature;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
        newspaper = new NewspaperView();
        book = new BookView();
        magazine = new MagazineView();

        this.literature = new Register();

        this.menuItems = new String[]{
            "1. Add new literature",
            "2. List all literature",
            "3. Search magazine by title",
            "4. Search a magazine by publisher",
            "5. Remove a magazine by title",
            "6. Enter Shop"};

        this.typeLiterature = new String[]{
            "1. Magazine",
            "2. Book",
            "3. Newspaper",
            "4. Return"};

        /**
         * this.shopMenu = new String[]{ "1. Magazine", "2. Book", "3.
         * Newspaper", "4. Return"};
         */
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
                        this.enterShop();
                        break;

                    case 7:
                        System.out.println("\nThank you for using "
                                + "Application v2.1 Bye!\n");
                        quit = true;
                        break;

                    default:
                }
                if (!quit && !back) {
                    typeEnterToContinue();
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

        System.out.println("\n**** Application v2.1 ****\n");
        // Display the menu
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-"
                + maxMenuItemNumber + "): \n");
        // Read input from user
        int menuSelection = getIntInput();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    /**
     * Method that returns input from user as a string
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
     * Method that returns input from user as a integer
     *
     * @return input returns input typed by user as a integer
     */
    private int getIntInput() {
        Scanner reader = new Scanner(System.in);
        int input;
        try {
            input = reader.nextInt();
        } catch (InputMismatchException error) {
            System.out.println("\nPlease enter a valid number\n");
            input = getIntInput();
        }
        return input;
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllProducts() {
        int number = 1;
        Iterator<Literature> allMagazine = literature.getAllLiteratureIterator();
        if (allMagazine.hasNext()) {
            while (allMagazine.hasNext()) {
                System.out.println("\n" + number + "  |  " + getDetails(allMagazine.next()));
                number++;
            }
            System.out.println(clock());
        } else {
            printError(ErrorMessage.emptyList);
        }

    }

    private int setTypeLiterature() {
        System.out.println("\n**** Application v2.1 ****\n");
        // Display the menu
        for (String Literature : typeLiterature) {
            System.out.println(Literature);
        }
        int maxMenuItemNumber = typeLiterature.length;
        // Add the "Exit"-choice to the menu
        System.out.println("Please choose number between (1-"
                + maxMenuItemNumber + "): \n");
        // Read input from user
        int literatureSelection = getIntInput();
        if ((literatureSelection < 1) || (literatureSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return literatureSelection;
    }

    /**
     * Add a new product/literature to the register. First reading the input
     * value and stores it. When all variable is set its add the magazine if the
     * inputs are valid.
     */
    private void addNewProduct() {

        back = false;
        while (!back) {
            try {
                int literatureSelection = this.setTypeLiterature();
                switch (literatureSelection) {
                    case 1:
                        Magazine magazineToAdd = this.magazine.createMagazine();
                        literature.addLiterature(magazineToAdd);
                        break;

                    case 2:
                        Book bookToAdd = this.book.createBook();
                        literature.addLiterature(bookToAdd);
                        break;

                    case 3:
                        Newspaper newspaperToAdd = this.newspaper.createNewspaper();
                        literature.addLiterature(newspaperToAdd);
                        break;

                    case 4:
                        back = true;
                        break;

                    default:
                }
                if (!back) {
                    typeEnterToContinue();
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number "
                        + "between 1 and " + this.menuItems.length + "..\n");
            }
        }
    }

    /**
     * Find the magazine or magazines that contains the title typed by user
     */
    private void searchProductByTitle() {
        System.out.println("\ntype title of literature: \n");
        String title = getStringInput();
        if (title == null) {
            printError(ErrorMessage.noTitle);
        } else {
            Iterator<Literature> allLiteratureByTitle
                    = literature.getLiteratureByTitle(title);
            if (allLiteratureByTitle.hasNext()) {
                while (allLiteratureByTitle.hasNext()) {
                    System.out.println(getDetails(allLiteratureByTitle.next()));
                }
                System.out.println(clock());
            } else {
                printError(ErrorMessage.noMagazine);
            }
        }
    }

    /**
     * Find the magazine or magazines that contains the publisher typed by user
     */
    private void searchProductByPublisher() {
        System.out.println("\ntype publisher of literature: \n");
        String publisher = getStringInput();
        if (publisher == null) {
            printError(ErrorMessage.noPublisher);
        } else {
            Iterator<Literature> allLiteratureByMagazine
                    = literature.getLiteraturesByPublisher(publisher);
            if (allLiteratureByMagazine.hasNext()) {
                while (allLiteratureByMagazine.hasNext()) {
                    System.out.println(getDetails(allLiteratureByMagazine.next()));
                }
                System.out.println(clock());
            } else {
                printError(ErrorMessage.noMagazine);
            }
        }
    }

    /**
     * List a list of magazines that you can remove found from the input, typed
     * by user. Removes the magazine at the index user choose.
     */
    private void removeProductByTitle() {
        System.out.println("\ntype title of magazine to be removed: \n");

        String title = getStringInput();
        removeMagazinesList = new ArrayList<>();
        int number = 1;
        if (title == null) {
            printError(ErrorMessage.noTitle);
        } else {
            Iterator<Literature> magazinesToRemove
                    = literature.getLiteratureToRemoveByTitle(title);
            if (magazinesToRemove.hasNext()) {
                magazinesToRemove.forEachRemaining(removeMagazinesList::add);
                for (Literature test : removeMagazinesList) {

                    System.out.println(number + " | " + getDetails(test));
                    number++;
                }
                System.out.println(clock());
                number--;
                if (removeMagazinesList.size() == 1) {
                    System.out.println("Do you want to delete this literature? "
                            + "\nIf yes, type Yes, else type anything and enter\n");
                    String yes = getStringInput();
                    if (yes.trim().toUpperCase().equals("YES")) {
                        System.out.println("title: "
                                + removeMagazinesList.get(0).getTitle());
                        if (removeMagazinesList.get(0).getQuantity() <= 1) {
                            System.out.print("  | Literature stock is decreased by 1");
                        } else {
                            System.out.print(" is removed");
                        }
                        literature.removeLiterature(removeMagazinesList.get(0));
                    }
                } else {
                    System.out.println("Please choose number between (1-" + number
                            + " to remove): \n");
                    number = getIntInput() - 1;
                    literature.removeLiterature(removeMagazinesList.get(number));
                    System.out.println("title: "
                            + removeMagazinesList.get(number).getTitle()
                            + " is removed");
                }
            } else {
                printError(ErrorMessage.noMagazine);
            }

        }
    }

    /**
     * Add a new product/literature to the register. First reading the input
     * value and stores it. When all variable is set its add the magazine if the
     * inputs are valid.
     */
    private void enterShop() {

        back = false;
        while (!back) {
            try {
                int literatureSelection = this.setTypeLiterature();
                switch (literatureSelection) {
                    case 1:
                        Magazine magazineToAdd = this.magazine.createMagazine();
                        literature.addLiterature(magazineToAdd);
                        break;

                    case 2:
                        Book bookToAdd = this.book.createBook();
                        literature.addLiterature(bookToAdd);
                        break;

                    case 3:
                        Newspaper newspaperToAdd = this.newspaper.createNewspaper();
                        literature.addLiterature(newspaperToAdd);
                        break;

                    case 4:
                        back = true;
                        break;

                    default:
                }
                if (!back) {
                    typeEnterToContinue();
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number "
                        + "between 1 and " + this.menuItems.length + "..\n");
            }
        }
    }

    /**
     * Method to stop the application until enter is pressed. this is for not
     * displaying the menu list, before the user have read the error message or
     * other messages.
     */
    private void typeEnterToContinue() {
        System.out.println();
        System.out.println("type enter to contine ");
        try {
            System.in.read();
        } catch (IOException error) {
            System.out.println("No key enter");
        }
    }

    /**
     * Builds a string which contains all info about the magazine we set
     *
     * @param publication magazine that we want to get information about
     * @return details Returns all details about the magazine that is set.
     */
    private StringBuilder getDetails(Literature publication) {
        StringBuilder details = new StringBuilder();
        if (publication instanceof Book) {
            details.append(book.getDetailsOfBook((Book) publication));
        }
        if (publication instanceof Magazine) {
            details.append(magazine.getDetailsOfMagazine((Magazine) publication));
        }
        if (publication instanceof Newspaper) {
            details.append(newspaper.getDetailsOfNewspaper((Newspaper) publication));
        }
        details.append("\n");
        return details;
    }

    /**
     * Reads real time clock, returns is a string in minutes and hours.
     *
     * @return the real time clock as a string
     */
    private StringBuilder clock() {
        StringBuilder clock = new StringBuilder();
        LocalTime time = LocalTime.now();
        clock.append("\nTime: ");
        clock.append((time.getHour() > 9)
                ? ("" + time.getHour()) : ("0" + time.getHour()));
        clock.append(" : ");
        clock.append((time.getMinute() > 9)
                ? ("" + time.getMinute()) : ("0" + time.getMinute()));
        return clock;
    }

    /**
     * Prints out an error message set by the parameter error.
     *
     * @param error contains an enum used to print out the correct error message
     */
    private void printError(ErrorMessage error) {
        StringBuilder errorString = new StringBuilder();
        errorString.append("\nERROR: ");
        switch (error) {
            case noTitle:
                errorString.append("Don't have a title to use");
                break;
            case emptyList:
                errorString.append("No magazine to list");
                break;
            case noMagazine:
                errorString.append("Didnt find the magazine you searched for");
                break;
            case noPublisher:
                errorString.append("Don't have a publisher to use");
                break;
            case notRemovedTitle:
                errorString.append("Magazine is not removed, "
                        + "magazine title does not exsist");
                break;
            case magazineNotAdded:
                errorString.append("Magazine is not added, "
                        + "input is not correct\n");
                break;
        }
        System.out.println(errorString);
    }
}
