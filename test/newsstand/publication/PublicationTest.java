package newsstand.publication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test to test method in class Publication.
 *
 * @author UltraReidar
 */
public class PublicationTest {

    Publication test;

    public PublicationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new Magazine("hei", "nei", "stein", 10, 5, 0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of increaseStock method, of class Publication. Checks if we can add
     * 1 to stock.
     */
    @Test
    public void testIncreaseStock() {
        test.increaseStock();
        assertEquals(1, test.getQuantity());
    }

    /**
     * Test of decreaseStock method, of class Publication. Checks if we can not
     * decrease the stock to negative.
     */
    @Test
    public void testDecreaseStock() {
        test.decreaseStock();
        assertNotEquals(-1, test.getQuantity());
        assertEquals(0, test.getQuantity());
    }

    /**
     * Test of addOrRemoveStock method, of class Publication. Checks if we can
     * add 100 to stock and we can not get quantity in minus, only 0.
     */
    @Test
    public void testAddOrRemoveStock() {
        test.addOrRemoveStock(100);
        assertEquals(100, test.getQuantity());
        test.addOrRemoveStock(-200);
        assertEquals(0, test.getQuantity());
    }

    /**
     * Test of getTitle method, of class Publication. Checks if the title is
     * correct.
     */
    @Test
    public void testGetTitle() {
        String expResult = "hei";
        String result = test.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPublisher method, of class Publication. Checks if the added
     * publisher is not the same as we expected.
     */
    @Test
    public void testGetPublisher() {
        String expResult = "ikkje riktig";
        String result = test.getPublisher();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class Publication. Checks if the added
     * category is the same ass expected.
     */
    @Test
    public void testGetCategory() {
        String expResult = "stein";
        String result = test.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Publication. Checks if the price is
     * correct.
     */
    @Test
    public void testGetPrice() {
        assertNotEquals(6, test.getPrice());
        assertNotEquals(4, test.getQuantity());
        assertEquals(5, test.getPrice());
    }

    /**
     * Test of getQuantity method, of class Publication. Checks if the quantity
     * added is the same.
     */
    @Test
    public void testGetQuantity() {
        assertEquals(0, test.getQuantity());
    }
}
