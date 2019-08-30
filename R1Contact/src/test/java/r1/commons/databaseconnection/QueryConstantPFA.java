package r1.commons.databaseconnection;

import r1.commons.BasePage;

public class QueryConstantPFA extends BasePage{

	public String PFA_419028_SQL10()
	{
		return "select top 1 EncounterID from registrations where sex='M'";
	}

	public String PFA_419029_SQL11()
	{
		return "select top 1 v.encounterid,r.sex, (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) as age from vwRegistrationProcessUnscreened v inner join registrations r on  v.encounterid=r.encounterid" + 
				"where r.sex='F' and (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) >'54'";

	}

	public String PFA_419030_SQL12()
	{
		return "select v.encounterid,r.sex, (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) as age from vwRegistrationProcessUnscreened v inner join registrations r on  v.encounterid=r.encounterid" + 
				"where r.sex='F' and (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) <'54'";
	}

	public static String queryPayorCode = "select * from payorplans where payorplanname like '%commercial%'";

	public static String queryEncounterdID = "select top 1 s.state,r.encounterid from vwRegistrationProcessUnscreened r  inner join accretive..state s on R.state=s.statecode";

	public static String queryAgeLessThanEighteenEncounterID = "SELECT TOP 1 r.ID, EncounterID FROM Registrations r (nolock) Left join recordcheckout rco (nolock) on rco.RecordKey = r.ID Where rco.ID is NULL and r.DOB IS NOT NULL and (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) < 18 ORDER BY 1 desc";

	public static String queryAgeGreaterThanEighteenEncounterID ="SELECT TOP 1 r.ID, EncounterID FROM Registrations r (nolock) Left join recordcheckout rco (nolock) on rco.RecordKey = r.ID Where rco.ID is NULL and r.DOB IS NOT NULL and (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) >= 18 ORDER BY 1 desc"; 



}
