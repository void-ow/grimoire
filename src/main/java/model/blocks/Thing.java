package model.blocks;

import lombok.Data;
import mainlogic.FeatureLogic;
import model.Check;
import text.DefaultFlavourText;
import text.SystemText;

import java.util.HashMap;
import java.util.Map;

import static text.SystemText.ImmutableFeatures.HIDDEN;

@Data
public class Thing {

    private String name;
    private Map<String, Thing> children;
    private Map<String, Feature> features;
    private Map<String, Check> checks;

    public Thing(String name) {
        this.name = name;
        children = new HashMap<>();
        features = new HashMap<>();
        checks = new HashMap<>();
    }

    public String describe() {
        StringBuilder description = new StringBuilder(DefaultFlavourText.INITIAL);
        return description.append(getShortDescription()).toString();
    }

    private String getShortDescription() {
        StringBuilder description = getNameWithQualities()
                .append(SystemText.END);

        // Describe it's children Things

        // Hide children that have "hidden" feature with the correct severity
        Map<String, Thing> childrenToShow = hideChildren();

        if (!childrenToShow.isEmpty()) {
            description
                    .append(SystemText.SPACE)
                    .append(DefaultFlavourText.DESCRIBE_CHILD);

            for (Thing child : childrenToShow.values()) {
                description.append(child.getNameWithQualities()).append(SystemText.COMMA);
            }

            // Delete that last comma
            description.replace(
                    description.lastIndexOf(SystemText.COMMA),
                    description.lastIndexOf(SystemText.COMMA) + 1,
                    SystemText.END);

        }
        return description.toString();
    }

    private Map<String, Thing> hideChildren() {
        Map<String, Thing> childrenToShow = new HashMap<>();

        for (Thing child : children.values()) {

            if (!FeatureLogic.isSeverityEqualTo(child.getFeatures(), HIDDEN, HIDDEN)) {
                childrenToShow.put(child.name, child);
            }

        }
        return childrenToShow;
    }

    private StringBuilder getNameWithQualities() {
        // Add a prefix
        StringBuilder description = new StringBuilder(DefaultFlavourText.A);
        // Add each feature
        for (Feature feature : features.values()) {
            // 'cept for system ones
            if (!feature.isSystem()) {
                description
                        .append(SystemText.SPACE)
                        .append(feature.getSeverity());
            }
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
