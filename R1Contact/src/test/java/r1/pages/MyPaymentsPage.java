package r1.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.utilities.CommonMethod;

public class MyPaymentsPage extends BasePage {

	CommonMethod comm;
	R1ContactCommonMethods r1ComMethod;

	@FindBy(xpath = "//table[@id='paymentTable']//thead//tr[@class='ng-table-sort-header']//th/div/span")
	private List<WebElementFacade> myPaymenttblheaderName;

	@FindBy(xpath = "//input[@name='DueMonth']")
	private WebElementFacade dueMonth;

	@FindBy(xpath = "//input[@name='DueDay']")
	private WebElementFacade dueDay;

	@FindBy(xpath = "//tr[@ng-show='show_filter']/th[@class='filter ']")
	private List<WebElementFacade> myPaymentFilter;

	@FindBy(xpath = "//button[@class='btn btn-payments']")
	private WebElementFacade myPaymentTab;

	@FindBy(xpath = "//input[@name='EntryMonth']")
	private WebElementFacade entryMonth;

	@FindBy(xpath = "//input[@name='EntryDay']")
	private WebElementFacade entryDay;

	@FindBy(xpath = "//input[@name='EntryYear']")
	private WebElementFacade entryYear;

	@FindBy(xpath = "//input[@name='DueYear']")
	private WebElementFacade dueYear;

	@FindBy(xpath = "//table[@ng-table='tableParams']//tbody//tr[@ng-repeat='row in $data']")
	private List<WebElementFacade> paymentsRows;

	String filterInput = "//tr[@ng-show='show_filter']/th[@class='filter ']";
	String paymentsRowString = "//table[@ng-table='tableParams']//tbody//tr[@ng-repeat='row in $data']";
	String paymentsFilterHeaders = "//table[@ng-table='tableParams']//thead//tr[@class='ng-table-sort-header']//th";

	public void veryfyTabInDuedate() {
		comm.verifyTabPressInNextSection(dueMonth, dueDay, "18");
	}

	// Filtering my payments filter
	public void myPaymentsFilter() {
		for (int i = 0; i < myPaymentFilter.size(); i++) {
			String filterName = myPaymentFilter.get(i).getAttribute("data-title-text");
			WebElementFacade xpath = element(By.xpath(filterInput + "[" + (i + 1) + "]" + "/div/input"));

			if (filterName.equals("Facility")) {
				String searchElement = CommonMethod.readProperties("PaymentFacility");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Facility", searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Account Number")) {
				String searchElement = CommonMethod.readProperties("PaymentAccountNum");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Account Number",
						searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Group")) {
				String searchElement = CommonMethod.readProperties("PaymentGroup");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Group", searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("SVC LOC")) {
				String searchElement = CommonMethod.readProperties("PaymentSVCLOC");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "SVC LOC", searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Unit")) {
				String searchElement = CommonMethod.readProperties("PaymentEntryDate");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Unit", searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Entry Date")) {
				String searchMon = CommonMethod.readProperties("PaymentEntryMonth");
				entryMonth.sendKeys(searchMon);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Entry Date", searchMon);
				entryMonth.clear();
				String searchDate = CommonMethod.readProperties("PaymentEntryDate");
				entryDay.sendKeys(searchDate);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Entry Date", searchDate);
				entryDay.clear();
				String searchYear = CommonMethod.readProperties("PaymentEntryYear");
				entryYear.sendKeys(searchYear);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Entry Date", searchYear);
				entryYear.clear();
				continue;

			} else if (filterName.equals("Mode Description")) {
				String searchElement = CommonMethod.readProperties("PaymentModeDes");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Mode Description",
						searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Flag Description")) {
				String searchElement = CommonMethod.readProperties("PaymentFlagDes");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Flag Description",
						searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Payment Number")) {
				String searchElement = CommonMethod.readProperties("PaymentNum");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Payment Number",
						searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Due Month")) {
				String searchElement = CommonMethod.readProperties("PaymentDueMonth");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Facility", searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Due Date")) {
				String searchDueMon = CommonMethod.readProperties("PaymentDueMonth");
				dueMonth.sendKeys(searchDueMon);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Due Date", searchDueMon);
				dueMonth.clear();
				String searchDueDate = CommonMethod.readProperties("PaymentDueDate");
				dueDay.sendKeys(searchDueDate);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Due Date", searchDueDate);
				dueDay.clear();
				String searchDueYear = CommonMethod.readProperties("PaymentDueYear");
				dueYear.sendKeys(searchDueYear);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Due Date", searchDueYear);
				dueYear.clear();
				continue;

			} else if (filterName.equals("Due Year")) {
				String searchElement = CommonMethod.readProperties("PaymentDueYear");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Facility", searchElement);
				xpath.clear();
				continue;

			} else if (filterName.equals("Due Amount")) {
				String searchElement = CommonMethod.readProperties("PaymentDueAmount");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Due Amount", searchElement);
				xpath.clear();
				continue;
			} else if (filterName.equals("Reason")) {
				String searchElement = CommonMethod.readProperties("Reason");
				xpath.sendKeys(searchElement);
				r1ComMethod.checkElementcontain(paymentsRowString, paymentsFilterHeaders, "Reason", searchElement);
				xpath.clear();
				continue;
			}
		}

	}

	// click on the my payment tab
	public void clickMyPaymentTab() {
		myPaymentTab.click();

	}

	// Verify payment table header section
	public void verifyPaymentHeaderSection() {
		for (int i = 0; i < myPaymentFilter.size(); i++) {
			Assert.assertTrue("Expected table header is not displayed!", myPaymentFilter.get(i).isDisplayed());
		}
	}

	public void verifyPaymentsRows() {
		Assert.assertTrue("There is no records on my payments page!", paymentsRows.size() > 0);
	}
}