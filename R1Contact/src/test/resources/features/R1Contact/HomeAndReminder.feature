Feature: Home and Reminder Verfication
Background: user navigates to account home page
Given user is on R1Contact home page

@408185
Scenario: Reminder_Verify the time field on Reminder setup window
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc
When Enter last name as "K" and press ENTER and List of Accounts should be displayed
When Pick one account from the list by click on Arrow
Then Verify the 'Set a reminder' icon 
When Click on the 'Set a reminder' icon
Then Verify Date box along with calendar icon,Time box,Note box and X-Cancel on remindar pop up window

#modified
@440384 @Test
Scenario: Reminder_Verify the default value for 'Time' field on the reminder setup window
When user mouse hover on SEARCH link and clicks on the account button
Then user should be navigate to account search page
When User fetch the "Account" for search and click for search button
Then User select the account by clicking on arrow button from account table
Then user should be navigate to account info page
When user clicks on the Set a reminders icon
Then a pop up window should be displayed
When user select the date 
And time as default 
And enter note in the notes text box
And user clicks on the reminder save button
When user navigate to home page 
Then verify the reminder created and user should see the reminder with default time 00:00

#modified
@440386 @Test
Scenario: Reminder_Verify the header in the 'Reminder' home screen
Given Verify the header in 'Reminders' section
And header should be in Caps
 
#modified
@440385 @Test
Scenario: Reminder_Verify the Create Reminder while Set a Reminder time
When user mouse hover on SEARCH link and clicks on the account button
Then user should be navigate to account search page
When User fetch the "Account" for search and click for search button
Then User select the account by clicking on arrow button from account table
Then user should be navigate to account info page
When user clicks on the Set a reminders icon
Then a pop up window should be displayed
When user select the date 
And select time "2:00 PM" from the dropdown
And enter note in the notes text box
And user clicks on the reminder save button
When user navigate to home page 
Then verify the reminder created time and reminder time should be same as it was created for

#modified
@440383 @Test
Scenario: Reminder_Verify the 'Create Reminder' on the date where a reminder is already exist
When user mouse hover on SEARCH link and clicks on the account button
Then user should be navigate to account search page
When User fetch the "Account" for search and click for search button
Then User select the account by clicking on arrow button from account table
Then user should be navigate to account info page
When user clicks on the Set a reminders icon
Then a pop up window should be displayed
When user select the date 
And select time "1:00 PM" from the dropdown
And enter note in the notes text box
And user clicks on the reminder save button
Then  An alert should be displayed with the below alert message.Reminder on account already exists

@440389 @Test
Scenario: Reminder_Verify the current balance sync functionality for Reminders based on +/- 7 days
Given Verify the header in 'Reminders' section
Then Compare Balance in Reminders at Home page and Balance on the account page corresponding to one account
 
@440387 @Test
Scenario: Reminder_Verify the filter option in 'Reminder' home screen
Given  Verify the header in 'Reminders' section
Then Verify the filter option in 'Reminders' list.
And Verify the type of Search box

@440388 @Test
Scenario: Reminder_Verify the sort option in 'Reminder' home screen.
Given Verify the Ascending sort function to sort reminder list
And Verify the Descending sort function to sort reminder list 


@419108 @homeReminder
Scenario: Home_Reminder_Verify functionality of Delete icon on Home page
Given user is on R1Contact home page
Then user should be able to see Agent Information
And Reminders list(If any reminder set by the agent)
And Home, My Tabs and other Tabs
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc
When Enter last name as "K" and press ENTER and List of Accounts should be displayed
When Pick one account from the list by click on Arrow
Then Verify the 'Set a reminder' icon 
When Click on the 'Set a reminder' icon
Then A pop up window should be displayed and user would be able to submit Reminder by filling required details
And Save reminder by hitting 'Save reminder' button
Given user is on home page
And User verifies delete icon in reminder panel

#modified
@440844 @Test
Scenario: Home_Reminder_Verify background color for Today's Reminder 
Given Verify the header in 'Reminders' section
Then user should be able to see Agent Information
And When verify today's remindertab color

@441789 @Test
Scenario: Home_Reminder_Verify functionality of Delete icon on Home page
When user mouse hover on SEARCH link and clicks on the account button
Then user should be navigate to account search page
When User fetch the "Account" for search and click for search button
Then User select the account by clicking on arrow button from account table
Then user should be navigate to account info page
When user clicks on the Set a reminders icon
Then a pop up window should be displayed
When user select the date 
And select time "2:00 PM" from the dropdown
And enter note in the notes text box
And user clicks on the reminder save button
When user navigate to home page 
Then user click on Delete Icon and particular row should be deleted from the Reminder section

@440856 
Scenario: Home_Reminder_Verify background color for Tomorrow's Reminder
When user mouse hover on SEARCH link and clicks on the account button
Then user should be navigate to account search page
When User fetch the "Account" for search and click for search button
Then User select the account by clicking on arrow button from account table
Then user should be navigate to account info page
When user clicks on the Set a reminders icon
Then a pop up window should be displayed
When user select tomorrow date 
And select time "2:00 PM" from the dropdown
And enter note in the notes text box
And user clicks on the reminder save button
When user navigate to home page 
Then verify the tomorrow reminder color








