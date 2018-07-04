package mainlogic;

import generation.Generator;
import mainlogic.check.AbilityCheck;
import model.Room;
import utils.messagelog.MessageLog;

public class DecisionLogic {

    public static void handleDecision(String decision) {
        if (decision.equalsIgnoreCase("room")) {
            Room room = Generator.generateRoom();
            RoomLoop.loop(room);
        }
    }

    public static void handleDecisionForRoom(String decision, Room room) {
        if (decision.equalsIgnoreCase("check")) {
            AbilityCheck.checkPerception(room);
        }
    }
}
