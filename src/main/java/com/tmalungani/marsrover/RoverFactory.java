package com.tmalungani.marsrover;

public class RoverFactory {

    /**
     * Build a rover and place it on a grid with the passed size in the passed position
     *
     * @param Grid.Size size
     * @param Position position
     * @return Rover
     */
    static Rover roverFor(Grid.Size size, Position position) {

        if (!size.contains(position.getCoordinate())) {

            throw new IllegalArgumentException("Invalid rover starting position. Starting position should be within the boundaries if the grid.");
        }

        return new Rover(new Grid(size), position);
    }
}
