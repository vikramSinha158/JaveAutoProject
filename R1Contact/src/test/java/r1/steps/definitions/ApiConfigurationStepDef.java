package r1.steps.definitions;

import java.text.ParseException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.ApiConfigurationPage;

public class ApiConfigurationStepDef {
	
	ApiConfigurationPage apiConfig;
	
	@Then("^user ishould be able to view API CONFIGURATION page with columns$")
	public void user_ishould_be_able_to_view_API_CONFIGURATION_page_with_columns() {
		
		apiConfig.verifyApiConfigHeader();
	    
	}
	
	@Then("^user should be able to view Edit pop up with Details$")
	public void user_should_be_able_to_view_Edit_pop_up_with_Details() {
	    apiConfig.verifyEditLabel();
	}
	
	
	@When("^user clicks on Add New Record button$")
	public void user_clicks_on_Add_New_Record_button() {
		 apiConfig.clickOnApiConfignAddRecord();
		
	}
	
	@Then("^user should be able to view a pop up with  with textboxes$")
	public void user_should_be_able_to_view_a_pop_up_with_with_textboxes() {
		 apiConfig.verifyAddRecordLabel();

	}


	@Then("^user user clicks on the dropdown of ParameterName and should able to view the values of dropdown$")
	public void user_user_clicks_on_the_dropdown_of_ParameterName_and_should_able_to_view_the_values_of_dropdown() {
		 apiConfig.verifyParameterNameDropDown();
	}
	
	@Then("^user should be able to view Add New Vendor pop up with below textboxes$")
	public void user_should_be_able_to_view_Add_New_Vendor_pop_up_with_below_textboxes() {
		apiConfig.verifyAddNewVendor();
	}
	
	@When("^user clicks on Add New Vendor$")
	public void user_clicks_on_Add_New_Vendor() {
		apiConfig.clickOnAddnewVendoe();
	}


	@Then("^user should be able to view Add New Vendor pop up$")
	public void user_should_be_able_to_view_Add_New_Vendor_pop_up() {
		apiConfig.verifyBackBtnInAddnewVendor();
	}
	
	@When("^clicks on Cancel button on Add New Record pop up$")
	public void clicks_on_Cancel_button_on_Add_New_Record_pop_up() {
		apiConfig.clickOnAddrecordCabcelBtn();
	}


	@Then("^user shold successfully close the popup window$")
	public void user_shold_successfully_close_the_popup_window() {
		apiConfig.verifyApiConfigPage();
	}
	
	@When("^user match the UI configuration value from the excelsheet \"([^\"]*)\",if not match update the cell$")
	public void user_match_the_UI_configuration_value_from_the_excelsheet_if_not_match_update_the_cell(String sheetName) throws InterruptedException, ParseException {
		apiConfig.verifyApiConfigurationTable(sheetName);
	}
	
	


}
