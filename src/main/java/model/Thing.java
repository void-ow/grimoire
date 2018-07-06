package model;

import lombok.Data;
import model.blocks.Feature;

import java.util.ArrayList;
import java.util.List;

@Data
public class Thing {

    private String name;
    private List<Thing> children;
    private List<Feature> features;

    public Thing(String name) {
        this.name = name;
        children = new ArrayList<>();
        features = new ArrayList<>();
    }

    public String describeFully() {
        StringBuilder description = new StringBuilder("This is ");
        return description.append(getFullDescription()).toString();
    }

    public String describe() {
        StringBuilder description = new StringBuilder("This is ");
        return description.append(getShortDescription()).toString();
    }

    private String getFullDescription() {
        StringBuilder description = new StringBuilder("a ");
        for (Feature feature : features) {
            description.append(feature.getSeverity()).append(" ");
        }
        description.append(name).append(". ");
        for (Thing child : children) {
            description.append("It has ").append(child.getFullDescription());
        }
        return description.toString();
    }

    private String getShortDescription() {
        StringBuilder description = new StringBuilder("a ");
        for (Feature feature : features) {
            description.append(feature.getSeverity()).append(" ");
        }
        description.append(name).append(". ");
        description.append("It has ");
        for (Thing child : children) {
            description.append("a ").append(child.getName()).append(", ");
        }
        return description.toString();
    }
}
