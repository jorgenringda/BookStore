/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand;

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
public class MagazineRegister {

    private final ArrayList<Magazine> magazine;

    public MagazineRegister() {
        magazine = new ArrayList<>();
    }

    /**
     * Add a new magazine into a ArrayList of magazines.
     *
     * @param title contains the set title as a string
     * @param publisher contains the set publisher as a string
     * @param category contains the set category as a string
     * @param releasePerYear contains the set releaser per year as an integer
     * @return a Boolean true or false if magazine is added or not
     */
    public boolean addMagazine(String title, String publisher,
            String category, int releasePerYear) {
        boolean magazineAdded = false;

        Magazine magazine1 = new Magazine(title, publisher,
                category, releasePerYear);
        if (magazine1.isMagazineValid()) {
            magazine.add(magazine1);
            magazineAdded = true;
        }
        return magazineAdded;
    }

    /**
     * Returns an iterator of an ArrayList of magazines
     *
     * @return iterator of ArrayList of magazines
     */
    public Iterator<Magazine> getMagazinesIterator() {
        return magazine.iterator();
    }

    /**
     * Search for object of type magazine that contains the given title, returns
     * a ArrayList of all the magazines that contains the title.
     *
     * @param title contains the set title as a string.
     * @return an ArrayList that contains all the object of type magazine that
     * contains the title.
     */
    public Iterator<Magazine> getMagazinesByTitle(String title) {
        ArrayList<Magazine> magazineContains = new ArrayList<>();
        if (!title.isEmpty()) {
            for (Magazine paper : magazine) {
                if (paper.getTitle().toUpperCase()
                        .contains(title.toUpperCase())) {
                    magazineContains.add(paper);
                }
            }
        }
        return magazineContains.iterator();
    }

    /**
     * Search for object of type magazine that contains the given publisher,
     * returns a ArrayList of all the magazines that contains the publisher.
     *
     * @param publisher contains the set publisher as a string.
     * @return an ArrayList that contains all the object of type magazine that
     * contains the publisher.
     */
    public Iterator<Magazine> getMagazinesByPublisher(String publisher) {
        ArrayList<Magazine> magazineContains = new ArrayList<>();
        if (!publisher.isEmpty()) {
            for (Magazine paper : magazine) {
                if (paper.getPublisher().toUpperCase()
                        .contains(publisher.toUpperCase())) {
                    magazineContains.add(paper);
                }
            }
        }
        return magazineContains.iterator();
    }

    /**
     * Returns a Iterator of an ArrayList containing magazines.
     *
     * @param title contains the set title as a string.
     * @return a Iterator of an ArrayList
     */
    public Iterator<Magazine> getMagazinesToRemove(String title) {
        ArrayList<Magazine> magazinesToRemove = new ArrayList<>();
        if (!title.isEmpty()) {
            for (Magazine paper : magazine) {
                if (paper.getTitle().toUpperCase()
                        .contains(title.toUpperCase())) {
                    magazinesToRemove.add(paper);
                }
            }
        }
        return magazinesToRemove.iterator();
    }

    /**
     * Remove magazine by title.When removing it print out "magazine(title) is
     * removed".Else print "magazine is not removed"
     *
     * @param magazineToRemove the magazine object user want to remove.
     */
    public void removeMagazine(Magazine magazineToRemove) {
        magazine.remove(magazineToRemove);
    }
}
