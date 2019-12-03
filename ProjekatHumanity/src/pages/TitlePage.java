package pages;

import org.openqa.selenium.WebDriver;

public class TitlePage extends BasicPage{

	
	public TitlePage(WebDriver driver) 
	{
		super(driver);
	}

	public String getPageTitle() 
	{
		return this.driver.getTitle();
	}
}
