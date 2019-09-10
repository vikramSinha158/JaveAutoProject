package r1.serenity.steps;

import java.io.IOException;
import java.sql.SQLException;

import net.thucydides.core.annotations.Step;
import r1.commons.BasePage;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.databaseconnection.QueryConstants;
import r1.commons.utilities.CommonMethods;

public class ConfigRulesStep extends BasePage{
	
	public static String searchEncounterIDPAS(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.queryConfigRuleEncounterIdPAS());
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	public static String searchEncounterIDPCE(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.queryConfigRuleEncounterIdPCE());
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	public static String searchEncounterIDSAR(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.queryConfigRuleEncounterIdSAR());
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	

}
