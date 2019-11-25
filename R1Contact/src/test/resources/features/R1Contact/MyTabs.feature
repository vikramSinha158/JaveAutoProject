Feature: My Tab cases
Background: user is on My tab screen
Given user is on R1Contact home page
When user click on My tabs link
And user is on My tab screen

@419583
Scenario: Verify the input value accept by the MM section in Date search
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters values in "MM" section out of 01 to 12 range
Then Then user should be able to view entered inputs out of 01 to 12 only
