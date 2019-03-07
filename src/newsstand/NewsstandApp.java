/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand;

/**
 * The Main-class of the application. This class only holds the main()-method to
 * start the application.
 *
 * @author Ultrareidar
 * @version 1.0
 */
public class NewsstandApp {

    /**
     * The main entry for the application.
     *
     * @param args arguments provided during startup of the application
     */
    public static void main(String[] args) {
        ApplicationUI appUI = new ApplicationUI();
        appUI.start();
    }
}
