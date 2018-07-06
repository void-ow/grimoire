package model.blocks;

import lombok.Data;

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

    @Override
    public String toString() {
        return "Feature{" +
                "name='" + name + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}
