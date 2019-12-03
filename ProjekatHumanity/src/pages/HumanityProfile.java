package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HumanityProfile extends BasicPage {

	//private By profSettings = By.cssSelector("i.icon.icon-arrowFullDn.j-arrowIconToAvatar.navBottom__userArrow");
	private By profSettings = By.xpath("//*[@id=\"wrap_us_menu\"]/i");
	private By profileBtn = By.xpath("//*[@id=\"userm\"]/div/a[1]");
	private By settingsBtn = By.cssSelector("#userm > div > a:nth-child(5)");
	private By availabilityBtn = By.cssSelector("#userm > div > a:nth-child(7)");
	private By signOutBtn = By.cssSelector("#userm > div > div:nth-child(13) > a");
	private By appVersion = By.id("humanityAppVersion");
	
	public HumanityProfile(WebDriver driver) 
	{
		super(driver);
	}
	
	public void getProfileSettings() 
	{
		this.driver.findElement(this.profSettings).click();
	}
	
	public void getProfileBtn()
	{
		this.driver.findElement(this.profileBtn).click();
	}
	
	public void getSettingsBtn()
	{
		this.driver.findElement(this.settingsBtn).click();
	}
	
	public void getAvailabilityBtn()
	{
		this.driver.findElement(this.availabilityBtn).click();
	}
	
	public void getSignOutBtn()
	{
		this.driver.findElement(this.signOutBtn).click();
	}
	
	public String getAppVersion()
	{
		return this.driver.findElement(appVersion).getText();
	}
	
}
