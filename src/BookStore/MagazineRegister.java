/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * MagazineRegister for storing magazines
 * <ul>
 * <li> Add Magazine </li>
 * <li> Sell magazine by title </li>
 * <li> Sell magazine by index </li>
 * <li> List Magazine by index </li>
 * <li> List all magazine </li>
 * <li> Get magazine by title </li>
 * <li> Get magazine by publisher </li>
 * <li> Removes magazine by title </li>
 * <li> Removes magazine by publisher </li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public class MagazineRegister {

    private final ArrayList<Magazine> magazine;

    /**
     * defining variables to use in switch-case for print out error message.
     */
    private enum errorMessage {
        notSold, noTitle, indexInvalid, negativeIndex,
        indexToLarge, emptyList, noMagazine, noPublisher,
        notRemovedTitle, notRemovedPublisher, magazineNotAdded,
    }

    private String magazineError = "";

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
     */
    public void addMagazine(String title, String publisher,
            String category, int releasePerYear) {
        Magazine magazine1 = new Magazine(title, publisher,
                category, releasePerYear);
        if (magazine1.isMagazineValid()) {
            magazine.add(magazine1);
            System.out.println(clock() + " Added " + title);
        } else {
            magazineError = magazine1.errorMessage();
            errorPrint(errorMessage.magazineNotAdded);
        }
    }

    /**
     * Sells magazine by title, and removes it from the ArrayList. Print out
     * "magazine is not sold" if the magazine is not sold
     *
     * @param title contains the set title as a string
     */
    public void sellMagazineByTitle(String title) {
        if (title != null) {
            if (!title.isEmpty()) {
                boolean found = false;
                Iterator<Magazine> it = this.magazine.iterator();
                while (it.hasNext() && !found) {
                    Magazine paper = it.next();
                    if (paper.getTitle().toUpperCase()
                            .equals(title.toUpperCase())) {
                        found = true;
                        System.out.println(clock() + " "
                                + paper.getTitle() + " is sold");
                        magazine.remove(paper);
                    }
                }
                if (!found) {
                    errorPrint(errorMessage.notSold);
                }
            }
        } else {
            errorPrint(errorMessage.noTitle);
        }
    }

    /**
     * Sells magazine by index, and removes it from the ArrayList. When magazine
     * is removed and print out, magazine is sold.
     *
     * @param index set number of the magazine that is going to be sold.
     */
    public void sellMagazineByIndex(int index) {
        boolean found = indexVaild(index);

        if (indexVaild(index)) {
            found = true;
            Magazine sellMagazine = magazine.get(index);
            System.out.println(clock() + " "
                    + sellMagazine.getTitle() + " is sold");
            magazine.remove(index);
        }
        if (!found) {
            errorPrint(errorMessage.notSold);
        }
    }

    /**
     * checks if an index is vaild and in use. returns true if.
     *
     * @param index set number of the index that is going to be checked if vaild
     * @return valid witch it either true or false.
     */
    private boolean indexVaild(int index) {
        boolean valid = false;
        if (index < 0) {
            errorPrint(errorMessage.indexInvalid);
        } else {
            if (index < 0) {
                errorPrint(errorMessage.negativeIndex);
                valid = false;
            } else if (index >= magazine.size()) {
                errorPrint(errorMessage.indexToLarge);
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }

    /**
     * List all magazines and print it out.
     *
     * @return magazine.iterator Returns iterator of ArrayList of magazines
     */
    public Iterator<Magazine> listAllMagazine() {
        if (magazine.isEmpty()) {
            errorPrint(errorMessage.emptyList);
        }
        return magazine.iterator();
    }

    public Magazine getMagazine(int index) {
        Magazine publication = magazine.get(index);
        return publication;
    }

    /**
     * Search for object of type magazine that contains the given title, returns
     * a ArrayList of all the magazine that contains the title.
     *
     * @param title contains the set title as a string.
     * @return magazineContains an ArrayList that contains all the object of
     * type magazine that contains the title.
     */
    public Iterator<Magazine> getMagazineByTitle(String title) {
        ArrayList<Magazine> magazineContains = new ArrayList<>();
        if (title != null) {
            if (!title.isEmpty()) {
                for (Magazine paper : magazine) {
                    if (paper.getTitle().toUpperCase()
                            .contains(title.toUpperCase())) {
                        magazineContains.add(paper);
                    }
                }
                if (magazineContains.isEmpty()) {
                    errorPrint(errorMessage.noMagazine);
                }

            }
        } else {
            errorPrint(errorMessage.noTitle);
        }
        return magazineContains.iterator();
    }

    /**
     * Search for object of type magazine that contains the given publisher,
     * returns a ArrayList of all the magazine that contains the publisher.
     *
     * @param publisher contains the set publisher as a string.
     * @return magazineContains an ArrayList that contains all the object of
     * type magazine that contains the publisher.
     */
    public Iterator<Magazine> getMagazineByPublisher(String publisher) {
        ArrayList<Magazine> magazineContains = new ArrayList<>();
        if (publisher != null) {
            if (!publisher.isEmpty()) {
                for (Magazine paper : magazine) {
                    if (paper.getPublisher().toUpperCase()
                            .contains(publisher.toUpperCase())) {
                        magazineContains.add(paper);
                    }
                }
                if (magazineContains.isEmpty()) {
                    errorPrint(errorMessage.noMagazine);
                }
            }
        } else {
            errorPrint(errorMessage.noPublisher);
        }
        return magazineContains.iterator();
    }

    /**
     * Remove magazine by title. When removing it print out "magazine(title) is
     * removed". Else print "magazine is not removed"
     *
     * @param title contains the set title as a string.
     */
    public void removeMagazineByTitle(String title) {
        boolean found = false;
        if (title != null) {
            if (!title.isEmpty()) {
                Iterator<Magazine> it = this.magazine.iterator();
                while (it.hasNext() && !found) {
                    Magazine paper = it.next();
                    if (paper.getTitle().toUpperCase()
                            .equals(title.toUpperCase())) {
                        found = true;
                        System.out.println(clock() + " "
                                + paper.getTitle() + " is removed");
                        magazine.remove(paper);
                    }
                }
                if (!found) {
                    errorPrint(errorMessage.notRemovedTitle);
                }
            }
        } else {
            errorPrint(errorMessage.noTitle);
        }
    }

    /**
     * Removes magazine by publisher. When removing it print out
     * "magazine(publisher) is removed". Else print "Magazine is not removed".
     *
     * @param publisher contains the set publisher as a string
     */
    public void removeMagazineByPublisher(String publisher) {
        boolean found = false;
        if (publisher != null) {
            if (!publisher.isEmpty()) {
                Iterator<Magazine> it = this.magazine.iterator();
                while (it.hasNext() && !found) {
                    Magazine paper = it.next();
                    if (paper.getPublisher().toUpperCase()
                            .equals(publisher.toUpperCase())) {
                        found = true;
                        System.out.println(clock() + " "
                                + paper.getPublisher() + " is removed");
                        magazine.remove(paper);
                    }
                }
                if (!found) {
                    errorPrint(errorMessage.notRemovedPublisher);
                }
            }
        } else {
            errorPrint(errorMessage.noPublisher);
        }
    }

    /**
     * Reads real time clock, returns is a string in minutes and hours.
     *
     * @return clock return real time clock as a string
     */
    public StringBuilder clock() {
        StringBuilder clock = new StringBuilder();
        LocalTime time = LocalTime.now();
        clock.append("\nTime: ");
        clock.append((time.getHour() > 9)
                ? ("" + time.getHour()) : ("0" + time.getHour()));
        clock.append(" : ");
        clock.append((time.getMinute() > 9)
                ? ("" + time.getMinute()) : ("0" + time.getMinute()));
        return clock;
    }

    private void errorPrint(errorMessage error) {
        StringBuilder errorString = new StringBuilder();
        errorString.append("\nERROR: ");
        switch (error) {
            case notSold:
                errorString.append("Magazine is not sold");
                break;
            case noTitle:
                errorString.append("Don't have a title to search for");
                break;
            case indexInvalid:
                errorString.append("index not vaild");
                break;
            case negativeIndex:
                errorString.append("Index cannot be negative");
                break;
            case indexToLarge:
                errorString.append("Index is too large");
                break;
            case emptyList:
                errorString.append("No magazine to list");
                break;
            case noMagazine:
                errorString.append("Didnt find the magazine you searched for");
                break;
            case noPublisher:
                errorString.append("Don't have a publisher to search for");
                break;
            case notRemovedTitle:
                errorString.append("Magazine is not removed, "
                        + "magazine title does not exsist");
                break;
            case notRemovedPublisher:
                errorString.append("Magazine is not removed, "
                        + "magazine publisher does not exist");
                break;
            case magazineNotAdded:
                errorString.append("Magazine is not added, "
                        + "input is not correct\n");
                errorString.append(magazineError);
                break;
        }
        System.out.println(errorString);
    }
}
