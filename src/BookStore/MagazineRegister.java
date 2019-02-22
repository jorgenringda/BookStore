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
        Magazine magazine1 = new Magazine(title, publisher, category, releasePerYear);
        if (magazine1.isMagazineValid()) {
            magazine.add(magazine1);
            System.out.println(clock() + " Added " + title);
        }
    }

    /**
     * Sells magazine by title, and removes it from the ArrayList. Print out
     * "magazine is not sold" if the magazine is not sold
     *
     * @param title contains the set title as a string
     */
    public void sellMagazineByTitle(String title) {
        if (!title.isEmpty()) {
            if (title != null) {
                boolean found = false;
                Iterator<Magazine> it = this.magazine.iterator();
                while (it.hasNext() && !found) {
                    Magazine paper = it.next();
                    if (paper.getTitle().toUpperCase().equals(title.toUpperCase())) {
                        found = true;
                        System.out.println(clock() + " " + paper.getTitle() + " is sold");
                        magazine.remove(paper);
                    }
                }
                if (!found) {
                    errorPrint(1);
                }
            }
        } else {
            errorPrint(2);
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
            System.out.println(clock() + " " + sellMagazine.getTitle() + " is sold");
            magazine.remove(index);
        }
        if (!found) {
            errorPrint(1);
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
            errorPrint(3);
        } else {
            if (index < 0) {
                errorPrint(4);
                valid = false;
            } else if (index >= magazine.size()) {
                errorPrint(5);
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }

    /**
     * List magazine by given index and print out.
     *
     * @param index set number of the magazine that is going to listed
     *
     * public void listMagazineByIndex(int index) { if (indexVaild(index) ==
     * true) { System.out.print(clock() + " " + index + ": "); Magazine
     * publication = magazine.get(index); System.out.println(getDetails(index));
     * } } /
     *
     * /**
     * List all magazines and print it out.
     * @return
     */
    public ArrayList<Magazine> listAllMagazine() {
        if (magazine.isEmpty()) {
            errorPrint(6);
        }
        return magazine;
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
    public ArrayList<Magazine> getMagazineByTitle(String title) {
        ArrayList<Magazine> magazineContains = new ArrayList<>();
        if (!title.isEmpty()) {
            if (title != null) {
                for (Magazine paper : magazine) {
                    if (paper.getTitle().toUpperCase().contains(title.toUpperCase())) {
                        magazineContains.add(paper);
                        //System.out.println(getDetails(magazine.indexOf(paper)));
                    }
                }
                if (magazineContains.isEmpty()) {
                    errorPrint(7);
                }

            }
        } else {
            errorPrint(8);
        }
        return magazineContains;
    }

    /**
     * Search for object of type magazine that contains the given publisher,
     * returns a ArrayList of all the magazine that contains the publisher.
     *
     * @param publisher contains the set publisher as a string.
     * @return magazineContains an ArrayList that contains all the object of
     * type magazine that contains the publisher.
     */
    public ArrayList<Magazine> getMagazineByPublisher(String publisher) {
        ArrayList<Magazine> magazineContains = new ArrayList<>();
        if (!publisher.isEmpty()) {
            if (publisher != null) {
                for (Magazine paper : magazine) {
                    if (paper.getPublisher().toUpperCase().contains(publisher.toUpperCase())) {
                        magazineContains.add(paper);
                        //System.out.println(getDetails(magazine.indexOf(paper)));
                    }
                }
                if (magazineContains.isEmpty()) {
                    errorPrint(7);
                }
            }
        } else {
            errorPrint(9);
        }
        return magazineContains;
    }

    /**
     * Remove magazine by title. When removing it print out "magazine(title) is
     * removed". Else print "magazine is not removed"
     *
     * @param title contains the set title as a string.
     */
    public void removeMagazineByTitle(String title) {
        boolean found = false;
        if (!title.isEmpty()) {
            if (title != null) {
                Iterator<Magazine> it = this.magazine.iterator();
                while (it.hasNext() && !found) {
                    Magazine paper = it.next();
                    if (paper.getTitle().toUpperCase().equals(title.toUpperCase())) {
                        found = true;
                        System.out.println(clock() + " " + paper.getTitle() + " is removed");
                        magazine.remove(paper);
                    }
                }
                if (!found) {
                    errorPrint(10);
                }
            }
        } else {
            errorPrint(8);
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
        if (!publisher.isEmpty()) {
            if (publisher != null) {
                Iterator<Magazine> it = this.magazine.iterator();
                while (it.hasNext() && !found) {
                    Magazine paper = it.next();
                    if (paper.getPublisher().toUpperCase().equals(publisher.toUpperCase())) {
                        found = true;
                        System.out.println(clock() + " " + paper.getPublisher() + " is removed");
                        magazine.remove(paper);
                    }
                }
                if (!found) {
                    errorPrint(11);
                }
            }
        } else {
            errorPrint(9);
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

    private void errorPrint(int index) {
        StringBuilder errorString = new StringBuilder();
        errorString.append("\nERROR: ");
        int error = index;
        switch (error) {
            case 1:
                errorString.append(" magazine is not sold");
                break;
            case 2:
                errorString.append("Don't have a title to search for");
                break;
            case 3:
                errorString.append("index not vaild");
                break;
            case 4:
                errorString.append("Index cannot be negative");
                break;
            case 5:
                errorString.append("Index is too large");
                break;
            case 6:
                errorString.append("No magazine to list");
                break;
            case 7:
                errorString.append("Didnt find the magazine you searched for");
                break;
            case 8:
                errorString.append("Don't have a title to search for");
                break;
            case 9:
                errorString.append("Don't have a publisher to search for");
                break;
            case 10:
                errorString.append("Magazine is not removed, magazine title does not exsist");
                break;
            case 11:
                errorString.append("Magazine is not removed, magazine publisher does not exist");
                break;
        }
        System.out.println(errorString);
    }
}
