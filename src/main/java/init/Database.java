package init;

import model.data.FeatureData;
import model.data.ThingData;
import text.SystemText;
import utils.datareader.DataReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    public static Map<String, ThingData> things = new HashMap<>();
    public static Map<String, List<String>> thingsByTags = new HashMap<>();

    public static Map<String, FeatureData> features = new HashMap<>();

    public Database() {
    }

    public static void initialize() {
        List<ThingData> thingData = DataReader.readThingData("things.dat");
        for (int i = 0; i < thingData.size(); i++) {
            ThingData data = thingData.get(i);
            if (!data.getName().equalsIgnoreCase(SystemText.UNKNOWN)) {
                things.put(data.getName(), data);

                List<String> tags = data.getTag();
                if (tags != null && tags.size() != 0) {
                    for (int j = 0; j < tags.size(); j++) {
                        String tag = tags.get(j);
                        if (!thingsByTags.containsKey(tag)) {
                            List<String> dataList = new ArrayList<>();
                            dataList.add(data.getName());
                            thingsByTags.put(tag, dataList);
                        } else {
                            thingsByTags.get(tag).add(data.getName());
                        }
                    }
                }

            }
        }

        List<FeatureData> featureData = DataReader.readFeatureData("features.dat");
        for (int i = 0; i < featureData.size(); i++) {
            if (!featureData.get(i).getName().equalsIgnoreCase(SystemText.UNKNOWN)) {
                features.put(featureData.get(i).getName(), featureData.get(i));
            }
        }
    }
}
