package generation;

import init.Database;
import model.Check;
import model.blocks.Feature;
import model.blocks.Thing;
import model.data.FeatureData;
import model.data.ThingData;
import text.SystemText;
import utils.dice.BaseDie;
import utils.dice.DTwenty;

import java.util.List;

public class Generator {

    private static final int FEATURE_GENERATION_THRESHOLD = 15;

    public static Thing generateThing(String name) {

        Thing generated = new Thing(name);

        ThingData data = Database.things.get(name);

        if (data == null) {
            System.out.println("Generation Error: Can't generate " + name + " - it doesn't exist in the data.");
            return generated;
        }

        // Get Thing's features and generate them randomly
        List<String> mainFeatures = data.getFeatures();

        for (String featureName : mainFeatures) {

            String severity = SystemText.UNKNOWN;
            FeatureData featureDataFromDB = Database.features.get(featureName);
            boolean system = featureDataFromDB.isSystem();

            if (featureDataFromDB != null) {

                List<String> severities = featureDataFromDB.getSeverities();
                // If there's an additional flavour text, swap out severities text with it
                if (featureDataFromDB.getFlavourText() != null && featureDataFromDB.getFlavourText().size() != 0) {
                    severities = featureDataFromDB.getFlavourText();
                }

                if (severities != null && severities.size() != 0) {
                    severity = severities.get(BaseDie.roll(severities.size()) - 1);
                } else {
                    System.out.println("Generation Warning: Feature " + featureName + " does not have any severities");
                }
            } else {
                System.out.println("Generation Warning: Can't find feature " + featureName);
            }

            generated.getFeatures().put(featureName, new Feature(featureName, severity, system));
        }

        // Get Thing's checks
        List<String> checks = data.getChecks();
        for (String check : checks) {
            generated.getChecks().put(check, new Check(check));
        }

        // Get Thing's children and generate them randomly.
        List<String> children = data.getChildren();
        if (children != null && children.size() != 0) {
            for (String child : children) {
                Thing generatedChild = generateThing(child);
                generated.getChildren().put(child, generatedChild);
            }
        } else {
            System.out.println("Generation Warning: " + name + " does not have any children");
        }

        // Get Thing's optional children and generate them randomly.
        List<String> tags = data.getOptionalTags();
        if (tags != null && tags.size() != 0) {
            for (String tag : tags) {
                List<String> thingsByTags = Database.thingsByTags.get(tag);
                if (thingsByTags != null && thingsByTags.size() != 0) {
                    for (String thingFromTag : thingsByTags) {
                        // Randomly generate
                        // or don't
                        if (DTwenty.roll() >= FEATURE_GENERATION_THRESHOLD) {
                            Thing generatedChild = generateThing(thingFromTag);
                            generated.getChildren().put(thingFromTag, generatedChild);
                        }
                    }
                } else {
                    System.out.println("Generation Warning: Tag " + tag + " does not have any Things associated with it");
                }
            }
        } else {
            System.out.println("Generation Warning: " + name + " does not have any tags");
        }

        return generated;
    }

}
