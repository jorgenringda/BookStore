/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.duplicate;

import java.util.Iterator;
import newsstand.Register;
import newsstand.literature.Book;
import newsstand.literature.Literature;
import newsstand.literature.Magazine;
import newsstand.literature.Newspaper;

/**
 *
 * @author Ishmael
 */
public class Duplicate {

    Register test;

    public void Duplicate() {
        test = new Register();
    }

    /**
     *
     * @param duplicateBook
     * @param typeIterator
     * @return
     */
    public Book checkDuplicateBook(Book duplicateBook, Iterator<Literature> typeIterator) {
        boolean duplicate = false;
        Book book = null;
        if (typeIterator.hasNext()) {
            while (typeIterator.hasNext() && duplicate) {
                book = (Book) typeIterator.next();
                if (book.getTitle().equals(duplicateBook.getTitle())) {
                    if (book.getPublisher().equals(duplicateBook.getPublisher())) {
                        if (book.getCategory().equals(duplicateBook.getCategory())) {
                            if (book.getEdition() == duplicateBook.getEdition()) {
                                if (book.getauthor().equals(duplicateBook.getauthor())) {
                                    duplicate = true;
                                }
                            }
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

    public Newspaper checkDuplicateNewspaper(Newspaper duplicateNewspaper, Iterator<Literature> typeIterator) {
        boolean duplicate = false;
        Newspaper newspaper = null;
        if (typeIterator.hasNext()) {
            while (typeIterator.hasNext() && duplicate) {
                newspaper = (Newspaper) typeIterator.next();
                if (newspaper.getTitle().equals(duplicateNewspaper.getTitle())) {
                    if (newspaper.getPublisher().equals(duplicateNewspaper.getPublisher())) {
                        if (newspaper.getCategory().equals(duplicateNewspaper.getCategory())) {
                            if (newspaper.getDateOfRelease().equals(duplicateNewspaper.getDateOfRelease())) {
                                duplicate = true;
                            }
                        }
                    }
                }
            }
        }
        if (!duplicate) {
            newspaper = null;
        }
        return newspaper;
    }

    public Magazine checkDuplicateMagazine(Magazine duplicateMagazine, Iterator<Literature> typeIterator) {
        boolean duplicate = false;
        Magazine magazine = null;
        if (typeIterator.hasNext()) {
            while (typeIterator.hasNext() && !duplicate) {
                magazine = (Magazine) typeIterator.next();
                if (magazine.getTitle().equals(duplicateMagazine.getTitle())) {
                    if (magazine.getPublisher().equals(duplicateMagazine.getPublisher())) {
                        if (magazine.getCategory().equals(duplicateMagazine.getCategory())) {
                            if (magazine.getReleasePerYear() == duplicateMagazine.getReleasePerYear()) {
                                duplicate = true;
                            }
                        }
                    }
                }
            }
        }
        if (!duplicate) {
            magazine = null;
        }
        return magazine;
    }
}
