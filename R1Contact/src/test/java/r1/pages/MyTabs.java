package r1.pages;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;

public class MyTabs extends BasePage{

	@FindBy(css="div.headline")
	private WebElementFacade myTabs;
	
	public void verifyMyTab() {
		Assert.assertTrue("My tab is not displayed!", myTabs.isDisplayed());
	}
	
}
