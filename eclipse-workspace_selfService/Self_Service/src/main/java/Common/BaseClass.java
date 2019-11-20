package Common;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initilizeBrowser() throws Exception {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Pankaj_Kalra\\eclipse-workspace_selfService\\Self_Service\\src\\main\\java\\Data\\data.properties");
		prop.load(fis);

		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pankaj_Kalra\\eclipse-workspace_selfService\\Self_Service\\src\\main\\java\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));

		return driver;

	}
}
