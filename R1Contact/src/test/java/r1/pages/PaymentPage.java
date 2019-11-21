package r1.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class PaymentPage extends BasePage {

	R1ContactCommonMethods contactMethod;
	AccountPage account;
	CommonMethod com;
	HomePage home;
	String wheatonNonZeroAccountNum;
	int index;
	String copytext;
	int randomEMI;// create random variable as global
	@FindBy(xpath = "//a[text()='Initial']")
	private WebElementFacade initiaPaymnet;

	@FindBy(xpath = "//a[text()='Dovetail']")
	private WebElementFacade dovetail;

	@FindBy(xpath = "//a[text()='Summary']")
	private WebElementFacade summaryPayment;

	@FindBy(xpath = "//a[text()='Payment Information']")
	private WebElementFacade paymentInformation;

	@FindBy(xpath = "//a[text()='Process']")
	private WebElementFacade process;

	@FindBy(xpath = "//td[@id='0-Balance']")
	private WebElementFacade balance;

	@FindBy(xpath = "//td[@id='0-Balance']//following-sibling::td/div[@class='checkbox-margin']/div/input[contains(@id,'DoInitial')]")
	private WebElementFacade includeCheck;

	@FindBy(xpath = "//div[@class='center-div accounts accts-dovetail']/div/table/tbody/tr[2]/td/div/input[contains(@id,'Dovetail')]")
	private WebElementFacade dovetailCheck;

	@FindBy(id = "InitialSummary")
	private WebElementFacade summaryButton;

	@FindBy(id = "DovetailSummary")
	private WebElementFacade doveTailSummaryButton;

	@FindBy(xpath = "//input[@value='Enter Payment']")
	private WebElementFacade paymentbtn;

	@FindBy(xpath = "//input[@value='SecureInput']")
	private WebElementFacade secureInput;

	@FindBy(xpath = "//input[@value='AgentInputVendor2']")
	private WebElementFacade agentInput;

	@FindBy(xpath = "//div[@class='cc-entry address flt-lft']/div[contains(text(),'Current Guarantor')]")
	private WebElementFacade GuarantorName;

	@FindBy(xpath = "//div[@class='flt-lft row' and contains(text(),'Success')]")
	private WebElementFacade successMessage;

	@FindBy(xpath = "//input[@value='Submit' and @name='ButtonClicked']")
	private WebElementFacade summarySubmit;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElementFacade payInfoSubmit;

	@FindBy(xpath = "//div[@class='flt-lft row' and contains(text(),'Success')]")
	private WebElementFacade SuccessMessage;

	@FindBy(xpath = "//div[text()='Submitted']")
	private WebElementFacade submitted;

	@FindBy(xpath = "//div[@id='Vendor2PaymentContainer']")
	private WebElementFacade revspringFramexpath;

	@FindBy(xpath = "//input[@placeholder='First & Last Name']")
	private WebElementFacade name;

	@FindBy(xpath = "//input[@placeholder='XXXX XXXX XXXX XXXX']")
	private WebElementFacade cardNum;

	@FindBy(xpath = "//input[@placeholder='XXXX']")
	private WebElementFacade cvv;

	@FindBy(xpath = "//input[@placeholder='xxx@xxx.xxx']")
	private WebElementFacade email;

	@FindBy(xpath = "//input[@placeholder='Address 1 ']")
	private WebElementFacade address;

	@FindBy(xpath = "//input[@placeholder='City ']")
	private WebElementFacade city;

	@FindBy(xpath = "//select[contains(@ng-options,'monthOptions')]")
	private WebElementFacade monthOptions;

	@FindBy(xpath = "//select[contains(@ng-options,'stateOptions')]")
	private WebElementFacade stateOptions;

	@FindBy(xpath = "//select[contains(@ng-options,'yearOptions')]")
	private WebElementFacade yearOptions;

	@FindBy(xpath = "//input[contains(@placeholder,'Postal Code')]")
	private WebElementFacade postalCode;

	@FindBy(xpath = "//button[@ng-bind-html='submitButtonText']")
	private WebElementFacade submitProfile;

	@FindBy(xpath = "//iframe[@id='EmergeIFrame']")
	private WebElementFacade emergeFrame;

	@FindBy(xpath = "//div[@id='paymentProfileId']")
	private WebElementFacade profileID;

	@FindBy(xpath = "//input[@id='EmergeProfileId']")
	private WebElementFacade profileIdInputBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElementFacade submit;

	@FindBy(xpath = "//select[@id='PaymentInstallment']")
	private WebElementFacade emiDrpdown;

	@FindBy(xpath = "//select[@id='Summaries_0__Reason']")
	private WebElementFacade reasonDrpdwn;

	@FindBy(xpath = "//div[@id='backButtonMessage']")
	private WebElementFacade paySubmission;

	@FindBy(xpath = "//div[@class='checkmark-icon']")
	private WebElementFacade chechmarkIcon;

	@FindBy(xpath = "//input[@id='TotalInstallmentsBalance']")
	private WebElementFacade totalInstallments;

	@FindBy(xpath = "//input[@id='TotalPerInstallment']")
	private WebElementFacade totalPerInstallment;

	@FindBy(xpath = "//input[@id='InstallmentsStartDate']")
	private WebElementFacade installmentsStartDate;

	@FindBy(xpath = "//div[@class='flt-lft result-cell']")
	private List<WebElementFacade> submittedMsgList;

	@FindBy(xpath = "//div[@id='backButtonMessage']")
	private WebElementFacade payProgessMsg;

	@FindBy(xpath = "//Select[@ng-model='formObject.accountType']")
	private WebElementFacade accountdrpdown;

	@FindBy(xpath = "//input[@rs-checksum='achRoutingNumber']")
	private WebElementFacade routingNumber;

	@FindBy(xpath = "//input[@rs-checksum='achAccountNumber']")
	private WebElementFacade accountNumber;

	@FindBy(xpath = "//a[contains(text(),'Checking / Savings')]")
	private WebElementFacade checking_SavingsBtn;

	/* New vik **************************/
	@FindBy(xpath = "//input[@value='AgentInput']")
	private WebElementFacade agentInputRadiobtn;

	@FindBy(xpath = "//iframe[@id='PaymentIFrame']")
	private WebElementFacade revSpringFrame;

	@FindBy(xpath = "//legend[text()='Billing Information']")
	private WebElementFacade revSpringFrameHeader;

	@FindBy(xpath = "//Input[@id='profile_first_name']")
	private WebElementFacade revSpringFirstName;

	@FindBy(xpath = "//Input[@id='profile_last_name']")
	private WebElementFacade revSpringLastName;

	@FindBy(xpath = "//Input[@id='profile_address_1']")
	private WebElementFacade revSpringAddres1;

	@FindBy(xpath = "//Input[@id='profile_city']")
	private WebElementFacade revSpringCity;

	@FindBy(xpath = "//Input[@id='profile_state']")
	private WebElementFacade revSpringState;

	@FindBy(xpath = "//Input[@id='profile_postal_code']")
	private WebElementFacade revSpringCode;

	@FindBy(xpath = "//Input[@id='profile_cc_account_number']")
	private WebElementFacade revSpringCardNum;

	@FindBy(xpath = "//input[@id='submit_button']")
	private WebElementFacade revSpringSubmitBtn;

	@FindBy(xpath = "//div[contains(text(),'profile has been saved')]")
	private WebElementFacade revSpringSuccessMsg;

	@FindBy(xpath = "//label[text()='Profile ID']//following-sibling::label")
	private WebElementFacade revSpringProfileId;

	@FindBy(xpath = "//input[@id='ProfileId']")
	private WebElementFacade revSpringProfileIdTextBox;

	@FindBy(xpath = "//div[@class='save-item']//input[@type='submit']")
	private WebElementFacade revSpringfinalSubmitBtn;

	@FindBy(xpath = "//div[text()='Submitted']")
	private WebElementFacade revSpringfinalSubmitMsg;

	@FindBy(xpath = "//div[@class='checkmark-icon']")
	private WebElementFacade revSpringCheckMark;

	@FindBy(xpath = "//div[text()='Submitted']")
	private List<WebElementFacade> revSpringfinalSubmitMsgList;

	String revSpringfinalSubmitMsgListbefore = "//div[@class='flt-lft row'][";
	String revSpringfinalSubmitMsgListAfter = "]//div[text()='Submitted']";
	String revSpringCheckMarkBefore = "//div[@class='flt-lft row'][";
	String revSpringCheckMarkAfter = "]//div[@class='checkmark-icon']";
	String selectResonSummary = "Summaries_0__Reason";
	String textItemForReason = "PIF";
	String revSpringProfileIdtext;
	String accountBalBeforeXpath = "//div[@class='flt-lft accounts fake-grid accts-initial table table-bordered tableGridDiv']/table/tbody/tr[";
	String accountBalAfterXpath = "]/td[contains(@id,'Balance')]";
	String paymentAccountRow = "//div[@class='flt-lft accounts fake-grid accts-initial table table-bordered tableGridDiv']/table/tbody/tr";
	String paymentAccountCol = "//div[@class='flt-lft accounts fake-grid accts-initial table table-bordered tableGridDiv']/table/tbody/tr[1]/td";
	String dovetailRows = "//div[contains(@class, 'accts-dovetail tableGridDiv')]/table/tbody/tr";
	String dovetailColums = "//div[contains(@class, 'accts-dovetail tableGridDiv')]/table/tbody/tr[1]/td";
	String doveCheckBeforeXpath = "//div[contains(@class, 'accts-dovetail tableGridDiv')]/table/tbody/tr[";
	String deoveCheckAfterXpath = "]/td/div/input[@type='checkbox']";
	String dovetailAdjstBal = "]/td/input[contains(@id,'AdjustedBalance')]";
	String profileId;
	String emergeFrame1 = "//iframe[@id='EmergeIFrame']";
	String emiList = "//div[@class='t-popup t-group']/ul/li";
	String emiDropDownIcon = "//span[@class='t-icon t-arrow-down' and text()='select']";
	String emiDropDownBefore = "//div[@class='t-popup t-group']/ul/li[text()='";
	String emiDropDownAfter = "']";
	String revspringFrame = "//div[@id='Vendor2PaymentContainer']";

	/* verify intial page payment */
	public void verifiyInitialPage() {
		com.verifyElement(initiaPaymnet);

	}

	/* verify Dovetail page payment */
	public void verifiyDovetailPage() {
		com.verifyElement(dovetail);

	}

	/* verify summary page */
	public void verifiySummaryPage() {
		com.verifyElement(summaryPayment);

	}

	/* verify payment Information page */
	public void verifiyPaymentInformation() {
		com.verifyElement(paymentInformation);

	}

	/* verify GuarantorName Information page */
	public void verifiyGuarantorInfo() {
		com.verifyElement(GuarantorName);

	}

	/* verify Process page */
	public void verifyProcess() {
		com.verifyElement(process);
	}

	/* verify SuccessMessage */
	public void verifiySuccessMessage() {
		com.verifyElement(SuccessMessage);

	}

	/* verify Submitted message successfully */
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

		ArrayList<String> homeTablecolData = contactMethod.getColValue(homeReminderInfoRow, homeReminderInfoCol,
				columnHeader);
		try {
			for (int i = 0; i < homeTablecolData.size(); i++) {
				if (homeTablecolData.get(i).contains(searchElement)) {
					index = i;
					break;
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return index;
	}

	/* Intial page check and submit */
	public void enterAndCheck(String accountNumber) {
		int rowNum = readRealtiveColumn(paymentAccountRow, paymentAccountCol, "Account", accountNumber);
		String xpath = accountBalBeforeXpath + (rowNum + 1) + accountBalAfterXpath;
		String bal = element(By.xpath(xpath)).getText();
		String[] split = bal.split("\\.");
		String splited = split[0];
		int balance = Integer.parseInt(splited);
		int amount = CommonMethod.random(balance);
		WebElementFacade amountfield = element(xpath + "//following-sibling::td/input");
		amountfield.clear();
		amountfield.sendKeys(Integer.toString(amount));
		WebElementFacade includeCheck = element(
				xpath + "//following-sibling::td/div[@class='checkbox-margin']/div/input[contains(@id,'DoInitial')]");
		includeCheck.click();
		summaryButton.click();

	}

	/* Regular payment arrangement page adjusted balance */
	public String regularPaymentAdjstBal(String accountNumber) {
		int rowNum = readRealtiveColumn(paymentAccountRow, paymentAccountCol, "Account", accountNumber);
		String xpath = doveCheckBeforeXpath + (rowNum + 1) + dovetailAdjstBal;
		String adjustBal = element(By.xpath(xpath)).getAttribute("value");
		return adjustBal;

	}

	/*
	 * Verify Regular payment arrangement page adjusted balance with Total
	 * Installments Balance
	 */
	public void verifyInstallmentsBal(String accountNumber) {
		String adjustBalance = regularPaymentAdjstBal(accountNumber);
		String installmentBal = totalInstallments.getAttribute("value");
		Assert.assertTrue("Total Installments Balance isn't matching with  payment arrangement page adjusted balance  ",
				adjustBalance.contentEquals(installmentBal));
	}

	// Fetch payment per installment
	public double paymentPerInstallment() {
		String totalBal = totalInstallments.getAttribute("value");
		String numberOfEmi = emiDrpdown.getAttribute("value");
		String[] arrSplit = totalBal.split("\\.");
		double ppi = com.divideTwoNumber(Integer.parseInt(arrSplit[0]), Integer.parseInt(numberOfEmi));
		return ppi;

	}

	// verify Payment Per Installment
	public void verifyPayPerInstallments() {
		double payPerInstallments = Double.parseDouble(totalPerInstallment.getAttribute("value"));
		Assert.assertTrue("Pay per installment is not correct!!", payPerInstallments == paymentPerInstallment());

	}

	// Verify Start date of installment
	public void verifyStartInstallmentDate() {
		String startDate = installmentsStartDate.getAttribute("value");
		Assert.assertTrue("Start InstallmentDate is not matching!!", startDate.equals(com.nextMonthDate()));
	}

	/* Dovetail page check and submit */
	public void dovetailCheck(String accountNumber) throws InterruptedException {
		int rowNum = readRealtiveColumn(dovetailRows, dovetailColums, "Account", accountNumber);
		String dovetailCheck = doveCheckBeforeXpath + (rowNum + 1) + deoveCheckAfterXpath;
		if (element(By.xpath(dovetailCheck)).isClickable()) {
			element(By.xpath(dovetailCheck)).click();
		} else {
			Assert.assertTrue("Already Checked!", false);
		}
	}

	/* Click doveTailSummaryButton */
	public void clickDoveTailSummary() {
		doveTailSummaryButton.click();
	}

	// select random installament
	public void randEMI() {
		Select selectDropdown = new Select(emiDrpdown);
		List<WebElement> listOptionDropdown = selectDropdown.getOptions();
		randomEMI = (int) (Math.random() * listOptionDropdown.size() - 1) + 1;
		selectDropdown.selectByIndex(randomEMI);
	}

	// Click paymentInfo Submit button
	public void submitPaymentInfo() {
		payInfoSubmit.click();
	}

	/* verify revspring frame */
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

	// Enter checking / Savings details and submit
	public void enterChecking_SavingsDetails() {
		name.clear();
		name.sendKeys(CommonMethod.readProperties("Name"));
		CommonMethod.DrpVisibleTxt(accountdrpdown, "Savings");
		routingNumber.sendKeys(CommonMethod.readProperties("RoutingNumber"));
		accountNumber.sendKeys(CommonMethod.readProperties("ChequeAcccountNumber"));
		address.clear();
		address.sendKeys(CommonMethod.readProperties("Address"));
		city.clear();
		city.sendKeys(CommonMethod.readProperties("City"));
		CommonMethod.selectRandomList(stateOptions);
		postalCode.clear();
		postalCode.sendKeys(CommonMethod.readProperties("PostalCode"));

	}

	// Submit payment profile
	public void submitProfile() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", submitProfile);
		Thread.sleep(1000);
		submitProfile.click();
	}

	public void verifyProfileID() {

		com.verifyElement(profileID);
	}

	// Copying profile id
	public void copyProfileID() {
		copytext = profileID.getText();

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

	// select from reason dropdown
	public void selectResonDrpdwn(String text) {
		CommonMethod.DrpVisibleTxt(reasonDrpdwn, text);
	}

	// verify pay submission message
	public void verifySubmission(String text) {
		String submissionText = paySubmission.getText();
		Assert.assertTrue("Submission process message is missing!", submissionText.equals(text));
	}

	/* chechmarkIcon verification */
	public void verifyCheckMarkIcon() {
		com.verifyElement(chechmarkIcon);
	}

	// Verify sumission message
	public void verifySubmissionMsg() {
		int submissions = randomEMI + 1;
		if (submittedMsgList.size() == submissions) {
			for (int i = 0; i <= submissions; i++) {
				verifyCheckMarkIcon();
				verifySubmittedMessage();
			}
		} else {
			Assert.assertTrue("Number of submission is not equal to number of Installments", false);
		}
	}

	// click on checking/savings button
	public void clickCheckingBtn() {
		checking_SavingsBtn.click();
	}

	// Viks

	/* Verify submitted message vik */
	public void verifySubmittedMsgForRevSpring() {
		com.waitForControl("//div[text()='Submitted']");
		CommonMethod.isDisplayedMethod(revSpringfinalSubmitMsg);
		com.highLightSteps(revSpringfinalSubmitMsg);
		CommonMethod.isDisplayedMethod(revSpringCheckMark);
		com.highLightSteps(revSpringCheckMark);

	}

	/* Verify submitted list message vik */
	public void verifySuccessSubmitList() {
		int instalmentEMI = randomEMI + 1;
        try {
            Thread.sleep(3000);
     } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
     }
		if (instalmentEMI == revSpringfinalSubmitMsgList.size()) {
			for (int i = 1; i <= revSpringfinalSubmitMsgList.size(); i++) {
				String xpathSubmit = revSpringfinalSubmitMsgListbefore + i + revSpringfinalSubmitMsgListAfter;

				com.waitForControl(xpathSubmit);
				CommonMethod.isDisplayedMethod(
						element(By.xpath(revSpringfinalSubmitMsgListbefore + i + revSpringfinalSubmitMsgListAfter)));
				com.highLightSteps(
						element(By.xpath(revSpringfinalSubmitMsgListbefore + i + revSpringfinalSubmitMsgListAfter)));
				CommonMethod
						.isDisplayedMethod(element(By.xpath(revSpringCheckMarkBefore + i + revSpringCheckMarkAfter)));
				com.highLightSteps(element(By.xpath(revSpringCheckMarkBefore + i + revSpringCheckMarkAfter)));
			}
		} else {
			Assert.assertTrue(
					"installment EMI does not match with submit success message,EMI istallment " + instalmentEMI
							+ " Submitted table record = " + revSpringfinalSubmitMsgList.size(),
					instalmentEMI == revSpringfinalSubmitMsgList.size());
		}
	}

	/* click onm submit button vik */
	public void clickOnLastSubmitBtnForRecSpring() {
		clickOn(revSpringfinalSubmitBtn);
	}

	/* copied profie ID vik */
	public void revSpringcopyProfileID() {
		revSpringProfileIdtext = revSpringProfileId.getText();

	}

	/* Send copied profie ID vik */
	public void sendrevSpringProfileID() throws InterruptedException {
		getDriver().switchTo().defaultContent();
		home.switchHeaderFrame();
		revSpringProfileIdTextBox.sendKeys(revSpringProfileIdtext);
	}

	/* verify revspring profile id vik */
	public void veryfyReVspringProfileID() {
		CommonMethod.isDisplayedMethod(revSpringProfileId);
		com.highLightSteps(revSpringProfileId);
	}

	/* revspring card detail succes submissin msg detail vik */
	public void veryfyReVspringSuccesMsg() {
		CommonMethod.isDisplayedMethod(revSpringSuccessMsg);
		com.highLightSteps(revSpringSuccessMsg);
	}

	/* File revSpring card detail vik */
	public void fillRevSpringCardDetails() throws InterruptedException {
		revSpringFirstName.clear();
		revSpringFirstName.sendKeys(CommonMethod.readProperties("FirstName"));
		revSpringLastName.clear();
		revSpringLastName.sendKeys(CommonMethod.readProperties("LastName"));
		revSpringAddres1.clear();
		revSpringAddres1.sendKeys(CommonMethod.readProperties("Address"));
		revSpringCity.clear();
		revSpringCity.sendKeys(CommonMethod.readProperties("City"));
		revSpringState.clear();
		revSpringState.sendKeys(CommonMethod.readProperties("State"));
		revSpringCode.clear();
		revSpringCode.sendKeys(CommonMethod.readProperties("PostalCode"));
		com.selectListWithElement("profile_kind", "Credit Card");
		com.selectListWithElement("profile_cc_account_type", "visa");
		revSpringCardNum.clear();
		revSpringCardNum.sendKeys(CommonMethod.readProperties("CardNumber"));
		com.selectListWithElement("profile_cc_expiration_month", "6");
		com.selectListWithElement("profile_cc_expiration_year", "2027");
		clickOn(revSpringSubmitBtn);

	}

	/* Medthod to click radio btn vik */
	public void agentInputRadioBtn() {
		agentInputRadiobtn.click();
		com.verifyCheckBox(agentInputRadiobtn);
	}

	/* Medthod to select reason in summary vik */
	public void selectReasonForPaySummary() throws InterruptedException {

		com.selectListWithElement(selectResonSummary, textItemForReason);
	}

	/* verify revspring frame vik */
	public void revspringFrame() {
		contactMethod.waitForControl("//iframe[@id='PaymentIFrame']");
		getDriver().switchTo().frame(revSpringFrame);

		com.verifyElement(revSpringFrameHeader);
		com.highLightSteps(revSpringFrameHeader);
	}

}
