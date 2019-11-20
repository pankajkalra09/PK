package AdmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProspectsViewRecords {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ProspectsViewRecords.class.getName());
	
	@FindBy(xpath = "//ul[@id='menu-block']/li/a[@title='PROSPECTS']") WebElement prospects;
	@FindBy(xpath = "//ul[@id='menu-block']/li/ul/li/a[@title = 'View Records']") WebElement ProspectViewRecords;
	@FindBy(xpath = "//ol[@class='breadcrumb']/li/span[contains (text(), 'Prospects')]") WebElement breadcrumbProspect;
	@FindBy(xpath = "//*[@id=\"centercontent\"]/div/dashboardv1/div[1]/div[1]/div[2]/div/ul/li[1]/button") WebElement AddFilterlink;
	@FindBy(xpath = "//div[@class='modal-content']/div/h4[contains(text(), 'Filter')]") WebElement Filterpopup;
	@FindBy(xpath = "//*[@id=\"filterModal\"]/div/div/dashboard-filterv1/div/form/div[1]/div/div[2]/div[2]/fieldset/div/label/input") WebElement FilterSelect;
	@FindBy(xpath = "//*[@id=\"filterModal\"]/div/div/dashboard-filterv1/div/form/div[3]/input") WebElement ApplyFilterbutton;
	@FindBy(xpath = "//span[contains (text(), 'Showing Result(s):')]") WebElement showingresult;
	@FindBy(xpath = "//label[contains (text(), 'Clear All Filters')]") WebElement clearAllFilter;
	@FindBy(xpath = "//*[@id=\"custDropDown\"]") WebElement customizecolumnlink;
	@FindBy(xpath = "//*[@id=\"customizeColumns\"]/div/div/form/div[2]/fieldset/div[1]/ul/li[2]/label/span") WebElement SelectAll;
	@FindBy(xpath = "//input[@value='Apply']") WebElement CustomizeApplyButton;
	@FindBy(xpath = "//span[@class='tglbtn']") WebElement AdvanceFilterToggle;
	@FindBy(xpath = "//table/thead/tr[2]/td[2]/input[@type='text']") WebElement FirstNameText;
	
	
	public ProspectsViewRecords(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	

}
