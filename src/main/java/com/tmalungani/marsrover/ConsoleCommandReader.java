package com.tmalungani.marsrover;

import java.util.Scanner;

class ConsoleCommandReader {

    Grid.Size size;
    Position position;
    String commands;

    private static Scanner input = new Scanner(System.in);
    private static ICommandParser commandParser = new CommandParser();

    /**
     * Read the commands to be used to initialise the Mars rover and to be executed
     */
    ConsoleCommandReader read() {

        readGridSize();
        readStartingPosition();
        readRoverCommands();

        return this;
    }

    private void readGridSize() {

        try {

            System.out.print("Enter grid size. eg 10 8: ");
            size = commandParser.size(input.nextLine());

        } catch (IllegalGridSizeException e) {

            System.out.println("ERROR: " + e.getMessage());

            readGridSize();
        }
    }

    private void readStartingPosition() {

        try {

            System.out.print("Enter starting position. Allowed directions: (N W S E) Eg. 1 2 E: ");
            position = commandParser.position(input.nextLine());

        } catch (IllegalRoverPositionException | IllegalRoverDirectionException e) {

            System.out.println("ERROR: " + e.getMessage());

            readStartingPosition();
        }
    }

    private void readRoverCommands() {

        try {

            System.out.print("Enter commands to be sent to rover: ");
            commands = commandParser.commands(input.nextLine());

        } catch (IllegalRoverCommandException e) {

            System.out.println("ERROR: " + e.getMessage());
        }
    }
}