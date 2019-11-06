package com.tmalungani.marsrover;

public class Main {

    public static void main(String[] args) {

        try {

            ConsoleCommandReader reader = (new ConsoleCommandReader()).read();
            Rover rover                 = RoverFactory.buildFor(reader.size, reader.position);
            String finalPosition        = rover.execute(reader.commands);

            System.out.println("Final Mars Rover Position: " + finalPosition);

        } catch (Exception  e) {

            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
