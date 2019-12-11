package AdministrationTC;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AdmPages.DashboardClass;
import AdmPages.LoginClass;
import AdmPages.PeopleSearchClass;
import AdmPages.ProspectsViewRecords;
import Common.BaseClass;
import Common.DataProviderClass;

public class Admin_Flow extends BaseClass {
	
	public static Logger log = Logger.getLogger(Admin_Flow.class);

	@BeforeTest
	public void browserload() throws Exception {
		driver = initilizeBrowser();
		driver.get(prop.getProperty("admurl"));

	}

	@Test(priority = 1, enabled = true, dataProvider = "Adm_LoginPage", dataProviderClass = DataProviderClass.class)
	public void Login_Page_Test(String user_name, String pass_word) throws Exception {

		LoginClass Login_obj = new LoginClass(driver);
		Login_obj.verifyPageTitle();
		Login_obj.func_Login(user_name, pass_word);
	}

	@Test(priority = 2, enabled = true)
	public void Dashboard_Page_Test() throws Exception {
		DashboardClass Dashboard_obj = new DashboardClass(driver);
		Dashboard_obj.verifyPageTitle();
		Dashboard_obj.wighettest();
	}
	
	@Test(priority = 3, enabled = true)
	public void PeopleSearch_Page_Test() throws Exception {
		PeopleSearchClass People_obj = new PeopleSearchClass(driver);
		People_obj.verifyPeopleSearchPageTitle();
		People_obj.peopleSearchmethod();
	}

	@Test(priority = 4, enabled = true)
	public void ProspectViewRecords_Page_Test() throws Exception{
		ProspectsViewRecords ProspectView_obj = new ProspectsViewRecords(driver);
		ProspectView_obj.verifyProspectViewRecordsPageTitle();
		ProspectView_obj.AddFilterFunctionality();
		ProspectView_obj.CustomizeColumnFunctionality();
		ProspectView_obj.AdvanceFilterFunctionality();
		ProspectView_obj.ProspectDetails();
	}
	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

}
