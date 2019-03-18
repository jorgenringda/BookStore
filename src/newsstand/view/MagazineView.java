/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.view;

import newsstand.literature.Magazine;

/**
 *
 * @author Ishmael
 */
public class MagazineView extends View {

    public StringBuilder getDetailsOfMagazine(Magazine magazine) {

        StringBuilder view = new StringBuilder();

        view.append(super.getDetailsPart1(magazine));
        view.append("  |  Release per year: ");
        view.append(magazine.getReleasePerYear());
        view.append(super.getDetailsPart2(magazine));
        view.append("  |  Type: Magazine");
        return view;
    }

    public Magazine createMagazine() {
        Magazine magazineToReturn = null;
        String title = super.getNewTitle();
        String publisher = super.getNewPublisher();
        String category = super.getNewCategory();
        System.out.println("\nSet release per year of magazine: \n");
        int edition = validInput.getIntInput();
        int price = super.getNewPrice();
        int amount = super.getNewQuantity();
        Magazine magazine = new Magazine(title, publisher, category, edition, price, amount);
        if (magazine.isLiteratureValid()) {
            magazineToReturn = magazine;
        }
        return magazineToReturn;
    }
}
