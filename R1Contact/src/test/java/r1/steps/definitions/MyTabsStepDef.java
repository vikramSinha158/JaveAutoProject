package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import cucumber.api.DataTable;
import java.sql.SQLException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;
import r1.pages.MyPaymentsPage;
import r1.pages.MyQueuePage;
import r1.pages.MyRequestsPage;


public class MyTabsStepDef {

	String myQueueAccount="";
	MyQueuePage myQueue;
	MyRequestsPage myMyrequest;
	String date_label = "Status Date";
	String mmSearchElment ="01";
	MyPaymentsPage myPayment;
	String myQueueFacility="";

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
		myQueue.clickDateStatus();
	}

	@When("^user enters values in \"([^\"]*)\" section out of (\\d+) to (\\d+) range with (.*) and user should be able to view entered inputs$")
	public void user_enters_values_in_section_out_of_to_range_with_and_user_should_be_able_to_view_entered_inputs(String search, int arg2, int arg3, String month, DataTable data) throws FileNotFoundException, IOException {
		myQueue.checkQueuePresence();
		List<List<String>> data1 =data.raw();
		for(int i=0;i<data1.size();i++) {
			myQueue.checkContainInMyQueue(search, date_label, data1.get(i).get(0));

		}

	}

	@When("^user enters value in \"([^\"]*)\" section out of (\\d+) to (\\d+) range with (.*)$")
	public void user_enters_value_in_section_out_of_to_range_with(String search, int arg2, int arg3, String day, DataTable dayData) throws FileNotFoundException, IOException {
		List<List<String>> data1 =dayData.raw();
		for(int i=0;i<data1.size();i++) {
			myQueue.checkContainInMyQueue(search, date_label, data1.get(i).get(0));
		}
	}


	@When("^user enters single digit into the \"([^\"]*)\" section and user should be able to view records filtered on the basis of entered digit$")
	public void user_enters_single_digit_into_the_section_and_user_should_be_able_to_view_records_filtered_on_the_basis_of_entered_digit(String search, DataTable data) {
		List<List<String>> rawData = data.raw();
		for(int i=0;i<rawData.size();i++) {
			try {
				myQueue.checkContainInMyQueue(search, date_label, rawData.get(i).get(0));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@When("^user enters double digits into the \"([^\"]*)\" section and user should be able to view records filtered on the basis of entered digits$")
	public void user_enters_double_digits_into_the_section_and_user_should_be_able_to_view_records_filtered_on_the_basis_of_entered_digits(String search, DataTable data) {
		List<List<String>> data1 =data.raw();
		for(int i=0;i<data1.size();i++) {
			try {
				myQueue.checkContainInMyQueue(search, date_label, data1.get(i).get(0));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@When("^user enters first digit in the \"([^\"]*)\" section and user should be able to view records filtered on the basis of the first digit\\.$")
	public void user_enters_first_digit_in_the_section_and_user_should_be_able_to_view_records_filtered_on_the_basis_of_the_first_digit(String search, DataTable data) {
		List<List<String>> data1 =data.raw();
		for(int i=0;i<data1.size();i++) {
			try {
				myQueue.checkContainInMyQueue(search, date_label, data1.get(i).get(0));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	@When("^user enters value in section and user should be able to view records in the descending order$")
	public void user_enters_value_in_section_and_user_should_be_able_to_view_records_in_the_descending_order() {
		myQueue.sendInStatusDate();
		myQueue.verifySearchDateOrder();
	}

	@Then("^user should be able to view entered inputs out of (\\d+) to (\\d+) range only$")
	public void user_should_be_able_to_view_entered_inputs_out_of_to_range_only(int arg1, int arg2) {

	}

	@When("^user press tab button on the keyboard over the Status Date search option$")
	public void user_press_tab_button_on_the_keyboard_over_the_Status_Date_search_option() {
		myQueue.pressTabInDateTxtField();
	}


	@Then("^user should be able to view the move from one section to the next$")
	public void user_should_be_able_to_view_the_move_from_one_section_to_the_next() {
		myQueue.verifyTabInDateStatus();
	}


	@Then("^user should be able to view the move from one section to the next in Payement$")
	public void user_should_be_able_to_view_the_move_from_one_section_to_the_next_in_Payement() {
		myPayment.veryfyTabInDuedate();

	}

	@When("^user runs the query  to fetch facility \"([^\"]*)\" Page$")
	public void user_runs_the_query_to_fetch_facility_Page(String queryKey) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		R1ContactCommonMethods.runQuery(queryKey);
		DatabaseConn.resultSet.next();
		myQueueFacility=DatabaseConn.resultSet.getString("aqFacility");
	}

	@When("^user double clicks on any of the column under owned account list except account number link$")
	public void user_double_clicks_on_any_of_the_column_under_owned_account_list_except_account_number_link() throws FileNotFoundException, IOException {
		myQueue.DoubleclickOnFacilityMyQueueTbl(myQueueFacility);
	}

	@Then("^user should be able to view the account information page after double click$")
	public void user_should_be_able_to_view_the_account_information_page_after_double_click() {
		myQueue.verifyAccountInfoPageHeader();
	}

	@When("^user clicks single time on any of the column under owned account list apart from account number$")
	public void user_clicks_single_time_on_any_of_the_column_under_owned_account_list_apart_from_account_number() throws FileNotFoundException, IOException {
		myQueue.singleClickOnFacilityMyQueueTbl(myQueueFacility);
	}

	@Then("^user should not be able to view the account information page$")
	public void user_should_not_be_able_to_view_the_account_information_page() {
		myQueue.verifyAccountInfoPageNotVisible();
	}

	@When("^User clicks on the \"([^\"]*)\" tab on tap page$")
	public void user_clicks_on_the_tab_on_tap_page(String arg1) {
		myPayment.clickMyPaymentTab();
		
	}

	@Then("^user should be able to view columns with headers$")
	public void user_should_be_able_to_view_columns_with_headers() {
	    myPayment.verifyPaymentHeaderSection();
	}

	@Then("^user should be able to view list of payment records$")
	public void user_should_be_able_to_view_list_of_payment_records() {
		myPayment.verifyPaymentsRows();
	}

	@When("^user enters value as inputs to the columns of My Payments page and should be able to view records filtered on the basis of values entered$")
	public void user_enters_value_as_inputs_to_the_columns_of_My_Payments_page_and_should_be_able_to_view_records_filtered_on_the_basis_of_values_entered() {
		myPayment.myPaymentsFilter();
	}
}
