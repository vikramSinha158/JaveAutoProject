package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;


public class MyQueuePage extends BasePage{
	R1ContactCommonMethods r1ComMethod;
	@FindBy(xpath="//input[@name='StatusMonth']")
	private WebElementFacade statusMonth;
	
	@FindBy(xpath="//input[@name='StatusDay']")
	private WebElementFacade statusDay;
	
	@FindBy(xpath="//input[@name='StatusYear']")
	private WebElementFacade statusYear;
	
	@FindBy(xpath="//div[@ng-include='config.getTemplateUrl(filter)']")
	private List<WebElementFacade> myTabFilterBox;
	
	@FindBy(xpath="//tr[@class='ng-scope']")
	private List<WebElementFacade> listOfMyQueue;
	
	@FindBy(xpath="//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th")
	private List<WebElementFacade> homeReminderInfoColPath;
	
	int listOfMyQueueCount;
	int searchEleRow;
	String homeReminderInfoCol ="//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th";
	String listOfQueue ="//tr[@class='ng-scope']";
	
	// Click status month filter
	public void clickStatusMonth() {
		statusMonth.click();
	}
		
	// send in status month filter
	public void sendInStatusMonth(String month) {
		statusMonth.clear();
		statusMonth.sendKeys(month);
	}
	
	//Check records in My Queue
	public void checkQueuePresence() {
		if(listOfMyQueue.size()==0) {
			Assert.assertTrue("There is no queue present in My Queue to do further testing!!", false);
		}
	}
		
	//
	
	public void checkContainInMyQueue(String search, String headerName, String searchElement) throws FileNotFoundException, IOException {
		// If date search is for MM
		if (search.equalsIgnoreCase("MM")) {
			statusMonth.sendKeys(searchElement);
			String validMonth = searchElement.substring(0, 1);
			// If searchElement is out of month range
			if(statusMonth.getAttribute("value").equals(validMonth)) {
				listOfMyQueueCount = listOfMyQueue.size();
				searchEleRow = r1ComMethod.checkElementcontain(listOfQueue, homeReminderInfoCol, headerName,
						validMonth);
				}else {
			listOfMyQueueCount = listOfMyQueue.size();
			searchEleRow = r1ComMethod.checkElementcontain(listOfQueue, homeReminderInfoCol, headerName,
					
					searchElement);
			}
			statusMonth.clear();
			// Else if date search is for DD
		} else if (search.equalsIgnoreCase("DD")) {
			statusDay.sendKeys(searchElement);
			listOfMyQueueCount = listOfMyQueue.size();
			searchEleRow = r1ComMethod.checkElementcontain(listOfQueue, homeReminderInfoCol, headerName,
					searchElement);
			statusDay.clear();
		} /* else if (headerName.equalsIgnoreCase("Time")) {
			txtSearchTime.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchTime.clear();
		} else if (headerName.equalsIgnoreCase("Facility")) {
			txtSearchFacility.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchFacility.clear();
		} else if (headerName.equalsIgnoreCase("Notes")) {
			txtSearchNote.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchNote.clear();
		} else if (headerName.equalsIgnoreCase("Balance")) {
			txtSearchBalance.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchBalance.clear();*
		
		}*/
		Assert.assertEquals("Row for search element not match", listOfMyQueueCount, searchEleRow);
	}
	
	// Verifying outputs with desired outcomes
	public void verifyOutput() {
		
	}

}

