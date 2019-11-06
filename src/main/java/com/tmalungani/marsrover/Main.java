package com.tmalungani.marsrover;

public class Main {

    public static void main(String[] args) {

        try {

            CommandReader reader    = CommandReaderFactory.reader();
            Rover rover             = RoverFactory.roverFor(reader.gridSize, reader.roverPosition);
            String finalPosition    = rover.execute(reader.roverCommands);

            System.out.println("Final Mars Rover Position: " + finalPosition);

        } catch (Exception  e) {

            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
