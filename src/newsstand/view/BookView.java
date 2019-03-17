/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.view;

import newsstand.literature.Book;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ishmael
 */
public class BookView {

    public StringBuilder getDetailsOfBook(Book book) {

        StringBuilder view = new StringBuilder();

        view.append("Title: ");
        view.append(book.getTitle());
        view.append("  |  Author: ");
        view.append(book.getauthor());
        view.append("  |  Publisher: ");
        view.append(book.getPublisher());
        view.append("  |  Category: ");
        view.append(book.getCategory());
        view.append("  |  Edition: ");
        view.append(book.getEdition());
        view.append("  |  Price: ");
        view.append(book.getPrice());
        view.append(" $");
        view.append("  |  In Stock: ");
        view.append(book.getQuantity());
        view.append("  |  Type: Book");
        return view;
    }

    public Book createBook() {
        Book bookToReturn = null;
        System.out.println("\nSet title of book: \n");
        String title = getStringInput();
        System.out.println("\nSet publisher of book: \n");
        String publisher = getStringInput();
        System.out.println("\nSet author of book: \n");
        String author = getStringInput();
        System.out.println("\nSet category of book: \n");
        String category = getStringInput();
        System.out.println("\nSet edition of book: \n");
        int edition = getIntInput();
        System.out.println("\nSet price of book: \n");
        int price = getIntInput();
        Book book = new Book(title, publisher, author, category, edition, price);
        if (book.isBookValid()) {
            bookToReturn = book;
        }
        return bookToReturn;
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
