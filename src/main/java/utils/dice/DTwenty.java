package utils.dice;

import text.SystemText;
import utils.messagelog.MessageLog;

public class DTwenty {

    private static String name = "Twenty-sided die";
    private static int sides = 20;

    public static int roll() {
        return BaseDie.roll(sides);
    }

    public static int rollWithFloor(int floor) {
        int roll = BaseDie.roll(sides);
        if (roll < floor) {
            roll = floor;
        }
        return roll;
    }

    public static int rollAndPrint() {
        int toReturn = roll();

        final String message = String.format(SystemText.DICE_ROLL, name, toReturn);
        MessageLog.addMessage(message, true);

        return toReturn;
    }
}
