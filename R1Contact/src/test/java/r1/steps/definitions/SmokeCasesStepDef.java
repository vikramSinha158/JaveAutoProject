package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.utilities.CommonMethod;
import r1.pages.AccountDetailsPage;
import r1.pages.AccountPage;
import r1.pages.BalanceLinkPage;
import r1.pages.CodeAndDesPage;
import r1.pages.ApiConfigurationPage;
import r1.pages.CampaignPage;
import r1.pages.ClientMaintenance;
import r1.pages.LattersPage;
import r1.pages.LogicProfilePage;
import r1.pages.ThirdPartyConnectionsPage;
import r1.pages.HomePage;
import r1.pages.MyTabsPage;
import r1.pages.PatientInfoPage;
import r1.pages.PaymentPage;
import r1.pages.ReminderPage;
import r1.pages.RightPartyConPage;

public class SmokeCasesStepDef extends BasePage {

	HomePage home;
	MyTabsPage tab;
	ReminderPage rem;
	AccountPage account;
	CommonMethod comm;
	AccountDetailsPage accoundel;
	PatientInfoPage patientInfo;
	RightPartyConPage rpcPage;
	BalanceLinkPage balancePage;
	PaymentPage payment;
	CodeAndDesPage code;
	ClientMaintenance cltMaintainance;
	CampaignPage campaign;
	LogicProfilePage logicProfile;
	ThirdPartyConnectionsPage ThirdPartyCon;
	ApiConfigurationPage apiConfig;
	LattersPage letters;
	String JHouseAccount;
	String AccountNum="AccountNumber";
	String billingAccount;
	String newPaymentAccount;
	String WheatonAccountNum="WheatonAccountNumber"; // added from vikram
	
	@Given("^user is on R(\\d+) contact login page$")
	public void user_is_on_R_contact_login_page(int arg) {
		OpenBrowser();
		home.switchHeaderFrame();
		home.changeVisibleDate();
	}

	@When("^user Land on the R(\\d+)Contact application home page$")
	public void user_Land_on_the_R_Contact_application_home_page(int arg) {
		home.verifyPageTitle();
	}

	@Then("^user should be able to view Agent information$")
	public void user_should_be_able_to_view_Agent_information() throws InterruptedException {
		home.verifyAgentName();

	}

	@Then("^user should be able  view Reminder list$")
	public void user_should_be_able_view_Reminder_list() {
		home.checkreminderList();
	}

	@Then("^user should be able to view R(\\d+) Contact logo$")
	public void user_should_be_able_to_view_R_Contact_logo(int arg1) {
		home.logoVerification();
	}

	/*
	 * Test Case 428405:Verify all links available on the home page are accessible
	 */
	@Given("^user is on the R(\\d+)C home page$")
	public void user_is_on_the_R_C_home_page(int arg1) {
		home.verifyPageTitle();

	}

	@When("^user accessing all links available on header$")
	public void user_accessing_all_links_available_on_header() {
		home.verifyHeaderTab();

	}

	@Then("^user should be able to access all the links$")
	public void user_should_be_able_to_access_all_the_links() throws InterruptedException {
		home.chechHomePageTab();
		home.switchHeaderFrame();
		home.verifyHeaderdropdownLinks();
		home.clickOnMyTab();
		tab.verifyMyTab();

	}

	/*
	 * Test Case 428406:Verify 'Search' functionality
	 */

	@When("^user mouse hover on search dropdown and clicks on the Account$")
	public void user_mouse_hover_on_search_dropdown_and_clicks_on_the_Account() {
		home.clickForSerachAccount();
	}

	@Then("^user should be able to view the account search page with search criterias PhoneNumber MRN Account NumberAddress State Fname LastName Zip$")
	public void user_should_be_able_to_view_the_account_search_page_with_search_criterias_PhoneNumber_MRN_Account_NumberAddress_State_Fname_LastName_Zip() {
		account.searchAccountlables();
		account.searchAccountTextField();

	}

	/*
	 * Test Case 428407: Verify the 'Account Info' page
	 */

	@When("^user selects the last name search criteria on account search page and user enters \"([^\"]*)\" in the search box$")
	public void user_selects_the_last_name_search_criteria_on_account_search_page_and_user_enters_in_the_search_box(
			String arg1) {
		account.enterLastNameTxt(arg1);
		account.lastNameSearchclk();

	}

	@Then("^Then user should see the search results populated with number of retrieved accounts with last name \"([^\"]*)\"$")
	public void then_user_should_see_the_search_results_populated_with_number_of_retrieved_accounts_with_last_name(
			String arg1) {
		account.verifyFirstCharForLastName(arg1);
	}

	@When("^user clicks \"([^\"]*)\" given at the end of the row for the account$")
	public void user_clicks_given_at_the_end_of_the_row_for_the_account(String arg1)
			throws FileNotFoundException, IOException {
		account.selectAndClickAccount(arg1, AccountNum);
	}

	@Then("^user should be able to see the account info page with the following details present on the screen Guarantor Patient Balances Account Information$")
	public void user_should_be_able_to_see_the_account_info_page_with_the_following_details_present_on_the_screen_Guarantor_Patient_Balances_Account_Information() {
		accoundel.verifyAccountInfoSection();
	}

	/*
	 * Test case: 428408 Verify the tabs available on the account information page
	 */
	@Then("^Then user should be land on the account info page$")
	public void then_user_should_be_land_on_the_account_info_page() {
		accoundel.verifyAccInfoAccNum(AccountNum);
	}

	@Then("^user should be able to see the below tabs InsuranceNotes Transactions Payment History Letter Sent Encounter Information Account Activity$")
	public void user_should_be_able_to_see_the_below_tabs_InsuranceNotes_Transactions_Payment_History_Letter_Sent_Encounter_Information_Account_Activity() {
		accoundel.displayPatientDtlTabs();
	}

	/*
	 * Test case: 428411 Set a Reminder from account page
	 */
	@Then("^user should be navigate back to the account page$")
	public void user_should_be_navigate_back_to_the_account_page() throws FileNotFoundException, IOException {
		rem.VerifyDuplicateReminderAlert();
		accoundel.verifyAccInfoAccNum(AccountNum);
	}

	/*
	 * Test case: 428409 To Verify 'Right Party Contact (RPC) verified' in INBOUND
	 * CALLS page successfully
	 */
	@When("^user selects the last name search criteria on account search page$")
	public void user_selects_the_last_name_search_criteria_on_account_search_page() {

		account.lastNameCheck();
	}

	@When("^user enters \"([^\"]*)\" alphabets in the last name search box$")
	public void user_enters_alphabets_in_the_last_name_search_box(String lastnameStart) {
		account.enterLastNameTxt(lastnameStart);
	}

	@Then("^user should see the search results last name start with \"([^\"]*)\" populated  number of retrieved accounts$")
	public void user_should_see_the_search_results_last_name_start_with_populated_number_of_retrieved_accounts(
			String lastnameStart) {
		account.lastNameSearchclk();
		account.verifyFirstCharForLastName(lastnameStart);
	}

	/*
	 * Test case: 428415 To Verify 'Link Balance' Page opens successfully
	 */
	@When("^user clicks on the \"([^\"]*)\" enter arrow$")
	public void user_clicks_on_the_enter_arrow(String inboundArrow) throws FileNotFoundException, IOException {

		account.selectAndClickAccount(inboundArrow, AccountNum);
	}

	@Then("^user should be navigate to right party verification page$")
	public void user_should_be_navigate_to_right_party_verification_page() {
		rpcPage.rpcPageDisplayed();

	}

	@When("^user clicks on the both Yes button$")
	public void user_clicks_on_the_both_Yes_button() {

		rpcPage.clickOnRpcBothYesBtn();
	}

	@Then("^user should be land on the account info page$")
	public void user_should_be_land_on_the_account_info_page() {
		accoundel.verifyAccInfoAccNum(AccountNum);

	}

	@When("^user clicks on the link balance link$")
	public void user_clicks_on_the_link_balance_link() {
		accoundel.balancelinkClk();

	}

	@Then("^user should be navigate to the link balance page$")
	public void user_should_be_navigate_to_the_link_balance_page() {
		balancePage.verifyBalanceLinkPage();
	}

	/*
	 * Test case: 428414 To Verify that updated 'Patient Account Information'
	 */
	@When("^user clicks on the Patient name link$")
	public void user_clicks_on_the_Patient_name_link() {
		accoundel.clickOnPatientLink();

	}

	@Then("^user should be avail to navigate on the patient info page$")
	public void user_should_be_avail_to_navigate_on_the_patient_info_page() {

		patientInfo.verifyPatientInfoPage();

	}

	@When("^user changes the patient info$")
	public void user_changes_the_patient_info() {
		patientInfo.enterPatientAddress2();
	}

	@When("^user clicks on the save button$")
	public void user_clicks_on_the_save_button() {
		patientInfo.SavePatientPage();
	}

	@Then("^patient info should be updated successfully$")
	public void patient_info_should_be_updated_successfully() {
		patientInfo.verifySuceesUpdate();
	}

	/*
	 * Test case: 428416 To Verify the "Encounter History Information"
	 */
	@When("^user clicks on the \"([^\"]*)\" tab$")
	public void user_clicks_on_the_tab(String EncounterInformation) {
		accoundel.clickPatientDtlTabs(EncounterInformation);
	}

	@Then("^Encounter Information tab should be expand$")
	public void encounter_Information_tab_should_be_expand() {
		accoundel.verifyEncounterTabExpand();
	}

	@When("^user clicks on the Click to View link$")
	public void user_clicks_on_the_Click_to_View_link() {
		accoundel.clkInView();
	}

	@Then("^Patient Diagnosis details pop window should get appeared$")
	public void patient_Diagnosis_details_pop_window_should_get_appeared() {
		accoundel.verifyPopUpInEncInfo();
	}

	/*
	 * Test case: 428410 To check that Take ownership of an account working as
	 * expected.
	 */
	@Then("^user fetch the \"([^\"]*)\" get AccountNum having Jhouse owner$")
	public void user_fetch_the_get_AccountNum_having_Jhouse_owner(String queryName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		account.JhouseOwnerAccountNum(queryName, "BOMCKEY");
		DatabaseConn.resultSet.next();
		JHouseAccount = DatabaseConn.resultSet.getString("accountNum");

	}

	@When("^user clicks on the arrow with Jhouse acccount number$")
	public void user_clicks_on_the_arrow_with_Jhouse_acccount_number() throws FileNotFoundException, IOException {
		account.enterAccNumForSearch(JHouseAccount);
		account.clickForAccSearch();
		account.clickOnArrowWithDbAccNum(JHouseAccount);

	}

	@Given("^user check the agent EmailID$")
	public void user_check_the_agent_EmailID() {

		home.agentEmailId();
	}

	@When("^user clicks on the check arrow next to jhouse text in account information$")
	public void user_clicks_on_the_check_arrow_next_to_jhouse_text_in_account_information() {

		accoundel.clkOnJHouseChckMark();
	}

	@Then("^account owner should be updated$")
	public void account_owner_should_be_updated() {

		accoundel.ownerEmail();
	}

	@Then("^user is able to see their email prefix in place of jhous$")
	public void user_is_able_to_see_their_email_prefix_in_place_of_jhous() {
		accoundel.verifyOwnerJHouseWithAgentName();

	}

	/*	 
	 * Test case: 428412 Submit a request from Account page
	 */
	@When("^user clicks on the New request icon$")
	public void user_clicks_on_the_New_request_icon() {
		accoundel.clickRequest();
	}


	@Then("^user should be navigate to create request page$")
	public void user_should_be_navigate_to_create_request_page() {
		accoundel.verifyRequestPage();
	}

	@Then("^user is able to see the request code and its description$")
	public void user_is_able_to_see_the_request_code_and_its_description() {
		accoundel.codeAndDes();
	}

	@When("^user selects one code and user clicks on the Create button$")
	public void user_selects_one_code_and_user_clicks_on_the_Create_button() {
		accoundel.createReq();	
	}

	@Then("^user should be able to see the Request form\\.$")
	public void user_should_be_able_to_see_the_Request_form() {
		code.chrtyRequestText();
	}

	@When("^user enter all details$")
	public void user_enter_all_details() {
		code.enterAddress();
	}

	@When("^user clicks on the Save button$")
	public void user_clicks_on_the_Save_button() {
		code.clickRequest();
	}

	@Then("^user should be able to save the request successfully$")
	public void user_should_be_able_to_save_the_request_successfully() {
		code.verifyReqMessage();

	}

	/*	
	 * Test Case 428417:Verify Bill Statement
	 */
	@When("^select accounts option for WHEATON PHYSICIAN SERVICES$")
	public void select_accounts_option_for_WHEATON_PHYSICIAN_SERVICES() {
		account.selectFacility("Wheaton Franciscan Healthcare (Wisconsin)");
		
	}
	
	@When("^user fetch the \"([^\"]*)\" and search for it$")
	public void user_fetch_the_and_search_for_it(String propkey) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		account.fetchAccountNumber(propkey, "ASWIKEY");
		DatabaseConn.resultSet.next();
		billingAccount = DatabaseConn.resultSet.getString("accountNum");
		account.searchAccount(billingAccount);
	}
	
	
	@When("^user clicks \"([^\"]*)\" given at the end of the WHEATON PHYSICIAN SERVICES account row$")
	public void user_clicks_given_at_the_end_of_the_WHEATON_PHYSICIAN_SERVICES_account_row(String arg1) throws FileNotFoundException, IOException {
		account.clickOnAccount(billingAccount);
		
	}
	
	@Then("^verify user account information on account info page$")
	public void verify_user_account_information_on_account_info_page() {
	   accoundel.verifyAccountWithDb(billingAccount);
	}
	
	@When("^user clicks on the Bill statement link$")
	public void user_clicks_on_the_Bill_statement_link() throws InterruptedException {
		accoundel.clickBillStatement();
	}

	@Then("^an overlay window should be appeared$")
	public void an_overlay_window_should_be_appeared() {
		accoundel.billReportWindow();
	}

	@When("^user clicks on the Pdf link$")
	public void user_clicks_on_the_Pdf_link() {
		accoundel.clickShowPDF();
	}

	@Then("^a pdf file should be open$")
	public void a_pdf_file_should_be_open() throws IOException {
		accoundel.verifyPDF();
	}

	/*	
	 * Test case: 428494  Verify the payment posting using secure payment
	 */
	
	@When("^user fetch the \"([^\"]*)\" for payment posting and search for it$")
	public void user_fetch_the_for_payment_posting_and_search_for_it(String propkey) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		account.fetchAccountNumber(propkey, "ASWIKEY");
		DatabaseConn.resultSet.next();
		newPaymentAccount = DatabaseConn.resultSet.getString("accountNum");
		account.searchAccount(newPaymentAccount);
	}

	@When("^user selects the New payment account by clicking on the arrow button$")
	public void user_selects_the_New_payment_account_by_clicking_on_the_arrow_button() throws FileNotFoundException, IOException {
		account.clickOnAccount(newPaymentAccount);
	}
	

	@When("^user Click on \"([^\"]*)\" tab and pick one option from the drop down \"([^\"]*)\"$")
	public void user_Click_on_tab_and_pick_one_option_from_the_drop_down(String arg1, String dropdownValue) throws InterruptedException {
		accoundel.clickPaymentHistory();
		accoundel.paymentDropdown(dropdownValue);
	}

	@Then("^User should be land on the payment initial page\\.$")
	public void user_should_be_land_on_the_payment_initial_page() {
		payment.verifiyInitialPage();
		
	   
	}

	@When("^user enter amount,checks check box then and user clicks on Summary button$")
	public void user_enter_amount_checks_check_box_then_and_user_clicks_on_Summary_button() {
	    payment.enterAndCheck(newPaymentAccount);
	   
	}

	@Then("^User land on the Summary tab$")
	public void user_land_on_the_Summary_tab() {
		payment.verifiySummaryPage(); 
	   
	}

	@When("^user Click on Enter payment button$")
	public void user_Click_on_Enter_payment_button() {
	    payment.clickPayment();
	   
	}

	@Then("^User land on the payment Information tab And user is able to see secure payment radio button enabled$")
	public void user_land_on_the_payment_Information_tab_And_user_is_able_to_see_secure_payment_radio_button_enabled() {
	    payment.verifiyPaymentInformation();
	    payment.checkIncludeCheckBox();
	    
	   
	}

	@Then("^user is able to see guarantor info$")
	public void user_is_able_to_see_guarantor_info() {
	    payment.verifiyGuarantorInfo();
	   
	}

	@When("^user clicks on the submit button$")
	public void user_clicks_on_the_submit_button() {
	    payment.clickSummarySubmit();
	   
	}

	@Then("^Payment should be submitted successfully$")
	public void payment_should_be_submitted_successfully() {
	   payment.verifiySuccessMessage(); 
	   
	}
	
	/*Test Case 428495:Verify the payment posting using Agent input with revspring*/
	
	@Then("^User land on the payment Information tab And user is able to see agent input radio button enabled$")
	public void user_land_on_the_payment_Information_tab_And_user_is_able_to_see_agent_input_radio_button_enabled() {
		  payment.verifiyPaymentInformation();
		  payment.agentInputCheckBox();
	    
	}

	@Then("^Then iFrame screen should be displayed$")
	public void then_iFrame_screen_should_be_displayed() {
	    payment.verifyRevspringFrame();
	    
	}

	@When("^user add payment information$")
	public void user_add_payment_information() {
	     payment.enterCardDetails();
	    
	}

	@When("^click on submit button$")
	public void click_on_submit_button() {
	    payment.submitProfile();
	    
	}

	@Then("^a profile id should be generated$")
	public void a_profile_id_should_be_generated() {
	    payment.verifyProfileID();
	    
	}

	@When("^user copy that profile id$")
	public void user_copy_that_profile_id() {
	   payment.copyProfileID();
	    
	}

	@When("^user paste the profile id into the profile text box$")
	public void user_paste_the_profile_id_into_the_profile_text_box() throws InterruptedException {
	    payment.sendProfileID();
	    
	}
	
	@When("^user clicks on the submit button on payment information page$")
	public void user_clicks_on_the_submit_button_on_payment_information_page() {
	   payment.submitPayment();
	 
	}


	@Then("^Payment should be submitted successfully for check payment arrangement$")
	public void payment_should_be_submitted_successfully_for_check_payment_arrangement() {
		payment.verifyProcess();
		payment.verifySubmittedMessage();
	   
	}
	
	/*	Test Case 428497:Verify the Regular payment posting*/
	
	@Then("^user should be land on the payment dovetail page\\.$")
	public void user_should_be_land_on_the_payment_dovetail_page() {
		payment.verifiyDovetailPage();
	}


	@Then("^user enter amount,checks check box,select emi perion then and user clicks on Summary button$")
	public void user_enter_amount_checks_check_box_select_emi_perion_then_and_user_clicks_on_Summary_button() throws InterruptedException {
		 payment.dovetailCheck();

	}

	@Then("^Then user should be land on the summary tab$")
	public void then_user_should_be_land_on_the_summary_tab() {
	   payment.verifiySummaryPage();
	}

	@Then("^user should be land on the payment information tab$")
	public void user_should_be_land_on_the_payment_information_tab() {
	  payment.verifiyPaymentInformation();
	}

	@When("^user clicks on the submit button on payment information$")
	public void user_clicks_on_the_submit_button_on_payment_information() {
		payment.submitPaymentInfo();
	}
	
	@Then("^Payment should be processed successfully$")
	public void payment_should_be_processed_successfully() {
	  payment.verifyProcess();
	}
	
	/*
	 *  IN303350
	 */
	/*
     * Test case: 428418 step to enter text in patient info page "
     */
     
     @When("^user enter the text into the status notes text box$")
     public void user_enter_the_text_into_the_status_notes_text_box() {

            accoundel.enterTextForNotes();
     }

/*
     * Test case: 428418 step to clicks on the enter arrow "
     */
     
     @When("^user clicks on the enter arrow$")
     public void user_clicks_on_the_enter_arrow() {
            accoundel.clkNotesBtn();
        
     }
     
     /*
     * Test case: 428418 step to verify notes in table  "
     */

     @Then("^account notes should be updated with same note$")
     public void account_notes_should_be_updated_with_same_note() {
            
            accoundel.verifyAccountNotesInNotesTable();
            
     }
     
     @When("^user click on My tabs link$")
     public void user_click_on_My_tabs_link() {
            home.clickOnMyTab();
        
     }


     @When("^user is on My tab screen$")
     public void user_is_on_My_tab_screen() {
            tab.verifyMyTab();
     }
     

 @When("^User clicks the \"([^\"]*)\" first tab on tab page$")
 public void user_clicks_the_first_tab_on_tab_page(String myQuery) {
      tab.clickOntabs(myQuery);
      tab.veryfyMyQueryTableHeader();
 }

 @When("^user clicks the \"([^\"]*)\" second tab$")
 public void user_clicks_the_second_tab(String myPayment) {
         tab.clickOntabs(myPayment);
      tab.veryfyMyPaymentTableHeader();
 }
 
 @When("^user clicks on the \"([^\"]*)\" third tab$")
 public void user_clicks_on_the_third_tab(String myReminder) {
        tab.clickOntabs(myReminder);
        tab.veryfyMyReminderTableHeader();
 }
 
 @When("^user clicks on the \"([^\"]*)\" fouth tab$")
 public void user_clicks_on_the_fouth_tab(String myRequest) {
        tab.clickOntabs(myRequest);
        tab.veryfyMyReminderTableHeader();
 }
 
 @When("^user clicks on the \"([^\"]*)\" fith tab$")
 public void user_clicks_on_the_fith_tab(String myAccount) {
        tab.clickOntabs(myAccount);
        tab.veryfyMyAccountTableHeader();
 }
 

 @Given("^When user hover on Administration & hover on Settings link & clicks on \"([^\"]*)\" link$")
 public void when_user_hover_on_Administration_hover_on_Settings_link_clicks_on_link(String clientMaintenace) throws InterruptedException {
     home.clickOnSubMenu(clientMaintenace);
 }


 @Then("^user is on Client Maintenance page$")
 public void user_is_on_Client_Maintenance_page() {
        cltMaintainance.verifyClientMaintenancePage();
 
 }

 @Then("^user select client \"([^\"]*)\"$")
 public void user_select_client(String BorgessHealth ) throws InterruptedException {
        cltMaintainance.selectClientMaintenanceList(BorgessHealth);
        cltMaintainance.waitForClientMaintenancePage();
 }

 @When("^user clicks on Campaign$")
 public void user_clicks_on_Campaign() {
        
        cltMaintainance.clickOnCampaignLink();
 }
 
 @When("^user on Compaign Page$")
 public void user_on_Compaign_Page() {
        campaign.verifyCampaignPage();
 }


 @When("^user clicks on Add New Record$")
 public void user_clicks_on_Add_New_Record() {
    campaign.clickOnCampaignAddRecord();
 }

 @Then("^user should be able to view isBDQualified column in account table with Name , Insert and Cancel button$")
 public void user_should_be_able_to_view_isBDQualified_column_in_account_table_with_Name_Insert_and_Cancel_button() {
     campaign.VerifyControlOnAddRecord();
 }
 
 @Then("^user should be able to view pop/Overlay window should be open with filters$")
 public void user_should_be_able_to_view_pop_Overlay_window_should_be_open_with_filters() {
        campaign.clickonAlterBtnCampaignTbl();
        campaign.verifyDialogFilterDispaly();
 }


 @Then("^user can view One 'Select' condition, row ,type,Data Source, label\\. Operator,Value,Delete$")
 public void user_can_view_One_Select_condition_row_type_Data_Source_label_Operator_Value_Delete() {
        campaign.verifyFilterHeader();
 }


 @Then("^user can view add new button_Save button & Cancel button$")
 public void user_can_view_add_new_button_Save_button_Cancel_button() {
     campaign.VerifyControlsFilterDialog();
 }
 
 @When("^user clicks on Alter button$")
 public void user_clicks_on_Alter_button() {
        campaign.clickonAlterBtnCampaignTbl();
        
 }


 @Then("^user should be able to view  Delete icon should not be displayed on the first two rows$")
 public void user_should_be_able_to_view_Delete_icon_should_not_be_displayed_on_the_first_two_rows() {
        campaign.verifyDialogFilterDispaly();
        campaign.verifyNotDisplayDeleteIcon();
 }
 
 @Then("^user can view that other than two rows delete icon should be dispalyed on all the where type rows$")
 public void user_can_view_that_other_than_two_rows_delete_icon_should_be_dispalyed_on_all_the_where_type_rows() {
    campaign.verifyDeleteIconOnFilter();
 }
 
 @Then("^user should be able to view Edit Order overlay/pop up window should be displayed$")
 public void user_should_be_able_to_view_Edit_Order_overlay_pop_up_window_should_be_displayed() {
        campaign.clickonEditBtnCampaignTbl();
        campaign.verifyComapignEditPopUp();
 }


 @Then("^user able to view Name of Logic,Insert at position dropdown,Ordering dropdown,Update button,Cancel button$")
 public void user_able_to_view_Name_of_Logic_Insert_at_position_dropdown_Ordering_dropdown_Update_button_Cancel_button() {
        campaign.verifyControlOnEditPopUp();
 }
 
 @When("^user click on Logic Profile link$")
 public void user_click_on_Logic_Profile_link() {
        cltMaintainance.clickOnLogicLink();
 }
 
 @Then("^user should be able to view logic profile screen$")
 public void user_should_be_able_to_view_logic_profile_screen() {
        
        logicProfile.verifyLogicProfilePage();
 }


 @Then("^user is able to access Add new record,$")
 public void user_is_able_to_access_Add_new_record() {
        logicProfile.verifyAddRecordLogicProfilePopUp();
 }

 @Then("^user is able to acces Alter/Create,$")
 public void user_is_able_to_acces_Alter_Create() {
        logicProfile.verifyAlterLogicFilterDispaly();
 }

 @Then("^user is able to acces Edit Details button$")
 public void user_is_able_to_acces_Edit_Details_button() {
        logicProfile.verifyLogicProfileEdit();
 }

 @Then("^user is able to acces Delete icon$")
 public void user_is_able_to_acces_Delete_icon() {
        logicProfile.verifyDeleteAlert();
 }
 
 @When("^user click on Letters Profile link$")
 public void user_click_on_Letters_Profile_link() {
        
        cltMaintainance.clickOnLettersLink();
 }


 @Then("^user should be able to view Letters profile screen$")
 public void user_should_be_able_to_view_Letters_profile_screen() {
        letters.verifyLettersPage();
     
 }

 @Then("^user is able to access Add new record in Latters page$")
 public void user_is_able_to_access_Add_new_record_in_Latters_page() {
        letters.verifyAddRecordLettersPopUp();
   
 }

 @Then("^user is able to acces Alter/Create in Latters page$")
 public void user_is_able_to_acces_Alter_Create_in_Latters_page() {
        
        letters.verifyAlterLettersFilterDispaly();
 }

 @Then("^user is able to acces Edit Details button in Latters page$")
 public void user_is_able_to_acces_Edit_Details_button_in_Latters_page() {
        letters.verifyLettersEdit();
   
 }

 @Then("^user is able to acces Toggle button in Latters page$")
 public void user_is_able_to_acces_Toggle_button_in_Latters_page() {
        letters.verifyToggleAlertLetter();
    
 }

 @Then("^user is able to acces Delete icon in Latters page$")
 public void user_is_able_to_acces_Delete_icon_in_Latters_page() {
        letters.verifyDeleteAlertLetter();
   
 }

 @When("^user click on ThirdPartyConnections link$")
 public void user_click_on_ThirdPartyConnections_link() {
        cltMaintainance.clickOnThirdPartyConLink();
 }


 @Then("^user should be able to view ThirdPartyConnections screen$")
 public void user_should_be_able_to_view_ThirdPartyConnections_screen() {
        ThirdPartyCon.verifyThirdPartyConPage();
 }

 @Then("^user is able to access Add new record in ThirdPartyConnections page$")
 public void user_is_able_to_access_Add_new_record_in_ThirdPartyConnections_page() {
        ThirdPartyCon.verifyAddRecordThirdPartyConPopUp();
 }

 @Then("^user is able to acces Edit Details button in ThirdPartyConnections page$")
 public void user_is_able_to_acces_Edit_Details_button_in_ThirdPartyConnections_page() {
        ThirdPartyCon.verifyThirdPartyConTblEdit();
 }
 
 @When("^user click on APIconfiguration link$")
 public void user_click_on_APIconfiguration_link() {
   cltMaintainance.clickOnApiConfigLink();
 }


 @Then("^user should be able to view click on APIconfiguration screen$")
 public void user_should_be_able_to_view_click_on_APIconfiguration_screen() {
        apiConfig.verifyApiConfigPage();
 }

 @Then("^user is able to access Add new record in click on APIconfiguration page$")
 public void user_is_able_to_access_Add_new_record_in_click_on_APIconfiguration_page() {
        apiConfig.verifyAddRecordApiConfigPopUp();
 }

 @Then("^user is able to acces Edit Details button in click on APIconfiguration page$")
 public void user_is_able_to_acces_Edit_Details_button_in_click_on_APIconfiguration_page() {
        apiConfig.verifyApiConfigTblEdit();
 }

	
}
