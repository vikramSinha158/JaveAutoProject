package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.QueryExecutor;
import r1.commons.utilities.CommonMethod;

public class AccountPage extends BasePage {

	private int counter = 0;
	R1ContactCommonMethods contactCommon;
	CommonMethod common;
	CommonMethod comMethod;
	String accountColHeader = "Patient Name";
	String accountRowLocator = "//table[@cellspacing='0']/tbody/tr";
	String accountColLocator = "//table[@cellspacing='0']//thead/tr/th";
	String accountRows = "//div[@id='Accounts']/table/tbody/tr";
	String colNum = "//div[@id='Accounts']/table/tbody/tr[1]/td";
	private String arrowLink = "//a//div";
	private String inboundLink = "//a//img[@alt='Example inbound']";
	private String outboundLink = "//a//img[@alt='Example outbound']";

	@FindBy(xpath = "//button[@id='NameSubmit']")
	private WebElementFacade lastNameSearchclk;

	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> accountTablerOW;

	@FindBy(id = "LastName")
	private WebElementFacade lastNametxt;

	@FindBy(xpath = "//div[@class='flt-lft label-item']/p")
	private List<WebElementFacade> searchAccLabels;

	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> totalRowCount;

	@FindBy(xpath = "//div[@class='account-number']")
	WebElementFacade accNumber;

	@FindBy(xpath = "//div[@class='flt-lft label-item']/p//following::div[@class='flt-lft']/input")
	private List<WebElementFacade> searchAccountTextFields;

	@FindBy(id = "Zip")
	private WebElementFacade zipSearchField;

	@FindBy(xpath = "//input[@id='AccountNumber']")
	private WebElementFacade enteraccNumtxt;

	@FindBy(xpath = "//button[@id='AccountNumberSubmit']")
	private WebElementFacade clkaccNumSearch;

	public void runQueryTranServer(String queryName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		QueryExecutor.runQueryTran(this.getClass().getSimpleName().replace("Page", ""), queryName);
	}

	/*
	 * Clicks the the account passed by property file
	 */
	public void selectAndClickAccount(String clickItem) throws FileNotFoundException, IOException {

		if (clickItem.equalsIgnoreCase("inbound")) {
			contactCommon.clickOnMatchingColValue(accountRows, colNum, CommonMethod.readProperties("AccountNumber"),
					inboundLink);
		}

		else if (clickItem.equalsIgnoreCase("outbound")) {
			contactCommon.clickOnMatchingColValue(accountRows, colNum, CommonMethod.readProperties("AccountNumber"),
					outboundLink);
		} else if (clickItem.equalsIgnoreCase("arrow")) {
			contactCommon.clickOnMatchingColValue(accountRows, colNum, CommonMethod.readProperties("AccountNumber"),
					arrowLink);
		}

	}

	/*
	 * Clicks the the account factched from DB
	 */

	public void clickOnArrowWithDbAccNum(String AccountNum) throws FileNotFoundException, IOException {
		contactCommon.clickOnMatchingColValue(accountRows, colNum, AccountNum, arrowLink);

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
	 * Search accounts text fields is displayed or editable or not
	 */
	public void searchAccountTextField() {
		for (int i = 0; i < searchAccountTextFields.size(); i++) {
			Assert.assertTrue("Search criteria label name is:" + searchAccountTextFields.get(i).getText(),
					searchAccountTextFields.get(i).isDisplayed());
			String readonly = searchAccountTextFields.get(i).getAttribute("readonly");
			Assert.assertNull(readonly);
		}
		Assert.assertTrue("Last name Search field is not being displayed!", lastNametxt.isDisplayed());
		Assert.assertNull(lastNametxt.getAttribute("readonly"));
		Assert.assertTrue("Zip Search field is not being displayed!", zipSearchField.isDisplayed());
		Assert.assertNull(zipSearchField.getAttribute("readonly"));
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

	/*----Check for last Name field ----*/

	public void lastNameCheck() {
		CommonMethod.isDisplayedMethod(lastNametxt);
	}

	/* Enter text for account search */

	public void enterAccNumForSearch(String accNumtxt) {

		enteraccNumtxt.clear();
		enteraccNumtxt.sendKeys(accNumtxt);

	}

	public void clickForAccSearch() {
		clkaccNumSearch.click();
	}
}
