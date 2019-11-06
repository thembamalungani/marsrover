package com.tmalungani.marsrover;

import java.util.Scanner;

class ConsoleCommandReader {

    Grid.Size size;
    String commands;
    Position position;

    private static Scanner input = new Scanner(System.in);
    private static ICommandParser commandParser = CommandParserFactory.parser();

    /**
     * Read the commands to be used to initialise the Mars rover and to be executed
     */
    ConsoleCommandReader read() {

        readGridSize();
        readStartingPosition();
        readRoverCommands();

        return this;
    }

    /**
     * Reads the grid size from command line as string and parses it to Grid.size.
     * This method will be called recursively until the size is valid.
     */
    private void readGridSize() {

        try {
            prompt("Enter grid size. eg 10 8: ");
            size = commandParser.size(readInput());

        } catch (IllegalGridSizeException e) {

            error(e.getMessage());
            readGridSize();
        }
    }

    /**
     * Reads the rover starting position from command line as string and parses it to Position.
     * This method will be called recursively until the position is valid.
     */
    private void readStartingPosition() {

        try {
            prompt("Enter starting position. Allowed directions [N W S E] Eg. 1 2 E: ");
            position = commandParser.position(readInput());

        } catch (IllegalRoverPositionException | IllegalRoverDirectionException e) {

            error(e.getMessage());
            readStartingPosition();
        }
    }

    /**
     * Reads the rover commands from command line as string and parses it to String.
     * This method will be called recursively until the commands are valid.
     */
    private void readRoverCommands() {

        try {
            prompt("Enter commands to be sent to rover. Allowed commands [LRM]: ");
            commands = commandParser.commands(readInput());

        } catch (IllegalRoverCommandException e) {

            error(e.getMessage());
            readRoverCommands();
        }
    }

    /**
     * Display prompt on screen
     *
     * @param String message
     */
    private void prompt(String message) {
        System.out.print(message);
    }

    /**
     * Print the error
     *
     * @param String error
     */
    private void error(String error) {
        System.err.println("ERROR: " + error);
    }

    /**
     * Reads the input from console
     *
     * @return String
     */
    private String readInput() {
        return input.nextLine();
    }
}