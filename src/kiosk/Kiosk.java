/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import java.util.ArrayList;

/**
 * .
 * erwere
 *
 * @author erer
 * @version 1
 */
public class Kiosk {

    private final ArrayList<PeriodicalPublication> forSale;

    public Kiosk() {
        forSale = new ArrayList<>();
    }

    public void addPeriodicalPublication(String title, String publisher, String type, String field, int releasePerYear) {
        forSale.add(new PeriodicalPublication(title, publisher, type, field, releasePerYear));
    }

    public void soldPublication(int index) {
        if (indexVaild(index)) {
            forSale.remove(index);
        }
    }

    private boolean indexVaild(int index) {
        boolean valid;
        if (index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        } else if (index >= forSale.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public void listPublication(int index) {
        System.out.print(index + ": ");
        PeriodicalPublication publication = forSale.get(index);
        System.out.println(publication.getDetails());

    }

    public void listAllPublication() {
        System.out.println("");
        int index = 0;
        while (index < forSale.size()) {
            PeriodicalPublication publication = forSale.get(index);
            System.out.println(publication);
            index++;

            System.out.println("er du med git")
        }
    }
}
