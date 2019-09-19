package r1.pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethods;

public class ReminderPage extends BasePage  {

	R1ContactCommonMethods contactCommon;
	CommonMethods.common common;
	HomePage Home;
	Date date;

	private static int DATE_REMINDER=4;
	private static int counter=0;
	final String containCheck ="already exists";
	static String noteText="Please check!";
	static String accountnumber="0003257700065";
	String accountColHeader="Patient Name";
	String accountRowLocator="//table[@cellspacing='0']/tbody/tr";	
	String accountColLocator="//table[@cellspacing='0']//thead/tr/th";
	String accountRows = "//div[@id='Accounts']/table/tbody/tr";
	String colNum = "//div[@id='Accounts']/table/tbody/tr[2]/td";

	@FindBy(xpath = "//span[@id='Reminder']")
	private WebElementFacade ReminderIcon;

	@FindBy(xpath="//button[@id='NameSubmit']")
	private WebElementFacade lastNameSearchclk; 

	@FindBy(xpath="//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> accountTablerOW; 

	@FindBy(xpath="//input[@id='LastName']")
	private WebElementFacade lastNametxt;

	@FindBy(xpath="//div[@class='flt-lft label-item']/p")
	private List<WebElementFacade> searchAccLabels;

	@FindBy(xpath = "//input[@id='ReminderDate']//following::span[@class='t-icon t-icon-calendar']")
	private WebElementFacade calenderPicker;

	@FindBy(xpath = "//input[@id='ReminderTime']//following::span[@class='t-icon t-icon-clock']")
	private WebElementFacade daterPicker;

	@FindBy(id = "ReminderNote")
	private WebElementFacade reminderNote;

	@FindBy(id="SubmitReminder")
	private WebElementFacade submitreminder;

	@FindBy(xpath ="//i[contains(@class,'clock')]")
	private WebElementFacade reminderIcon;

	@FindBy(xpath ="//div[contains(@id,'TooltipPopupContainer')]")
	private WebElementFacade ReminderContainer;

	@FindBy(xpath ="//input[@id='ReminderTime']")
	private WebElementFacade TimeField;

	@FindBy(xpath ="//input[@id='ReminderDate']")
	private WebElementFacade dateField;

	@FindBy(xpath ="//span[contains(text(),'time view')]")
	private WebElementFacade timeIcon;

	@FindBy(xpath ="//img[@src='/Content/images/close.png']")
	private WebElementFacade remindarclose;

	@FindBy(xpath="//img[@src='/Content/images/save.PNG']")
	private WebElementFacade reminderSave;

	public void selectAndClickAccount() {
		contactCommon.getTableColValue(accountRows, colNum, accountnumber);

	}

	public void enterLastNameTxt(String txtValue)
	{
		lastNametxt.clear();
		lastNametxt.sendKeys(txtValue);

	}

	public void lastNameSearchclk()
	{
		clickOn(lastNameSearchclk);

	}

	@SuppressWarnings("deprecation")
	public void searchAccountlables()
	{
		for(int i=0;i<searchAccLabels.size();i++)
		{
			Assert.assertTrue("Search criteria label name is:"+searchAccLabels.get(i).getText(), searchAccLabels.get(i).isDisplayed());
		}
	}

	@SuppressWarnings("deprecation")
	public void reminderIcon()
	{
		Assert.assertTrue("Reminder icon is not coming", reminderIcon.isVisible());
	}

	public void ClickreminderIcon()
	{

		reminderIcon.click();
	}

	@SuppressWarnings("deprecation")
	public void IsreminderContainerDisplayed()
	{
		Assert.assertTrue("Reminder container is not coming", ReminderContainer.isDisplayed());

	}

	public static String tommorrowdate()
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, DATE_REMINDER);
		Date date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String reminderDate = formatter.format(date);
		return reminderDate;
	}

	public void FillreminderDate()
	{
		dateField.clear();
		String reminderDate = tommorrowdate();
		dateField.sendKeys(reminderDate);
	}

	public void setReminderNote(String note )
	{
		reminderNote.clear();
		reminderNote.sendKeys(note);

	}


	public void submitReminder()
	{
		submitreminder.click();
	}

	public void fillRemindarForm()
	{
		ClickreminderIcon();
		FillreminderDate();
		setReminderNote(noteText);
		submitReminder();
	}

	// Duplicate reminder alert check assertion

	@SuppressWarnings("deprecation")
	public void reminderAlertAssertion()
	{
		String reminderAlert = getDriver().switchTo().alert().getText();
		Assert.assertTrue("Expected Alert Message is not coming!", reminderAlert.contains(containCheck));
		getDriver().switchTo().alert().dismiss();

	}

	public void VerifyDuplicateReminderAlert() {
		if(contactCommon.checkAlert()) {
			getDriver().switchTo().alert();
			reminderAlertAssertion();
		}
		else
		{	
			fillRemindarForm();		
			getDriver().switchTo().alert();
			reminderAlertAssertion();
		}
	}

	// List of patient matching with last name

	@SuppressWarnings("deprecation")
	public void verifyFirstCharForLastName(String firstCharLastName)
	{

		ArrayList<String> patientList=contactCommon.getColValue(accountRowLocator, accountColLocator, accountColHeader);

		for(String patientName:patientList)
		{
			String[] patientNameSplit=patientName.split(" ");
			String LastName=patientNameSplit[patientNameSplit.length-1];				

			if(LastName.toUpperCase().startsWith(firstCharLastName.toUpperCase()))
			{
				counter++;

			}

		}

		//Assert.assertEquals("Number of row not match for search element "+ firstCharLastName,accountTablerOW.size(), counter);

	} 

	public void verifyRemindarPopup()
	{
		if(dateField.isDisplayed()) {
			dateField.clear();
			dateField.sendKeys(tommorrowdate());
			dateField.clear();
		} else
		{
			Assert.assertTrue(false);
		}

		if(calenderPicker.isClickable())
		{
			calenderPicker.click();
		} else
		{
			Assert.assertTrue(false);
		}
		if(TimeField.isDisplayed())
		{
			timeIcon.click();
		} else
		{
			Assert.assertTrue(false);
		}
		if(reminderNote.isEnabled())
		{
			reminderNote.clear();
			reminderNote.sendKeys(noteText);
		} else
		{
			Assert.assertTrue(false);
		}
		if(remindarclose.isDisplayed())
		{
			remindarclose.click();
		}else
		{
			Assert.assertTrue(false);
		}
	}




}




