@smoke
  Feature: user should be able to add course to course list
    Scenario: logged user adding a course
      Given user click on course page icon
      And user click on create course button
      When user fill mandatory course fields and click on save
