@web
Feature: Hexacta Web

  @screenplay
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

    @page_object
  Scenario Outline: Interaction with the hexacta page with page object model
    Given Navigate in the page Hexacta
    When Send "<dataType>" data in let´s work together with page object model
    Then Checks if the message for the "<dataType>" is valid with page object model

    Examples:
      | dataType                              |
      | missingAllInformation                 |
      | validUser                             |
      | userWithoutCompany                    |
      | userWithEmailInvalidAndWithoutCompany |