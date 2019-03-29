/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.register;

import newsstand.publication.Publication;

/**
 * Sub-class of Register A register to store the item customer has put in his
 * basket.
 *
 * @author Ishmael
 */
public class CartRegister extends Register {

    /**
     * Constructor
     */
    public CartRegister() {
    }

    /**
     * Method that gets price and quantity from a Publication stored in a
     * cartRegister and calculate the total price and returns the total price.
     *
     * @param publication is the Publication that we are going to get the total
     * price from
     * @return the total price of the Publication added to the register
     */
    public int getTotalForEach(Publication publication) {
        return publication.getPrice() * publication.getQuantity();
    }

    /**
     * Method that removes everything from cartRegister.
     */
    public void clearCart() {
        this.publication.clear();
    }
}
