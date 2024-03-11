@Home_Hexacta
Feature: Hexacta Home

  @screenplay_challenge
  Scenario: Interaction with the hexacta page
    Given Navigate in the page Hexacta
    When Search "Outsource"
    Then Checks if the message for the "What not to do when working with an outsourced software team" exist