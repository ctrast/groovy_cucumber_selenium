Feature: Google Search

  As a user I want to search google for content.

  Rules:
  - Google should return as many known results as possible.
  - Google Cannot search unless a search parameter is entered.


  @Test
  Scenario: Search for Bears
    Given The user is on the google search page
    And the user enters the search "bears"
    When the user presses Enter button
    Then search results list the "www.chicagobears.com"