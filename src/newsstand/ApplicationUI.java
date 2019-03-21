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
import java.util.Random;
import newsstand.literature.Book;
import newsstand.literature.Magazine;
import newsstand.register.CartRegister;
import newsstand.register.LiteratureRegister;
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

    int number;
    CartRegister shoppingCart;
    GetInputs validInput;
    NewspaperView newspaper;
    BookView book;
    MagazineView magazine;
    LiteratureRegister literature;
    boolean back;
    boolean firstTime;
    boolean code;

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
        shoppingCart = new CartRegister();
        validInput = new GetInputs();
        newspaper = new NewspaperView();
        book = new BookView();
        magazine = new MagazineView();
        number = 0;
        firstTime = true;
        code = false;
        this.literature = new LiteratureRegister();

        this.menuItems = new String[]{
            "Add new literature",
            "Add more quantity to a literature in stock",
            "Remove quantity from a literature in stock",
            "List all literature",
            "Search magazine by title",
            "Search a magazine by publisher",
            "Remove a magazine by title",
            "Enter Shop",
            "Auto fyll",
            "Exit"};

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
        while (code(true)) {
            boolean quit = false;
            while (!quit) {
                try {
                    int menuSelection = showMenu(this.menuItems);
                    code = true;
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
                            this.listAllProductsByIterator(literature.getIterator());
                            break;

                        case 5:
                            this.listAllProductsByIterator(getProductsIteratorByTitle());
                            break;

                        case 6:
                            this.listAllProductsByIterator(getProductIteratorByPublisher());
                            break;

                        case 7:
                            this.removeProductByTitle();
                            break;

                        case 8:
                            this.enterShop();
                            break;

                        case 9:
                            auto();
                            break;

                        case 10:
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
                int literatureSelection = showMenu(this.typeLiterature);
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

    /**
     * Add a new product/literature to the register. First reading the input
     * value and stores it. When all variable is set its add the magazine if the
     * inputs are valid.
     */
    private void enterShop() {
        while (code(true)) {
            showFeature();
            back = false;
            // boolean wantToAddMore = true;
            while (!back) {
                try {
                    int shop = showMenu(this.shopMenu);
                    boolean wantToAddMore = true;
                    firstTime = true;
                    switch (shop) {
                        case 1:
                            listAllProductsByIterator(literature.getIterator());
                            addToCart(literature.getIterator());
                            while (wantToAddMore) {
                                wantToAddMore = addMore(literature.getIterator());
                            }
                            break;

                        case 2:
                            System.out.println("\ntype title of literature: \n");
                            String title = validInput.getStringInput();
                            if (title == null) {
                                printError(ErrorMessage.noTitle);
                            }
                            listAllProductsByIterator(literature.getLiteratureByTitle(title));
                            addToCart(literature.getLiteratureByTitle(title));
                            while (wantToAddMore) {
                                wantToAddMore = addMore(literature.getLiteratureByTitle(title));
                            }
                            break;

                        case 3:
                            listAllProductsByIterator(shoppingCart.getIterator());
                            break;
                        case 4:
                            removeFromShoppingCart();
                            break;
                        case 5:

                            getPayment(getTotal());
                            break;
                        case 6:
                            code(false);
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
    }

    private boolean getPayment(int total) {
        boolean cancel = false;
        System.out.println("Do you want to cancel payment?"
                + "\nType Cancel if you want to cancel"
                + "\nType anything and then enter to proceed");
        if (validInput.getStringInput().trim().toUpperCase().equals("CANCEL")) {
            cancel = true;
            System.out.println("You have now cancel you payment, you will be sent back to the menu");
        } else {
            int payedMoney = 0;
            while (payedMoney < total) {
                System.out.println("Insert money as a number");
                payedMoney += validInput.getIntInput();
                if (payedMoney < total) {
                    System.out.println("You need to insert more money");
                } else if (payedMoney > total) {
                    int toReturn = payedMoney - total;
                    System.out.println("You have now payed more than you have to,"
                            + "you will be return " + toReturn + "$");
                } else {
                    System.out.println("You have payed the exact amount of money, thank you");
                }
            }
            System.out.println("You will now resive your products, enjoy");
            shoppingCart.clearCart();
        }
        return cancel;
    }

    private int getTotal() {
        int totalPrice = 0;
        Iterator<Literature> total = shoppingCart.getIterator();
        while (total.hasNext()) {
            totalPrice += shoppingCart.getTotalForEach(total.next());
        }
        System.out.println("Your total is: " + totalPrice + "$");
        return totalPrice;
    }

    private void removeFromShoppingCart() {
        ArrayList<Literature> removeList = new ArrayList<>();
        Iterator<Literature> cartIterator = shoppingCart.getIterator();
        listAllProductsByIterator(cartIterator);
        cartIterator.forEachRemaining(removeList::add);
        System.out.println("Are you sure you want to remove one of these products?"
                + "\nType yes if you want to remove a item from your basket");
        if (validInput.getStringInput().trim().toUpperCase().equals("YES")) {
            System.out.println("Type the number of product you want to remove:");
            int removeNumber = validInput.getIntInput() - 1;
            Literature literatureToRemove = shoppingCart.getLiteratureByIndex(removeNumber);
            literature.addLiterature(literatureToRemove);
            System.out.println("Literature : "
                    + literatureToRemove.getTitle()
                    + " is added to cart :)\n");
            shoppingCart.removeLiterature(literatureToRemove);
        }
    }

    private void showFeature() {
        System.out.println("You might like this: \n");
        ArrayList<Literature> random = new ArrayList<>();
        Iterator<Literature> randomLiterature = literature.getIterator();
        randomLiterature.forEachRemaining(random::add);
        if (!random.isEmpty()) {
            Random rand = new Random();
            System.out.println(getDetails(literature.getLiteratureByIndex(rand.nextInt(random.size()))));
        }
    }

    private void addToCart(Iterator<Literature> avalibelToAdd) {
        boolean addMore = false;
        if (firstTime) {
            firstTime = false;
            System.out.println("Do you want to add one of the items to your cart?"
                    + "\n\nType yes if you want to add to cart");
            if (validInput.getStringInput().trim().toUpperCase().equals("YES")) {
                addMore = true;
            }
        } else {
            addMore = true;
        }
        if (addMore) {
            System.out.println("Type the number of the literature you want to add");

            ArrayList<Literature> findLiteratureToAdd = new ArrayList<>();
            avalibelToAdd.forEachRemaining(findLiteratureToAdd::add);
            int addNumber = validInput.getIntInputMinMax(1, findLiteratureToAdd.size()) - 1;
            Literature literatureToAdd = literature.getLiteratureByIndex(addNumber);
            shoppingCart.addLiteratureToCart(literatureToAdd);
            System.out.println("Literature : "
                    + literatureToAdd.getTitle()
                    + " is added to cart :)\n");
            literature.removeLiterature(literatureToAdd);

        }
    }

    private Boolean addMore(Iterator<Literature> avalibelToAdd) {

        boolean wantToAddMore = false;
        System.out.println("Do you want to add more of the listed literature to cart?"
                + "\n\nType yes if you want to add more literature to cart");
        if (validInput.getStringInput().trim().toUpperCase().equals("YES")) {
            if (avalibelToAdd.hasNext()) {
                listAllProductsByIterator(literature.getIterator());
                addToCart(avalibelToAdd);
                wantToAddMore = true;
            } else {
                System.out.println("Where sold out, sorry :(");
            }
        }
        return wantToAddMore;
    }

    /**
     * Lists all the products/literature in the register
     */
    private boolean listAllProductsByIterator(Iterator<Literature> allLiterature) {
        boolean hasLiteratureInList = false;
        number = 1;
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
        if (listAllProductsByIterator(literature.getIterator())) {
            System.out.println("Enter the number of the literature you want to add quantity to!");
            Literature literatureToAdd = getInputLiterature();
            if (literatureToAdd != null) {
                System.out.println("Enter the amount you want to add: ");
                int quantity = validInput.getIntInput();
                System.out.println("You have now added " + quantity + " to " + literatureToAdd.getTitle());
                literatureToAdd.addOrRemoveStock(quantity);
            }
        } else {
            System.out.println("\nNo literature in newsstand");
        }
    }

    private void removeQuantity() {
        if (listAllProductsByIterator(literature.getIterator())) {
            System.out.println("Enter the number of the literature you want to remove quantity from!");
            Literature literatureToAdd = getInputLiterature();
            if (literatureToAdd != null) {
                System.out.println("Enter the amount you want to remove: ");
                int quantity = validInput.getIntInput();
                if (literatureToAdd.getQuantity() - quantity >= 1) {
                    System.out.println("You have now removed " + quantity + " from " + literatureToAdd.getTitle());
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
                            + "else type anything you will return to main menu");
                }
            }
        } else {
            System.out.println("\nNo literature in newsstand");
        }
    }

    private Literature getInputLiterature() {
        Literature literatureToAdd = null;
        int literatureToAddQuantity = validInput.getIntInput() - 1;
        if (literature.getLiteratureByIndex(literatureToAddQuantity) != null) {
            literatureToAdd
                    = this.literature.getLiteratureByIndex(literatureToAddQuantity);
        } else {
            System.out.println("Did not add any amount because the number of "
                    + "the literature you want to add quantity to, "
                    + "does not exsist");
        }

        return literatureToAdd;
    }

    /**
     * Find the literature or literatures that contains the title typed by user
     */
    private Iterator<Literature> getProductsIteratorByTitle() {
        System.out.println("\ntype title of literature: \n");
        String title = validInput.getStringInput();
        Iterator<Literature> allLiteratureByTitle = null;
        if (title == null) {
            printError(ErrorMessage.noTitle);
        } else {
            allLiteratureByTitle
                    = literature.getLiteratureByTitle(title);
        }
        return allLiteratureByTitle;
    }

    /**
     * Find the Literature or literatures that contains the publisher typed by
     * user
     */
    private Iterator<Literature> getProductIteratorByPublisher() {
        System.out.println("\ntype publisher of literature: \n");
        String publisher = validInput.getStringInput();
        Iterator<Literature> allLiteratureByPublisher = null;
        if (publisher == null) {
            printError(ErrorMessage.noPublisher);
        } else {
            allLiteratureByPublisher
                    = literature.getLiteraturesByPublisher(publisher);

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
        ArrayList<Literature> removeMagazinesList;
        removeMagazinesList = new ArrayList<>();
        Iterator<Literature> literatureToRemoveIterator
                = literature.getLiteratureToRemoveByTitle(title);
        if (literatureToRemoveIterator.hasNext()) {
            literatureToRemoveIterator.forEachRemaining(removeMagazinesList::add);
            listAllProductsByIterator(removeMagazinesList.iterator());
            Literature literatureToRemove = decideProductToRemove(removeMagazinesList);
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
                    literature.removeLiterature(literatureToRemove);
                }
            } else {
                System.out.println("No product have been removed");
            }
        } else {
            printError(ErrorMessage.noMagazine);

        }
    }

    private Literature decideProductToRemove(ArrayList<Literature> removeMagazinesList) {
        number = removeMagazinesList.size();
        Literature literatureToRemove = null;
        if (removeMagazinesList.size() > 1) {
            System.out.println("Please choose number between (1-" + number
                    + " to remove): \n");
            number = validInput.getIntInput() - 1;
            literatureToRemove = removeMagazinesList.get(number);

        } else {
            System.out.println("Do you want to delete/decrease stock of this literature? "
                    + "\nIf yes, type Yes, else type anything and enter\n");
            String yes = validInput.getStringInput();
            if (yes.trim().toUpperCase().equals("YES")) {
                literatureToRemove = removeMagazinesList.get(0);
            }
        }
        return literatureToRemove;
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

    private void auto() {
        Magazine mag = new Magazine("hei", "nei", "sport", 2, 4, 3);
        Magazine mag1 = new Magazine("t", "nei", "sport", 2, 7, 1);
        Magazine mag2 = new Magazine("helty", "nei", "sport", 2, 4, 1);
        literature.addLiterature(mag2);
        literature.addLiterature(mag);
        literature.addLiterature(mag1);

    }

    private int showMenu(String[] menu) {
        System.out.println("\n**** Application v2.1 ****\n");
        int menuNumber = 1;
        // Display the menu
        for (String menuItem : menu) {

            System.out.println(menuNumber + ". " + menuItem);
            menuNumber++;
        }
        int maxMenuItemNumber = menu.length;
        System.out.println("\nPlease choose menu item (1-"
                + maxMenuItemNumber + "\n");
        // Read input from user
        int menuSelection = validInput.getIntInput();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
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
    private boolean code(boolean enterLeave) {
        boolean code = false;
        String word;
        if (enterLeave) {
            word = "enter";
        } else {
            word = "leave";
        }
        System.out.println("To " + word + " this program, please type the master code");
        if (validInput.getIntInput() == 9999) {
            System.out.println("\nCode was correct! "
                    + "\nYou will now " + word + " the program, enjoy");
            code = true;
        } else {
            System.out.println("Code was not correct \n"
                    + "Try again\n");
            code(enterLeave);
        }
        return code;
    }
}
