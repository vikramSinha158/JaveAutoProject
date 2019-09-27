package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.HomePage;
import r1.pages.ReminderPage;

public class TimeFieldOnReminderStepDef extends BasePage {

	ReminderPage rem;
	HomePage home;

	@Then("^Verify Date box along with calendar icon,Time box,Note box and X-Cancel on remindar pop up window$")
	public void verify_Date_box_along_with_calendar_icon_Time_box_Note_box_and_X_Cancel_on_remindar_pop_up_window()
			throws FileNotFoundException, IOException {

		rem.verifyRemindarPopup();

	}

}
