/*
 * Represent a newspaper by title, publisher, release per year and
 * genre / category.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.literature;

/**
 * Holds information about a magazine, It contains of a title, publisher and
 * publications per year
 *
 * @author Ultrareidar
 */
public class Book extends Literature {

    StringBuilder error = new StringBuilder();

    private String author;

    /**
     * Number of publications per year of this magazine
     */
    private int edition;

    /**
     * Constructor for objects of class Magazine.
     *
     * @param title The title of the magazine
     * @param publisher
     * @param author
     * @param category
     * @param edition the number of release per year of the magazine
     */
    public Book(String title, String publisher,
            String author, String category, int edition, int price, int quantity) {
        super(title, publisher, category, price, quantity);
        setAuthor(author);
        setEdition(edition);

    }

    /**
     * Returns the number of publications per year
     *
     * @return number of publications per year
     */
    public String getauthor() {
        return this.author;
    }

    /**
     * Returns the number of publications per year
     *
     * @return number of publications per year
     */
    public int getEdition() {
        return this.edition;
    }

    /**
     * Sets the value of this.author from parameter author. also check if the
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
            valid = false;
        }
    }

    /**
     * Sets the value of this.edition from parameter edition. also check if the
     * value from parameter is valid
     *
     * @param edition parameter contains an int with number of release per year
     */
    private void setEdition(int edition) {
        if (edition <= 0) {
            valid = false;
        } else {
            this.edition = edition;
        }
    }
}
