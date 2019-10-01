package r1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.utilities.CommonMethod;

public class PatientInfoPage extends PageObject {
	
	CommonMethod comMethod;
		
	@FindBy(xpath="//li[@id='PATIENT']")
	WebElementFacade patientInfoPage;
		
	@FindBy(xpath="//img[@class='icon'][@src='../../Content/images/success.png']")
	WebElementFacade patientInfoUpdatedSucess;
	
	
	@FindBy(xpath="//input[@id='PatientAddress2']")
	WebElementFacade txtPatientAddress2;
	
	
	@FindBy(xpath="//div[@id='tabs-PATIENT']//input[@value='Save']")
	WebElementFacade btnPatientPageSave;
	
	
	public void verifyPatientInfoPage()
	{
		comMethod.isDisplayedMethod(patientInfoPage);
		comMethod.highLightSteps(patientInfoPage);
		
	}
	
	public void enterPatientAddress2()
	{
		txtPatientAddress2.clear();
		
		txtPatientAddress2.sendKeys(CommonMethod.readProperties("txtPatientAddress2"));
	}
	
	public void  verifySuceesUpdate()
	{
		
		comMethod.isDisplayedMethod(patientInfoUpdatedSucess);
		comMethod.highLightSteps(patientInfoUpdatedSucess);
	}
	
	public void SavePatientPage()
	{
		clickOn(btnPatientPageSave);
	}
	
	
	

}
