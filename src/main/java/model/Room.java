package model;

import lombok.Data;
import model.blocks.Feature;
import text.RoomFlavourText;
import text.SystemText;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {

    List<Feature> featureList = new ArrayList<>();

    public Room() {
    }

    @Override
    public String toString() {
        return "Room{" +
                "featureList=" + featureList +
                '}';
    }

    public String describe() {
        StringBuilder description = new StringBuilder();

        description.append(RoomFlavourText.INITIAL);

        if (featureList != null && !featureList.isEmpty()) {
            for (int i = 0; i < featureList.size(); i++) {
                if (i != 0) {
                    description.append(SystemText.AND);
                }
                description.append(featureList.get(i).getSeverity());
            }
        } else {
            description.append(RoomFlavourText.FEATURELESS);
        }
        description.append(SystemText.END);

        return description.toString();
    }
}
