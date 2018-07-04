import generation.Generator;
import init.DataInit;
import model.Room;
import utils.messagelog.MessageLog;

public class Application {

    public static void main(String[] args) {

        DataInit.initialize();

        Room testRoom = Generator.generateRoom();
        MessageLog.addMessage(testRoom.describe(), true);

    }
}
