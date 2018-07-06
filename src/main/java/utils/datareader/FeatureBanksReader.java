package utils.datareader;

import model.blocks.FeatureBank;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FeatureBanksReader {

    public static List<FeatureBank> readFromFeatureBank(String filename) {
        List<FeatureBank> toReturn = new ArrayList<>();

        try {

            String allData = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
            String[] featureBanks = allData.split(";");

            for (int i = 0; i < featureBanks.length; i++) {
                String[] data = featureBanks[i].split(",");

                List<String> severities = new ArrayList<>();
                for (int j = 1; j < data.length; j++) {
                    severities.add(data[j]);
                }

                FeatureBank featureBank = new FeatureBank(data[0].replace("\n",""), severities);
                toReturn.add(featureBank);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toReturn;
    }
}
