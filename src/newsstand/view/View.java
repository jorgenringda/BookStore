package newsstand.view;

import newsstand.GetInputs;
import newsstand.publication.Publication;

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
     * Method to return details of give Publication as a StringBuilder This is
     * part 1 of two methods that return details
     *
     * @param publication , object of type Publication
     * @return StringBuilder with details of publication
     */
    protected StringBuilder getDetailsPart1(Publication publication) {
        StringBuilder view = new StringBuilder();

        view.append("Title: ");
        view.append(publication.getTitle());
        view.append("  |  Publisher: ");
        view.append(publication.getPublisher());
        view.append("  |  Category: ");
        view.append(publication.getCategory());
        return view;
    }

    /**
     * Method to return details of give Publication as a StringBuilder This is
     * part 2 of two methods that return details
     *
     * @param publication , object of type Publication
     * @return StringBuilder with details of publication
     */
    protected StringBuilder getDetailsPart2(Publication publication) {
        StringBuilder view = new StringBuilder();
        view.append("  |  Price: ");
        if (publication.getPrice() == 0) {
            view.append("Free");
        } else {
            view.append(publication.getPrice());
            view.append(" $");
        }
        view.append("  |  In Stock: ");
        view.append(publication.getQuantity());
        return view;
    }

    /**
     * Method that gets the users typed input and set it as title
     *
     * @return the title that is set
     */
    protected String getNewTitle() {
        System.out.println("\nSet title: \n");
        String title = validInput.getStringInput();
        return title;
    }

    /**
     * Method that gets the users typed input and set it as publisher
     *
     * @return the publisher that is set
     */
    protected String getNewPublisher() {
        System.out.println("\nSet publisher: \n");
        String publisher = validInput.getStringInput();
        return publisher;
    }

    /**
     * Method that gets the users typed input and set it as category
     *
     * @return the category that is set
     */
    protected String getNewCategory() {
        System.out.println("\nSet category: \n");
        String category = validInput.getStringInput();
        return category;
    }

    /**
     * Method that gets the users typed input and set it as price
     *
     * @return the price that is set
     */
    protected int getNewPrice() {
        System.out.println("\nSet price: \n");
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
                + "add more than one of this publication!");
        if (validInput.getStringInput().trim().toUpperCase().equals("YES")) {
            System.out.println("Type the amount you want to add: ");
            amount = validInput.getIntInput();
        }
        return amount;
    }

    /**
     * Abstract method that creates Publication in each sub-Classes.
     *
     * @return the Publication that is created
     */
    public abstract Publication createPublication();

    /**
     * Abstract method that returns details of Publication in each sub-Class.
     *
     * @param publication is the Publication we want to get details from
     * @return a StringBuilder with all the details from the Publication
     */
    public abstract StringBuilder getDetailsOfPublication(Publication publication);
}
