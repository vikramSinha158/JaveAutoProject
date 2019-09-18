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

@408189 @homeReminder
Scenario: Reminder_Verify the header in the 'Reminder' home screen
Given Verify the header in 'Reminders' section
 
@408188 @homeReminder
Scenario: Reminder_Verify the 'Create Reminder' on the date where a reminder is already exist
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
And click on 'Set Reminder' on the same date where a reminder has already set
Then  An alert should be displayed with the below alert message.Reminder on account already exists

@408186 @homeReminder
Scenario: Reminder_Verify the default value for 'Time' field on the reminder setup window
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc
When Enter last name as "K" and press ENTER and List of Accounts should be displayed
When Pick one account from the list by click on Arrow
Then Verify the 'Set a reminder' icon 
When Click on the 'Set a reminder' icon
Then A pop up window should be displayed and user would be able to submit Reminder by filling required details
When Enter text in the Note box and save the reminder 
Then go to the home page and check created remindar date is 00.00 EST or not

@408196 @homeReminder
Scenario: Home_Reminder_Verify the current balance for reminders on Home page
Given Verify the header in 'Reminders' section
Then Compare Balance in Reminders at Home page and Balance on the account page corresponding to one account
 
@408191 @homeReminder
Scenario: Reminder_Verify the filter option in 'Reminder' home screen
Given  Verify the header in 'Reminders' section
Then Verify the filter option in 'Reminders' list.
And Verify the type of Search box
And Verify the Search box inputs




 
