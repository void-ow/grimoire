package mainlogic.light;

import model.Room;
import model.blocks.Feature;

public class LightManager {

    public static void hideFeatures(Room room) {

        boolean infravisionOnly = false;

        for (int i = 0; i < room.getFeatureList().size(); i++) {
            Feature feature = room.getFeatureList().get(i);
            if (feature.getName().equalsIgnoreCase("Light")) {
                if (!feature.getSeverity().equalsIgnoreCase("moderately lit")
                        && !feature.getSeverity().equalsIgnoreCase("fully lit")
                        && !feature.getSeverity().equalsIgnoreCase("brightly lit")
                        && !feature.getSeverity().equalsIgnoreCase("extremely bright")) {
                    infravisionOnly = true;
                }
            }
        }

        if (infravisionOnly) {
            for (int i = 0; i < room.getFeatureList().size(); i++) {
                Feature feature = room.getFeatureList().get(i);
                if (feature.getName().equalsIgnoreCase("Size")) {
                    feature.setKnown(false);
                }
                if (feature.getName().equalsIgnoreCase("Walls")) {
                    feature.setKnown(false);
                }
            }
        }
    }
}
