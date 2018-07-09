package mainlogic;

import model.Check;
import model.blocks.Thing;

import java.util.List;

import static text.SystemText.Abbreviations.PERCEPTION;
import static text.SystemText.ImmutableFeatures.HIDDEN;

public class CheckLogic {

    public static void handleCheck(Thing thing, Check check) {
        if (check.getType().equalsIgnoreCase(PERCEPTION)) {
            perception(thing, check);
        }
    }

    public static void perception(Thing thing, Check check) {

        boolean checkSucceeded = check.check();

        List<Thing> hiddenChildren = FeatureLogic.filterThingsForSpecificFeatureAndSeverity(
                thing.getChildren(), HIDDEN, HIDDEN
        );

        for (Thing child : hiddenChildren) {
            if (check.check()) {
                FeatureLogic.changeSeverity(child.getFeatures(), HIDDEN, 1);
            }
        }
    }
}
