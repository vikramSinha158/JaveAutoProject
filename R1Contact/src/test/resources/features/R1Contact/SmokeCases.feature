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
When User fetch the "Account" for search and click search button
Then User select the account by clicking on arrow button
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

@428412
Scenario: Submit a request from Account page
Given user is on R1Contact home page
Then user should be able to see Agent Information
And Reminders list(If any reminder set by the agent)
And Home, My Tabs and other Tabs
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "BillingAccount" and search for it
And user clicks "arrow" given at the end of the WHEATON PHYSICIAN SERVICES account row 
Then verify user account information on account info page
And user should be able to see the below tabs InsuranceNotes Transactions Payment History Letter Sent Encounter Information Account Activity
When user clicks on the New request icon
Then user should be navigate to create request page
And user is able to see the request code and its description
When user selects one code and user clicks on the Create button
Then user should be able to see the Request form.
When user enter all details
And user clicks on the Save button
Then user should be able to save the request successfully 

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

@428417 
Scenario: Verify Bill Statement
When user Click on 'Search' account link
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "BillingAccount" and search for it
And user clicks "arrow" given at the end of the WHEATON PHYSICIAN SERVICES account row 
Then verify user account information on account info page
When user clicks on the Bill statement link
Then an overlay window should be appeared 
When user clicks on the Pdf link
Then a pdf file should be open 

@428418
Scenario: Verify the update account status
When user Click on 'Search' account link
Then Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc 
When user selects the last name search criteria on account search page
And Enter last name as "K" and press ENTER and List of Accounts should be displayed
When user clicks on the "arrow" enter arrow 
Then user should be land on the account info page
When user enter the text into the status notes text box
And user clicks on the enter arrow
Then account notes should be updated with same note

@428494  @Test  
Scenario: Verify the payment posting using secure payment
When user Click on 'Search' account link
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it 
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Single credit card payment"
Then User should be land on the payment initial page.
When user enter amount,checks check box then and user clicks on Summary button
Then User land on the Summary tab 
When user Click on Enter payment button
Then User land on the payment Information tab And user is able to see secure payment radio button enabled 
And user is able to see guarantor info
When user clicks on the submit button
Then Payment should be submitted successfully

@428495  @Test
Scenario: Verify the payment posting using Agent input with revspring
When user Click on 'Search' account link
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it 
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Check payment arrangment"
Then User should be land on the payment initial page.
When user enter amount,checks check box then and user clicks on Summary button
And user Click on Enter payment button
Then User land on the payment Information tab 
And  user clicks on the Agent input radio button
And Then iFrame screen should be displayed
When user add payment information 
And click on submit button
Then a profile id should be generated 
When user copy that profile id 
And user paste the profile id into the profile text box
And user clicks on the submit button on payment information page
Then Payment should be submitted successfully for check payment arrangement

@428496 @Test
Scenario: Verify the payment posting using Agent input with Emerge
When user Click on 'Search' account link
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Credit card payment arrangment"
Then User should be land on the payment initial page.
When user enter amount,checks check box then and user clicks on Summary button
And user Click on Enter payment button
Then User land on the payment Information tab 
And  user clicks on the Agent input radio button
And Then iFrame screen should be displayed
When user add payment information 
And click on submit button
Then a profile id should be generated
When user copy that profile id
And user paste the profile id into the profile text box
And user clicks on the submit button on payment information page
Then Payment should be submitted successfully for check payment arrangement 

@428497 @Test
Scenario: Verify the Regular payment posting
When user Click on 'Search' account link
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it 
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Regular payment arrangment"
Then user should be land on the payment dovetail page.
And user enter amount,checks check box,select emi period then and user clicks on Summary button
Then user should be able to view the Summary tab 
And user Click on Enter payment button
Then user should be able to view the payment Information tab
When user clicks on the submit button on payment information
Then Payment should be processed successfully

@428498
Scenario: Verify 'the my queue tab under the my tabs'
When user click on My tabs link
And user is on My tab screen
When User clicks the "My Queue" first tab on tab page
And user clicks the "My Payments" second tab
And user clicks on the "My Reminders" third tab 
And user clicks on the "My Requests" fouth tab 
And user clicks on the "My Account History" fith tab


@435814
Scenario: Campaign_Verify the Add New Record overlay/pop window
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user clicks on Campaign
And user on Compaign Page
And user clicks on Add New Record
Then user should be able to view isBDQualified column in account table with Name , Insert and Cancel button  

@435816
Scenario: Campaign_Verify the Alter Campaign filter screen
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user clicks on Campaign
And user on Compaign Page
Then user should be able to view pop/Overlay window should be open with filters
And user can view One 'Select' condition, row ,type,Data Source, label. Operator,Value,Delete
And user can view add new button_Save button & Cancel button


@435815
Scenario: Campaign_Verify the Delete icon associate with rows
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user clicks on Campaign
And user on Compaign Page
And user clicks on Alter button
Then user should be able to view  Delete icon should not be displayed on the first two rows
And user can view that other than two rows delete icon should be dispalyed on all the where type rows


@435817
Scenario: Campaign_Verify the Edit order overlay/pop window
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user clicks on Campaign
And user on Compaign Page
Then user should be able to view Edit Order overlay/pop up window should be displayed 
Then user able to view Name of Logic,Insert at position dropdown,Ordering dropdown,Update button,Cancel button

@428500
Scenario: Verify Logic Profiles client maintenance settings
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user click on Logic Profile link
Then user should be able to view logic profile screen 
And user is able to access Add new record,
And   user is able to acces Alter/Create, 
And   user is able to acces Edit Details button
And   user is able to acces Delete icon 

@428503
Scenario: Verify the Letters under client maintenance settings
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user click on Letters Profile link
Then user should be able to view Letters profile screen 
And user is able to access Add new record in Latters page
And   user is able to acces Alter/Create in Latters page 
And   user is able to acces Edit Details button in Latters page
And   user is able to acces Toggle button in Latters page
And   user is able to acces Delete icon in Latters page 

@428511
Scenario: Verify Third Party Connections under the client maintenance settings
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user click on ThirdPartyConnections link
Then user should be able to view ThirdPartyConnections screen 
And user is able to access Add new record in ThirdPartyConnections page
And user is able to acces Edit Details button in ThirdPartyConnections page

@428501
Scenario: Verify API Configuration client maintenance settings
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen 
And user is able to access Add new record in click on APIconfiguration page
And user is able to acces Edit Details button in click on APIconfiguration page




