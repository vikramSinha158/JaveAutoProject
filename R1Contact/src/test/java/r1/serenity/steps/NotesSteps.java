package r1.serenity.steps;

import java.io.IOException;
import java.sql.SQLException;
import net.thucydides.core.annotations.Step;
import r1.commons.BasePage;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.databaseconnection.QueryConstants;
import r1.commons.utilities.CommonMethods;

public class NotesSteps {
	
	@Step
	public static String verifyNewCreatedScope(String encounterid, String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstants.queryNote(encounterid));
		DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}

}
