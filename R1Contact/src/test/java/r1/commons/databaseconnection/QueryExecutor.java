package r1.commons.databaseconnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import r1.commons.utilities.CommonMethod;

public class QueryExecutor {

	public static void runQueryTran(String queryName,String moduleName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethod.LoadProperties("webdriver.base.url"), CommonMethod.LoadProperties("facility"));
		if (moduleName.equalsIgnoreCase(moduleName))
			DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, CommonMethod.queryProperties(queryName,moduleName));
	}

	public static void runQueryTran(String queryName, String facility,String moduleName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethod.LoadProperties("webdriver.base.url"), facility);
		if (moduleName.equalsIgnoreCase(moduleName))
			DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, CommonMethod.queryProperties(queryName,moduleName));
	}
	public static void runQueryTranParam(String queryName, String parameter,String moduleName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethod.LoadProperties("webdriver.base.url"), CommonMethod.LoadProperties("facility"));
		if (moduleName.equalsIgnoreCase(moduleName))
			DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, String.format(CommonMethod.queryProperties(queryName,moduleName), parameter));
	}

	public static void runQueryAccretiveDB(String queryName,String moduleName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		if (moduleName.equalsIgnoreCase(moduleName))
			DatabaseConn.serverConn(CommonMethod.LoadProperties("bindServer"),"accretive", CommonMethod.queryProperties(queryName,moduleName));
	}

}