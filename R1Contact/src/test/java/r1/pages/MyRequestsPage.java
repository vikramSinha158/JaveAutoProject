package r1.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.utilities.CommonMethod;

public class MyRequestsPage extends BasePage {

	CommonMethod com;
	
	@FindBy(xpath = "//table[@cellspacing='0']//thead//tr//th/a")
	private List<WebElementFacade> myRequestTblheaderName;
	
	
	
	public void verifyHeaderOrder()
	{
		
		List<String> headerList=new ArrayList<String>();
		
	   for(int i=0;i<myRequestTblheaderName.size();i++) {
		   String x= myRequestTblheaderName.get(i).getText();
		   if(!(myRequestTblheaderName.get(i).getText().equals(" ")))
		   {
			   headerList.add(myRequestTblheaderName.get(i).getText());
		   }
	   }
	   
	   List<String> guiHeaderList=com.dataAfterPipeSeperation("myQueueHeader");
	   Assert.assertTrue("expected valuse does not match with actaul value", headerList.equals(guiHeaderList));
		
		
	}
}
