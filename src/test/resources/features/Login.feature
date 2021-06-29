Feature: howo-app Login Form


@regression
  Scenario Outline: Verify that user cannot login
  Given  user enters to Howo page
    When the user click login button
    Then the user enters <email>
    And enter your <password>
    And user click login button
    And verify that  display the warning message
  Examples:
    | email                | password |
    | juanperez44gmail.com | password |