/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.util.Iterator;
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
     * Test of addMagazine method, of class MagazineRegister.
     */
    @Test
    public void tryToAddInvalidMagazine() {
        assertFalse(test2.addMagazine("", "ok", "ok", 1));
        assertFalse(test2.addMagazine(null, "ok", "ok", 1));
        assertFalse(test2.addMagazine("ok", "ok", "ok", -10));
    }

    /**
     * Test of addMagazine method, of class MagazineRegister.
     */
    @Test
    public void tryToAddValidMagazine() {
        assertTrue(test2.addMagazine("kult", "ok", "ok", 1));
        assertTrue(test2.addMagazine("veldig bra", "ok", "ok", 39));
    }

    /**
     * Test of sellMagazineByTitle method, of class MagazineRegister.
     */
    @Test
    public void tryToSellInvalidMagazine() {
        assertEquals(false, test2.sellMagazineByTitle("fins ikkje"));
    }

    /**
     * Test of sellMagazineByTitle method, of class MagazineRegister.
     */
    @Test
    public void tryToSellValidMagazine() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(true, test2.sellMagazineByTitle("ok"));
        test2.removeMagazineByTitle("ok");
    }

    /**
     * Test of listAllMagazine method, of class MagazineRegister.
     */
    @Test
    public void testListAllMagazineWhenThereIsNoMagazineInRegister() {
        assertEquals(false, test2.listAllMagazine().hasNext());
    }

    /**
     * Test of getMagazine method, of class MagazineRegister.
     */
    @Test
    public void testGetValidMagazine() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals("ok", test2.getMagazine(0).getTitle());
        test2.removeMagazineByTitle("ok");
    }

    /**
     * Test of getMagazineByTitle method, of class MagazineRegister.
     */
    @Test
    public void testGetMagazineByInvalidTitle() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(false, test2.getMagazineByTitle("feil").hasNext());
        test2.removeMagazineByTitle("ok");
    }

    /**
     * Test of getMagazineByPublisher method, of class MagazineRegister.
     */
    @Test
    public void testGetMagazineByValidPublisher() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(true, test2.getMagazineByPublisher("ok").hasNext());
        test2.removeMagazineByTitle("ok");
    }

    /**
     * Test of removeMagazineByTitle method, of class MagazineRegister.
     */
    @Test
    public void testRemoveMagazineByTitle() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(true, test2.getMagazineByTitle("ok").hasNext());
        test2.removeMagazineByTitle("ok");
        assertEquals(false, test2.getMagazineByTitle("ok").hasNext());
    }

    /**
     * Test of removeMagazineByPublisher method, of class MagazineRegister.
     */
    @Test
    public void testRemoveInvalidAndValidMagazineByPublisher() {
        test2.addMagazine("ok", "ok", "ok", 1);
        assertEquals(true, test2.getMagazineByPublisher("ok").hasNext());
        test2.removeMagazineByPublisher("fins ikkje");
        assertEquals(true, test2.getMagazineByPublisher("ok").hasNext());
        test2.removeMagazineByPublisher("ok");
        assertEquals(false, test2.getMagazineByPublisher("ok").hasNext());
    }
}
