/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand;

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
     * Test of getMagazinesIterator method, test function that list all magazine
     * tries to list all magazines when there is no magazine in the list
     */
    @Test
    public void testListAllMagazineWhenThereIsNoMagazineInRegister() {
        assertEquals(false, test2.getMagazinesIterator().hasNext());
    }

    /**
     * Test of getMagazines method, test if the function get title.
     */
    @Test
    public void testGetValidMagazine() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals("ok", test2.getMagazinesByTitle("ok").next().getTitle());
    }

    /**
     * Test of getMagazinesByTitle method, checks if we can get a invalid title
     */
    @Test
    public void testGetMagazineByInvalidTitle() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(false, test2.getMagazinesByTitle("feil").hasNext());
    }

    /**
     * Test of getMagazinesByPublisher method, test if we can get a valid
     * publisher
     */
    @Test
    public void testGetMagazineByValidPublisher() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(true, test2.getMagazinesByPublisher("ok").hasNext());
    }

    /**
     * Test of removeMagazinesByTitle method, remove magazine by title, one i
     * valid test, other one does not have the title we are looking for
     */
    @Test
    public void testGetMagazinesToRemove() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertTrue(test2.getMagazinesByTitle("ok").hasNext());
        test2.removeMagazine(test2.getMagazinesToRemove("ok").next());
        assertFalse(test2.getMagazinesByTitle("ok").hasNext());
    }
}
