package newsstand.register;

import java.util.Iterator;
import newsstand.publication.Book;
import newsstand.publication.Magazine;
import newsstand.publication.Movie;
import newsstand.publication.Publication;
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
public class publicationRegisterTest {

    publicationRegister test;

    public publicationRegisterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new publicationRegister();
        test.addPublication(new Magazine("hei1", "storm11", "fisk", 10, 20, 30));
        test.addPublication(new Magazine("hei2", "storm12", "fisk", 10, 20, 30));
        test.addPublication(new Magazine("hei3", "storm3", "fisk", 10, 20, 30));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPublicationByTitle method, of class publicationRegister.
     * Search for title and gets an iterator and checks that is has the expected
     * amount of element.
     */
    @Test
    public void testGetPublicationByTitle() {
        Iterator<Publication> itr = test.getPublicationByTitle("hei");
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertFalse(itr.hasNext());
    }

    /**
     * Test of getPublicationsByPublisher method, of class publicationRegister.
     * Search for publisher and gets an iterator and checks that is has the
     * expected amount of element.
     */
    @Test
    public void testGetPublicationsByPublisher() {
        Iterator<Publication> itr = test.getPublicationsByPublisher("storm1");
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertFalse(itr.hasNext());
    }

    /**
     * Test of getPublicationInOrder method, of class publicationRegister.
     */
    @Test
    public void testGetPublicationInOrder() {
        test.addPublication(new Book("bygg", "stige", "alf",
                "kato", 10, 230, 30));
        test.addPublication(new Magazine("hei4", "storm4", "fisk",
                10, 20, 30));
        Iterator<Publication> itr = test.getPublicationInOrder();
        assertTrue(itr.next() instanceof Magazine);
        assertFalse(itr.next() instanceof Book);
        assertTrue(itr.next() instanceof Magazine);
        assertFalse(itr.next() instanceof Movie);
        assertTrue(itr.next() instanceof Book);
    }
}
