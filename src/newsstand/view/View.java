/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.view;

import newsstand.GetInputs;
import newsstand.literature.Literature;

/**
 *
 * @author Ishmael
 */
public class View {

    protected GetInputs validInput;

    public View() {
        this.validInput = new GetInputs();
    }

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

    protected String getNewTitle() {
        System.out.println("\nSet title of magazine: \n");
        String title = validInput.getStringInput();
        return title;
    }

    protected String getNewPublisher() {
        System.out.println("\nSet publisher of magazine: \n");
        String publisher = validInput.getStringInput();
        return publisher;
    }

    protected String getNewCategory() {
        System.out.println("\nSet category of magazine: \n");
        String category = validInput.getStringInput();
        return category;
    }

    protected int getNewPrice() {
        System.out.println("\nSet price of magazine: \n");
        int price = validInput.getIntInput();
        return price;
    }

    protected int getNewQuantity() {
        int amount = 1;
        System.out.println("Type yes if you want to add more than one of this literature!");
        if (validInput.getStringInput().trim().toUpperCase().equals("YES")) {
            System.out.println("Type the amount you want to add: ");
            amount = validInput.getIntInput();
        }
        return amount;
    }
}
