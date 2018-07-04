package utils.dice;

import java.util.concurrent.ThreadLocalRandom;

public class BaseDie {

    public static int roll(int sides) {
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }
}
