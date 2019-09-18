package r1.steps.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.AccountDetailsPage;
import r1.pages.HomePage;
import r1.pages.ReminderPage;

public class HomeReminderStepDef {

	HomePage home;
	ReminderPage rem;
	AccountDetailsPage account;

	@Then("^user should be able to see Agent Information$")
	public void user_should_be_able_to_see_Agent_Information() throws InterruptedException {

		//home.switchHeaderFrame();
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
		rem.searchAccountlables();


	}

	@When("^Enter last name as \"([^\"]*)\" and press ENTER and List of Accounts should be displayed$")
	public void enter_last_name_as_and_press_ENTER_and_List_of_Accounts_should_be_displayed(String arg1) {
		rem.enterLastNameTxt(arg1);
		rem.lastNameSearchclk();
		rem.verifyFirstCharForLastName(arg1);
		
	}

	@When("^Pick one account from the list by click on Arrow$")
	public void pick_one_account_from_the_list_by_click_on_Arrow() {
		rem.selectAndClickAccount();

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
	public void a_pop_up_window_should_be_displayed_and_user_would_be_able_to_submit_Reminder_by_filling_required_details() {
		rem.IsreminderContainerDisplayed();
		rem.FillreminderDate();
		

	}

/*	@When("^Enter text in the Note box and save the reminder$")
	public void enter_text_in_the_Note_box_and_save_the_reminder() {
	    // Write code here that turns the phrase above into concrete actions
		rem.submitReminder();
	}
	*/

	@When("^click on 'Set Reminder' on the same date where a reminder has already set$")
	public void click_on_Set_Reminder_on_the_same_date_where_a_reminder_has_already_set() {
		rem.setReminderNote("Hello");
		rem.submitReminder();

	}

	@Then("^An alert should be displayed with the below alert message\\.Reminder on account already exists$")
	public void an_alert_should_be_displayed_with_the_below_alert_message_Reminder_on_account_already_exists() {

		rem.VerifyDuplicateReminderAlert();
	}

/*************************************@408196 Home_Reminder_Verify the current balance for reminders on Home page ****************************/

/*	@Then("^Pick any account from Reminders section and verify the Balance on the account page\\.$")
	public void pick_any_account_from_Reminders_section_and_verify_the_Balance_on_the_account_page() {
		
	}*/

	@Then("^Compare Balance in Reminders at Home page and Balance on the account page corresponding to one account$")
	public void compare_Balance_in_Reminders_at_Home_page_and_Balance_on_the_account_page_corresponding_to_one_account() {
	    home.verifyBalance();
	}

/***************************Test Case 408190:Reminder_Verify the filter option in 'Reminder' home screen*************************************/
	
	@Then("^Verify the filter option in 'Reminders' list\\.$")
	public void verify_the_filter_option_in_Reminders_list() {
	    
		home.verifyReminderSearch();
	}

	@Then("^Verify the type of Search box$")
	public void verify_the_type_of_Search_box() throws NoSuchFieldException {
		home.checkContainHometable();
	}

	@Then("^Verify the Search box inputs$")
	public void verify_the_Search_box_inputs() {
	    
	}
	
}
