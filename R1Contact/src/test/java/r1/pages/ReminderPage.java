package r1.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethods;

public class ReminderPage extends BasePage  {
	R1ContactCommonMethods com;
	CommonMethods.common common;
	HomePage c;
	Date date;
	//Calendar cal;
	
	@FindBy(xpath = "//span[@id='Reminder']")
	private WebElementFacade ReminderIcon;
	
	String accountRows = "//div[@id='Accounts']/table/tbody/tr";
	
	String colNum = "//div[@id='Accounts']/table/tbody/tr[2]/td";
	
	@FindBy(xpath="//button[@id='NameSubmit']")
	private WebElementFacade lastNameSearchclk; 
	
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
	
	@FindBy(xpath ="//input[@id='ReminderDate']")
	private WebElementFacade dateField;
	
	
	public void selectAndClickAccount() {
		com.getTableColValue(accountRows, colNum, "0002671680104");
			
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
	
	public void reminderIcon()
	{
		Assert.assertTrue("Reminder icon is not coming", reminderIcon.isDisplayed());
	}
	
	public void ClickreminderIcon()
	{
		reminderIcon.click();
	}
	
	public void IsreminderContainerDisplayed()
	{
		Assert.assertTrue("Reminder container is not coming", ReminderContainer.isDisplayed());
		
	}
	
	@SuppressWarnings("deprecation")
	public void tommorrowdate()
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(cal);
		
		  // SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		   //String strDate= formatter.format(cal);
		   //System.out.println(strDate);
	}
	
	public void fillreminder()
	{
		dateField.clear();
		dateField.sendKeys("9/15/2019");
		reminderNote.clear();
		reminderNote.sendKeys("Set remindar");
		submitreminder.click();
		
		
	}
	
	public void verifyDuplicateRem()
	{
		common.switchWindow();
		
		getDriver().switchTo().window(getDriver().getWindowHandle());
	}
	}
	
	
	

