Feature: Smoke Test Case
Background: user navigates to account home page
Given user is on R1Contact home page

@428409
Scenario: To Verify 'Right Party Contact (RPC) verified' in INBOUND CALLS page successfully
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc 
When user selects the last name search criteria on account search page
And user enters "K" alphabets in the last name search box
Then user should see the search results last name start with "K" populated  number of retrieved accounts
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
Then user should see the search results last name start with "K" populated  number of retrieved accounts
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
Then user should see the search results last name start with "K" populated  number of retrieved accounts
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
And user enters "K" alphabets in the last name search box
Then user should see the search results last name start with "K" populated  number of retrieved accounts
When user clicks on the "arrow" enter arrow 
Then user should be land on the account info page
When user clicks on the "Encounter Information" tab
Then Encounter Information tab should be expand
When user clicks on the Click to View link
Then Patient Diagnosis details pop window should get appeared

