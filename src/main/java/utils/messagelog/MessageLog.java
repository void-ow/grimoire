package utils.messagelog;

import java.util.ArrayList;
import java.util.List;

public class MessageLog {

    public static int MAX_LENGTH = 8;
    public static List<String> messages = new ArrayList<>();

    public static void addMessage(String message, boolean display) {
        adjustMessageLogSize();
        messages.add(message);

        if (display == true) {
            displayMessageLog();
        }
    }

    public static void displayMessageLog() {
        clearMessageLog();
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
    }

    public static void clearMessageLog() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void adjustMessageLogSize() {
        if (messages.size() >= MAX_LENGTH) {
            final int difference = messages.size() - MAX_LENGTH;
            messages = messages.subList(difference + 1, messages.size());
        }
    }

}
