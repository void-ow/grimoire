package mainlogic;

import generation.Generator;
import model.blocks.Thing;
import text.SystemText;
import utils.messagelog.MessageLog;

import static text.SystemText.Commands.CHECK;
import static text.SystemText.Commands.LOOK;

public class DecisionLogic {

    public static void handleDecision(String decision) {
        if (decision.equalsIgnoreCase("room")) {
            Thing room = Generator.generateThing("room");
            ThingLoop.loop(room);
        }
    }

    public static void handleDecisionForThing(String decision, Thing thing) {

        String[] command = decision.split("\\ ");

        if (command.length <= 1) {
            MessageLog.addMessage(SystemText.UNKNOWN_COMMAND, true);
        } else {

            String notation = command[0];
            String thingName = getThingName(command);

            if (notation.equalsIgnoreCase(LOOK)) {

                if (thing.getChildren().containsKey(thingName)) {
                    ThingLoop.loop(thing.getChildren().get(thingName));
                }
            }

            if (notation.equalsIgnoreCase(CHECK)) {

                if (thing.getChecks().containsKey(thingName)) {
                    CheckLogic.handleCheck(thing, thing.getChecks().get(thingName));
                }
            }

        }
    }

    private static String getThingName(String[] command) {
        StringBuilder thingName = new StringBuilder();
        for (int i = 1; i < command.length; i++) {
            if (i != 1) {
                thingName.append(SystemText.SPACE).append(command[i]);
            } else {
                thingName.append(command[i]);
            }
        }
        return thingName.toString();
    }
}
