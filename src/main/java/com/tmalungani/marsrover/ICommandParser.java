package com.tmalungani.marsrover;

public interface ICommandParser {

    Position position(String startingPosition) throws IllegalRoverPositionException, IllegalRoverDirectionException;
    Grid.Size size(String size) throws IllegalGridSizeException;
    String commands(String commands) throws IllegalRoverCommandException;
}
