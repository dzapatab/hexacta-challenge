@web
Feature: Hexacta

  Scenario Outline: Interaction with the hexacta page
    Given Navigate in the page Hexacta
    When Send "<dataType>" data in let´s work together
    Then Checks if the message for the "<dataType>" is valid

    Examples:
      | dataType                              |
      | missingAllInformation                 |
      | validUser                             |
      | userWithoutCompany                    |
      | userWithEmailInvalidAndWithoutCompany |