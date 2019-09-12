package r1.pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    private static int DATE_REMINDER=40;

		
	
	
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
	
	static String accountnumber="0002671680104";
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
		Assert.assertTrue("Reminder icon is not coming", reminderIcon.isDisplayed());
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
	
	@SuppressWarnings("deprecation")
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
	
	@SuppressWarnings("deprecation")
	public void verifyDuplicateReminder()
	{
		common.VerifyDuplicateReminderAlert();
		
	}
	String accountRowLocator="//table[@ng-table='tableParams']/thead/tr";
	String accountColLocator="//table[@ng-table='tableParams']/thead/tr/th";
	//table[@ng-table='tableParams']/thead/tr/th//span[text()='Account Number']

	public void verifyReminder()
	{
		//contactCommon.getColValue(accountRowLocator, accountColLocator, "Account Number");
	}
	

	
/*	public boolean checkRemindar()
    {
		Boolean flag=true;
    for(int i=1;i<=reminderList.size()-1;i++)
    {
    	String rowlocator2=reminderRow+ "[" + i + "]";
    	
    	for(int j=1;j<reminderListColumn.size();j++)
    	{
    		String colLocator1=rowlocator2+"/td["+j+"]/a";
    		System.out.println(colLocator1);
    		String accountNumber=element(By.xpath(colLocator1)).getText();
    		String date=element(rowlocator2+"/td[1]/a").getText();
    		if(accountNumber.equalsIgnoreCase(ReminderPage.accountnumber)&&date.equalsIgnoreCase(ReminderPage.tommorrowdate()))
    		{
    			
    			flag=false;
    			System.out.println(flag);
    			break;
    			
    		}
    		
    		}
    	if(flag=false)
    	{
    		break;
    	}
    	System.out.println(flag);
    }
    
    return flag;
    
    }*/
	
	public boolean isAlertPresents() {
		try {
		getDriver().switchTo().alert();
		return true;
		}// try
		catch (Exception e) {
		return false;
		}// catch
		}
	
	@SuppressWarnings("deprecation")
	public void VerifyDuplicateReminderAlert() {
		
		/*boolean status=Home.checkRemindar();
		System.out.println(status);*/
		
		

		if(isAlertPresents()) {
		String reminderAlert = getDriver().switchTo().alert().getText();
		System.out.println(reminderAlert);
		getDriver().switchTo().alert().dismiss();
		Assert.assertTrue("Expected Alert Message is not coming!", reminderAlert.contains("already exists"));
	}
		else
		{
			ClickreminderIcon();
			FillreminderDate();
			setReminderNote("Hi" );
			submitReminder();
			String reminderAlert = getDriver().switchTo().alert().getText();
			System.out.println(reminderAlert);
			getDriver().switchTo().alert().dismiss();
			Assert.assertTrue("Expected Alert Message is not coming!", reminderAlert.contains("already exists"));
		}
	}
	
	
	}
	
	
	

