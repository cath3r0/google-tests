Feature: trying new framework

  Scenario: Test search suggestions on google page
    Given User is on Google Home Page
    When User enter words in search field
    Then next text is displayed: 'showing results blablablah'

  Scenario: Test google translate
    Given User is on Google Home Page
    When User enter 'translate google.com' in search field
    And Opens first link
    And Fills in first field 'apple'
    And Clicks on any inactive language
    Then Check if translated text has been changed

  Scenario: Test navigation
    Given User is on Google Home Page
    When User search vie search field term 'apple'
    And Gets number of results
    And Navigates through second and tenth page
    Then Check if the same number of results are displayed on second and tenth page as on the first page