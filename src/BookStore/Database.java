/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.util.ArrayList;

/**
 * Database for storing magazines
 * <ul>
 * <li> add Magazine </li>
 * <li> Sell magazine by title </li>
 * <li> sell magazine by index </li>
 * <li> list Magazine by index </li>
 * <li> list all magazine </li>
 * <li> get magazine by title </li>
 * <li> get magazine by publisher </li>
 * <li> delete magazine by title </li>
 * <li> delete magazine by publisher </li>
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

    public void addMagazine(String title, String publisher, String field, int releasePerYear) {
        magazine.add(new Magazine(title, publisher, field, releasePerYear));
    }

    public void sellMagazineByTitle(String title) {
        for (Magazine paper : magazine) {
            if (paper.getTitle().contains(title)) {
                magazine.remove(paper);
            }
            Magazine test = paper;
            if (test == null) {
                System.out.println("Magazine is sold");
            }
        }

    }

    public void sellMagazineByIndex(int index) {
        if (indexVaild(index)) {
            magazine.remove(index);
            System.out.println("Magazine is sold");
        }
    }

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

    public void listBewspaperByIndex(int index) {
        System.out.print(index + ": ");
        Magazine publication = magazine.get(index);
        System.out.println(publication.getDetails());

    }

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
     *
     * @param title
     * @return
     */
    public ArrayList<Magazine> getMagazineByTitle(String title) {
        ArrayList<Magazine> magazineContains = new ArrayList<Magazine>();
        // magazine.contains(title);
        for (Magazine paper : magazine) {
            if (paper.getTitle().contains(title)) {
                magazineContains.add(paper);
            }
        }
        return magazineContains;
    }

    /**
     *
     * @param title
     * @return
     */
    public ArrayList<Magazine> getMagazineByPublisher(String publisher) {
        ArrayList<Magazine> magazineContains = new ArrayList<Magazine>();
        // magazine.contains(title);
        for (Magazine paper : magazine) {
            if (paper.getTitle().contains(publisher)) {
                magazineContains.add(paper);
            }
        }
        return magazineContains;
    }

    public void deleteMagazineByTitle(String title) {
        for (Magazine paper : magazine) {
            if (paper.getTitle().contains(title)) {
                magazine.remove(paper);
            }
            Magazine test = paper;
            if (test == null) {
                System.out.println("Magazine is deleted");
            }
        }
    }

    public void deleteMagazineByPublisher(String publisher) {
        for (Magazine paper : magazine) {
            if (paper.getPublisher().contains(publisher)) {
                magazine.remove(paper);
            }
            Magazine test = paper;
            if (test == null) {
                System.out.println("Magazine is deleted");
            }
        }
    }
}
