package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.MyQueuePage;

public class MyTabsStepDef extends BasePage {
	MyQueuePage queue;
	
	String date_label = "Status Date";
	
	
	@When("^When user clicks on the Status Date filter box$")
	public void when_user_clicks_on_the_Status_Date_filter_box() {
	   queue.clickStatusMonth();
	}


/*	@When("^user enters values in \"([^\"]*)\" section out of (\\d+) to (\\d+) range$")
	public void user_enters_values_in_section_out_of_to_range(String search, int arg2, int arg3) throws FileNotFoundException, IOException {
		queue.checkQueuePresence();
		queue.checkContainInMyQueue(search, date_label,mmSearchElment);
	}*/

	@When("^user enters values in \"([^\"]*)\" section out of (\\d+) to (\\d+) range with (.*) and user should be able to view entered inputs$")
	public void user_enters_values_in_section_out_of_to_range_with_and_user_should_be_able_to_view_entered_inputs(String search, int arg2, int arg3, String month, DataTable data) throws FileNotFoundException, IOException {
		List<List<String>> data1 =data.raw();
		for(int i=0;i<data1.size();i++) {
		queue.checkContainInMyQueue(search, date_label, data1.get(i).get(0));
		
		}
	}
	

	@Then("^Then user should be able to view entered inputs out of (\\d+) to (\\d+) only$")
	public void then_user_should_be_able_to_view_entered_inputs_out_of_to_only(int arg1, int arg2) {
	    queue.verifyOutput();
	}
	
	@When("^user enters value in \"([^\"]*)\" section out of (\\d+) to (\\d+) range with (.*)$")
	public void user_enters_value_in_section_out_of_to_range_with(String search, int arg2, int arg3, String day, DataTable dayData) throws FileNotFoundException, IOException {
		List<List<String>> data1 =dayData.raw();
		for(int i=0;i<data1.size();i++) {
		queue.checkContainInMyQueue(search, date_label, data1.get(i).get(0));
		}
	}


	@Then("^user should be able to view entered inputs out of (\\d+) to (\\d+) range only$")
	public void user_should_be_able_to_view_entered_inputs_out_of_to_range_only(int arg1, int arg2) {
	    
	}

}