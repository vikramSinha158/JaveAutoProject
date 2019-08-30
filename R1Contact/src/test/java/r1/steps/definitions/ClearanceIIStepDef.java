package r1.steps.definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;

public class ClearanceIIStepDef extends BasePage{


	@Given("^user is on R(\\d+)Contact home page$")
	public void user_is_on_R_Contact_home_page(int arg1) {
		OpenBrowser();
	}
	
	@When("^user close application$")
	public void user_close_application() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
