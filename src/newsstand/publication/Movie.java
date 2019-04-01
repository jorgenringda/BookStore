package newsstand.publication;

/**
 * Sub-class of Publication. Holds information about a Movie, It contains of a
 * title, publisher, category, dateOfRelease, price and quantity.
 *
 * @author Ultrareidar
 */
public class Movie extends Publication {

    /**
     * The date the movie is released
     */
    private String dateOfRelease;
    /**
     * The name of the director;
     */
    private String director;

    /**
     * Constructor for objects of class Movie.
     *
     * @param title is the title of the Movie
     * @param publisher is the publisher of the Movie
     * @param dateOfRelease is the release date of the Movie
     * @param category is the category of the Movie
     * @param price is the price of the Movie
     * @param quantity is the quantity of the Movie that is being added to stock
     */
    public Movie(String title, String director, String publisher,
            String category, String dateOfRelease, int price, int quantity) {
        super(title, publisher, category, price, quantity);
        setDirector(director);
        setDateOfRelease(dateOfRelease);
    }

    /**
     * Sets the value of the director from parameter. Throws exception if
     * director is not valid.
     *
     * @param director parameter contains an string with the director
     */
    private void setDirector(String director) {
        if (director == null) {
            director = "";
        }
        director = director.trim();
        if (!director.isEmpty()) {
            this.director = director;
        } else {
            throw new IllegalArgumentException("Director is not valid");
        }
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
     * Returns the title of the director of the movie.
     *
     * @return title of director
     */
    public String getDirector() {
        return this.director;
    }

    /**
     * Returns the number of publications per year of the Movie.
     *
     * @return number of publications per year
     */
    public String getDateOfRelease() {
        return this.dateOfRelease;
    }
}
