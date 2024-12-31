Feature: Typing bot for the site https://play.typeracer.com.
  Background: I am on the main page of the site
    Given I open the site "https://play.typeracer.com"

  Scenario: The bot starts the game and types a words
    When Start the game
    And Waiting for the game to start
    And Typing highlighted word
    Then Checking that the game is finished and the count of WPM is over 100