package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PopularBetLeague {
    @JsonProperty
    private long Id;
    @JsonProperty
    private long SportId;
    @JsonProperty
    private long CategoryId;
    @JsonProperty
    private long TournamentId;
    @JsonProperty
    private long UniqueTournamentId;
    @JsonProperty
    private String Name;
    @JsonProperty
    private Object UppercasedName;
    @JsonProperty
    private Object Abbreviation;
    @JsonProperty
    private boolean IsPrimary;
    @JsonProperty
    private Object CreatedBy;
    @JsonProperty
    private Object ModifiedBy;
    @JsonProperty
    private String CreatedOn;
    @JsonProperty
    private Object ModifiedOn;
    @JsonProperty
    private String FlagCode;
    @JsonProperty
    private long LeagueOrder;
    @JsonProperty
    private long LeagueEventCount;
}
