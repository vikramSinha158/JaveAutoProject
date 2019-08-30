package r1.commons.databaseconnection;

import r1.commons.BasePage;

public class QueryConstantSettlement extends BasePage{

	public String totalChargesPositive()
	{
		return "select top 1 encounterid from registrations where facilitypatientid in (select top 1 facilitypatientid from priorbalance where patientbalance>0)";
	}	
}
