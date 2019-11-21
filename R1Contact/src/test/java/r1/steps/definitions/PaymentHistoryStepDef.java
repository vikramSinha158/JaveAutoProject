package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.R1ContactCommonMethods;
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
	String paymentAccount;

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
	
	@Then("^user is able to view the start as one month after of current date$")
	public void user_is_able_to_view_the_start_as_one_month_after_of_current_date() {
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
	
	//viks
	  
	  @When("^select accounts option for Catholic Health East$")
	  public void select_accounts_option_for_Catholic_Health_East() {

		  account.selectFacility("Catholic Health East (New Jersey)");

	  }
	  
	  @When("^user runs the query  to fetch \"([^\"]*)\" for PaymentPosting$")
	  public void user_runs_the_query_to_fetch_for_PaymentPosting(String querykey) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
	      
		  R1ContactCommonMethods.runQuery(querykey);
	      account.fetchAccountNumber(querykey, "LLNJKEY");
	      DatabaseConn.resultSet.next();
	      paymentAccount = DatabaseConn.resultSet.getString("AccountNum");
	    
	  }

	  @When("^user enters the fetched account number in Account Number textbox & user clicks on the search icon$")
	  public void user_enters_the_fetched_account_number_in_Account_Number_textbox_user_clicks_on_the_search_icon() {
	      account.searchAccount(paymentAccount);
	     
	  }

	  @When("^user selects the payment account by clicking on the arrow button$")
	  public void user_selects_the_payment_account_by_clicking_on_the_arrow_button() throws FileNotFoundException, IOException {
	      account.clickOnAccount(paymentAccount);
	 }
	  
	  @When("^user enters amount equal or less than balance,checks check box then and user clicks on Summary button$")
	  public void user_enters_amount_equal_or_less_than_balance_checks_check_box_then_and_user_clicks_on_Summary_button() {
	         payment.enterAndCheck(paymentAccount);
	         payment.clickSummaryBtn();
	  }
	  
	  @Then("^User land on the payment Information tab And user clicks on the Agent input radio button$")
	  public void user_land_on_the_payment_Information_tab_And_user_clicks_on_the_Agent_input_radio_button() {
	      payment.verifiyPaymentInformation();
	      payment.agentInputRadioBtn();
	  }
	  
	  @When("^user selects the reason as PIF$")
	  public void user_selects_the_reason_as_PIF() throws InterruptedException {
	      payment.selectReasonForPaySummary();
	  }
	  
	  @Then("^user should be able to view the iFrame screen for revspring$")
	  public void user_should_be_able_to_view_the_iFrame_screen_for_revspring() {

	      payment.revspringFrame();
	      
	  }
	  
	  @Then("^user is able fill all detail in revSpring frame$")
	  public void user_is_able_fill_all_detail_in_revSpring_frame() throws InterruptedException {
	      payment.fillRevSpringCardDetails();
	  }
	  
	  @Then("^user is able to view the confirmation message 'Your payment profile has been saved'$")
	  public void user_is_able_to_view_the_confirmation_message_Your_payment_profile_has_been_saved() {
	      payment.veryfyReVspringSuccesMsg();
	  }

	  @Then("^user is able to view Profile ID with the Profile info$")
	  public void user_is_able_to_view_Profile_ID_with_the_Profile_info() {
	     payment.veryfyReVspringProfileID();
	  }

	  @When("^user selects and copy profile id$")
	  public void user_selects_and_copy_profile_id() {
	     payment.revSpringcopyProfileID();
	  }

	  @When("^user pastes the profile id into the profile text box$")
	  public void user_pastes_the_profile_id_into_the_profile_text_box() throws InterruptedException {
	     payment.sendrevSpringProfileID();
	  }

	  @When("^user clicks on the revspring submit button$")
	  public void user_clicks_on_the_revspring_submit_button() {
	      payment.clickOnLastSubmitBtnForRecSpring();
	  }
	  
	  @When("^user is able to see the green check with submitted text on the Process tab for revspring$")
	  public void user_is_able_to_see_the_green_check_with_submitted_text_on_the_Process_tab_for_revspring() {
		  payment.verifySubmittedMsgForRevSpring();
	  }
	  
	  @When("^user selects check box of the for revspring account$")
	  public void user_selects_check_box_of_the_for_revspring_account() throws InterruptedException {
	      payment.dovetailCheck(paymentAccount);
	  }
	  
	  @When("^user selects EMI period from the revspring drop down$")
	  public void user_selects_EMI_period_from_the_revspring_drop_down() {
	      payment.randEMI();
	  }
	  
	  @Then("^user is able to view the total Installments balance field should show the adjusted balance revSpring$")
	  public void user_is_able_to_view_the_total_Installments_balance_field_should_show_the_adjusted_balance_revSpring() {
	      payment.verifyInstallmentsBal(paymentAccount);
	  }
	  
	  @Then("^user is able to view the start date as next month date same as today date$")
	  public void user_is_able_to_view_the_start_date_as_next_month_date_same_as_today_date() {
	      payment.verifyStartInstallmentDate();
	  }

	  @Then("^user is able to see the green check with submitted text on the Process tab for all installment$")
	  public void user_is_able_to_see_the_green_check_with_submitted_text_on_the_Process_tab_for_all_installment() {
	      payment.verifySuccessSubmitList();
	  }
		
}
