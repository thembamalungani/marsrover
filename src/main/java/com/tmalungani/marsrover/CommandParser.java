package com.tmalungani.marsrover;

public class CommandParser implements ICommandParser {

    /**
     * Parses the starting position of the rover
     *
     * @param String startingPosition
     * @return Position
     */
    @Override
    public Position position(String position) throws IllegalRoverPositionException, IllegalRoverDirectionException {

        String[] parameters  = position.split(" ");

        try {

            String sDirection   = parameters[2];
            int xCoordinate     = Integer.parseInt(parameters[0]);
            int yCoordinate     = Integer.parseInt(parameters[1]);

            Coordinate coordinate   = new Coordinate(xCoordinate, yCoordinate);
            Direction direction     = getDirection(sDirection);

            return new Position(coordinate, direction);

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {

            throw new IllegalRoverPositionException("Invalid rover position. Please pass starting position like: 1 2 E");
        }
    }

    /**
     * Parse the size of the grid
     *
     * @param String size
     * @return Grid.Size
     */
    @Override
    public Grid.Size size(String size) throws IllegalGridSizeException {

        String[] parameters = size.split(" ");

        try {

            int maxWidth    = Integer.parseInt(parameters[0]);
            int maxHeight   = Integer.parseInt(parameters[1]);

            return new Grid.Size(maxWidth, maxHeight);

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {

            throw new IllegalGridSizeException("Invalid grid size. Grid size should be 2 integers separated by a space");
        }
    }

    /**
     * Ensures the passed commands are valida
     *
     * @param commands
     * @return
     * @throws IllegalRoverCommandException
     */
    @Override
    public String commands(String commands) throws IllegalRoverCommandException {

        String allowedCommands = "LRM";

        for (char command: commands.toCharArray()) {

            if (!allowedCommands.contains(String.valueOf(command))) {

                throw new IllegalRoverCommandException("Invalid rover command: " + String.valueOf(command));
            }
        }

        return commands;
    }

    /**
     * Get the direction of string
     *
     * @param String direction
     * @return Direction
     */
    private Direction getDirection(String direction) throws IllegalRoverDirectionException {

        if (direction.equals("N")) return Direction.NORTH;
        if (direction.equals("W")) return Direction.WEST;
        if (direction.equals("S")) return Direction.SOUTH;
        if (direction.equals("E")) return Direction.EAST;

        throw new IllegalRoverDirectionException("Invalid rover direction: " + direction);
    }
}
