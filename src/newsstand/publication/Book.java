package newsstand.publication;

/**
 * Sub-class of Publication. Holds information about a Book, It contains of a
 * title, publisher, author, category, edition, price and quantity.
 *
 * @author Ultrareidar
 */
public class Book extends Publication {

    private String author;
    private int edition;

    /**
     * Constructor for objects of class Magazine.
     *
     * @param title The title of the Book
     * @param publisher is the publisher of the Book
     * @param author is the author of the Book
     * @param category is the category of the Book
     * @param edition is the edition of the Book
     * @param price is the price of the Book
     * @param quantity is the quantity of the Book that is being added to stock
     */
    public Book(String title, String publisher,
            String author, String category,
            int edition, int price, int quantity) {
        super(title, publisher, category, price, quantity);
        setAuthor(author);
        setEdition(edition);
    }

    /**
     * Sets the value of this.author from parameter author. Also check if the
     * value from parameter is valid
     *
     * @param author parameter contains an string with the author
     */
    private void setAuthor(String author) {
        if (author == null) {
            author = "";
        }
        author = author.trim();
        if (!author.isEmpty()) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Author is not valid");
        }
    }

    /**
     * Sets the value of this.edition from parameter edition. Throws exception
     * if edition is not valid.
     *
     * @param edition parameter contains an int with the edition
     */
    private void setEdition(int edition) {
        if (edition <= 0) {
            throw new IllegalArgumentException("Edition is negative or 0");
        } else {
            this.edition = edition;
        }
    }

    /**
     * Method to return author of Book.
     *
     * @return the author of the Book
     */
    public String getauthor() {
        return this.author;
    }

    /**
     * Method that returns edition of the Book.
     *
     * @return the author of the Book
     */
    public int getEdition() {
        return this.edition;
    }
}
