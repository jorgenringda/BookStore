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
public class BookView extends View {

    public StringBuilder getDetailsOfBook(Book book) {

        StringBuilder view = new StringBuilder();

        view.append(super.getDetailsPart1(book));
        view.append("  |  Author: ");
        view.append(book.getauthor());
        view.append("  |  Edition: ");
        view.append(book.getEdition());
        view.append(super.getDetailsPart2(book));
        view.append("  |  Type: Book");
        return view;
    }

    public Book createBook() {
        Book bookToReturn = null;
        String title = super.getNewTitle();
        String publisher = super.getNewPublisher();
        System.out.println("\nSet author of book: \n");
        String author = validInput.getStringInput();
        String category = super.getNewCategory();
        System.out.println("\nSet edition of book: \n");
        int edition = validInput.getIntInput();
        int price = super.getNewPrice();
        int amount = super.getNewQuantity();
        Book book = new Book(title, publisher, author, category, edition, price, amount);
        if (book.isLiteratureValid()) {
            bookToReturn = book;
        }
        return bookToReturn;
    }
}
