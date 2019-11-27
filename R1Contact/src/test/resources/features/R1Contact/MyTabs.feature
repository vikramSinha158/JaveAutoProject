Feature: My Tabs scenarios
Background: user navigates to account home page
Given user is on R1Contact home page
When user click on My tabs link
And user is on My tab screen

@419576
Scenario: Verify the enter Arrow functionality
When User clicks the "My Queue" first tab on tab page
And user should be able to view list of owned accounts
When User clicks the "My Queue" first tab on tab page
And user runs the query  to fetch "MyQueueAccount" Page 
When user clicks on the account arrow button myQueue
Then user should be able to view the account information page after clicking arroe in myqueuePage

@419577
Scenario: Validate the functionality of Agent Queue screen that account number should work as a clickable hyperlink
When User clicks the "My Queue" first tab on tab page
And user runs the query  to fetch "MyQueueAccount" Page 
Then user should be able to view an account number as a hyperlink and click on account Number
Then user should be able to view the account information page after clicking arroe in myqueuePage

@419604
Scenario: Verify the Order of columns in records list
And user clicks on the "My Requests" fouth tab
Then user should be able to view the order of columns

@419583
Scenario: Verify the input value accept by the MM section in Date search
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters values in "MM" section out of 01 to 12 range
Then Then user should be able to view entered inputs out of 01 to 12 only

@419582
Scenario: Verify the TAB option on the Status Date filter box 
When User clicks the "My Queue" first tab on tab page
Then user should be able to view the move from one section to the next

@419605
Scenario: Verify My Request tab
And user clicks on the "My Requests" fouth tab

@419598
Scenario: Verify the TAB option on the Due Date filter box in Payement
And user clicks the "My Payments" second tab
Then user should be able to view the move from one section to the next in Payement

@419578
Scenario: Validate that double click on any column line should navigate to the Account page
When User clicks the "My Queue" first tab on tab page
And user runs the query  to fetch facility "MyQueueFacility" Page
When user double clicks on any of the column under owned account list except account number link
Then user should be able to view the account information page after double click

@419579
Scenario: Validate that double click on any column line should navigate to the Account page
When User clicks the "My Queue" first tab on tab page
And user runs the query  to fetch facility "MyQueueFacility" Page
When user clicks single time on any of the column under owned account list apart from account number
Then user should not be able to view the account information page

@419606
Scenario: Verify My Account History tab
And user clicks on the "My Account History" fith tab

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
	
