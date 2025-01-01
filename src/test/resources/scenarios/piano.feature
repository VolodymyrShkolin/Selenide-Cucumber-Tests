Feature: Playing a melody on the piano on the site https://virtualpiano.net
  Background: I am on the main page of the site
    Given I open the site "https://virtualpiano.net"

    Scenario: The bot write and plays it
      When Writing the melody "xZxZxkzlj sfjk fHkl fxZxZxkzlj sfjk flkj klzx kcxz gxzl fzlk fxZxZxkzlj sfjk flkj"
      And Playing the melody
      Then Checking that the melody is over
