package generation;

import init.featureBanks.RoomFeatureBanks;
import model.Room;
import org.junit.Before;
import org.junit.Test;

import static generation.Generator.generateRoom;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Before
    public void setUp() throws Exception {
        RoomFeatureBanks.initialize();
    }

    @Test
    public void generateRoomTest() {
        //given
        //when
        Room generatedRoom = generateRoom();
        //then
        assertThat(generatedRoom.getFeatureList(), is(not(nullValue())));
        assertThat(generatedRoom.getFeatureList(), is(not(empty())));
    }
}