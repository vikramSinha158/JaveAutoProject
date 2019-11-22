Feature: Home and Reminder Verfication
Background: user navigates to account home page
Given user is on R1Contact home page

@419576
Scenario: Verify the enter Arrow functionality
When user click on My tabs link
And user is on My tab screen
When User clicks the "My Queue" first tab on tab page
And user should be able to view list of owned accounts
And user runs the query  to fetch "MyQueueAccount" Page 
When user clicks on the account arrow button myQueue
Then user should be able to view the account information page after clicking arroe in myqueuePage
