/*
 * Represent a newspaper by title, publisher, release per year and genre / category
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

/**
 * Holds information about a magazine, It contains of a title, publisher and
 * publications per year
 *
 * @author Ultrareidar
 */
public class Magazine {

    boolean valid = true;

    /**
     * The magazine title
     */
    private String title;

    /**
     * The publisher name
     */
    private String publisher;

    /**
     * type of category the magazine is about.
     */
    private String category;

    /**
     * Number of publications per year of this magazine
     */
    private int releasePerYear;

    /**
     * Assign the passed variables to local categories
     *
     * @param title The title of the magazine
     * @param publisher The publisher of the magazine
     * @param category The category of the magazine
     * @param publicationsPerYear Number of publications per year
     */
    public Magazine(String title, String publisher, String category, int releasePerYear) {
        setTitle(title);
        setPublisher(publisher);
        setCategory(category);
        setReleasePerYear(releasePerYear);
    }

//    /**
//     * returns all data of the magazine
//     *
//     * @return returns the magazine title, publisher, category and release per
//     * year
//     */
//    public String getDetails() {
//        return "Title: " + title + "\nPublisher: " + publisher + "\nField: " + category + "\nRelease Per Year: " + releasePerYear;
//    }
    /**
     * Returns the title of the magazine
     *
     * @return returns the magazine title name
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the magazine
     *
     * @return returns the magazine publisher
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Returns the category of the magazine
     *
     * @return returns the type of category the magazine is
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Returns the number of publications per year
     *
     * @return Returns number of publications per year
     */
    public int getReleasePerYear() {
        return this.releasePerYear;
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            if (title != null) {
                this.title = title;
            }
        } else {
//            System.out.println("No title added");
//            System.out.println("Magazine is not valid");
            valid = false;
        }
    }

    public void setPublisher(String publisher) {
        if (!publisher.isEmpty()) {
            if (publisher != null) {
                this.publisher = publisher;
            }
        } else {
//            System.out.println("No publisher added");
//            System.out.println("Magazine is not valid");
            valid = false;
        }
    }

    public void setCategory(String category) {
        if (!category.isEmpty()) {
            if (category != null) {
                this.category = category;
            }
        } else {
//            System.out.println("No category added");
//            System.out.println("Magazine is not valid");
            valid = false;
        }
    }

    public void setReleasePerYear(int releasePerYear) {
        if (releasePerYear <= 0) {
//            System.out.println("No release per year added");
//            System.out.println("Magazine is not valid");
            valid = false;
        } else {
            this.releasePerYear = releasePerYear;
        }
    }

    public boolean isMagazineValid() {
        return valid;
    }
}
