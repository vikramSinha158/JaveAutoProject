package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class ReminderPage extends BasePage {

	R1ContactCommonMethods contactCommon;
	CommonMethod common;
	HomePage Home;
	Date date;

	final String containCheck = "already exists";
	static String noteText = "Please check!";

	@FindBy(xpath = "//span[@id='Reminder']")
	private WebElementFacade ReminderIcon;

	@FindBy(xpath = "//input[@id='ReminderDate']//following::span[@class='t-icon t-icon-calendar']")
	private WebElementFacade calenderPicker;

	@FindBy(xpath = "//input[@id='ReminderTime']//following::span[@class='t-icon t-icon-clock']")
	private WebElementFacade daterPicker;

	@FindBy(id = "ReminderNote")
	private WebElementFacade reminderNote;

	@FindBy(id = "SubmitReminder")
	private WebElementFacade submitreminder;

	@FindBy(xpath = "//i[contains(@class,'clock')]")
	private WebElementFacade reminderIcon;

	@FindBy(xpath = "//div[contains(@id,'TooltipPopupContainer')]")
	private WebElementFacade ReminderContainer;

	@FindBy(xpath = "//input[@id='ReminderTime']")
	private WebElementFacade TimeField;

	@FindBy(xpath = "//input[@id='ReminderDate']")
	private WebElementFacade dateField;

	@FindBy(xpath = "//span[contains(text(),'time view')]")
	private WebElementFacade timeIcon;

	@FindBy(xpath = "//img[@src='/Content/images/close.png']")
	private WebElementFacade remindarclose;

	@FindBy(xpath = "//img[@src='/Content/images/save.PNG']")
	private WebElementFacade reminderSave;
	
	
	String TimeIcinBtn = "//span[@title='Open the time view']";
	
	
	String timedropdown="//div[@class='t-popup t-group t-time-popup']/ul/li";
	
	public void selectTimeFromReminder(String timeToBeselected) throws InterruptedException
	{
		contactCommon.clickdropdown(TimeIcinBtn, timedropdown, timeToBeselected);
		
	}
	
	

	public void reminderIcon() {
		Assert.assertTrue("Reminder icon is not coming", reminderIcon.isVisible());
	}

	public void ClickreminderIcon() {

		reminderIcon.click();
	}

	public void IsreminderContainerDisplayed() {
		Assert.assertTrue("Reminder container is not coming", ReminderContainer.isDisplayed());

	}

	public static String reminderDateToFill() throws FileNotFoundException, IOException {
		String DATE_REMINDER = CommonMethod.readProperties("DATE_REMINDER");
		int integerDate = Integer.parseInt(DATE_REMINDER);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, integerDate);
		Date date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String reminderDate = formatter.format(date);
		return reminderDate;
	}

	public void FillreminderDate() throws FileNotFoundException, IOException {
		dateField.clear();
		String reminderDate = reminderDateToFill();
		dateField.sendKeys(reminderDate);
		TimeField.clear();
		TimeField.sendKeys(CommonMethod.readProperties("ReminderTime"));

	}
	
	public void FillOnlyDateOnReminder() throws FileNotFoundException, IOException {
		dateField.clear();
		String reminderDate = reminderDateToFill();
		dateField.sendKeys(reminderDate);
		

	}
	
	public void FillOnlyTimeOnReminder() throws FileNotFoundException, IOException {
	
		TimeField.clear();
		TimeField.sendKeys(CommonMethod.readProperties("ReminderTime"));

	}
	
	

	public void setReminderNote(String note) {
		reminderNote.clear();
		reminderNote.sendKeys(note);

	}

	public void submitReminder() {
		submitreminder.click();
	}

	public void fillRemindarForm() throws FileNotFoundException, IOException {
		ClickreminderIcon();
		FillreminderDate();
		setReminderNote(noteText);
		submitReminder();
		if (contactCommon.checkAlert()) {
			getDriver().switchTo().alert();
			reminderAlertAssertion();
		}
	}

	/*
	 * Duplicate reminder alert check assertion
	 */
	public void reminderAlertAssertion() {
		String reminderAlert = getDriver().switchTo().alert().getText();
		Assert.assertTrue("Expected Alert Message is not coming!", reminderAlert.contains(containCheck));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().switchTo().alert().dismiss();

	}

	public void VerifyDuplicateReminderAlert() throws FileNotFoundException, IOException {
		if (contactCommon.checkAlert()) {
			getDriver().switchTo().alert();
			reminderAlertAssertion();
		} else {
			fillRemindarForm();

		}
	}

	public void verifyRemindarPopup() throws FileNotFoundException, IOException {

		if (dateField.isDisplayed()) {
			common.highLightSteps(dateField);
			dateField.clear();
			dateField.sendKeys(reminderDateToFill());
			dateField.clear();
		} else {
			Assert.assertTrue("Date Field is not displayed!", false);
		}

		if (calenderPicker.isClickable()) {
			common.highLightSteps(calenderPicker);
			calenderPicker.click();
		} else {
			Assert.assertTrue("Calendar is not displayed!", false);
		}
		if (TimeField.isDisplayed()) {
			common.highLightSteps(TimeField);
			timeIcon.click();
		} else {
			Assert.assertTrue("Time field is not displayed!", false);
		}
		if (reminderNote.isEnabled()) {
			common.highLightSteps(reminderNote);
			reminderNote.clear();
			reminderNote.sendKeys(noteText);
		} else {
			Assert.assertTrue("ReminderNote Field is not displaed!", false);
		}
		if (remindarclose.isDisplayed()) {
			common.highLightSteps(remindarclose);
			remindarclose.click();
		} else {
			Assert.assertTrue("Reminder close icon is not displayed!", false);
		}
	}

}
