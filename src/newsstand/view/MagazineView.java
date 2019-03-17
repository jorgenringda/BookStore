/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.view;

import newsstand.literature.Magazine;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ishmael
 */
public class MagazineView {

    public StringBuilder getDetailsOfMagazine(Magazine magazine) {

        StringBuilder view = new StringBuilder();

        view.append("Title: ");
        view.append(magazine.getTitle());
        view.append("  |  Publisher: ");
        view.append(magazine.getPublisher());
        view.append("  |  Category: ");
        view.append(magazine.getCategory());
        view.append("  |  Release per year: ");
        view.append(magazine.getReleasePerYear());
        view.append("  |  Price: ");
        view.append(magazine.getPrice());
        view.append(" $");
        view.append("  |  In Stock: ");
        view.append(magazine.getQuantity());
        view.append("  |  Type: Magazine");
        return view;
    }

    public Magazine createMagazine() {
        Magazine magazineToReturn = null;
        System.out.println("\nSet title of magazine: \n");
        String title = getStringInput();
        System.out.println("\nSet publisher of magazine: \n");
        String publisher = getStringInput();
        System.out.println("\nSet category of magazine: \n");
        String category = getStringInput();
        System.out.println("\nSet release per year of magazine: \n");
        int edition = getIntInput();
        System.out.println("\nSet price of magazine: \n");
        int price = getIntInput();
        Magazine magazine = new Magazine(title, publisher, category, edition, price);
        if (magazine.isMagazineValid()) {
            magazineToReturn = magazine;
        }
        return magazineToReturn;
    }

    /**
     * Method that returns input from user as a string
     *
     * @return input returns input typed by user as a string
     */
    private String getStringInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        System.out.println();

        return input;
    }

    /**
     * Method that returns input from user as a integer
     *
     * @return input returns input typed by user as a integer
     */
    private int getIntInput() {
        Scanner reader = new Scanner(System.in);
        int input;
        try {
            input = reader.nextInt();
        } catch (InputMismatchException error) {
            System.out.println("\nPlease enter a valid number\n");
            input = getIntInput();
        }
        return input;
    }
}
