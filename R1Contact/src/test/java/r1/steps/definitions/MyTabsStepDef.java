package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;
import r1.pages.MyQueuePage;


public class MyTabsStepDef {
	
	String myQueueAccount="";
	MyQueuePage myQueue;
	
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
	

	   


}
