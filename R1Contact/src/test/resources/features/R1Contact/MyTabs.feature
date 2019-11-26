Feature: Home and Reminder Verfication
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
Scenario: Verify the enter Arrow functionality
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
When user press tab button on the keyboard over the Status Date search option
Then user should be able to view the move from one section to the next



