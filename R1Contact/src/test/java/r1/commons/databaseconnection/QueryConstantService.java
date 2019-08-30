package r1.commons.databaseconnection;

import r1.commons.BasePage;

public class QueryConstantService extends BasePage {
			
	public static  String fetchSettingValue(String settingName)
	{
	 return "select SettingValue from FacilitySettings where settingName ='" + settingName + "'";
	}
	
	public static  String fetchHCPCCodeValue()
	{
	 return "SELECT top 1 hcpc_code_id FROM REFERENCE_HCPC_SEARCH WHERE EXPIRATIONDATE < GETDATE()";
	}
	
	
}
