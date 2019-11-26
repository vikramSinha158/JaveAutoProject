Feature: My Tab cases
Background: user is on My tab screen
Given user is on R1Contact home page
When user click on My tabs link
And user is on My tab screen

@419583
Scenario: Verify the input value accept by the MM section in Date search
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters values in "MM" section out of 01 to 12 range with <month> and user should be able to view entered inputs
	|13|
	|22| 

@419584
 Scenario: Verify the input value accept by the DD section in Date search
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters value in "DD" section out of 01 to 31 range with <Day> and user should be able to view entered inputs 
	|20|
	|13|
	|25|


@419586
Scenario: Verify single digit search in MM section
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters values in "MM" section out of 01 to 12 range with <month> and user should be able to view entered inputs
	|1|
	|8|
	|3|

@419587
Scenario: Verify two digits search in MM section
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters values in "MM" section out of 01 to 12 range with <month> and user should be able to view entered inputs
	|01|
	|11|
	|12| 
	