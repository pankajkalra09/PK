package SelfService.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Application {

	public WebDriver driver;
	
	public Application(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
}
