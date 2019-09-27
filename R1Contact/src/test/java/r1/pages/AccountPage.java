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

	/*
	 * Clicks the the account passed by property file
	 */
	public void selectAndClickAccount() throws FileNotFoundException, IOException {

		contactCommon.clickOnMatchingColValue(accountRows, colNum, CommonMethod.readProperties("AccountNumber"));

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

}