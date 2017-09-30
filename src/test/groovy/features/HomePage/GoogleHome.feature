Feature: Google Home

  As a user I want to verify google is available for search.

  Rules:
 www.google.com should load page with search edit field and search buttons


  @smoke
  Scenario: Navigate to Google.com
    Given The user is on the google search page
    When the user presses Enter button
    Then the google home page Logo is displayed