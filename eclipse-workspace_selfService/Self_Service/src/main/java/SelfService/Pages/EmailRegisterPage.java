package SelfService.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EmailRegisterPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@id='selfserviceLoginEmail']")	WebElement emailtext;
	@FindBy(xpath = "//input[@type='submit']")	WebElement nextbutton;
	@FindBy(xpath = "//div[@id='emailVerificationModal']//button[text()='Close']")	WebElement closebutton;
	@FindBy(xpath = "//div[@id='emailVerificationModal']//div/h4")	WebElement popuptext;

	public EmailRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void verifyPageTitle() {
		String pagetitle = driver.getTitle();
		Assert.assertEquals(pagetitle, "Oklahoma Wesleyan University");
	}

	public ProspectInfoPage enterEmailId(String email) throws Exception {
		emailtext.sendKeys(email);
		Thread.sleep(5000);
		nextbutton.click();
		Thread.sleep(5000);
		try {
			String poptext = popuptext.getText();
			if (poptext.equalsIgnoreCase("Email Verification")) {
				closebutton.click();
				Thread.sleep(3000);
				emailtext.clear();
			}
		}catch (Exception e) {
				System.out.println("Catch block executed");
			
			}

		return new ProspectInfoPage(driver);
	}

}
