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
public class MagazineRegisterTest {

    MagazineRegister test2;

    public MagazineRegisterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test2 = new MagazineRegister();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMagazine method, adds invalid magazine, check if magazine can
     * not be add.
     */
    @Test
    public void tryToAddInvalidMagazine() {
        assertFalse(test2.addMagazine("", "ok", "ok", 1));
        assertFalse(test2.addMagazine(null, "ok", "ok", 1));
        assertFalse(test2.addMagazine("ok", "ok", "ok", -10));
    }

    /**
     * Test of addMagazine method, adds valid magazine, checks if magazine can
     * be added
     */
    @Test
    public void tryToAddValidMagazine() {
        assertTrue(test2.addMagazine("kult", "ok", "ok", 1));
        assertTrue(test2.addMagazine("veldig bra", "ok", "ok", 39));
    }

    /**
     * Test of listAllMagazine method, test function that list all magazine
     * tries to list all magazines when there is no magazine in the list
     */
    @Test
    public void testListAllMagazineWhenThereIsNoMagazineInRegister() {
        assertEquals(false, test2.listAllMagazine().hasNext());
    }

    /**
     * Test of getMagazine method, test if the function get title.
     */
    @Test
    public void testGetValidMagazine() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals("ok", test2.getMagazineByTitle("ok").next().getTitle());
        test2.removeMagazineByTitle("ok");
    }

    /**
     * Test of getMagazineByTitle method, checks if we can get a invalid title
     */
    @Test
    public void testGetMagazineByInvalidTitle() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(false, test2.getMagazineByTitle("feil").hasNext());
        test2.removeMagazineByTitle("ok");
    }

    /**
     * Test of getMagazineByPublisher method, test if we can get a valid
     * publisher
     */
    @Test
    public void testGetMagazineByValidPublisher() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(true, test2.getMagazineByPublisher("ok").hasNext());
        test2.removeMagazineByTitle("ok");
    }

    /**
     * Test of removeMagazineByTitle method, remove magazine by title, one i
     * valid test, other one does not have the title we are looking for
     */
    @Test
    public void testRemoveMagazineByTitle() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(true, test2.getMagazineByTitle("ok").hasNext());
        test2.removeMagazineByTitle("ok");
        assertEquals(false, test2.getMagazineByTitle("fins ikkje").hasNext());
    }
}
