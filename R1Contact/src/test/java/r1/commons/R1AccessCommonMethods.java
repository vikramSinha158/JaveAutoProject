package r1.commons;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class R1AccessCommonMethods extends BasePage {

	Select select;
	String value = "";
	public ArrayList colValues;
	public ArrayList columnValue;
	int countBeforeCheckOut;
	int countAfterCheckOut;
	boolean flag = false;

	/*------------------------- SELECT FACILITY AND CLICK   XPath ---------------------------------------------------*/

	@FindBy(xpath = "//select[contains(@id,'LocationChooser_ddlLocation')]")
	private WebElementFacade facility;

	@FindBy(xpath = "//a[contains(@id,'LocationChooser_hypLoc')]")
	private WebElementFacade facilityList;

	/*------------------------- WORKLIST CLEAR FILTER BUTTON   XPath ---------------------------------------------------*/

	@FindBy(xpath = "//td/a/a[@class='GBtn']")
	private List<WebElementFacade> workListData;

	@FindBy(xpath = "//a[contains(@id , 'grid_lnkClear')]")
	private WebElementFacade showAll;

	/*------------------------- SEARCH..BUTTON..VISIT..SSN..LAST/FIRST.NAME..MEDICAL..RECORD..XPath ---------------------*/

	@FindBy(xpath = "//input[contains(@name,'txtVisit')]")
	private WebElementFacade visitIDTextArea;

	@FindBy(xpath = "//input[contains(@name,'txtSSN')]")
	private WebElementFacade sSN;

	@FindBy(xpath = "//input[contains(@name,'txtLastName')]")
	private WebElementFacade lName;

	@FindBy(xpath = "//input[contains(@name,'txtFirstName')]")
	private WebElementFacade fName;

	@FindBy(xpath = "//input[contains(@name,'txtMedRec')]")
	private WebElementFacade medicalRecord;

	@FindBy(xpath = "//a[contains(@id,'btnSearch')]")
	private WebElementFacade searchButton;

	/*------------------------- CHECK OUT OR REDO  XPath ----------------------------------------------------------------*/

	@FindBy(xpath = "//td[@class ='actionButtons' ]//a[text()='Check Out']")
	private WebElementFacade checkOut;

	@FindBy(xpath = "//td[@class ='actionButtons' ]//a[text()='Redo']")
	private WebElementFacade redo;

	@FindBy(xpath = "//td[@class ='actionButtons' ]//a")
	private List<WebElementFacade> actionButtons;

	@FindBy(xpath = "//td[@class ='actionButtons' ]//a[text()='Check Out']")
	private List<WebElementFacade> CheckOut;

	@FindBy(xpath = "//td[@class ='actionButtons' ]//a[text()='Redo']")
	private List<WebElementFacade> Redo;

	/*-------------------------..WORKLIST..NEW SEARCH XPath ---------------------------------------------------*/

	@FindBy(xpath = "//span[@class='main_dnnmenu_bar']//a /following-sibling::span[@class='txt']")
	private List<WebElementFacade> accountDetailMenuLinks;

	@FindBy(xpath = "//*[contains(@id,'WorklistPanel_grid_grdWorklist')]//tr[@valign= 'middle']")
	private List<WebElementFacade> Worklist;

	@FindBy(xpath = "//table[contains(@id,'l_grid_grdWorklist')]//tr[2]")
	private WebElementFacade clickFirstAcct;

	@FindBy(xpath = "//select[contains(@id ,'grid_ddlPatientType' )]")
	private WebElementFacade patientTypeDropdown;

	@FindBy(xpath = "//ul[@class ='rtbUL']//li[@class = 'rtbItem rtbBtn']")
	private List<WebElementFacade> myHeaderList;

	@FindBy(xpath = "//div[@id='uwtMainMenu']")
	private WebElementFacade verifyHeaderList;

	@FindBy(xpath = "//table[contains(@id,'accTaskAction_dlActions')]//td//a")
	private List<WebElementFacade> actionsStatusTab;

	@FindBy(xpath = "//ul[@class = 'detailTabs' ]//li")
	private List<WebElementFacade> tabs;

	@FindBy(xpath = "//span[contains (@id, 'accTaskAction_lblStatus' )]")
	private WebElementFacade statusLabel;

	/*-------------------------SUB MODULES XPath ---------------------------------------------------*/

	@FindBy(xpath = "//div[@class='side_nav']//a /following-sibling::span[@class='txt']")
	private List<WebElementFacade> sideaccountDetailMenuLinks;

	/*------------------------- MODULES XPath ---------------------------------------------------*/

	@FindBy(xpath = "//ul[@class='detailTabs']//li")
	private List<WebElementFacade> r1AccesModules;

	/*------------------------- FILTER FOLDER XPath-----------------------------------------------*/

	@FindBy(xpath = "//select[contains(@id , 'grid_ddlColumns')]")
	private WebElementFacade ddlFilter;

	@FindBy(xpath = "//select[contains(@id , 'grid_ddlClauses')]")
	private WebElementFacade ddlOperator;

	@FindBy(xpath = "//input[contains(@id , 'grid_txtSearch')]")
	private WebElementFacade textBox1;

	@FindBy(xpath = "//input[contains(@id , 'grid_txtSearchEnd')]")
	private WebElementFacade textBox2;

	@FindBy(xpath = "//a[contains (@id , 'grid_btnFilter')]")
	private WebElementFacade filterButton;

	/*
	 * ...................................FOOTER LINK-
	 * XPATH.............................................
	 */

	@FindBy(xpath = "//div[@id='footer_nav']/span/a")
	private List<WebElementFacade> footerR1AccessModulesTab;

	/*
	 * ...................................TAB COMPLETED OR
	 * NOT.........................................
	 */

	@FindBy(xpath = "//ul[@class='detailTabs']//li//a")

	private List<WebElementFacade> tabColor;

	/*
	 * ...................................USER MANAGEMENT
	 * XPATH.........................................
	 */

	@FindBy(xpath = "//span[@class='txt'][text()='User Management']")
	private WebElementFacade userManagement;

	@FindBy(xpath = "//select[contains(@id , 'Users_ddlSearchType' ) ]")
	private WebElementFacade userSearchType;

	@FindBy(xpath = "//input[contains(@id , 'Users_txtSearch' ) ]")
	private WebElementFacade userSearchTextBox;

	@FindBy(xpath = "//input[contains(@id , 'Users_btnSearch' ) ]")
	private WebElementFacade userSearchButton;

	@FindBy(xpath = "//img[contains(@id , 'Users_grdUsers_Hyperlink1Image_0')]")
	private WebElementFacade userEditButton;

	@FindBy(xpath = "//input[contains(@id , 'ManageUsers_cblRoles')]")
	private List<WebElementFacade> userRolesCheckbox;

	@FindBy(xpath = "//table[contains(@id , 'ManageUsers_cblRoles')]//label")
	private List<WebElementFacade> userRoles;

	@FindBy(xpath = "//input[@value = 'Update User']")
	private WebElementFacade updateUser;

	/*
	 * ...................................FACILITY SETTINGS
	 * XPATH................................
	 */

	@FindBy(xpath = "//*[@id = 'dllLocationSearch']")
	private WebElementFacade select_search_field_dropDown;

	@FindBy(xpath = "//*[@id = 'txtLocSearchValue']")
	private WebElementFacade search_value_textbox;

	@FindBy(xpath = "//span[contains(@id,'BtnLocSearch')]")
	private WebElementFacade search_value_button;

	@FindBy(xpath = "//a[@title= 'View Location Facility Setting'] ")
	private WebElementFacade view_icon;

	@FindBy(xpath = "//SELECT[contains(@id,'dllFSSearch')]")
	private WebElementFacade select_setting_dropdown;

	@FindBy(xpath = "//INPUT[contains(@id,'txtFSSearchValue')]")
	private WebElementFacade search_setting_textbox;

	@FindBy(xpath = "//SPAN[contains(@id,'BtnFSSearch')]")
	private WebElementFacade search_setting_button;

	@FindBy(xpath = "//div[@text = 'Update Facility Setting']")
	private WebElementFacade edit_facility_setting;

	@FindBy(xpath = "//textarea[@id='txtSettingValue']")
	private WebElementFacade text_setting_value;

	@FindBy(xpath = "//input[@id='Button1']")
	private WebElementFacade update_facility_button;

	/*------------------------PATIENT TYPE O/I/E/S in INNNER GRID----------------------------------------------------------*/

	@FindBy(xpath = "//span[contains(@id,'lblPatientType')]")
	private WebElementFacade patientType;

	/*----------------------------------- CACHE  XPATH----------------------------------------------------------------------*/

	@FindBy(xpath = "//input[contains(@id , \"btnClearAll\")]")

	private WebElementFacade cache_clear_all;

	@FindBy(xpath = "//span[@class='txt'][text()='Cache']")
	private WebElementFacade cache_link;

	/*-------------------------  COVERAGES   XPath ---------------------------------------------------*/

	@FindBy(xpath = "//img[@alt='Delete']")
	private WebElementFacade deleteCoverage;

	@FindBy(xpath = "//a[contains(@id,'btnAddNew')]//img")
	private WebElementFacade plusSign;

	@FindBy(xpath = "//input[contains(@id,'_txtSearchPayors')]")
	private WebElementFacade searchPayorplanTextBox;

	@FindBy(xpath = "//a[contains(@id,'btnRunSearch')]")
	private WebElementFacade searchPayorplanSearchBtn;

	@FindBy(xpath = "//table[contains(@id , 'CoverageSearchResults')]//tr[2]//a")
	private WebElementFacade coverageSearchResult;

	public String clickOnAccountReturnEncounterID(String colName) {

		String rowLocator = "//td/a/a[@class='GBtn']";
		String colLocator = "//tr[@class='tableHeader']//td";
		String colValues = "";

		int rowSize = findAll(By.xpath(rowLocator)).size();
		int colSize = findAll(By.xpath(colLocator)).size();

		for (int i = 1; i <= colSize; i++) {
			String colLocator1 = colLocator + "[" + i + "]";
			if (element(By.xpath(colLocator1)).getText().equalsIgnoreCase(colName)) {
				for (int j = 2; j <= rowSize; j++) {
					String rowLocator2 = rowLocator + "[" + j + "]/td[" + i + "]";
					colValues = element(By.xpath(rowLocator2)).getText();
				}
				break;
			}
		}
		return colValues;

	}

	/*
	 * ......FOOTER LINK..HOME-- PATIENT SATISFCACTION---PATIENT ACCESS --BILLING
	 * FOLLOW UP-- HEALTH INFORMATION--CBO--SETTINGS................
	 */

	public void clickFooterR1AccesModulesTab(String tab) {
		for (int i = 0; i < footerR1AccessModulesTab.size(); i++) {
			if (footerR1AccessModulesTab.get(i).getText().equalsIgnoreCase(tab)) {
				withAction().moveToElement(footerR1AccessModulesTab.get(i)).click().build().perform();
				break;
			}
		}
	}

	/*------------------------- PATIENT COVERGAE SERVICE RESIDUAL CLEARANCE SETTLEMENT LOG FCC CONTACT AUTHORIZATION  NOTES-------------------*/

	public void clickR1AccesModulesTab(String tab) {
		for (int i = 0; i < r1AccesModules.size(); i++) {
			if (r1AccesModules.get(i).getText().equalsIgnoreCase(tab)) {
				withAction().moveToElement(r1AccesModules.get(i)).click().build().perform();
				break;
			}
		}
	}

	/*------------------------- NEW TASK COLUMNS SEARCH EXPORT SAVE LIST CONFIG ------------------------------*/

	public void clickUpperHeaderLink(String item) {
		for (int i = 0; i < myHeaderList.size(); i++) {
			if (myHeaderList.get(i).getText().toString().equalsIgnoreCase(item)) {
				clickOn(myHeaderList.get(i));
				break;
			}

		}
	}

	public void verifyUpperHeaderExists() {
		Assert.assertTrue("Upper Header Is getting Displayed", verifyHeaderList.isDisplayed());
	}

	/*-------------------------CHECK OUT OR REDO ---------------------------------------------------------*/

	public void clickOnCheckOut() {
		int count1 = CheckOut.size();
		if (count1 > 0) {
			CheckOut.get(0).click();
		}
		int count2 = Redo.size();
		if (count2 > 0) {
			Redo.get(0).click();
		}
	}

	public void checkOut() {
		int count1 = CheckOut.size();
		if (count1 > 0) {
			CheckOut.get(0).click();
		}
		int count2 = Redo.size();
		if (count2 > 0) {
			Redo.get(0).click();
		}

	}

	/*-------HOME--  PATIENT SATISFCACTION---PATIENT ACCESS --BILLING FOLLOW UP-- HEALTH INFORMATION  ------*/

	public void clickR1HubModulesMenuLink(String menuName) {

		for (int i = 0; i < accountDetailMenuLinks.size(); i++) {

			if (accountDetailMenuLinks.get(i).getText().equalsIgnoreCase(menuName)) {

				withAction().moveToElement(accountDetailMenuLinks.get(i)).click().build().perform();

				break;
			}
		}
	}

	/*--------------------------PATIENT ACCESS >> PRE- REGISTRATION   ---------------------------------------*/

	public void clickSubSideR1HubModulesMenuLink(String menuName) {

		for (int i = 0; i < sideaccountDetailMenuLinks.size(); i++) {

			if (sideaccountDetailMenuLinks.get(i).getText().equalsIgnoreCase(menuName)) {

				withAction().moveToElement(sideaccountDetailMenuLinks.get(i)).click().build().perform();

				break;

			}
		}
	}

	/*------------------------------------------------ WORKLIST   --------------------------------------------*/

	public void clickOnUnassignedAccount() {
		for (WebElementFacade account : workListData) {
			clickOn(account);
			break;
		}
	}

	public void clickFirstAccount() {
		withAction().moveToElement(clickFirstAcct).click().build().perform();
	}

	public void showAllButton() {
		clickOn(showAll);
	}

	public void selectPatientType(String type) {
		select = new Select(patientTypeDropdown);
		select.selectByValue(type);
	}

	public void clickOnSearchButton() {
		clickOn(searchButton);
	}

	public void enterVisitNumber(String text) {
		typeInto(visitIDTextArea, text);
	}

	public void enterSSNNumber(String text) {
		typeInto(sSN, text);
	}

	public void enterMedicalNumber(String text) {
		typeInto(medicalRecord, text);
	}

	public void enterName(String text) {
		typeInto(fName, text);
		typeInto(lName, text);
	}

	/*-------------------------------- WORKLIST EXIST OR NOT-----------------------------------------*/

	public void verifyWorklistExists() {
		int initialCount = Worklist.size();
		Assert.assertTrue("Worklist doesnot exists", initialCount > 0);
	}

	public void verifyWorklistDoesNotExists() {
		int initialCount = Worklist.size();
		Assert.assertTrue("Worklist doesnot exists", initialCount == 0);
	}

	/*------------------------- WORK LIST FILTER FOLDER --------------------------------------*/

	public void ddlWorkListFilter(String filterVal, String operatorVal, String textVal, String textVal2) {
		selectFromDropdown(ddlFilter, filterVal);
		if (operatorVal.equals(">,<") || operatorVal.equals("BTWN")) {
			selectFromDropdown(ddlOperator, operatorVal);
			typeInto(textBox1, textVal);
			typeInto(textBox2, textVal2);
			clickOn(filterButton);
		}
	}

	public void ddlWorkListFilter(String filterVal, String operatorVal, String textVal) {

		selectFromDropdown(ddlFilter, filterVal);
		selectFromDropdown(ddlOperator, operatorVal);
		typeInto(textBox1, textVal);
		clickOn(filterButton);
	}

	public void ddlWorkListFilter(String filterVal, String operatorVal) {
		selectFromDropdown(ddlFilter, filterVal);
		selectFromDropdown(ddlOperator, operatorVal);
		clickOn(filterButton);
	}

	/*----------------------------COMPLETE RELEASE PHONE SCHEDULE ASSIGN EXCEPTIONS --------------------*/

	public void clickActionStatusTab(String menuName) {
		for (int i = 0; i < actionsStatusTab.size(); i++) {
			if (actionsStatusTab.get(i).getText().equalsIgnoreCase(menuName)) {
				withAction().moveToElement(actionsStatusTab.get(i)).click().build().perform();
				break;
			}
		}
	}

	public void verifyActionStatusAfterCheckout() {
		for (int i = 0; i < actionsStatusTab.size(); i++) {
			if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Phone")) {
				countAfterCheckOut++;
			} else if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Schedule")) {
				countAfterCheckOut++;
			} else if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Assign")) {
				countAfterCheckOut++;
			} else if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Complete")) {
				countAfterCheckOut++;
			} else if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Release")) {
				countAfterCheckOut++;
			} else if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Exceptions")) {
				countAfterCheckOut++;
			}
		}
		Assert.assertTrue("After Checkout Tabs Are Not Coming", countAfterCheckOut == 6);
	}

	public void verifyActionStatusTabBeforeCheckout() {
		for (int i = 0; i < actionsStatusTab.size(); i++) {
			if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Phone")) {
				countBeforeCheckOut++;
			} else if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Check Out")) {
				countBeforeCheckOut++;
			} else if (actionsStatusTab.get(i).getText().equalsIgnoreCase("Exceptions")) {
				countBeforeCheckOut++;
			}
		}
		Assert.assertTrue("After Checkout Tabs Are Not Coming", countBeforeCheckOut == 3);
	}

	/*----------------------------CHECK TAB COLOR RED..BLUE..YELLOW------------------------------------*/

	public String checkTabColor(String tab) {

		for (int i = 0; i < tabs.size(); i++) {
			if (tabs.get(i).getText().toString().equalsIgnoreCase(tab)) {
				if (tabs.get(i).getAttribute("class").equals("TabBGSelI")) {
					value = "Red";
				} else if (tabs.get(i).getAttribute("class").equals("TabBGC") ||tabs.get(i).getAttribute("class").equals("TabBGSelC")) {
					value = "Blue";
				} else if (tabs.get(i).getAttribute("class").equals("TabLU")||tabs.get(i).getAttribute("class").equals("TabBGU")) {
					value = "Yellow";
				}
			}
		}
		return value;
	}



	/*----------------------------CHECK TAB STATUS INCOMPLETE..COMPLETE..REDO..UNDETERMINED--------------*/

	public String chkTabStatusIncompleteComplete() {
		if (statusLabel.getText().contains("Incomplete")) {
			value = "Incomplete";
		} else if (statusLabel.getText().contains("Complete")) {
			value = "Complete";
		} else if (statusLabel.getText().contains("Redo")) {
			value = "Redo";
		} else if (statusLabel.getText().contains("Undetermined")) {
			value = "Undetermined";
		}
		return value;
	}

	/*---------------------------- SET FACILITY SETTING VALUE   ------------------------------------*/

	public void setFacilitySettingVal(String facilityCode, String settingName, String value) {
		select = new Select(select_search_field_dropDown);
		select.selectByValue("Code");
		search_value_textbox.sendKeys(facilityCode);
		search_value_button.click();
		withAction().moveToElement(view_icon).click().build().perform();
		select = new Select(select_setting_dropdown);
		select.selectByValue("SettingName");
		search_setting_textbox.sendKeys(settingName);
		withAction().moveToElement(search_setting_button).click().build().perform();
		withAction().moveToElement(edit_facility_setting).click().build().perform();
		text_setting_value.clear();		
		text_setting_value.sendKeys(value);
		update_facility_button.click();
	}

	/*
	 * ...................................USER MANAGEMENT
	 * .........................................
	 */

	public void setUserRoles(String searchBy, String searchText, String role, Boolean status)
			throws InterruptedException {
		withAction().moveToElement(userManagement).click().build().perform();
		select = new Select(userSearchType);
		select.selectByVisibleText(searchBy);
		typeInto(userSearchTextBox, searchText);
		clickOn(userSearchButton);
		clickOn(userEditButton);
		int count = userRoles.size();
		int i = 0;

		for (i = 0; i < count; i++) {
			if (status == true) {
				if (userRoles.get(i).getText().toString().equalsIgnoreCase(role)) {
					boolean att = userRolesCheckbox.get(i).isSelected();
					if (att) {
						break;
					} else {
						clickOn(userRolesCheckbox.get(i));
						clickOn(updateUser);
						break;
					}
				}
			} else {
				if (userRoles.get(i).getText().toString().equalsIgnoreCase(role)) {
					boolean att = userRolesCheckbox.get(i).isSelected();
					if (att) {
						clickOn(userRolesCheckbox.get(i));
						clickOn(updateUser);
						break;
					} else {
						break;
					}
				}
			}
		}
	}

	/*
	 * ...................................PATIENT TYPE STATUS OUTPATIENT EMERGENCY
	 * INPATIENT ............
	 */

	public String checkPatientTypeOSEI() {
		value = patientType.getText();
		return value;
	}

	/*
	 * ................................... TREE SUB FOLDER
	 * CLICK.........................................
	 */

	public void subFolderClick(String item, String subItem) throws InterruptedException {

		String itemxpath = "//*[contains(text(),'" + item + "')]//..//*[contains(@imgtype , 'exp')]";
		WebElementFacade mainItem = element(By.xpath(itemxpath));
		Thread.sleep(5000);
		withAction().moveToElement(mainItem).click().build().perform();
		Thread.sleep(5000);
		String subItemxpath = itemxpath + "//..//..//following-sibling::div//*[text()= '" + subItem + "']";
		WebElementFacade mainSubItem = element(By.xpath(subItemxpath));
		withAction().moveToElement(mainSubItem).click().build().perform();
		Thread.sleep(5000);
		WebElementFacade mainItem1 = element(By.xpath(itemxpath));
		withAction().moveToElement(mainItem1).click().build().perform();
		
	}

	/*
	 * ................................... CACHE
	 * .........................................
	 */

	public void clearCache() {
		withAction().moveToElement(cache_link).click().build().perform();
		cache_clear_all.click();
	}

	/*
	 * ................................... Get TABLE COLUMN VALUE
	 * .........................................
	 */

	public ArrayList getTableColValue(String rowLocator, String colLocator, String colName) {
		colValues = new ArrayList();
		int rowSize = findAll(By.xpath(rowLocator)).size();
		int colSize = findAll(By.xpath(colLocator)).size();
		for (int i = 1; i <= colSize; i++) {
			String colLocator1 = colLocator + "[" + i + "]";
			if (element(By.xpath(colLocator1)).getText().equalsIgnoreCase(colName)) {
				for (int j = 2; j <= rowSize; j++) {
					String rowLocator2 = rowLocator + "[" + j + "]/td[" + i + "]";
					colValues.add(element(By.xpath(rowLocator2)).getText());
				}
				break;
			}
		}
		return colValues;
	}

	/*
	 * ................................... SORTING COLUMN
	 * ...............................................
	 */

	public void verifySorting(String tableRowXpath, String tableHeaderColXpath, String colName) {
		columnValue = getTableColValue(tableRowXpath, tableHeaderColXpath, colName);
		boolean flag = true;

		for (int j = 0; j < columnValue.size() - 1; j++) {
			String d1 = (String) columnValue.get(j);
			String d2 = (String) columnValue.get(j + 1);
			int val = d1.compareTo(d2);
			if (val > 0) {
				flag = false;
				Assert.assertTrue("sorting failed", flag);
			}
		}
	}

	/*
	 * ................................... SELECT AND CLICK ON FACILITY
	 * ...............................
	 */

	public void clickFacilityList() throws InterruptedException {
		clickOn(facilityList);
	}

	public void selectFacility(String text) {
		selectFromDropdown(facility, text);
	}

	/*
	 * ................................... COVERAGE SEARCH, ADD AND DELETE
	 * ............................
	 */

	public void searchPayorPlan(String text) {
		withAction().moveToElement(plusSign).click().build().perform();
		typeInto(searchPayorplanTextBox, text);
		withAction().moveToElement(searchPayorplanSearchBtn).click().build().perform();
		withAction().moveToElement(coverageSearchResult).click().build().perform();
	}

	public void deletePayorPlan(String text) {
		withAction().moveToElement(deleteCoverage).click().build().perform();
	}

}
