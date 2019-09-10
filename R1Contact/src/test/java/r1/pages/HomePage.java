package r1.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.utilities.CommonMethods;

public class HomePage extends BasePage {
	
	/***************************** HomeAndReminder***************************/
	
	@FindBy(xpath ="//div[@id='Accounts']/table/tbody/tr")
	private List<WebElementFacade> accountRows;
	
	@FindBy(xpath ="//table[@ng-table='tableParams']//tbody//tr")
	private List<WebElementFacade> reminderList;
	
	@FindBy(xpath="//iframe[@src='/Home/SiteEntry']")
	private WebElementFacade headerframeName;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElementFacade homeTab;
	
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
	public void checkreminderList() {
		
	if(reminderList.size()<2)
	{
		System.out.println("No reminders present!");
	}

	}
	
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
		
		System.out.println(agentPrintName.getText());
	}
	
}