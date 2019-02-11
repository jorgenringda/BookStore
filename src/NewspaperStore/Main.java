/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewspaperStore;

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
        test.addNewspaper("kristofer hattemaker", "hampus e rar", "dyreliv", 12);

        Newspaper tiss = test.getNewspaperByPublisher("hampus e rar");
        System.out.println(tiss.getDetails());

        test.addNewspaper("bæsj på tissen", "tiss i rompa", "hverdagshelter", 0);
        Newspaper tets = test.getNewspaperByTitle("bæsj på tissen");
        System.out.println(tets.getDetails());
        test.soldPublication(0);
        test.deleteNewspaperByTitle("bæsj på tissen");
        //test.deleteNewspaperByPublisher("hampus e rar");

    }

}
