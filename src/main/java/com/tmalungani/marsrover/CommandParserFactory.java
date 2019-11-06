package com.tmalungani.marsrover;

public class CommandParserFactory {
    /**
     * Returns an instance of ICommandParser
     * @return ICommandParser
     */
    public static ICommandParser parser() {

        return new CommandParser();
    }
}
