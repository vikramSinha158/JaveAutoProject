package r1.steps.definitions;

import cucumber.api.java.en.Given;
import r1.commons.BasePage;
import r1.pages.HomePage;
import r1.pages.ReminderPage;

public class ReminderHeaderStepDef extends BasePage {

	HomePage home;
	ReminderPage rem;
	
	@Given("^user is on R1Contact home page$")
	public void user_is_on_R_Contact_home_page() {
		
		OpenBrowser();
		home.switchHeaderFrame();
		home.changeVisibleDate();
	}

	@Given("^Verify the header in 'Reminders' section$")
	public void verify_the_header_in_Reminders_section() {
	
		home.reminderHeader();
		
	}
	

}
