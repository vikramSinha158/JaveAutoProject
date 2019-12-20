Feature: Smoke Test Cases of R1contact
Background: user is able to naviagate to R1C home page
Given user is on R1 contact login page
And When user hover on Administration & hover on Settings link & clicks on "Client Maintenance" link
Then user is on Client Maintenance page


@391470
Scenario: APIConfig_Verify the Edit Dialog
And user select client "Borgess Health (Michigan)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen 
And user is able to access Add new record in click on APIconfiguration page
Then user ishould be able to view API CONFIGURATION page with columns
Then user should be able to view Edit pop up with Details 

@391472
Scenario: APIConfig_Verify the Add New Record config window
And user select client "Borgess Health (Michigan)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen 
When user clicks on Add New Record button 
Then user should be able to view a pop up with  with textboxes
Then user user clicks on the dropdown of ParameterName and should able to view the values of dropdown

@391473
Scenario: APIConfig_Verify the Add New Vendor setting window
And user select client "Borgess Health (Michigan)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen 
When user clicks on Add New Record button
Then user should be able to view Add New Vendor pop up with below textboxes

@451885
Scenario: APIConfig_Verify the functionality of Back button on Add New Record pop up
And user select client "Borgess Health (Michigan)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen 
When user clicks on Add New Record button
When user clicks on Add New Vendor
Then user should be able to view Add New Vendor pop up

@451948
Scenario: APIConfig_Verify the functionality of Cancel button on Add New Record pop up
And user select client "Borgess Health (Michigan)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen 
When user clicks on Add New Record button
And clicks on Cancel button on Add New Record pop up
Then user shold successfully close the popup window

@451978 @Test
Scenario: Validate the configuration setting against client facility group: WHEATON FRANCISCAN HEALTHCARE and Edit the config setting once find difference into the UI
And user select client "Wheaton Franciscan Healthcare (Wisconsin)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen
When user match the UI configuration value from the excelsheet "WHEATON FRANCISCAN HEALTHCARE",if not match update the cell  

@451979 @Test
Scenario: Validate the configuration setting against client facility group: VIA CHRISTI HEALTH (KANSAS) and Edit the config setting once find difference into the UI
And user select client "Via Christi Health (Kansas)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen
When user match the UI configuration value from the excelsheet "VIA CHRISTI HEALTH",if not match update the cell 

@451980 @Test
Scenario: Validate the configuration setting against client facility group:BORGESS HEALTH (MICHIGAN) and Edit the config setting once find difference into the UI
And user select client "Borgess Health (Michigan)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen
When user match the UI configuration value from the excelsheet "BORGESS HEALTH",if not match update the cell 

@451981 @Test
Scenario: Validate the configuration setting against client facility group:CATHOLIC HEALTH EAST (NEW JERSEY) and Edit the config setting once find difference into the UI
And user select client "Catholic Health East (New Jersey)"
When user click on APIconfiguration link
Then user should be able to view click on APIconfiguration screen
When user match the UI configuration value from the excelsheet "CATHOLIC HEALTH EAST",if not match update the cell 

