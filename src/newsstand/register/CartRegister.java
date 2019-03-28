/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.register;

import newsstand.literature.Literature;

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

    public void addLiteratureToCart(Literature literature) {
        this.literature.add(literature);
    }

    /**
     * Method that calls a Method that removes Literature from an ArrayList.
     *
     * @param literature is the Literature that is removed from the register
     */
    public void removeLiteratureFromCart(Literature literature) {
        this.literature.remove(literature);
    }

    /**
     * Method that gets price and quantity from a Literature stored in a
     * cartRegister and calculate the total price and returns the total price.
     *
     * @param literature is the Literature that we are going to get the total
     * price from
     * @return the total price of the Literature added to the register
     */
    public int getTotalForEach(Literature literature) {
        return literature.getPrice() * literature.getQuantity();
    }

    /**
     * Method that removes everything from cartRegister.
     */
    public void clearCart() {
        this.literature.clear();
    }
}
