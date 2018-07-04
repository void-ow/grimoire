package mainlogic;

import generation.Generator;
import model.Room;
import utils.messagelog.MessageLog;

public class DecisionLogic {

    public static void handleDecision(String decision) {
        if (decision.equalsIgnoreCase("room")) {
            Room testRoom = Generator.generateRoom();
            MessageLog.addMessage(testRoom.describe(), true);
        }
    }
}
