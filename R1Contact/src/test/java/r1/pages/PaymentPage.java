package r1.pages;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.utilities.CommonMethod;

public class PaymentPage extends BasePage {
	
	String wheatonNonZeroAccountNum;

	@FindBy(xpath="//a[text()='Initial']") 
	private WebElementFacade initiaPaymnet;
	
	@FindBy(xpath="//a[text()='Summary']") 
	private WebElementFacade SummaryPaymnet;
	
	@FindBy(xpath="//a[text()='Payment Information']") 
	private WebElementFacade PaymentInformation;
	
	@FindBy(xpath="//td[@id='0-Balance']") 
	private WebElementFacade balance;
	
	@FindBy(xpath="//td[@id='0-Balance']//following-sibling::td/input") 
	private WebElementFacade amountfield;
	
	@FindBy(xpath="//td[@id='0-Balance']//following-sibling::td/div[@class='checkbox-margin']/div/input[contains(@id,'DoInitial')]") 
	private WebElementFacade includeCheck;
	
	@FindBy(id="InitialSummary") 
	private WebElementFacade summaryButton;
	
	@FindBy(xpath="//input[@value='Enter Payment']") 
	private WebElementFacade paymentbtn;
	
	@FindBy(xpath="//input[@value='SecureInput']") 
	private WebElementFacade secureInput;
	
	@FindBy(xpath="//div[@class='cc-entry address flt-lft']/div[contains(text(),'Current Guarantor')]") 
	private WebElementFacade GuarantorName;
	
	@FindBy(xpath="//div[@class='flt-lft row' and contains(text(),'Success')]") 
	private WebElementFacade successMessage;
	
	@FindBy(xpath="//input[@value='Submit' and @name='ButtonClicked']") 
	private WebElementFacade summarySubmit;
	
	@FindBy(xpath="//div[@class='flt-lft row' and contains(text(),'Success')]") 
	private WebElementFacade SuccessMessage;
	
	R1ContactCommonMethods contactMethod;
	AccountPage account;
	CommonMethod com;
	
	
	/*verify intial page payment*/
	
	public void verifiyInitialPage() {
		com.verifyElement(initiaPaymnet);
		
	}
	
	/*verify summary page*/
	public void verifiySummaryPage() {
		com.verifyElement(SummaryPaymnet);
		
	}
	
	/*verify payment Information page*/
	public void verifiyPaymentInformation() {
		com.verifyElement(PaymentInformation);
		
	}
	/*verify GuarantorName Information page*/
	public void verifiyGuarantorInfo() {
		com.verifyElement(GuarantorName);
		
	}
	/*verify SuccessMessage*/
	public void verifiySuccessMessage() {
		com.verifyElement(SuccessMessage);
		
	}
	
	public void clickPayment() {
		paymentbtn.click();
	}
	
	public void checkIncludeCheckBox() {
		com.verifyCheckBox(secureInput);
	}
	
	public void clickSummarySubmit() {
		summarySubmit.click();
	}
	

	public void enterAndCheck() {
		String bal=balance.getText();
		String[] split=bal.split("\\.");
		String splited=split[0];
		int balance=Integer.parseInt(splited);
		int amount=CommonMethod.random(balance);
		amountfield.clear();
		amountfield.sendKeys(Integer.toString(amount));
		includeCheck.click();
		summaryButton.click();
	
	
	}
}
