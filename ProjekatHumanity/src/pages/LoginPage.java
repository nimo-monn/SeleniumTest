package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasicPage{

	private By email = By.name("email");
	private By password = By.name("password");
	private By loginBtn = By.name("login");
	
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	public void setEmail(String email) 
	{
		this.driver.findElement(this.email).sendKeys(email);
	}
	
	public void setPassword(String password) 
	{
		this.driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickOnLoginBtn() 
	{
		this.driver.findElement(this.loginBtn).click();
	}
	
	public void singIn(String email, String password) 
	{
		this.setEmail(email);
		this.setPassword(password);
		this.clickOnLoginBtn();
	}
	
	
}
