package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

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
		
	//
	
	public void checkContainInMyQueue(String search, String headerName, String searchElement) throws FileNotFoundException, IOException {
		if (search.equalsIgnoreCase(search)) {
			statusMonth.sendKeys(searchElement);
			listOfMyQueueCount = listOfMyQueue.size();
			searchEleRow = r1ComMethod.checkElementcontain(listOfQueue, homeReminderInfoCol, headerName,
					
					searchElement);
			statusMonth.clear();
		} /*else if (headerName.equalsIgnoreCase("Date")) {
			txtSearchDate.sendKeys(searchElement);
			homeRiminderRowCount = checkCountofTablerRow();
			searchEleRow = r1ComMethod.checkElementcontain(homeReminderInfoRow, homeReminderInfoCol, headerName,
					searchElement);
			txtSearchDate.clear();
		} else if (headerName.equalsIgnoreCase("Time")) {
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

}

