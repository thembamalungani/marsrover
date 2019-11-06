package com.tmalungani.marsrover;

/**
 * This is enum is used to encapsulate the logic relating to rover direction.
 * It allows for simple computations of directions with relative on direction.
 * Given a specif direction, you can be able to obtain it's left and right directions.
 */
public enum Direction {

    NORTH("N", "E", "W"),
    EAST("E", "S", "N"),
    SOUTH("S", "W", "E"),
    WEST("W","N", "S");

    private final String value;
    private final String right;
    private final String left;

    /**
     * Initialise the directions and related values in terms of left and right
     *
     * @param String value The value of the current direction
     * @param String right The right of the current direction
     * @param String left  The left of the current direction
     */
    Direction(String value, String right, String left) {

        this.value  = value;
        this.right  = right;
        this.left   = left;
    }

    /**
     * Gets the value of this direction
     *
     * @return
     */
    public String value() {

        return this.value;
    }

    /**
     * Get the right direction of this direction
     *
     * @return Direction
     */
    public Direction right() {

        return directionTo(this.right);
    }

    /**
     * Get the left direction of this direction
     *
     * @return Direction
     */
    public Direction left() {

        return directionTo(this.left);
    }

    /**
     * Gets the direction to the "orientation" for the current direction
     *
     * @param String orientation
     * @return Direction
     */
    private Direction directionTo(String orientation) {

        for (Direction direction : values()) {

            if ( direction.value.equals(orientation) ) {

                return direction;
            }
        }

        return null;
    }
}
