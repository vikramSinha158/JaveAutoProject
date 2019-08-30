package r1.commons.databaseconnection;

import r1.commons.BasePage;

public class QueryConstantCwl extends BasePage {

	public  String getEncounter()
	{
		return "select * from registrations where encounterid='0000758535354' ";
		
	}
	
	
	
}
