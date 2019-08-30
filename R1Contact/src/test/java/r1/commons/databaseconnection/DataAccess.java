package r1.commons.databaseconnection;

import java.io.IOException;
import java.sql.SQLException;
import r1.commons.BasePage;
import r1.commons.utilities.CommonMethods;

public class DataAccess extends BasePage {
	public static String getEncounterId(String column, String Query)
			throws IOException, ClassNotFoundException, SQLException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"),
				CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName, DatabaseConn.databaseName, Query);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}

	public static String getColumValue(String column, String Query, String facility2)
			throws IOException, ClassNotFoundException, SQLException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), facility2);
		DatabaseConn.serverConn(DatabaseConn.serverName, DatabaseConn.databaseName, Query);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	public static String getColumValue(String column, String Query)
			throws IOException, ClassNotFoundException, SQLException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"),CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName, DatabaseConn.databaseName, Query);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
}