package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.AccountDetailsPage;
import r1.pages.AccountPage;
import r1.pages.HomePage;
import r1.pages.ReminderPage;

public class HomeReminderStepDef {

	HomePage home;
	ReminderPage rem;
	AccountPage accountPage;
	AccountDetailsPage account;

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

		accountPage.selectAndClickAccount("arrow");

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

		home.checkContainHometable();
	}

	/***********************************************
	 * Test Case 408191*:Reminder_Verify the sort option in 'Reminder' home screen
	 *********************************************/

	@Given("^Verify the Ascending sort function to sort reminder list$")
	public void verify_the_Ascending_sort_function_to_sort_reminder_list() {

		home.sortingAscColumnHead();

	}

	@Given("^Verify the Descending sort function to sort reminder list$")
	public void verify_the_Descending_sort_function_to_sort_reminder_list() {

		home.sortingDescColumnHeader();
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

}
