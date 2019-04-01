package newsstand.view;

import newsstand.publication.Publication;
import newsstand.publication.Newspaper;

/**
 * Sub-class of View. Class that creates Newspaper and return details of
 * Newspapers.
 *
 * @author UltraReidar
 */
public class NewspaperView extends View {

    /**
     * Returns all details of a give Newspaper.
     *
     * @param newspaper is the Newspaper that we are going to get details from.
     * @return a StringBuilder with all details of a Newspaper.
     */
    @Override
    public StringBuilder getDetailsOfPublication(Publication newspaper) {
        Newspaper newspaper1 = (Newspaper) newspaper;
        StringBuilder view = new StringBuilder();
        view.append(super.getDetailsPart1(newspaper));
        view.append("  |  Date of release: ");
        view.append(newspaper1.getDateOfRelease());
        view.append(super.getDetailsPart2(newspaper));
        view.append("  |  Type: Newspaper");
        return view;
    }

    /**
     * Method that creates a object of type Newspaper. Gets input from user and
     * Creates a newspaper and returns it.
     *
     * @return the newspaper that has been created.
     */
    @Override
    public Newspaper createPublication() {
        Newspaper newspaperToReturn = null;
        String title = super.getNewTitle();
        String publisher = super.getNewPublisher();
        String category = super.getNewCategory();
        System.out.println("\nSet date of release: \n");
        String dateOfRelease = validInput.getDateInput();
        int price = super.getNewPrice();
        int amount = super.getNewQuantity();
        try {
            Newspaper newspaper = new Newspaper(title, publisher,
                    category, dateOfRelease, price, amount);
            newspaperToReturn = newspaper;
        } catch (IllegalArgumentException iae) {
        }
        return newspaperToReturn;
    }

}
