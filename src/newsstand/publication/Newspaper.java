package newsstand.publication;

/**
 * Sub-class of Publication. Holds information about a Newspaper, It contains of
 * a title, publisher, category, dateOfRelease, price and quantity.
 *
 * @author Ultrareidar
 */
public class Newspaper extends Publication {

    /**
     * The date the newspaper is released
     */
    private String dateOfRelease;

    /**
     * Constructor for objects of class Newspaper.
     *
     * @param title is the title of the Newspaper
     * @param publisher is the publisher of the Newspaper
     * @param dateOfRelease is the release date of the Newspaper
     * @param category is the category of the Newspaper
     * @param price is the price of the Newspaper
     * @param quantity is the quantity of the Newspaper that is being added to
     * stock
     */
    public Newspaper(String title, String publisher,
            String category, String dateOfRelease, int price, int quantity) {
        super(title, publisher, category, price, quantity);
        setDateOfRelease(dateOfRelease);
    }

    /**
     * Sets the value of this.dateOfRelease from parameter dateOfRelease. Also
     * Throws exception if date of release is not valid.
     *
     * @param dateOfRelease parameter contains an string with the date of
     * release
     */
    private void setDateOfRelease(String dateOfRelease) {
        if (dateOfRelease == null) {
            dateOfRelease = "";
        }
        dateOfRelease = dateOfRelease.trim();
        if (!dateOfRelease.isEmpty()) {
            this.dateOfRelease = dateOfRelease;
        } else {
            throw new IllegalArgumentException("Date of release is not valid");
        }
    }

    /**
     * Returns the number of publications per year of the Newspaper.
     *
     * @return number of publications per year
     */
    public String getDateOfRelease() {
        return this.dateOfRelease;
    }
}
