package generation;

import init.Database;
import model.blocks.Thing;
import org.junit.Before;
import org.junit.Test;

import static generation.Generator.generateThing;
import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Before
    public void setUp() throws Exception {
        Database.initialize();
    }

    @Test
    public void generateRoomTest() {
        //given
        //when
        Thing generatedRoom = generateThing("room");
        //then
        assertThat(generatedRoom.getFeatures(), is(not(nullValue())));
        assertThat(generatedRoom.getFeatures(), is(not(empty())));
    }
}