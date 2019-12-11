package AdmPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PeopleSearchClass {

	
	public WebDriver driver;
	public static Logger log = Logger.getLogger(PeopleSearchClass.class.getName());
	
	@FindBy(xpath = "//div[@class='custBreadCrumb']/ol/li[1]") WebElement breadcrumb;
	@FindBy(xpath = "//span[contains(text(), 'People')]")	WebElement peopleSearch;
	@FindBy(xpath = "//input[@id='emailAddress']")	WebElement emailID;
	@FindBy(xpath = "//button[contains(text(), 'Search')]")	WebElement searchButton;
	@FindBy(xpath = "//span[contains(text(), 'Showing Result(s):')]")	WebElement showingResult;
	@FindBy(xpath = "//*[@id=\"showData\"]/tbody/tr[1]/td/table/tbody/tr/td[1]/span/span[1]") WebElement firstRecord;
	@FindBy(xpath = "//td[@class='peopleDetalList']/ul/li[1]/span[1]") WebElement roleClick;
	
	public PeopleSearchClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void verifyPeopleSearchPageTitle() throws Exception {
		peopleSearch.click();
		Thread.sleep(5000);
		String pageTitle = breadcrumb.getText();
		log.info("Page title is "+ pageTitle);
		Assert.assertEquals(pageTitle, "People Search");
		log.info("Page Title is validated");
	}
	 
	public void peopleSearchmethod() throws Exception {
		emailID.sendKeys("tom");
		Thread.sleep(3000);
		searchButton.click();
		Thread.sleep(5000);
		boolean displayed = showingResult.isDisplayed();
		if(displayed == true) {
			log.info("Showing result is showing up");
		}
		firstRecord.click();
		Thread.sleep(3000);
		roleClick.click();
		Thread.sleep(7000);
	}
	
}
