package r1.pages;

import java.util.List;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountDetailsPage {

	@FindBy(xpath = "//div[@class='pull-left right-item']/a")
	private List<WebElementFacade> patientAndGuarntName;

	public void patientAndGuarntName() {
		for (int i = 0; i < patientAndGuarntName.size(); i++)
			Assert.assertTrue("Patient And GuarntName is not coming", patientAndGuarntName.get(i).isDisplayed());
	}
}
