package selfServiceTC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.DataProviderClass;
import SelfService.Pages.ApplicantInfoPage;
import SelfService.Pages.EmailRegisterPage;
import SelfService.Pages.ProspectInfoPage;

public class SelfService_Flow extends BaseClass {

//public WebDriver driver;

	
	  @BeforeTest 
	  public void browserload() throws Exception { 
		  driver =  initilizeBrowser(); 
		  driver.get(prop.getProperty("url"));
	  
	  }
	 
	@Test(priority = 1, enabled = true, dataProvider = "selfservice_EmailPage", dataProviderClass = DataProviderClass.class)
	public void Email_Page_method(String email_id) throws Exception {

		EmailRegisterPage obj = new EmailRegisterPage(driver);
		obj.verifyPageTitle();
		obj.enterEmailId(email_id);
		//prospectTest obj2 = new prospectTest(driver);

	}

	@Test(priority = 2, enabled = true, dataProvider = "selfservice_ProspectPage", dataProviderClass = DataProviderClass.class)
	public void Prospect_Form_method(String Calendartype, String termapplying, String award, String primarymajor,
			String secondarymajor, String firstname, String middlename, String lastname, String suffix,
			String preferedname, String legalname) throws Throwable {
		ProspectInfoPage obj1 = new ProspectInfoPage(driver);
		obj1.clickdrop(Calendartype, termapplying, award, primarymajor, secondarymajor, firstname, middlename, lastname,
				suffix, preferedname, legalname);
	}

	@Test(priority = 3, enabled = true, dataProvider = "selfservice_ApplicantPage", dataProviderClass = DataProviderClass.class)
	public void TApplicant_Form_method(String fullparttime, String admitcode, String campuscode, String resdencycode, String primarysource) throws Exception {
		ApplicantInfoPage obj2 = new ApplicantInfoPage(driver);
		obj2.applicantdata(fullparttime, admitcode, campuscode, resdencycode, primarysource);
	}

	
	
	 @AfterTest 
	 public void closebrowser() 
	 { driver.quit(); }
	 
	  }
	 

