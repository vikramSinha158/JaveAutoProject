package r1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class ClientMaintenance extends PageObject {

	R1ContactCommonMethods r1ComMethod;
	CommonMethod com;
	String selectClentMaintenance = "//span[text()='select']";
	String selectClentMaintenanceList = "//ul[@class='t-reset']/li";

	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElementFacade campaignsLinks;

	@FindBy(xpath = "//a[text()='Logic profile']")
	private WebElementFacade logicLinks;

	@FindBy(xpath = "//a[text()='Letters']")
	private WebElementFacade lettersLinks;

	@FindBy(xpath = "//a[text()='Third Party Connections']")
	private WebElementFacade ThirdPartyConLinks;

	@FindBy(xpath = "//a[text()='API Configuration']")
	private WebElementFacade ApiConfigLinks;

	@FindBy(xpath = "//div[contains(text(),'Client Maintenance')]")
	private WebElementFacade clientPageHeader;

	String clientMaintenanceHeader = "//div[contains(text(),' Client Maintenance ')]";

	public void selectClientMaintenanceList(String linkClick) throws InterruptedException {
		r1ComMethod.clickdropdown(selectClentMaintenance, selectClentMaintenanceList, linkClick);
	}

	public void verifyClientMaintenancePage() {
		CommonMethod.isDisplayedMethod(clientPageHeader);

	}

	public void clickOnCampaignLink() {
		clickOn(campaignsLinks);
	}

	public void waitForClientMaintenancePage() {
		com.waitForControl(clientMaintenanceHeader);
	}

	public void clickOnLogicLink() {
		clickOn(logicLinks);
	}

	public void clickOnThirdPartyConLink() {
		clickOn(ThirdPartyConLinks);
	}

	public void clickOnLettersLink() {
		clickOn(lettersLinks);

	}

	public void clickOnApiConfigLink() {
		clickOn(ApiConfigLinks);

	}

}
