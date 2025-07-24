Feature: Course Management on Winjigo Platform

  Background:
    Given the user navigates to the Winjigo login page
    When the user enters valid credentials
    And the user clicks the login button
    Then the user is logged in and redirected to the home page

  @smoke
  Scenario: Create a new course
    Given the user is on the courses page
    And user click on create course button
    When user fill mandatory course fields and click on save
    Then the user is redirected to the courses list page

  @smoke
  Scenario: Verify course title is displayed
    Given the user is on the courses page
    When search by course name
    Then course title is displayed on course page