package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.utilities.CommonMethod;
import r1.pages.AccountDetailsPage;
import r1.pages.AccountPage;
import r1.pages.HomePage;
import r1.pages.ReminderPage;

public class HomeReminderStepDef {

	HomePage home;
	ReminderPage rem;
	AccountPage accountPage;
	AccountDetailsPage account;
	String AccountNum = "AccountNumber";
	String reminderAccount = "";
	String defaultTime = "12:00 AM"; // It will remain constant
	// String setTimeInReminder="";

	String setTimeInReminder = CommonMethod.readProperties("TimeToCreateReminder");

	@Then("^user should be able to see Agent Information$")
	public void user_should_be_able_to_see_Agent_Information() throws InterruptedException {

		home.verifyAgentName();

	}

	@Then("^Reminders list\\(If any reminder set by the agent\\)$")
	public void reminders_list_If_any_reminder_set_by_the_agent() {

		home.checkreminderList();
	}

	@Then("^Home, My Tabs and other Tabs$")
	public void home_My_Tabs_and_other_Tabs() {

		home.verifyHeaderTab();

	}

	@When("^user Click on 'Search' account link$")
	public void user_Click_on_Search_account_link() {

		home.clickForSerachAccount();
	}

	@Then("^Search account page should be displayed with searching criterias like\\.\\.Account Number, First Name, Last Name etc$")
	public void search_account_page_should_be_displayed_with_searching_criterias_like_Account_Number_First_Name_Last_Name_etc() {

		accountPage.searchAccountlables();
	}

	@When("^Enter last name as \"([^\"]*)\" and press ENTER and List of Accounts should be displayed$")
	public void enter_last_name_as_and_press_ENTER_and_List_of_Accounts_should_be_displayed(String arg1) {

		accountPage.enterLastNameTxt(arg1);
		accountPage.lastNameSearchclk();
		accountPage.verifyFirstCharForLastName(arg1);

	}

	@When("^Pick one account from the list by click on Arrow$")
	public void pick_one_account_from_the_list_by_click_on_Arrow() throws FileNotFoundException, IOException {

		accountPage.selectAndClickAccount("arrow", AccountNum);

	}

	@Then("^Verify the 'Set a reminder' icon$")
	public void verify_the_Set_a_reminder_icon() {

		rem.reminderIcon();
	}

	@When("^Click on the 'Set a reminder' icon$")
	public void click_on_the_Set_a_reminder_icon() {

		rem.ClickreminderIcon();
	}

	@Then("^A pop up window should be displayed and user would be able to submit Reminder by filling required details$")
	public void a_pop_up_window_should_be_displayed_and_user_would_be_able_to_submit_Reminder_by_filling_required_details()
			throws FileNotFoundException, IOException {
		rem.IsreminderContainerDisplayed();
		rem.FillreminderDate();

	}

	@Then("^Save reminder by hitting 'Save reminder' button$")
	public void save_reminder_by_hitting_Save_reminder_button() {

		rem.setReminderNote("Hello");
		rem.submitReminder();
	}

	@Then("^An alert should be displayed with the below alert message\\.Reminder on account already exists$")
	public void an_alert_should_be_displayed_with_the_below_alert_message_Reminder_on_account_already_exists()
			throws FileNotFoundException, IOException {

		rem.VerifyDuplicateReminderAlert();
	}

	/*************************************
	 * @408196 Home_Reminder_Verify the current balance for reminders on Home page
	 ****************************/

	@Then("^Compare Balance in Reminders at Home page and Balance on the account page corresponding to one account$")
	public void compare_Balance_in_Reminders_at_Home_page_and_Balance_on_the_account_page_corresponding_to_one_account() {

		home.verifyBalance();
	}

	/***************************
	 * Test Case 408190:Reminder_Verify the filter option in 'Reminder' home screen
	 *************************************/

	@Then("^Verify the filter option in 'Reminders' list\\.$")
	public void verify_the_filter_option_in_Reminders_list() {

		home.verifyReminderSearch();
	}

	@Then("^Verify the type of Search box$")
	public void verify_the_type_of_Search_box() throws NoSuchFieldException, FileNotFoundException, IOException {
		home.checkContainHometable("DateSearch", "Date");
		home.checkContainHometable("TimeSearch", "Time");
		home.checkContainHometable("FacilitySearch", "Facility");
		home.checkContainHometable("AccountSearch", "Account Number");
		home.checkContainHometable("NotesSearch", "Notes");
		home.checkContainHometable("BalanceSearch", "Balance");
	}

	/***********************************************
	 * Test Case 408191*:Reminder_Verify the sort option in 'Reminder' home screen
	 *********************************************/

	@Given("^Verify the Ascending sort function to sort reminder list$")
	public void verify_the_Ascending_sort_function_to_sort_reminder_list() {

		home.sortingAscColumnHead("Account Number");
		home.sortingAscColumnHead("Facility");
		// home.sortingAscColumnHead("Notes");
		// home.sortingAscColumnHead("Balance");

	}

	@Given("^Verify the Descending sort function to sort reminder list$")
	public void verify_the_Descending_sort_function_to_sort_reminder_list() {

		home.sortingDescColumnHeader("Account Number");
		home.sortingDescColumnHeader("Facility");
		// home.sortingDescColumnHeader("Notes");
		// home.sortingDescColumnHeader("Balance");
	}

	/***************************************************
	 * Test Case 419087:Reminder_Verify the Create Reminder while Set a Reminder
	 * time
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 ****************************************/

	@Then("^very reminder has been created or not$")
	public void very_reminder_has_been_created_or_not() throws FileNotFoundException, IOException {

		rem.VerifyDuplicateReminderAlert();
		home.clicOnHome();
		home.switchHeaderFrame();
		home.reminderCreatedOrNot();
	}

	/*******************************************************
	 * Test Case 419108:Home_Reminder_Verify functionality of Delete icon on Home
	 * page
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 **********************************/

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws FileNotFoundException, IOException {

		rem.VerifyDuplicateReminderAlert();
		home.clicOnHome();
		home.switchHeaderFrame();
	}

	@Given("^User verifies delete icon in reminder panel$")
	public void user_verifies_delete_icon_in_reminder_panel() throws InterruptedException {

		home.verifyDeletingIconPoulating();
	}

	/**************************************************************
	 * Test Case 419105:Home_Reminder_Verify background color for Today's Reminder
	 ******************************************/

	@Given("^When verify today's remindertab color$")
	public void when_verify_today_s_remindertab_color() {

		home.todayTabColor("rgba(11, 92, 207, 1)");
	}

	@When("^user mouse hover on SEARCH link and clicks on the account button$")
	public void user_mouse_hover_on_SEARCH_link_and_clicks_on_the_account_button() {

		home.clickForSerachAccount();

	}

	@Then("^user should be navigate to account search page$")
	public void user_should_be_navigate_to_account_search_page() {
		accountPage.searchAccountlables();
	}

	@When("^User fetch the \"([^\"]*)\" for search and click for search button$")
	public void user_fetch_the_for_search_and_click_for_search_button(String queryKey)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		accountPage.fetchAccountNumber(queryKey, "BOMCKEY");
		DatabaseConn.resultSet.next();
		reminderAccount = DatabaseConn.resultSet.getString("AccountNum");
		accountPage.searchAccount(reminderAccount);

	}

	@Then("^User select the account by clicking on arrow button from account table$")
	public void user_select_the_account_by_clicking_on_arrow_button_from_account_table() {
		try {
			accountPage.clickOnAccount(reminderAccount);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Then("^user should be navigate to account info page$")
	public void user_should_be_navigate_to_account_info_page() {
		account.verifyAccountInfoSection();
	}

	@When("^user clicks on the Set a reminders icon$")
	public void user_clicks_on_the_Set_a_reminders_icon() {
		rem.reminderIcon();
		rem.ClickreminderIcon();
	}

	@Then("^a pop up window should be displayed$")
	public void a_pop_up_window_should_be_displayed() {
		rem.IsreminderContainerDisplayed();
	}

	@When("^user select the date$")
	public void user_select_the_date() throws FileNotFoundException, IOException {
		rem.FillOnlyDateOnReminder();
	}

	@When("^time as default$")
	public void time_as_default() {
		System.out.println("");
	}

	@When("^select time \"([^\"]*)\" from the dropdown$")
	public void select_time_from_the_dropdown(String timetoSelect) throws InterruptedException {
		rem.selectTimeFromReminder(timetoSelect);

	}

	@When("^enter note in the notes text box$")
	public void enter_note_in_the_notes_text_box() {
		rem.setReminderNote("Make Remindar!");

	}

	@When("^user clicks on the reminder save button$")
	public void user_clicks_on_the_reminder_save_button() {
		rem.submitReminder();
	}

	@When("^user navigate to home page$")
	public void user_navigate_to_home_page() {
		home.clicOnHome();
		home.switchHeaderFrame();
		home.changeVisibleDate();

	}

	@Then("^verify the reminder created and user should see the reminder with default time (\\d+):(\\d+)$")
	public void verify_the_reminder_created_and_user_should_see_the_reminder_with_default_time(int arg1, int arg2)
			throws FileNotFoundException, IOException, InterruptedException {
		home.verifyReminderTimeInHome(reminderAccount, defaultTime);
	}

	@Then("^verify the reminder created time and reminder time should be same as it was created for$")
	public void verify_the_reminder_created_time_and_reminder_time_should_be_same_as_it_was_created_for()
			throws FileNotFoundException, IOException, InterruptedException {
		home.verifyReminderTimeInHome(reminderAccount, setTimeInReminder);
	}

	@Given("^header should be in Caps$")
	public void header_should_be_in_Caps() {
		home.verifyReminderHeaderCaps();
	}

	@Then("^user click on Delete Icon and particular row should be deleted from the Reminder section$")
	public void user_click_on_Delete_Icon_and_particular_row_should_be_deleted_from_the_Reminder_section()
			throws FileNotFoundException, IOException, InterruptedException {
		home.verifyDeleteReminderHome(reminderAccount, setTimeInReminder);
	}

	/*
	 * verify_the_reminder_created_time_and_reminder_time_should_be_same_as_it_was_created_for
	 * 
	 */

	@When("^user select tomorrow date$")
	public void user_select_tomorrow_date() throws FileNotFoundException, IOException {
		rem.fillTomorrowReminder();
	}

	@Then("^verify the tomorrow reminder color$")
	public void verify_the_tomorrow_reminder_color() {
		home.searchremByAccNUm(reminderAccount);
		home.verifyTomRemCol();
	}

	/*
	 * Home_Reminder_Verify background color for expired Reminder
	 */
	@Then("^verify the expired reminder color$")
	public void verify_the_expired_reminder_color()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		R1ContactCommonMethods.runQuery("ExpiredReminder");
		DatabaseConn.resultSet.next();
		reminderAccount = DatabaseConn.resultSet.getString("remAccountNum");
		if (reminderAccount == null) {
			Assert.assertTrue("No Expired reminder is present for this user!", false);
		}
		home.searchremByAccNUm(reminderAccount);
		home.verifyExpiredRem();

	}

	/*
	 * Home_Verify Agent Information as per Role provided
	 */
	@When("^user verifies user profile information display below the Reminder panel$")
	public void user_verifies_user_profile_information_display_below_the_Reminder_panel() {
		home.verifyAgentHeader();
	}


	@Then("^user should be able to view all column names should populating with values$")
	public void user_should_be_able_to_view_all_column_names_should_populating_with_values() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException {
		home.verifyAgentInformation();

	}
	
}
