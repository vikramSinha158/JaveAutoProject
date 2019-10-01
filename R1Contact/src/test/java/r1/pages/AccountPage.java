package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class AccountPage extends BasePage {

	private int counter = 0;
	R1ContactCommonMethods contactCommon;
	String accountColHeader = "Patient Name";
	String accountRowLocator = "//table[@cellspacing='0']/tbody/tr";
	String accountColLocator = "//table[@cellspacing='0']//thead/tr/th";
	String accountRows = "//div[@id='Accounts']/table/tbody/tr";
	String colNum = "//div[@id='Accounts']/table/tbody/tr[2]/td";

	@FindBy(xpath = "//button[@id='NameSubmit']")
	private WebElementFacade lastNameSearchclk;

	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> accountTablerOW;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElementFacade lastNametxt;

	@FindBy(xpath = "//div[@class='flt-lft label-item']/p")
	private List<WebElementFacade> searchAccLabels;

	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> totalRowCount;
	
    /*-------- Added below fields------	*/
	
	/*@FindBy(xpath="//span[contains(text(),'Right party contact (RPC)')]")
	WebElementFacade rpc;*/
	
	@FindBy(xpath="//div[@class='account-number']")
	WebElementFacade accNumber;
	
	//button[@type='button'][text()='Yes']
	
	CommonMethod comMethod;
/*	@FindBy(xpath="//button[@type='button'][text()='Yes']")
	WebElementFacade rpcYes;
	
	@FindBy(xpath="//button[@type='submit'][text()='Yes']")
	WebElementFacade addressYes;*/
	
		
	
	
	/*@FindBy(xpath="//table[@cellspacing]//thead[@class='t-grid-header']")
	WebElementFacade headerBalabceTbl;*/
	
	
	
	
	
	
	private String arrowLink = "//a[1]//div";
	
	private String inboundLink = "//a//img[@alt='Example inbound']";
	private String outboundLink = "//a//img[@alt='Example outbound']";
	
	



	/* Updated the code for click on arrow, inbound and outbound
	 * Clicks the the account passed by property file
	 */
	public void selectAndClickAccount(String clickItem) throws FileNotFoundException, IOException {
		
		if(clickItem.equalsIgnoreCase("inbound"))
		{
		contactCommon.clickOnMatchingColValue(accountRows, colNum, CommonMethod.readProperties("AccountNumber"),inboundLink);
		
		}
		
		else if(clickItem.equalsIgnoreCase("outbound"))
		{
		contactCommon.clickOnMatchingColValue(accountRows, colNum, CommonMethod.readProperties("AccountNumber"),outboundLink);
		}
		else if(clickItem.equalsIgnoreCase("arrow"))
		{
		contactCommon.clickOnMatchingColValue(accountRows, colNum, CommonMethod.readProperties("AccountNumber"),arrowLink);
		}

	}

	/*
	 * Enters the last name in account search field
	 */
	public void enterLastNameTxt(String txtValue) {
		lastNametxt.clear();
		lastNametxt.sendKeys(txtValue);

	}

	/*
	 * Clicks the last name search icon
	 */
	public void lastNameSearchclk() {
		clickOn(lastNameSearchclk);

	}

	/*
	 * Search account labels is displayed
	 */
	public void searchAccountlables() {
		for (int i = 0; i < searchAccLabels.size(); i++) {
			Assert.assertTrue("Search criteria label name is:" + searchAccLabels.get(i).getText(),
					searchAccLabels.get(i).isDisplayed());
		}
	}

	/*
	 * Number of accounts matching with search criteria
	 */
	public int getTotalRowCount() {
		return totalRowCount.size();
	}

	public void verifyFirstCharForLastName(String firstCharLastName) {
		ArrayList<String> patientList = contactCommon.getColValue(accountRowLocator, accountColLocator,
				accountColHeader);
		for (String patientName : patientList) {
			String[] patientNameSplit = patientName.split(" ");
			String LastName = patientNameSplit[patientNameSplit.length - 1];
			if (LastName.toUpperCase().startsWith(firstCharLastName.toUpperCase())) {
				counter++;
			}

		}

		Assert.assertEquals("Number of row not match for search element " + firstCharLastName, getTotalRowCount(),
				counter);

	}
	
	/*----New Method----*/
	/*----Check for last Name field ----*/
	
	public void lastNameCheck()
	{
		CommonMethod.isDisplayedMethod(lastNametxt);
	}
	
	
	

	
	/*----Verify account number in page ----*/
	/*public void verifyAccountNumber()
	{
		boolean accFlag=false;
		String actAccNumber=accNumber.getText();
		System.out.println(actAccNumber);
		if(actAccNumber.contains(CommonMethod.readProperties("AccountNumber")))
		{
			accFlag=true;
			comMethod.highLightSteps(accNumber);
		}
		else
		{
			Assert.assertTrue("Account Number "+CommonMethod.readProperties("AccountNumber")+" Not found in "  + actAccNumber , accFlag);
		}
	}*/
	
	
	
	
	
	
	

}
