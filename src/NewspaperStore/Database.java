/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewspaperStore;

import java.util.ArrayList;

/**
 *
 *
 * @author Ultrareidar
 * @version V1.0
 */
public class Database {

    private final ArrayList<Newspaper> newspaper;

    public Database() {
        newspaper = new ArrayList<>();
    }

    public void addNewspaper(String title, String publisher, String field, int releasePerYear) {
        newspaper.add(new Newspaper(title, publisher, field, releasePerYear));
    }

    public void soldPublication(int index) {
        if (indexVaild(index)) {
            newspaper.remove(index);
            System.out.println("Newspaper is sold");
        }
    }

    private boolean indexVaild(int index) {
        boolean valid;
        if (index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        } else if (index >= newspaper.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public void listPublication(int index) {
        System.out.print(index + ": ");
        Newspaper publication = newspaper.get(index);
        System.out.println(publication.getDetails());

    }

    public void listAllPublication() {
        System.out.println("");
        int index = 0;
        while (index < newspaper.size()) {
            Newspaper publication = newspaper.get(index);
            System.out.println(publication.getDetails());
            index++;

        }
    }

    public Newspaper getNewspaperByTitle(String title) {
        // newspaper.contains(title);
        for (Newspaper paper : newspaper) {
            if (paper.getTitle().contains(title)) {
                return paper;
            }
        }
        return null;
    }

    public Newspaper getNewspaperByPublisher(String publisher) {
        // newspaper.contains(title);
        for (Newspaper paper : newspaper) {
            if (paper.getPublisher().contains(publisher)) {
                return paper;
            }
        }
        return null;
    }

    public void deleteNewspaperByTitle(String title) {

        newspaper.remove(getNewspaperByTitle(title));
        Newspaper test = getNewspaperByTitle(title);
        if (test == null) {
            System.out.println("Newspaper is deleted");
        }
    }

    public void deleteNewspaperByPublisher(String publisher) {

        newspaper.remove(getNewspaperByPublisher(publisher));
        Newspaper test = getNewspaperByPublisher(publisher);
        if (test == null) {
            System.out.println("Newspaper is deleted");
        }
    }
}
