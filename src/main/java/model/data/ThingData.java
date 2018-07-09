package model.data;

import lombok.Data;

import java.util.List;

@Data
public class ThingData {

    private String name;
    private List<String> tag;
    private List<String> children;
    private List<String> optionalTags;
    private List<String> features;
    private List<String> checks;

    public ThingData(String name, List<String> tag, List<String> children,
                     List<String> optionalTags, List<String> features, List<String> checks) {
        this.name = name;
        this.tag = tag;
        this.children = children;
        this.optionalTags = optionalTags;
        this.features = features;
        this.checks = checks;
    }
}
