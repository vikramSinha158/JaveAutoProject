package r1.commons;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class R1ContactCommonMethods extends BasePage {

	public ArrayList colValues;
	public ArrayList columnValue;
	
	
	
	
	
/*................................... Get TABLE COLUMN VALUE  .........................................*/

	
    @SuppressWarnings("deprecation")
	public void getTableColValue(String rowLocator, String colLocator, String accountName) 
	{
    	boolean flag=false;
		colValues = new ArrayList();
		int rowSize = findAll(By.xpath(rowLocator)).size();
		int colSize = findAll(By.xpath(colLocator)).size();
		for (int i = 1; i <= rowSize; i++)
		{
			String rowlocator1 = rowLocator + "[" + i + "]" ;
			
			for(int j=1;j<colSize;j++)
			{
				String colLocator1=rowlocator1+"/td["+j+"]";
				String accountNumber=element(By.xpath(colLocator1)).getText();
				if(accountNumber.contentEquals(accountName))
				{
						element(rowlocator1+"//a[1]//div").click();
						flag=true;
						break;
					
				}else
					{
						flag=false;
					}

				}
			if(flag)
			{
				break;
			}

	     }
					
		}

}

