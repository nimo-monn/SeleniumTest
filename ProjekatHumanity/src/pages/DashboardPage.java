package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasicPage {

	private By navLinks = By.cssSelector("ul#topMenu li");
	
	public DashboardPage(WebDriver driver) 
	{
		super(driver);
	}

	public List<WebElement> getNavLinks() 
	{
		return this.driver.findElements(navLinks);
	}
}
