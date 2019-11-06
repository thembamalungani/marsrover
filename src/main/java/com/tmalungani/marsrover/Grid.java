package com.tmalungani.marsrover;

/**
 * Encapsulate the grid operations
 */
public class Grid {

    /**
     * @var Size size
     */
    private final Size size;

    /**
     * Inject the grid size
     * @param Size size
     */
    public Grid(Size size) {
        this.size = size;
    }

    /**
     * Moves the rover from the coordinate passed in the direction passed
     *
     * @param Position position
     * @return Position
     */
    public Position move(Position position) {

        int y = position.getCoordinate().getY();
        int x = position.getCoordinate().getX();

        switch (position.getDirection()){
            case NORTH:     y = moveNorth(y);   break;
            case EAST:      x = moveEast(x);    break;
            case WEST:      x = moveWest(x);    break;
            case SOUTH:     y = moveSouth(y);    break;
        }

        return new Position(new Coordinate(x, y), position.getDirection());
    }

    /**
     * Moves the rover to south direction
     *
     * @param int y
     * @return int
     */
    private int moveSouth(int y) {
        return (y > 0) ? y - 1 : y;
    }

    /**
     * Moves the rover in west direction
     *
     * @param int x
     * @return int
     */
    private int moveWest(int x) {
        return (x > 0) ? x - 1 : x;
    }

    /**
     * Moves the rover in east direction
     *
     * @param int x
     * @return int
     */
    private int moveEast(int x) {
        return (x < size.maxWidth - 1) ? x + 1: x;
    }

    /**
     * Moves the rover in north direction
     *
     * @param int y
     * @return int
     */
    private int moveNorth(int y) {
        return (y < size.maxHeight - 1) ? y + 1: y;
    }

    /**
     * Encapsulates the size of a grid
     */
    public static class Size {

        private final int maxWidth;
        private final int maxHeight;

        /**
         * Inject the max width and height
         * @param int maxWidth
         * @param int  maxHeight
         */
        public Size(int maxWidth, int maxHeight) {
            this.maxWidth   = maxWidth;
            this.maxHeight  = maxHeight;
        }

        /**
         * Gets the max width
         *
         * @return int
         */
        public int getMaxWidth() {
            return maxWidth;
        }

        /**
         * Gets the max height
         * @return int
         */
        public int getMaxHeight() {
            return maxHeight;
        }

        /**
         * Asserts if the passed coordinates are within the boundaries of the grid size
         *
         * @param Coordinate coordinate
         * @return Boolean
         */
        Boolean contains(Coordinate coordinate) {
            return maxHeight >= coordinate.getY() && maxWidth >= coordinate.getX();
        }
    }
}
