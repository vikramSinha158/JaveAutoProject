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
import r1.pages.HomePage;
import r1.pages.MyTabsPage;
import r1.pages.PatientInfoPage;
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
	String JHouseAccount;

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
		account.selectAndClickAccount(arg1);
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
		accoundel.verifyAccInfoAccNum();
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
		accoundel.verifyAccInfoAccNum();
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

		account.selectAndClickAccount(inboundArrow);
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
		accoundel.verifyAccInfoAccNum();

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

		account.runQueryTranServer(queryName);
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

}
