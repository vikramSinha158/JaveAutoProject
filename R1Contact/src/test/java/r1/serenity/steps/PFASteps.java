package r1.serenity.steps;

import java.io.IOException;
import java.sql.SQLException;

import r1.commons.BasePage;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.databaseconnection.QueryConstantPFA;
import r1.commons.utilities.CommonMethods;

public class PFASteps extends BasePage {
	
	
	public String getPayorCode(String column) throws ClassNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPFA.queryPayorCode);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	public String getEncounterdIDForResident(String column) throws ClassNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPFA.queryEncounterdID);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
    }
	
	public String getEncounterdIDAgeLessThanEighteen(String column) throws ClassNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPFA.queryAgeLessThanEighteenEncounterID);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
    }
	
	public String getEncounterdIDAgeGreaterThanEighteen(String column) throws ClassNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPFA.queryAgeGreaterThanEighteenEncounterID);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
    }
	
	
	
	
	

}
