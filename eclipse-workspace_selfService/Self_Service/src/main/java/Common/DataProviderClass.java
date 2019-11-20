package Common;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	  
	  @DataProvider (name="selfservice_EmailPage")
		public static Object[][] getemail() throws Exception 
		{
		Object getemailobj[][] = ReadExcelData.getTestData("C:\\Users\\Pankaj_Kalra\\eclipse-workspace_selfService\\Self_Service\\src\\main\\java\\ExcelFiles\\SelfService_ProspectInfo.xlsx", "Login");	
		return getemailobj;
		}
	
	  @DataProvider (name="selfservice_ProspectPage")
			public static Object[][] getProspect() throws Exception 
			{
			Object getemailobj[][] = ReadExcelData.getTestData("C:\\Users\\Pankaj_Kalra\\eclipse-workspace_selfService\\Self_Service\\src\\main\\java\\ExcelFiles\\SelfService_ProspectInfo.xlsx", "Prospect");	
			return getemailobj;
			}
	  
	  @DataProvider (name="selfservice_ApplicantPage")
		public static Object[][] getApplicant() throws Exception 
		{
		Object getemailobj[][] = ReadExcelData.getTestData("C:\\Users\\Pankaj_Kalra\\eclipse-workspace_selfService\\Self_Service\\src\\main\\java\\ExcelFiles\\SelfService_ProspectInfo.xlsx", "Applicant");	
		return getemailobj;
		}
	  
	  @DataProvider (name="Adm_LoginPage")
		public static Object[][] getLoginCredentials() throws Exception 
		{
		Object getemailobj[][] = ReadExcelData.getTestData("C:\\Users\\Pankaj_Kalra\\eclipse-workspace_selfService\\Self_Service\\src\\main\\java\\ExcelFiles\\Administration_Data.xlsx", "LoginCred");	
		return getemailobj;
		}
		
}
