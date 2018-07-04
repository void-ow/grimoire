import generation.Generator;
import init.DataInit;
import mainlogic.MainLoop;
import model.Room;
import text.SystemText;
import utils.messagelog.MessageLog;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        DataInit.initialize();
        MainLoop.loop();
    }
}
