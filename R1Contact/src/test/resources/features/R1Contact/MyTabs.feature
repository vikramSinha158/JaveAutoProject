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
And user enters values in "MM" section out of 01 to 12 range with <month> and user should be able to view entered inputs
	|13|
	|22| 

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
Scenario: Validate that Single clicking on any of the records line should not navigate to the search Account Information page except account number column
When User clicks the "My Queue" first tab on tab page
And user runs the query  to fetch facility "MyQueueFacility" Page
When user clicks single time on any of the column under owned account list apart from account number
Then user should not be able to view the account information page

@419606
Scenario: Verify My Account History tab
And user clicks on the "My Account History" fith tab

@419584
 Scenario: Verify the input value accept by the DD section in Date search
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters value in "DD" section out of 01 to 31 range with <Day> and user should be able to view entered inputs 
	|33|
	|99|

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
And user enters double digits into the "MM" section and user should be able to view records filtered on the basis of entered digits
	|01|
	|11|
	|12| 
	
@419588
Scenario: Verify single digit search in DD section
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters single digit into the "DD" section and user should be able to view records filtered on the basis of entered digit
 	|4|
 	|1|
 	|9|
 	
@419590
Scenario: Verify two digits search in DD section
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters single digit into the "DD" section and user should be able to view records filtered on the basis of entered digit
	|11|
	|28|
	|03|

@419591
Scenario: Verify filtering records functionality for YYYY section only
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters single digit into the "YYYY" section and user should be able to view records filtered on the basis of entered digit
	|2019|
	|20|
	|2018|
	|9|
	
@419592
Scenario: Verify the search by entering numbers in YYYY section
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters first digit in the "YYYY" section and user should be able to view records filtered on the basis of the first digit.
	|2|

@419593
Scenario: Verify the records display order
When User clicks the "My Queue" first tab on tab page
And When user clicks on the Status Date filter box
And user enters value in MM/DD/YYYY section and user should be able to view records in the descending order

