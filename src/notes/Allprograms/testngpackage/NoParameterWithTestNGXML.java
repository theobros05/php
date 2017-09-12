package testngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class NoParameterWithTestNGXML 
{
	
	WebDriver driver;
	 
	 
    @Test
 
    public void testNoParameter() throws InterruptedException{
 
        String author = "John";
        String searchKey = "tree";
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);
        searchText.submit();
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
        //Thread.sleep(1000);
        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
        Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
 
}
    @BeforeClass
    public void beforeClass() 
     { 
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); 
        driver.get("https://www.google.com/");
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
   

 
}

