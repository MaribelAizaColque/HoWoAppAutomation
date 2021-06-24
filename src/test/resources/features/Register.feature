Feature: howo-app Register Form


@regression
  Scenario Outline: Verify that user can register successfully
  Given that the user can register in HoWo page
    When the user click Register button
    Then user sees the register form
    And user enters  <fullName>
    And user enters his <email>
    And user enters the <password>
    And user enters repeat <password>
    And user click register button
    And verify that  display the success message
    And driver close
  Examples:
    | fullName   | email                 | password |
    | Juan Perez | juanperez74@gmail.com | password |