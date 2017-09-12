package obj1;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assertion {
	
	WebDriver driver;
	
	
    
    public void testCase1()
    {
     	
 
        //initialize Chrome driver
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    	
        WebDriver driver = new ChromeDriver(); 
        
          driver.navigate().to("http://google.com");
    Assert.assertEquals("Google", driver.getTitle());
    System.out.println("Successfully passed!");
 
      
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         
         
       
}}


    































