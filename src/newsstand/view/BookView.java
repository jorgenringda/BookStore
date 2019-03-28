package newsstand.view;

import newsstand.literature.Book;
import newsstand.literature.Literature;

/**
 * Sub-class of View. Class that creates Book and return details of Book.
 *
 * @author Ishmael
 */
public class BookView extends View {

    /**
     * Returns all details of a give Book.
     *
     * @param book is the Book that we are going to get details from.
     * @return a StringBuilder with all details of a Book.
     */
    @Override
    public StringBuilder getDetailsOfLiterature(Literature book) {
        Book book1 = (Book) book;
        StringBuilder view = new StringBuilder();
        view.append(super.getDetailsPart1(book));
        view.append("  |  Author: ");
        view.append(book1.getauthor());
        view.append("  |  Edition: ");
        view.append(book1.getEdition());
        view.append(super.getDetailsPart2(book));
        view.append("  |  Type: Book");
        return view;
    }

    /**
     * Method that creates a object of type Book. Gets input from user and
     * Creates a Book and returns it.
     *
     * @return the Book that has been created
     */
    @Override
    public Book createLiterature() {
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
