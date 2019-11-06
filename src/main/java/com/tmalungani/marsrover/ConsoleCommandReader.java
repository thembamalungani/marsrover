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

            System.out.print("Enter grid size. eg 10 8: ");
            size = commandParser.size(input.nextLine());

        } catch (IllegalGridSizeException e) {

            System.out.println("ERROR: " + e.getMessage());

            readGridSize();
        }
    }

    /**
     * Reads the rover starting position from command line as string and parses it to Position.
     * This method will be called recursively until the position is valid.
     */
    private void readStartingPosition() {

        try {

            System.out.print("Enter starting position. Allowed directions: (N W S E) Eg. 1 2 E: ");
            position = commandParser.position(input.nextLine());

        } catch (IllegalRoverPositionException | IllegalRoverDirectionException e) {

            System.out.println("ERROR: " + e.getMessage());

            readStartingPosition();
        }
    }

    /**
     * Reads the rover commands from command line as string and parses it to String.
     * This method will be called recursively until the commands are valid.
     */
    private void readRoverCommands() {

        try {

            System.out.print("Enter commands to be sent to rover: ");
            commands = commandParser.commands(input.nextLine());

        } catch (IllegalRoverCommandException e) {

            System.out.println("ERROR: " + e.getMessage());
        }
    }
}