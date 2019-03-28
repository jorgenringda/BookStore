package newsstand.Menu;

import newsstand.literature.Literature;
import newsstand.literature.Newspaper;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import newsstand.literature.Book;
import newsstand.literature.Magazine;
import newsstand.register.LiteratureRegister;

/**
 * A sub-class. Class that are interacting with the user, and does this methods:
 * <ul>
 * <li> Add new literature </li>
 * <li> Add and removes quantity to/from a literature in stock </li>
 * <li> List all literature in register </li>
 * <li> Search after literature by title and publisher </li>
 * <li> Removes literature by title </li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public class StaffMenuUI extends Menu {

    /**
     * The menus that will be displayed.
     */
    private final String[] menuItems;
    private final String[] typeLiterature;

    /**
     * Creates the two menus and address what the menu option should say.
     */
    public StaffMenuUI() {
        super();
        this.menuItems = new String[]{
            "Add new literature",
            "Add more quantity to a literature in stock",
            "Remove quantity from a literature in stock",
            "List all literature",
            "Search after literature by title",
            "Search after literature by publisher",
            "Remove a literature by title",
            "Auto fyll",
            "Return"};

        this.typeLiterature = new String[]{
            "Magazine",
            "Book",
            "Newspaper",
            "Return"};

    }

    /**
     * Showing the menu and retrieving input from the user.
     *
     * @param literature is the register with Literature the application is
     * using
     * @return the updated register
     */
    public LiteratureRegister mainMenu(LiteratureRegister literature) {
        this.literature = literature;
        boolean quit = false;
        while (!quit) {
            try {
                int menuSelection = showMenu(this.menuItems);
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
                        this.listAll();
                        break;

                    case 5:
                        this.listAllByTitle();
                        break;

                    case 6:
                        this.listAllByPublisher();
                        break;

                    case 7:
                        this.removeProductByTitle();
                        break;

                    case 8:
                        this.auto();
                        break;

                    case 9:
                        System.out.println("\nYou will now return "
                                + "to menu selection\n");
                        quit = true;
                        break;

                    default:
                }
                if (!quit) {
                    typeEnterToContinue();
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number "
                        + "between 1 and " + this.menuItems.length + "..\n");

            }
        }
        return this.literature;
    }

    /**
     * Add a new product/literature to the register. First reading the input
     * value and stores it. When all variable is set its add the Literature if
     * the inputs are valid.
     */
    private void addNewProduct() {
        boolean literatureAdded = false;
        boolean back = false;
        while (!back) {
            try {
                int literatureSelection = showMenu(this.typeLiterature);
                switch (literatureSelection) {
                    case 1:
                        Magazine magazineToAdd
                                = this.magazine.createLiterature();
                        literatureAdded
                                = this.literature.addLiterature(magazineToAdd);
                        break;

                    case 2:
                        Book bookToAdd
                                = this.book.createLiterature();
                        literatureAdded
                                = this.literature.addLiterature(bookToAdd);
                        break;

                    case 3:
                        Newspaper newspaperToAdd
                                = this.newspaper.createLiterature();
                        literatureAdded
                                = this.literature.addLiterature(newspaperToAdd);
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
                        + "between 1 and "
                        + this.typeLiterature.length + "..\n");
            }
            if (literatureAdded) {
                System.out.println("Literature is added");
            } else {
                printError(ErrorMessage.literatureNotAdded);
            }
        }
    }

    /**
     * Method that adds quantity to stock.
     */
    private void addQuantity() {
        if (listAllProductsByIterator(this.literature.getIterator())) {
            System.out.println("Enter the number of the "
                    + "literature you want to add quantity to!");
            Literature literatureToAdd = getInputLiterature();
            if (literatureToAdd != null) {
                System.out.println("Enter the amount you want to add: ");
                int quantity = validInput.getIntInput();
                System.out.println("You have now added "
                        + quantity + " to " + literatureToAdd.getTitle());
                literatureToAdd.addOrRemoveStock(quantity);
            }
        } else {
            System.out.println("\nNo literature in newsstand");
        }
    }

    /**
     * Method that removes quantity from stock.
     */
    private void removeQuantity() {
        if (listAllProductsByIterator(this.literature.getIterator())) {
            System.out.println("Enter the number of the "
                    + "literature you want to remove quantity from!");
            Literature literatureToAdd = getInputLiterature();
            if (literatureToAdd != null) {
                System.out.println("Enter the amount you want to remove: ");
                int quantity = validInput.getIntInput();
                if (literatureToAdd.getQuantity() - quantity >= 1) {
                    System.out.println("You have now removed "
                            + quantity + " from " + literatureToAdd.getTitle());
                    literatureToAdd.addOrRemoveStock(quantity);
                } else if (literatureToAdd.getQuantity() - quantity < 0) {
                    System.out.println("The amount you want to remove is "
                            + "more than we have in stock, "
                            + "therefore not possible. "
                            + "\n\nPress enter to return to main menu");
                } else {
                    System.out.println("the amount you want to remove is"
                            + "the same as amount we have in stock."
                            + "\n\nType yes if you want to delete "
                            + "else type anything you will return to "
                            + "main menu");
                }
            }
        } else {
            System.out.println("\nNo literature in newsstand");
        }
    }

    /**
     * Method to check if there is something in register and print out if it's
     * something there, or print out error message.
     */
    private void listAll() {
        if (!this.listAllProductsByIterator(this.literature.getIterator())) {
            printError(ErrorMessage.emptyList);
        }
    }

    /**
     * Method to check if the register contains a Literature with the specific
     * title. Prints out all that have it, if no one contains the title it
     * prints error message.
     */
    private void listAllByTitle() {
        if (!this.listAllProductsByIterator(getProductsIteratorByTitle())) {
            printError(ErrorMessage.emptyList);
        }
    }

    /**
     * Method to check if the register contains a Literature with the specific
     * publisher. Prints out all that have it, if no one contains the publisher
     * it prints error message.
     */
    private void listAllByPublisher() {
        if (!this.listAllProductsByIterator(getProductIteratorByPublisher())) {
            printError(ErrorMessage.emptyList);
        }
    }

    /**
     * Gets input from user that have chosen an index of an arrayList to return.
     *
     * @return the Literature chosen by user
     */
    private Literature getInputLiterature() {
        Literature literatureToAdd = null;
        int literatureToAddQuantity = validInput.getIntInput() - 1;
        if (this.literature.getLiteratureByIndex(
                literatureToAddQuantity) != null) {
            literatureToAdd
                    = this.literature.getLiteratureByIndex(
                            literatureToAddQuantity);
        } else {
            System.out.println("Did not add any amount because the number of "
                    + "the literature you want to add quantity to, "
                    + "does not exsist");
        }

        return literatureToAdd;
    }

    /**
     * Find the literature or literatures that contains the title typed by user,
     * and adds it in an ArrayList.
     *
     * @return an Iterator of all Literature containing the title
     */
    private Iterator<Literature> getProductsIteratorByTitle() {
        System.out.println("\ntype title of literature: \n");
        String title = validInput.getStringInput();
        Iterator<Literature> allLiteratureByTitle = null;
        if (title == null) {
            printError(ErrorMessage.noTitle);
        } else {
            allLiteratureByTitle
                    = this.literature.getLiteratureByTitle(title);
        }
        return allLiteratureByTitle;
    }

    /**
     * Find the Literature or literatures that contains the publisher typed by
     * user, and adds it in an ArrayList.
     *
     * @return an Iterator of all Literature containing the publisher
     */
    private Iterator<Literature> getProductIteratorByPublisher() {
        System.out.println("\ntype publisher of literature: \n");
        String publisher = validInput.getStringInput();
        Iterator<Literature> allLiteratureByPublisher = null;
        if (publisher == null) {
            printError(ErrorMessage.noPublisher);
        } else {
            allLiteratureByPublisher
                    = this.literature.getLiteraturesByPublisher(publisher);

        }
        return allLiteratureByPublisher;
    }

    /**
     * List a list of Literature that you can remove found from the input, typed
     * by user. Removes the literature at the index user choose.
     */
    private void removeProductByTitle() {
        System.out.println("Type the title of literature you want to remove");
        String title = validInput.getStringInput();
        ArrayList<Literature> removeLiteratureList;
        removeLiteratureList = new ArrayList<>();
        Iterator<Literature> literatureToRemoveIterator
                = this.literature.getLiteratureToRemoveByTitle(title);
        if (literatureToRemoveIterator.hasNext()) {
            literatureToRemoveIterator.forEachRemaining(
                    removeLiteratureList::add);
            listAllProductsByIterator(removeLiteratureList.iterator());
            Literature literatureToRemove
                    = decideProductToRemove(removeLiteratureList);
            if (literatureToRemove != null) {
                if (literatureToRemove.getQuantity() > 1) {
                    System.out.println("title: "
                            + literatureToRemove.getTitle()
                            + "  | Literature stock is decreased by 1");
                    literatureToRemove.decreaseStock();
                } else {
                    System.out.println("title: "
                            + literatureToRemove.getTitle()
                            + " | Literature is remove");
                    this.literature.removeLiterature(literatureToRemove);
                }
            } else {
                System.out.println("No product have been removed");
            }
        } else {
            printError(ErrorMessage.noLiterature);

        }
    }

    /**
     * Method that get input from user that is choosing an index of an ArrayList
     * of Literature that can be removed from register.
     *
     * @param removeLiteratureList is the list with Literature that we can
     * remove from register
     * @return the Literature that is going to be removed
     */
    private Literature decideProductToRemove(
            ArrayList<Literature> removeLiteratureList) {
        int number = removeLiteratureList.size();
        Literature literatureToRemove = null;
        if (removeLiteratureList.size() > 1) {
            System.out.println("Please choose number between (1-" + number
                    + " to remove): \n");
            number = validInput.getIntInput() - 1;
            literatureToRemove = removeLiteratureList.get(number);

        } else {
            System.out.println("Do you want to delete/decrease "
                    + "stock of this literature? "
                    + "\nIf yes, type Yes, else type anything and enter\n");
            String yes = validInput.getStringInput();
            if (yes.trim().toUpperCase().equals("YES")) {
                literatureToRemove = removeLiteratureList.get(0);
            }
        }
        return literatureToRemove;
    }

    private void auto() {
        Magazine mag = new Magazine("hei", "nei", "sport", 2, 4, 3);
        Magazine mag1 = new Magazine("t", "nei", "sport", 2, 7, 1);
        Magazine mag2 = new Magazine("helty", "nei", "sport", 2, 4, 1);
        this.literature.addLiterature(mag2);
        this.literature.addLiterature(mag);
        this.literature.addLiterature(mag1);

    }
}
