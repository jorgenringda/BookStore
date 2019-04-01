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
public class NewspaperTest {

    Newspaper test;

    public NewspaperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new Newspaper("hei", "nei", "stein", "20/12/2083", 10, 20);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDateOfRelease method, of class Newspaper.
     */
    @Test
    public void testGetDateOfRelease() {
        assertEquals("20/12/2083", test.getDateOfRelease());
    }

}
