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
public class Magazine extends Literature {

    StringBuilder error = new StringBuilder();

    /**
     * Number of publications per year of this magazine
     */
    private int releasePerYear;

    /**
     * Constructor for objects of class Magazine.
     *
     * @param title The title of the magazine
     * @param publisher
     * @param category
     * @param releasePerYear the number of release per year of the magazine
     */
    public Magazine(String title, String publisher,
            String category, int releasePerYear, int price, int amount) {
        super(title, publisher, category, price, amount);
        setReleasePerYear(releasePerYear);
    }

    /**
     * Returns the number of publications per year
     *
     * @return number of publications per year
     */
    public int getReleasePerYear() {
        return this.releasePerYear;
    }

    /**
     * Sets the value of this.releasePerYear from parameter releasePerYear. also
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

}
