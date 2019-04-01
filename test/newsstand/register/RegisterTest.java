package newsstand.register;

import java.util.Iterator;
import newsstand.publication.Movie;
import newsstand.publication.Newspaper;
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
public class RegisterTest {

    publicationRegister test;
    Movie publication;

    public RegisterTest() {
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
        publication = new Movie("hei", "geir", "nei", "stein", "20/07/2015", 22, 123);
        test.addPublication(publication);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addPublication method, of class Register. Tries to add invalid
     * publication.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddPublication() {
        test.addPublication(new Movie("hei", null, "lamb", "saud", "20/07/2015", -23, 12));

    }

    /**
     * Test of addPublication method, of class Register. Tries to add valid
     * Publication.
     */
    @Test
    public void testAddPublication() {
        Movie duplicate = new Movie("hei", "geir", "nei", "stein", "20/07/2015", 22, 123);
        assertTrue(test.addPublication(duplicate));
    }

    /**
     * Test of getIterator method, of class Register. Checks if iterator that is
     * return contains the object that has been added.
     */
    @Test
    public void testGetIterator() {
        test.addPublication(publication);
        assertEquals(publication, test.getIterator().next());
    }

    /**
     * Test of getPublicationByIndex method, of class Register. Checks if the
     * publications title is the same as in register found by index.
     */
    @Test
    public void testGetPublicationByIndex() {
        Movie valid = new Movie("hei", "geit", "lamb", "saud", "20/07/2015", 23, 12);
        test.addPublication(valid);
        assertEquals(publication.getTitle(), test.getPublicationByIndex(0).getTitle());
        assertNotEquals(publication.getPublisher(), test.getPublicationByIndex(1).getPublisher());
    }

    /**
     * Test of getTypePublicationIterator method, of class Register. Check if
     * the iterator only contains Movies.
     */
    @Test
    public void testGetTypePublicationIterator() {
        Movie valid = new Movie("hei", "geit", "lamb", "saud", "20/07/2015", 23, 12);
        test.addPublication(valid);
        Newspaper Newspapervalid = new Newspaper("hei", "geit", "lamb", "saud", 23, 12);
        test.addPublication(Newspapervalid);
        Iterator<Publication> testItr = test.getTypePublicationIterator(Movie.class);
        assertTrue(testItr.next() instanceof Movie);
        assertEquals(valid.getPublisher(), testItr.next().getPublisher());
        assertFalse(testItr.hasNext());
    }

    /**
     * Test of removePublication method, of class Register. Tries to removes
     * publication. But it has many in stock so it only takes one out from
     * stock. Also removes all from stock and tries to remove. Then checks if it
     * has something i register.
     */
    @Test
    public void testRemovePublication() {
        test.removePublication(publication);
        assertEquals(122, test.getDuplicatePublication(publication).getQuantity());
        publication.addOrRemoveStock(-122);
        test.removePublication(publication);
        assertFalse(test.getIterator().hasNext());
    }

    /**
     * Test of getDuplicatePublication method, of class Register. Checks if it
     * find duplicate publication in register.
     */
    @Test
    public void testGetDuplicatePublication() {
        assertEquals(publication, test.getDuplicatePublication(publication));
    }
}
