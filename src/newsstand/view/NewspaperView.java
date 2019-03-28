/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.view;

import newsstand.literature.Literature;
import newsstand.literature.Newspaper;

/**
 * Sub-class of View. Class that creates Newspaper and return details of
 * Newspapers.
 *
 * @author Ishmael
 */
public class NewspaperView extends View {

    /**
     * Returns all details of a give Newspaper.
     *
     * @param newspaper is the Newspaper that we are going to get details from.
     * @return a StringBuilder with all details of a Newspaper.
     */
    @Override
    public StringBuilder getDetailsOfLiterature(Literature newspaper) {
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
    public Newspaper createLiterature() {
        Newspaper newspaperToReturn = null;
        String title = super.getNewTitle();
        String publisher = super.getNewPublisher();
        String category = super.getNewCategory();
        System.out.println("\nSet date of release of newspaper: \n");
        String dateOfRelease = validInput.getDateInput();
        int price = super.getNewPrice();
        int amount = super.getNewQuantity();
        Newspaper newspaper = new Newspaper(title, publisher,
                category, dateOfRelease, price, amount);
        if (newspaper.isLiteratureValid()) {
            newspaperToReturn = newspaper;
        }
        return newspaperToReturn;
    }

}
