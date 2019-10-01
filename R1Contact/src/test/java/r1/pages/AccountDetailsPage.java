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
	

	
	@FindBy(xpath="//span[@class='accordion-title']")
	List<WebElementFacade> patientDetailTabs;
	
	
	
	@FindBy(xpath="//div[contains(text(),'Diagnosis')]")
	WebElementFacade diagnosisLabelEncInfo;
	
	@FindBy(xpath="//div[contains(text(),'Click to View')]")
	WebElementFacade clkViewlEncInfo;
	

	@FindBy(xpath="//div[@id='TooltipPopupContainer']")
	WebElementFacade popUplEncInfo;
	
	
	
	@FindBy(xpath="//img[@alt='Patient agreed'][@src='/Content/images/checkmark.png']")
	WebElementFacade patientAgreepopUplEncInfo;

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
	
	/*-------HOME--  Click on patient detail tabs  ------*/

	public void clickPatientDtlTabs(String menuName) {
		
		boolean tabcheck=false;

		for (int i = 0; i < patientDetailTabs.size(); i++) {
		
					
			if (patientDetailTabs.get(i).getText().toUpperCase().contains(menuName.trim().toUpperCase())) {
				
				comMethod.scrollInView(patientDetailTabs.get(i));
			    clickOn(patientDetailTabs.get(i));
			    tabcheck=true;
				break;
			}
		}
		
			Assert.assertTrue(menuName + " Element Not found ", tabcheck);

		
	}
	
	/*-------verify Encounter Information expand ------*/
	
	public void verifyEncounterTabExpand()
	{
		CommonMethod.isDisplayedMethod(diagnosisLabelEncInfo);
		comMethod.highLightSteps(diagnosisLabelEncInfo);
	}
	
	/*-------click in view Encounter Information ------*/
	public void clkInView()
	{
		clickOn(clkViewlEncInfo);
	}
	
	/*-------verify PopUp Encounter Information ------*/
	public void verifyPopUpInEncInfo()
	{
	
		if(popUplEncInfo.isDisplayed())
		{
			CommonMethod.isDisplayedMethod(patientAgreepopUplEncInfo);
			comMethod.highLightSteps(patientAgreepopUplEncInfo);
		}
		else
		{
			Assert.assertTrue("Agreed pop is not dispalyed", popUplEncInfo.isDisplayed());
		}
	
	}
	
}
