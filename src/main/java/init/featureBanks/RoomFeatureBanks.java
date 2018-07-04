package init.featureBanks;

import model.blocks.FeatureBank;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.datareader.FeatureBanksReader.readFromFeatureBank;

public class RoomFeatureBanks {

    public static List<FeatureBank> roomFeatureBanks = new ArrayList<>();

    public static List<FeatureBank> roomRequiredFeatureBanks = new ArrayList<>();

    public static void initialize() {
        roomFeatureBanks = readFromFeatureBank("room_optional.fbs");
        roomRequiredFeatureBanks = readFromFeatureBank("room_required.fbs");
    }
}
