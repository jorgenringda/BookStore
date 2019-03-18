package newsstand;

import java.io.IOException;
import java.time.LocalTime;
import newsstand.literature.Literature;
import newsstand.view.NewspaperView;
import newsstand.view.BookView;
import newsstand.literature.Newspaper;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import newsstand.literature.Book;
import newsstand.literature.Magazine;
import newsstand.shopping.Cart;
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

    Cart shoppingCart;
    GetInputs validInput;
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
    private final String[] shopMenu;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
        shoppingCart = new Cart();
        validInput = new GetInputs();
        newspaper = new NewspaperView();
        book = new BookView();
        magazine = new MagazineView();

        this.literature = new Register();

        this.menuItems = new String[]{
            "Add new literature",
            "Add more quantity to a literature in stock",
            "Remove quantity from a literature in stock",
            "List all literature",
            "Search magazine by title",
            "Search a magazine by publisher",
            "Remove a magazine by title",
            "Enter Shop"};

        this.typeLiterature = new String[]{
            "Magazine",
            "Book",
            "Newspaper",
            "Return"};

        this.shopMenu = new String[]{
            "Show all products in store",
            "Search after product by title",
            "Show shopping cart",
            "Remove product from cart",
            "Checkout",
            "Return"};

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
                        this.addQuantity();
                        break;

                    case 3:
                        this.removeQuantity();
                        break;

                    case 4:
                        this.listAllProductsByIterator(literature.getAllLiteratureIterator());
                        break;

                    case 5:
                        this.searchProductByTitle();
                        break;

                    case 6:
                        this.searchProductByPublisher();
                        break;

                    case 7:
                        this.removeProductByTitle();
                        break;

                    case 8:
                        this.enterShop();
                        break;

                    case 9:
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
        int menuNumber = 1;
        // Display the menu
        for (String menuItem : menuItems) {

            System.out.println(menuNumber + ". " + menuItem);
            menuNumber++;
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-"
                + maxMenuItemNumber + "): \n");
        // Read input from user
        int menuSelection = validInput.getIntInput();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    private int setTypeLiterature() {
        int menuNumber = 1;
        System.out.println("\n**** Application v2.1 ****\n");
        // Display the menu
        for (String Literature : typeLiterature) {
            System.out.println(menuNumber + ". " + Literature);
            menuNumber++;
        }
        int maxMenuItemNumber = typeLiterature.length;
        // Add the "Exit"-choice to the menu
        System.out.println("Please choose number between (1-"
                + maxMenuItemNumber + "): \n");
        // Read input from user
        int literatureSelection = validInput.getIntInput();
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
        boolean literatureAdded = false;
        back = false;
        while (!back) {
            try {
                int literatureSelection = this.setTypeLiterature();
                switch (literatureSelection) {
                    case 1:
                        Magazine magazineToAdd = this.magazine.createMagazine();
                        literatureAdded = literature.addLiterature(magazineToAdd);
                        break;

                    case 2:
                        Book bookToAdd = this.book.createBook();
                        literatureAdded = literature.addLiterature(bookToAdd);
                        break;

                    case 3:
                        Newspaper newspaperToAdd = this.newspaper.createNewspaper();
                        literatureAdded = literature.addLiterature(newspaperToAdd);
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
            if (literatureAdded) {
                System.out.println("Literature is added");
            } else {
                printError(ErrorMessage.magazineNotAdded);
            }
        }
    }

    private int showShopMenu() {
        int menuNumber = 1;
        System.out.println("\n**** Application v2.1 ****\n");
        // Display the show menu
        for (String shop : shopMenu) {
            System.out.println(menuNumber + ". " + shop);
            menuNumber++;
        }
        int maxMenuItemNumber = shopMenu.length;
        // Add the "Exit"-choice to the menu
        System.out.println("Please choose number between (1-"
                + maxMenuItemNumber + "): \n");
        // Read input from user
        int shopSelection = validInput.getIntInput();
        if ((shopSelection < 1) || (shopSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return shopSelection;
    }

    /**
     * Add a new product/literature to the register. First reading the input
     * value and stores it. When all variable is set its add the magazine if the
     * inputs are valid.
     */
    private void enterShop() {
        System.out.println("Please provide the code to enter the shop: ");
        if (validInput.getStringInput().trim().equals("9999")) {
            System.out.println("Code was correct you will now enter the shop!");
            back = false;
            while (!back) {
                try {
                    int shop = this.showShopMenu();
                    switch (shop) {
                        case 1:
                            listAllProductsByIterator(literature.getAllLiteratureIterator());
                            break;

                        case 2:
                            searchProductByTitle();
                            break;

                        case 3:
                            listAllProductsByIterator(shoppingCart.getCartIterator());
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
        } else {
            System.out.println("Code was not corret, you will now enter the start menu");
        }
    }

    /**
     * Lists all the products/literature in the register
     */
    private boolean listAllProductsByIterator(Iterator<Literature> allLiterature) {
        boolean hasLiteratureInList = false;
        int number = 1;
        if (allLiterature.hasNext()) {
            while (allLiterature.hasNext()) {
                System.out.println("\n" + number + "  |  " + getDetails(allLiterature.next()));
                number++;
            }
            System.out.println(clock());
            hasLiteratureInList = true;
        } else {
            printError(ErrorMessage.emptyList);
            hasLiteratureInList = false;
        }
        return hasLiteratureInList;
    }

    private void addQuantity() {
        if (listAllProductsByIterator(literature.getAllLiteratureIterator())) {
            System.out.println("Enter the number of the literature you want to add quantity to!");
            int literatureToAddQuantity = validInput.getIntInput();
            if (literature.getLiteratureByIndex(literatureToAddQuantity) != null) {
                Literature literatureToAdd
                        = this.literature.getLiteratureByIndex(literatureToAddQuantity);
                System.out.println("Enter the amount you want to add: ");
                int quantity = validInput.getIntInput();
                System.out.println("You have now added " + quantity + " to " + literatureToAdd);
                literatureToAdd.addOrRemoveStock(quantity);
            } else {
                System.out.println("Did not add any amount because the number of "
                        + "the literature you want to add quantity to, "
                        + "does not exsist");
            }
        } else {
            System.out.println("\nNo literature in newsstand");
        }
    }

    private void removeQuantity() {
        if (listAllProductsByIterator(literature.getAllLiteratureIterator())) {
            System.out.println("Enter the number of the literature you want to remove quantity from!");
            int literatureToAddQuantity = validInput.getIntInput() - 1;
            if (literature.getLiteratureByIndex(literatureToAddQuantity) != null) {
                Literature literatureToAdd
                        = this.literature.getLiteratureByIndex(literatureToAddQuantity);
                System.out.println("Enter the amount you want to remove: ");
                int quantity = validInput.getIntInput();
                System.out.println("You have now removed " + quantity + " from " + literatureToAdd);
                literatureToAdd.addOrRemoveStock(quantity);
            } else {
                System.out.println("Did not remove any amount because the number of "
                        + "the literature you want to add quantity to, "
                        + "does not exsist");
            }
        } else {
            System.out.println("\nNo literature in newsstand");
        }
    }

    /**
     * Find the literature or literatures that contains the title typed by user
     */
    private void searchProductByTitle() {
        System.out.println("\ntype title of literature: \n");
        String title = validInput.getStringInput();
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
     * Find the Literature or literatures that contains the publisher typed by
     * user
     */
    private void searchProductByPublisher() {
        System.out.println("\ntype publisher of literature: \n");
        String publisher = validInput.getStringInput();
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
     * List a list of Literature that you can remove found from the input, typed
     * by user. Removes the literature at the index user choose.
     */
    private void removeProductByTitle() {
        System.out.println("\ntype title of magazine to be removed: \n");

        String title = validInput.getStringInput();
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
                    if (removeMagazinesList.get(0).getQuantity() == 1) {
                        System.out.println("Do you want to delete this literature? "
                                + "\nIf yes, type Yes, else type anything and enter\n");
                        String yes = validInput.getStringInput();
                        if (yes.trim().toUpperCase().equals("YES")) {
                            System.out.println("title: "
                                    + removeMagazinesList.get(0).getTitle()
                                    + " is removed");

                            literature.removeLiterature(removeMagazinesList.get(0));
                        }
                    } else {
                        System.out.println("Do you want to delete this literature? "
                                + "\nIf yes, type Yes, else type anything and enter\n");
                        String yes = validInput.getStringInput();
                        if (yes.trim().toUpperCase().equals("YES")) {
                            System.out.println("title: "
                                    + removeMagazinesList.get(0).getTitle()
                                    + "  | Literature stock is decreased by 1");
                            removeMagazinesList.get(0).decreaseStock();
                        }
                    }
                } else {
                    System.out.println("Please choose number between (1-" + number
                            + " to remove): \n");
                    number = validInput.getIntInput() - 1;
                    literature.removeLiterature(removeMagazinesList.get(number));
                    System.out.println("title: "
                            + removeMagazinesList.get(number).getTitle()
                            + "  | Literature stock is decreased by 1");
                    removeMagazinesList.get(number).decreaseStock();
                }
            } else {
                printError(ErrorMessage.noMagazine);
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
