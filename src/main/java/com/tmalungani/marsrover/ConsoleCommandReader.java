package com.tmalungani.marsrover;

class ConsoleCommandReader extends CommandReader {

    private static ICommandParser commandParser = CommandParserFactory.parser();

    /**
     * Read the commands to be used to initialise the Mars rover and to be executed
     */
    public CommandReader read() {

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
            ConsoleHelper.prompt("Enter grid size. eg 10 8: ");
            gridSize = commandParser.size(ConsoleHelper.input());

        } catch (IllegalGridSizeException e) {

            ConsoleHelper.error(e.getMessage());
            readGridSize();
        }
    }

    /**
     * Reads the rover starting position from command line as string and parses it to Position.
     * This method will be called recursively until the position is valid.
     */
    private void readStartingPosition() {

        try {
            ConsoleHelper.prompt("Enter starting position. Allowed directions [N W S E] Eg. 1 2 E: ");
            roverPosition = commandParser.position(ConsoleHelper.input());

        } catch (IllegalRoverPositionException | IllegalRoverDirectionException e) {

            ConsoleHelper.error(e.getMessage());
            readStartingPosition();
        }
    }

    /**
     * Reads the rover commands from command line as string and parses it to String.
     * This method will be called recursively until the commands are valid.
     */
    private void readRoverCommands() {

        try {
            ConsoleHelper.prompt("Enter commands to be sent to rover. Allowed commands [LRM]: ");
            roverCommands = commandParser.commands(ConsoleHelper.input());

        } catch (IllegalRoverCommandException e) {

            ConsoleHelper.error(e.getMessage());
            readRoverCommands();
        }
    }
}