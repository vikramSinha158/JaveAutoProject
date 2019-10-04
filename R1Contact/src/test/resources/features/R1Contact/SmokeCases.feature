Feature: Smoke Test Cases of R1contact
Background: user is able to naviagate to R1C home page
Given user is on R1 contact login page

@428404
Scenario: Verify the R1 Contact home page
Given user is on R1 contact login page
When user Land on the R1Contact application home page
Then user should be able to view Agent information
And user should be able  view Reminder list 
And user should be able to view R1 Contact logo

@428405
Scenario: Verify all links available on the home page are accessible
Given user is on the R1C home page
When user accessing all links available on header 
Then user should be able to access all the links

@428406
Scenario: Verify 'Search' functionality
Given user is on R1 contact login page
When user mouse hover on search dropdown and clicks on the Account
Then user should be able to view the account search page with search criterias PhoneNumber MRN Account NumberAddress State Fname LastName Zip 

@428407
Scenario: Verify the 'Account Info' page
Given user is on R1 contact login page
And user mouse hover on search dropdown and clicks on the Account
Then user should be able to view the account search page with search criterias PhoneNumber MRN Account NumberAddress State Fname LastName Zip
When user selects the last name search criteria on account search page and user enters "K" in the search box
Then Then user should see the search results populated with number of retrieved accounts with last name "K"
When user clicks "arrow" given at the end of the row for the account
Then user should be able to see the account info page with the following details present on the screen Guarantor Patient Balances Account Information 

@428408
Scenario: Verify the tabs available on the account information page
Given user is on R1 contact login page
And user mouse hover on search dropdown and clicks on the Account
Then user should be able to view the account search page with search criterias PhoneNumber MRN Account NumberAddress State Fname LastName Zip
When user selects the last name search criteria on account search page and user enters "K" in the search box
Then Then user should see the search results populated with number of retrieved accounts with last name "K"
When user clicks "arrow" given at the end of the row for the account
Then Then user should be land on the account info page
And user should be able to see the below tabs InsuranceNotes Transactions Payment History Letter Sent Encounter Information Account Activity

@428411
Scenario: Set a Reminder from account page
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
Then user should be navigate back to the account page

@428409
Scenario: To Verify 'Right Party Contact (RPC) verified' in INBOUND CALLS page successfully
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc 
When user selects the last name search criteria on account search page
And user enters "K" alphabets in the last name search box
When Enter last name as "K" and press ENTER and List of Accounts should be displayed
When user clicks on the "inbound" enter arrow 
Then user should be navigate to right party verification page
When user clicks on the both Yes button
Then user should be land on the account info page

@428415
Scenario: To Verify 'Link Balance' Page opens successfully
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc 
When user selects the last name search criteria on account search page
And user enters "K" alphabets in the last name search box
When Enter last name as "K" and press ENTER and List of Accounts should be displayed
When user clicks on the "arrow" enter arrow 
Then user should be land on the account info page
When user clicks on the link balance link 
Then user should be navigate to the link balance page

@428414
Scenario: To Verify that updated 'Patient Account Information'
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc 
When user selects the last name search criteria on account search page
And user enters "K" alphabets in the last name search box
When Enter last name as "K" and press ENTER and List of Accounts should be displayed
When user clicks on the "arrow" enter arrow 
Then user should be land on the account info page
When user clicks on the Patient name link 
Then user should be avail to navigate on the patient info page
When user changes the patient info 
And user clicks on the save button
Then patient info should be updated successfully

@428416
Scenario: To Verify the "Encounter History Information"
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc 
When user selects the last name search criteria on account search page
And Enter last name as "K" and press ENTER and List of Accounts should be displayed
When user clicks on the "arrow" enter arrow 
Then user should be land on the account info page
When user clicks on the "Encounter Information" tab
Then Encounter Information tab should be expand
When user clicks on the Click to View link
Then Patient Diagnosis details pop window should get appeared

@428410
Scenario Outline: To check that Take ownership of an account working as expected.
Given user check the agent EmailID
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc 
And user fetch the "<QueryForJHouseAuccountNum>" get AccountNum having Jhouse owner
When user clicks on the arrow with Jhouse acccount number
When user clicks on the check arrow next to jhouse text in account information
Then account owner should be updated
And user is able to see their email prefix in place of jhous


Examples:
   |QueryForJHouseAuccountNum|
   |queryAccountJHouse|

