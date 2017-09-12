package example1.example1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parallelseleniumcode {

	private WebDriver driver;
	String baseURL = "http://www.google.com/";

	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefo")) {
				System.setProperty("webdriver.gecko.driver", "D:\\firefoxdriver.exe");
				driver = new FirefoxDriver();
				}
				
			 if (browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void login_TestCase() throws Throwable {
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        Thread.sleep(1000);
        getscreenshot();
                //do something
	}

	@Test
	public void search_TestCase() {
		driver.navigate().to(baseURL);
		
		driver.manage().window().maximize();
             //do something
		// Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	public void getscreenshot() throws Exception 
	  {
	          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          
	       //The below method will save the screen shot in d drive with name "screenshot.png"
	          
	          
	          
	          FileUtils.copyFile(scrFile, new File("D:\\paralleltest"+System.currentTimeMillis()+".png"));
	          
	          //FileUtils.copyFile(src, new File("C:/selenium/"+System.currentTimeMillis()+".png"));
	  }
}