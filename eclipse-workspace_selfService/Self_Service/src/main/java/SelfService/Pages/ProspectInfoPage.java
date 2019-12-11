package SelfService.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProspectInfoPage {
	
public WebDriver driver;
	
	@FindBy (xpath = "//div[@id='calendarTYpe']/div/span") WebElement CalendarType;
	@FindBy (xpath = "//div[@id='calendarTYpe']/input[@type='search']") WebElement CTsearchfield;
	@FindBy (xpath = "//div[@id='calendarTYpe']/ul/li/div/span/span") WebElement value;
	@FindBy (xpath = "//div[@id='calendarTerm']/div/span") WebElement CalendarTerm;
	@FindBy (xpath = "//div[@id='calendarTerm']/input[@type='search']") WebElement TermSearch;
	@FindBy (xpath = "//div[@id='academicsDegree']/div/span") WebElement Award;
	@FindBy (xpath = "//div[@id='academicsDegree']/input[@type='search']") WebElement AwardSearch;
	@FindBy (xpath = "//div[@id='academicsPrimaryMajor']/div/span") WebElement PrimaryMajor;
	@FindBy (xpath = "//div[@id='academicsPrimaryMajor']/input[@type='search']") WebElement PrimaryMajorSearch;
	@FindBy (xpath = "//div[@id='academicssecondaryMajor']/div/span") WebElement Secondarymajor;
	@FindBy (xpath = "//div[@id='academicssecondaryMajor']/input[@type='search']") WebElement SecondaryMajorSearch;
	@FindBy (xpath = "//input[@id='firstName']") WebElement FirstName;
	@FindBy (xpath = "//input[@id='middleName']") WebElement MiddleName;
	@FindBy (xpath = "//input[@id='lastName']") WebElement LastName;
	@FindBy (xpath = "//input[@id='personSuffix']") WebElement Suffix;
	@FindBy (xpath = "//input[@id='preferredName']") WebElement PreferredName;
	@FindBy (xpath = "//input[@id='legalName']") WebElement LegalName;
	@FindBy (xpath = "//input[@id='contactNumber']") WebElement Contactnumber;
	@FindBy (xpath = "//input[@id='Extension']") WebElement Extension;
	@FindBy (xpath = "//input[@id='zipTextBox']") WebElement ZipCode;
	@FindBy (xpath = "//div[@id='fullAddressSectaion']/div/div/input") WebElement AddressLine;
	@FindBy (xpath = "//button[@type='submit']") WebElement SaveButton;
	@FindBy (xpath = "//div[@id='SubmitConfirmationModal']//div[@class = 'modal-footer']/button[2]") WebElement continuebutton;
	
	/*
	 * public ProspectInfoPage() { }
	 */
	public ProspectInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		//System.out.println("driver is "+driver);
	}
	
	public void verifyPageTitle1() {
		String pagetitle1 = driver.getTitle();
		Assert.assertEquals(pagetitle1, "Oklahoma Wesleyan University");
	}
	
	public ApplicantInfoPage clickdrop(String CalType, String Term, String Awardname, String PMajor, String SMajor, String FName, String MName, String LName, String Suff, String PreName, String LegName) throws InterruptedException {
		CalendarType.click();
		Thread.sleep(2000);
		CTsearchfield.sendKeys(CalType);
		CTsearchfield.sendKeys(Keys.ENTER);
		
		CalendarTerm.click();
		Thread.sleep(2000);
		TermSearch.sendKeys(Term);
		TermSearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		Award.click();
		Thread.sleep(2000);
		AwardSearch.sendKeys(Awardname);
		AwardSearch.sendKeys(Keys.ENTER);
		
		PrimaryMajor.click();
		Thread.sleep(2000);
		PrimaryMajorSearch.sendKeys(PMajor);
		PrimaryMajorSearch.sendKeys(Keys.ENTER);
		
		Secondarymajor.click();
		Thread.sleep(2000);
		SecondaryMajorSearch.sendKeys(SMajor);
		SecondaryMajorSearch.sendKeys(Keys.ENTER);
		
		FirstName.sendKeys(FName);
		Thread.sleep(2000);
		MiddleName.sendKeys(MName);
		Thread.sleep(2000);
		LastName.sendKeys(LName);
		Thread.sleep(2000);
		Suffix.sendKeys(Suff);
		Thread.sleep(2000);
		PreferredName.sendKeys(PreName);
		Thread.sleep(2000);
		LegalName.sendKeys(LegName);
		Thread.sleep(2000);
		
		/*
		 * Contactnumber.sendKeys(phone); Thread.sleep(2000); Extension.sendKeys(extn);
		 * Thread.sleep(2000); ZipCode.sendKeys(zip); Thread.sleep(2000);
		 * AddressLine.sendKeys(Address); Thread.sleep(2000); Thread.sleep(2000);
		 */
		SaveButton.click();
		Thread.sleep(2000);
		continuebutton.click();
		Thread.sleep(10000);
		//System.out.println("Continue button pressed");
		return new ApplicantInfoPage(driver);
		
	}
	
	/*
	 * public void dropdown(String xpathdrop) throws Throwable {
	 * 
	 * List<WebElement> dditems = driver.findElements(By.xpath(xpathdrop));
	 * 
	 * for (int i=0;i<dditems.size();i++) { WebElement element = dditems.get(i);
	 * //System.out.println("Element is: "+element);
	 * 
	 * String innertext = element.getAttribute("innerHTML");
	 * System.out.println("Value from drop down is== "+innertext);
	 * 
	 * if (innertext.contentEquals("Do Not Use")) {
	 * System.out.println("Clickible element is "+element); element.click();
	 * Thread.sleep(5000); break; }
	 * 
	 * //System.out.println(innertext); } driver.quit(); }
	 */
	
}
