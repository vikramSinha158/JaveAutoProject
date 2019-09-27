package r1.steps.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.HomePage;
import r1.pages.MyTabs;

public class SmokeCasesStepDef extends BasePage {

	HomePage home;
	MyTabs tab;

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
	public void user_should_be_able_to_access_all_the_links() {
		home.chechHomePageTab();
		home.switchHeaderFrame();
		home.clickOnMyTab();
		tab.verifyMyTab();
		
	  
	}
	
}
