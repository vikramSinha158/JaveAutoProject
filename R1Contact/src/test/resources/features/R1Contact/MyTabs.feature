Feature: Home and Reminder Verfication
Background: user navigates to account home page
Given user is on R1Contact home page
When user click on My tabs link
And user is on My tab screen

@419576
Scenario: Verify the enter Arrow functionality
When User clicks the "My Queue" first tab on tab page
And user should be able to view list of owned accounts
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
