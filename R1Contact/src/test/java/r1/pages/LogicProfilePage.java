package r1.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class LogicProfilePage extends PageObject {
	
	
	R1ContactCommonMethods r1ComMethod;
	CommonMethod com;
	
	@FindBy(xpath = "//div[contains(text(),'Logic Profiles')]")
	private WebElementFacade logicPageHeader;
	
	@FindBy(xpath = "//a[text()='Add new record']")
	private WebElementFacade addRecordLogic;
	
	
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElementFacade addRecordPopCancelBtn;
	
	@FindBy(xpath = "//div[@id='LogicProfilePopUp']")
	private WebElementFacade addRecordLogicProfilePopUp;
	
	@FindBy(xpath = "//div[@id='dialogLogicFilter']")
	private WebElementFacade dialogLogicProfilerFilter;
	
	
	@FindBy(xpath = "//div[@id='dialogLogicFilter']//span[text()='Cancel']")
	private WebElementFacade alterPopCancelBtn;
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[5]/a[text()='Alter']")
	private WebElementFacade firstRowAlterBtnLogic;
	
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[6]/a[contains(text(),'Edit Order')]")
	private WebElementFacade firstRowEditBtn;
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[7]/a")
	private WebElementFacade firstRowDelteBtn;
	
	
	@FindBy(xpath = "//div[@id='LogicProfilePopUp']")
	private WebElementFacade dialogLogicProfilerEdit;
	
	
	@FindBy(xpath = "//div[@id='LogicProfilePopUp']//a[text()='Cancel']")
	private WebElementFacade EditPopCancelBtn;
		
	
	public void verifyLogicProfilePage()
	{
		
		CommonMethod.isDisplayedMethod(logicPageHeader);
		com.highLightSteps(logicPageHeader);
	}
	
	public void verifyLogicProfileEdit()
	{
		clickOnLogicEdit();
		CommonMethod.isDisplayedMethod(dialogLogicProfilerEdit);
		clickOn(EditPopCancelBtn);
		
	}
	
	public void clickOnLogicAddRecord()
	{
		clickOn(addRecordLogic);
	}
	
	public void clickOnLogicAlter()
	{
		clickOn(firstRowAlterBtnLogic);
	}
	
	public void clickOnLogicEdit()
	{
		clickOn(firstRowEditBtn);
	}
	
	public void clickOnLogicDelete()
	{
		clickOn(firstRowDelteBtn);
	}
	
	public void verifyDeleteAlert()
	{
		clickOnLogicDelete();
		com.dimissAlert();
	}
	
	public void verifyAddRecordLogicProfilePopUp()
	{
		clickOnLogicAddRecord();
		CommonMethod.isDisplayedMethod(addRecordLogicProfilePopUp);
		clickOn(addRecordPopCancelBtn);
	}
	
	public void verifyAlterLogicFilterDispaly() 
	{
		clickOnLogicAlter();
		com.waitForControl("//div[@id='dialogLogicFilter']");
		CommonMethod.isDisplayedMethod(dialogLogicProfilerFilter);
		clickOn(alterPopCancelBtn);
	}

}
