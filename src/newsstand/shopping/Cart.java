/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.shopping;

import java.util.ArrayList;
import java.util.Iterator;
import newsstand.literature.Literature;

/**
 *
 * @author Ishmael
 */
public class Cart {

    private ArrayList<Literature> shoppingCart;

    public Cart() {
        this.shoppingCart = new ArrayList<>();
    }

    public void addLiteratureToCart(Literature literature) {
        shoppingCart.add(literature);
    }

    public void removeLiteratureFromCart(Literature literature) {
        shoppingCart.remove(literature);
    }

    public Iterator<Literature> getCartIterator() {
        return this.shoppingCart.iterator();

    }
}
