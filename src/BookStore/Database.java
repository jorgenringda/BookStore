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
 * Database for storing magazines
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
public class Database {

    private final ArrayList<Magazine> magazine;

    public Database() {
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
        magazine.add(new Magazine(title, publisher, category, releasePerYear));
        System.out.println(clock() + " Added " + title);
    }

    /**
     * Sells magazine by title, and removes it from the ArrayList. Print out
     * "magazine is not sold" if the magazine is not sold
     *
     * @param title contains the set title as a string
     */
    public void sellMagazineByTitle(String title) {
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
            System.out.println(clock() + " magazine is not sold");
        }
    }

    /**
     * Sells magazine by index, and removes it from the ArrayList. When magazine
     * is removed and print out, magazine is sold.
     *
     * @param index set number of the magazine that is going to be sold.
     */
    public void sellMagazineByIndex(int index) {
        boolean found = false;
        if (indexVaild(index)) {
            found = true;
            Magazine sellMagazine = magazine.get(index);
            System.out.println(clock() + " " + sellMagazine.getTitle() + " is sold");
            magazine.remove(index);
        }
        if (!found) {
            System.out.println(clock() + " magazine is not sold");
        }
    }

    /**
     * checks if an index is vaild and in use. returns true if.
     *
     * @param index set number of the index that is going to be checked if vaild
     * @return valid witch it either true or false.
     */
    private boolean indexVaild(int index) {
        boolean valid;
        if (index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        } else if (index >= magazine.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    /**
     * List magazine by given index and print out.
     *
     * @param index set number of the magazine that is going to listed
     */
    public void listMagazineByIndex(int index) {
        System.out.print(clock() + " " + index + ": ");
        Magazine publication = magazine.get(index);
        System.out.println(publication.getDetails());
    }

    /**
     * List all magazines and print it out.
     */
    public void listAllMagazine() {
        System.out.println("");
        int index = 0;
        while (index < magazine.size()) {
            Magazine publication = magazine.get(index);
            System.out.println(publication.getDetails());
            index++;
        }
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
        ArrayList<Magazine> magazineContains;
        magazineContains = new ArrayList<>();
        // magazine.contains(title);
        magazine.stream().filter((paper) -> (paper.getTitle().toUpperCase().contains(title.toUpperCase()))).forEachOrdered((paper) -> {
            magazineContains.add(paper);
        });
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
        // magazine.contains(title);
        magazine.stream().filter((paper) -> (paper.getTitle().toUpperCase().contains(publisher.toUpperCase()))).forEachOrdered((paper) -> {
            magazineContains.add(paper);
        });
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
            System.out.println(clock() + " magazine is not removed, magazine " + title + " does not exsist");
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
            System.out.println(clock() + " magazine is not removed, magazine publisher " + publisher + " does not exist");
        }
    }

    /**
     * Reads real time clock, returns is a string in minutes and hours.
     *
     * @return clock return real time clock as a string
     */
    public String clock() {
        LocalTime time = LocalTime.now();
        String clock = time.getHour() + " : " + time.getMinute();
        return clock;
    }
}
