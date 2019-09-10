Feature: Home and Reminder Verfication
Background: user navigates to account home page
Given user is on R1Contact home page

@408189 @homeReminder
Scenario: Reminder_Verify the header in the 'Reminder' home screen

Given Verify the header in 'Reminders' section 



Scenario: Reminder_Verify the 'Create Reminder' on the date where a reminder is already exist
#Given user is on R1Contact home page
Then user should be able to see Agent Information
And Reminders list(If any reminder set by the agent)
And Home, My Tabs and other Tabs
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc
When Enter last name as "K" and press ENTER and List of Accounts should be displayed
When Pick one account from the list by click on Arrow
Then Account info page should be displayed having account information like Patient,Gurantor,Balance and Account Details etcs
Then Verify the 'Set a reminder' icon 
When Click on the 'Set a reminder' icon
Then A pop up window should be displayed and user would be able to submit Reminder by filling required details
When Enter text in the Note box 
And click on 'Set Reminder' on the same date where a reminder has already set
Then  An alert should be displayed with the below alert message.Reminder on account already exists 



