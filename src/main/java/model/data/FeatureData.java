package model.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeatureData {

    private String name;
    private List<String> severities = new ArrayList<>();
    private List<String> flavourText = new ArrayList<>();

    public FeatureData() {
    }

    public FeatureData(String name, List<String> severities) {
        this.name = name;
        this.severities = severities;
    }
}
