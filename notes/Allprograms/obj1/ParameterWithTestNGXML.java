package obj1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class ParameterWithTestNGXML {
	 WebDriver driver;
 
@BeforeClass
	    public void beforeClass() 
	     { 
	System.setProperty("webdriver.chrome.driver","D://chromedriver.exe"); 
    driver= new ChromeDriver();
	  	  driver.get("http://www.google.com");
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

    