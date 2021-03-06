package r1.commons.databaseconnection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DatabaseConn {

	public static ResultSet resultSet;
	public static String serverName;
	public static String databaseName;
	public static Connection conn;

	public static void getServerDBName(String url, String facility) {

		try {

			String query = "SELECT hostName, dbName " + "from facility f (nolock) "
					+ "join db d (nolock) on fcDbId = dbId join host h (nolock) on dbHostId = hostId  "
					+ "where f.flag = 'A'and fcCode = '" + facility + "'";

			/***********************
			 * Staging Care Server
			 ***************************************************/

			if (url.contains("uatccc")) {
				serverConn("UATCONTWCOR01\\CCCCOR", "Stingray", query);
				while (resultSet.next()) {
					serverName = resultSet.getString("hostName");
					databaseName = resultSet.getString("dbName");
				}
			}

			/***********************
			 * Staging IMH Server
			 ***************************************************/

			if (url.contains("stgrcohub")) {
				serverConn("STGRHUBWCORE01", "Accretive", query);
				while (resultSet.next()) {
					serverName = resultSet.getString("servername") + ".EXTAPP.LOCAL";
					databaseName = resultSet.getString("databasename");
				}
			}

			/***********************
			 * UAT Care Server
			 ***************************************************/

			else if (url.contains("uathub")) {
				serverConn("UATRHUBWCORE01", "Accretive", query);
				while (resultSet.next()) {
					serverName = resultSet.getString("servername");
					databaseName = resultSet.getString("databasename");
				}
			}

			/***********************
			 * UAT IMH Server
			 ***************************************************/

			else if (url.contains("uatrcohub")) {
				serverConn("UATRHUBWCORE01", "Accretive", query);
				while (resultSet.next()) {
					serverName = resultSet.getString("servername") + ".EXTAPP.LOCAL";
					databaseName = resultSet.getString("databasename");
				}
			}

			/***********************
			 * DEV Care Server
			 ***************************************************/

			else if (url.contains("dev1ccc")) {
				serverConn("DEVCONTWCOR01", "stingray", query);
				while (resultSet.next()) {
					serverName = resultSet.getString("servername");
					databaseName = resultSet.getString("databasename");
				}
			}

			else if (url.contains("dev1rcohub")) {
				serverConn("DEVRHUBIWBND03 ", "Accretive", query);
				while (resultSet.next()) {
					serverName = resultSet.getString("servername");
					databaseName = resultSet.getString("databasename");
				}
			}

		} catch (Exception e) {

		}
	}

	public static void serverConn(String serverHost, String dbName, String query)
			throws ClassNotFoundException, SQLException {
		String path = System.getProperty("java.library.path");
		path = "src/test/resources/drivers" + ";" + path;
		System.setProperty("java.library.path", path);

		try {
			final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
			sysPathsField.setAccessible(true);
			sysPathsField.set(null, null);

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		try {
			String dbUrl = "jdbc:sqlserver://" + serverHost + ";databaseName=" + dbName + ";integratedSecurity=true";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection conn = DriverManager.getConnection(dbUrl);
			Statement stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query);
	

		} catch (Exception e) {
			
		}
	}
	
	public static void serverConn(String serverHost, String dbName, String query,String username, String password)
			throws ClassNotFoundException, SQLException {
		String path = System.getProperty("java.library.path");
		path = "src/test/resources/drivers" + ";" + path;
		System.setProperty("java.library.path", path);

		try {
			final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
			sysPathsField.setAccessible(true);
			sysPathsField.set(null, null);

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		try {
			String dbUrl = "jdbc:sqlserver://" + serverHost + ";databaseName=" + dbName + ";user = \" + username\r\n" + 
					"					+ \";password = \" + password;// \";integratedSecurity=true";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection conn = DriverManager.getConnection(dbUrl);
			Statement stmt = conn.createStatement();
			resultSet = stmt.executeQuery(query);

		} catch (Exception e) {

		}
	}
}