package model.blocks;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class FeatureBank {

    private String name;
    private List<String> severities;

    public FeatureBank(String name, List<String> severities) {
        this.name = name;
        this.severities = severities;
    }
}
