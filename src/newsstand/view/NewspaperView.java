/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.view;

import newsstand.literature.Newspaper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ishmael
 */
public class NewspaperView {

    public StringBuilder getDetailsOfNewspaper(Newspaper newspaper) {

        StringBuilder view = new StringBuilder();

        view.append("Title: ");
        view.append(newspaper.getTitle());
        view.append("  |  Publisher: ");
        view.append(newspaper.getPublisher());
        view.append("  |  Category: ");
        view.append(newspaper.getCategory());
        view.append("  |  Date of release: ");
        view.append(newspaper.getDateOfRelease());
        view.append("  |  Price: ");
        view.append(newspaper.getPrice());
        view.append(" $");
        view.append("  |  In Stock: ");
        view.append(newspaper.getQuantity());
        view.append("  |  Type: Newspaper");

        return view;
    }

    public Newspaper createNewspaper() {
        Newspaper newspaperToReturn = null;
        System.out.println("\nSet title of newspaper: \n");
        String title = getStringInput();
        System.out.println("\nSet publisher of newspaper: \n");
        String publisher = getStringInput();
        System.out.println("\nSet category of newspaper: \n");
        String category = getStringInput();
        System.out.println("\nSet date of release of newspaper: \n");
        String dateOfRelease = getDateInput();
        System.out.println("\nSet price of newspaper: \n");
        int price = getIntInput();

        Newspaper newspaper = new Newspaper(title, publisher, category, dateOfRelease, price);
        if (newspaper.isNewspaperValid()) {
            newspaperToReturn = newspaper;
        }
        return newspaperToReturn;
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
     * Method that returns input from user as a string
     *
     * @return input returns input typed by user as a string
     */
    private String getDateInput() {
        System.out.println("Enter a date in format : dd-mm-yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        try {
            dateFormat.parse(input);
        } catch (ParseException e) {
            System.out.println("\nPlease enter a valid date\n");
            input = getDateInput();
        }
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
