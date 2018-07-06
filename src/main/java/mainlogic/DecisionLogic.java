package mainlogic;

import generation.Generator;
import model.Thing;
import utils.messagelog.MessageLog;

import java.util.List;

public class DecisionLogic {

    public static void handleDecision(String decision) {
        if (decision.equalsIgnoreCase("room")) {
            Thing room = Generator.generateThing("room");
            ThingLoop.loop(room);
        }
    }

    public static void handleDecisionForRoom(String decision, Thing room) {
        if (decision.equalsIgnoreCase("wall")) {
            List<Thing> children = room.getChildren();
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getName().equalsIgnoreCase("wall")) {
                    MessageLog.addMessage(children.get(i).describe(), true);
                }
            }
        }
    }
}
