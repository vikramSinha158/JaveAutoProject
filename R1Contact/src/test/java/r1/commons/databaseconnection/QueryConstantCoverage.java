package r1.commons.databaseconnection;

public class QueryConstantCoverage {
	
	public static String queryCoverageEncounterID1() {
		return "SELECT distinct top 10 EncounterID, coverages.payorname,Coverages.FacilityPlanCode FROM Registrations with (nolock) \r\n" + 
				"inner join coverages on registrations.ID = Coverages.RegistrationID WHERE registrations.ID IN(SELECT registrationid\r\n" + 
				"FROM Coverages inner join  payorplans on payorplans.id = Coverages.PayorPlanId WHERE Coverages.CoverageStatus = 'A' \r\n" + 
				"and VerificationStatus=1 GROUP BY RegistrationID HAVING COUNT(RegistrationID) = 1) and registrations.ID not in \r\n" + 
				"(select RecordKey from RecordCheckOut) and Coverages.PayorName not like '%self%' and Coverages.PayorName not like \r\n" + 
				"'%charity%' and Coverages.PayorName not like '%medi%' and Coverages.PayorName not like '' and Coverages.PayorPlanName\r\n" + 
				"not like '%self%' and Coverages.PayorPlanName not like '%charity%' and Coverages.PayorPlanName not like '%medi%' and \r\n" + 
				"Coverages.PayorPlanName not like ''";
	}
	
	public static String queryCoverageEncounterID2() {
		return "Select top 10 R.EncounterId, R.PatientType, R.FacilityPatientType, R.ServiceFieldCode, \r\n" + 
				"C.FacilityPlanCode from registrations R (NOLOCK) JOIN(select registrationid from coverages\r\n" + 
				"where coveragestatus = 'A' and verificationstatus = 1 and Payorname not like '%Self%'and \r\n" + 
				"Payorname not like '%Charity%' and Payorname not like '%Medi%' and COBOrder > 1 \r\n" + 
				"GROUP by RegistrationId HAVING count(RegistrationID) = 1) COB ON \r\n" + 
				"COB.RegistrationId = R.ID JOIN Coverages C(NOLOCK) on C.RegistrationID = R.ID AND \r\n" + 
				"R.ID not in (select RecordKey from RecordCheckOut) and R.PatientType = 'O' order by R.ID Desc";
	}
	
	public static String queryCoverageEncounterID3(String facility) {
		return "SELECT top 10 EncounterID FROM Registrations r with (nolock) \r\n" + 
				" INNER JOIN Coverages c on r.id = c.RegistrationID and c.CoverageStatus = 'A' \r\n" + 
				" WHERE c.ID NOT IN (SELECT CoverageId FROM Eligibility_HIPAAEligibilityRequests\r\n" + 
				" Where facilityCode = '"+facility+"') and r.ID not in (select RecordKey from RecordCheckOut)";
	}
	
	public static String queryCoverageEncounterID4() {
		return "Select top 10 R.EncounterId, R.PatientType, R.FacilityPatientType, R.ServiceFieldCode, \r\n" + 
				"C.FacilityPlanCode from registrations R JOIN(select registrationid from coverages where coveragestatus = 'A' \r\n" + 
				"and verificationstatus = 1 and Payorname not like '%Self%' and PayorName not like '%medi%' and facilityPlanCode not in ('917') \r\n" + 
				"GROUP by RegistrationId HAVING count(RegistrationID) = 1) COB ON COB.RegistrationId = R.ID \r\n" + 
				"JOIN Coverages C on C.RegistrationID = R.ID AND R.ID not in (select RecordKey from RecordCheckOut)  \r\n" + 
				"order by R.ID Desc";
	}
	
	public static String queryCoverageEncounterID5(String facility) {
		return "select top 10 r.encounterid from Eligibility_HIPAAEligibilityRequests eh \r\n" + 
				" join registrations r on eh.RegistrationId= r.id where eh.resultcode=1 and eh.FacilityCode='"+facility+"'";
	}
	
	public static String queryHcpcCode() {
		return "Select top 10 hcpc_code_id,E.Code,E.EstimatedCharges from reference..hcpc_search h (nolock)\r\n" + 
				" join estimates E (nolock) on h.hcpc_code_id=E.code where h.expirationdate is null";
	}
	
	public static String queryCoverageColVal(String encounterID)
	{
		return "Select P.PayorPlanName,C.COBOrder,C.PayorGroupCode,C.FacilityPlanCode,C.SubscriberCode,C.Copay,C.ERCopay,\r\n" + 
				"C.Deductible,C.Coinsurance,C.MaxOutOfPocket  from coverages C join payorplans P on P.FacilityPlanCode = C.FacilityPlanCode \r\n" + 
				"where coveragestatus = 'A' And RegistrationID in (select id from Registrations where encounterid=  '"+encounterID+"' ) \r\n" + 
				"order by Coborder asc";
	}
	
	public static String queryEditedColVal(String encounterID)
	{
		return "select PayorPlanName,MaxOutOfPocket,Copay,ERCopay,Deductible,Coinsurance from coverages \r\n" + 
				"where RegistrationID in (select id from registrations where encounterid =  '"+encounterID+"' ) \r\n" + 
				"and CoverageStatus = 'A' order by COBOrder asc";
	}

}
