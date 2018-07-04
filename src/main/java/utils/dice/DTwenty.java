package utils.dice;

import text.SystemText;
import utils.messagelog.MessageLog;

public class DTwenty {

    private static String name = "Twenty-sided die";
    private static int sides = 20;

    public static int roll() {
        return BaseDie.roll(sides);
    }

    public static void rollAndPrint() {
        final String message = String.format(SystemText.DICE_ROLL, name, roll());
        MessageLog.addMessage(message, true);
    }
}
