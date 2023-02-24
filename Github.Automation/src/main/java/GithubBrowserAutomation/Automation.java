package GithubBrowserAutomation;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation {

	
public static WebDriver driver;
	
	@BeforeMethod
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://github.com/");

}
	
	@Test(priority=1,enabled=false)
	public static void FailedLogin() throws IOException {
		driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.id("login")).sendKeys("Rajib");
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Rajib");
		//driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String expected = "Incorrect username or password.";
		String actual = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Assert.assertEquals(actual,expected);
	}
	
	
	@Test(priority=2,enabled=false)
	public static void SuccessfullLogin() {
		driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.id("login")).sendKeys("Rajib");
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Rajibroy1750");
		//driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Roy1750@");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement element = driver.findElement(By.xpath("(//*[@class='dropdown-caret'])[2]"));
		
	element.click();
	driver.findElement(By.linkText("Your profile")).click();
	String actual = driver.findElement(By.xpath("//*[text()='Edit profile']")).getText();
String expected = "Edit profile";
Assert.assertEquals(actual, expected);
		

}
	
	@Test(priority=3,enabled=false)
	public static void GenerateToken1() {
		Automation.SuccessfullLogin();
		WebElement element = driver.findElement(By.xpath("(//*[@class='dropdown-caret'])[2]"));
		element.click();
		driver.findElement(By.linkText("Settings")).click();
		
		driver.findElement(By.linkText("Developer settings")).click();
		driver.findElement(By.id("personal-access-tokens-menu-item")).click();
		
		driver.findElement(By.xpath("(//span[@class='ActionListItem-label'])[5]")).click();
		driver.findElement(By.xpath("(//summary[@role='button'])[4]")).click();
		driver.findElement(By.xpath("(//div[@class='f5 text-bold'])[2]")).click();

		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("QA automations");
		
		Select Expiration = new Select(driver.findElement(By.xpath("//select[@aria-labelledby='expiration-label']")));
		Expiration.selectByVisibleText("7 days");
		
	
		driver.findElement(By.xpath("//input[@value='workflow']")).click();
		driver.findElement(By.xpath("//input[@value='user']")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).sendKeys(Keys.ENTER);
}
	@Test(priority=4)
	public static void GenerateToken2() {
		
		Automation.SuccessfullLogin();
		WebElement element = driver.findElement(By.xpath("(//*[@class='dropdown-caret'])[2]"));
		element.click();
		driver.findElement(By.linkText("Settings")).click();
		
		driver.findElement(By.linkText("Developer settings")).click();
		

		driver.findElement(By.id("personal-access-tokens-menu-item")).click();
		
		driver.findElement(By.xpath("(//span[@class='ActionListItem-label'])[5]")).click();
		driver.findElement(By.xpath("(//summary[@role='button'])[4]")).click();
		driver.findElement(By.xpath("(//div[@class='f5 text-bold'])[2]")).click();

		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Custom automations");
		
		Select Expiration = new Select(driver.findElement(By.xpath("//select[@aria-labelledby='expiration-label']")));
		Expiration.selectByVisibleText("Custom...");
		driver.findElement(By.xpath("//input[@type='date']")).click();
		
//	
//		driver.findElement(By.xpath("//input[@value='public_repo']")).click();
//		driver.findElement(By.xpath("//input[@value='read:user']")).click();
//		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).sendKeys(Keys.ENTER);
//		


}

	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}