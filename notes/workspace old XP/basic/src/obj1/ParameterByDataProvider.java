package obj1;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class ParameterByDataProvider {
 
     WebDriver driver;
    @BeforeTest
 
    public void setup(){
    	    System.setProperty("webdriver.chrome.driver","D://chromedriver.exe"); 
            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://google.com");
 
    }
    @AfterClass
    public void afterClass() {
  	  driver.quit();
    }
 
    @Test(dataProvider="SearchProvider")
 
    public void testMethod(String author,String searchKey) throws InterruptedException{
 
        {
 
            WebElement searchText = driver.findElement(By.name("q"));
            searchText.sendKeys(searchKey);
            System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
            Thread.sleep(3000);
            String testValue = searchText.getAttribute("value");
            System.out.println(testValue +"::::"+searchKey);
            searchText.clear();
            Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }
    }
 
    @DataProvider(name="SearchProvider")
 
    public Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "John", "Tiger" },
                { "Mary", "Rose" },
                { "Mark", "Dubai" },
                { "Matt", "Rayban" },
                { "Smith", "Audi" }
            };
    }
 
}
