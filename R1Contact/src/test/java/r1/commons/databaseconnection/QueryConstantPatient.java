package r1.commons.databaseconnection;

import r1.commons.BasePage;

public class QueryConstantPatient extends BasePage {

	public static String queryPatientGurantor() {
		return "Select top 1 encounterid ,SSN ,Admitdate from Registrations where GuarantorID is not null and encounterid is not NULL and SSN is not null and SSN <> '000000200' and SSN <> '000000000' and Phone is not null and ID not in (select RecordKey from RecordCheckOut) order by id desc ";
	}
	public String queryPatientCheckReturn(String encounterID) {
		return " Select top 1 isadmitted,isdischarged, * from registrations where encounterid='" + encounterID + "'";
	}
	public static String queryPatientforZeroAmmount() {
		return " Select Distinct top 2 r.encounterId, SUM(c.totalCharges) FROM registrations r JOIN charges c ON r.id = c.registrationId GROUP BY r.encounterId HAVING SUM(c.totalCharges) = 0";
	}
	public static String queryPatientforNotZeroAmmount() {
		return "SELECT Distinct top 2 r.encounterId, SUM(c.totalCharges) FROM registrations r JOIN charges c ON r.id = c.registrationId GROUP BY r.encounterId HAVING SUM(c.totalCharges) <>0  ";
	}
	public static String queryPatientGetCricitcalError() {
		return "select top 2 encounterId from registrations where address is null";
	}
	public static String queryPatientGetNonricitcalError() {
		return "select top 2 encounterId from registrations where address is null;";
	}
	public static String queryPatientforGreaterZeroAmmount() {
		return "SELECT distinct top 5 r.encounterId, SUM(c.totalCharges) FROM registrations r JOIN charges c ON r.id = c.registrationId GROUP BY r.encounterId HAVING SUM(c.totalCharges) > 0";
	}
	public static String queryFdischargePatient() {
		return "Select top 5 r.encounterID, r.SSN from registrations r inner join persons p on p.id = r.personid left join SkipTraces st on p.ID = st.PersonID where st.TraceDate is NULL and r.SSN is not null and r.SSN <> '000000200' and r.SSN <> '000000000' and r.Phone is not null and r.isdischarged = 1 and r.ID not in (select RecordKey from RecordCheckOut) order by r.id desc";
	}
	public static String queryPatienTabRed() {
		return "select top 1 reg.encounterid from dbo.recordtaskstatus rec join registrations  reg  on rec.RecordKey= reg.id where rec.taskid = 11 and  rec.status=2";
	}
	public static String queryPatienTabBlue() {
		return "select top 1 reg.encounterid from dbo.recordtaskstatus rec join registrations  reg  on rec.RecordKey= reg.id where rec.taskid = 11 and  rec.status=1";
	}
	public static String queryForPatientSkipGurantor() {
		return "select top 1 reg.encounterid from dbo.recordtaskstatus rec join registrations  reg  on rec.RecordKey= reg.id where rec.taskid = 11 and  rec.status=1";
	}
	public static String queryForPatientSkipTraceNotDischarge() {
		return "select distinct top 5 r.EncounterID from SkipTraces st Inner Join Persons p on p.ID = st.PersonID Inner Join Registrations r on r.PersonID = p.ID inner join recordtaskexceptions rte on r.id = rte.RecordKey where datediff (dd, st.TraceDate, GetDate()) < = (select settingvalue from facilitysettings where SettingName = 'FRONT_SKIPTRACE_RERUN_DAYS') and r.PatientType is not null and p.SSN = st.SSN and r.isdischarged = 0 and rte.RecordExceptionStatusID = 1 and rte.taskexceptionID = 2 ";
	}
	public static String queryForPatientSkipTraceWithReturnDays() {
		return "select distinct top 5 r.EncounterID from SkipTraces st Inner Join Persons p on p.ID = st.PersonID Inner Join Registrations r on r.PersonID = p.ID inner join recordtaskexceptions rte on r.id = rte.RecordKey where datediff (dd, st.TraceDate, GetDate()) > = (select settingvalue from facilitysettings where SettingName = 'FRONT_SKIPTRACE_RERUN_DAYS') and r.PatientType is not null and p.SSN = st.SSN and rte.taskexceptionID = 2 and rte.RecordExceptionStatusID = 1   ";
	}
	public static String queryForPatientForBADAddress() {
		return "select encounterid from registrations where id in (select registrationid from coverages where facilityplancode = 'I08') and Address = 'BAD ADDRESS' ";
	}
	public static String queryForExceptionID() {
		return "with getdata as ( \r\n" + "select status, taskid, recordkey, max(updateddatetime) as maxtime \r\n"
				+ "from dbo.recordtaskstatus \r\n" + "where taskid = 11 \r\n"
				+ "group by status, taskid, recordkey \r\n" + ") \r\n" + ", \r\n" + "getcount as ( \r\n"
				+ "select rte.recordkey, sum(rte.RecordExceptionStatusID) as total \r\n"
				+ "from dbo.recordtaskexceptions rte \r\n"
				+ "join accretive.dbo.taskexceptions te on rte.taskexceptionid = te.id \r\n"
				+ "where te.taskid = 11 \r\n" + "group by rte.recordkey \r\n"
				+ "having sum(rte.recordexceptionstatusid) =0 \r\n" + ") \r\n"
				+ "select r.encounterid, maxtime, g.status \r\n" + "from getdata g \r\n"
				+ "join getcount c on g.recordkey = c.recordkey \r\n"
				+ "join registrations r on g.recordkey = r.id \r\n" + "where g.status = -1 \r\n"
				+ "order by g.maxtime desc";
	}
}
