package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeePage extends BasicPage{

	private By addEmployeeBtn = By.id("act_primary");
	private By inputEl = By.cssSelector("._add_staff_tb tr._ns_row");
	private By saveBtn = By.id("_as_save_multiple");
	private int numberOfEmp = 0;
	
	public EmployeePage(WebDriver driver) 
	{
		super(driver);
	}

	public WebElement getAddEmployeeBtn() 
	{
		return this.driver.findElement(addEmployeeBtn);
	}
	
	public List<WebElement> getInputElements() 
	{
		return this.driver.findElements(inputEl);
	}
	
	public WebElement getInputsForRow(WebElement el, By findBy) 
	{
		return el.findElement(findBy);
	}
	
	public WebElement getSaveBtn() 
	{
		return this.driver.findElement(saveBtn);
	}
	
	public void addEmploy(String firstName,String lastName,String email) 
	{
		List<WebElement> inputs = this.getInputElements();
		WebElement fNameInput = this.getInputsForRow(inputs.get(numberOfEmp), 
					         By.cssSelector("[placeholder='first name']"));
		WebElement lNameInput = this.getInputsForRow(inputs.get(numberOfEmp), 
		         By.cssSelector("[placeholder='last name']"));

		WebElement emailInput= this.getInputsForRow(inputs.get(numberOfEmp), 
					         By.cssSelector("[placeholder='email@address.com']"));
		
		fNameInput.sendKeys(firstName);
		lNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		
		numberOfEmp++;
	}
	
	
//	public boolean employAdded(String email) {
//		return this.driver.findElement(By.xpath("//*[text()='"+ email +"']\"")) != null;
//	}
}
