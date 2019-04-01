package newsstand.publication;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author UltraReidar
 */
public class BookTest {

    private Book test;

    public BookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new Book("hei", "nei", "stig", "stein", 4, 32, 2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAuthor method, of class Book. Checks if the author is the same
     * as set in constructor.
     */
    @Test
    public void testGetauthor() {
        assertEquals("stig", test.getauthor());
    }

    /**
     * Test of getEdition method, of class Book. Checks if the edition is the
     * same as set in constructor.
     */
    @Test
    public void testGetEdition() {
        assertEquals(4, test.getEdition());
    }

}
