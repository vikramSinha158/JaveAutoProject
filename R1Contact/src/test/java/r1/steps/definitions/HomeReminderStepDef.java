package r1.steps.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.utilities.CommonMethods;
import r1.pages.HomePage;
import r1.pages.ReminderPage;

public class HomeReminderStepDef extends BasePage {
	
	HomePage home;
	ReminderPage rem;

	/*@Given("^user is on R1Contact home page$")
	public void user_is_on_R_Contact_home_page() {
		OpenBrowser();
		
	}*/
	@Then("^user should be able to see Agent Information$")
	public void user_should_be_able_to_see_Agent_Information() throws InterruptedException {
		home.switchHeaderFrame();
		home.verifyAgentName();
	}

	@Then("^Reminders list\\(If any reminder set by the agent\\)$")
	public void reminders_list_If_any_reminder_set_by_the_agent() {
	
		home.checkreminderList();
		//home.defaultFrame();
	    
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
		
		 rem.searchAccountlables();rem.lastNameSearchclk();
		rem.m1();
	    
	}
	@When("^Enter last name as \"([^\"]*)\" and press ENTER and List of Accounts should be displayed$")
	public void enter_last_name_as_and_press_ENTER_and_List_of_Accounts_should_be_displayed(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Enter last name as \"([^\"]*)\" and press ENTER$")
	public void enter_last_name_as_and_press_ENTER(String arg1) {
	  
		rem.enterLastNameTxt("k");
	}

	@Then("^List of Accounts should be displayed whose last name having \"([^\"]*)\"$")
	public void list_of_Accounts_should_be_displayed_whose_last_name_having(String arg1) {
	  
	    
	}

	@When("^Pick one account from the list by click on Arrow$")
	public void pick_one_account_from_the_list_by_click_on_Arrow() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Account info page should be displayed having account information like Patient,Gurantor,Balance and Account Details etcs$")
	public void account_info_page_should_be_displayed_having_account_information_like_Patient_Gurantor_Balance_and_Account_Details_etcs() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Verify the 'Set a reminder' icon$")
	public void verify_the_Set_a_reminder_icon() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Click on the 'Set a reminder' icon$")
	public void click_on_the_Set_a_reminder_icon() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^A pop up window should be displayed and user would be able to submit Reminder by filling required details$")
	public void a_pop_up_window_should_be_displayed_and_user_would_be_able_to_submit_Reminder_by_filling_required_details() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Enter text in the Note box$")
	public void enter_text_in_the_Note_box() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^click on 'Set Reminder' on the same date where a reminder has already set$")
	public void click_on_Set_Reminder_on_the_same_date_where_a_reminder_has_already_set() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^An alert should be displayed with the below alert message\\.Reminder on account already exists$")
	public void an_alert_should_be_displayed_with_the_below_alert_message_Reminder_on_account_already_exists() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
}
