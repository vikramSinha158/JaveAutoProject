package r1.pages;

import r1.commons.BasePage;
import r1.commons.utilities.CommonMethod;
import net.serenitybdd.core.pages.WebElementFacade;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CodeAndDesPage extends BasePage {

	/*---------------------------------------------------Create CHRTY Request------------------------------------------------------------------------------*/
	@FindBy(xpath="//div[contains(text(),'CHRTY Request')]")
	private WebElementFacade chrtyRequestText;
	
	@FindBy(xpath="//input[@name='CheckedRecords']")
	private WebElementFacade accCheckbox;
	
	@FindBy(id="TextAnswers") private  WebElementFacade addTextarea;
	
	@FindBy(id="MoneyAnswers") private  WebElementFacade totalBal;
	
	@FindBy(id="Note") private WebElementFacade note;
	
	@FindBy(id="Save") private WebElementFacade save;
	
	@FindBy(id="Message") private WebElementFacade submitRequestMsg;
	
	public void chrtyRequestText() {
		Assert.assertTrue("chrtyRequest is not coming!!!", chrtyRequestText.isDisplayed());
	}
	
	public void enterAddress() {
		accCheckbox.click();
		addTextarea.clear();
		addTextarea.sendKeys(CommonMethod.readProperties("CHRTYRequestAddress"));
		totalBal.clear();
		totalBal.sendKeys(CommonMethod.readProperties("CHRTYRequestBal"));
		note.clear();
		note.sendKeys(CommonMethod.readProperties("CHRTYRequestNote"));
		
	}
	
	/*click Service payment request submit button*/
	public void clickRequest() {
		save.click();
	}
	
	/*verify submit request message*/
	public void verifyReqMessage() {
		String submitMsg=submitRequestMsg.getText();
		Assert.assertTrue("Request submitted message is not coming!", submitMsg.contains("Request submitted"));
	}
}
