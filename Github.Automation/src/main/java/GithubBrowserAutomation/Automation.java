package GithubBrowserAutomation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Package.Utilities.AutomationUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation extends AutomationUtilities{

	
public static WebDriver driver;
	
	@BeforeTest
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://github.com/");

}
	
	@Test(priority=1)
	public static void FailedLogin() {
		driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.id("login")).sendKeys("Rajib");
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Rajib");
		//driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		AutomationUtilities.getHighLighter(driver.findElement(By.xpath("//input[@name='login']")));
		AutomationUtilities.getHighLighter(driver.findElement(By.xpath("//input[@name='password']")));
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
}
	
	@Test(priority=2)
	public static void SuccessfullLogin() {
		driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.id("login")).sendKeys("Rajib");
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Rajibroy1750");
		//driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Roy1750@");
		AutomationUtilities.getHighLighter(driver.findElement(By.xpath("//input[@name='login']")));
		AutomationUtilities.getHighLighter(driver.findElement(By.xpath("//input[@name='password']")));
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		

}
	@Test(priority=3)
	public static void GenerateToken1() {
	

Select Dropdown = new Select("//span[@class='dropdown-caret'])[2]");
Dropdown.selectByVisibleText("Settings");

}
	@Test(priority=4)
	public static void GenerateToken2() {
	


}
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
