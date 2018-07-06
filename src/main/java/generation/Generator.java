package generation;

import init.Database;
import model.Thing;
import model.blocks.Feature;
import model.data.FeatureData;
import model.data.ThingData;
import text.SystemText;
import utils.dice.BaseDie;

import java.util.List;

public class Generator {

    private static final int FEATURE_GENERATION_THRESHOLD = 15;
    private static final int PERCEPTION_FLOOR = 14;

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

            if (featureDataFromDB != null) {

                List<String> severities = featureDataFromDB.getSeverities();

                if (severities != null && severities.size() != 0) {
                    severity = severities.get(BaseDie.roll(severities.size()) - 1);
                } else {
                    System.out.println("Generation Warning: Feature " + featureName + " does not have any severities");
                }
            } else {
                System.out.println("Generation Warning: Can't find feature " + featureName);
            }

            generated.getFeatures().add(new Feature(featureName, severity));
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
                        Thing generatedChild = generateThing(thingFromTag);
                        generated.getChildren().put(thingFromTag, generatedChild);
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
