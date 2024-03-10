<em> # Automation challenge Hexacta </em>
Introduction 🚀
Automation made for a challenge, with transactions to call API And Hexacta Web

+ A file is attached showing the operation of the cases and some notes. Evidence execution of test cases

* This challenge is created to consume through the GET , POST , DELETE  and PUT methods the service https://reqres.in
and validate different answers that it can answer. The Hexacta website is also automated https://www.hexacta.com/


+ For the POST method, 2 business rules were created because the api does not have many controls
```
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
```

+ The header options are automated and the About Us form is filled out with different test cases

```
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
```
________
Pre requirements to execute 📋
+ Java version 17, update 17.0.2 or higher and JDK (environment variables configured).
+ Eclipse IDE or IntelliJ IDEA
+ Maven Compiler.
+ Cucumber for Java Plugin (updated version).
+ Gherkin Plugin (updated version).

________
Installation 🔧
+ To clone this repository locally, the following command must be run: git clone "https://github.com/dzapatab/hexacta-challenge" or download with ZIP
+ Import the project from Eclipse or IntelliJ IDE.
+ Configure the encoding to UTF-8 to the project once it is imported.
+ Compile the project with the command mvn compile and mvn clean or use the plugin compiler in the IDE 🔨
________
Execution 💻
The project can be executed from : src/test/java/com/hexacta/runners/RunnerTest.java
Tags web: @web
Tags services: tags = @services @GetUsers @GetAnUser @DeleteUser @CreateUser @ModifyUser

or

Command Line:
+ mvn clean test -D"cucumber.filter.tags=@services"
+ mvn clean test -D"cucumber.filter.tags=@web"
________
Create Serenity report 📋
+ User the plugin serenity:aggregate 
+ Command: mvn serenity:aggregate
________
Project structure 🚧

\## src/main/java/com/hexacta/
+ exceptions
    Classes that catch custom exceptions when automation fails and cannot find an expected field.

+ models
    Classes with which the data models are built using the builder pattern.

+ factory
    Classes to have a factory that instantiates objects

+ drivers
    Classes instantiate browsers

+ questions
    Classes with which values are obtained and then verified in the stepdefinitions (asserts).

+ tasks
    Classes that perform high-level actions, such as login in the application, enter data into a form, etc.

+ userinterfaces
   The userinterfaces layer could contain classes that represent user interface elements and facilitate the creation of tasks and interactions in Screenplay

+ interactions
    Classes that help to interact with the user interface or with APIs

+ utils
    Classes that contain common functionalities.

\## src/test/java/com/hexacta/  

+ runners
    Classes to run automation with the scenarios indicated in the feature.

+ stepdefinitions
    Classes that are the entry point of the feature to translate from Gherkin language to machine language and thus allow the execution of automation.

src/test/resources/

+ features
    The project features are found.
________
Built with 🛠
Automation was developed with:

+ BDD - Development strategy
+ Screenplay - Design pattern
+ Maven - Dependency manager
+ Cucumber7 - Is a software tool that supports behavior-driven development
+ Serenity BDD - open source library that helps write higher quality automated acceptance tests more efficiently
+ Gherkin - Business Readable DSL Language (Business-readable domain specific language)
+ Serenity Rest - Library that allows us to consume services
+ Hamscrest - Hamcrest is a framework for writing matcher objects allowing 'match' rules to be defined
+ GSON - Is an open source library that allows serialization and deserialization between Java objects and their representation in JSON notation.
+ Lombok annotations - It is a library for Java that through annotations reduces the code that we code
+ Faker - In software development, it is common to have to test an application with a large amount of test data. JavaFaker allows you to generate this data efficiently and realistically.
________
Versioning 📌
Git was used for version control, applying GitFlow 🔀


________
Thanks !!

Authors 👨
Diego Alejandro Zapata Betancur - dazb12@hotmail.com