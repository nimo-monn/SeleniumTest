package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasicPage {

	private By navTrail = By.cssSelector(".top-header .nav-trial a");
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	public WebElement getLoginBtn() 
	{
		return this.driver.findElements(navTrail).get(1);
	}
	
	

}
