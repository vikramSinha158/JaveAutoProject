package r1.pages;

import net.serenitybdd.core.pages.PageObject;
import java.util.List;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class ThirdPartyConnectionsPage extends PageObject {
	
	R1ContactCommonMethods r1ComMethod;
	CommonMethod com;
	
	@FindBy(xpath = "//div[contains(text(),'Third Party Connections')]")
	private WebElementFacade ThirdPartyConnectionPageHeader;
	
	@FindBy(xpath = "//a[text()='Add new record']")
	private WebElementFacade addRecordThirdPatyConBtn;
		
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElementFacade addRecordPopCancelBtnThirdPatyCon;
	
	@FindBy(xpath = "//div[@id='ThirdPartyConnectionPopUp']")
	private WebElementFacade addRecordThirdPatyConPopUp;
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr[1]/td[12]/a[contains(text(),'Edit')]")
	private WebElementFacade firstRowEditBtnThirdPartyCon;
	
	@FindBy(xpath = "//table[@cellspacing='0']/tbody/tr")
	private List<WebElementFacade> ThirdPartyConTblrow;
	
	@FindBy(xpath = "//div[@id='ThirdPartyConnectionPopUp']")
	private WebElementFacade dialogThirdPartyConEdit;
	
	@FindBy(xpath = "//div[@id='ThirdPartyConnectionPopUp']//a[text()='Cancel']")
	private WebElementFacade EditPopCancelBtnThirdPartyCon;
	
	
	public void verifyThirdPartyConTblEdit()
	{
		clickonEditBtnThirdPartyConTbl();
		CommonMethod.isDisplayedMethod(dialogThirdPartyConEdit);
		clickOn(EditPopCancelBtnThirdPartyCon);
		
	}
	
	public void clickonEditBtnThirdPartyConTbl()
	{
		
		if(ThirdPartyConTblrow.size()>0)
		{
			clickOn(firstRowEditBtnThirdPartyCon);
			
		}
		else
		{
			Assert.assertTrue("No row found in ThirdPartyCon Table to click on alter", ThirdPartyConTblrow.size()>0);
		}
		
	}
	
	public void verifyThirdPartyConPage()
	{
		
		CommonMethod.isDisplayedMethod(ThirdPartyConnectionPageHeader);
		com.highLightSteps(ThirdPartyConnectionPageHeader);
	}
	
	public void clickOnThirdPartyConAddRecord()
	{
		clickOn(addRecordThirdPatyConBtn);
	}
	
	public void verifyAddRecordThirdPartyConPopUp()
	{
		clickOnThirdPartyConAddRecord();
		CommonMethod.isDisplayedMethod(addRecordThirdPatyConPopUp);
		clickOn(addRecordPopCancelBtnThirdPatyCon);
	}

}
