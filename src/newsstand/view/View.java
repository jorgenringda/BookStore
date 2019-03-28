package newsstand.view;

import newsstand.GetInputs;
import newsstand.literature.Literature;

/**
 * Super class of View
 *
 * @author Ishmael
 */
public abstract class View {

    /**
     * Create a variable of type GetInputs.
     */
    protected GetInputs validInput;

    /**
     * Create an instance of GetInputs.
     */
    public View() {
        this.validInput = new GetInputs();
    }

    /**
     * Method to return details of give Literature as a StringBuilder This is
     * part 1 of two methods that return details
     *
     * @param literature , object of type Literature
     * @return StringBuilder with details of literature
     */
    protected StringBuilder getDetailsPart1(Literature literature) {
        StringBuilder view = new StringBuilder();

        view.append("Title: ");
        view.append(literature.getTitle());
        view.append("  |  Publisher: ");
        view.append(literature.getPublisher());
        view.append("  |  Category: ");
        view.append(literature.getCategory());
        return view;
    }

    /**
     * Method to return details of give Literature as a StringBuilder This is
     * part 2 of two methods that return details
     *
     * @param literature , object of type Literature
     * @return StringBuilder with details of literature
     */
    protected StringBuilder getDetailsPart2(Literature literature) {
        StringBuilder view = new StringBuilder();
        view.append("  |  Price: ");
        if (literature.getPrice() == 0) {
            view.append("Free");
        } else {
            view.append(literature.getPrice());
            view.append(" $");
        }
        view.append("  |  In Stock: ");
        view.append(literature.getQuantity());
        return view;
    }

    /**
     * Method that gets the users typed input and set it as title
     *
     * @return the title that is set
     */
    protected String getNewTitle() {
        System.out.println("\nSet title of magazine: \n");
        String title = validInput.getStringInput();
        return title;
    }

    /**
     * Method that gets the users typed input and set it as publisher
     *
     * @return the publisher that is set
     */
    protected String getNewPublisher() {
        System.out.println("\nSet publisher of magazine: \n");
        String publisher = validInput.getStringInput();
        return publisher;
    }

    /**
     * Method that gets the users typed input and set it as category
     *
     * @return the category that is set
     */
    protected String getNewCategory() {
        System.out.println("\nSet category of magazine: \n");
        String category = validInput.getStringInput();
        return category;
    }

    /**
     * Method that gets the users typed input and set it as price
     *
     * @return the price that is set
     */
    protected int getNewPrice() {
        System.out.println("\nSet price of magazine: \n");
        int price = validInput.getIntInput();
        return price;
    }

    /**
     * Method that gets the users typed input and set it as quantity
     *
     * @return the quantity that is set
     */
    protected int getNewQuantity() {
        int amount = 1;
        System.out.println("Type yes if you want to "
                + "add more than one of this literature!");
        if (validInput.getStringInput().trim().toUpperCase().equals("YES")) {
            System.out.println("Type the amount you want to add: ");
            amount = validInput.getIntInput();
        }
        return amount;
    }

    /**
     * Abstract method that creates Literature in each sub-Classes.
     *
     * @return the Literature that is created
     */
    public abstract Literature createLiterature();

    /**
     * Abstract method that returns details of Literature in each sub-Class.
     *
     * @param literature is the Literature we want to get details from
     * @return a StringBuilder with all the details from the Literature
     */
    public abstract StringBuilder getDetailsOfLiterature(Literature literature);
}
