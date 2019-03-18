/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.view;

import newsstand.literature.Newspaper;

/**
 *
 * @author Ishmael
 */
public class NewspaperView extends View {

    public StringBuilder getDetailsOfNewspaper(Newspaper newspaper) {

        StringBuilder view = new StringBuilder();

        view.append(super.getDetailsPart1(newspaper));
        view.append("  |  Date of release: ");
        view.append(newspaper.getDateOfRelease());
        view.append(super.getDetailsPart2(newspaper));
        view.append("  |  Type: Newspaper");

        return view;
    }

    public Newspaper createNewspaper() {
        Newspaper newspaperToReturn = null;
        String title = super.getNewTitle();
        String publisher = super.getNewPublisher();
        String category = super.getNewCategory();
        System.out.println("\nSet date of release of newspaper: \n");
        String dateOfRelease = validInput.getDateInput();
        int price = super.getNewPrice();
        int amount = super.getNewQuantity();
        Newspaper newspaper = new Newspaper(title, publisher, category, dateOfRelease, price, amount);
        if (newspaper.isLiteratureValid()) {
            newspaperToReturn = newspaper;
        }
        return newspaperToReturn;
    }

}
