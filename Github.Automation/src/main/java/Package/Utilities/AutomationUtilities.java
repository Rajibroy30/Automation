package Package.Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import GithubBrowserAutomation.Automation;

public class AutomationUtilities {
	public static WebElement getExplicitWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(element));
		return elem;
	}
	
	//clicking challenge
	//Actions is not an interface, it is a class from selenium
	
	public static void actionClick(WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}
	
	public static void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver; //casting - changing the type of the object
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void elementScroll(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView", element);
	}
	
	public static void scrollToBottomPage() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollToTopPage() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0,0)");
		
	}
	
	public static void takeScreenShot() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+ "//screenshot.screenshot.png");
		targetFile.getParentFile().mkdir();
		srcFile.createNewFile();
		Files.copy(srcFile, targetFile);
		
	}
	
	public static void getHighLighter(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('style','background: yellow; border: 4px solid red;');", element);
		
	}
	
	
	

}
