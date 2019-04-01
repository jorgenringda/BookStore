package newsstand.input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Class that contains method that get input from user
 *
 * @author UltraReidar
 */
public class GetInputs {

    /**
     * Method that returns input from user as a string
     *
     * @return input returns input typed by user as a string
     */
    public String getStringInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        System.out.println();

        return input;
    }

    /**
     * Method that returns input from user as a integer
     *
     * @return input returns input typed by user as a integer
     */
    public int getIntInput() {
        Scanner reader = new Scanner(System.in);
        int input;
        try {
            input = reader.nextInt();
            if (input < 0) {
                System.out.println("\nPlease enter a valid number\n");
                input = getIntInput();
            }
        } catch (InputMismatchException error) {
            System.out.println("\nPlease enter a valid number\n");
            input = getIntInput();
        }
        return input;
    }

    /**
     * Method that returns input from user as a integer but input must be within
     * the min - max range
     *
     * @param min is the minimum value the input can have
     * @param max is the maximum value the input can have
     * @return input returns input typed by user as a integer
     */
    public int getIntInputMinMax(int min, int max) {
        Scanner reader = new Scanner(System.in);
        int input;
        try {
            input = reader.nextInt();
            if (input < 0 || input < min || input > max) {
                System.out.println("\nPlease enter a valid number\n");
                input = getIntInputMinMax(min, max);
            }
        } catch (InputMismatchException error) {
            System.out.println("\nPlease enter a valid number\n");
            input = getIntInputMinMax(min, max);
        }
        return input;
    }

    /**
     * Method that get input from user as a date and returns input from user as
     * a string
     *
     * @return input returns input typed by user as a string
     */
    public String getDateInput() {
        LocalDate validDate = null;
        System.out.println("Enter a date in format : dd/mm/yyyy   "
                + "example : 20/08/2010");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        try {
            dateFormat.parse(input);
        } catch (ParseException pe) {
            System.out.println("\nPlease enter a valid date format\n");
            input = getDateInput();
        }
        String[] valid = input.split("/");
        String day = valid[0];
        String month = valid[1];
        String year = valid[2];
        try {
            validDate = LocalDate.of(Integer.parseInt(year),
                    Integer.parseInt(month), Integer.parseInt(day));
        } catch (DateTimeException dte) {
            System.out.println("\nPlease enter a valid date\n");
            input = getDateInput();
        }
        return input;
    }
}
