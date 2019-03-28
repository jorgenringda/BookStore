package newsstand.literature;

/**
 * Sub-class of Literature. Holds information about a Newspaper, It contains of
 * a title, publisher, category, dateOfRelease, price and quantity.
 *
 * @author Ultrareidar
 */
public class Newspaper extends Literature {

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
     * Returns the number of publications per year of the Magazine.
     *
     * @return number of publications per year
     */
    public String getDateOfRelease() {
        return this.dateOfRelease;
    }

    /**
     * Sets the value of this.dateOfRelease from parameter dateOfRelease. Also
     * check if the value from parameter is valid.
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
            valid = false;
        }
    }
}
