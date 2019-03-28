package newsstand.register;

import newsstand.literature.Literature;
import java.util.ArrayList;
import java.util.Iterator;
import newsstand.duplicate.Duplicate;
import newsstand.literature.Book;
import newsstand.literature.Magazine;
import newsstand.literature.Newspaper;

/**
 * Super class Register for storing Literature
 * <ul>
 * <li> Get Iterator of Literature </li>
 * <li> Get Literature by index </li>
 * <li> Get Iterator of one type of Literature </li>
 * <li> Removes Literature </li>
 * <li> Get duplicate Literature </li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public abstract class Register {

    /**
     * Hold a collection of Literature
     */
    public ArrayList<Literature> literature;

    Duplicate duplicate;

    /**
     * Constructor. Instantiate Literature ArrayList. Instantiate Duplicate.
     */
    public Register() {
        this.literature = new ArrayList<>();
        this.duplicate = new Duplicate();
    }

    /**
     * Returns an iterator of an ArrayList of all Literature
     *
     * @return iterator of ArrayList of Literature
     */
    public Iterator<Literature> getIterator() {
        return literature.iterator();
    }

    /**
     * Method to get an object of Literature by index
     *
     * @param index is the index the object we are going to get is in
     * @return the object that has been found
     */
    public Literature getLiteratureByIndex(int index) {
        Literature literatureByIndex = null;
        if (indexValid(index)) {
            literatureByIndex = this.literature.get(index);
        }
        return literatureByIndex;
    }

    /**
     * Returns an iterator of ArrayList of specific literature
     *
     * @param literature is an object of Literature
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

    /**
     * Method that take the Literature parameter and check what it's an
     * instanceof and loops through all Literature to check if there is a
     * duplicate. returns the duplicate Literature that is already in register
     *
     * @param literature is the Literature that is being check if it has a
     * duplicate.
     * @return the duplicate Literature
     */
    protected Literature getDuplicateLiterature(Literature literature) {
        Literature duplicateFound = null;
        if (literature instanceof Book) {
            Iterator<Literature> checkEmpty
                    = getTypeLiteratureIterator(Book.class);
            duplicateFound = duplicate.
                    checkDuplicateBook((Book) literature,
                            checkEmpty);
        } else if (literature instanceof Magazine) {
            Iterator<Literature> checkEmpty
                    = getTypeLiteratureIterator(Magazine.class);
            duplicateFound = duplicate.
                    checkDuplicateMagazine((Magazine) literature,
                            checkEmpty);
        } else if (literature instanceof Newspaper) {
            Iterator<Literature> checkEmpty
                    = getTypeLiteratureIterator(Newspaper.class);
            duplicateFound = duplicate.
                    checkDuplicateNewspaper((Newspaper) literature,
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
            } else if (index >= literature.size()) {
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }
}
