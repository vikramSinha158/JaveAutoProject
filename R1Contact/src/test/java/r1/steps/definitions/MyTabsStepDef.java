package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;
import r1.pages.MyQueuePage;
import r1.pages.MyRequestsPage;


public class MyTabsStepDef {
	
	String myQueueAccount="";
	MyQueuePage myQueue;
	MyRequestsPage myMyrequest;
	String date_label = "Status Date";
	String mmSearchElment ="01";
	
	@When("^user should be able to view list of owned accounts$")
	public void user_should_be_able_to_view_list_of_owned_accounts() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		myQueue.verifyOwnedAccounts();
				
	}
	
	@When("^user runs the query  to fetch \"([^\"]*)\" Page$")
	public void user_runs_the_query_to_fetch_Page(String queryKey) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
	
		R1ContactCommonMethods.runQuery(queryKey);
		DatabaseConn.resultSet.next();
		myQueueAccount=DatabaseConn.resultSet.getString("aqAccountNum");
	
	}
	
	@When("^user clicks on the account arrow button myQueue$")
	public void user_clicks_on_the_account_arrow_button_myQueue() throws FileNotFoundException, IOException {
	  myQueue.clickOnAccountonmyQueueTbl(myQueueAccount);
	}
	

	@Then("^user should be able to view the account information page after clicking arroe in myqueuePage$")
	public void user_should_be_able_to_view_the_account_information_page_after_clicking_arroe_in_myqueuePage() {
		myQueue.verifyAccountInfoPage(myQueueAccount);
	    
	}
	
	@Then("^user should be able to view an account number as a hyperlink and click on account Number$")
	public void user_should_be_able_to_view_an_account_number_as_a_hyperlink_and_click_on_account_Number() throws FileNotFoundException, IOException {
		myQueue.checkHyperLinkForAccount(myQueueAccount);
	}
	
	@Then("^user should be able to view the order of columns$")
	public void user_should_be_able_to_view_the_order_of_columns() {
		myMyrequest.verifyHeaderOrder();
	}
	@When("^When user clicks on the Status Date filter box$")
	public void when_user_clicks_on_the_Status_Date_filter_box() {
		myQueue.clickStatusMonth();
	}


	@When("^user enters values in \"([^\"]*)\" section out of (\\d+) to (\\d+) range$")
	public void user_enters_values_in_section_out_of_to_range(String search, int arg2, int arg3) throws FileNotFoundException, IOException {
		myQueue.checkContainInMyQueue(search, date_label,mmSearchElment);
	}

	@Then("^Then user should be able to view entered inputs out of (\\d+) to (\\d+) only$")
	public void then_user_should_be_able_to_view_entered_inputs_out_of_to_only(int arg1, int arg2) {
	    
	}
}
