package mainlogic;

import model.Thing;
import text.SystemText;
import utils.messagelog.MessageLog;

import java.util.Scanner;

public class ThingLoop {

    private static boolean toStop;

    public static void loop(Thing thing) {
        while (!toStop) {
            MessageLog.addMessage("You are observing a " + thing.getName(), true);
            MessageLog.addMessage(thing.describe(), true);
            MessageLog.addMessage(SystemText.ACTION_LOOP, true);

            Scanner inputScanner = new Scanner(System.in);
            String input = inputScanner.nextLine();

            DecisionLogic.handleDecisionForThing(input, thing);

            if (input.equalsIgnoreCase("stop")) {
                toStop = true;
            }
        }
        toStop = false;
    }
}
