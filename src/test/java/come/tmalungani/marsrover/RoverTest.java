package come.tmalungani.marsrover;

import com.tmalungani.marsrover.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    /**
     * @var Rover rover
     */
    private Rover rover;

    @Before
    public void init() {
        rover = new Rover(new Grid(new Grid.Size(10, 10)), new Position(new Coordinate(0,0), Direction.NORTH));
    }

    @Test
    @Parameters({
        "R, 0 0 E",
        "RR, 0 0 S",
        "RRR, 0 0 W",
        "RRRR, 0 0 N"
    })
    public void shouldRotateRight(String commands, String position) {
        //Assumes the rover is starting a position 0 0 N
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
        "L, 0 0 W",
        "LL, 0 0 S",
        "LLL, 0 0 E",
        "LLLL, 0 0 N"
    })
    public void shouldRotateLeft(String commands, String position) {
        //Assumes the rover is starting a position 0 0 N
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
        "M, 0 1 N",
        "MMM, 0 3 N"
    })
    public void shouldMoveNorth(String commands, String position) {
        //Assumes the rover is starting a position 0 0 N
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
        "RM, 1 0 E",
        "RMMMM, 4 0 E"
    })
    public void shouldMoveEast(String commands, String position) {
        //Assumes the rover is starting a position 0 0 N
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
        "RMMMLLMM, 1 0 W",
        "LMMMM, 0 0 W"
    })
    public void shouldMoveWest(String commands, String position) {
        //Assumes the rover is starting a position 0 0 N
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
        "MMMLLMM, 0 1 S",
        "RMMMR, 3 0 S"
    })
    public void shouldMoveSouth(String commands, String position) {
        //Assumes the rover is starting a position 0 0 N
        assertThat(rover.execute(commands), is(position));
    }
}
