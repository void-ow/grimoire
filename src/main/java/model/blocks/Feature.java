package model.blocks;

import lombok.Data;
import utils.dice.BaseDie;

@Data
public class Feature {

    private String name;
    private String severity;
    private boolean known;
    private int difficulty;

    public Feature(String name, String severity) {
        this.name = name;
        this.severity = severity;
    }

    public Feature(FeatureBank featureBank) {
        name = featureBank.getName();
        severity = featureBank.getSeverities().get(BaseDie.roll(featureBank.getSeverities().size()) - 1);
    }

    @Override
    public String toString() {
        return "Feature{" +
                "name='" + name + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}
