/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand;

import newsstand.literature.Literature;
import java.util.ArrayList;
import java.util.Iterator;
import newsstand.duplicate.Duplicate;
import newsstand.literature.Book;
import newsstand.literature.Magazine;
import newsstand.literature.Newspaper;

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
public class Register {

    private final ArrayList<Literature> literature;
    Duplicate duplicate;

    public Register() {
        this.literature = new ArrayList<>();
        this.duplicate = new Duplicate();
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
     * Returns an iterator of an ArrayList of all Literature
     *
     * @return iterator of ArrayList of Literature
     */
    public Iterator<Literature> getAllLiteratureIterator() {
        return literature.iterator();
    }

    public Literature getLiteratureByIndex(int index) {
        Literature literature = null;
        if (indexValid(index)) {
            literature = this.literature.get(index);
        }
        return literature;
    }

    /**
     * Returns an iterator of ArrayList of specific literature
     *
     * @param literature
     * @return iterator of ArrayList of specify Literature
     */
    public Iterator<Literature> getTypeLiteratureIterator(Class<?> literature) {
        ArrayList<Literature> literatureContains = new ArrayList<>();
        for (Literature type : this.literature) {
            if (type.getClass() == literature) {
                literatureContains.add(type);
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

    /**
     * Removes literature.
     *
     * @param literatureToRemove the literature object user want to remove.
     */
    public void removeLiterature(Literature literatureToRemove) {
        if (getDuplicateLiterature(literatureToRemove) == null) {
            literature.remove(literatureToRemove);
        } else {
            if (getDuplicateLiterature(literatureToRemove).getQuantity() <= 1) {
                literature.remove(literatureToRemove);
            } else {
                getDuplicateLiterature(literatureToRemove).decreaseStock();
            }
        }
    }

    private Literature getDuplicateLiterature(Literature literature) {
        Literature duplicateFound = null;
        if (literature instanceof Book) {
            try {
                Iterator<Literature> checkEmpty = getTypeLiteratureIterator(Book.class);
                duplicateFound = duplicate.checkDuplicateBook((Book) literature, checkEmpty);
            } catch (NullPointerException e) {
            }
        } else if (literature instanceof Magazine) {
            try {
                Iterator<Literature> checkEmpty = getTypeLiteratureIterator(Magazine.class);
                duplicateFound = duplicate.checkDuplicateMagazine((Magazine) literature, checkEmpty);
            } catch (NullPointerException e) {
            }
        } else if (literature instanceof Newspaper) {
            try {
                Iterator<Literature> checkEmpty = getTypeLiteratureIterator(Newspaper.class);
                duplicateFound = duplicate.checkDuplicateNewspaper((Newspaper) literature, checkEmpty);
            } catch (NullPointerException e) {
            }
        }
        return duplicateFound;
    }

    /**
     * checks if an index is vaild and in use. returns true if.
     *
     * @param index set number of the index that is going to be checked if vaild
     * @return valid witch it either true or false.
     */
    private boolean indexValid(int index) {
        boolean valid = false;
        if (index < 0) {
            valid = false;
        } else {
            if (index < 0) {

                valid = false;
            } else if (index >= literature.size()) {
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }
}
