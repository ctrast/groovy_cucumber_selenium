Feature: Mercury Tours Login

  As a user I want to Log into the website

  Rules:
  - Provide Valid username and password



  @regression
  Scenario: Login
    Given The user is on the Mercury Tours home page
    And the user enters the username "mercury"
    And the user enter the password "mercury"
    When the user presses Sign-In button
    Then the Flight Finder page is displayed