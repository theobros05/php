package obj1;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class crossbrowser
 {
	WebDriver driver;
@BeforeTest
@Parameters("browser")
public void setup(String browser) throws Exception
{
    if(browser.equalsIgnoreCase("chrome"))
   {		
      System.setProperty("webdriver.chrome.driver","D://chromedriver.exe"); 
      driver= new ChromeDriver();
     driver.get("http://www.google.com");
    }
    
    
     else if(browser.equalsIgnoreCase("ie"))
    {
	System.setProperty("webdriver.ie.driver","D://IEDriverServer.exe"); 
            driver= new InternetExplorerDriver();
            driver.get("http://www.Google.com/");
    }		
      else
      {
           //If no browser passed throw exception
	throw new Exception("Browser is not correct");
         }
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         }
       @Test
       @Parameters({"author","searchKey"})
         public void testParameterWithXML( @Optional("Abc") String author,String searchKey) throws InterruptedException
{  
      WebElement searchText = driver.findElement(By.name("q"));
         searchText.sendKeys(searchKey);
         System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
 Thread.sleep(3000);
	  System.out.println("Value Google in Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
	       
	       Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
	        
}
	  @AfterClass//called after every method
	    public void afterClass() {
	  	  driver.quit();
	
	
	    }
}
