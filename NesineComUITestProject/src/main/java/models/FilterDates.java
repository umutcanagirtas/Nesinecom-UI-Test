package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FilterDates {
    @JsonProperty
    private String Key;
    @JsonProperty
    private String Value;
    @JsonProperty
    private boolean IsSelected;
}
