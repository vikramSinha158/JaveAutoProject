package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.utilities.CommonMethod;
import r1.pages.AccountDetailsPage;
import r1.pages.AccountPage;
import r1.pages.ApiConfigurationPage;
import r1.pages.BalanceLinkPage;
import r1.pages.CampaignPage;
import r1.pages.ClientMaintenance;
import r1.pages.CodeAndDesPage;
import r1.pages.HomePage;
import r1.pages.LattersPage;
import r1.pages.LogicProfilePage;
import r1.pages.MyTabsPage;
import r1.pages.PatientInfoPage;
import r1.pages.PaymentPage;
import r1.pages.ReminderPage;
import r1.pages.RightPartyConPage;
import r1.pages.ThirdPartyConnectionsPage;

public class PaymentHistoryStepDef {
	
	HomePage home;
	MyTabsPage tab;
	ReminderPage rem;
	AccountPage account;
	CommonMethod comm;
	AccountDetailsPage accoundel;
	PatientInfoPage patientInfo;
	RightPartyConPage rpcPage;
	BalanceLinkPage balancePage;
	PaymentPage payment;
	CodeAndDesPage code;
	ClientMaintenance cltMaintainance;
	CampaignPage campaign;
	LogicProfilePage logicProfile;
	ThirdPartyConnectionsPage ThirdPartyCon;
	ApiConfigurationPage apiConfig;
	LattersPage letters;
	String newPaymentAccount;

	/*Verify the payment posting using Agent input with Emerge*/
	
	@When("^user selects the reason as \"([^\"]*)\"$")
	public void user_selects_the_reason_as(String arg1) {
		payment.selectResonDrpdwn(arg1);
	}


	@Then("^user should be able to view the process tab with alert message \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_process_tab_with_alert_message(String arg1) {
		payment.verifySubmission(arg1);
	}

	@Then("^user is able to see the green check with submitted text on the Process tab$")
	public void user_is_able_to_see_the_green_check_with_submitted_text_on_the_Process_tab() {
		payment.verifyProcess();
		payment.verifySubmissionMsg();
		
	}
	
	/*Verify the Regular payment arrangement payment posting using Agent input with Emerge*/
	@When("^user selects check box of the account$")
	public void user_selects_check_box_of_the_account() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		account.fetchAccountNumber("NewPaymentAccount", "ASWIKEY");
		DatabaseConn.resultSet.next();
		newPaymentAccount = DatabaseConn.resultSet.getString("accountNum");
	   try {
		payment.dovetailCheck(newPaymentAccount);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	}


	@When("^user selects Total Installments from the drop down$")
	public void user_selects_Total_Installments_from_the_drop_down() {
		
		payment.randEMI();
	}

	@Then("^user is able to view the total Installments balance field should show the adjusted balance$")
	public void user_is_able_to_view_the_total_Installments_balance_field_should_show_the_adjusted_balance() {
	  payment.verifyInstallmentsBal(newPaymentAccount);
	}

	@Then("^user is able to view Payment per installment  field should show the installment amount$")
	public void user_is_able_to_view_Payment_per_installment_field_should_show_the_installment_amount() {
			payment.verifyPayPerInstallments();
	}

	@Then("^user is able to view the start date as current date$")
	public void user_is_able_to_view_the_start_date_as_current_date() {
		payment.verifyStartInstallmentDate();
	}

	@When("^user clicks on the Summary button$")
	public void user_clicks_on_the_Summary_button() {
		payment.clickDoveTailSummary();
	}
	
	// Verify the payment posting using Check payment arrangement mode with Emerge
	@When("^user Enters checking/Savings details$")
	public void user_Enters_checking_Savings_details() {
	   payment.enterChecking_SavingsDetails();
	}

	@Then("^User clicks on the checking Savings Button$")
	public void user_clicks_on_the_checking_Savings_Button() {
	    payment.clickCheckingBtn();
	}
}
