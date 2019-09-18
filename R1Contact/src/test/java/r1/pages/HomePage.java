package r1.pages;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethods;

public class HomePage extends BasePage {

	static int counter ;
	R1ContactCommonMethods r1ComMethod;
	private int homeRiminderRowCount;
	private String columnHeader="Date";
	private String searchElement="16";
	private int searchEleRow;

	/***************************** HomeAndReminder***************************/

	@FindBy(xpath ="//div[@id='Accounts']/table/tbody/tr")
	private List<WebElementFacade> accountRows;

	@FindBy(xpath ="//table[@ng-table='tableParams']//tbody//tr")
	private List<WebElementFacade> reminderList;

	@FindBy(xpath ="//i[contains(@id,'DeleteReminder')]")
	private List<WebElementFacade> delete;


	@FindBy(xpath ="//table[@ng-table='tableParams']//tbody//tr[1]/td")
	private List<WebElementFacade> reminderListColumn;

	String reminderRow="//table[@ng-table='tableParams']//tbody//tr";

	@FindBy(xpath="//iframe[@src='/Home/SiteEntry']")
	private WebElementFacade headerframeName;

	@FindBy(xpath="//a[text()='Home']")
	private WebElementFacade homeTab;

	@FindBy(xpath="//table[@ng-table='tableParams']//tbody//tr[1]/td[1]/a")
	private WebElementFacade topReminder;

	@FindBy(xpath="//div[@class= 'row account-boxes']//div[contains(text() , 'Balance')]//following-sibling::div")
	private WebElementFacade amountAtHompage;

	@FindBy(xpath="//span[contains(text(),'Date')]")
	private WebElementFacade date;

	@FindBy(xpath="//span[contains(text(),'Time')]")
	private WebElementFacade time;

	@FindBy(xpath="//span[contains(text(),'Facility')]")
	private WebElementFacade Facility;

	@FindBy(xpath="//span[contains(text(),'Account Number')]")
	private WebElementFacade accountnum;

	@FindBy(xpath="//span[contains(text(),'Notes')]")
	private WebElementFacade notes;

	@FindBy(xpath="//span[contains(text(),'Balance')]")
	private WebElementFacade Balance;

	@FindBy(xpath="//span[text()='Help']")
	private WebElementFacade help;

	@FindBy(xpath="//a[text()='My Tabs']")
	private WebElementFacade myTabs;

	@FindBy(xpath = "//span[text()='Search']")
	private WebElementFacade hoverOnSerch;

	@FindBy(xpath = "//span[text()='Initiatives']")
	private WebElementFacade Initiatives;

	@FindBy(xpath="//a[text()='Accounts']")
	private WebElementFacade AccountElemnet;

	@FindBy(xpath="//p[@class='pull-right']/strong")
	private WebElementFacade agentPrintName;


	@FindBy(xpath="//p[@class='pull-right']/strong")
	private WebElementFacade agentNameOnHomePage;


	@FindBy(xpath="//table[@ng-table='tableParams']/tbody/tr")
	private WebElementFacade reminderTableRowsCnt;

	@FindBy(xpath="//input[@name='remAccountNum']")
	private WebElementFacade txtSearchAccountNum;

	@FindBy(xpath="//input[@name='remDate']")
	private WebElementFacade txtSearchDate;

	@FindBy(xpath="//input[@name='remFacility']")
	private WebElementFacade txtSearchFacility;

	@FindBy(xpath="//input[@name='remNotes']")
	private WebElementFacade txtSearchNote;

	@FindBy(xpath="//input[@name='remBalance']")
	private WebElementFacade txtSearchBalance;


	@FindBy(xpath="//input[@class='form-control valid']")
	private WebElementFacade txtToShowDate;

	@FindBy(xpath="//button//div[@class='revert']")
	private WebElementFacade buttonToShowDate;

	@FindBy(xpath="//table[@ng-table='tableParams']//tbody//tr")
	private List<WebElementFacade> homeReminderTableRow;

	final int remindarSize=2;
	
	@FindBy(xpath="//th[@data-title-text='Date']")
	private WebElementFacade dateReminderSearch;
	
	@FindBy(xpath="//th[@data-title-text='Time']")
	private WebElementFacade timeReminderSearch;
	
	@FindBy(xpath="//th[@data-title-text='Facility']")
	private WebElementFacade facilityReminderSearch;
	
	@FindBy(xpath="//th[@data-title-text='Account Number']")
	private WebElementFacade accountNumReminderSearch;
	
	@FindBy(xpath="//th[@data-title-text='Notes']")
	private WebElementFacade notesReminderSearch;
	
	@FindBy(xpath="//th[@data-title-text='Balance']")
	private WebElementFacade balanceReminderSearch;
	
	
	
	String homeReminderInfoRow = "//table[@ng-table='tableParams']//tbody//tr";
	String homeReminderInfoCol="//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th";

	/************************************************ Reminder Filter***********************************/


	int totalcount;
	public void checkContainHometable()
	{

		ArrayList<String> homeTablecolData =r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Account Number");

		System.out.println(homeTablecolData);
		totalcount= homeReminderTableRow.size();

		if (columnHeader.equalsIgnoreCase("Account Number")) {


			txtSearchAccountNum.sendKeys(searchElement);
			homeRiminderRowCount=homeReminderTableRow.size()-1;
			searchEleRow=r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader, searchElement);

		} else if (columnHeader.equalsIgnoreCase("Date")) {


			txtSearchDate.sendKeys(searchElement);
			homeRiminderRowCount=homeReminderTableRow.size()-1;
			searchEleRow=r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader, searchElement);

		} else if (columnHeader.equalsIgnoreCase("Facility")) {

			txtSearchFacility.sendKeys(searchElement);
			homeRiminderRowCount=homeReminderTableRow.size()-1;
			searchEleRow=r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader, searchElement);


		} else if (columnHeader.equalsIgnoreCase("Notes")) {

			txtSearchNote.sendKeys(searchElement);
			homeRiminderRowCount=homeReminderTableRow.size()-1;
			searchEleRow=r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader, searchElement);

		}else if (columnHeader.equalsIgnoreCase("Balance")) {

			txtSearchBalance.sendKeys(searchElement);
			homeRiminderRowCount=homeReminderTableRow.size()-1;
			searchEleRow=r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, columnHeader, searchElement);

		}


		System.out.println("Total count " + totalcount + "  total row in table after enter text " + homeRiminderRowCount + "  After serach "  +searchEleRow);

		Assert.assertEquals("Row for search element not match", homeRiminderRowCount, searchEleRow);
	}

	@SuppressWarnings("deprecation")
	public void verifyAgentName() throws InterruptedException
	{
		String agentNameFromTable=agentPrintName.getText();
		System.out.println(agentNameFromTable);
		String agentNameFromHome=agentNameOnHomePage.getText();
		String[]agentArr=agentNameFromHome.split("\\(");
		String actualAgentName=agentArr[0];
		Assert.assertTrue("Agent name is not matching", agentNameFromTable.contains(actualAgentName));

	}


	@SuppressWarnings("deprecation")


	public void switchHeaderFrame()
	{
		getDriver().switchTo().frame(headerframeName);

	}

	public void defaultFrame()
	{
		getDriver().switchTo().defaultContent();
	}

	public void clicOnHome()
	{
		clickOn(homeTab);
	}

	public void spanContains()
	{

	}

	public void verifyHeaderTab()
	{
		CommonMethods.isDisplayedMethod(homeTab);
		CommonMethods.isDisplayedMethod(myTabs);
		CommonMethods.isDisplayedMethod(Initiatives);
		CommonMethods.isDisplayedMethod(help);

	}


	public void clickOnMyTab()
	{
		clickOn(myTabs);
	}



	public void clickForSerachAccount()
	{

		withAction().moveToElement(hoverOnSerch).click().build().perform();
		clickOn(AccountElemnet);
	}

	public void reminderHeader()
	{
		CommonMethods.isDisplayedMethod(date);
		CommonMethods.isDisplayedMethod(time);
		CommonMethods.isDisplayedMethod(Facility);
		CommonMethods.isDisplayedMethod(accountnum);
		CommonMethods.isDisplayedMethod(notes);
		CommonMethods.isDisplayedMethod(Balance);

	}

	@SuppressWarnings("deprecation")
	public void checkreminderList() {


		if(reminderList.size()<2)
		{
			System.out.println("No reminders present!");
		}

	}


	// Check remindar on homepage

	@SuppressWarnings("deprecation")
	public boolean checkRemindar()
	{
		Boolean flag=true;
		for(int i=1;i<=reminderList.size()-1;i++)
		{
			String rowlocator2=reminderRow+ "[" + i + "]";

			for(int j=1;j<reminderListColumn.size();j++)
			{
				String colLocator1=rowlocator2+"/td["+j+"]/a";
				String accountNumber=element(By.xpath(colLocator1)).getText();
				String date=element(rowlocator2+"/td[1]/a").getText();
				if(accountNumber.equalsIgnoreCase(ReminderPage.accountnumber)&&date.equalsIgnoreCase(ReminderPage.tommorrowdate()))
				{

					String time= element(rowlocator2+"/td[1]/a").getText();
					String[] spiltedTime=time.split(":");
					String mintus=spiltedTime[1];
					Assert.assertTrue("Default value is not. 00.00 EST", mintus.contains("00"));

					flag=false;
					counter++;

					break;

				}

			}
			if(flag==false)
			{
				break;
			}
		}

		return flag;

	}

	public void verifyBalance()
	{

		ArrayList<String> ListOFAccounts = r1ComMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, "Balance");
		if(ListOFAccounts.size()>1)
		{
			String TopBalance=ListOFAccounts.get(0).substring(1);
			topReminder.click();
			String amount=amountAtHompage.getText();
			Assert.assertEquals(TopBalance, amount);


		}

	}
	
	/**************************************************************ReminderSearchField*********************************************/
	
	public void verifyReminderSearch()
	{
	CommonMethods.isDisplayedMethod(dateReminderSearch);
	CommonMethods.isDisplayedMethod(timeReminderSearch);
	CommonMethods.isDisplayedMethod(facilityReminderSearch);
	CommonMethods.isDisplayedMethod(accountNumReminderSearch);
	CommonMethods.isDisplayedMethod(notesReminderSearch);
	CommonMethods.isDisplayedMethod(balanceReminderSearch);
	}
}




