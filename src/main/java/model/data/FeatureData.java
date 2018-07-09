package model.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeatureData {

    private String name;
    private List<String> severities = new ArrayList<>();
    private List<String> flavourText = new ArrayList<>();
    private boolean system;

    public FeatureData() {
    }

    public FeatureData(String name, List<String> severities, boolean system) {
        this.name = name;
        this.severities = severities;
        this.system = system;
    }
}
