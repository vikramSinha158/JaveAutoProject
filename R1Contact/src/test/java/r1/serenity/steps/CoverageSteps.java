package r1.serenity.steps;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import r1.commons.BasePage;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.databaseconnection.QueryConstantCoverage;
import r1.commons.databaseconnection.QueryConstants;
import r1.commons.utilities.CommonMethods;

public class CoverageSteps extends BasePage{
	
	public static ArrayList<String> Encounter_ID=new ArrayList<>();
	public static ArrayList<String> payorPlanNameDB = new ArrayList<>();
	public static ArrayList<String> COBDB = new ArrayList<>();
	public static ArrayList<String> payorGroupCodeDB = new ArrayList<>();
	public static ArrayList<String> FacilityPlanCodeDB = new ArrayList<>();
	public static ArrayList<String> subscriberCodeDB = new ArrayList<>();
	public static ArrayList<String> copayDB = new ArrayList<>();
	public static ArrayList<String> ERDB = new ArrayList<>();
	public static ArrayList<String> deductDB = new ArrayList<>();
	public static ArrayList<String> coinsDB = new ArrayList<>();
	public static ArrayList<String> oopDB = new ArrayList<>();
	public static ArrayList<String> HCPC=new ArrayList<>();

	@Step
	public static void getCoverageColumnValue(String encounterID) throws ClassNotFoundException, SQLException, IOException {
		
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantCoverage.queryCoverageColVal(encounterID));
		boolean empty = false;
		payorPlanNameDB.clear();
		COBDB.clear();
		payorGroupCodeDB.clear();
		FacilityPlanCodeDB.clear();
		subscriberCodeDB.clear();
		copayDB.clear();
		ERDB.clear();
		deductDB.clear();
		coinsDB.clear();
		oopDB.clear();
		while (DatabaseConn.resultSet.next()) {
			empty = true;
			payorPlanNameDB.add(DatabaseConn.resultSet.getString("PayorPlanName"));
			COBDB.add(DatabaseConn.resultSet.getString("COBOrder"));
			payorGroupCodeDB.add(DatabaseConn.resultSet.getString("PayorGroupCode"));
			FacilityPlanCodeDB.add(DatabaseConn.resultSet.getString("FacilityPlanCode"));
			subscriberCodeDB.add(DatabaseConn.resultSet.getString("SubscriberCode"));
			copayDB.add(DatabaseConn.resultSet.getString("Copay"));
			ERDB.add(DatabaseConn.resultSet.getString("ERCopay"));
			deductDB.add(DatabaseConn.resultSet.getString("Deductible"));
			coinsDB.add(DatabaseConn.resultSet.getString("Coinsurance"));
			oopDB.add(DatabaseConn.resultSet.getString("MaxOutOfPocket"));
			}
		}
	
	@Step
	public static void getEditedColumnValue(String encounterID) throws ClassNotFoundException, SQLException, IOException {
		
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantCoverage.queryEditedColVal(encounterID));
		boolean empty = false;
		payorPlanNameDB.clear();
		copayDB.clear();
		ERDB.clear();
		deductDB.clear();
		coinsDB.clear();
		oopDB.clear();
		while (DatabaseConn.resultSet.next()) {
			empty = true;
			payorPlanNameDB.add(DatabaseConn.resultSet.getString("PayorPlanName"));
			copayDB.add(DatabaseConn.resultSet.getString("Copay"));
			ERDB.add(DatabaseConn.resultSet.getString("ERCopay"));
			deductDB.add(DatabaseConn.resultSet.getString("Deductible"));
			coinsDB.add(DatabaseConn.resultSet.getString("Coinsurance"));
			oopDB.add(DatabaseConn.resultSet.getString("MaxOutOfPocket"));
			}
		}
	
	@Step
	public ArrayList<String> getCoverageEncounterID1() throws SQLException, ClassNotFoundException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantCoverage.queryCoverageEncounterID1());
		boolean empty = true;
		Encounter_ID.clear();
		while (DatabaseConn.resultSet.next()) {
		empty = false;
		Encounter_ID.add(DatabaseConn.resultSet.getString("EncounterID"));
		}
		Assert.assertEquals( "There is no records in DataBase",empty, false);
		return Encounter_ID;
		}
	
	@Step
	public ArrayList<String> getCoverageEncounterID2() throws SQLException, ClassNotFoundException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantCoverage.queryCoverageEncounterID2());
		boolean empty = true;
		Encounter_ID.clear();
		while (DatabaseConn.resultSet.next()) {
		empty = false;
		Encounter_ID.add(DatabaseConn.resultSet.getString("EncounterID"));
		}
		Assert.assertEquals( "There is no records in DataBase",empty, false);
		return Encounter_ID;
		}
	
	@Step
	public ArrayList<String> getCoverageEncounterID3() throws SQLException, ClassNotFoundException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantCoverage.queryCoverageEncounterID3(CommonMethods.LoadProperties("facility")));
		boolean empty = true;
		Encounter_ID.clear();
		while (DatabaseConn.resultSet.next()) {
		empty = false;
		Encounter_ID.add(DatabaseConn.resultSet.getString("EncounterID"));
		}
		Assert.assertEquals( "There is no records in DataBase",empty, false);
		return Encounter_ID;
		}
	
	@Step
	public ArrayList<String> getCoverageEncounterID4() throws SQLException, ClassNotFoundException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantCoverage.queryCoverageEncounterID4());
		boolean empty = true;
		Encounter_ID.clear();
		while (DatabaseConn.resultSet.next()) {
		empty = false;
		Encounter_ID.add(DatabaseConn.resultSet.getString("EncounterID"));
		}
		Assert.assertEquals( "There is no records in DataBase",empty, false);
		return Encounter_ID;
		}
	
	@Step
	public ArrayList<String> getCoverageEncounterID5() throws SQLException, ClassNotFoundException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantCoverage.queryCoverageEncounterID5(CommonMethods.LoadProperties("facility")));
		boolean empty = true;
		Encounter_ID.clear();
		while (DatabaseConn.resultSet.next()) {
		empty = false;
		Encounter_ID.add(DatabaseConn.resultSet.getString("EncounterID"));
		}
		Assert.assertEquals( "There is no records in DataBase",empty, false);
		return Encounter_ID;
		}
	
	@Step
	public ArrayList<String> getHcpcCode() throws SQLException, ClassNotFoundException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantCoverage.queryHcpcCode());
		boolean empty = true;
		HCPC.clear();
		while (DatabaseConn.resultSet.next()) {
		empty = false;
		HCPC.add(DatabaseConn.resultSet.getString("hcpc_code_id"));
		}
		Assert.assertEquals( "There is no records in DataBase",empty, false);
		return HCPC;
		}
      
	}
