package r1.pages;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class PaymentPage extends BasePage {

	String wheatonNonZeroAccountNum;
	int index;
	String copytext;
	@FindBy(xpath="//a[text()='Initial']") 
	private WebElementFacade initiaPaymnet;

	@FindBy(xpath="//a[text()='Dovetail']") 
	private WebElementFacade dovetail;

	@FindBy(xpath="//a[text()='Summary']") 
	private WebElementFacade summaryPayment;

	@FindBy(xpath="//a[text()='Payment Information']") 
	private WebElementFacade paymentInformation;

	@FindBy(xpath="//a[text()='Process']")
	private WebElementFacade process;

	@FindBy(xpath="//td[@id='0-Balance']") 
	private WebElementFacade balance;

	@FindBy(xpath="//td[@id='0-Balance']//following-sibling::td/div[@class='checkbox-margin']/div/input[contains(@id,'DoInitial')]") 
	private WebElementFacade includeCheck;

	@FindBy(xpath="//div[@class='center-div accounts accts-dovetail']/div/table/tbody/tr[2]/td/div/input[contains(@id,'Dovetail')]") 
	private WebElementFacade dovetailCheck;

	@FindBy(id="InitialSummary") 
	private WebElementFacade summaryButton;

	@FindBy(id="DovetailSummary") 
	private WebElementFacade doveTailSummaryButton;

	@FindBy(xpath="//input[@value='Enter Payment']") 
	private WebElementFacade paymentbtn;

	@FindBy(xpath="//input[@value='SecureInput']") 
	private WebElementFacade secureInput;

	@FindBy(xpath="//input[@value='AgentInputVendor2']")
	private WebElementFacade agentInput;

	@FindBy(xpath="//div[@class='cc-entry address flt-lft']/div[contains(text(),'Current Guarantor')]") 
	private WebElementFacade GuarantorName;

	@FindBy(xpath="//div[@class='flt-lft row' and contains(text(),'Success')]") 
	private WebElementFacade successMessage;

	@FindBy(xpath="//input[@value='Submit' and @name='ButtonClicked']") 
	private WebElementFacade summarySubmit;

	@FindBy(xpath="//input[@value='Submit']")
	private WebElementFacade payInfoSubmit;

	@FindBy(xpath="//div[@class='flt-lft row' and contains(text(),'Success')]") 
	private WebElementFacade SuccessMessage;

	@FindBy(xpath="//div[text()='Submitted']")
	private WebElementFacade submitted;

	@FindBy(xpath="//div[@id='Vendor2PaymentContainer']")
	private WebElementFacade revspringFramexpath;

	@FindBy(xpath="//input[@placeholder='First & Last Name']")
	private WebElementFacade name;

	@FindBy(xpath="//input[@placeholder='XXXX XXXX XXXX XXXX']")
	private WebElementFacade cardNum;

	@FindBy(xpath="//input[@placeholder='XXXX']")
	private WebElementFacade cvv;

	@FindBy(xpath="//input[@placeholder='Address 1 ']")
	private WebElementFacade address;

	@FindBy(xpath="//input[@placeholder='City ']")
	private WebElementFacade city;

	@FindBy(xpath="//select[contains(@ng-options,'monthOptions')]")
	private WebElementFacade monthOptions;

	@FindBy(xpath="//select[contains(@ng-options,'stateOptions')]")
	private WebElementFacade stateOptions;

	@FindBy(xpath="//select[contains(@ng-options,'yearOptions')]")
	private WebElementFacade yearOptions;

	@FindBy(xpath="//input[contains(@placeholder,'Postal Code')]")
	private WebElementFacade postalCode;

	@FindBy(xpath="//button[text()='Submit New Profile']")
	private WebElementFacade submitProfile;

	@FindBy(xpath="//iframe[@id='EmergeIFrame']")
	private WebElementFacade emergeFrame;

	@FindBy(xpath="//div[@id='paymentProfileId']")
	private WebElementFacade profileID;

	@FindBy(xpath="//input[@id='EmergeProfileId']")
	private WebElementFacade profileIdInputBox;

	@FindBy(xpath="//button[@type='submit']")
	private WebElementFacade submit;
	String accountBalBeforeXpath="//div[@class='flt-lft accounts fake-grid accts-initial table table-bordered tableGridDiv']/table/tbody/tr[";
	String accountBalAfterXpath="]/td[contains(@id,'Balance')]";
	String paymentAccountRow="//div[@class='flt-lft accounts fake-grid accts-initial table table-bordered tableGridDiv']/table/tbody/tr";
	String paymentAccountCol= "//div[@class='flt-lft accounts fake-grid accts-initial table table-bordered tableGridDiv']/table/tbody/tr[1]/td";
	String profileId;
	String emergeFrame1="//iframe[@id='EmergeIFrame']";
	String emiList="//div[@class='t-popup t-group']/ul/li";
	String emiDropDownIcon="//span[@class='t-icon t-arrow-down' and text()='select']";
	String emiDropDownBefore="//div[@class='t-popup t-group']/ul/li[text()='";
	String emiDropDownAfter="']";
	String revspringFrame="//div[@id='Vendor2PaymentContainer']";
	R1ContactCommonMethods contactMethod;
	AccountPage account;
	CommonMethod com;
	HomePage home;

	/*verify intial page payment*/
	public void verifiyInitialPage() {
		com.verifyElement(initiaPaymnet);

	}

	/*verify Dovetail page payment*/
	public void verifiyDovetailPage() {
		com.verifyElement(dovetail);

	}

	/*verify summary page*/
	public void verifiySummaryPage() {
		com.verifyElement(summaryPayment);

	}

	/*verify payment Information page*/
	public void verifiyPaymentInformation() {
		com.verifyElement(paymentInformation);

	}
	/*verify GuarantorName Information page*/
	public void verifiyGuarantorInfo() {
		com.verifyElement(GuarantorName);

	}
	/*verify Process page*/
	public void verifyProcess() {
		com.verifyElement(process);
	}
	/*verify SuccessMessage*/
	public void verifiySuccessMessage() {
		com.verifyElement(SuccessMessage);

	}

	/*verify Submitted message successfully*/
	public void verifySubmittedMessage() {
		com.verifyElement(submitted);
	}
	public void clickPayment() {
		paymentbtn.click();
	}

	public void checkIncludeCheckBox() {
		com.verifyCheckBox(secureInput);
	}

	public void agentInputCheckBox() {
		agentInput.click();
		com.verifyCheckBox(agentInput);
	}
	public void clickSummarySubmit() {
		summarySubmit.click();
	}

	// Search account on initial page and enter amount and check it

	public int readRealtiveColumn(String homeReminderInfoRow, String homeReminderInfoCol, String columnHeader,
			String searchElement) {

		ArrayList<String> homeTablecolData = contactMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol, columnHeader);
		try {
			for (int i = 0; i < homeTablecolData.size(); i++) {
				if (homeTablecolData.get(i).contains(searchElement)) {
					index=i;
					break;
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return index;
	}

	/*	Intial page check and submit*/
	public void enterAndCheck(String accountNumber ) {
		int rowNum = readRealtiveColumn(paymentAccountRow, paymentAccountCol, "Account", accountNumber);
		String xpath=accountBalBeforeXpath+(rowNum+1)+accountBalAfterXpath;
		String bal =element(By.xpath(xpath)).getText();
		String[] split=bal.split("\\.");
		String splited=split[0];
		int balance=Integer.parseInt(splited);
		int amount=CommonMethod.random(balance);
		WebElementFacade amountfield=element(xpath+"//following-sibling::td/input");
		amountfield.clear();
		amountfield.sendKeys(Integer.toString(amount));
		WebElementFacade includeCheck = element(xpath+"//following-sibling::td/div[@class='checkbox-margin']/div/input[contains(@id,'DoInitial')]");
		includeCheck.click();
		summaryButton.click();

	}
	/*Dovetail page check and submit*/
	public void dovetailCheck() throws InterruptedException {
		if(dovetailCheck.isClickable()) {
			dovetailCheck.click();
		}
		else {
			Assert.assertTrue("Already Checked!", false);
		}
		selectEMI(); 
		doveTailSummaryButton.click();

	}

	// select random  installament
	public String randEMI() {
		element(By.xpath(emiDropDownIcon)).click();
		int size= findAll(By.xpath(emiList)).size();
		element(By.xpath(emiDropDownIcon)).click();
		int random = (int) (Math.random() * size - 1) + 1;
		String clickOption=element(By.xpath(emiDropDownBefore+random+emiDropDownAfter)).getText();
		return clickOption;

	}

	// Select Installment dropdown
	public void selectEMI() throws InterruptedException {
		String clickOption = randEMI();
		contactMethod.clickdropdown(emiDropDownIcon, emiList, clickOption);
	}

	// Click paymentInfo Submit button
	public void submitPaymentInfo() {
		payInfoSubmit.click();
	}

	/*verify revspring frame*/
	public void verifyRevspringFrame() {
		getDriver().switchTo().frame(emergeFrame);
		contactMethod.waitForControl("//input[@placeholder='First & Last Name']");
		com.verifyElement(name);
	}

	// enter card details and submit
	public void enterCardDetails() {
		name.clear();
		name.sendKeys(CommonMethod.readProperties("Name"));
		cardNum.clear();
		cardNum.sendKeys(CommonMethod.readProperties("CardNumber"));
		CommonMethod.selectRandomList(monthOptions);
		Select selectDropdown = new Select(yearOptions);
		//List<WebElement> listOptionDropdown = selectDropdown.getOptions();
		selectDropdown.selectByValue(CommonMethod.readProperties("expiryYear"));
		cvv.clear();
		cvv.sendKeys(CommonMethod.readProperties("CVV"));
		address.clear();
		address.sendKeys(CommonMethod.readProperties("Address"));
		city.clear();
		city.sendKeys(CommonMethod.readProperties("City"));
		CommonMethod.selectRandomList(stateOptions);
		postalCode.clear();
		postalCode.sendKeys(CommonMethod.readProperties("PostalCode"));

	}
	//Submit payment profile
	public void submitProfile() {
		submitProfile.click();
	}

	public void verifyProfileID() {

		com.verifyElement(profileID);
	}
	// Copying profile id 
	public void copyProfileID() {
		copytext=profileID.getText();

	}

	// Send copied profie ID
	public void sendProfileID() throws InterruptedException {
		getDriver().switchTo().defaultContent();
		home.switchHeaderFrame();
		profileIdInputBox.sendKeys(copytext);
	}

	// Submit payment information
	public void submitPayment() {
		submit.click();
	}
	
	// Check payment arrangement submitted
	public void paymentArrangeSubmitted() {
		
	}
}
