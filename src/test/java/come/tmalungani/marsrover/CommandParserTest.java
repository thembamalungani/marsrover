package come.tmalungani.marsrover;

import com.tmalungani.marsrover.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CommandParserTest {

    private CommandParser parser;

    @Before
    public void init() {

        parser = new CommandParser();
    }

    @Parameters({
        "1 2 E"
    })
    public void shouldReturnPositionIfValid(String position) throws IllegalRoverPositionException, IllegalRoverDirectionException {

        Position position1 = parser.position(position);
    }

    @Parameters({
        "10 8"
    })
    public void shouldReturnSizeIfValid(String size) throws IllegalGridSizeException {

        Grid.Size size1 = parser.size(size);
    }

    @Parameters({
        "MMMMMLMM"
    })
    public void shouldReturnCommandsIfValid(String commands) throws IllegalRoverCommandException {

        String commands1 = parser.commands(commands);
    }

    @Test(expected = IllegalRoverDirectionException.class)
    @Parameters({
        "1 2 M"
    })
    public void shouldThrowAnExceptionIfInvalidPosition(String position) throws IllegalRoverPositionException, IllegalRoverDirectionException {

        parser.position(position);
    }

    @Test(expected = IllegalGridSizeException.class)
    @Parameters({
        "1 J"
    })
    public void shouldThrowAnExceptionIfInvalidGridSize(String size) throws IllegalGridSizeException {

        parser.size(size);
    }

    @Test(expected = IllegalRoverCommandException.class)
    @Parameters({
        "MMMMO"
    })
    public void shouldThrowAnExceptionIfInvalidCommand(String commands) throws IllegalRoverCommandException {

        parser.commands(commands);
    }
}
