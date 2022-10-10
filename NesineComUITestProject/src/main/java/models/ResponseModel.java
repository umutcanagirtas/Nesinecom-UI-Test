package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseModel {
    @JsonProperty
    private long SportType;
    @JsonProperty
    private boolean IsMobile;
    @JsonProperty
    private List<FilterDates> FilterDates;
    @JsonProperty
    private List<PopularBetList> PopularBetList;
    @JsonProperty
    private List<PopularBetLeague> PopularBetLeague;
    @JsonProperty
    private Object LeagueIdsByDate;
}
