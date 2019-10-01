package r1.pages;

import java.util.List;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class AccountDetailsPage extends PageObject {
	
	CommonMethod comMethod;
	R1ContactCommonMethods contactCommon;
	private String accNumberxpath="//div[@class='account-number']";

	@FindBy(xpath = "//div[@class='pull-left right-item']/a")
	private List<WebElementFacade> patientAndGuarntName;
	
	
	@FindBy(xpath="//div[@class='pull-left patient stretch account-box']//div[@class='pull-left right-item']//a")
	WebElementFacade patientInfoLink;
	
	@FindBy(xpath="//a[contains(text(),'Link Balance ')]")
	WebElementFacade balanceClk;
	
	
	
	

	public void patientAndGuarntName() {
		for (int i = 0; i < patientAndGuarntName.size(); i++)
			Assert.assertTrue("Patient And GuarntName is not coming", patientAndGuarntName.get(i).isDisplayed());
	}
	
	public void clickOnPatientLink()
	{
		clickOn(patientInfoLink);
	}
	
	/*----Click on Balance Link --------------- ----*/
	public void balancelinkClk()
	{
		clickOn(balanceClk);
	}
	
	
	
	public void verifyAccInfoAccNum()
	{
		contactCommon.verifyAccountNumber(accNumberxpath, CommonMethod.readProperties("AccountNumber"));
	}
}
