package utils.datareader;

import model.data.FeatureData;
import model.data.ThingData;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static List<ThingData> readThingData(String filename) {
        List<ThingData> toReturn = new ArrayList<>();

        try {

            String allData = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
            allData = allData.replace("\n", "");
            allData = allData.replace(" ", "");
            String[] things = allData.split("\\{");

            for (int i = 1; i < things.length; i++) {
                String[] properties = things[i].split("\\;");

                String name = getStringFromProperties(properties, 0);
                if (name.equalsIgnoreCase("UNKNOWN")) {
                    System.out.println("Data parse warning: no name for thing #" + i);
                }

                List<String> tags = getListStringFromProperties(properties, 1);
                validateResult(name, tags, "tags");

                List<String> children = getListStringFromProperties(properties, 2);
                validateResult(name, children, "children");

                List<String> optionalTags = getListStringFromProperties(properties, 3);
                validateResult(name, optionalTags, "optional_tags");

                List<String> features = getListStringFromProperties(properties, 4);
                validateResult(name, features, "features");

                toReturn.add(new ThingData(name, tags, children, optionalTags, features));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    public static List<FeatureData> readFeatureData(String filename) {
        List<FeatureData> toReturn = new ArrayList<>();

        try {

            String allData = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
            allData = allData.replace("\n", "");
            allData = allData.replace(" ", "");
            String[] things = allData.split("\\{");

            for (int i = 1; i < things.length; i++) {
                String[] properties = things[i].split("\\;");

                String name = getStringFromProperties(properties, 0);
                if (name.equalsIgnoreCase("UNKNOWN")) {
                    System.out.println("Data parse warning: no name for feature #" + i);
                }

                List<String> severities = getListStringFromProperties(properties, 1);
                validateResult(name, severities, "severities");

                toReturn.add(new FeatureData(name, severities));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    private static void validateResult(String name, List<String> stringList, String parameter) {
        if (stringList.size() == 0) {
            System.out.println(String.format("Data parse warning: no %s for thing %s", parameter, name));
        }
    }

    private static String getStringFromProperties(String[] properties, int propNumber) {
        String[] item = properties[propNumber].split("\\:");
        String name = "UNKNOWN";
        if (item.length > 1) {
            name = item[1];
        }
        return name;
    }

    private static List<String> getListStringFromProperties(String[] properties, int propNumber) {
        String[] item = properties[propNumber].split("\\:");
        List<String> list = new ArrayList<>();
        if (item.length > 1) {
            String[] strings = item[1].split("\\,");
            for (int j = 0; j < strings.length; j++) {
                list.add(strings[j]);
            }
        }
        return list;
    }
}
