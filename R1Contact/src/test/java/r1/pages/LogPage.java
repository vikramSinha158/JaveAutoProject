package r1.pages;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;

public class LogPage extends BasePage {

	R1AccessCommonMethods R1AccessCommonMethodsRef;
	ArrayList<String> columnValue1;
	
	public String actionLogTableRow = "//*[contains(@id,'DataGrid1')]/tbody/tr";
  	public String actionLogTablecol = "//*[contains(@id,'DataGrid1')]/tbody/tr/td";
  	public String actionLogTableHeader = "//*[contains(@id,'DataGrid1')]/tbody/tr[1]/td";
	
	@FindBy(xpath = "//table[contains(@class,'PanelDetail actionLog')]//tr[1]")
	private WebElementFacade actionLogHeader;
	
	@FindBy(xpath = "//a[contains(text(),'Release')]")
	private WebElementFacade release;
	
	@FindBy(xpath = "//table[contains(@class,'PanelDetail actionLog')]//tr[1]//a")
	private List<WebElementFacade> actionLogColName;
	
	@FindBy(xpath = "//table[contains(@class,'PanelDetail actionLog')]//tr//img")
	private WebElementFacade actionLogColHeaderIcon;
	
	@FindBy(xpath = "//table[contains(@id,'rbFilter')]//label[contains(text(),'All')]/preceding-sibling::input")
	private WebElementFacade actionLogAllRadioBtn;
	
	@FindBy(xpath = "//table[contains(@id,'rbFilter')]//label[contains(text(),'Tasks')]/preceding-sibling::input")
	private WebElementFacade actionLogTaskRadioBtn;
	
	@FindBy(xpath = "//table[contains(@id,'rbFilter')]//label[contains(text(),'Actions')]/preceding-sibling::input")
	private WebElementFacade actionLogActionRadioBtn;
	
	@FindBy(xpath = "//input[contains(@id,'txtSearch')]")
	private WebElementFacade serviceSearchTxtBox;
	
	@FindBy(xpath = "//a[contains(@id,'btnSearch')]")
	private WebElementFacade srvcSrchBtn;
	
	@FindBy(xpath = "//a[contains(@id,'SearchResults_btnSelect')]")
	private WebElementFacade srvcSearchedRes;
	
	@FindBy(xpath = "//*[contains(@class,'PanelDetail actionLog')]//tr[contains(@class,'PanelDetail')][1]/td[2]")
	private WebElementFacade lastTaskLog;
	
	@FindBy(xpath = "//*[contains(@class,'PanelDetail actionLog')]//tr[contains(@class,'PanelDetail')][1]/td[4]")
	private WebElementFacade lastStatusLog;
	
	public void passLabel(String label)
	{
		Assert.assertTrue("Action log label not found", actionLogHeader.getText().contains(label));
	}
	
	public void verifyLabel(DataTable dt)
	{
		List<String> list = dt.asList(String.class);
		for(int i = 0; i < list.size(); i++)
		{
			passLabel(list.get(i).toString());
		}
	}
	
	public void verifyColClick(DataTable dt)
	{
		List<String> list = dt.asList(String.class);
		for(int i = 0; i < list.size(); i++)
		{
			passColClick(list.get(i).toString());
		}
	}
	
	public void passColClick(String column)
	{
		for(int i = 0 ; i< actionLogColName.size() ; i++)
		{
		if(actionLogColName.get(i).getText().contains(column))
		{
			withAction().moveToElement(actionLogColName.get(i)).click().build().perform();
			Assert.assertTrue("Triangle icon doesn't appeared on clicking column header", actionLogColHeaderIcon.getAttribute("src").contains("images/sort"));
			sorting(column);
			break;
		}
		}
	}
	
	public void sorting(String colName)
	{
		R1AccessCommonMethodsRef.verifySorting(actionLogTableRow,actionLogTableHeader,colName);
	}
	
	public void clickRelease() 
	{
		if(release.isVisible())
		{
		clickOn(release);
		}
	}

	public void clickActionType(String button) 
	{
		if(button.equalsIgnoreCase("All"))
		{
			clickOn(actionLogAllRadioBtn);
		}
		else if(button.equalsIgnoreCase("Tasks"))
		{
			clickOn(actionLogTaskRadioBtn);
		}
		else if(button.equalsIgnoreCase("Actions"))
		{
			clickOn(actionLogActionRadioBtn);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void verifyActionType(String taskType, String actionType)
	{
		columnValue1 = R1AccessCommonMethodsRef.getTableColValue(actionLogTableRow,actionLogTableHeader,"Type/Disposition");
		boolean flag = true;
		if(columnValue1.size() > 0)
		{
		for(int i = 0 ; i < columnValue1.size(); i++)
		{
		if(!(columnValue1.get(i).equalsIgnoreCase(taskType) || columnValue1.get(i).equalsIgnoreCase(actionType)))
		{
			flag = false;
		}
		}
		}
		Assert.assertTrue("ActionLog type mis matched", flag);
	}
	
	@SuppressWarnings("unchecked")
	public void verifySingleActionType(String Type)
	{
		columnValue1 = R1AccessCommonMethodsRef.getTableColValue(actionLogTableRow,actionLogTableHeader,"Type/Disposition");
		boolean flag = true;
		if(columnValue1.size()>0)
		{
		for(int i = 0 ; i < columnValue1.size(); i++)
		{
		if(!(columnValue1.get(i).equalsIgnoreCase(Type)))
		{
			flag = false;
		}
		}
		}
		Assert.assertTrue("ActionLog type mis matched", flag);
	}
	
	public void searchService()
	{
		typeInto(serviceSearchTxtBox,"skin");
		clickOn(srvcSrchBtn);
	}

	public void clickOnSearchedService()
	{
		clickOn(srvcSearchedRes);
	}
	
	public void verifyActionlog() 
	{
		Assert.assertTrue("last task does not matches with PCP", lastTaskLog.getText().contains("Services"));
		Assert.assertTrue("last status log was not completed", lastStatusLog.getText().contains("Completed"));
	}
}
