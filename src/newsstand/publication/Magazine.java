package newsstand.publication;

/**
 * Sub-class of Publication. Holds information about a magazine, It contains of
 * a title, publisher, publications per year, category, price and quantity.
 *
 * @author Ultrareidar
 */
public class Magazine extends Publication {

    /**
     * Number of publications per year of this magazine
     */
    private int releasePerYear;

    /**
     * Constructor for objects of class Magazine.
     *
     * @param title is the title of the Magazine
     * @param publisher is the publisher of the Magazine
     * @param category is the category of the Magazine
     * @param releasePerYear is the release per year of the Magazine
     * @param price is the price of the Magazine
     * @param quantity is the quantity of Magazine that is being added to stock
     */
    public Magazine(String title, String publisher,
            String category, int releasePerYear, int price, int quantity) {
        super(title, publisher, category, price, quantity);
        setReleasePerYear(releasePerYear);
    }

    /**
     * Sets the value of this.releasePerYear from parameter releasePerYear. Also
     * check if the value from parameter is valid
     *
     * @param releasePerYear parameter contains an int with number of release
     * per year
     */
    private void setReleasePerYear(int releasePerYear) {
        if (releasePerYear <= 0) {
            valid = false;
        } else {
            this.releasePerYear = releasePerYear;
        }
    }

    /**
     * Returns the number of publications per year
     *
     * @return number of publications per year
     */
    public int getReleasePerYear() {
        return this.releasePerYear;
    }

}
