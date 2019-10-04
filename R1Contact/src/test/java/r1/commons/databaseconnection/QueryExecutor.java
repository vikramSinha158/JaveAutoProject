package r1.commons.databaseconnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import r1.commons.utilities.CommonMethod;


public class QueryExecutor {
	
	
	public static void runQueryTran(String dbPropertiesFileName,String queryName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethod.LoadProperties("webdriver.base.url"), CommonMethod.LoadProperties("facility"));
			DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, CommonMethod.queryProperties(queryName,dbPropertiesFileName));
	}
	
	public static void runQueryTran(String dbPropertiesFileName,String queryName, String facility) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethod.LoadProperties("webdriver.base.url"), facility);
			DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, CommonMethod.queryProperties(dbPropertiesFileName,queryName));
	}
	
	public static void runQueryTranParam(String dbPropertiesFileName,String queryName, String parameter) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethod.LoadProperties("webdriver.base.url"), CommonMethod.LoadProperties("facility"));
			DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, String.format(CommonMethod.queryProperties(dbPropertiesFileName,queryName), parameter));
	}	
	
	public static void runQueryBindAccretive(String dbPropertiesFileName,String queryName, String parameter) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.serverConn(CommonMethod.LoadProperties("bindServer"),"Accretive", String.format(CommonMethod.queryProperties(dbPropertiesFileName,queryName), parameter));
	}
	
	public static void runQueryBindAccretive(String dbPropertiesFileName,String queryName, String parameter1, String parameter2) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.serverConn(CommonMethod.LoadProperties("bindServer"),"Accretive", String.format(CommonMethod.queryProperties(dbPropertiesFileName,queryName), parameter1,parameter2));
	}
	
}
