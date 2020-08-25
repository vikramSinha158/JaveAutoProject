package r1.pages;

import net.serenitybdd.core.pages.PageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;
import r1.commons.utilities.ReadExcelData;

public class ApiConfigurationPage extends PageObject {

	CommonMethod com;
	R1ContactCommonMethods r1ComMethod;
	
	String rowCollector="//div[@id='ApiVendorSetting']//table[@cellspacing='0']/tbody/tr";
	String colCollector="//div[@id='ApiVendorSetting']//table[@cellspacing='0']/thead/tr/th";
	String beforeEditPath="//table[@cellspacing='0']/tbody/tr[";
	String afterEditPath="]/td[11]/a[text()='Edit']/span";
	String parameterDropDwn="'ParameterName";
	

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
		
	@FindBy(xpath = "//div[@id='ApiVendorSetting']//table[@cellspacing='0']/thead/tr/th")
	private List<WebElementFacade> apiTableHeaderList;
	
	@FindBy(xpath = "//a[text()='Back To Vendor']")
	private WebElementFacade backVendorBtn;
	
	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//input[@id='BestBillConnector']")
	private WebElementFacade editConnector;
	
	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//input[@id='apiVendorUrl']")
	private WebElementFacade editApiVendorUrl;
	
	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//input[@id='apiClientId']")
	private WebElementFacade editApiClientId;
		
	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//input[@id='apiClientSecret']")
	private WebElementFacade editApiClientSecret;
		
	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//input[@id='apiToken']")
	private WebElementFacade editApiToken;
		
	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//input[@id='apiRefreshToken']")
	private WebElementFacade editApiRefreshToken;
		
	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//input[@id='apiTokenExpiry']")
	private WebElementFacade editApiTokenExpiry;
		
	@FindBy(xpath = "//a[text()='Update']")
	private WebElementFacade editPopUpdateBtnApiConfig;
	
	public void verifyApiConfigPage() {

		CommonMethod.isDisplayedMethod(ApiConfigPageHeader);
		com.highLightSteps(ApiConfigPageHeader);
	}

	
	/*verify on add record btn */
	public void verifyAddRecordApiConfigPopUp() {
		clickOnApiConfignAddRecord();
		CommonMethod.isDisplayedMethod(addRecordApiConfigPopUp);
		clickOn(addRecordPopCancelBtnApiConfig);
	}

	/*Click on add record btn */
	public void clickOnApiConfignAddRecord() {
		clickOn(ApiConfigThirdPatyConBtn);
	}

	/*verify first row edit */
	public void clickOnApiConfigEdit() {
		if (ApiConfigTblrow.size() > 0) {
			clickOn(firstRowEditBtnApiConfig);

		} else {
			Assert.assertTrue("No row found in Api Configuration Table to click on edit", ApiConfigTblrow.size() > 0);
		}
	}

	/*verify edit pop up*/
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
	
	
	/*verify the Label of add Vendor of API configuration */
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

		Assert.assertTrue("expected value does not match with actaul value in Add new vendor", addNewVendorLabelList.equals(com.dataAfterPipeSeperation("AddNewVendorLabelList")));	
	}
	
	/*Click On Add new vendor button  */
	public void clickOnAddnewVendoe()
	{
		clickOn(addNewVendorBtn);
	}
	
	/*Click On Cancel Add record pop up */
	public void clickOnAddrecordCabcelBtn() {
		
		clickOn(addRecordPopCancelBtnApiConfig);
	}
	
	/*Verify the back button in add new vendor  */
	public void verifyBackBtnInAddnewVendor()
	{

		if(backVendorBtn.isDisplayed())
		{
			clickOn(backVendorBtn);
			verifyAddRecordLabel();
		}
		else {
			Assert.assertTrue("Back button is not visible ", false);
		}		
	}
	
	
	/*Verify the content of API configuration table */
	public void verifyApiConfigurationTable(String sheetName) throws InterruptedException, ParseException 
	{
		ReadExcelData readExcel=new ReadExcelData("src/test/resources/TestData/ApiConfigutationData.xlsx");
		int rowSize = findAll(By.xpath(rowCollector)).size();
		for(int rowNum=1;rowNum<=rowSize;rowNum++)
		{			
			List<String> excelRowList=readExcel.getRowData(sheetName, rowNum);
			List<String> guiRowList=r1ComMethod.getRowValue(rowCollector, colCollector, rowNum);		
			System.out.println("Webta cell value  "+ guiRowList);
						
			for(int colNum=0;colNum<guiRowList.size()-1;colNum++)
			{
				if(!(guiRowList.get(colNum).equalsIgnoreCase(excelRowList.get(colNum))))
				{ 
					String header=apiTableHeaderList.get(colNum).getText();
					
					if((guiRowList.get(colNum).equals("")) && (excelRowList.get(colNum).equalsIgnoreCase("NULL"))) {
						continue;}
					if(header.equalsIgnoreCase("API TOKEN EXPIRY"))
					{
						SimpleDateFormat dbDateFormate = new SimpleDateFormat("dd-MMM-yyyy");
						Date excelDate = dbDateFormate.parse(excelRowList.get(colNum).trim());
						SimpleDateFormat convertedFormate = new SimpleDateFormat("M/d/yyyy");

						String convertedDbDate = convertedFormate.format(excelDate);
	
						if(!(guiRowList.get(colNum).equalsIgnoreCase(convertedDbDate)))
						{
							updateEditPopUp(header,convertedDbDate,rowNum);
						}
						
					}else {
						 	updateEditPopUp(header,excelRowList.get(colNum),rowNum);		
					}
				}
			  }
							   		
			}				
		}			
	
		/*Update the value in edit pop up */
		public void updateEditPopUp(String tableheader,String updateData,int rowID) throws InterruptedException, ParseException
		{
			Thread.sleep(2000);
			element(By.xpath(beforeEditPath+rowID+afterEditPath)).click();
			
			  switch (tableheader)  
	          { 
	          case "VENDOR":
	        	  System.out.println("VENDOR"); 
	              break;
	          case "FACILITY": 
	              System.out.println("FACILITY"); 
	              break; 
	          case "API CLIENT": 
	        	  editApiClientId.clear();
	        	  editApiClientId.sendKeys(updateData); 
	              break;
	          case "API VENDOR URL": 
	        	  editApiVendorUrl.clear();
	        	  editApiVendorUrl.sendKeys(updateData);
	              break;
	          case "API CLIENT SECRET": 
	        	  editApiClientSecret.clear();
	        	  editApiClientSecret.sendKeys(updateData);
	              break;
	          case "API TOKEN": 
	        	  editApiToken.clear();
	        	  editApiToken.sendKeys(updateData); 
	              break;
	          case "API REFRESH TOKEN": 
	        	  editApiRefreshToken.clear();
	        	  editApiRefreshToken.sendKeys(updateData);
	              break;
	          case "API TOKEN EXPIRY": 
	        	  editApiTokenExpiry.clear();
	        	  editApiTokenExpiry.sendKeys(updateData); 
	              break;
	          case "CONNECTOR": 
	        	  editConnector.clear();
	        	  editConnector.sendKeys(updateData);
	              break;
	          case "PARAMETER": 
	              com.selectListWithElement(parameterDropDwn, updateData);
	              break;
		         
	          } 
			  			  
			  Thread.sleep(3000);
		 
			  editPopUpdateBtnApiConfig.click();
		
			  Thread.sleep(3000);
		
		}
	
	
}
