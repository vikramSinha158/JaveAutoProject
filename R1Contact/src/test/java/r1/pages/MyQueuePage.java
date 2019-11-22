package r1.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1ContactCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.utilities.CommonMethod;
import java.util.Collections;

public class MyQueuePage extends BasePage {
	
	R1ContactCommonMethods r1ComMethod;
	AccountPage account;
	CommonMethod comm;
	AccountDetailsPage accoundel;
	
	
	String myQuerytblCol="//table[@id='queueTable']//thead//tr[@class='ng-table-sort-header']//th";
	String myQuerytblRow="//table[@id='queueTable']/tbody/tr[@class='ng-scope']";
	String myQueueArrowLink = "//a";
	String accountHeader="Account Number";
	
	
	/* verify   Owned  Accounts*/	
	public void verifyOwnedAccounts() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException
	{
		
		R1ContactCommonMethods.runQuery("MyQueueAccountList");		
		List<String> listOfMyQueueAcc = new ArrayList<String>();
		
		while(DatabaseConn.resultSet.next())
		{
			listOfMyQueueAcc.add(DatabaseConn.resultSet.getString("aqAccountNum"));
		}
		
		List<String> listOfAccFromGui=r1ComMethod.getColValue(myQuerytblRow, myQuerytblCol, accountHeader);
				
		Collections.sort(listOfMyQueueAcc);
		Collections.sort(listOfAccFromGui);
		Assert.assertTrue("Owned account does not match db account  "+ listOfMyQueueAcc.size() + "with the view account on table,GUI account " + listOfAccFromGui.size(), listOfAccFromGui.equals(listOfAccFromGui));
		
	}
	
	/* click On Account on my QueueTbl*/
	public void clickOnAccountonmyQueueTbl(String myQueuetblAcc) throws FileNotFoundException, IOException
	{
		
		r1ComMethod.clickOnMatchingColValue(myQuerytblRow, myQuerytblCol, myQueuetblAcc, myQueueArrowLink);
				
	}
	
	
	/* verify Account Info Page*/
	public void verifyAccountInfoPage(String dbAccount)
	{
		accoundel.verifyAccountInfoSection();
		accoundel.verifyAccountWithDb(dbAccount);
	}
	

}
