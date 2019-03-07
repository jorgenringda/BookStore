/*
 * Represent a newspaper by title, publisher, release per year and
 * genre / category.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand;

/**
 * Holds information about a magazine, It contains of a title, publisher and
 * publications per year
 *
 * @author Ultrareidar
 */
public class Magazine {

    private boolean valid = true;

    StringBuilder error = new StringBuilder();
    /**
     * The magazine title
     */
    private String title;

    /**
     * The publisher name
     */
    private String publisher;

    /**
     * type of category the magazine is about.
     */
    private String category;

    /**
     * Number of publications per year of this magazine
     */
    private int releasePerYear;

    /**
     * Assign the passed variables to local categories
     *
     * @param title The title of the magazine
     * @param publisher The publisher of the magazine
     * @param category The category of the magazine
     * @param releasePerYear the number of release per year of the magazine
     */
    public Magazine(String title, String publisher,
            String category, int releasePerYear) {
        setTitle(title);
        setPublisher(publisher);
        setCategory(category);
        setReleasePerYear(releasePerYear);
    }

    /**
     * Returns the title of the magazine
     *
     * @return the magazine title name
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the magazine
     *
     * @return the magazine publisher
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Returns the category of the magazine
     *
     * @return the type of category the magazine is
     */
    public String getCategory() {
        return this.category;
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
     * Sets the value of this.title from parameter title. also check if the
     * value from parameter is valid
     *
     * @param title parameter contains an string with the title
     */
    private void setTitle(String title) {
        if (title == null) {
            title = "";
        }
        title = title.trim();
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            valid = false;
        }
    }

    /**
     * Sets the value of this.publisher from parameter publisher. also check if
     * the value from parameter is valid
     *
     * @param publisher parameter contains an string with the publisher
     */
    private void setPublisher(String publisher) {
        if (publisher == null) {
            publisher = "";
        }
        publisher = publisher.trim();
        if (!publisher.isEmpty()) {
            this.publisher = publisher;
        } else {
            valid = false;
        }
    }

    /**
     * Sets the value of this.category from parameter category. also check if
     * the value from parameter is valid
     *
     * @param category parameter contains an string with the category
     */
    private void setCategory(String category) {
        if (category == null) {
            category = "";
        }
        category = category.trim();
        if (!category.isEmpty()) {
            this.category = category;
        } else {
            valid = false;
        }
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

    /**
     * Returns a Boolean saying true or false if the magazine is valid or
     * invalid
     *
     * @return a Boolean saying true or false if the magazine is valid or
     * invalid
     */
    public boolean isMagazineValid() {
        return valid;
    }
}
