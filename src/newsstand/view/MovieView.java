package newsstand.view;

import newsstand.publication.Publication;
import newsstand.publication.Movie;

/**
 * Sub-class of View. Class that creates Movie and return details of Movies.
 *
 * @author UltraReidar
 */
public class MovieView extends View {

    /**
     * Returns all details of a give Movie.
     *
     * @param movie is the Movie that we are going to get details from.
     * @return a StringBuilder with all details of a Movie.
     */
    @Override
    public StringBuilder getDetailsOfPublication(Publication movie) {
        Movie movie1 = (Movie) movie;
        StringBuilder view = new StringBuilder();
        view.append(super.getDetailsPart1(movie));
        view.append("  |  Date of release: ");
        view.append(movie1.getDateOfRelease());
        view.append(super.getDetailsPart2(movie));
        view.append("  |  Type: Movie");
        return view;
    }

    /**
     * Method that creates a object of type Movie. Gets input from user and
     * Creates a movie and returns it.
     *
     * @return the movie that has been created.
     */
    @Override
    public Movie createPublication() {
        Movie movieToReturn = null;
        String title = super.getNewTitle();
        System.out.println("Add the name of the director/directors: \n");
        String director = validInput.getStringInput();
        String publisher = super.getNewPublisher();
        String category = super.getNewCategory();
        System.out.println("\nSet date of release: \n");
        String dateOfRelease = validInput.getDateInput();
        int price = super.getNewPrice();
        int amount = super.getNewQuantity();
        Movie movie = new Movie(title, director, publisher,
                category, dateOfRelease, price, amount);
        if (movie.isPublicationValid()) {
            movieToReturn = movie;
        }
        return movieToReturn;
    }

}
