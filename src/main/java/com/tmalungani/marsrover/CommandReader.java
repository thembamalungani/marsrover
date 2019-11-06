package com.tmalungani.marsrover;

abstract class CommandReader {
    Grid.Size gridSize;
    String roverCommands;
    Position roverPosition;

    /**
     * Reader the commands and return an instance of CommandReader
     *
     * @return CommandReader
     */
    abstract CommandReader read();
}
