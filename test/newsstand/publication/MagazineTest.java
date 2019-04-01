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
public class MagazineTest {

    Magazine test;

    public MagazineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new Magazine("test", "test", "test", 10, 1, 1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getReleasePerYear method, checks if the result of get release per
     * year is the one that is expected
     */
    @Test
    public void testGetReleasePerYear() {

        int expResult = 10;
        int result = test.getReleasePerYear();
        assertEquals(expResult, result);
    }

}
