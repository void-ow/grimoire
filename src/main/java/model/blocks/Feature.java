package model.blocks;

import lombok.Data;

@Data
public class Feature {

    private String name;
    private String severity;
    private boolean system;

    public Feature(String name, String severity, boolean system) {
        this.name = name;
        this.severity = severity;
        this.system = system;
    }

}
