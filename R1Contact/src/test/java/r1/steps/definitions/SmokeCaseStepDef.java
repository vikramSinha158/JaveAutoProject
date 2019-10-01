package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.AccountDetailsPage;
import r1.pages.AccountPage;
import r1.pages.BalanceLinkPage;
import r1.pages.PatientInfoPage;
import r1.pages.RightPartyConPage;

public class SmokeCaseStepDef {


	AccountPage accountPage;
	AccountDetailsPage accPatientDtl;
	PatientInfoPage patientInfo;
	RightPartyConPage rpcPage;
	BalanceLinkPage balancePage;
	
	
	@When("^user selects the last name search criteria on account search page$")
	public void user_selects_the_last_name_search_criteria_on_account_search_page() {
		
		accountPage.lastNameCheck();
	}

	@When("^user enters \"([^\"]*)\" alphabets in the last name search box$")
	public void user_enters_alphabets_in_the_last_name_search_box(String lastnameStart) {
		accountPage.enterLastNameTxt(lastnameStart);
	}

	@Then("^user should see the search results last name start with \"([^\"]*)\" populated  number of retrieved accounts$")
	public void user_should_see_the_search_results_last_name_start_with_populated_number_of_retrieved_accounts(String lastnameStart) {
		accountPage.lastNameSearchclk();
		accountPage.verifyFirstCharForLastName(lastnameStart);
	}
	
	@When("^user clicks on the \"([^\"]*)\" enter arrow$")
	public void user_clicks_on_the_enter_arrow(String inboundArrow) throws FileNotFoundException, IOException {
	    
		accountPage.selectAndClickAccount(inboundArrow);
	}
	
	@Then("^user should be navigate to right party verification page$")
	public void user_should_be_navigate_to_right_party_verification_page() {
		rpcPage.rpcPageDisplayed();
	 
	}

	@When("^user clicks on the both Yes button$")
	public void user_clicks_on_the_both_Yes_button() {
	    
		rpcPage.clickOnRpcBothYesBtn();
	}

	@Then("^user should be land on the account info page$")
	public void user_should_be_land_on_the_account_info_page() {
		accPatientDtl.verifyAccInfoAccNum();
	    
	}
	
	@When("^user clicks on the link balance link$")
	public void user_clicks_on_the_link_balance_link() {
		accPatientDtl.balancelinkClk();
	  
	}

	@Then("^user should be navigate to the link balance page$")
	public void user_should_be_navigate_to_the_link_balance_page() {
		balancePage.verifyBalanceLinkPage();
	}
	
	@When("^user clicks on the Patient name link$")
	public void user_clicks_on_the_Patient_name_link() {
		accPatientDtl.clickOnPatientLink();
	   
	}

	@Then("^user should be avail to navigate on the patient info page$")
	public void user_should_be_avail_to_navigate_on_the_patient_info_page() {
		
		patientInfo.verifyPatientInfoPage();
	   
	}
	
	@When("^user changes the patient info$")
	public void user_changes_the_patient_info() {
		patientInfo.enterPatientAddress2();
	}

	@When("^user clicks on the save button$")
	public void user_clicks_on_the_save_button() {
		patientInfo.SavePatientPage();
	}

	@Then("^patient info should be updated successfully$")
	public void patient_info_should_be_updated_successfully() {
		patientInfo.verifySuceesUpdate();
	}
	
	@When("^user clicks on the \"([^\"]*)\" tab$")
	public void user_clicks_on_the_tab(String EncounterInformation) {
		accPatientDtl.clickPatientDtlTabs(EncounterInformation);
	}
	
	@Then("^Encounter Information tab should be expand$")
	public void encounter_Information_tab_should_be_expand() {
		accPatientDtl.verifyEncounterTabExpand();
	}

	@When("^user clicks on the Click to View link$")
	public void user_clicks_on_the_Click_to_View_link() {
		accPatientDtl.clkInView();
	}

	@Then("^Patient Diagnosis details pop window should get appeared$")
	public void patient_Diagnosis_details_pop_window_should_get_appeared() {
		accPatientDtl.verifyPopUpInEncInfo();
	}
}
