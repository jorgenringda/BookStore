package newsstand.duplicate;

import java.util.ArrayList;
import newsstand.publication.Book;
import newsstand.publication.Magazine;
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
public class DuplicateTest {

    Duplicate duplicate;
    ArrayList<Publication> test;

    public DuplicateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new ArrayList<>();
        duplicate = new Duplicate();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkDuplicateBook method, of class Duplicate. Checks if it can
     * find a duplicate.
     */
    @Test
    public void testCheckDuplicateBook() {
        Book testBook = new Book("stein", "åge", "ola", "stig", 10, 20, 30);
        test.add(testBook);
        assertEquals("stein", duplicate.checkDuplicateBook(testBook, test.iterator()).getTitle());
    }

    /**
     * Test of checkDuplicateMagazine method, of class Duplicate. Checks if it
     * can find a duplicate.
     */
    @Test
    public void testCheckDuplicateMagazine() {
        Magazine testMagazine = new Magazine("stein", "åge", "ola",
                10, 20, 30);
        test.add(testMagazine);
        assertEquals("stein", duplicate.checkDuplicateMagazine(testMagazine,
                test.iterator()).getTitle());
    }

    /**
     * Test of checkDuplicateNewspaper method, of class Duplicate. Checks if it
     * can find a duplicate.
     */
    @Test
    public void testCheckDuplicateNewspaper() {
        Newspaper testNewspaper = new Newspaper("stein", "åge", "ola",
                "olav", 20, 30);
        test.add(testNewspaper);
        assertEquals("stein", duplicate.checkDuplicateNewspaper(testNewspaper,
                test.iterator()).getTitle());
    }

    /**
     * Test of checkDuplicateMovie method, of class Duplicate. Checks if it can
     * find a duplicate.
     */
    @Test
    public void testCheckDuplicateMovie() {
        Movie testMovie = new Movie("stein", "åge", "ola", "Koma", "hest", 20, 30);
        test.add(testMovie);
        assertEquals("stein", duplicate.checkDuplicateMovie(testMovie, test.iterator()).getTitle());
    }

}
