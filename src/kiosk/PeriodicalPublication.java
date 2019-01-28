/*
 * represent periodical publication
 * represented by title, publisher, release per year, type and genre / field
 */
package kiosk;

/**
 *
 * @author Ishmael
 */
public class PeriodicalPublication {

    private final String title;
    private final String publisher;
    private final String type;
    private final String field;
    private final int releasePerYear;

    public PeriodicalPublication(String title, String publisher, String type, String field, int releasePerYear) {
        this.title = title;
        this.publisher = publisher;
        this.type = type;
        this.field = field;
        this.releasePerYear = releasePerYear;
    }

    public String getDetails() {
        return "title: " + title + "    publisher: " + publisher + "   type: " + type + "  field: " + field + "    release per year: " + releasePerYear;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getType() {
        return this.type;
    }

    public String getField() {
        return this.field;
    }

    public int getReleasePerYear() {
        return this.releasePerYear;
    }

}
