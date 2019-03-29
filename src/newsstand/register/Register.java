package newsstand.register;

import newsstand.publication.Publication;
import java.util.ArrayList;
import java.util.Iterator;
import newsstand.duplicate.Duplicate;
import newsstand.publication.Book;
import newsstand.publication.Magazine;
import newsstand.publication.Movie;
import newsstand.publication.Newspaper;

/**
 * Super class Register for storing Publication
 * <ul>
 * <li> Add Publication </li>
 * <li> Get Iterator of Publication </li>
 * <li> Get Publication by index </li>
 * <li> Get Iterator of one type of Publication </li>
 * <li> Removes Publication </li>
 * <li> Get duplicate Publication </li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public abstract class Register {

    /**
     * Hold a collection of Publication
     */
    public ArrayList<Publication> publication;

    Duplicate duplicate;

    /**
     * Constructor. Instantiate Publication ArrayList. Instantiate Duplicate.
     */
    public Register() {
        this.publication = new ArrayList<>();
        this.duplicate = new Duplicate();
    }

    /**
     * Add a new Publication into a ArrayList of Publication. Also checks if the
     * Publication already exist, and if it does, it's increase the quantity.
     * Checks also if the Publication is valid.
     *
     * @param publication is a Publication that is going to be added
     * @return a Boolean true or false if Publication is added or not
     */
    public boolean addPublication(Publication publication) {

        boolean publicationAdded = false;
        try {
            getDuplicatePublication(publication).increaseStock();
        } catch (NullPointerException e) {
            try {
                if (publication.isPublicationValid()) {
                    publicationAdded = this.publication.add(publication);
                    //publicationAdded = true;
                }
            } catch (NullPointerException error) {
                publicationAdded = false;
            }
        }
        return publicationAdded;
    }

    /**
     * Returns an iterator of an ArrayList of all Publication
     *
     * @return iterator of ArrayList of Publication
     */
    public Iterator<Publication> getIterator() {
        return publication.iterator();
    }

    /**
     * Method to get an object of Publication by index
     *
     * @param index is the index the object we are going to get is in
     * @return the object that has been found
     */
    public Publication getPublicationByIndex(int index) {
        Publication publicationByIndex = null;
        if (indexValid(index)) {
            publicationByIndex = this.publication.get(index);
        }
        return publicationByIndex;
    }

    /**
     * Returns an iterator of ArrayList of specific publication
     *
     * @param publication is an object of Publication
     * @return iterator of ArrayList of specify Publication
     */
    public Iterator<Publication> getTypePublicationIterator(Class<?> publication) {
        ArrayList<Publication> publicationContains = new ArrayList<>();
        for (Publication type : this.publication) {
            if (type.getClass() == publication) {
                publicationContains.add(type);
            }
        }
        return publicationContains.iterator();
    }

    /**
     * Removes publication.
     *
     * @param publicationToRemove the publication object user want to remove.
     */
    public void removePublication(Publication publicationToRemove) {
        if (getDuplicatePublication(publicationToRemove) == null) {
            publication.remove(publicationToRemove);
        } else {
            if (getDuplicatePublication(publicationToRemove).getQuantity() <= 1) {
                publication.remove(publicationToRemove);
            } else {
                getDuplicatePublication(publicationToRemove).decreaseStock();
            }
        }
    }

    /**
     * Method that take the Publication parameter and check what it's an
     * instanceof and loops through all Publication to check if there is a
     * duplicate. returns the duplicate Publication that is already in register
     *
     * @param publication is the Publication that is being check if it has a
     * duplicate.
     * @return the duplicate Publication
     */
    protected Publication getDuplicatePublication(Publication publication) {
        Publication duplicateFound = null;
        if (publication instanceof Book) {
            Iterator<Publication> checkEmpty
                    = getTypePublicationIterator(Book.class);
            duplicateFound = duplicate.
                    checkDuplicateBook((Book) publication,
                            checkEmpty);
        } else if (publication instanceof Magazine) {
            Iterator<Publication> checkEmpty
                    = getTypePublicationIterator(Magazine.class);
            duplicateFound = duplicate.
                    checkDuplicateMagazine((Magazine) publication,
                            checkEmpty);
        } else if (publication instanceof Newspaper) {
            Iterator<Publication> checkEmpty
                    = getTypePublicationIterator(Newspaper.class);
            duplicateFound = duplicate.
                    checkDuplicateNewspaper((Newspaper) publication,
                            checkEmpty);
        } else if (publication instanceof Movie) {
            Iterator<Publication> checkEmpty
                    = getTypePublicationIterator(Movie.class);
            duplicateFound = duplicate.
                    checkDuplicateMovie((Movie) publication,
                            checkEmpty);
        }
        return duplicateFound;
    }

    /**
     * Checks if an index is valid and in use. Returns true if its valid.
     *
     * @param index set number of the index that is going to be checked if
     * valid.
     * @return valid witch it either true or false.
     */
    private boolean indexValid(int index) {
        boolean valid;
        if (index < 0) {
            valid = false;
        } else {
            if (index < 0) {

                valid = false;
            } else if (index >= publication.size()) {
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }
}
