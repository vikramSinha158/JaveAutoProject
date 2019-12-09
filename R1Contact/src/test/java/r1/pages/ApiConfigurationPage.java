package r1.pages;

import net.serenitybdd.core.pages.PageObject;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.utilities.CommonMethod;

public class ApiConfigurationPage extends PageObject {

	CommonMethod com;

	@FindBy(xpath = "//div[contains(text(),'API Configuration')]")
	private WebElementFacade ApiConfigPageHeader;

	@FindBy(xpath = "//a[text()='Add new record']")
	private WebElementFacade ApiConfigThirdPatyConBtn;

	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElementFacade addRecordPopCancelBtnApiConfig;

	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']")
	private WebElementFacade addRecordApiConfigPopUp;

	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[11]/a[contains(text(),'Edit')]")
	private WebElementFacade firstRowEditBtnApiConfig;

	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> ApiConfigTblrow;

	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']")
	private WebElementFacade dialogApiConfigEdit;

	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//a[text()='Cancel']")
	private WebElementFacade EditPopCancelBtnApiConfig;
		
	@FindBy(xpath = "//table[@cellspacing='0']/thead[@class='t-grid-header']/tr/th")
	private List<WebElementFacade> ApiConfigTblHeader;
		
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//label")
	private List<WebElementFacade> editLabel;
		
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//a[@id='Addvendor']")
	private WebElementFacade addNewVender;
		
	@FindBy(xpath = "//select[@id='ParameterName']")
	private WebElementFacade addRecordParameterDrpDn;
		
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//label[@for='VendorNameforSave']")
	private WebElementFacade vendorNameforSave;
	
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//label[@for='apiVendorUrl']")
	private WebElementFacade apiVendorUrl;
	
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//label[@for='apiClientId']")
	private WebElementFacade apiClientId;
	
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//label[@for='apiClientSecret']")
	private WebElementFacade apiClientSecret;
	
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//label[@for='apiToken']")
	private WebElementFacade apiToken;
	
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//label[@for='apiRefreshToken']")
	private WebElementFacade apiRefreshToken;
	
	@FindBy(xpath = "//form[@id='ApiVendorSettingform']//label[@for='apiTokenExpiry']")
	private WebElementFacade apiTokenExpiry;
		
	@FindBy(xpath = "//a[text()='Add New Vendor']")
	private WebElementFacade addNewVendorBtn;
	
	public void verifyApiConfigPage() {

		CommonMethod.isDisplayedMethod(ApiConfigPageHeader);
		com.highLightSteps(ApiConfigPageHeader);
	}

	public void verifyAddRecordApiConfigPopUp() {
		clickOnApiConfignAddRecord();
		CommonMethod.isDisplayedMethod(addRecordApiConfigPopUp);
		clickOn(addRecordPopCancelBtnApiConfig);
	}

	public void clickOnApiConfignAddRecord() {
		clickOn(ApiConfigThirdPatyConBtn);
	}

	public void clickOnApiConfigEdit() {
		if (ApiConfigTblrow.size() > 0) {
			clickOn(firstRowEditBtnApiConfig);

		} else {
			Assert.assertTrue("No row found in Api Configuration Table to click on edit", ApiConfigTblrow.size() > 0);
		}
	}

	public void verifyApiConfigTblEdit() {
		clickOnApiConfigEdit();
		CommonMethod.isDisplayedMethod(dialogApiConfigEdit);
		clickOn(EditPopCancelBtnApiConfig);

	}
	
	/*verify the header of API configuration */
	public void verifyApiConfigHeader()
	{		
		List<String> headerList=new ArrayList<String>();
		
	   for(int i=0;i<ApiConfigTblHeader.size();i++) {		
			   headerList.add(ApiConfigTblHeader.get(i).getText());
	   }	   
	   List<String> apiConfigHeaderList=com.dataAfterPipeSeperation("ApiConfigHeader");
	   Assert.assertTrue("expected valuse does not match with actaul value", headerList.equals(apiConfigHeaderList));		
	}
	
	
	/*verify the Lable of Edit of API configuration */
	public void verifyEditLabel()
	{
		List<String> editLabelList=new ArrayList<String>();
		clickOnApiConfigEdit();
		 for(int i=0;i<editLabel.size();i++) {
			 if(i==1)
			 {
				 continue;
			 }
			 editLabelList.add(editLabel.get(i).getText());			
		 }
		 List<String> apiConfigExpectEditList=com.dataAfterPipeSeperation("ApiEditLabel");		 
		 Assert.assertTrue("expected valuse does not match with actaul value", editLabelList.equals(apiConfigExpectEditList));
		 clickOn(EditPopCancelBtnApiConfig);
	}
	
	

	/*verify the Label of add record of API configuration */
	public void verifyAddRecordLabel()
	{
		List<String> addNewRecordLabelList=new ArrayList<String>();
		 for(int i=0;i<6;i++) {
			 if(i==1)
			 {
				 continue;
			 }
			 addNewRecordLabelList.add(editLabel.get(i).getText());			
		 }
		 List<String> apiConfigExpectAddRecList=com.dataAfterPipeSeperation("AddRecordLabel");
		 Assert.assertTrue("expected valuse does not match with actaul value", addNewRecordLabelList.equals(apiConfigExpectAddRecList));
		 
		 Assert.assertTrue("", addNewVender.getText().equalsIgnoreCase(CommonMethod.readProperties("AddVendorLabel")));
		
	}
	
	
	/*verify the Label of Parameter Name dropdown of addrecord pop up*/
	public void verifyParameterNameDropDown()
	{
		clickOn(addRecordParameterDrpDn);
		List<String> ParameterDrpDnList=new ArrayList<String>();
		Select selectParameterDropdown = new Select(addRecordParameterDrpDn);
		List<WebElement> listOptionDropdown = selectParameterDropdown.getOptions();
		for(int i=0;i<listOptionDropdown.size();i++)
		{
			ParameterDrpDnList.add(listOptionDropdown.get(i).getText());
		}

		Assert.assertTrue("expected valuse does not match with actaul value", ParameterDrpDnList.equals(com.dataAfterPipeSeperation("ParameterName")));		
	}
	
	public void verifyAddNewVendor()
	{
		clickOn(addNewVendorBtn);
		List<String> addNewVendorLabelList=new ArrayList<String>();
		addNewVendorLabelList.add(vendorNameforSave.getText());
		addNewVendorLabelList.add(apiVendorUrl.getText());
		addNewVendorLabelList.add(apiClientId.getText());
		addNewVendorLabelList.add(apiClientSecret.getText());
		addNewVendorLabelList.add(apiToken.getText());
		addNewVendorLabelList.add(apiRefreshToken.getText());
		addNewVendorLabelList.add(apiTokenExpiry.getText());
		
		
		System.out.println(addNewVendorLabelList);
		System.out.println(com.dataAfterPipeSeperation("AddNewVendorLabelList"));
		Assert.assertTrue("expected valuse does not match with actaul value", addNewVendorLabelList.equals(com.dataAfterPipeSeperation("AddNewVendorLabelList")));	
	}

}
