package r1.commons;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class R1ContactCommonMethods extends BasePage {

	public ArrayList<String> colValues;
	private int rowSize;
	private int colSize; 
	boolean flag;




	/*................................... Get TABLE COLUMN VALUE  .........................................*/


	@SuppressWarnings("deprecation")
	public void getTableColValue(String rowLocator, String colLocator, String accountName) 
	{
		
		//colValues = new ArrayList();
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
			if(flag==true)
			{
				break;
			}

		}

	}

	/*******************************CheckAlertIsPresent**********************************************/

	public boolean checkAlert() {
		try {

			getDriver().switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*****************************************find columns*******************************************/
	
	public ArrayList<String> getColValue(String rowLocator, String colLocator, String colName) {
    	colValues = new ArrayList<String>();
    	rowSize = findAll(By.xpath(rowLocator)).size();
		colSize = findAll(By.xpath(colLocator)).size();
		for (int col = 1; col <= colSize; col++) {
			String colLocator1 = colLocator + "[" + col + "]";
			if (element(By.xpath(colLocator1)).getText().equalsIgnoreCase(colName)) {
				for (int row = 1; row <= rowSize; row++) {
					String rowLocator2 = rowLocator + "[" + row + "]/td[" + col + "]";
					colValues.add(element(By.xpath(rowLocator2)).getText());
				}
				break;
			}
		}
		return colValues;
	} 

}

