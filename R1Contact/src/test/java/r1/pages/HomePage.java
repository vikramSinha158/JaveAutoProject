package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.utilities.CommonMethod;

public class HomePage extends BasePage {
	R1ContactCommonMethods r1ComMethod;
	CommonMethod com;
	private int homeRiminderRowCount;
	private String expectedTitle = "R1Contact";
	private int searchEleRow;
	int accountIndex;
	int totalcount;
	public static String agentEmailID;
	HashMap<String, String> agentInformation;
	String reminderRow = "//table[@ng-table='tableParams']//tbody//tr";
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
	String remDate = "DATE_REMINDER";
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
	@FindBy(xpath = "//div[contains(text(),'Email')]//following-sibling::div")
	private WebElementFacade agentEmail;
	@FindBy(xpath = "//table[@ng-table='tableParams']/thead/tr[1]/th/div/span")
	private List<WebElementFacade> reminderHeader;
	@FindBy(xpath = "//div[@class='ng-table-pager ng-scope']/ul/li/a/span")
	private List<WebElementFacade> tablePageNumber;
	@FindBy(xpath = "//input[@name='remTime']")
	private WebElementFacade txtSearchTime;
	@FindBy(xpath = "//div[@class='flt-lft left-item']")
	private List<WebElementFacade> agentHeaders;
	@FindBy(xpath = "//div[@class='flt-lft right-item']") // new
	private List<WebElementFacade> agentValues;

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

	/************************************************
	 * 
	 * Reminder Filter
	 ***********************************/
	public int checkCountofTablerRow() {
		boolean check = true;
		if (homeReminderTableRow == null) {
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
	public void checkContainHometable(String search, String headerName) throws FileNotFoundException, IOException {
		String searchElement = CommonMethod.readProperties(search);
		totalcount = homeReminderTableRow.size();
		if (headerName.equalsIgnoreCase("Account Number")) {
			txtSearchAccountNum.sendKeys(searchElement);
			homeRiminderRowCount = homeReminderTableRow.size();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchAccountNum.clear();
		} else if (headerName.equalsIgnoreCase("Date")) {
			txtSearchDate.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchDate.clear();
		} else if (headerName.equalsIgnoreCase("Time")) {
			txtSearchTime.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchTime.clear();
		} else if (headerName.equalsIgnoreCase("Facility")) {
			txtSearchFacility.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchFacility.clear();
		} else if (headerName.equalsIgnoreCase("Notes")) {
			txtSearchNote.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchNote.clear();
		} else if (headerName.equalsIgnoreCase("Balance")) {
			txtSearchBalance.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchBalance.clear();
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

	String settingMenuPath = "//span[text()='Administration']//following-sibling::div/ul/li/span";

	public void clickOnSubMenu(String subManuItemClick) throws InterruptedException {
		r1ComMethod.clickSubMenudropdown(adminXpath, adminSubmenu, "Settings", settingSubmenu, subManuItemClick);
	}

	/**********************************************************
	 * Verify reminder header are in caps or not
	 * 
	 * 
	 **********************************************/
	public void verifyReminderHeaderCaps() {
		boolean capsCheck = true;
		for (int i = 0; i < reminderHeader.size() - 1; i++) {
			capsCheck = com.isUpperCaseCheck(reminderHeader.get(i).getText());
			Assert.assertTrue(reminderHeader.get(i).getText() + " does not contain upper case ", capsCheck);
			com.highLightSteps(reminderHeader.get(i));
		}
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
		if (actualReminders < 1) {
			Assert.assertFalse("No reminders present", true);
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
	 * Verify reminder time from home page reminder table
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 **********************************************/
	public void verifyReminderTimeInHome(String dbAccNum, String expectedTime)
			throws FileNotFoundException, IOException, InterruptedException {
		boolean checkClk = false;
		for (int j = 0; j < tablePageNumber.size(); j++) {
			clickOn(tablePageNumber.get(j));
			ArrayList<String> listOfAccount = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol,
					"Account Number");
			ArrayList<String> listOfTime = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Time");
			for (int i = 0; i < listOfAccount.size(); i++) {
				String accountNum = listOfAccount.get(i);
				if (accountNum.contentEquals(dbAccNum)) {
					accountIndex = i;
					String ActualTime = listOfTime.get(accountIndex);
					Assert.assertEquals(expectedTime, ActualTime);
					checkClk = true;
					break;
				}
			}
			if (checkClk == true)
				break;
		}
	}

	/*--------------------------------------Sorting In ascending-------------------------------------------------------*/
	private void checkAscShortingStatus(String colHeader) {
		boolean chkShortStatus = true;
		if (sortDescElement.isDisplayed()) {
			clickOn(sortDescElement);
			if (sortAscElement.isDisplayed()) {
				r1ComMethod.verifySorting(homeReminderInfoRow, homeReminderInfoCol, colHeader);
			} else {
				chkShortStatus = false;
				Assert.assertTrue("Element for Assending is not visible", chkShortStatus);
			}
		}
	}

	public void sortingAscColumnHead(String columnHeaderAsc) {
		if (columnHeaderAsc.equalsIgnoreCase("Account Number")) {
			clickOn(sortAccNumHeader);
			checkAscShortingStatus(columnHeaderAsc);
		} else if (columnHeaderAsc.equalsIgnoreCase("Facility")) {
			clickOn(sortFacilityHeader);
			checkAscShortingStatus(columnHeaderAsc);
		} else if (columnHeaderAsc.equalsIgnoreCase("Notes")) {
			clickOn(sortNoteHeader);
			checkAscShortingStatus(columnHeaderAsc);
		} else if (columnHeaderAsc.equalsIgnoreCase("Balance")) {
			clickOn(sortBalanceHeader);
			checkAscShortingStatus(columnHeaderAsc);
		}
	}

	/*--------------------------------------Sorting In descending-------------------------------------------------------*/
	private void checkDescShortingStatus(String colHeaderdsc) {
		boolean chkDescStatus = true;
		if (sortDescElement.isDisplayed()) {
			r1ComMethod.verifyDescSorting(homeReminderInfoRow, homeReminderInfoCol, colHeaderdsc);
		} else {
			chkDescStatus = false;
			Assert.assertTrue("Element for Assending is not visible", chkDescStatus);
		}
	}

	public void sortingDescColumnHeader(String columnHeaderDsc) {
		if (columnHeaderDsc.equalsIgnoreCase("Account Number")) {
			clickOn(sortAccNumHeader);
			checkDescShortingStatus(columnHeaderDsc);
		} else if (columnHeaderDsc.equalsIgnoreCase("Facility")) {
			clickOn(sortFacilityHeader);
			checkDescShortingStatus(columnHeaderDsc);
		} else if (columnHeaderDsc.equalsIgnoreCase("Notes")) {
			clickOn(sortNoteHeader);
			checkDescShortingStatus(columnHeaderDsc);
		} else if (columnHeaderDsc.equalsIgnoreCase("Balance")) {
			clickOn(sortBalanceHeader);
			checkDescShortingStatus(columnHeaderDsc);
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

	/*--------------------------------------Verify  Delete reminder account -------------------------------------------------------*/
	public void verifyDeleteReminderHome(String dbAccNum, String expectedTime)
			throws FileNotFoundException, IOException, InterruptedException {
		boolean delStatus = false;
		for (int j = 0; j < tablePageNumber.size(); j++) {
			clickOn(tablePageNumber.get(j));
			ArrayList<String> listOfAccount = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol,
					"Account Number");
			ArrayList<String> listOfDate = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Date");
			for (int i = 0; i < listOfAccount.size(); i++) {
				String accountNum = listOfAccount.get(i);
				if (accountNum.contentEquals(dbAccNum)) {
					accountIndex = i;
					;
					String ActualDate = listOfDate.get(accountIndex);
					Assert.assertEquals(
							"Actual date " + ActualDate + " does not with expected date "
									+ ReminderPage.reminderDateToFill(remDate),
									ReminderPage.reminderDateToFill(remDate), ActualDate);
					int delrow = i + 1;
					String delIconPath = homeReminderInfoRow + "[" + delrow + deleteIcon1Path;
					WebElementFacade delIcon = element(By.xpath(delIconPath));
					if (delIcon.isDisplayed()) {
						Thread.sleep(2000);
						clickOn(delIcon);
						if (deletePop.isDisplayed()) {
							clickOn(DeleteBtnIndeletePop);
							ArrayList<String> listOfAccAfterAccDel = r1ComMethod.getColValue(homeReminderInfoRow,
									homeReminderInfoCol, "Account Number");
							ArrayList<String> listOfDateAfterAccDel = r1ComMethod.getColValue(homeReminderInfoRow,
									homeReminderInfoCol, "Date");
							if (listOfAccAfterAccDel.contains(dbAccNum)) {
								int accIndex = listOfAccAfterAccDel.indexOf(dbAccNum);
								if (listOfDateAfterAccDel.get(accIndex)
										.equalsIgnoreCase(ReminderPage.reminderDateToFill(remDate))) {
									delStatus = false;
									Assert.assertTrue("Account is not deleted,check it manually ", delStatus);
								}
							} else {
								delStatus = true;
								break;
							}
						}
					}
				}
			}
			if (delStatus == true)
				break;
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
		for (int j = 0; j < tablePageNumber.size(); j++) {
			clickOn(tablePageNumber.get(j));
			ArrayList<String> ListOfDate = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Date");
			for (int i = 0; i < ListOfDate.size(); i++) {
				if (ListOfDate.get(i).contains(day)) {
					int rowIndex = i + 1;
					String actualCssValue = element(By.xpath(homeReminderInfoRow + "[" + rowIndex + "]"))
							.getCssValue("background-color");
					Assert.assertEquals(actualCssValue, expectedCssValue);
				}
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

	/*--------------------------------------Return Agent Email Id------------------------------------------------------*/
	public String agentEmailId() {
		agentEmailID = agentEmail.getText();
		return agentEmailID;
	}

	/* search reminder by account number */
	public void searchremByAccNUm(String accNum) {
		txtSearchAccountNum.clear();
		txtSearchAccountNum.sendKeys(accNum);
	}

	/* verify tomorrow reminder color */
	public void verifyTomRemCol() {
		String expectedCssValue = "rgba(233, 243, 252, 1)";
		String actualCssValue = element(By.xpath("//div[@id='ReminderGrid']/div/table/tbody/tr[@class='normal']"))
				.getCssValue("background-color");
		Assert.assertEquals(actualCssValue, expectedCssValue);
	}

	/* verify expired reminder color */
	public void verifyExpiredRem() {
		String expectedCssValue = "rgba(248, 248, 248, 1)";
		String actualCssValue = element(By.xpath("//div[@id='ReminderGrid']/div/table/tbody/tr[@class='past']"))
				.getCssValue("background-color");
		Assert.assertEquals(actualCssValue, expectedCssValue);
	}

	// verify agent information headers
	public void verifyAgentHeader() {
		List<String> list = new ArrayList<String>();
		List<String> namesList = Arrays.asList("PRINT NAME", "LOCATION", "MANAGER", "ROLE", "UNIT", "TEAM", "EMAIL",
				"PHONE", "SHIFT", "START DATE", "MAX VAL", "MESSAGE");
		int size = agentHeaders.size();
		for (int i = 0; i < size; i++) {
			list.add(agentHeaders.get(i).getText());
		}
		Assert.assertTrue("Some agent information headers aren't missing", list.containsAll(namesList));
	}

	/* verify agent values from DB vik */

	public void verifyAgentInformation()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException {
		agentInformation = new HashMap<>();
		for (int i = 0; i < agentHeaders.size(); i++) {

			agentInformation.put(agentHeaders.get(i).getText().trim(), agentValues.get(i).getText().trim());

		}

		verifyAgentHeaderValue("PRINT NAME");
		verifyAgentHeaderValue("EMAIL");
		verifyAgentHeaderValue("PHONE");
		verifyAgentHeaderValue("MANAGER");
		verifyAgentHeaderValue("MAX VAL");
		verifyAgentHeaderValue("MESSAGE");
		verifyAgentHeaderValue("START DATE");

	}

	/* Method to very values from DB agent values from DB vik */
	public void verifyAgentHeaderValue(String Header)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException {
		R1ContactCommonMethods.runQuery("AgentInfo");
		DatabaseConn.resultSet.next();

		for (Map.Entry<String, String> entry : agentInformation.entrySet()) {

			if (Header.equalsIgnoreCase("PRINT NAME")) {

				Assert.assertTrue("", DatabaseConn.resultSet.getString("agentPrintName")
						.equalsIgnoreCase(agentInformation.get("PRINT NAME")));
				break;
			} else if (Header.equalsIgnoreCase("MANAGER")) {

				Assert.assertTrue("", DatabaseConn.resultSet.getString("agentManager")
						.equalsIgnoreCase(agentInformation.get("MANAGER")));
				break;
			} else if (Header.equalsIgnoreCase("EMAIL")) {

				Assert.assertTrue("",
						DatabaseConn.resultSet.getString("agentEmail").equalsIgnoreCase(agentInformation.get("EMAIL")));
				break;
			} else if (Header.equalsIgnoreCase("PHONE")) {

				Assert.assertTrue("",
						DatabaseConn.resultSet.getString("agentPhone").equalsIgnoreCase(agentInformation.get("PHONE")));

				break;
			} else if (Header.equalsIgnoreCase("MAX VAL")) {

				Assert.assertTrue("", DatabaseConn.resultSet.getString("agentMaxVal")
						.equalsIgnoreCase(agentInformation.get("MAX VAL")));
				System.out.println(agentInformation.get("MAX VAL"));
				break;
			} else if (Header.equalsIgnoreCase("MESSAGE")) {

				Assert.assertTrue("", DatabaseConn.resultSet.getString("agentMessage")
						.equalsIgnoreCase(agentInformation.get("MESSAGE")));
				System.out.println(agentInformation.get("MESSAGE"));
				break;
			} else if (Header.equalsIgnoreCase("START DATE")) {

				String startdateDb = DatabaseConn.resultSet.getString("agentStartDate");

				SimpleDateFormat dbDateFormate = new SimpleDateFormat("yyyy-MM-dd");
				Date dbDate = dbDateFormate.parse(startdateDb);
				SimpleDateFormat convertedFormate = new SimpleDateFormat("MM/dd/yyyy");

				String convertedDbDate = convertedFormate.format(dbDate);

				Assert.assertTrue("", convertedDbDate.equalsIgnoreCase(agentInformation.get("START DATE")));

				break;
			}

		}

	}

}
