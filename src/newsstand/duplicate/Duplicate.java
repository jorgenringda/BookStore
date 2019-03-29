package newsstand.duplicate;

import java.util.Iterator;
import newsstand.publication.Book;
import newsstand.publication.Publication;
import newsstand.publication.Magazine;
import newsstand.publication.Movie;
import newsstand.publication.Newspaper;

/**
 * Class that check if there is the same type of Publication in the register
 * that is being added.
 *
 * @author Ishmael
 */
public class Duplicate {

    /**
     * Constructor.
     */
    public Duplicate() {
    }

    /**
     * Method that checks for duplicates of Publication type Book. Returns the
     * duplicate Book if it has one else return null.
     *
     * @param duplicateBook is the Book that is being check if it has a
     * duplicate
     * @param typeIterator is an Iterator of all Book in the register
     * @return the duplicate Book if it has one else return null.
     */
    public Book checkDuplicateBook(Book duplicateBook,
            Iterator<Publication> typeIterator) {
        boolean duplicate = false;
        Book book = null;
        if (typeIterator.hasNext()) {
            while (typeIterator.hasNext() && duplicate) {
                book = (Book) typeIterator.next();
                if (checkCommonDuplicate(duplicateBook, book)) {
                    if (book.getEdition() == duplicateBook.getEdition()) {
                        if (book.getauthor().
                                equals(duplicateBook.getauthor())) {
                            duplicate = true;
                        }
                    }
                }
            }
        }
        if (!duplicate) {
            book = null;
        }
        return book;
    }

    /**
     * Method that checks for duplicates of Publication type Magazine. Returns
     * the duplicate Magazine if it has one else return null.
     *
     * @param duplicateMagazine is the Magazine that is being check if it has a
     * duplicate
     * @param typeIterator is an Iterator of all Magazine in the register
     * @return the duplicate Magazine if it has one else return null.
     */
    public Magazine checkDuplicateMagazine(Magazine duplicateMagazine,
            Iterator<Publication> typeIterator) {
        boolean duplicate = false;
        Magazine magazine = null;
        if (typeIterator.hasNext()) {
            while (typeIterator.hasNext() && !duplicate) {
                magazine = (Magazine) typeIterator.next();
                if (checkCommonDuplicate(duplicateMagazine, magazine)) {
                    if (magazine.getReleasePerYear()
                            == duplicateMagazine.getReleasePerYear()) {
                        duplicate = true;
                    }
                }
            }
        }
        if (!duplicate) {
            magazine = null;
        }
        return magazine;
    }

    /**
     * Method that checks for duplicates of Publication type Newspaper. Returns
     * the duplicate Newspaper if it has one else return null.
     *
     * @param duplicateNewspaper is the Newspaper that is being check if it has
     * a duplicate
     * @param typeIterator is an Iterator of all Newspaper in the register
     * @return the duplicate Newspaper if it has one else return null.
     */
    public Newspaper checkDuplicateNewspaper(Newspaper duplicateNewspaper,
            Iterator<Publication> typeIterator) {
        boolean duplicate = false;
        Newspaper newspaper = null;
        if (typeIterator.hasNext()) {
            while (typeIterator.hasNext() && duplicate) {
                newspaper = (Newspaper) typeIterator.next();
                if (checkCommonDuplicate(duplicateNewspaper, newspaper)) {
                    if (newspaper.getDateOfRelease().
                            equals(duplicateNewspaper.getDateOfRelease())) {
                        duplicate = true;
                    }
                }
            }
        }
        if (!duplicate) {
            newspaper = null;
        }
        return newspaper;
    }

    /**
     * Method that checks for duplicates of Publication type Movie. Returns the
     * duplicate Movie if it has one else return null.
     *
     * @param duplicateMovie is the Movie that is being check if it has a
     * duplicate
     * @param typeIterator is an Iterator of all Movie in the register
     * @return the duplicate Movie if it has one else return null.
     */
    public Movie checkDuplicateMovie(Movie duplicateMovie,
            Iterator<Publication> typeIterator) {
        boolean duplicate = false;
        Movie movie = null;
        if (typeIterator.hasNext()) {
            while (typeIterator.hasNext() && duplicate) {
                movie = (Movie) typeIterator.next();
                if (checkCommonDuplicate(duplicateMovie, movie)) {
                    if (movie.getDateOfRelease().
                            equals(duplicateMovie.getDateOfRelease())) {
                        if (movie.getDirector().equals(duplicateMovie.getDirector())) {
                            duplicate = true;
                        }
                    }
                }
            }
        }
        if (!duplicate) {
            movie = null;
        }
        return movie;
    }

    /**
     * Method that checks the type Publication for duplicate Publication. Checks
     * only the parameters that is common for all type of Publication.
     *
     * @param duplicatePublication is the Publication that is being check if it
     * has a duplicate
     * @param publicationInRegister is Publication in the register that we are
     * checking if its duplicate with
     * @return a Boolean true or false if it found if the two Publication is
     * duplicate on common parameters
     */
    private boolean checkCommonDuplicate(Publication duplicatePublication,
            Publication publicationInRegister) {
        boolean duplicate = false;
        if (publicationInRegister.getTitle().
                equals(duplicatePublication.getTitle())) {
            if (publicationInRegister.getPublisher().
                    equals(duplicatePublication.getPublisher())) {
                if (publicationInRegister.getCategory().
                        equals(duplicatePublication.getCategory())) {
                    duplicate = true;
                }
            }
        }
        return duplicate;
    }

}
