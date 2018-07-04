package generation;

import model.Room;
import model.blocks.Feature;
import model.blocks.FeatureBank;
import utils.dice.DTwenty;

import static init.featureBanks.RoomFeatureBanks.*;

public class Generator {

    private static final int FEATURE_GENERATION_THRESHOLD = 15;

    public static Room generateRoom() {
        Room generated = new Room();

        for (int i = 0; i < roomRequiredFeatureBanks.size(); i++) {
            addFeatureBankToRoom(generated, roomRequiredFeatureBanks.get(i));
        }

        for (int i = 0; i < roomFeatureBanks.size(); i++) {
            if (DTwenty.roll() >= FEATURE_GENERATION_THRESHOLD) {
                addFeatureBankToRoom(generated, roomFeatureBanks.get(i));
            }
        }

        return generated;
    }

    private static void addFeatureBankToRoom(Room room, FeatureBank featureBank) {
        Feature feature = new Feature(featureBank);
        room.getFeatureList().add(feature);
    }

}
