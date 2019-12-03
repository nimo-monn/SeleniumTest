package tests;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.EmployeePage;
import pages.HomePage;
import pages.HumanityEditStaff;
import pages.HumanityProfile;
import pages.LoginPage;
import pages.TitlePage;


public class LoginTest extends BasicTest {

	private String baseUrl = "https://www.humanity.com/";

	@Test(priority = 0)
	public void basicLogin() throws InterruptedException, Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		HomePage hp = new HomePage(driver);
		hp.getLoginBtn().click();
		Thread.sleep(2000);
		
		File file = new File("nalog.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		String korisnik = sheet.getRow(1).getCell(0).getStringCellValue();
		String lozinka = sheet.getRow(1).getCell(1).getStringCellValue();
		
		
		LoginPage lg = new LoginPage(driver);
		lg.singIn(korisnik, lozinka);
		Thread.sleep(2000);
		
		wb.close();
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Dashboard"));
		
	}
	
	@Test(priority = 1)
	public void dashboardTest() throws InterruptedException {
		
		DashboardPage dp = new DashboardPage(driver);
		System.out.print("dashboardTest" + dp.getNavLinks().size());
		Assert.assertTrue(dp.getNavLinks().size() > 0);
	}
	
	@Test(priority = 20)
	public void addEmployeeTest() throws InterruptedException, Exception {
		driver.get("https://sdn1.humanity.com/app/dashboard/");
		Thread.sleep(2000);
		
		DashboardPage dp = new DashboardPage(driver);
		System.out.print("addEmployeeTest" + dp.getNavLinks().size());
		dp.getNavLinks().get(5).click(); // Staff link
		Thread.sleep(2000);

		EmployeePage ep = new EmployeePage(driver);
		ep.getAddEmployeeBtn().click();
		Thread.sleep(2000);
		
		File file = new File("radnici.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		for(int i = 1; i <5; i++)
		{
			String ime = sheet.getRow(i).getCell(0).getStringCellValue();
			String prezime = sheet.getRow(i).getCell(1).getStringCellValue();
			String email = sheet.getRow(i).getCell(2).getStringCellValue();
			ep.addEmploy(ime, prezime, email);
		}
		
		/*ep.addEmploy("Milan", "Markovic", "233343232332@email.com");
		ep.addEmploy("Darko", "Darkovic", "ewd34334@email.com");
		ep.addEmploy("Marko", "Jeftic", "09238732k32m@email.com");*/
		
		ep.getSaveBtn().click();
		Thread.sleep(2000);
		workBook.close();
//		
//		dp.getNavLinks().get(5).click(); 
//		
//		Assert.assertTrue(ep.employAdded("233343232332@email.com"));
//		Assert.assertTrue(ep.employAdded("ewd34334@email.com"));
//		Assert.assertTrue(ep.employAdded("09238732k32m@email.com"));
		
	}
	
	@Test(priority = 21)
	public void goProfileSettings() throws InterruptedException{
		HumanityProfile hp = new HumanityProfile(driver);
		hp.getProfileSettings();
		
		hp.getProfileBtn();
		Thread.sleep(2000);
		
		HumanityEditStaff hes = new HumanityEditStaff(driver);
		hes.getUpload();
		Thread.sleep(2000);
		hes.getNicknameBtn("Moni");
		Thread.sleep(2000);
		hes.saveEmployee();
	}
	
	
}
