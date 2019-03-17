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
public class Newspaper extends Literature {

    StringBuilder error = new StringBuilder();

    /**
     * The date the newspaper is released
     */
    private String dateOfRelease;

    /**
     * Constructor for objects of class Magazine.
     *
     * @param title
     * @param publisher The publisher of the magazine
     * @param dateOfRelease
     * @param category The category of the magazine
     */
    public Newspaper(String title, String publisher,
            String category, String dateOfRelease, int price) {
        super(title, publisher, category, price);
        setDateOfRelease(dateOfRelease);
    }

    /**
     * Returns the number of publications per year
     *
     * @return number of publications per year
     */
    public String getDateOfRelease() {
        return this.dateOfRelease;
    }

    /**
     * Sets the value of this.category from parameter category. also check if
     * the value from parameter is valid
     *
     * @param category parameter contains an string with the category
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

    /**
     * Returns a Boolean saying true or false if the magazine is valid or
     * invalid
     *
     * @return a Boolean saying true or false if the magazine is valid or
     * invalid
     */
    public boolean isNewspaperValid() {
        return valid;
    }
}
