package newsstand.Menu;

import java.io.IOException;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Iterator;
import newsstand.input.GetInputs;
import newsstand.publication.Book;
import newsstand.publication.Publication;
import newsstand.publication.Magazine;
import newsstand.publication.Movie;
import newsstand.publication.Newspaper;
import newsstand.register.publicationRegister;
import newsstand.view.BookView;
import newsstand.view.MagazineView;
import newsstand.view.MovieView;
import newsstand.view.NewspaperView;

/**
 * A super class. Contains common methods for all sub-classes.
 * <ul>
 * <li> Prints out menu </li>
 * <li> Prints out all Publication by Iterator </li>
 * <li> Get details of a Publication as a StringBuilder </li>
 * <li> Check if user type the correct code </li>
 * <li> Prints out Error messages </li>
 * <li> Get clock as a StringBuilder </li>
 * </ul>
 *
 * @author Ultrareidar
 * @version V1.0
 */
public abstract class Menu {

    /**
     * Register that contains all Publication in store.
     */
    publicationRegister publication;
    NewspaperView newspaper;
    BookView book;
    MagazineView magazine;
    MovieView movie;
    /**
     * Class that have method to get valid inputs.
     */
    GetInputs validInput;
    /**
     * String that contains the password the user need to type to get access to
     * the program.
     */
    String password;

    /**
     * defining variables to use in switch-case for print out error message.
     */
    protected enum ErrorMessage {
        noTitle, emptyList, noPublication, noPublisher,
        notRemovedTitle, publicationNotAdded,
    }

    /**
     * Constructor. Creates a Menu.
     */
    public Menu() {
        publication = new publicationRegister();
        newspaper = new NewspaperView();
        book = new BookView();
        magazine = new MagazineView();
        movie = new MovieView();
        validInput = new GetInputs();
        password = "9999";

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     * @throws InputMismatchException if user enters an invalid number/menu
     * choice
     */
    public int showMenu(String[] menu) {
        System.out.println("\n**** Application v2.1 ****\n");
        int menuNumber = 1;
        for (String menuItem : menu) {
            System.out.println(menuNumber + ". " + menuItem);
            menuNumber++;
        }
        int maxMenuItemNumber = menu.length;
        System.out.println("\nPlease choose menu item (1-" + maxMenuItemNumber + "\n");
        int menuSelection = validInput.getIntInput();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    /**
     * Lists all the products/publication in the register.
     *
     * @param allPublication is an Iterator of all the Publication that is going
     * to be printed out
     * @return a Boolean if there is nothing to print out or not
     */
    protected boolean listAllProductsByIterator(Iterator<Publication> allPublication) {
        boolean hasPublicationInList = false;
        int number = 1;
        if (allPublication.hasNext()) {
            while (allPublication.hasNext()) {
                System.out.println("\n" + number + "  |  " + getDetails(allPublication.next()));
                number++;
            }
            System.out.println(clock());
            hasPublicationInList = true;
        } else {

            hasPublicationInList = false;
        }
        return hasPublicationInList;
    }

    /**
     * Builds a string which contains all info about the Publication we set.
     *
     * @param publication Publication that we want to get information about
     * @return all details about the Publication
     */
    protected StringBuilder getDetails(Publication publication) {
        StringBuilder details = new StringBuilder();
        if (publication instanceof Book) {
            details.append(book.getDetailsOfPublication((Book) publication));
        }
        if (publication instanceof Magazine) {
            details.append(magazine.getDetailsOfPublication((Magazine) publication));
        }
        if (publication instanceof Newspaper) {
            details.append(newspaper.getDetailsOfPublication((Newspaper) publication));
        }
        if (publication instanceof Movie) {
            details.append(movie.getDetailsOfPublication((Movie) publication));
        }
        details.append("\n");
        return details;
    }

    /**
     * Prints out an error message set by the parameter error.
     *
     * @param error contains an enum used to print out the correct error message
     */
    protected void printError(ErrorMessage error) {
        StringBuilder errorString = new StringBuilder();
        errorString.append("\nERROR: ");
        switch (error) {
            case noTitle:
                errorString.append("Don't have a title to use");
                break;
            case emptyList:
                errorString.append("No publication to list");
                break;
            case noPublication:
                errorString.append("Didnt find the publication you searched for");
                break;
            case noPublisher:
                errorString.append("Don't have a publisher to use");
                break;
            case notRemovedTitle:
                errorString.append("Publication is not removed, " + "publication title does not exsist");
                break;
            case publicationNotAdded:
                errorString.append("Publication is not added, " + "input is not correct\n");
                break;
        }
        System.out.println(errorString);
    }

    /**
     * Method that gets an input from user that have to be equal the password to
     * get access to the program.
     *
     * @return true or false if the correct code is typed
     */
    public boolean code() {
        boolean code;
        System.out.println("To enter this program, "
                + "please type the master code");

        if (validInput.getStringInput().equals(password)) {
            System.out.println("\nCode was correct! "
                    + "\nYou will now enter the program, enjoy");
            code = true;
        } else {
            System.out.println("Code was not correct \nTry again\n");
            code = code();
        }
        return code;
    }

    /**
     * Reads real time clock, returns is a string in minutes and hours.
     *
     * @return the real time clock as a string
     */
    private StringBuilder clock() {
        StringBuilder clock = new StringBuilder();
        LocalTime time = LocalTime.now();
        clock.append("\nTime: ");
        clock.append((time.getHour() > 9)
                ? ("" + time.getHour()) : ("0" + time.getHour()));
        clock.append(" : ");
        clock.append((time.getMinute() > 9)
                ? ("" + time.getMinute()) : ("0" + time.getMinute()));
        return clock;
    }

    /**
     * Method to stop the application until enter is pressed. this is for not
     * displaying the menu list, before the user have read the error message or
     * other messages.
     */
    protected void typeEnterToContinue() {
        System.out.println();
        System.out.println("type enter to contine ");
        try {
            System.in.read();
        } catch (IOException error) {
            System.out.println("No key enter");
        }
    }
}
