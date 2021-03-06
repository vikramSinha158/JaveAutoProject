package r1.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.utilities.CommonMethod;
import java.util.Collections;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.By;

public class MyQueuePage extends BasePage {

	R1ContactCommonMethods r1ComMethod;
	AccountPage account;
	CommonMethod comm;
	HomePage home;
	AccountDetailsPage accoundel;
	@FindBy(xpath = "//input[@name='StatusMonth']")
	private WebElementFacade statusMonth;

	@FindBy(xpath = "//input[@name='StatusDay']")
	private WebElementFacade statusDay;

	@FindBy(xpath = "//input[@name='StatusYear']")
	private WebElementFacade statusYear;

	@FindBy(xpath = "//div[@ng-include='config.getTemplateUrl(filter)']")
	private List<WebElementFacade> myTabFilterBox;

	@FindBy(xpath = "//tr[@class='ng-scope']")
	private List<WebElementFacade> listOfMyQueue;

	@FindBy(xpath = "//th[@data-title-text='Status Date']")
	private WebElementFacade statusDate;

	@FindBy(xpath = "//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th")
	private List<WebElementFacade> homeReminderInfoColPath;

	@FindBy(xpath = "//table[@id='queueTable']//thead//tr[@class='ng-table-sort-header']//th")
	private List<WebElementFacade> headerList;

	int listOfMyQueueCount;
	int searchEleRow;
	String homeReminderInfoCol = "//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th";
	String listOfQueueString = "//tr[@class='ng-scope']";
	String myQuerytblCol = "//table[@id='queueTable']//thead//tr[@class='ng-table-sort-header']//th";
	String myQuerytblRow = "//table[@id='queueTable']/tbody/tr[@class='ng-scope']";
	String myQueueArrowLink = "//a";
	String accountHeader = "Account Number";
	String statusDateHeader = "STATUS DATE";
	String headerListString = "//table[@id='queueTable']//thead//tr[@class='ng-table-sort-header']//th";
	@FindBy(xpath = "//div[@class='ng-table-pager ng-scope']/ul/li/a/span")
	private List<WebElementFacade> myQueueTblPage;

	/* verify Owned Accounts */
	public void verifyOwnedAccounts() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

		List<String> listOfMyQueueAcc = new ArrayList<String>();
		List<String> listOfAccFromGui = new ArrayList<String>();

		R1ContactCommonMethods.runQuery("MyQueueAccountList");

		while (DatabaseConn.resultSet.next()) {
			listOfMyQueueAcc.add(DatabaseConn.resultSet.getString("aqAccountNum"));
		}

		if(myQueueTblPage.size()>0) {
			for (int i = 0; i < myQueueTblPage.size(); i++) {
				clickOn(myQueueTblPage.get(i));
				List<String> listOfAccPerPage = r1ComMethod.getColValue(myQuerytblRow, myQuerytblCol, accountHeader);
				listOfAccFromGui.addAll(listOfAccPerPage);

			}
		}else {
			List<String> listOfAccPerPage = r1ComMethod.getColValue(myQuerytblRow, myQuerytblCol, accountHeader);
			listOfAccFromGui.addAll(listOfAccPerPage);

		}

		if (listOfAccFromGui.size() < 1) {
			Assert.assertTrue("No record Data found in MyQueue Table ", false);
		}

		Collections.sort(listOfAccFromGui);
		Collections.sort(listOfMyQueueAcc);

		Assert.assertTrue(
				"Owned account does not match db account  " + listOfMyQueueAcc.size()
						+ " with the view account on table,GUI account " + listOfAccFromGui.size(),
				listOfAccFromGui.equals(listOfMyQueueAcc));

	}

	/* click On Account on my QueueTbl */
	public void clickOnAccountonmyQueueTbl(String myQueuetblAcc) throws FileNotFoundException, IOException {

		r1ComMethod.clickOnMatchingColValue(myQuerytblRow, myQuerytblCol, myQueuetblAcc, myQueueArrowLink);

	}

	/* verify Account Info Page */
	public void verifyAccountInfoPage(String dbAccount) {
		accoundel.verifyAccountInfoSection();
		accoundel.verifyAccountWithDb(dbAccount);
	}

	public void checkHyperLinkForAccount(String dbAcc) throws FileNotFoundException, IOException {
		
		if(findAll(By.xpath(myQuerytblRow)).size()<1)
		{
			Assert.assertTrue("No record Data found in MyQueue Table ", false);
		}

		if(myQueueTblPage.size()>0) {
		for (int i = 0; i < myQueueTblPage.size(); i++) {
			clickOn(myQueueTblPage.get(i));

			if (r1ComMethod.clickOnCheckingHyperlink(myQuerytblRow, myQuerytblCol, dbAcc, "//a") == true) {
				break;
			}

		}
	  }else {
		  r1ComMethod.clickOnCheckingHyperlink(myQuerytblRow, myQuerytblCol, dbAcc, "//a");
	  }
	}

	// Click status month filter
	public void clickStatusMonth() {
		statusMonth.click();
	}

	// Click on Date Status
	public void clickDateStatus() {
		statusDate.click();
	}

	// send in status month filter
	public void sendInStatusMonth(String month) {
		statusMonth.clear();
		statusMonth.sendKeys(month);
	}

	//

	public void checkContainInMyQueue(String search, String headerName, String searchElement)
			throws FileNotFoundException, IOException {
		// If date search is for MM
		if (search.equalsIgnoreCase("MM")) {
			statusMonth.sendKeys(searchElement);
			String validMonth = searchElement.substring(0, 1);
			// If searchElement is out of month range
			if (statusMonth.getAttribute("value").equals(validMonth)) {
				listOfMyQueueCount = listOfMyQueue.size();
				searchEleRow = r1ComMethod.checkElementcontain(listOfQueueString, homeReminderInfoCol, headerName,
						validMonth);
			} else {
				listOfMyQueueCount = listOfMyQueue.size();
				searchEleRow = r1ComMethod.checkElementcontain(listOfQueueString, homeReminderInfoCol, headerName,

						searchElement);
			}
			statusMonth.clear();
			// Else if date search is for DD
		} else if (search.equalsIgnoreCase("DD")) {
			statusDay.sendKeys(searchElement);
			String validDate = searchElement.substring(0, 1);
			// If searchElement is out of month range
			if (statusDay.getAttribute("value").equals(validDate)) {
				listOfMyQueueCount = listOfMyQueue.size();
				searchEleRow = r1ComMethod.checkElementcontain(listOfQueueString, homeReminderInfoCol, headerName,
						validDate);
			} else {
				listOfMyQueueCount = listOfMyQueue.size();
				searchEleRow = r1ComMethod.checkElementcontain(listOfQueueString, homeReminderInfoCol, headerName,

						searchElement);
			}
			statusDay.clear();

		} else if (search.equalsIgnoreCase("YYYY")) {
			statusYear.sendKeys(searchElement);
			listOfMyQueueCount = listOfMyQueue.size();
			searchEleRow = r1ComMethod.checkElementcontain(listOfQueueString, homeReminderInfoCol, headerName,
					searchElement);
			statusYear.clear();
		}
		Assert.assertEquals("Row for search element not match", listOfMyQueueCount, searchEleRow);
	}

	// press tab in date MM section
	public void pressTabInDateTxtField() {
		comm.pressTab(statusMonth);
	}

	// verify tab press in date status section
	public void verifyTabInDateStatus() {

		Assert.assertTrue("Tab press failed for date section ",
				comm.verifyTabPressInNextSection(statusMonth, statusDay, "15"));
	}

	// Double click on facility
	public void DoubleclickOnFacilityMyQueueTbl(String dbFacility) throws FileNotFoundException, IOException {
		r1ComMethod.DoubleclickOnMatchingColValue(myQuerytblRow, myQuerytblCol, dbFacility);

	}

	// Veryfying account inf page after double click on nay column other than
	// account
	public void verifyAccountInfoPageHeader() {
		Assert.assertTrue("Not landed on Account Info Page", accoundel.verifyAccountInfoSectionWithReturn());
	}

	// Single click on facility
	public void singleClickOnFacilityMyQueueTbl(String dbFacility) throws FileNotFoundException, IOException {
		r1ComMethod.SingleClickOnMatchingColValue(myQuerytblRow, myQuerytblCol, dbFacility);

	}

	// Veryfying account inf page after double click on nay column other than
	// account
	public void verifyAccountInfoPageNotVisible() {
		Assert.assertFalse("Not landed on Account Info Page", accoundel.verifyAccountInfoSectionWithReturn());
	}

	// Check records in My Queue
	public void checkQueuePresence() {
		if (listOfMyQueue.size() == 0) {
			Assert.assertTrue("There is no queue present in My Queue to do further testing!!", false);
		}
	}

	// Verify dates are in descending order not
	public void verifySearchDateOrder() {
		r1ComMethod.verifyDescSorting(listOfQueueString, headerListString, statusDateHeader);
	}

	public void sendInStatusDate() {
		statusYear.sendKeys("2019");
	}
}
