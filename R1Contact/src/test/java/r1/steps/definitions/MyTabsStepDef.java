package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.MyQueuePage;

public class MyTabsStepDef extends BasePage {
	MyQueuePage queue;
	
	String date_label = "Status Date";
	String mmSearchElment ="01";
	
	@When("^When user clicks on the Status Date filter box$")
	public void when_user_clicks_on_the_Status_Date_filter_box() {
	   queue.clickStatusMonth();
	}


	@When("^user enters values in \"([^\"]*)\" section out of (\\d+) to (\\d+) range$")
	public void user_enters_values_in_section_out_of_to_range(String search, int arg2, int arg3) throws FileNotFoundException, IOException {
		queue.checkContainInMyQueue(search, date_label,mmSearchElment);
	}

	@Then("^Then user should be able to view entered inputs out of (\\d+) to (\\d+) only$")
	public void then_user_should_be_able_to_view_entered_inputs_out_of_to_only(int arg1, int arg2) {
	    
	}
}