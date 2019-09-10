package r1.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;

public class ReminderPage extends BasePage  {
	R1ContactCommonMethods com;
	HomePage c;
	
	@FindBy(xpath = "//span[@id='Reminder']")
	private WebElementFacade ReminderIcon;
	
/*	@FindBy(xpath="//div[@id='Accounts']/table/tbody/tr[1]/td")
	private List<WebElementFacade>colNum;
	
	@FindBy(xpath="//div[@id='Accounts']/table/tbody/tr")
	private List<WebElementFacade>accountRows;*/
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
	
	public void m1() {
		com.getTableColValue(accountRows, colNum, "0002671680104");
			
		}
	
	public void enterLastNameTxt(String txtValue)
	{
		lastNametxt.sendKeys(txtValue);
		
	}
	
	public void lastNameSearchclk()
	{
		clickOn(lastNameSearchclk);
		
	}
	
	public void searchAccountlables()
	{
		for(int i=0;i<searchAccLabels.size();i++)
		{
			//searchAccLabels.get(i).getAttribute("value");
			System.out.println(searchAccLabels.get(i).getAttribute("value"));
		}
	}
	
	
	}
	

