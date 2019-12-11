package SelfService.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicantInfoPage {

	public WebDriver driver;

	@FindBy(xpath = "//div[@id='academicsDegreeType']/div/span") WebElement FullParttimedrop;
	@FindBy(xpath = "//div[@id='academicsDegreeType']/input")	WebElement Fullpartsearch;
	@FindBy(xpath = "//div[@id='academicsMinorLabel']/a")	WebElement minorlink;
	@FindBy(xpath = "//div[@id='MultiSelectModal']//button[@ng-class = 'settings.buttonClasses']")	WebElement popupdropdown;
	@FindBy(xpath = "//div[@id= 'MultiSelectModal']//div[@class = 'modal-footer']/button[text()='Add']")	WebElement popupAddbutton;
	@FindBy(xpath = "//div[@id='academicsConcentrationLabel']/a")	WebElement concentrationlink;
	@FindBy(xpath = "//div[@id='MultiSelectModal']//button[@ng-class = 'settings.buttonClasses']")	WebElement concentrationdrop;
	@FindBy(xpath = "//div[@id='admitCode']/div/span") WebElement admitcodedrop;
	@FindBy(xpath = "//div[@id='admitCode']/input")	WebElement admitcodesearch;
	@FindBy(xpath = "//div[@id='campusCode']/div/span") WebElement campusCodedrop;
	@FindBy(xpath = "//div[@id='campusCode']/input")	WebElement campusCodesearch;
	@FindBy(xpath = "//div[@id='residencyCode']/div/span") WebElement residencyCodedrop;
	@FindBy(xpath = "//div[@id='residencyCode']/input")	WebElement residencyCodesearch;
	@FindBy(xpath = "//div[@id='sourceHeardAboutUs']/div/span") WebElement sourceHeardAboutUsdrop;
	@FindBy(xpath = "//div[@id='sourceHeardAboutUs']/input")	WebElement sourceHeardAboutUssearch;
	@FindBy(xpath = "//div[@class='titleHead']//div//button[2]") WebElement Savebutton;
	
	

	public ApplicantInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public Application applicantdata(String fullparttime, String admitcode, String campuscode, String resdencycode, String primarysource) throws InterruptedException {
		//Select Full Time value
		FullParttimedrop.click();
		Fullpartsearch.sendKeys(fullparttime);
		Fullpartsearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Select Minor Values
		minorlink.click();
		Thread.sleep(2000);
		popupdropdown.click();
		Thread.sleep(2000);
		List<WebElement> minor = driver.findElements(By.xpath("//li[@class='ng-scope']//span[2]"));
		for (int i = 0; i < minor.size(); i++) {
			WebElement minor_element = minor.get(i);
			minor_element.click();
		}
		popupAddbutton.click();
		Thread.sleep(3000);
		
		//Select Concentration values
		concentrationlink.click();
		Thread.sleep(2000);
		popupdropdown.click();
		Thread.sleep(2000);
		List<WebElement> concentration = driver.findElements(By.xpath("//li[@class='ng-scope']//span[2]"));
		for (int i = 0; i < concentration.size(); i++) {
			WebElement concentration_element = concentration.get(i);
			concentration_element.click();
		}
		popupAddbutton.click();
		Thread.sleep(3000);
		
		//select admit code
		/*
		 * admitcodedrop.click(); admitcodesearch.sendKeys(admitcode);
		 * admitcodesearch.sendKeys(Keys.ENTER); Thread.sleep(2000);
		 * 
		 * // select campus code campusCodedrop.click();
		 * campusCodesearch.sendKeys(campuscode); campusCodesearch.sendKeys(Keys.ENTER);
		 * Thread.sleep(2000);
		 * 
		 * //select residency code residencyCodedrop.click();
		 * residencyCodesearch.sendKeys(resdencycode);
		 * residencyCodesearch.sendKeys(Keys.ENTER); Thread.sleep(2000);
		 * 
		 * // select primary source sourceHeardAboutUsdrop.click();
		 * sourceHeardAboutUssearch.sendKeys(primarysource);
		 * sourceHeardAboutUssearch.sendKeys(Keys.ENTER); Thread.sleep(2000);
		 */

		Savebutton.click();
		Thread.sleep(5000);
		
		return new Application(driver);
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
