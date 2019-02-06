/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.util.ArrayList;

/**
 *
 * @author Ultrareidar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Database test = new Database();

        /**
         * add 12 magazines
         */
        for (int i = 1; i < 13; i++) {
            test.addMagazine("kristofer hattemaker " + i, "hampus e rar " + i, "dyreliv", 12);
        }

        /**
         * sells magazine by title
         */
        test.sellMagazineByTitle("kristofer hattemaker 2");

        /**
         * print out alla magazine with the title contains "kristofer ha"
         */
        ArrayList<Magazine> magazineByTitle = test.getMagazineByTitle("kristofer ha");
        magazineByTitle.forEach((magazine) -> {
            System.out.println(magazine.getDetails());
        });

        /**
         * removes magazine
         */
        test.removeMagazineByPublisher("hampus e rar 2");
    }
}
