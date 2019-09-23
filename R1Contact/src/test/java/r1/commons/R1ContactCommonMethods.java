package r1.commons;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.By;
import r1.commons.utilities.CommonMethods;

public class R1ContactCommonMethods extends BasePage {

	private ArrayList<String> colValues;
	private ArrayList<String> columnValue;
	private int rowSize;
	private int colSize; 
	boolean flag;
	private static int searchEleCount=0;
	private String viewAccountLink ="//a[1]//div";

	/*................................... Get TABLE COLUMN VALUE  .........................................*/

	public void clickOnMatchingColValue(String rowLocator, String colLocator, String accountName) throws FileNotFoundException, IOException 
	{
		int rowSize = findAll(By.xpath(rowLocator)).size();
		int colSize = findAll(By.xpath(colLocator)).size();
		for (int i = 1; i <= rowSize; i++)
		{
			String rowlocator1 = rowLocator + "[" + i + "]" ;
			for(int j=1;j<colSize;j++)
			{
				String colLocator1=rowlocator1+"/td["+j+"]";
				String accountNumber=element(By.xpath(colLocator1)).getText();
				if(accountNumber.contentEquals(CommonMethods.readProperties("AccountNumber")))
				{
					element(rowlocator1+viewAccountLink).click();
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


	/*................................... CheckAlertIsPresent  .........................................*/	

	public boolean checkAlert() {
		try {

			getDriver().switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*................................... Get TABLE COLUMN VALUE  .........................................*/

	public ArrayList<String> getColValue(String rowLocator, String colLocator, String colName) {
		colValues = new ArrayList<String>();
		rowSize = findAll(By.xpath(rowLocator)).size();
		colSize = findAll(By.xpath(colLocator)).size();
		for (int col = 1; col <= colSize; col++) {
			String colLocator1 = colLocator + "[" + col + "]";
			try {
				if (element(By.xpath(colLocator1)).getText().equalsIgnoreCase(colName)) {
					for (int row = 1; row <= rowSize; row++) {
						String rowLocator2 = rowLocator + "[" + row + "]/td[" + col + "]";
						colValues.add(element(By.xpath(rowLocator2)).getText());
					}
					break;
				}
			} catch (NoSuchElementException e) {
				break;
			}
		}
		return colValues;
	} 

	/*---------------------------------------check Filter in homepage---------------------------------------------------------*/

	public int checkElementcontain(String homeReminderInfoRow, String homeReminderInfoCol,String columnHeader,String searchElement)
	{


		ArrayList<String> homeTablecolData =getColValue(homeReminderInfoRow, homeReminderInfoCol, columnHeader);
		try {
			for (int i = 0; i < homeTablecolData.size(); i++) {
				if(homeTablecolData.get(i).contains(searchElement))
				{
					searchEleCount++;
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return searchEleCount;
	}

	/* ................................... SORTING COLUMN descending ...............................................*/


	public void verifyDescSorting(String tableRowXpath, String tableHeaderColXpath, String colName) {
		columnValue = getColValue(tableRowXpath, tableHeaderColXpath, colName);
		boolean flag = true;

		for (int j = 0; j < columnValue.size() - 1; j++) {
			String d1 = (String) columnValue.get(j);
			String d2 = (String) columnValue.get(j + 1);
			int val = d1.compareTo(d2);
			if (val < 0) {
				flag = false;
				Assert.assertTrue("sorting failed", flag);
			}
		}
	}

	/*................................... SORTING COLUMN ascending ...............................................*/

	public void verifySorting(String tableRowXpath, String tableHeaderColXpath, String colName) {
		columnValue = getColValue(tableRowXpath, tableHeaderColXpath, colName);
		boolean flag = true;

		for (int j = 0; j < columnValue.size() - 1; j++) {
			String d1 = (String) columnValue.get(j);
			String d2 = (String) columnValue.get(j + 1);
			int val = d1.compareTo(d2);
			if (val > 0) {
				flag = false;
				Assert.assertTrue("sorting failed", flag);
			}
		}
	}


}





