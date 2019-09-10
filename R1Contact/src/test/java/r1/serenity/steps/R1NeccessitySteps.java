package r1.serenity.steps;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import r1.commons.BasePage;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.databaseconnection.QueryConstants;
import r1.commons.utilities.CommonMethods;

public class R1NeccessitySteps{

	@Step
	public String searchEncounterID(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.queryWorklistAccount);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	
	@Step
	public String searchNecessityEncounterID(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.neccessityRegistrationID);
		DatabaseConn.resultSet.next();
		String registrationID =  DatabaseConn.resultSet.getString("RegistrationID");
		
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.getNeccessityEncounterID(registrationID));
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	@Step
	public String getUserDisplayName() throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.serverConn(CommonMethods.LoadProperties("bindServer"),"Accretive", QueryConstants.queryUserDisplayName(CommonMethods.LoadProperties("username")));
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString("FirstName");
	}
	
	@Step
	public ArrayList<String> getNecessityEncounterID(String column) throws IOException, ClassNotFoundException, SQLException{
		ArrayList<String> necessityEncounterID = new ArrayList<String>();
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.queryNecessityEncounterID());
		while(DatabaseConn.resultSet.next()) {
			necessityEncounterID.add(DatabaseConn.resultSet.getString(column));
		}
		return necessityEncounterID;
	}
	
	@Step
	public String getPatientEncounterID(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.queryPatientTypeEncounterID);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
}
