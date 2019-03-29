package newsstand.register;

import newsstand.literature.Literature;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Sub-class of Register LiteratureRegister for storing Literature
 * <ul>
 * <li> Get Literature by title as Iterator </li>
 * <li> Get Literature by publisher as Iterator</li>
 * <li> Get Literature to remove by title as Iterator</li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public class LiteratureRegister extends Register {

    /**
     * Constructor. Don't instantiate anything, everything is done by super
     * class.
     */
    public LiteratureRegister() {
        super();
    }

    /**
     * Search for object of type literature that contains the given title,
     * returns an Iterator of all the literature that contains the title.
     *
     * @param title contains the set title as a string.
     * @return an Iterator that contains all the object of type literature that
     * contains the title.
     */
    public Iterator<Literature> getLiteratureByTitle(String title) {
        ArrayList<Literature> literatureContains = new ArrayList<>();
        if (!title.isEmpty()) {
            for (Literature paper : literature) {
                if (paper.getTitle().toUpperCase()
                        .contains(title.toUpperCase())) {
                    literatureContains.add(paper);
                }
            }
        }
        return literatureContains.iterator();
    }

    /**
     * Search for object of type literature that contains the given publisher,
     * returns an Iterator of all the literature that contains the publisher.
     *
     * @param publisher contains the set publisher as a string.
     * @return an Iterator that contains all the object of type literature that
     * contains the publisher.
     */
    public Iterator<Literature> getLiteraturesByPublisher(String publisher) {
        ArrayList<Literature> literatureContains = new ArrayList<>();
        if (!publisher.isEmpty()) {
            for (Literature paper : literature) {
                if (paper.getPublisher().toUpperCase()
                        .contains(publisher.toUpperCase())) {
                    literatureContains.add(paper);
                }
            }
        }
        return literatureContains.iterator();
    }

    /**
     * Returns a Iterator of an ArrayList containing literature.
     *
     * @param title is the String word that is used to search for in an
     * ArrayList
     * @return a Iterator of an ArrayList
     */
    public Iterator<Literature> getLiteratureToRemoveByTitle(String title) {
        ArrayList<Literature> literaturesToRemove = new ArrayList<>();
        if (!title.isEmpty()) {
            for (Literature paper : literature) {
                if (paper.getTitle().toUpperCase()
                        .contains(title.toUpperCase())) {
                    literaturesToRemove.add(paper);
                }
            }
        }
        return literaturesToRemove.iterator();
    }

}
