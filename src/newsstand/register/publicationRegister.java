package newsstand.register;

import newsstand.publication.Publication;
import java.util.ArrayList;
import java.util.Iterator;
import newsstand.publication.Book;
import newsstand.publication.Magazine;
import newsstand.publication.Movie;
import newsstand.publication.Newspaper;

/**
 * Sub-class of Register publicationRegister for storing Publication
 * <ul>
 * <li> Get Publication by title as Iterator </li>
 * <li> Get Publication by publisher as Iterator </li>
 * <li> Get Publication to remove by title as Iterator </li>
 * <li> Get Publication in order as Iterator </li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public class publicationRegister extends Register {

    /**
     * Constructor. Don't instantiate anything, everything is done by super
     * class.
     */
    public publicationRegister() {
        super();
    }

    /**
     * Search for object of type publication that contains the given title,
     * returns an Iterator of all the publication that contains the title.
     *
     * @param title contains the set title as a string.
     * @return an Iterator that contains all the object of type publication that
     * contains the title.
     */
    public Iterator<Publication> getPublicationByTitle(String title) {
        ArrayList<Publication> publicationContains = new ArrayList<>();
        ArrayList<Publication> publicationList = new ArrayList<>();
        getPublicationInOrder().forEachRemaining(publicationList::add);
        if (!title.isEmpty()) {
            for (Publication paper : publicationList) {
                if (paper.getTitle().toUpperCase()
                        .contains(title.toUpperCase())) {
                    publicationContains.add(paper);
                }
            }
        }
        return publicationContains.iterator();
    }

    /**
     * Search for object of type publication that contains the given publisher,
     * returns an Iterator of all the publication that contains the publisher.
     *
     * @param publisher contains the set publisher as a string.
     * @return an Iterator that contains all the object of type publication that
     * contains the publisher.
     */
    public Iterator<Publication> getPublicationsByPublisher(String publisher) {
        ArrayList<Publication> publicationContains = new ArrayList<>();
        ArrayList<Publication> publicationList = new ArrayList<>();
        getPublicationInOrder().forEachRemaining(publicationList::add);
        if (!publisher.isEmpty()) {
            for (Publication paper : publicationList) {
                if (paper.getPublisher().toUpperCase()
                        .contains(publisher.toUpperCase())) {
                    publicationContains.add(paper);
                }
            }
        }
        return publicationContains.iterator();
    }

    /**
     * Method to take everything in the register and sort it after type.
     *
     * @return an iterator with all publication in order
     */
    public Iterator<Publication> getPublicationInOrder() {
        ArrayList<Publication> publicationInOrder = new ArrayList<>();
        getTypePublicationIterator(Magazine.class).
                forEachRemaining(publicationInOrder::add);
        getTypePublicationIterator(Newspaper.class).
                forEachRemaining(publicationInOrder::add);
        getTypePublicationIterator(Book.class).
                forEachRemaining(publicationInOrder::add);
        getTypePublicationIterator(Movie.class).
                forEachRemaining(publicationInOrder::add);
        return publicationInOrder.iterator();
    }

}
