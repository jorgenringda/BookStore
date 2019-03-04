/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ishmael
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
        test = new Magazine("test1", "test2", "test3", 4);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, checks getTitle works.
     */
    @Test
    public void testGetTitle() {

        String expResult = "test1";
        String result = test.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, test if expected result is not the same as the
     * result
     */
    @Test
    public void testGetPublisher() {
        String expResult = "fins ikkje";
        String result = test.getPublisher();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getTitle method, checks if the set category is the same as it is
     */
    @Test
    public void testGetCategory() {

        String expResult = "test3";
        String result = test.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, checks if the result of get release per year is
     * the one that is expected
     */
    @Test
    public void testGetReleasePerYear() {

        int expResult = 4;
        int result = test.getReleasePerYear();
        assertEquals(expResult, result);
    }

}
