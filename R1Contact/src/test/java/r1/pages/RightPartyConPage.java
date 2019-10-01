package r1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.utilities.CommonMethod;

public class RightPartyConPage extends PageObject {
	
	CommonMethod comMethod;
	
	@FindBy(xpath="//span[contains(text(),'Right party contact (RPC)')]")
	WebElementFacade rpc;
	
	@FindBy(xpath="//button[@type='button'][text()='Yes']")
	WebElementFacade rpcYes;
	
	@FindBy(xpath="//button[@type='submit'][text()='Yes']")
	WebElementFacade addressYes;
	
	/*----Check for Right party contact ----*/
	public void rpcPageDisplayed()
	{
		CommonMethod.isDisplayedMethod(rpc);
		comMethod.highLightSteps(rpc);

	}
	
	/*----Click on both Yes page --------------- ----*/
	public void clickOnRpcBothYesBtn()
	{
		if(rpcYes.isDisplayed())
		{
			clickOn(rpcYes);
			if(addressYes.isClickable())
			{
				clickOn(addressYes);
			}
			
		}
		
	}

}
