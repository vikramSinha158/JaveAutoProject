package r1.pages;
import java.util.List;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;


public class MyPaymentsPage extends BasePage {
	
	
	
	@FindBy(xpath = "//table[@id='paymentTable']//thead//tr[@class='ng-table-sort-header']//th/div/span")
	private List<WebElementFacade> myPaymenttblheaderName;
	
	

}
