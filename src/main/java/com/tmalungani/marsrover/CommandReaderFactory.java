package com.tmalungani.marsrover;

public class CommandReaderFactory {
    /**
     * Returns a instance of ICommandReader
     *
     * @return ICommandReader
     */
    public static CommandReader reader() {
        return new ConsoleCommandReader();
    }
}
