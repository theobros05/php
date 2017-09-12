package har;

import org.testng.annotations.*;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;
  
  public class assertion {
	  WebDriver driver;
	  String url; 
	  
	  @Test  
	  public void testCase1(){
	  	
	  	 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();
	       
	       driver.navigate().to("http://google.com");
	       
	       System.out.println("Page title is " + driver.getTitle() ) ;
	       
		    Assert.assertEquals("Google", driver.getTitle());
		    System.out.println("Successfully passed!");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
            
            
		   
	  driver.close();
	  driver.quit();
	  
	


		  


	  }
		  
	  
}

 
