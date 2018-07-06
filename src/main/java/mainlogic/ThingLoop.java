package mainlogic;

import model.Thing;
import text.SystemText;
import utils.messagelog.MessageLog;

import java.util.Scanner;

public class ThingLoop {

    private static boolean toStop;

    public static void loop(Thing room) {
        while (!toStop) {
            MessageLog.addMessage("You are currently in a room.", true);
            MessageLog.addMessage(room.describe(), true);
            MessageLog.addMessage(SystemText.ACTION_LOOP, true);

            Scanner inputScanner = new Scanner(System.in);
            String input = inputScanner.nextLine();

            DecisionLogic.handleDecisionForRoom(input, room);

            if (input.equalsIgnoreCase("stop")) {
                toStop = true;
            }
        }
        toStop = false;
    }
}
