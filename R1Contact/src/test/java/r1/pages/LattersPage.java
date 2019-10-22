package r1.pages;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;


public class LattersPage extends PageObject {
	

	R1ContactCommonMethods r1ComMethod;
	CommonMethod com;
	
	@FindBy(xpath = "//div[contains(text(),'Letters')]")
	private WebElementFacade lettersPageHeader;
	
	@FindBy(xpath = "//a[text()='Add new record']")
	private WebElementFacade addRecordLettersBtn;
		
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElementFacade addRecordPopCancelBtnLetter;
	
	@FindBy(xpath = "//div[@id='LetterConfigPopUp']")
	private WebElementFacade addRecordLettersPopUp;
	
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> lettersTblrow;
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[13]/a[text()='Alter']")
	private WebElementFacade firstRowAlterBtnLetter;
	
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[14]/a[contains(text(),' Edit Details')]")
	private WebElementFacade firstRowEditBtnLetter;
	
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[16]/a")
	private WebElementFacade firstRowDelteBtnLetter;
	
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[15]/a")
	private WebElementFacade firstRowToggleBtnLetter;
	
	@FindBy(xpath = "//div[@id='dialogLogicFilter']")
	private WebElementFacade dialogLetterProfilerEdit;
	
	@FindBy(xpath = "//div[@id='dialogLogicFilter']//span[text()='Cancel']")
	private WebElementFacade letterAlterPopCancelBtn;
	
	
	
	@FindBy(xpath = "//div[@id='LetterConfigPopUp']")
	private WebElementFacade dialogLettersProfilerEdit;
	
	
	@FindBy(xpath = "//div[@id='LetterConfigPopUp']//a[text()='Cancel']")
	private WebElementFacade EditPopCancelBtnLetters;
	
	
	public void verifyAddRecordLettersPopUp()
	{
		clickOnLettersAddRecord();
		CommonMethod.isDisplayedMethod(addRecordLettersPopUp);
		clickOn(addRecordPopCancelBtnLetter);
	}
	
	
	public void verifyDeleteAlertLetter()
	{
		clickonDelteBtnLattersTbl();
		com.dimissAlert();
	}
	
	public void verifyToggleAlertLetter()
	{
		clickonToggleBtnLattersTbl();
		com.dimissAlert();
	}
	
	public void verifyLettersEdit()
	{
		clickonEditBtnLattersTbl();
		CommonMethod.isDisplayedMethod(dialogLettersProfilerEdit);
		clickOn(EditPopCancelBtnLetters);
		
	}
	
	
	public void verifyAlterLettersFilterDispaly() 
	{
		clickonAlterBtnLattersTbl();
		com.waitForControl("//div[@id='dialogLogicFilter']");
		CommonMethod.isDisplayedMethod(dialogLetterProfilerEdit);
		clickOn(letterAlterPopCancelBtn);
	}
	
	
	public void clickOnLettersAddRecord()
	{
		clickOn(addRecordLettersBtn);
	}
	
	public void clickOnLetterAddRecordCancelBtn()
	{
		clickOn(EditPopCancelBtnLetters);
	}
	
	
	public void verifyLettersPage()
	{
		
		CommonMethod.isDisplayedMethod(lettersPageHeader);
		com.highLightSteps(lettersPageHeader);
	}
	
	public void clickonBtnLattersTbl(WebElementFacade element)
	{
		
		if(lettersTblrow.size()>0)
		{
			clickOn(element);
			
		}
		else
		{
			Assert.assertTrue("No row found in Table to click", lettersTblrow.size()>0);
		}
		
	}
	
	public void clickonAlterBtnLattersTbl()
	{
		clickonBtnLattersTbl(firstRowAlterBtnLetter);
		
		
	}
	
	
	
	public void clickonEditBtnLattersTbl()
	{
		
		clickonBtnLattersTbl(firstRowEditBtnLetter);
		
	}
	
	public void clickonToggleBtnLattersTbl()
	{
		
		clickonBtnLattersTbl(firstRowToggleBtnLetter);
		
	}
	
	public void clickonDelteBtnLattersTbl()
	{
		
		clickonBtnLattersTbl(firstRowDelteBtnLetter);
		
	}
	
	

}
