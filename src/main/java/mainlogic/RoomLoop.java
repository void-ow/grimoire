package mainlogic;

import model.Room;
import text.SystemText;
import utils.messagelog.MessageLog;

import java.util.Scanner;

public class RoomLoop {

    private static boolean toStop;

    public static void loop(Room room) {
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
