package com.tmalungani.marsrover;

import java.util.Scanner;

public class ConsoleHelper
{
    private static Scanner input = new Scanner(System.in);

    /**
     * Display prompt on screen
     *
     * @param String message
     */
    static void prompt(String message) {
        System.out.print(message);
    }

    /**
     * Print the error
     *
     * @param String error
     */
    static void error(String error) {
        System.err.println("ERROR: " + error);
    }

    /**
     * Display the message as feedback onto the console
     *
     * @param String message
     */
    static void feedback(String message) {
        System.out.println(message);
    }

    /**
     * Reads the input from console
     *
     * @return String
     */
    static String input() {
        return input.nextLine();
    }
}
