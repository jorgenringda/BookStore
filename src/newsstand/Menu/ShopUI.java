package newsstand.Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import newsstand.literature.Book;
import newsstand.literature.Literature;
import newsstand.literature.Magazine;
import newsstand.literature.Newspaper;
import newsstand.register.CartRegister;
import newsstand.register.LiteratureRegister;

/**
 * A sub-class. Class that are interacting with the user, and does this methods:
 * <ul>
 * <li> List all literature in shop </li>
 * <li> Search after literature in shop and list it </li>
 * <li> List all literature user has in his basket </li>
 * <li> Removes products from users basket </li>
 * <li> Lets the user buy the products </li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public class ShopUI extends Menu {

    /**
     * A Boolean to not let the user get the same message twice.
     */
    boolean firstTime;
    /**
     * A register containing all the literature user have added to his basket.
     */
    CartRegister shoppingCart;
    /**
     * The menus that will be displayed.
     */
    private final String[] shopMenu;

    /**
     * Constructor. Creates a menu for the shop, and a register to store
     * literature added to basket.
     */
    public ShopUI() {
        super();
        firstTime = true;
        shoppingCart = new CartRegister();
        shopMenu = new String[]{
            "Show all products in store",
            "Search after product by title",
            "Show shopping cart",
            "Remove product from cart",
            "Checkout",
            "Return"};
    }

    /**
     * Showing the menu and retrieving input from the user of what case in the
     * switch-case that is going to be run.
     *
     * @param literature is the register with Literature the application is
     * using
     * @return the updated register
     */
    public LiteratureRegister enterShop(LiteratureRegister literature) {
        this.literature = literature;
        code();
        showFeature();
        boolean back = false;
        while (!back) {
            try {
                int shop = showMenu(this.shopMenu);
                firstTime = true;
                switch (shop) {
                    case 1:
                        this.listShop();
                        break;

                    case 2:
                        this.searchAndList();
                        break;

                    case 3:
                        this.listCart();
                        break;
                    case 4:
                        this.removeFromShoppingCart();
                        break;
                    case 5:
                        this.checkout();
                        break;
                    case 6:

                        back = true;
                        break;

                    default:
                }
                if (!back) {
                    typeEnterToContinue();
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number "
                        + "between 1 and " + this.shopMenu.length + "..\n");
            }
        }
        code();
        return this.literature;
    }

    /**
     * Method to list everything in the shop.
     */
    private void listShop() {
        if (listAllProductsByIterator(this.literature
                .getIterator())) {
            add();
        } else {
            System.out.println("No items to buy, "
                    + "where sold out");
        }
    }

    /**
     * Method to search after Literature and list it for the user.
     */
    private void searchAndList() {
        System.out.println("\ntype title of literature: \n");
        String title = validInput.getStringInput();
        if (title == null) {
            printError(ErrorMessage.noTitle);
        }
        if (listAllProductsByIterator(this.literature
                .getLiteratureByTitle(title))) {
            addWithTitle(title);
        } else {
            System.out.println("\nDidn't find the product "
                    + "you where looking for\n");
        }
    }

    /**
     * Method to add literature to basket.
     */
    private void add() {
        boolean wantToAddMore = true;
        boolean addMore = addToCart(this.literature
                .getIterator());
        while (wantToAddMore) {
            wantToAddMore = addMore(this.literature
                    .getIterator(), addMore);
        }
    }

    /**
     * Method to add literature user have search for to basket.
     *
     * @param title is the title user is searching for
     */
    private void addWithTitle(String title) {
        boolean wantToAddMore = true;
        boolean addMore = addToCart(this.literature
                .getLiteratureByTitle(title));
        while (wantToAddMore) {
            wantToAddMore = addMore(this.literature
                    .getLiteratureByTitle(title), addMore);
        }
    }

    /**
     * Method to list all products in users basket.
     */
    private void listCart() {
        if (!listAllProductsByIterator(
                shoppingCart.getIterator())) {
            System.out.println("\nYour shopping cart "
                    + "is empty\n");
        }
    }

    /**
     * Method to get the total cost of shopping cart and get payment from user.
     */
    private void checkout() {
        int total = getTotal();
        if (total != 0) {
            getPayment(total);
        } else {
            System.out.println("\nYou dont have products in "
                    + "cart, therefore nothing to checkout. "
                    + "\n\nPlease add products to cart\n");
        }
    }

    /**
     * Method that gets payment from user. Checks if user have payed enough
     * before giving user the product.
     *
     * @param total is the total cost of all products in users basket
     * @return a boolean if user still want to buy the items or not
     */
    private boolean getPayment(int total) {
        boolean cancel = false;
        System.out.println("Do you want to cancel payment?"
                + "\nType Cancel if you want to cancel"
                + "\nType anything and then enter to proceed");
        if (validInput.getStringInput().trim().toUpperCase().equals("CANCEL")) {
            cancel = true;
            System.out.println("You have now cancel you payment, "
                    + "you will be sent back to the menu");
        } else {
            int payedMoney = 0;
            while (payedMoney < total) {
                System.out.println("Insert money as a number");
                payedMoney += validInput.getIntInput();
                if (payedMoney < total) {
                    System.out.println("You need to insert more money");
                } else if (payedMoney > total) {
                    int toReturn = payedMoney - total;
                    System.out.println("You have now payed more than you have "
                            + "to, you will be return " + toReturn + "$");
                } else {
                    System.out.println("You have payed the exact "
                            + "amount of money, thank you");
                }
            }
            System.out.println("\nYou will now resive your products, enjoy\n");
            shoppingCart.clearCart();
        }
        return cancel;
    }

    /**
     * Method that calculate the total cost of users basket.
     *
     * @return the total cost
     */
    private int getTotal() {
        int totalPrice = 0;
        Iterator<Literature> total = shoppingCart.getIterator();
        while (total.hasNext()) {
            totalPrice += shoppingCart.getTotalForEach(total.next());
        }
        System.out.println("Your total is: " + totalPrice + "$");
        return totalPrice;
    }

    /**
     * Method that removes literature from users basket and adds it in the shop
     * again.
     */
    private void removeFromShoppingCart() {
        ArrayList<Literature> removeList = new ArrayList<>();
        Iterator<Literature> cartIterator = shoppingCart.getIterator();
        cartIterator.forEachRemaining(removeList::add);
        listAllProductsByIterator(removeList.iterator());
        if (!removeList.isEmpty()) {
            System.out.println("Are you sure you want to remove one "
                    + "of these products?"
                    + "\nType yes if you want to remove a "
                    + "item from your basket");
            if (validInput.getStringInput().trim()
                    .toUpperCase().equals("YES")) {
                System.out.println("Type the number of product "
                        + "you want to remove:");
                int removeNumber = validInput.getIntInput() - 1;
                Literature literatureToRemove
                        = shoppingCart.getLiteratureByIndex(removeNumber);
                Literature addLiteratureToShop = copyObject(literatureToRemove);
                this.literature.addLiterature(addLiteratureToShop);
                System.out.println("Literature : "
                        + literatureToRemove.getTitle()
                        + " is removed from cart :(\n");
                shoppingCart.removeLiterature(literatureToRemove);
            }
        } else {
            System.out.println("\nYour shopping cart is empty"
                    + ", no Products to remove\n");
        }
    }

    /**
     * Method that show a random literature to the user when entering the store.
     */
    private void showFeature() {
        ArrayList<Literature> random = new ArrayList<>();
        Iterator<Literature> randomLiterature = this.literature.getIterator();
        randomLiterature.forEachRemaining(random::add);
        if (!random.isEmpty()) {
            System.out.println("You might like this: \n");
            if (!random.isEmpty()) {
                Random rand = new Random();
                System.out.println(getDetails(this.literature
                        .getLiteratureByIndex(rand.nextInt(random.size()))));
            }
        } else {
            System.out.println("\nSorry were sold out....\n");
        }
    }

    /**
     * Method that ask the user what Literature he wants to add to his basket
     * and does that.
     *
     * @param avalibelToAdd is an iterator of all Literature that is available
     * to add to basket
     * @return true or false if user decided to add or not
     */
    private boolean addToCart(Iterator<Literature> avalibelToAdd) {
        boolean addMore = false;
        if (firstTime) {
            firstTime = false;
            System.out.println("Do you want to add one of "
                    + "the items to your cart?"
                    + "\n\nType yes if you want to add to cart");
            if (validInput.getStringInput().trim()
                    .toUpperCase().equals("YES")) {
                addMore = true;
            }
        } else {
            addMore = true;
        }
        if (addMore) {
            System.out.println("Type the number of the literature "
                    + "you want to add");
            ArrayList<Literature> findLiteratureToAdd = new ArrayList<>();
            avalibelToAdd.forEachRemaining(findLiteratureToAdd::add);
            int addNumber = validInput.
                    getIntInputMinMax(1, findLiteratureToAdd.size()) - 1;
            Literature literatureToAdd
                    = this.literature.getLiteratureByIndex(addNumber);
            Literature addLiteratureToCart = copyObject(literatureToAdd);
            shoppingCart.addLiterature(addLiteratureToCart);
            System.out.println("Literature : "
                    + literatureToAdd.getTitle()
                    + " is added to cart :)\n");
            literature.removeLiterature(literatureToAdd);
        }
        return addMore;
    }

    /**
     * Method that ask the user to add more than the item they already added to
     * basket. User gets the option to add more Literature if he wants to.
     *
     * @param avalibelToAdd is an iterator of Literature containing all the
     * literature that user can add to basket
     * @param addMore a Boolean saying that the user don't want to add in the
     * first place or not.
     * @return a Boolean true or false if the user wants to add more or not
     */
    private Boolean addMore(Iterator<Literature> avalibelToAdd,
            boolean addMore) {
        boolean wantToAddMore = false;
        if (addMore) {
            System.out.println("Do you want to add more of "
                    + "the listed literature to cart?"
                    + "\n\nType yes if you want to add more "
                    + "literature to cart");
            if (validInput.getStringInput().trim()
                    .toUpperCase().equals("YES")) {
                if (avalibelToAdd.hasNext()) {
                    listAllProductsByIterator(this.literature.getIterator());
                    addToCart(avalibelToAdd);
                    wantToAddMore = true;
                } else {
                    System.out.println("Where sold out, sorry :(");
                }
            }
        }

        return wantToAddMore;
    }

    /**
     * Method that copy the object it gets from the parameter, this is to add it
     * to two register with different stock. Stock is set to 1, the system sort
     * out how many in stock.
     *
     * @param shopObject is the Literature we want to copy
     * @return the copied Literature
     */
    private Literature copyObject(Literature shopObject) {
        Literature object = null;
        if (shopObject instanceof Book) {
            Book shopBookObject = (Book) shopObject;
            object = new Book(shopBookObject.getTitle(),
                    shopBookObject.getPublisher(),
                    shopBookObject.getauthor(),
                    shopBookObject.getCategory(),
                    shopBookObject.getEdition(),
                    shopBookObject.getPrice(),
                    1);
        }
        if (shopObject instanceof Magazine) {
            Magazine shopMagazineObject = (Magazine) shopObject;
            object = new Magazine(shopMagazineObject.getTitle(),
                    shopMagazineObject.getPublisher(),
                    shopMagazineObject.getCategory(),
                    shopMagazineObject.getReleasePerYear(),
                    shopMagazineObject.getPrice(),
                    1);
        }
        if (shopObject instanceof Newspaper) {
            Newspaper shopNewspaperObject = (Newspaper) shopObject;
            object = new Newspaper(shopNewspaperObject.getTitle(),
                    shopNewspaperObject.getPublisher(),
                    shopNewspaperObject.getCategory(),
                    shopNewspaperObject.getDateOfRelease(),
                    shopNewspaperObject.getPrice(),
                    1);
        }

        return object;
    }

}
