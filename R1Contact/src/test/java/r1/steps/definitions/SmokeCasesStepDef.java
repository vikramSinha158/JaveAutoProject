package r1.steps.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.utilities.CommonMethod;
import r1.pages.AccountPage;
import r1.pages.HomePage;
import r1.pages.MyTabs;

public class SmokeCasesStepDef extends BasePage {

	HomePage home;
	MyTabs tab;
	AccountPage account;
	CommonMethod comm;

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
		home.verifyOfficeDropdown();
		home.verifyInitiativesDropdown();
		home.verifyHelpDropdown();
		home.verifyadminDropdown();
		home.clickOnMyTab();
		tab.verifyMyTab();
		
	}
	
/*
 * 	Test Case 428406:Verify 'Search' functionality
 */
	@When("^user mouse hover on search dropdown and clicks on the Account$")
	public void user_mouse_hover_on_search_dropdown_and_clicks_on_the_Account() {
	   home.clickForSerachAccount();
	}

	@Then("^user should be able to view the account search page with search criterias PhoneNumber MRN Account NumberAddress State Fname LastName Zip$")
	public void user_should_be_able_to_view_the_account_search_page_with_search_criterias_PhoneNumber_MRN_Account_NumberAddress_State_Fname_LastName_Zip() {
		account.searchAccountlables();
		account.searchAccountTextField();
		//comm.handleBootStrapDropdown();
		
		
	}

	
}
