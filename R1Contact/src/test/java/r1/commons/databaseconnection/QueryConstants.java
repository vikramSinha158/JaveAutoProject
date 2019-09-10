package r1.commons.databaseconnection;


public class QueryConstants {


	public static String queryWorklistAccount = "Select Distinct top 1 r.EncounterID from NecessityServices ns JOin Registrations r on r.ID = ns.RegistrationID where Active = 1 AND [NecessityStatusId]<>1";
	
	public static String queryNote(String encounterID) {
	return "select top 1 Note from registrations r join notes n On r.id=n.registrationid and encounterid = '"+encounterID+"'";
	}
	
	public static String queryPatientGurantor()
	{
	return "Select top 1 encounterid ,SSN ,Admitdate from Registrations where GuarantorID is not null and encounterid is not NULL and SSN is not null and SSN <> '000000200' and SSN <> '000000000' and Phone is not null and ID not in (select RecordKey from RecordCheckOut) order by id desc ";
	}
	
	public static String neccessityRegistrationID = "Select top 1 * from NecessityServices where NecessityStatusID in (2,3) order by NEWID()";
	
	public static String getNeccessityEncounterID(String registrationID) {
		return "select * from registrations where id='"+registrationID+"'";
	}
	
	public static String queryUserDisplayName(String userID) {
		return "select * from dnn..users where username = '"+userID+"'";
	}
	
	public static String queryNecessityEncounterID() {
		return "SELECT TaskStatus_MN Status,* FROM vwPreRegistrationProcess R Where (AdmitDate > CONVERT(DATETIME, getdate())) AND PlanType = 'MEDICARE' AND PatientType IN ('O','S') AND ID in (Select RecordKey From RecordTaskStatus WHERE TaskId = 867 AND Status IN (-1,2,3))";
	}
	
	public static String queryPatientTypeEncounterID =  "select top 1 * from registrations where patienttype='o' order by NEWID() ";
	
	public static String queryConfigRuleEncounterIdPAS() {
		return "SELECT top 10 EncounterID FROM Registrations r (nolock) where ID in (SELECT RegistrationID FROM Coverages (nolock) where ID in (SELECT c.ID FROM Coverages c\r\n" + 
				"join BusinessRuleLogs br (nolock) on c.ID=br.RecordID where DataSourceID='64'GROUP BY C.ID)) AND EXISTS (Select 1 from Coverages cov where \r\n" + 
				"cov.RegistrationID=r.ID and cov.VerificationStatus='1' and cov.CoverageStatus='A') AND r.ID not in (select RecordKey from RecordCheckOut) Order by Id Desc";
	}
	
	public static String queryConfigRuleEncounterIdPCE() {
		return "Select top 1 EncounterID From Registrations r (nolock) join coverages c (nolock) on r.id = c.registrationid where c.COBOrder = 1 and " +
				"c.coveragestatus = 'A'and c.id in (Select distinct top 10 RecordID from businessrulelogs bl (nolock) inner join accretive_BusinessRules br (nolock) " +
				"on bl.BusinessRuleID=br.id and BusinessRuleTypeId=5 where datasourceid = '63' and bl.BusinessRuleID in (select BusinessRuleID from accretive_BusinessRuleProperties (nolock) " +
				"where PropertyValue='1' and PropertyName='ExceptionLevel')) AND r.ID not in (select RecordKey from RecordCheckOut)";
	}
	
	public static String queryConfigRuleEncounterIdSAR() {
		return "SELECT distinct Top 10 R.encounterID, R.ID, PatientType FROM " + 
				"(select ID, EncounterID, PatientType from Registrations R (nolock) " + 
				"where IsDischarged=0) R Join services s (nolock) on R.ID <> s.RegistrationID";
	}

}
