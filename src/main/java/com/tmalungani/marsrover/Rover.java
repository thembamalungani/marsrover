package com.tmalungani.marsrover;

/**
 * This is the class used to encapsulate Mars rover properties and behaviours.
 * This class is used as a blueprint of a Mars rover.
 */
public class Rover {

    private Grid grid;
    private Position position;

    /**
     * Initialises the rover with a grid where is is to be place, the position on the grid
     * and the initial direction
     *
     * @param Grid grid
     * @param Position position
     */
    public Rover(Grid grid, Position position) {

        this.grid       = grid;
        this.position   = position;
    }

    /**
     * Executes commands send to mars rover and return the results.
     *
     * @param String commands
     * @return String
     */
    public String execute(String commands) {

        for (char command: commands.toCharArray()) {

            executeCommand(command);
        }

        return getPosition();
    }

    /**
     * Return a string formatted position of the rover
     *
     * @return String
     */
    private String getPosition() {

        return String.format("%s %s %s",
            position.getCoordinate().getX(),
            position.getCoordinate().getY(),
            position.getDirection().value()
        );
    }

    /**
     * Execute the command and updates the rover direction. This method has side effects on the direction
     * of the rover.
     *
     * @param String command
     */
    private void executeCommand(char command) {

        switch (command){

            case 'R': position  = new Position(position.getCoordinate(), position.getDirection().right()); break;
            case 'L': position  = new Position(position.getCoordinate(), position.getDirection().left()); break;
            case 'M': position  = grid.move(position);
        }
    }
}
