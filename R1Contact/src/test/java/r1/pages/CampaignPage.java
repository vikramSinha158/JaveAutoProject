package r1.pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;
import java.util.List;

public class CampaignPage extends PageObject {
	
	
	R1ContactCommonMethods r1ComMethod;
	CommonMethod com;
	String filterTblRowPath="//div[@id='Boxes']/div";
	String deleteiconPath="/span[@class='fa fa-trash t-grid-delete']";
	
	
	@FindBy(xpath = "//a[text()='Add new record']")
	private WebElementFacade addRecord;
	
	
	@FindBy(xpath = "//div[contains(text(),'Campaign Configs')]")
	private WebElementFacade campaignHeader;
	
	
	@FindBy(xpath = "//div[@id='CampaignConfigPopUp']")
	private WebElementFacade campaignAddrecordPopUp;
	
	
	@FindBy(xpath = "//a[text()='Insert']")
	private WebElementFacade insertBtnInPopUp;
	
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElementFacade cancelBtnInPopUp;
	
	
	
	@FindBy(xpath = "//div[@class='panel dialogLogicFiltertest']//table//tr//th")
	private List<WebElementFacade> dialogLogicFilter;
	
	
	
	@FindBy(xpath = "//div[@id='dialogLogicFilter']")
	private WebElementFacade dialogFilter;
	
	
	
	@FindBy(xpath = "//div[@id='CampaignConfig']//tbody//tr")
	private List<WebElementFacade> campaignTblrow;
	
	
	@FindBy(xpath = "//div[@id='CampaignConfig']//tbody//tr[1]/td[5]/a[text()='Alter']")
	private WebElementFacade firstRowAlterBtn;
	
	
	@FindBy(xpath = "//div[@id='CampaignConfig']//tbody//tr[1]/td[6]/a[contains(text(),'Edit Order')]")
	private WebElementFacade firstRowEditBtn;
	
	
	@FindBy(xpath = "//button[contains(text(),'Add New')]")
	private WebElementFacade addNewBtnOnFilterDialog;
	
	
	@FindBy(xpath = "//input[@id='Save']")
	private WebElementFacade saveBtnOnFilterDialog;
	
	
	@FindBy(xpath = "//div[@id='dialogLogicFilter']//button[@type='button']//span[text()='Cancel']")
	private WebElementFacade cancelBtnOnFilterDialog;
	
	
	@FindBy(xpath = "//div[@id='Boxes']/div")
	private List<WebElementFacade> totalRowFilterTbl;
	
	@FindBy(xpath = "//div[@id='Boxes']/div/span[@class='fa fa-trash t-grid-delete']")
	private List<WebElementFacade> DeleteIconOnFltTblList;
	
	
	@FindBy(xpath = "//div[@id='CampaignConfigPopUp']")
	private WebElementFacade CampaignEditPopUp;
	
	
	@FindBy(xpath = "//label[text()='Name']")
	private WebElementFacade labelName;
	

	@FindBy(xpath = "//div[@class='t-dropdown-wrap t-state-default']")
	private List<WebElementFacade> dropDownOnEditPopUp;
	
	
	@FindBy(xpath = "//a[text()='Update']")
	private WebElementFacade btnUpdate;
	
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElementFacade btnCancel;
	
	
	@FindBy(xpath = "//label[text()='Position']")
	private WebElementFacade labelPosition;
	
	@FindBy(xpath = "//label[text()='Ordering']")
	private WebElementFacade labelOrdering;
	
	public void verifyControlOnEditPopUp()
	{
		verifyDropDownInEditPopUp();
		CommonMethod.isDisplayedMethod(labelName);
		CommonMethod.isDisplayedMethod(labelPosition);
		CommonMethod.isDisplayedMethod(labelOrdering);
		CommonMethod.isDisplayedMethod(btnUpdate);
		CommonMethod.isDisplayedMethod(btnCancel);
		
		
	}
	
	public void verifyComapignEditPopUp()
	{
		CommonMethod.isDisplayedMethod(CampaignEditPopUp);
	}
	
	public void verifyDropDownInEditPopUp()
	{
		if(dropDownOnEditPopUp.size()==2)
		{

                  com.isDisplayListItem(dropDownOnEditPopUp);
		}
		else
		{
			Assert.assertTrue("More than 2 dropDown found", dropDownOnEditPopUp.size()==2);
		}
	}
	
	
	public void clickOnCampaignAddRecord()
	{
		clickOn(addRecord);
	}
	
	public void verifyCampaignPage()
	{
		
		CommonMethod.isDisplayedMethod(campaignHeader);
		com.highLightSteps(campaignHeader);
	}
	
	public void VerifyControlOnAddRecord()
	{
		CommonMethod.isDisplayedMethod(campaignAddrecordPopUp);
		CommonMethod.isDisplayedMethod(insertBtnInPopUp);
		CommonMethod.isDisplayedMethod(cancelBtnInPopUp);
				
	}
	
	
	public void verifyDialogFilterDispaly() 
	{
		
		com.waitForControl("//div[@id='dialogLogicFilter']");
		CommonMethod.isDisplayedMethod(dialogFilter);
	}
	
	public void clickonAlterBtnCampaignTbl()
	{
		
		if(campaignTblrow.size()>0)
		{
			clickOn(firstRowAlterBtn);
			
		}
		else
		{
			Assert.assertTrue("No row found in CampaignTable to click on alter", campaignTblrow.size()>0);
		}
		
	}
	
	public void clickonEditBtnCampaignTbl()
	{
		
		if(campaignTblrow.size()>0)
		{
			clickOn(firstRowEditBtn);
			
		}
		else
		{
			Assert.assertTrue("No row found in CampaignTable to click on alter", campaignTblrow.size()>0);
		}
		
	}
	
	public void verifyFilterHeader()
	{
		com.isDisplayListItem(dialogLogicFilter);
	}
	
	public void VerifyControlsFilterDialog()
	{
	      CommonMethod.isDisplayedMethod(addNewBtnOnFilterDialog);
	      CommonMethod.isDisplayedMethod(saveBtnOnFilterDialog);
	      CommonMethod.isDisplayedMethod(cancelBtnOnFilterDialog);
		
	}
	
	public void verifyNotDisplayDeleteIcon()
	{
		boolean delIconChk=true;
		int loopCnt=totalRowFilterTbl.size()- DeleteIconOnFltTblList.size();
		
		for(int i=1;i<=loopCnt;i++)
		{
			WebElementFacade currentdeleteIcon=element(By.xpath(filterTblRowPath + "[" +i+"]" + deleteiconPath));
			try {
				if(currentdeleteIcon.isDisplayed())
				{
					delIconChk=false;
					Assert.assertTrue("Delete icon found in " + i + " row", delIconChk);
					break;
					
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				Assert.assertTrue("Delete icon found in " + i + "row", delIconChk);
			}
		}
	}
	
	public void verifyDeleteIconOnFilter()
	{
		com.isDisplayListItem(DeleteIconOnFltTblList);
	}
	
	
	
	
	
	
	
	
	
	
}
