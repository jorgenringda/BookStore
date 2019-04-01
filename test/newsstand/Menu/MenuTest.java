package newsstand.Menu;

import newsstand.register.publicationRegister;
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
public class MenuTest {

    Menu menu;

    public MenuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Create an instance of shopUI.
     */
    @Before
    public void setUp() {
        menu = new ShopUI();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of listAllProductsByIterator method, of class Menu.
     */
    @Test
    public void testListAllProductsByIterator() {
        publicationRegister register = new publicationRegister();
        boolean allPublication = menu.listAllProductsByIterator(register.getPublicationInOrder());
        assertFalse(allPublication);
    }

    public class MenuImpl extends Menu {
    }

}
