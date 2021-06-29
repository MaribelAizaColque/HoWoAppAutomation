Feature: howo-app Register Form


@regression
  Scenario Outline: Verify that user can register successfully
  Given  user enters to Howo page
    When the user click Register button
    Then user enters  <fullName>
    And user enters his <email>
    And user enters the <password>
    And user enters repeat <password>
    And user click register button
    And verify that  display the success message
  Examples:
    | fullName   | email                  | password |
    | Juan Perez | juanperez101@gmail.com | password |