Feature: NesineComLayoutTest

  Scenario: Chrome Layout Testing for Login Button NesineCom
    Given Create Browser as "chrome"
    And Go to NesineCom homepage
    And Check Layout Login Button

  Scenario: Firefox Layout Testing for Login Button NesineCom
    Given Create Browser as "firefox"
    And Go to NesineCom homepage
    And Check Layout Login Button