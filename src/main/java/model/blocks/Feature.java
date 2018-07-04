package model.blocks;

import lombok.Data;
import utils.dice.BaseDie;

@Data
public class Feature {

    private String name;
    private String severity;

    public Feature(String name, String severity) {
        this.name = name;
        this.severity = severity;
    }

    public Feature(FeatureBank featureBank) {
        this.name = featureBank.getName();
        this.severity = featureBank.getSeverities().get(BaseDie.roll(featureBank.getSeverities().size() - 1));
    }

    @Override
    public String toString() {
        return "Feature{" +
                "name='" + name + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}
