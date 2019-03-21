/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.register;

import newsstand.literature.Literature;

/**
 *
 * @author Ishmael
 */
public class CartRegister extends Register {

    public CartRegister() {
    }

    public void addLiteratureToCart(Literature literature) {
        this.literature.add(literature);
    }

    public void removeLiteratureFromCart(Literature literature) {
        this.literature.remove(literature);
    }

    public int getTotalForEach(Literature literature) {
        return literature.getPrice() * literature.getQuantity();
    }

    public void clearCart() {
        this.literature.clear();
    }
}
