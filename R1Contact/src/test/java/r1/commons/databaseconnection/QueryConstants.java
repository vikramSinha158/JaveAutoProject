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
	
	public static String neccessityRegistrationID = "Select top 1 * from NecessityServices where NecessityStatusID in (2,3)";
	public static String getNeccessityEncounterID(String registrationID) {
		return "select * from registrations where id='"+registrationID+"'";
	}
	
	public static String queryUserDisplayName(String userID) {
		return "select * from dnn..users where username = '"+userID+"'";
	}
	
	public static String queryNecessityEncounterID() {
		return "SELECT TaskStatus_MN Status,* FROM vwPreRegistrationProcess R Where (AdmitDate > CONVERT(DATETIME, getdate())) AND PlanType = 'MEDICARE' AND PatientType IN ('O','S') AND ID in (Select RecordKey From RecordTaskStatus WHERE TaskId = 867 AND Status IN (-1,2,3))";
	}

}
