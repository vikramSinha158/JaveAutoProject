package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.HomePage;
import r1.pages.ReminderPage;

public class DefaultTimeStepDef extends BasePage{
	ReminderPage rem;
	HomePage home;
	
	@When("^Enter text in the Note box and save the reminder$")
	public void enter_text_in_the_Note_box_and_save_the_reminder() throws FileNotFoundException, IOException {
	  
		rem.setReminderNote("Make Remindar!");
		rem.submitReminder();
		rem.VerifyDuplicateReminderAlert();
	}
	
	@Then("^go to the home page and check created remindar date is (\\d+)\\.(\\d+) EST or not$")
	public void go_to_the_home_page_and_check_created_remindar_date_is_EST_or_not(int arg1, int arg2) throws FileNotFoundException, IOException {
		home.clicOnHome();
		home.switchHeaderFrame();
		home.changeVisibleDate();
		home.verifyDefaultTime();
	}

}
