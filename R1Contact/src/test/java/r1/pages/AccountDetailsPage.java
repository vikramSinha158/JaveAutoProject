package r1.pages;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class AccountDetailsPage extends PageObject {
	CommonMethod comMethod;
	R1ContactCommonMethods contactCommon;
	HomePage home;
	AccountPage account;
	String agentPatientPageEmail;
	private String accNumberxpath = "//div[@class='account-number']";
	@FindBy(xpath = "//div[@class='pull-left right-item']/a")
	private List<WebElementFacade> patientAndGuarntName;

	@FindBy(xpath = "//div[@id='RequestConfigs']//tbody/tr")
	private List<WebElementFacade> codeAndDesRows;

	@FindBy(xpath = "//div[@class='pull-left patient stretch account-box']//div[@class='pull-left right-item']//a")
	WebElementFacade patientInfoLink;

	@FindBy(xpath = "//a[contains(text(),'Link Balance ')]")
	WebElementFacade balanceClk;

	@FindBy(xpath = "//span[@class='accordion-title']")
	List<WebElementFacade> patientDetailTabs;

	@FindBy(xpath = "//div[contains(text(),'Diagnosis')]")
	WebElementFacade diagnosisLabelEncInfo;

	@FindBy(xpath = "//div[contains(text(),'Click to View')]")
	WebElementFacade clkViewlEncInfo;

	@FindBy(xpath = "//div[@id='TooltipPopupContainer']")
	WebElementFacade popUplEncInfo;

	@FindBy(xpath = "//img[@alt='Take account ownership'][@src='/Content/images/checkmark.png']")
	WebElementFacade chkMarkJHouse;

	@FindBy(xpath = "//img[@alt='Patient agreed'][@src='/Content/images/checkmark.png']")
	WebElementFacade patientAgreepopUplEncInfo;

	@FindBy(xpath = "//div[contains(text(),'Owner')]//following-sibling::div//div[@class='flt-lft']")
	WebElementFacade ownerEmail;

	@FindBy(xpath = "//div[@class='has-icon head-box']")
	private List<WebElementFacade> accountInfoSection;

	@FindBy(xpath = "//td[contains(text(),'CHARITY APPLICATION')]/following-sibling::td/a")
	private WebElementFacade chrityCreate;

	@FindBy(id = "DoRequest")
	private WebElementFacade requestIcon;

	@FindBy(xpath = "//div[@id='RequestConfigs']//thead")
	private WebElementFacade codeTableHeader;

	@FindBy(xpath = "//span[text()=' Payment History ']")
	private WebElementFacade paymentHistory;

	@FindBy(xpath = "//a[text()='Bill Statements']")
	private WebElementFacade billStatement;

	@FindBy(xpath = "//span[text()='Billing Statement Report']")
	private WebElementFacade billingStatReport;

	@FindBy(xpath = "//a[text()='Show PDF']")
	private WebElementFacade showAnyPDF;

	@FindBy(xpath = "//div[@id='content']")
	private WebElementFacade pdfSrc;

	@FindBy(xpath = "//input[@id='Note']")
	private WebElementFacade txtForNote;

	@FindBy(xpath = "//button[@id='Save'][@type='submit']")
	private WebElementFacade clkSubmitBtn;

	@FindBy(xpath = "//table[@ng-table='tableParams']//tbody//tr[1]//td[@data-title-text='Notes']//span")
	private WebElementFacade noteTextCellvalue;
	
	@FindBy(id="aMode")
	private WebElementFacade paymentDropDown;

	int PatientDtlTabs = Integer.parseInt(CommonMethod.readProperties("patientDetailtabs"));

	public void patientAndGuarntName() {
		for (int i = 0; i < patientAndGuarntName.size(); i++)
			Assert.assertTrue("Patient And GuarntName is not coming", patientAndGuarntName.get(i).isDisplayed());
	}

	/* verify account information section displayed or not */
	public void verifyAccountInfoSection() {
		int size = accountInfoSection.size();
		for (int i = 0; i < size; i++) {
			accountInfoSection.get(i).isDisplayed();

		}
	}

	/*-------HOME--  Click on patient detail tabs  ------*/

	public void displayPatientDtlTabs() {

		int counter = 0;
		for (int i = 0; i < patientDetailTabs.size(); i++) {

			patientDetailTabs.get(i).isDisplayed();
			comMethod.scrollInView(patientDetailTabs.get(i));
			counter++;
		}

		Assert.assertEquals("Account info page has not all expected tabs", PatientDtlTabs, counter);
	}

	public void clickOnPatientLink() {
		clickOn(patientInfoLink);
	}

	/*----Click on Balance Link --------------- ----*/
	public void balancelinkClk() {
		clickOn(balanceClk);
	}

	public void verifyAccInfoAccNum(String AccountNumber) {
		contactCommon.verifyAccountNumber(accNumberxpath, CommonMethod.readProperties(AccountNumber));
	}

	public void verifyAccountWithDb(String AccountNum) {
		contactCommon.verifyAccountNumber(accNumberxpath, AccountNum);
	}
	/*-------HOME--  Click on patient detail tabs  ------*/

	public void clickPatientDtlTabs(String menuName) {

		boolean tabcheck = false;

		for (int i = 0; i < patientDetailTabs.size(); i++) {

			if (patientDetailTabs.get(i).getText().toUpperCase().contains(menuName.trim().toUpperCase())) {

				comMethod.scrollInView(patientDetailTabs.get(i));
				clickOn(patientDetailTabs.get(i));
				tabcheck = true;
				break;
			}
		}

		Assert.assertTrue(menuName + " Element Not found ", tabcheck);

	}

	/*-------verify Encounter Information expand ------*/

	public void verifyEncounterTabExpand() {
		CommonMethod.isDisplayedMethod(diagnosisLabelEncInfo);
		comMethod.highLightSteps(diagnosisLabelEncInfo);
	}

	/*-------click in view Encounter Information ------*/
	public void clkInView() {
		clickOn(clkViewlEncInfo);
	}

	/*-------verify PopUp Encounter Information ------*/
	public void verifyPopUpInEncInfo() {

		if (popUplEncInfo.isDisplayed()) {
			CommonMethod.isDisplayedMethod(patientAgreepopUplEncInfo);
			comMethod.highLightSteps(patientAgreepopUplEncInfo);
		} else {
			Assert.assertTrue("Agreed pop is not dispalyed", popUplEncInfo.isDisplayed());
		}

	}

	/*------------Click on Jhouse check mark ------*/

	public void clkOnJHouseChckMark() {
		clickOn(chkMarkJHouse);
	}

	public void ownerEmail() {

		agentPatientPageEmail = ownerEmail.getText();

	}

	public void verifyOwnerJHouseWithAgentName() {
		boolean ownerchk = false;
		if (HomePage.agentEmailID.toLowerCase().contains(agentPatientPageEmail.toLowerCase())) {
			ownerchk = true;
		} else {
			Assert.assertTrue("Agent name does not matched", ownerchk);
		}
	}

	public void clickRequest() {
		requestIcon.click();
	}

	// Verify create user request page
	public void verifyRequestPage() {
		Assert.assertTrue("User is not on create Request Page!!!", codeTableHeader.isDisplayed());
	}

	// Create request
	public void createReq() {
		chrityCreate.click();

	}

	public void codeAndDes() {
		Assert.assertTrue("No code and description rows are coming", codeAndDesRows.size() > 0);

	}

	/* Click payment History */
	public void clickPaymentHistory() {
		paymentHistory.click();
	}

	/* payment dropdown */
	public void paymentDropdown(String value) throws InterruptedException {
		CommonMethod.DrpVisibleTxt(paymentDropDown, value);
	}

	/* Enter text for notes */
	public void enterTextForNotes() {
		txtForNote.sendKeys(CommonMethod.readProperties("textForStatusNotes"));
	}

	/* click notes button after entering notes */
	public void clkNotesBtn() {
		clickOn(clkSubmitBtn);
	}

	public void verifyAccountNotesInNotesTable() {

		String notesTxt = noteTextCellvalue.getText();

		comMethod.scrollInView(noteTextCellvalue);
		Assert.assertTrue("Actual vlaue not match with expected text " + notesTxt,
				notesTxt.contains(CommonMethod.readProperties("textForStatusNotes")));
	}

	/* click on Bill Statement */
	public void clickBillStatement() throws InterruptedException {
		billStatement.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Billing Statement Report']")));

	}

	/* Bill statement report window */
	public void billReportWindow() {
		String statementText = billingStatReport.getText();
		Assert.assertEquals(statementText, "Billing Statement Report");

	}

	public void clickShowPDF() {
		showAnyPDF.click();
	}

	@FindBy(xpath = "//iframe[@id='iframepdf1571320266191']")
	private WebElementFacade pdfFrame;

	public void verifyPDF() throws InvalidPasswordException, IOException {
		String Url = "http://uatccc.accretivehealth.com/Account/GetBillingStatementPdf?aAccountNumber=fab2ccd0-7880-e911-80e5-0050569a120c&aFac=ASWI&aPatId=";
		URL url = new URL(Url);
		InputStream is = url.openStream();
		BufferedInputStream fileparse = new BufferedInputStream(is);
		PDDocument doc = null;
		doc = PDDocument.load(fileparse);
		PDFTextStripper pdfContent = new PDFTextStripper();
		pdfContent.getText(doc);

	}
}
