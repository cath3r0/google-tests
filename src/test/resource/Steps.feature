Feature: trying new framework

  Scenario: Test search suggestions on google page
    Given User is on Google Home Page
    When User enters "translate google com" in search field
    Then Suggestions "Можливо, ви мали на увазі: translate.google.com" are displayed

  Scenario: Test google translate
    Given User is on Google Home Page
    When User enters "translate google com" in search field
    And Opens first link and fills in first field "apple" and Clicks on any inactive language
    Then Check if translated text has been changed

  Scenario: Test navigation
    Given User is on Google Home Page
    When User enters "apple" in search field
    And Gets number of results
    And Navigates through second and tenth page
    Then Check if the same number of results are displayed on second and tenth page as on the first page