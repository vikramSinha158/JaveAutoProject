Feature: Verification of Clearance tab for a new patient account

  @391783 @Clearance
  Scenario: Verify Clearance tab for a new patient account
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "LLNJ"
    And user clicks on "Patient Access" link
    And user clicks on "Pre-Registration" link
    When user clicks on New button at the bottom of accretive logo
    And user enter input for all mandatory field in the text boxes mentioned in parameter values section
    Then user is able to see all the inputted values
    When user clicks on Add button
    Then user is able to add the Record
    When user click on Clearance tab
    Then user should get navigated to clearance tab
    And user is able to see tab color and tab status bar color equal to red and Status equal to Incompleted
    When user clicks on Log tab
    Then user Log page related to that account should be displayed
    And user is able to see a log for Task equal to Clearance and Status equal to Assigned
    When user clicks on Worklist
    Then user is able to see All account in worklist
    When user search from same record from Search functionality
    Then user is able to see the record
    And user is able to see Clearance tab in RED color
