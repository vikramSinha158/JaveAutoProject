package r1.pages;
import java.util.List;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;


public class MyPaymentsPage extends BasePage {
	
	CommonMethod comm;
	
	
	@FindBy(xpath = "//table[@id='paymentTable']//thead//tr[@class='ng-table-sort-header']//th/div/span")
	private List<WebElementFacade> myPaymenttblheaderName;
	
	@FindBy(xpath = "//input[@name='DueMonth']")
	private WebElementFacade dueMonth;

	@FindBy(xpath = "//input[@name='DueDay']")
	private WebElementFacade dueDay;
	
	public void veryfyTabInDuedate() {
		comm.verifyTabPressInNextSection(dueMonth, dueDay, "18");
	}

	
	
	

}
