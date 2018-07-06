package init;

import lombok.Data;
import model.FeatureData;
import model.ThingData;
import utils.datareader.DataReader;

import java.util.ArrayList;
import java.util.List;

@Data
public class Database {

    private static List<ThingData> things = new ArrayList<>();
    private static List<FeatureData> features = new ArrayList<>();

    public Database() {
    }

    public static void initialize() {
        things = DataReader.readThingData("things.dat");
        features = DataReader.readFeatureData("features.dat");
    }
}
