package r1.commons;

import java.io.IOException;
import java.sql.SQLException;

import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.utilities.CommonMethods;

public class DataAccess {

	public static String getEncounterId(String column,String Query) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, Query);
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}


}