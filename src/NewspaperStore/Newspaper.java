/*
 * Represent a newspaper by title, publisher, release per year and genre / field
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

/**
 *
 * @author Ishmael
 */
public class Newspaper {

    private final String title;
    private final String publisher;
    private final String field;
    private final int releasePerYear;

    public Newspaper(String title, String publisher, String field, int releasePerYear) {
        this.title = title;
        this.publisher = publisher;
        this.field = field;
        this.releasePerYear = releasePerYear;
    }

    public String getDetails() {
        return "title: " + title + "    publisher: " + publisher + "  field: " + field + "    release per year: " + releasePerYear;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getField() {
        return this.field;
    }

    public int getReleasePerYear() {
        return this.releasePerYear;
    }

}
