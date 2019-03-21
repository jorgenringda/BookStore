/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.register;

import newsstand.literature.Literature;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * MagazineRegister for storing magazines
 * <ul>
 * <li> Add Magazine </li>
 * <li> List all magazine </li>
 * <li> Get magazine by title </li>
 * <li> Get magazine by publisher </li>
 * <li> Removes magazine by title </li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public class LiteratureRegister extends Register {

    public LiteratureRegister() {
        super();
    }

    /**
     * Add a new magazine into a ArrayList of magazines.
     *
     * @param literature
     * @return a Boolean true or false if magazine is added or not
     */
    public boolean addLiterature(Literature literature) {
        boolean magazineAdded = false;
        try {
            getDuplicateLiterature(literature).increaseStock();
        } catch (NullPointerException e) {
            try {
                if (literature.isLiteratureValid()) {
                    magazineAdded = this.literature.add(literature);
                    magazineAdded = true;
                }
            } catch (NullPointerException error) {
                magazineAdded = false;
            }
        }
        return magazineAdded;
    }

    /**
     * Search for object of type literature that contains the given title,
     * returns a ArrayList of all the literature that contains the title.
     *
     * @param title contains the set title as a string.
     * @return an ArrayList that contains all the object of type literature that
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
     * Search for object of type literature that contains the given title,
     * returns a ArrayList of all the literature that contains the title.
     *
     * @param title contains the set title as a string.
     * @return an ArrayList that contains all the object of type literature that
     * contains the title.
     */
    public ArrayList<Literature> getLiteratureByTitleArray(String title) {
        ArrayList<Literature> literatureContains = new ArrayList<>();
        if (!title.isEmpty()) {
            for (Literature paper : literature) {
                if (paper.getTitle().toUpperCase()
                        .contains(title.toUpperCase())) {
                    literatureContains.add(paper);
                }
            }
        }
        return literatureContains;
    }

    /**
     * Search for object of type literature that contains the given publisher,
     * returns a ArrayList of all the literature that contains the publisher.
     *
     * @param publisher contains the set publisher as a string.
     * @return an ArrayList that contains all the object of type literature that
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
     * @param title
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
