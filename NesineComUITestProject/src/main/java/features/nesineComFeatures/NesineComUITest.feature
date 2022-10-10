Feature: NesineComUITest

  Scenario: Chrome Scenarios for NesineCom
    Given Create Browser as "chrome"
    And Go to NesineCom homepage
    And Close Tutorial PopUp Or Accept Cookies
    When Login
    And Click Popular Bets
    And Check Correct url as "https://www.nesine.com/iddaa/populer-bahisler"
    And Click Football Tab
    And Get Played Count And Code
    And Create Post as GetPopularBets Service "{\"eventType\":1,\"date\":null}"
    And Sign Out Of Account
    Then Compare Service Data With Web Data

  Scenario: Firefox Scenarios for NesineCom
    Given Create Browser as "firefox"
    And Go to NesineCom homepage
    And Close Tutorial PopUp Or Accept Cookies
    When Login
    And Click Popular Bets
    And Check Correct url as "https://www.nesine.com/iddaa/populer-bahisler"
    And Click Football Tab
    And Get Played Count And Code
    And Create Post as GetPopularBets Service "{\"eventType\":1,\"date\":null}"
    And Sign Out Of Account
    Then Compare Service Data With Web Data