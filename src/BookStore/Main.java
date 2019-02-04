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
        for (int i = 0; i < 20; i++) {
            test.addMagazine("kristofer hattemaker " + i, "hampus e rar " + i, "dyreliv", 12);
        }
        //  for (Magazine tiss : test) {
        //     Magazine tiss = test.getMagazineByPublisher("hampus e rar");
        //      System.out.println(tiss.getDetails());
        //     }
        test.addMagazine("bæsj på tissen", "tiss i rompa", "hverdagshelter", 0);
        //Magazine tets = test.getMagazineByTitle("bæsj på tissen");
        // System.out.println(tets.getDetails());
        test.sellMagazineByIndex(0);
        // test.deleteMagazineByTitle("bæsj på tissen");
        //test.deleteMagazineByPublisher("hampus e rar");

        ArrayList<Magazine> test66 = test.getMagazineByTitle("kristofer ha");
        for (Magazine test88 : test66) {
            System.out.println(test88.getDetails());
        }

    }

}
