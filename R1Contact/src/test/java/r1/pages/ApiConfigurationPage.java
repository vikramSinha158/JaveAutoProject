package r1.pages;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.utilities.CommonMethod;

public class ApiConfigurationPage extends PageObject {

	CommonMethod com;

	@FindBy(xpath = "//div[contains(text(),'API Configuration')]")
	private WebElementFacade ApiConfigPageHeader;

	@FindBy(xpath = "//a[text()='Add new record']")
	private WebElementFacade ApiConfigThirdPatyConBtn;

	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElementFacade addRecordPopCancelBtnApiConfig;

	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']")
	private WebElementFacade addRecordApiConfigPopUp;

	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[11]/a[contains(text(),'Edit')]")
	private WebElementFacade firstRowEditBtnApiConfig;

	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> ApiConfigTblrow;

	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']")
	private WebElementFacade dialogApiConfigEdit;

	@FindBy(xpath = "//div[@id='ApiVendorSettingPopUp']//a[text()='Cancel']")
	private WebElementFacade EditPopCancelBtnApiConfig;

	public void verifyApiConfigPage() {

		CommonMethod.isDisplayedMethod(ApiConfigPageHeader);
		com.highLightSteps(ApiConfigPageHeader);
	}

	public void verifyAddRecordApiConfigPopUp() {
		clickOnApiConfignAddRecord();
		CommonMethod.isDisplayedMethod(addRecordApiConfigPopUp);
		clickOn(addRecordPopCancelBtnApiConfig);
	}

	public void clickOnApiConfignAddRecord() {
		clickOn(ApiConfigThirdPatyConBtn);
	}

	public void clickOnApiConfigEdit() {
		if (ApiConfigTblrow.size() > 0) {
			clickOn(firstRowEditBtnApiConfig);

		} else {
			Assert.assertTrue("No row found in Api Configuration Table to click on edit", ApiConfigTblrow.size() > 0);
		}
	}

	public void verifyApiConfigTblEdit() {
		clickOnApiConfigEdit();
		CommonMethod.isDisplayedMethod(dialogApiConfigEdit);
		clickOn(EditPopCancelBtnApiConfig);

	}

}
