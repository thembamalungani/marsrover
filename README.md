# MarsRover

## Usage
This is a java maven project so you will need at least maven version 2 and at least java 8 installed. Follow instructions [here](https://maven.apache.org/install.html) to install maven
and [here](https://www.java.com/en/download/) to install java 8

Once maven is installed, you can run the commands below in the root directory of the projects:

```$ mvn compile```<br>
```$ mvn exec:java -Dexec.mainClass=com.tmalungani.marsrover.Main```

### Inputs
All inputs to the program are space separated. Example 12 4, these will be treated as 2 parameters.

### Example run 

```$ mvn compile```<br>
```$ mvn exec:java -Dexec.mainClass=com.tmalungani.marsrover.Main```<br><br>
```Enter grid size. eg 10 8:```10 8<br>
```Enter starting position. Allowed directions [N W S E] Eg. 1 2 E:``` 1 2 E<br/>
```Enter commands to be sent to rover. Allowed commands [LRM]:``` MMLMRMMRRMML<br/>
```Final Mars Rover Position: 3 3 S```

## Design
The entry level to the programs is via the class `com.tmalungani.marsrover.Main`. From there the command reader factory is used to obtain an instance of `CommandReader`.
The idea here is you can have different types of commands readers based on the source of you inputs.
As an example, if in the future commands are sent to MarsRover via a text file, you could update the `com.tmalungani.marsrover.CommandReaderFactory`
to return an instance of a reader which can read commands from a file.
The responsibility of the CommandReader is to parse commands from a source into data structures known by the `com.tmalungani.marsrover.Rover`.

Once the commands are parsed, a instance of `com.tmalungani.marsrover.Rover` is created via the `com.tmalungani.marsrover.RoverFactory`. This ensure that other necessary
checks are performed to ensure to valid rover is created with correct parameters. Once the rover is
created, commands can be passed to it and executed.

A rover is place on a grid and at any specific time has a position (which is the coordinates in the grid and direction). The rover can be moved by executing commands
which are passed to the grid which then determines the next position of the rover relative to the current position.

If instructions are given to move the rover beyond the boundaries of the grid, the rover will be moved to the last "possible" position. Error handling has been built in to avoid
having invalid input. Invalid input could be bad data or maybe rover starting position which is outside of the grid.
The program has been design in a way to perpetually ask the user for input until is is valid before moving on to ask for the next input.

## Testing
To ensure the correctness of the code, functional tests were added to make sure that at any point in time, the program can be validated that it is still functioning as intended and meets the functional requirements.
The tests validate that the rover can: move up, down, left, and right, and can rotate left and right.
The test are written using JUnit 4. Withing the root of the project, you can just run the command below:

```$ mvn test```<br>
