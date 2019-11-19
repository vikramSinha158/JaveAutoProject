Feature: Payment History
Background: user is able to naviagate to R1C home page
Given user is on R1 contact login page
When user Click on 'Search' account link

@445538
Scenario: Verify the Single Credit Card payment posting using Agent input with Emerge
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Credit card payment arrangment"
Then User should be land on the payment initial page.
When user enter amount,checks check box then and user clicks on Summary button
And user selects the reason as "PIF"
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
Then user should be able to view the process tab with alert message "Payment submission is in progress. Please do not leave this screen until all payments are completely submitted."
And user is able to see the green check with submitted text on the Process tab

@445540
Scenario: Verify the Regular payment arrangement payment posting using Agent input with Emerge
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it 
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Regular payment arrangment"
Then user should be land on the payment dovetail page.
When user selects check box of the account
And user selects Total Installments from the drop down
Then user is able to view the total Installments balance field should show the adjusted balance
And user is able to view Payment per installment  field should show the installment amount
And user is able to view the start date as current date
When user clicks on the Summary button  
Then user should be able to view the Summary tab
When user selects the reason as "PIF"
And user Click on Enter payment button
Then user should be land on the payment information tab
When user clicks on the submit button on payment information
Then user is able to see the green check with submitted text on the Process tab

@445681
Scenario: Verify the payment posting using Credit Card payment Arrangement mode with Emerge
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Credit card payment arrangment"
Then User should be land on the payment initial page.
When user enter amount,checks check box then and user clicks on Summary button
When user selects the reason as "PIF"
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
Then user should be able to view the process tab with alert message "Payment submission is in progress. Please do not leave this screen until all payments are completely submitted."
And user is able to see the green check with submitted text on the Process tab

@445679
Scenario: Verify the payment posting using Check payment arrangement mode with Emerge
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it 
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Check payment arrangment"
Then User should be land on the payment initial page.
When user enter amount,checks check box then and user clicks on Summary button
When user selects the reason as "PIF"
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
Then user should be able to view the process tab with alert message "Payment submission is in progress. Please do not leave this screen until all payments are completely submitted."
And user is able to see the green check with submitted text on the Process tab

@445682
Scenario: Verify the payment posting using Check payment arrangement mode with Emerge
And select accounts option for WHEATON PHYSICIAN SERVICES
And user fetch the "NewPaymentAccount" for payment posting and search for it 
When user selects the New payment account by clicking on the arrow button
And user Click on "Payment history" tab and pick one option from the drop down "Check payment arrangment"
Then User should be land on the payment initial page.
When user enter amount,checks check box then and user clicks on Summary button
When user selects the reason as "PIF"
And user Click on Enter payment button
Then User land on the payment Information tab 
And  user clicks on the Agent input radio button
And Then iFrame screen should be displayed
And User clicks on the checking Savings Button
When user Enters checking/Savings details
And click on submit button
Then a profile id should be generated 
When user copy that profile id 
And user paste the profile id into the profile text box
And user clicks on the submit button on payment information page
Then user should be able to view the process tab with alert message "Payment submission is in progress. Please do not leave this screen until all payments are completely submitted."
And user is able to see the green check with submitted text on the Process tab








