package com.tmalungani.marsrover;

public interface ICommandParser {
    /**
     * Parses the size of the grid from string to Grid.Size
     *
     * @param String size
     * @return Grid.Size
     * @throws IllegalGridSizeException
     */
    Grid.Size size(String size) throws IllegalGridSizeException;

    /**
     * Parses the commands to be sent to rover
     *
     * @param String commands
     * @return String
     * @throws IllegalRoverCommandException
     */
    String commands(String commands) throws IllegalRoverCommandException;

    /**
     * Parses the position of rover from string to Position
     *
     * @param String startingPosition
     * @return
     * @throws IllegalRoverPositionException
     * @throws IllegalRoverDirectionException
     */
    Position position(String startingPosition) throws IllegalRoverPositionException, IllegalRoverDirectionException;
}
