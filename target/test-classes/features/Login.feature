#noinspection CucumberUndefinedStep
Feature: howo-app Login Form


@regression
Scenario Outline: Verify that the user cannot enter incorrect data
Given that the user enters incorrect information
When click the Login button
Then the system should display a warning message

And user enters his <email>
And user enters the <password>
And user click login button
And verify that display the warning message
And driver close
Examples:
  | email                 | password |
  | juan1yopmail          | password1 |