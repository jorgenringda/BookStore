/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
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
     * Method that returns input from user as a integer
     *
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
     * Method that returns input from user as a string
     *
     * @return input returns input typed by user as a string
     */
    public String getDateInput() {
        System.out.println("Enter a date in format : dd-mm-yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        try {
            dateFormat.parse(input);
        } catch (ParseException e) {
            System.out.println("\nPlease enter a valid date\n");
            input = getDateInput();
        }
        System.out.println();

        return input;
    }
}
