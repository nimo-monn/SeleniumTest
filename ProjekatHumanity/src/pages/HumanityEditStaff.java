package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityEditStaff extends BasicPage{
	
	private By editDetails = By.xpath("//*[@id='_cd_staff']/div[3]/div[1]/a[2]");
	private By nicknameBtn = By.id("nick_name");
	private By saveEmployeeBtn = By.id("act_primary");

	public HumanityEditStaff(WebDriver driver) 
	{
		super(driver);
	}
	
	public WebElement getEditDetails()
	{
		return this.driver.findElement(editDetails);
	}
	
	public void getNicknameBtn(String nickname) 
	{
		this.driver.findElement(nicknameBtn).sendKeys(nickname);
	}
	
	public void saveEmployee()
	{
		this.driver.findElement(this.saveEmployeeBtn).click();
	}
	
	public void getUpload() throws InterruptedException
	{
		WebElement eDetails = this.driver.findElement(editDetails);
		eDetails.click();
		Thread.sleep(2000);
		
		WebElement uploadPicture = this.driver.findElement(By.id("fileupload"));	
		uploadPicture.sendKeys("C:\\Users\\Moni\\eclipse-workspace\\ProjekatHumanity\\IMG_4038.jpg");
		Thread.sleep(2000);
	}

}
