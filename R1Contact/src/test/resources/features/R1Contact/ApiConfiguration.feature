Feature: Smoke Test Cases of R1contact
Background: user is able to naviagate to R1C home page
Given user is on R1 contact login page
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page
And user select client "Borgess Health (Michigan)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen

@391470
Scenario: APIConfig_Verify the Edit Dialog 
And user is able to access Add new record in click on APIconfiguration page
Then user ishould be able to view API CONFIGURATION page with columns
Then user should be able to view Edit pop up with Details 

@391472
Scenario: APIConfig_Verify the Add New Record config window
When user clicks on Add New Record button 
Then user should be able to view a pop up with  with textboxes
Then user user clicks on the dropdown of ParameterName and should able to view the values of dropdown

@391473
Scenario: APIConfig_Verify the Add New Vendor setting window
When user clicks on Add New Record button
Then user should be able to view Add New Vendor pop up with below textboxes