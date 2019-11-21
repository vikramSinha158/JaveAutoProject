package r1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.utilities.CommonMethod;

public class BalanceLinkPage extends PageObject {

	CommonMethod comMethod;

	@FindBy(xpath = "//table[@cellspacing]")
	WebElementFacade headerBalabceTbl;

	/*--------Verify Balance link Page --------------- ----*/
	public void verifyBalanceLinkPage() {
		CommonMethod.isDisplayedMethod(headerBalabceTbl);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		comMethod.highLightSteps(headerBalabceTbl);
	}

}
