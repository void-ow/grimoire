package mainlogic;

import init.Database;
import model.blocks.Feature;
import model.blocks.Thing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeatureLogic {

    public static void changeSeverity(Map<String, Feature> features, String featureName, int newSeverityId) {
        if (features.containsKey(featureName)) {
            features.get(featureName)
                    .setSeverity(Database.features.get(featureName).getSeverities().get(newSeverityId));
        }
    }

    public static boolean isSeverityEqualTo(Map<String, Feature> features, String featureName, String severity) {
        if (features.containsKey(featureName)) {
            String featureSeverity = features.get(featureName).getSeverity();
            return severity.equalsIgnoreCase(featureSeverity);
        } else {
            return false;
        }
    }

    public static List<Thing> filterThingsForSpecificFeatureAndSeverity(Map<String, Thing> things,
                                                                        String feature, String severity) {
        return things.values().stream().filter(thing -> {
            return isSeverityEqualTo(thing.getFeatures(), feature, severity);
        }).collect(Collectors.toList());
    }

}
