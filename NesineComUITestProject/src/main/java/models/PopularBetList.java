package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PopularBetList {
    @JsonProperty
    private long PlayedCount;
    @JsonProperty
    private long Code;
    @JsonProperty
    private String Name;
    @JsonProperty
    private long MatchType;
    @JsonProperty
    private long Mbs;
    @JsonProperty
    private long OutcomeId;
    @JsonProperty
    private double Odd;
    @JsonProperty
    private String MatchTime;
    @JsonProperty
    private long GameType;
    @JsonProperty
    private long HandicapHome;
    @JsonProperty
    private long HandicapVisitor;
    @JsonProperty
    private long FirstHalfHandicapHome;
    @JsonProperty
    private long FirstHalfHandicapVisitor;
    @JsonProperty
    private long SecondHalfHandicapHome;
    @JsonProperty
    private long SecondHalfHandicapVisitor;
    @JsonProperty
    private long ExtraHandicapHome;
    @JsonProperty
    private long ExtraHandicapVisitor;
    @JsonProperty
    private long Limit;
    @JsonProperty
    private String HomeName;
    @JsonProperty
    private String AwayName;
    @JsonProperty
    private Object HomeNameHandicap;
    @JsonProperty
    private Object AwayNameHandicap;
    @JsonProperty
    private long EventType;
    @JsonProperty
    private long H1Y1;
    @JsonProperty
    private long H2Y1;
    @JsonProperty
    private long H1Y2;
    @JsonProperty
    private long H2Y2;
    @JsonProperty
    private long EH1;
    @JsonProperty
    private long EH2;
    @JsonProperty
    private long LeagueID;
    @JsonProperty
    private long BTIP;
    @JsonProperty
    private long NsnMarketTypeId;
    @JsonProperty
    private long SpecialOddsValue;
    @JsonProperty
    private long MarketType;
    @JsonProperty
    private long MarketStatus;
    @JsonProperty
    private long Season;
    @JsonProperty
    private long MarketId;
    @JsonProperty
    private String MarketName;
    @JsonProperty
    private String OutcomeName;
    @JsonProperty
    private long CbsProviderId;
    @JsonProperty
    private String MarketNo;
    @JsonProperty
    private String NavLink;
    @JsonProperty
    private String StatisticsUrl;
    @JsonProperty
    private long ViewTypeId;
}
