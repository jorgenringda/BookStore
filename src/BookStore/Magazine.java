/*
 * Represent a newspaper by title, publisher, release per year and genre / field
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

/**
 * Holds information about a magazine, It contains of a title, publisher and
 * publications per year
 *
 * @author Ultrareidar
 */
public class Magazine {

    /**
     * The magazine title
     */
    private final String title;

    /**
     * The publisher name
     */
    private final String publisher;

    /**
     * type of field the magazine is about.
     */
    private final String field;

    /**
     * Number of publications per year of this magazine
     */
    private final int releasePerYear;

    /**
     * Assign the passed variables to local fields
     *
     * @param title The title of the magazine
     * @param publisher The publisher of the magazine
     * @param field The field of the magazine
     * @param publicationsPerYear Number of publications per year
     */
    public Magazine(String title, String publisher, String field, int releasePerYear) {
        this.title = title;
        this.publisher = publisher;
        this.field = field;
        this.releasePerYear = releasePerYear;
    }

    /**
     * returns all data of the magazine
     *
     * @return returns the magazine title, publisher, field and release per year
     */
    public String getDetails() {
        return "Title: " + title + "\nPublisher: " + publisher + "\nField: " + field + "\nRelease Per Year: " + releasePerYear;
    }

    /**
     * Returns the title of the magazine
     *
     * @return returns the magazine title name
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the magazine
     *
     * @return returns the magazine publisher
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Returns the field of the magazine
     *
     * @return returns the type of field the magazine is
     */
    public String getField() {
        return this.field;
    }

    /**
     * Returns the number of publications per year
     *
     * @return Returns number of publications per year
     */
    public int getReleasePerYear() {
        return this.releasePerYear;
    }

}
