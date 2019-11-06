package com.tmalungani.marsrover;

public class Position {

    private final Coordinate coordinate;
    private final Direction direction;

    /**
     * Inject the coordinates and direction
     *
     * @param Coordinate coordinate
     * @param Direction direction
     */
    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    /**
     * Get the coordinates
     *
     * @return Coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Get the direction
     *
     * @return Direction
     */
    public Direction getDirection() {
        return direction;
    }
}
