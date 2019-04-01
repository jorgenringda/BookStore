package newsstand.register;

import newsstand.publication.Movie;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author UltraReidar
 */
public class CartRegisterTest {

    Movie test;
    CartRegister testRegister;

    public CartRegisterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new Movie("hei", "tore", "på", "spore", "30/04/2102", 10, 15);
        testRegister = new CartRegister();
        testRegister.addPublication(test);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalForEach method, of class CartRegister. Gets total of all
     * publication in cart.
     */
    @Test
    public void testGetTotalForEach() {

        int expTotal = 150;
        assertEquals(expTotal, testRegister.getTotalForEach(test));
    }

    /**
     * Test of clearCart method, of class CartRegister. Checks if clearCart
     * method removes all from cart. Checks that by getting an Iterator of all
     * in cart and ask if it has a next, that should be false.
     */
    @Test
    public void testClearCart() {
        testRegister.clearCart();
        assertFalse(testRegister.getIterator().hasNext());
    }

}
