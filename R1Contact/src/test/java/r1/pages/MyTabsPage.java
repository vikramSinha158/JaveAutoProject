package r1.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.utilities.CommonMethod;

public class MyTabsPage extends BasePage {
	
	CommonMethod comMethod;

	@FindBy(css = "div.headline")
	private WebElementFacade myTabs;
	

	public void verifyMyTab() {
		Assert.assertTrue("My tab is not displayed!", myTabs.isDisplayed());
	}
	
	
	@FindBy(xpath = "//div[@class='buttons-item']//button[@type='submit']")
	private List<WebElementFacade> tablist;
	
	
	
	@FindBy(xpath = "//table[@id='queueTable']//thead//tr[@class='ng-table-sort-header']//th")
	private List<WebElementFacade> myQuerytblheaderlist;
	
	
	@FindBy(xpath = "//table[@id='paymentTable']//thead//tr[@class='ng-table-sort-header']//th")
	private List<WebElementFacade> myPaymenttblheaderlist;
	
	
	
	@FindBy(xpath = "//table[@cellspacing='0']//thead//tr//th//a")
	private List<WebElementFacade> myRemindertblheaderlist;
	
	
	@FindBy(xpath = "//table[@cellspacing='0']//thead//tr//th//a")
	private List<WebElementFacade> myRequesttblheaderlist;
	
	@FindBy(xpath = "//table[@cellspacing='0']//thead//tr//th//a")
	private List<WebElementFacade> myAccounttblheaderlist;
	
	
	public void clickOntabs(String tabName)
	{
		comMethod.clickListTabs(tablist, tabName);
		
	}
	
	public void veryfyMyQueryTableHeader()
	{
		comMethod.isDisplayListItem(myQuerytblheaderlist);
	}
	
	public void veryfyMyPaymentTableHeader()
	{
		comMethod.isDisplayListItem(myPaymenttblheaderlist);
	}
	
	public void veryfyMyReminderTableHeader()
	{
		comMethod.isDisplayListItem(myRemindertblheaderlist);
	}
	
	public void veryfyMyRequestTableHeader()
	{
		comMethod.isDisplayListItem(myRequesttblheaderlist);
	}
	
	public void veryfyMyAccountTableHeader()
	{
		comMethod.isDisplayListItem(myAccounttblheaderlist);
	}
	
	
	
	

}
