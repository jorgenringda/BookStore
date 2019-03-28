package newsstand.duplicate;

import java.util.Iterator;
import newsstand.literature.Book;
import newsstand.literature.Literature;
import newsstand.literature.Magazine;
import newsstand.literature.Newspaper;

/**
 * Class that check if there is the same type of Literature in the register that
 * is being added.
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
     * Method that checks for duplicates of Literature type Book. Returns the
     * duplicate Book if it has one else return null.
     *
     * @param duplicateBook is the Book that is being check if it has a
     * duplicate
     * @param typeIterator is an Iterator of all Book in the register
     * @return the duplicate Book if it has one else return null.
     */
    public Book checkDuplicateBook(Book duplicateBook,
            Iterator<Literature> typeIterator) {
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
     * Method that checks for duplicates of Literature type Newspaper. Returns
     * the duplicate Newspaper if it has one else return null.
     *
     * @param duplicateNewspaper is the Newspaper that is being check if it has
     * a duplicate
     * @param typeIterator is an Iterator of all Newspaper in the register
     * @return the duplicate Newspaper if it has one else return null.
     */
    public Newspaper checkDuplicateNewspaper(Newspaper duplicateNewspaper,
            Iterator<Literature> typeIterator) {
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
     * Method that checks for duplicates of Literature type Magazine. Returns
     * the duplicate Magazine if it has one else return null.
     *
     * @param duplicateMagazine is the Magazine that is being check if it has a
     * duplicate
     * @param typeIterator is an Iterator of all Magazine in the register
     * @return the duplicate Magazine if it has one else return null.
     */
    public Magazine checkDuplicateMagazine(Magazine duplicateMagazine,
            Iterator<Literature> typeIterator) {
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
     * Method that checks the type Literature for duplicate Literature. Checks
     * only the parameters that is common for all type of Literature.
     *
     * @param duplicateLiterature is the Literature that is being check if it
     * has a duplicate
     * @param literatureInRegister is Literature in the register that we are
     * checking if its duplicate with
     * @return a Boolean true or false if it found if the two Literature is
     * duplicate on common parameters
     */
    private boolean checkCommonDuplicate(Literature duplicateLiterature,
            Literature literatureInRegister) {
        boolean duplicate = false;
        if (literatureInRegister.getTitle().
                equals(duplicateLiterature.getTitle())) {
            if (literatureInRegister.getPublisher().
                    equals(duplicateLiterature.getPublisher())) {
                if (literatureInRegister.getCategory().
                        equals(duplicateLiterature.getCategory())) {
                    duplicate = true;
                }
            }
        }
        return duplicate;
    }
}
