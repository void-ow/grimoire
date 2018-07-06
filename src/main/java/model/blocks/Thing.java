package model.blocks;

import lombok.Data;
import text.DefaultFlavourText;
import text.SystemText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Thing {

    private String name;
    private Map<String, Thing> children;
    private List<Feature> features;

    public Thing(String name) {
        this.name = name;
        children = new HashMap<>();
        features = new ArrayList<>();
    }

    public String describe() {
        StringBuilder description = new StringBuilder(DefaultFlavourText.INITIAL);
        return description.append(getShortDescription()).toString();
    }

    private String getShortDescription() {
        StringBuilder description = getNameWithQualities()
                .append(SystemText.END);

        // Describe it's children Things

        if (!children.isEmpty()) {
            description
                    .append(SystemText.SPACE)
                    .append(DefaultFlavourText.DESCRIBE_CHILD);

            for (Thing child : children.values()) {
                description.append(child.getNameWithQualities()).append(SystemText.COMMA);
            }

            // Delete that last comma
            description.replace(
                    description.lastIndexOf(SystemText.COMMA),
                    description.lastIndexOf(SystemText.COMMA) + 1,
                    ".");

        }
        return description.toString();
    }

    private StringBuilder getNameWithQualities() {
        // Add a prefix
        StringBuilder description = new StringBuilder(DefaultFlavourText.A);
        // Add each feature
        for (Feature feature : features) {
            description
                    .append(SystemText.SPACE)
                    .append(feature.getSeverity());
        }

        // Add a Thing's name
        description
                .append(SystemText.SPACE)
                .append(name);
        return description;
    }

    public String describeFully() {
        StringBuilder description = new StringBuilder(DefaultFlavourText.INITIAL);
        return description.append(getFullDescription()).toString();
    }

    private String getFullDescription() {
        // Add a prefix
        StringBuilder description = getNameWithQualities();

        for (Thing child : children.values()) {
            description.append("It has ").append(child.getFullDescription());
        }
        return description.toString();
    }
}
