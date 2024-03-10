  @services
  Feature: Make request to a service

  Background: I makes the connection to the api
    Given I makes the connection to the api

  @GetUsers
  Scenario: Make request to method Get for consult all users
    When Execute the method GET with the resource api "all users" with "<typeUser>"
    Then See that the is returned 200

  @GetAnUser
  Scenario Outline: Make request to method Get for consult an user
    When Execute the method GET with the resource api "users" with "<typeUser>"
    Then See that the is returned <statusCode>
    And Check if the user exists successfully for "<typeUser>"
    Examples:
      |typeUser  | statusCode |
      |valid     |200         |
      |idInvalid |404         |

  @DeleteUser
  Scenario: Make request to method DELETE for delete an user
    When Execute the method DELETE with the resource api "users"
    Then See that the is returned 204

  @CreateUser
  Scenario Outline: Make request to method POST for create an user
    When Execute the method POST with the resource api "users" with "<typeUser>"
    Then See that the is returned <statusCode>
    And Check if the user was create successfully for "<typeUser>"
    Examples:
      |typeUser       | statusCode |
      |valid          |201         |
      |jobEmpty       |400         |
      |jobInvalid     |400         |
      |withoutJobParam|201         |

  @ModifyUser
  Scenario Outline: Make request to method PUT for modify an user
    When Execute the method PUT with the resource api "users" with "<typeUser>"
    Then See that the is returned <statusCode>
    And Check if the user was modify successfully for "<typeUser>"
    Examples:
      |typeUser       | statusCode |
      |valid          |200         |
      |withoutJobParam|200         |
