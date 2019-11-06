package com.tmalungani.marsrover;

public interface ICommandReader {

    /**
     * Reader the commands and return an instance of CommandReader
     *
     * @return CommandReader
     */
    CommandReader read();
}
