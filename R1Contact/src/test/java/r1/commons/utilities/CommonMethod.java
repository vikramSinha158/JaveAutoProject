package r1.commons.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import r1.commons.BasePage;

public class CommonMethod extends BasePage {
	public static void DrpVisibleTxt(WebElementFacade we, String s) {
		Select drp = new Select(we);
		drp.selectByVisibleText(s);
	}

	public static String selectRandomList(WebElementFacade element) {
		Select selectDropdown = new Select(element);
		List<WebElement> listOptionDropdown = selectDropdown.getOptions();
		int random = (int) (Math.random() * listOptionDropdown.size() - 1) + 1;
		selectDropdown.selectByIndex(random);
		return selectDropdown.getFirstSelectedOption().getText();
	}

	public static String selectListWithContains(WebElementFacade element, String text) {
		Select selectDropdown = new Select(element);
		List<WebElement> listOptionDropdown = selectDropdown.getOptions();
		for (int i = 0; i < listOptionDropdown.size(); i++) {
			if (listOptionDropdown.get(i).getText().contains(text)) {
				selectDropdown.selectByIndex(i);
			}
		}
		return selectDropdown.getFirstSelectedOption().getText();
	}

	public void selectListWithElement(String element, String text) throws InterruptedException {

		WebElementFacade dropdownEle = element(By.id(element));
		dropdownEle.click();

		Select selectDropdown = new Select(dropdownEle);
		List<WebElement> listOptionDropdown = selectDropdown.getOptions();
		for (int i = 0; i < listOptionDropdown.size(); i++) {
			if (listOptionDropdown.get(i).getText().equalsIgnoreCase(text)) {

				selectDropdown.selectByVisibleText(text);

				break;
			}

		}
	}

	public static int dropDownSize(WebElementFacade list) {
		Select drpList = new Select(list);
		return drpList.getOptions().size();
	}

	public static List<WebElement> dropDownValues(WebElementFacade list) {
		Select drpList = new Select(list);
		return drpList.getOptions();
	}

	public static void DrpVal(WebElementFacade we, String s) {
		Select drp = new Select(we);
		drp.selectByValue(s);
	}

	public static void DrpIndex(WebElementFacade we, int i) {
		Select drp = new Select(we);
		drp.selectByIndex(i);
	}

	public class common extends BasePage {
		PageObject page;

		// Click on Ok or accept on Alter message box
		public void HandleAlertsAccept() {
			page.getAlert().accept();
		}

		// Click on Cancel or dismiss on Alert message box
		public void HandleAlertDismiss() {
			page.getAlert().dismiss();
		}

		// Count the number of windows open on the application, switch to those windows
		// and get title of it.
		public void HandleMultipleWindows() {
			String mainWindow = getDriver().getWindowHandle();
			Set<String> handles = getDriver().getWindowHandles();
			for (String windowHandles : handles)
				if (!mainWindow.equals(windowHandles)) {
					getDriver().switchTo().window(windowHandles);

				}
		}

		public void switchWindow() {
			for (String windowHandles : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(windowHandles);
			}
		}

		public void closeWindow() {
			getDriver().close();
		}

		public String getWindowTitle() {
			return getDriver().getTitle();
		}

		public void DefaultWindow() {
			getDriver().switchTo().defaultContent();
		}

		// Switch to frame using frame name
		public void FrameSwitchUsingName(WebElementFacade frameName) {
			try {
				getDriver().switchTo().frame(frameName);

			} catch (NoSuchFrameException e) {

			}
		}

		// Switch to frame using frameID
		public void FrameUsingId(int frameId) {
			try {
				getDriver().switchTo().frame(frameId);
			} catch (NoSuchFrameException e) {

			}
		}

		// Count the number of frames present on the page
		public int GetTotalFrameCountInCurrentPage() {
			int ret = 0;
			By byFrameTag = (By) By.tagName("frame");
			List<WebElement> frameList = getDriver().findElements(byFrameTag);
			int frameSize = frameList.size();

			By byIFrameTag = (By) By.tagName("iframe");
			List<WebElement> iframeList = getDriver().findElements(byIFrameTag);
			int iframeSize = iframeList.size();

			ret = frameSize + iframeSize;
			return ret;
		}

		public int getElementsSize(String xpath) {
			return getDriver().findElements(By.xpath(xpath)).size();
		}
	}

	/**
	 *
	 * @Author AmeyaS - Read parameters from serenity.properties file
	 *
	 *
	 */
	public static String LoadProperties(String input) throws IOException {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		return variables.getProperty(input);
	}

	/*
	 * Read property file
	 */ public static String readProperties(String input) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/test/resources/TestData/Config.properties"));
		} catch (IOException e) {
		e.printStackTrace();
		}
		return prop.getProperty(input);
	}

	public static int GetRandom(int all) {
		Random rnd = new Random();
		return rnd.nextInt(all);
	}

	public static void isDisplayedMethod(WebElement element) {
		Assert.assertTrue("Value not found,actaul name is  " + element.getText(), element.isDisplayed());

	}

	public static String queryProperties(String input, String moduleName) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		String path = "src/test/resources/TestData/" + moduleName + ".properties";
		prop.load(new FileInputStream(path));
		return prop.getProperty(input);
	}

	/*
	 * Highlights the control
	 */
	public void highLightSteps(WebElementFacade element) {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

	}

	/*
	 * Bootstrap dropDownHandling
	 */
	public List<String> handleBootStrapDropdown(String options, String element) {
		List<String> optionsList = new ArrayList<String>();
		element(By.xpath(element)).click();
		List<WebElementFacade> list = findAll(By.xpath(options));
		for (int i = 0; i < list.size(); i++) {
			optionsList.add(list.get(i).getText());

		}

		return optionsList;

	}

	/*
	 * Bootstrap innerdropDownHandling
	 */
	public List<String> handleInnerBootStrapDropdown(String options, String element, String clickMenuName,
			String innerOptions) throws InterruptedException {
		List<String> optionsList = new ArrayList<String>();
		element(By.xpath(element)).click();
		List<WebElementFacade> list = findAll(By.xpath(options));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equalsIgnoreCase(clickMenuName)) {
				list.get(i).click();
				Thread.sleep(1000);
				List<WebElementFacade> innerlist = findAll(By.xpath(innerOptions));
				for (int j = 0; j < innerlist.size(); j++) {
					optionsList.add(innerlist.get(j).getText());
				}

			}

		}

		return optionsList;

	}

	/*
	 * Highlights the control
	 */
	public void scrollInView(WebElementFacade element) {
		JavascriptExecutor je = (JavascriptExecutor) getDriver();
		je.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	/* Random number */
	public static int random(int num) {
		int randomNumber = 0;
		Random objGenerator = new Random();
		for (int iCount = 0; iCount < 10; iCount++) {
			randomNumber = objGenerator.nextInt(num) + 1;

		}
		return randomNumber;
	}

	public void verifyElement(WebElementFacade element) {
		Assert.assertTrue("Element is not displayed!", element.isDisplayed());
	}

	public void verifyCheckBox(WebElementFacade element) {
		Assert.assertTrue("CheckBox is not selected!", element.isSelected());
	}

	/*
	 * Extracting text from pdf and read it
	 */
	public void readPdf(String pdfpath) throws InvalidPasswordException, IOException {
		// load existing pdf document
		File file = new File(pdfpath);
		PDDocument doc = PDDocument.load(file);
		// Instantiating PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.getText(doc);

	}

	/* check the display of list of element */
	public void isDisplayListItem(List<WebElementFacade> elements) {
		boolean itemDispay = false;

		for (int i = 0; i < elements.size(); i++) {

			if (elements.get(i).isDisplayed()) {
				itemDispay = true;
			} else {
				itemDispay = false;
				Assert.assertTrue(elements.get(i).getText() + " not displayed", itemDispay);
			}
		}
	}

	/* Method to click element from list of item */
	public void clickListTabs(List<WebElementFacade> elementList, String elementTobeName) {

		boolean tabcheck = false;

		for (int i = 0; i < elementList.size(); i++) {

			if (elementList.get(i).getText().toUpperCase().contains(elementTobeName.trim().toUpperCase())) {

				clickOn(elementList.get(i));
				tabcheck = true;
				break;
			}
		}

		Assert.assertTrue(elementTobeName + " Element Not found ", tabcheck);

	}

	/* Method to wait control */
	public void waitForControl(String waitElement) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitElement)));
	}

	/* Method to wait control */
	public void waitToClickable(String waitElement) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(waitElement)));
	}

	/* Method to dismiss alert */
	public void dimissAlert() {
		boolean alerFlag = false;
		Alert alt = null;
		try {

			alt = getDriver().switchTo().alert();
			alerFlag = true;
		} catch (Exception e) {
			alerFlag = false;
			Assert.assertTrue("No alert found after click ", alerFlag);
		}
		if (alerFlag == true) {
			Assert.assertTrue(alerFlag);
			alt.dismiss();
		}
	}

	/* Method to check all letters are in caps or not in string */
	public boolean isUpperCaseCheck(String s) {
		String str = s.replaceAll("\\s", "");
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isUpperCase(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/* Divide two nummber */
	public double divideTwoNumber(int firstNum, int secondNum) {
		double result = (double) firstNum / secondNum;
		double roundoffresult = Math.round(result * 100.0) / 100.0;
		return roundoffresult;
	}

	// next month date
	public String nextMonthDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		Date date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String nextMonthDate = formatter.format(date);
		return nextMonthDate;
	}

	
	
	//Splite the string on th ebasis of pipeline
	public List<String> dataAfterPipeSeperation(String input){
		List<String> headerList=new ArrayList<String>();

		String headerData= CommonMethod.readProperties(input);
		String[] headerText = headerData.split("\\|");
		for (String txt : headerText) {
			headerList.add(txt);
		}
		 
		 return headerList;
	}
	
	// press tab
	public void pressTab(WebElementFacade textbox)
	{
		textbox.sendKeys("");
		textbox.sendKeys(Keys.TAB);		
	}
	
	//veriFy tab movement in next section
	public boolean verifyTabPressInNextSection(WebElementFacade nextSection)
	{
		if(nextSection.equals(getDriver().switchTo().activeElement())){
			
			highLightSteps(nextSection);
			return true;
		}
		
		return false;
			
	}
}

