package mainlogic;

import generation.Generator;
import model.blocks.Thing;

public class DecisionLogic {

    public static void handleDecision(String decision) {
        if (decision.equalsIgnoreCase("room")) {
            Thing room = Generator.generateThing("room");
            ThingLoop.loop(room);
        }
    }

    public static void handleDecisionForThing(String decision, Thing thing) {

        if (thing.getChildren().containsKey(decision)) {
            ThingLoop.loop(thing.getChildren().get(decision));
        }
    }
}
