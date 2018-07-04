package mainlogic.check;

import model.Room;
import model.blocks.Feature;
import utils.dice.DTwenty;

public class AbilityCheck {

    public static void checkPerception(Room toCheck) {
        int roll = DTwenty.rollAndPrint();

        for (int i = 0; i < toCheck.getFeatureList().size(); i++) {
            Feature featureToCheck = toCheck.getFeatureList().get(i);
            if (featureToCheck.getDifficulty() < roll) {
                featureToCheck.setKnown(true);
            }
        }
    }
}
