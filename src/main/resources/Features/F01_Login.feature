@smoke
Feature: user should be able to login to the system
  Scenario: user login with valid username and password
    Given user navigates to login page
    When user enter valid name and password
    And user click on login button
    Then  user could login successfully and go to home page