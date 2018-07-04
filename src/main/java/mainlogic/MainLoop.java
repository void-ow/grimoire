package mainlogic;

import generation.Generator;
import model.Room;
import text.SystemText;
import utils.messagelog.MessageLog;

import java.util.Scanner;

public class MainLoop {

    private static boolean toStop;

    public static void loop() {
        while (!toStop) {
            MessageLog.addMessage(SystemText.MAIN_LOOP, true);
            Scanner inputScanner = new Scanner(System.in);
            String input = inputScanner.nextLine();

            DecisionLogic.handleDecision(input);

            if (input.equalsIgnoreCase("stop")) {
                toStop = true;
            }
        }
    }
}
