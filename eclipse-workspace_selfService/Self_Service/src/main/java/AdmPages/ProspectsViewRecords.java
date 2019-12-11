package AdmPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProspectsViewRecords {
	
	public WebDriver driver;
	public static Logger log = Logger.getLogger(ProspectsViewRecords.class.getName());
	
	@FindBy(xpath = "//ul[@id='menu-block']/li/a[@title='PROSPECTS']") WebElement prospects;
	@FindBy(xpath = "//ul[@id='menu-block']/li/ul/li/a[@title = 'View Records']") WebElement ProspectViewRecords;
	@FindBy(xpath = "//ol[@class='breadcrumb']/li/span[contains (text(), 'Prospects')]") WebElement breadcrumbProspect;
	@FindBy(xpath = "//div[@class='custBreadCrumb']/div[2]//button[contains(text(),'Add')]") WebElement AddFilterlink;
	@FindBy(xpath = "//div[@class='modal-content']/div/h4[contains(text(), 'Filter')]") WebElement Filterpopup;
	@FindBy(xpath = "//*[@id=\"filterModal\"]/div/div/dashboard-filterv1/div/form/div[1]/div/div[1]/div[1]/div[1]/fieldset/div/label/input") WebElement FilterSelect;
	@FindBy(xpath = "//div[@class='modal-footer']//input") WebElement ApplyFilterbutton;
	@FindBy(xpath = "//span[contains (text(), 'Showing Result(s):')]") WebElement showingresult;
	@FindBy(xpath = "//label[contains (text(), 'Clear All Filters')]") WebElement clearAllFilter;
	@FindBy(xpath = "//div[@class='custBreadCrumb']/div[2]//button[contains(text(),'Customize')]") WebElement customizecolumnlink;
	@FindBy(xpath = "//div/ul/li//label[@class='chkbox']/span") WebElement SelectAll;
	@FindBy(xpath = "//input[@type='submit' and @title='submit']") WebElement CustomizeApplyButton;
	@FindBy(xpath = "//span[@class='tglbtn']") WebElement AdvanceFilterToggle;
	@FindBy(xpath = "//table/thead/tr[2]/td[2]/input[@type='text']") WebElement FirstNameText;
	@FindBy(xpath = "//*[@id=\"showData\"]/tbody/tr[51]/td[2]/span/span[1]") WebElement ClickFirstRecord;
	@FindBy(xpath = "//ol[@class='breadcrumb']/li[contains(text(), 'Edit')]") WebElement EditRecordPage;
	@FindBy(xpath = "//div[@class='userInfo']/h1/span[3]") WebElement GetProspectID;
	@FindBy(xpath = "//div[@class='titleHeadscroll']/div/div[2]/button[2]") WebElement GetCreateApplicationButton;
	@FindBy(xpath = "//ol[@class='breadcrumb']/li/a") WebElement ProspectBackButton;
	
	
	public ProspectsViewRecords(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void verifyProspectViewRecordsPageTitle() throws Exception {
		prospects.click();
		ProspectViewRecords.click();
		Thread.sleep(5000);
		String pageTitle = breadcrumbProspect.getText();
		log.info("Prospect View Records Page title is "+ pageTitle);
		Assert.assertEquals(pageTitle, "Prospects");
		log.info("Prospect View Records Page Title is validated");
	}
	
	public void AddFilterFunctionality() throws Exception {
		AddFilterlink.click();
		Thread.sleep(3000);
		log.info("Add Filter Link is Clicked");
		boolean filterpopupwindow = Filterpopup.isDisplayed();
		if (filterpopupwindow == true)
			log.info("Add Filter pop up is shoiwng up correctly.");
		FilterSelect.click();
		Thread.sleep(3000);
		log.info("First filter is checked");
		ApplyFilterbutton.click();
		Thread.sleep(3000);
		log.info("Filer Apply button is clicked");
		boolean filter = showingresult.isDisplayed();
		if (filter == true)
			log.info("Data is filtered correctly.");
		clearAllFilter.click();
		Thread.sleep(3000);
		log.info("Filters are cleared");
	}
	
	public void CustomizeColumnFunctionality() throws Exception {
		customizecolumnlink.click();
		Thread.sleep(3000);
		log.info("User has clicked on Customize column link.");
		SelectAll.click();
		Thread.sleep(3000);
		log.info("User has selected Select All from the pop up.");
		CustomizeApplyButton.click();
		Thread.sleep(3000);
		log.info("Üser has clicked Apply Filter button.");
	}
	
	public void AdvanceFilterFunctionality() throws Exception {
		AdvanceFilterToggle.click();
		Thread.sleep(3000);
		log.info("User has selected the toggle for Advance Filter.");
		FirstNameText.sendKeys("*a*");
		Thread.sleep(3000);
		log.info("User has entered search criteria in text field.");
		FirstNameText.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		log.info("Enter key is pressed.");
		ClickFirstRecord.click();
		Thread.sleep(11000);
		log.info("First record in the search result is clicked successfully");
			
	}
	
	public void ProspectDetails() throws Exception {
		boolean editprospect = EditRecordPage.isDisplayed();
		if (editprospect == true)
			log.info("Prospect record is showing up correctly.");
		String ProspectID = GetProspectID.getText();
		log.info("Prospect ID for the record is: "+ProspectID);
		Thread.sleep(3000);
		boolean CreateApplicant = GetCreateApplicationButton.isDisplayed();
		if (CreateApplicant == true)
			log.info("Create Application Button is showing up correctly.");
		ProspectBackButton.click();
		Thread.sleep(5000);
		log.info("User has clicked on the Prospect Breadcrumb link for navigate back to Prospect Listing Page. ");
	}
}
