package newsstand.Menu;

import newsstand.publication.Publication;
import newsstand.publication.Newspaper;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import newsstand.publication.Book;
import newsstand.publication.Magazine;
import newsstand.publication.Movie;
import newsstand.register.publicationRegister;

/**
 * A sub-class. Class that are interacting with the user, and does this methods:
 * <ul>
 * <li> Add new publication </li>
 * <li> Add and removes quantity to/from a publication in stock </li>
 * <li> List all publication in register </li>
 * <li> Search after publication by title and publisher </li>
 * <li> Removes publication by title </li>
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
    private final String[] typePublication;

    /**
     * Creates the two menus and address what the menu option should say.
     */
    public StaffMenuUI() {
        super();
        this.menuItems = new String[]{
            "Add new publication",
            "Add more quantity to a publication in stock",
            "Remove quantity from a publication in stock",
            "List all publication",
            "Search after publication by title",
            "Search after publication by publisher",
            "Remove a publication by title",
            "Auto fyll",
            "Return"};

        this.typePublication = new String[]{
            "Magazine",
            "Book",
            "Newspaper",
            "Movie",
            "Return"};

    }

    /**
     * Showing the menu and retrieving input from the user.
     *
     * @param publication is the register with Publication the application is
     * using
     * @return the updated register
     */
    public publicationRegister mainMenu(publicationRegister publication) {
        this.publication = publication;
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
        return this.publication;
    }

    /**
     * Add a new product/publication to the register. First reading the input
     * value and stores it. When all variable is set its add the Publication if
     * the inputs are valid.
     */
    private void addNewProduct() {
        boolean publicationAdded = false;
        boolean back = false;
        while (!back) {
            try {
                int publicationSelection = showMenu(this.typePublication);
                switch (publicationSelection) {
                    case 1:
                        Magazine magazineToAdd
                                = this.magazine.createPublication();
                        publicationAdded
                                = this.publication.addPublication(magazineToAdd);
                        break;

                    case 2:
                        Book bookToAdd
                                = this.book.createPublication();
                        publicationAdded
                                = this.publication.addPublication(bookToAdd);
                        break;

                    case 3:
                        Newspaper newspaperToAdd
                                = this.newspaper.createPublication();
                        publicationAdded
                                = this.publication.addPublication(newspaperToAdd);
                        break;
                    case 4:
                        Movie movieToAdd
                                = this.movie.createPublication();
                        publicationAdded
                                = this.publication.addPublication(movieToAdd);
                        break;
                    case 5:
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
                        + this.typePublication.length + "..\n");
            }
            if (publicationAdded) {
                System.out.println("Publication is added");
            } else {
                printError(ErrorMessage.publicationNotAdded);
            }
        }
    }

    /**
     * Method to check if there is something in register and print out if it's
     * something there, or print out error message.
     */
    private void listAll() {
        if (!this.listAllProductsByIterator(this.publication.getPublicationInOrder())) {
            printError(ErrorMessage.emptyList);
        }
    }

    /**
     * Method to check if the register contains a Publication with the specific
     * title. Prints out all that have it, if no one contains the title it
     * prints error message.
     */
    private void listAllByTitle() {
        if (!this.listAllProductsByIterator(getProductsIteratorByTitle())) {
            printError(ErrorMessage.emptyList);
        }
    }

    /**
     * Method to check if the register contains a Publication with the specific
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
     * @return the Publication chosen by user
     */
    private Publication getInputPublication() {
        Publication publicationToAdd = null;
        int publicationToAddQuantity = validInput.getIntInput() - 1;
        if (this.publication.getPublicationByIndex(
                publicationToAddQuantity) != null) {
            publicationToAdd
                    = this.publication.getPublicationByIndex(
                            publicationToAddQuantity);
        } else {
            System.out.println("Did not add any amount because the number of "
                    + "the publication you want to add quantity to, "
                    + "does not exsist");
        }

        return publicationToAdd;
    }

    /**
     * Find the publication or publications that contains the title typed by
     * user, and adds it in an ArrayList.
     *
     * @return an Iterator of all Publication containing the title
     */
    private Iterator<Publication> getProductsIteratorByTitle() {
        System.out.println("\ntype title of publication: \n");
        String title = validInput.getStringInput();
        Iterator<Publication> allPublicationByTitle = null;
        if (title == null) {
            printError(ErrorMessage.noTitle);
        } else {
            allPublicationByTitle
                    = this.publication.getPublicationByTitle(title);
        }
        return allPublicationByTitle;
    }

    /**
     * Find the Publication or publications that contains the publisher typed by
     * user, and adds it in an ArrayList.
     *
     * @return an Iterator of all Publication containing the publisher
     */
    private Iterator<Publication> getProductIteratorByPublisher() {
        System.out.println("\ntype publisher of publication: \n");
        String publisher = validInput.getStringInput();
        Iterator<Publication> allPublicationByPublisher = null;
        if (publisher == null) {
            printError(ErrorMessage.noPublisher);
        } else {
            allPublicationByPublisher
                    = this.publication.getPublicationsByPublisher(publisher);

        }
        return allPublicationByPublisher;
    }

    /**
     * List a list of Publication that you can remove found from the input,
     * typed by user. Removes the publication at the index user choose.
     */
    private void removeProductByTitle() {
        System.out.println("Type the title of publication you want to remove");
        String title = validInput.getStringInput();
        ArrayList<Publication> removePublicationList;
        removePublicationList = new ArrayList<>();
        Iterator<Publication> publicationToRemoveIterator
                = this.publication.getPublicationByTitle(title);
        if (publicationToRemoveIterator.hasNext()) {
            publicationToRemoveIterator.forEachRemaining(
                    removePublicationList::add);
            listAllProductsByIterator(removePublicationList.iterator());
            Publication publicationToRemove
                    = decideProductToRemove(removePublicationList);
            if (publicationToRemove != null) {
                if (publicationToRemove.getQuantity() > 1) {
                    System.out.println("title: "
                            + publicationToRemove.getTitle()
                            + "  | Publication stock is decreased by 1");
                    publicationToRemove.decreaseStock();
                } else {
                    System.out.println("title: "
                            + publicationToRemove.getTitle()
                            + " | Publication is remove");
                    this.publication.removePublication(publicationToRemove);
                }
            } else {
                System.out.println("No product have been removed");
            }
        } else {
            printError(ErrorMessage.noPublication);

        }
    }

    /**
     * Method that adds quantity to stock.
     */
    private void addQuantity() {
        if (listAllProductsByIterator(this.publication.getIterator())) {
            System.out.println("Enter the number of the "
                    + "publication you want to add quantity to!");
            Publication publicationToAdd = getInputPublication();
            if (publicationToAdd != null) {
                System.out.println("Enter the amount you want to add: ");
                int quantity = validInput.getIntInput();
                System.out.println("You have now added "
                        + quantity + " to " + publicationToAdd.getTitle());
                publicationToAdd.addOrRemoveStock(quantity);
            }
        } else {
            System.out.println("\nNo publication in newsstand");
        }
    }

    /**
     * Method that removes quantity from stock.
     */
    private void removeQuantity() {
        if (listAllProductsByIterator(this.publication.getIterator())) {
            System.out.println("Enter the number of the "
                    + "publication you want to remove quantity from!");
            Publication publicationToAdd = getInputPublication();
            if (publicationToAdd != null) {
                System.out.println("Enter the amount you want to remove: ");
                int quantity = validInput.getIntInput();
                if (publicationToAdd.getQuantity() - quantity >= 1) {
                    System.out.println("You have now removed "
                            + quantity + " from " + publicationToAdd.getTitle());
                    publicationToAdd.addOrRemoveStock(quantity);
                } else if (publicationToAdd.getQuantity() - quantity < 0) {
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
            System.out.println("\nNo publication in newsstand");
        }
    }

    /**
     * Method that get input from user that is choosing an index of an ArrayList
     * of Publication that can be removed from register.
     *
     * @param removePublicationList is the list with Publication that we can
     * remove from register
     * @return the Publication that is going to be removed
     */
    private Publication decideProductToRemove(
            ArrayList<Publication> removePublicationList) {
        int number = removePublicationList.size();
        Publication publicationToRemove = null;
        if (removePublicationList.size() > 1) {
            System.out.println("Please choose number between (1-" + number
                    + " to remove): \n");
            number = validInput.getIntInput() - 1;
            publicationToRemove = removePublicationList.get(number);

        } else {
            System.out.println("Do you want to delete/decrease "
                    + "stock of this publication? "
                    + "\nIf yes, type Yes, else type anything and enter\n");
            String yes = validInput.getStringInput();
            if (yes.trim().toUpperCase().equals("YES")) {
                publicationToRemove = removePublicationList.get(0);
            }
        }
        return publicationToRemove;
    }

    private void auto() {
        Magazine mag = new Magazine("hei", "nei", "sport", 2, 4, 3);
        Magazine mag1 = new Magazine("t", "nei", "sport", 2, 7, 1);
        Magazine mag2 = new Magazine("helty", "nei", "sport", 2, 4, 1);
        this.publication.addPublication(mag2);
        this.publication.addPublication(mag);
        this.publication.addPublication(mag1);

    }
}
