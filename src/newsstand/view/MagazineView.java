/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.view;

import newsstand.publication.Publication;
import newsstand.publication.Magazine;

/**
 * Sub-class of View. Class that creates Magazine and return details of
 * Magazine.
 *
 * @author Ishmael
 */
public class MagazineView extends View {

    /**
     * Returns all details of a give Magazine.
     *
     * @param magazine is the Magazine that we are going to get details from.
     * @return a StringBuilder with all details of a Magazine.
     */
    public StringBuilder getDetailsOfPublication(Publication magazine) {
        Magazine magazine1 = (Magazine) magazine;
        StringBuilder view = new StringBuilder();
        view.append(super.getDetailsPart1(magazine));
        view.append("  |  Release per year: ");
        view.append(magazine1.getReleasePerYear());
        view.append(super.getDetailsPart2(magazine));
        view.append("  |  Type: Magazine");
        return view;
    }

    /**
     * Method that creates a object of type Magazine. Gets input from user and
     * Creates a Magazine and returns it.
     *
     * @return the Magazine that has been created.
     */
    @Override
    public Magazine createPublication() {
        Magazine magazineToReturn = null;
        String title = super.getNewTitle();
        String publisher = super.getNewPublisher();
        String category = super.getNewCategory();
        System.out.println("\nSet release per year: \n");
        int edition = validInput.getIntInput();
        int price = super.getNewPrice();
        int amount = super.getNewQuantity();
        Magazine magazine = new Magazine(title, publisher, category,
                edition, price, amount);
        if (magazine.isPublicationValid()) {
            magazineToReturn = magazine;
        }
        return magazineToReturn;
    }
}
