package com.tmalungani.marsrover;

public class Main {

    public static void main(String[] args) {

        try {

            CommandReader reader    = CommandReaderFactory.reader().read();
            Rover rover             = RoverFactory.roverFor(reader.gridSize, reader.roverPosition);
            String finalPosition    = rover.execute(reader.roverCommands);

            ConsoleHelper.feedback("Final Mars Rover Position: " + finalPosition);

        } catch (IllegalArgumentException  e) {

            ConsoleHelper.error("ERROR: " + e.getMessage());
        }
    }
}
