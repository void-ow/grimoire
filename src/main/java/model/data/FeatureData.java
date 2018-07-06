package model.data;

import lombok.Data;

import java.util.List;

@Data
public class FeatureData {

    private String name;
    private List<String> severities;

    public FeatureData(String name, List<String> severities) {
        this.name = name;
        this.severities = severities;
    }
}
