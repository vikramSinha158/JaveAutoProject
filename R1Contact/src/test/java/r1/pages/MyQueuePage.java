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

public class MyQueuePage extends BasePage {

	R1ContactCommonMethods r1ComMethod;
	AccountPage account;
	CommonMethod comm;
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

	@FindBy(xpath = "//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th")
	private List<WebElementFacade> homeReminderInfoColPath;

	int listOfMyQueueCount;
	int searchEleRow;
	String homeReminderInfoCol = "//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th";
	String listOfQueue = "//tr[@class='ng-scope']";
	String myQuerytblCol = "//table[@id='queueTable']//thead//tr[@class='ng-table-sort-header']//th";
	String myQuerytblRow = "//table[@id='queueTable']/tbody/tr[@class='ng-scope']";
	String myQueueArrowLink = "//a";
	String accountHeader = "Account Number";
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
        		
		for (int i = 0; i < myQueueTblPage.size(); i++) {
			clickOn(myQueueTblPage.get(i));
			List<String> listOfAccPerPage = r1ComMethod.getColValue(myQuerytblRow, myQuerytblCol, accountHeader);
			listOfAccFromGui.addAll(listOfAccPerPage);
	
		}

		System.out.println(listOfAccFromGui.size());
		System.out.println(listOfMyQueueAcc.size());
	

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

		for (int i = 0; i < myQueueTblPage.size(); i++) {
			clickOn(myQueueTblPage.get(i));

			if (r1ComMethod.clickOnCheckingHyperlink(myQuerytblRow, myQuerytblCol, dbAcc, "//a") == true)
				;
			{
				break;
			}

		}
	}

	// Click status month filter
	public void clickStatusMonth() {
		statusMonth.click();
	}

	// send in status month filter
	public void sendInStatusMonth(String month) {
		statusMonth.clear();
		statusMonth.sendKeys(month);
	}

	//

	public void checkContainInMyQueue(String search, String headerName, String searchElement)
			throws FileNotFoundException, IOException {
		if (search.equalsIgnoreCase(search)) {
			statusMonth.sendKeys(searchElement);
			listOfMyQueueCount = listOfMyQueue.size();
			searchEleRow = r1ComMethod.checkElementcontain(listOfQueue, homeReminderInfoCol, headerName,

					searchElement);
			statusMonth.clear();
		} /*
		 * else if (headerName.equalsIgnoreCase("Date")) {
		 * txtSearchDate.sendKeys(searchElement); homeRiminderRowCount =
		 * checkCountofTablerRow(); searchEleRow =
		 * r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol,
		 * headerName, searchElement); txtSearchDate.clear(); } else if
		 * (headerName.equalsIgnoreCase("Time")) {
		 * txtSearchTime.sendKeys(searchElement); homeRiminderRowCount =
		 * checkCountofTablerRow(); searchEleRow =
		 * r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol,
		 * headerName, searchElement); txtSearchTime.clear(); } else if
		 * (headerName.equalsIgnoreCase("Facility")) {
		 * txtSearchFacility.sendKeys(searchElement); homeRiminderRowCount =
		 * checkCountofTablerRow(); searchEleRow =
		 * r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol,
		 * headerName, searchElement); txtSearchFacility.clear(); } else if
		 * (headerName.equalsIgnoreCase("Notes")) {
		 * txtSearchNote.sendKeys(searchElement); homeRiminderRowCount =
		 * checkCountofTablerRow(); searchEleRow =
		 * r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol,
		 * headerName, searchElement); txtSearchNote.clear(); } else if
		 * (headerName.equalsIgnoreCase("Balance")) {
		 * txtSearchBalance.sendKeys(searchElement); homeRiminderRowCount =
		 * checkCountofTablerRow(); searchEleRow =
		 * r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol,
		 * headerName, searchElement); txtSearchBalance.clear();*
		 * 
		 * }
		 */
		Assert.assertEquals("Row for search element not match", listOfMyQueueCount, searchEleRow);
	}
	
	//press tab in date MM section 
	public void pressTabInDateTxtField()
	{
		comm.pressTab(statusMonth);
	}
	
	//verify tab press in date status section
	public void verifyTabInDateStatus() {
		
		Assert.assertTrue("Tab press failed for date section ", comm.verifyTabPressInNextSection(statusDay));
	}

}
