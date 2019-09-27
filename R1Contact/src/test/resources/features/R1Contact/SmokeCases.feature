Feature: Smoke Test Cases of R1contact
Background: user is able to naviagate to R1C home page
Given user is on R1 contact login page

@428404
Scenario: Verify the R1 Contact home page
Given user is on R1 contact login page
When user Land on the R1Contact application home page
Then user should be able to view Agent information
And user should be able  view Reminder list 
And user should be able to view R1 Contact logo

@428405
Scenario: Verify all links available on the home page are accessible
Given user is on the R1C home page
When user accessing all links available on header 
Then user should be able to access all the links