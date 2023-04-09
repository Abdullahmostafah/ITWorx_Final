@smoke
  Feature: user should be able to see course title displayed at courses list page
    Scenario: user has created course and checking its name
      Given user click on course page icon
      When search by course name
      Then course title is displayed on course page