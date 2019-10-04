package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class HomePage extends BasePage {

	R1ContactCommonMethods r1ComMethod;
	CommonMethod com;
	private int homeRiminderRowCount;
	private String columnHeader = "Account Number";
	private String expectedTitle = "R1Contact";
	private int searchEleRow;
	int accountIndex;
	int totalcount;
	String reminderRow = "//table[@ng-table='tableParams']//tbody//tr";
	String defaultTime = "12:00 AM"; // It will remain constant
	String homeReminderInfoRow = "//table[@ng-table='tableParams']//tbody//tr[@ng-repeat='row in $data']";
	String homeReminderInfoCol = "//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th";
	String deleteIcon1Path = "]//td//i[@id='tooltip-popup-triggerDeleteReminder']";
	String officeXpath = "//span[text()='Office']";
	String officeSubmenu = "//span[text()='Office']//following-sibling::div/ul/li/a";
	String initiativesSubmenu = "//span[text()='Initiatives']//following-sibling::div/ul/li/span";
	String initiativesXpath = "//span[text()='Initiatives']";
	String helpSubmenu = "//span[text()='Help']//following-sibling::div/ul/li/a";
	String helpXpath = "//span[text()='Help']";
	String adminSubmenu = "//span[text()='Administration']//following-sibling::div/ul/li";
	String adminXpath = "//span[text()='Administration']";
	String customerPulsSubmenu = "//span[text()='Customer Pulse']//following-sibling::div/ul/li/a";
	String icePulsSubmenu = "//span[text()='ICE']//following-sibling::div/ul/li/a";
	String settingSubmenu = "//span[text()='Settings']//following-sibling::div/ul/li/a";

	/***************************** HomeAndReminder ***************************/
	@FindBy(xpath = "//strong[contains(text(),'Reminders')]/following-sibling::span")
	private WebElementFacade Reminders;
	@FindBy(xpath = "//div[@id='logo']//a[@href='/']")
	private WebElementFacade logo;
	@FindBy(xpath = "//div[@id='Accounts']/table/tbody/tr")
	private List<WebElementFacade> accountRows;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tbody//tr")
	private List<WebElementFacade> reminderList;
	@FindBy(xpath = "//i[contains(@id,'DeleteReminder')]")
	private List<WebElementFacade> delete;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tbody//tr[1]/td")
	private List<WebElementFacade> reminderListColumn;
	@FindBy(xpath = "//iframe[@src='/Home/SiteEntry']")
	private WebElementFacade headerframeName;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElementFacade homeTab;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tbody//tr[1]/td[1]/a")
	private WebElementFacade topReminder;
	@FindBy(xpath = "//div[@class= 'row account-boxes']//div[contains(text() , 'Balance')]//following-sibling::div")
	private WebElementFacade amountAtHompage;
	@FindBy(xpath = "//span[contains(text(),'Date')]")
	private WebElementFacade date;
	@FindBy(xpath = "//span[contains(text(),'Time')]")
	private WebElementFacade time;
	@FindBy(xpath = "//span[contains(text(),'Facility')]")
	private WebElementFacade Facility;
	@FindBy(xpath = "//span[contains(text(),'Account Number')]")
	private WebElementFacade accountnum;
	@FindBy(xpath = "//span[contains(text(),'Notes')]")
	private WebElementFacade notes;
	@FindBy(xpath = "//span[contains(text(),'Balance')]")
	private WebElementFacade Balance;
	@FindBy(xpath = "//span[text()='Help']")
	private WebElementFacade help;
	@FindBy(xpath = "//a[text()='My Tabs']")
	private WebElementFacade myTabs;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElementFacade hoverOnSerch;
	@FindBy(xpath = "span[text()='Office']")
	private WebElementFacade office;
	@FindBy(xpath = "//span[text()='Initiatives']")
	private WebElementFacade Initiatives;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElementFacade Search;
	@FindBy(xpath = "//span[text()='Office']")
	private WebElementFacade Office;
	@FindBy(xpath = "//span[text()='Administration']")
	private WebElementFacade Administration;
	@FindBy(xpath = "//a[text()='Accounts']")
	private WebElementFacade AccountElemnet;
	@FindBy(xpath = "//div[contains(text(),'Print Name')]//following-sibling::div ")
	private WebElementFacade agentPrintName;
	@FindBy(xpath = "//p[@class='pull-right']/strong")
	private WebElementFacade agentNameOnHomePage;
	@FindBy(xpath = "//table[@ng-table='tableParams']/tbody/tr")
	private WebElementFacade reminderTableRowsCnt;
	@FindBy(xpath = "//input[@name='remAccountNum']")
	private WebElementFacade txtSearchAccountNum;
	@FindBy(xpath = "//input[@name='remDate']")
	private WebElementFacade txtSearchDate;
	@FindBy(xpath = "//input[@name='remFacility']")
	private WebElementFacade txtSearchFacility;
	@FindBy(xpath = "//input[@name='remNotes']")
	private WebElementFacade txtSearchNote;
	@FindBy(xpath = "//input[@name='remBalance']")
	private WebElementFacade txtSearchBalance;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tbody//tr[@ng-repeat='row in $data']")
	private List<WebElementFacade> homeReminderTableRow;
	@FindBy(xpath = "//th[@data-title-text='Date']")
	private WebElementFacade dateReminderSearch;
	@FindBy(xpath = "//th[@data-title-text='Time']")
	private WebElementFacade timeReminderSearch;
	@FindBy(xpath = "//th[@data-title-text='Facility']")
	private WebElementFacade facilityReminderSearch;
	@FindBy(xpath = "//th[@data-title-text='Account Number']")
	private WebElementFacade accountNumReminderSearch;
	@FindBy(xpath = "//th[@data-title-text='Notes']")
	private WebElementFacade notesReminderSearch;
	@FindBy(xpath = "//th[@data-title-text='Balance']")
	private WebElementFacade balanceReminderSearch;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tr[@class='ng-table-sort-header']//th//span[text()='Date']")
	private WebElementFacade sortDateHeader;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tr[@class='ng-table-sort-header']//th//span[text()='Account Number']")
	private WebElementFacade sortAccNumHeader;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tr[@class='ng-table-sort-header']//th//span[text()='Facility']")
	private WebElementFacade sortFacilityHeader;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tr[@class='ng-table-sort-header']//th//span[text()='Notes']")
	private WebElementFacade sortNoteHeader;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tr[@class='ng-table-sort-header']//th//span[text()='Balance']")
	private WebElementFacade sortBalanceHeader;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tr[@class='ng-table-sort-header']//th[@class='header  sortable sort-desc']")
	private WebElementFacade sortDescElement;
	@FindBy(xpath = "//table[@ng-table='tableParams']//tr[@class='ng-table-sort-header']//th[@class='header  sortable sort-asc']")
	private WebElementFacade sortAscElement;
	@FindBy(xpath = "//div[@class='modal-dialog']//div[@class='modal-content']")
	private WebElementFacade deletePop;
	@FindBy(xpath = "//div[@class='modal-footer']//button[text()='Cancel']")
	private WebElementFacade cancelBtnIndeletePop;
	@FindBy(xpath = "//div[@class='modal-footer']//button[text()='Delete Reminder']")
	private WebElementFacade DeleteBtnIndeletePop;
	@FindBy(xpath = "//input[contains(@class,'form-control')][@id='Days']")
	private WebElementFacade txtToShowDate;
	@FindBy(xpath = "//button//div[@class='revert']")
	private WebElementFacade buttonToShowDate;

	/*
	 * page title
	 */
	public void verifyPageTitle() {
		String pageActualTitle = getDriver().getTitle();
		Assert.assertEquals("Page Title is not matching, Actual page title is:" + pageActualTitle, pageActualTitle,
				expectedTitle);
	}

	/*
	 * homePage tab and validate
	 */
	public void chechHomePageTab() {
		boolean clicked;
		try {
			homeTab.click();
			clicked = true;
		} catch (Exception e) {
			clicked = false;
			Assert.assertTrue("HomeTab is not working!", clicked);
		}
	}

	/*
	 * Number of reminders printed on header
	 */
	public int printedReminderOnHeader() {
		String headerReminderMessage = Reminders.getText();
		String[] message = headerReminderMessage.split(" ");
		int Printedreminders = Integer.parseInt(message[message.length - 2]); // Taking 2nd last array objet & changing
																				// their type
		return Printedreminders;

	}

	/* Logo verify */
	public void logoVerification() {
		boolean flag = logo.isDisplayed();
		Assert.assertTrue("Logo is not being displayed!", flag);
	}

	/*
	 * Reminder Filter
	 */
	public int checkCountofTablerRow() {
		boolean check = true;
		if (homeReminderTableRow.size() < 1) {
			check = false;
			Assert.assertTrue("Rowcount is less then Zero,NoRow found", check);
		} else {
			homeRiminderRowCount = homeReminderTableRow.size();
		}
		return homeRiminderRowCount;
	}

	/*
	 * verify filter search is not working
	 */
	public void checkContainHometable() throws FileNotFoundException, IOException {
		String searchElement = CommonMethod.readProperties("FilterSearch");
		totalcount = homeReminderTableRow.size();
		if (columnHeader.equalsIgnoreCase("Account Number")) {
			txtSearchAccountNum.sendKeys(searchElement);
			homeRiminderRowCount = homeReminderTableRow.size();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader,
					searchElement);
		} else if (columnHeader.equalsIgnoreCase("Date")) {
			txtSearchDate.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader,
					searchElement);
		} else if (columnHeader.equalsIgnoreCase("Facility")) {
			txtSearchFacility.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader,
					searchElement);
		} else if (columnHeader.equalsIgnoreCase("Notes")) {
			txtSearchNote.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader,
					searchElement);
		} else if (columnHeader.equalsIgnoreCase("Balance")) {
			txtSearchBalance.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader,
					searchElement);
		}
		Assert.assertEquals("Row for search element not match", homeRiminderRowCount, searchEleRow);
	}

	/* Agent name verification */
	public void verifyAgentName() throws InterruptedException {
		String agentNameFromTable = agentPrintName.getText();
		String agentNameFromHome = agentNameOnHomePage.getText();
		String[] agentArr = agentNameFromHome.split("\\(");
		String actualAgentName = agentArr[0];
		Assert.assertTrue("Agent name is not matching", agentNameFromTable.contains(actualAgentName));
	}

	public void switchHeaderFrame() {
		getDriver().switchTo().frame(headerframeName);
	}

	public void defaultFrame() {
		getDriver().switchTo().defaultContent();
	}

	public void clicOnHome() {
		clickOn(homeTab);
	}

	/* Verify header menu */
	public void verifyHeaderTab() {
		CommonMethod.isDisplayedMethod(homeTab);
		CommonMethod.isDisplayedMethod(myTabs);
		CommonMethod.isDisplayedMethod(Initiatives);
		CommonMethod.isDisplayedMethod(help);
		CommonMethod.isDisplayedMethod(Search);
		CommonMethod.isDisplayedMethod(Office);
		CommonMethod.isDisplayedMethod(Administration);

	}

	public void clickOnMyTab() {
		clickOn(myTabs);
	}

	public void clickForSerachAccount() {
		withAction().moveToElement(hoverOnSerch).click().build().perform();
		clickOn(AccountElemnet);
	}

	public void verifyDropdown(String menus, String elment, String propKey) {
		List<String> listOfmenu = new ArrayList<String>();
		List<String> actualSubmenu = com.handleBootStrapDropdown(menus, elment);
		String propSubmenu = CommonMethod.readProperties(propKey);
		String[] splittedSubmenu = propSubmenu.split("\\|");
		for (String submenu : splittedSubmenu) {
			listOfmenu.add(submenu);
		}
		Collections.sort(listOfmenu);
		Collections.sort(actualSubmenu);
		Assert.assertTrue("Office submenu list are not matching!", actualSubmenu.retainAll(listOfmenu));

	}

	public void verifyInnerDropdown(String options, String element, String clickMenuName, String innerOptions,
			String propKey) throws InterruptedException {
		List<String> listOfmenu = new ArrayList<String>();
		List<String> actualSubmenu = com.handleInnerBootStrapDropdown(options, element, clickMenuName, innerOptions);
		String propSubmenu = CommonMethod.readProperties(propKey);
		String[] splittedSubmenu = propSubmenu.split("\\|");
		for (String submenu : splittedSubmenu) {
			listOfmenu.add(submenu);
		}
		Collections.sort(listOfmenu);
		Collections.sort(actualSubmenu);
		Assert.assertTrue("submenu list are not matching!", actualSubmenu.equals(listOfmenu));
	}
	/*
	 * header menu dropdowns
	 */

	public void verifyHeaderdropdownLinks() throws InterruptedException {
		verifyOfficeDropdown();
		verifyInitiativesDropdown();
		verifyCustomerPulse();
		verifyICE();
		verifyHelpDropdown();
		verifyadminDropdown();
		verifySettingDropdown();
	}

	public void verifyOfficeDropdown() {
		verifyDropdown(officeSubmenu, officeXpath, "OfficeDropdowns");
	}

	public void verifyInitiativesDropdown() {
		verifyDropdown(initiativesSubmenu, initiativesXpath, "InitiativesDropdowns");
	}

	public void verifyHelpDropdown() {
		verifyDropdown(helpSubmenu, helpXpath, "HelpDropdowns");
	}

	public void verifyadminDropdown() {
		verifyDropdown(adminSubmenu, adminXpath, "AdminDropdowns");
	}

	public void verifyCustomerPulse() throws InterruptedException {
		verifyInnerDropdown(initiativesSubmenu, initiativesXpath, "Customer Pulse", customerPulsSubmenu,
				"CustomerPulseDropdowns");
	}

	public void verifyICE() throws InterruptedException {
		verifyInnerDropdown(initiativesSubmenu, initiativesXpath, "ICE", icePulsSubmenu, "ICEDropdowns");
	}

	public void verifySettingDropdown() throws InterruptedException {
		verifyInnerDropdown(adminSubmenu, adminXpath, "Settings", settingSubmenu, "SettingsDropdowns");
	}

	public void reminderHeader() {
		CommonMethod.isDisplayedMethod(date);
		CommonMethod.isDisplayedMethod(time);
		CommonMethod.isDisplayedMethod(Facility);
		CommonMethod.isDisplayedMethod(accountnum);
		CommonMethod.isDisplayedMethod(notes);
		CommonMethod.isDisplayedMethod(Balance);
	}

	/*
	 * verify reminder list size
	 * 
	 */
	public void checkreminderList() {
		int actualReminders = homeReminderTableRow.size();
		if (actualReminders > 1) {
			int expectedReminders = printedReminderOnHeader();
			Assert.assertEquals("Number of reminders are not matching", actualReminders, expectedReminders);
		} else {
			Assert.assertTrue("No reminders present", actualReminders == 0);
		}
	}

	/******************************************************
	 * Verify balance
	 ************************************************************************/

	public void verifyBalance() {
		ArrayList<String> ListOfBalance = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Balance");
		if (ListOfBalance.size() > 1) {
			String TopBalance = ListOfBalance.get(0).substring(1);
			topReminder.click();
			String amount = amountAtHompage.getText();
			Assert.assertEquals(TopBalance, amount);
		}

	}

	/**************************************************************
	 * ReminderSearchField
	 *********************************************/

	public void verifyReminderSearch() {
		CommonMethod.isDisplayedMethod(dateReminderSearch);
		CommonMethod.isDisplayedMethod(timeReminderSearch);
		CommonMethod.isDisplayedMethod(facilityReminderSearch);
		CommonMethod.isDisplayedMethod(accountNumReminderSearch);
		CommonMethod.isDisplayedMethod(notesReminderSearch);
		CommonMethod.isDisplayedMethod(balanceReminderSearch);

	}

	/**********************************************************
	 * Verify default time
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 **********************************************/

	public void verifyDefaultTime() throws FileNotFoundException, IOException {
		ArrayList<String> listOfAccount = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol,
				"Account Number");
		ArrayList<String> listOfTime = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Time");
		for (int i = 0; i < listOfAccount.size(); i++) {
			String accountNum = listOfAccount.get(i);
			if (accountNum.contentEquals(accountNumber())) {
				accountIndex = i;
			}
		}
		String ActualTime = listOfTime.get(accountIndex);
		Assert.assertEquals(ActualTime, defaultTime);
	}

	/*--------------------------------------Sorting In ascending-------------------------------------------------------*/

	private void checkAscShortingStatus() {
		boolean chkShortStatus = true;
		if (sortDescElement.isDisplayed()) {
			clickOn(sortDescElement);
			if (sortAscElement.isDisplayed()) {
				r1ComMethod.verifySorting(homeReminderInfoRow, homeReminderInfoCol, columnHeader);
			} else {
				chkShortStatus = false;
				Assert.assertTrue("Element for Assending is not visible", chkShortStatus);
			}
		}
	}

	public void sortingAscColumnHead() {

		if (columnHeader.equalsIgnoreCase("Account Number")) {

			clickOn(sortAccNumHeader);
			checkAscShortingStatus();

		} else if (columnHeader.equalsIgnoreCase("Facility")) {

			clickOn(sortFacilityHeader);
			checkAscShortingStatus();

		} else if (columnHeader.equalsIgnoreCase("Notes")) {

			clickOn(sortNoteHeader);
			checkAscShortingStatus();

		} else if (columnHeader.equalsIgnoreCase("Balance")) {

			clickOn(sortBalanceHeader);
			checkAscShortingStatus();
		}

	}

	/*--------------------------------------Sorting In descending-------------------------------------------------------*/

	private void checkDescShortingStatus() {
		boolean chkDescStatus = true;
		if (sortDescElement.isDisplayed()) {

			r1ComMethod.verifyDescSorting(homeReminderInfoRow, homeReminderInfoCol, columnHeader);

		} else {
			chkDescStatus = false;
			Assert.assertTrue("Element for Assending is not visible", chkDescStatus);
		}
	}

	public void sortingDescColumnHeader() {

		if (columnHeader.equalsIgnoreCase("Account Number")) {

			clickOn(sortAccNumHeader);
			checkDescShortingStatus();

		} else if (columnHeader.equalsIgnoreCase("Facility")) {

			clickOn(sortFacilityHeader);
			checkDescShortingStatus();

		} else if (columnHeader.equalsIgnoreCase("Notes")) {

			clickOn(sortNoteHeader);
			checkDescShortingStatus();

		} else if (columnHeader.equalsIgnoreCase("Balance")) {

			clickOn(sortBalanceHeader);
			checkDescShortingStatus();
		}

	}

	/**********************************************************
	 * check reminder creation
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 ********************************************************************/

	public void reminderCreatedOrNot() throws FileNotFoundException, IOException {
		ArrayList<String> listOfAccount = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol,
				"Account Number");
		ArrayList<String> listOfNotes = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Notes");
		for (int i = 0; i < listOfAccount.size(); i++) {
			String accountNum = listOfAccount.get(i);
			if (accountNum.contentEquals(accountNumber())) {
				boolean flag = listOfNotes.get(i).contentEquals(ReminderPage.noteText);
				Assert.assertTrue(flag);
			}

		}
	}

	/*--------------------------------------Verify  Delete icon Populating-------------------------------------------------------*/

	public void verifyDeletingIconPoulating() throws InterruptedException {
		int rowCnt = homeReminderTableRow.size();
		boolean checkDelPop = true;
		if (rowCnt > 1) {
			for (int row = 1; row <= rowCnt; row++) {
				String deleteIconPath = homeReminderInfoRow + "[" + row + deleteIcon1Path;

				WebElementFacade deleteIcon = element(By.xpath(deleteIconPath));

				if (deleteIcon.isDisplayed()) {

					Thread.sleep(2000);

					clickOn(deleteIcon);

					if (deletePop.isDisplayed()) {
						if (DeleteBtnIndeletePop.isDisplayed()) {
							clickOn(cancelBtnIndeletePop);
						} else {
							checkDelPop = false;
							Assert.assertTrue("deltion button in pop  not found", checkDelPop);
						}

					} else {
						checkDelPop = false;
						Assert.assertTrue("Deletion Pop not found", checkDelPop);
					}

				}

			}
		}
	}

	/****************************************************
	 * Set Reminders size
	 **************************************************************/

	public void changeVisibleDate() {
		txtToShowDate.clear();
		txtToShowDate.sendKeys(CommonMethod.readProperties("txtToShowDate"));
		clickOn(buttonToShowDate);
	}

	/*********************************************************
	 * Today's tab back ground-color
	 ***********************************************/

	public void todayTabColor(String expectedCssValue) {
		String day = "Today";
		ArrayList<String> ListOfDate = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Date");
		for (int i = 0; i < ListOfDate.size(); i++) {
			if (ListOfDate.get(i).contains(day)) {
				int rowIndex = i + 1;
				String actualCssValue = element(By.xpath(homeReminderInfoRow + "[" + rowIndex + "]"))
						.getCssValue("background-color");
				Assert.assertEquals(actualCssValue, expectedCssValue);
				break;
			}
		}
	}

	/*********************************************************
	 * Get Account Number from property File
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 ***********************************************/

	public static String accountNumber() throws FileNotFoundException, IOException {

		return CommonMethod.readProperties("AccountNumber");

	}
}
