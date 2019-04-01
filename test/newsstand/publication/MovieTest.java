package newsstand.publication;

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
public class MovieTest {

    Movie test;

    public MovieTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new Movie("hei", "geir", "nei", "stein", "20/07/2015", 22, 123);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDirector method, of class Movie. Checks if director is the
     * same as set in constructor.
     */
    @Test
    public void testGetDirector() {
        assertEquals("geir", test.getDirector());
    }

    /**
     * Test of getDateOfRelease method, of class Movie. Checks if date of
     * release is the same as set in constructor.
     */
    @Test
    public void testGetDateOfRelease() {
        assertEquals("20/07/2015", test.getDateOfRelease());
    }

}
