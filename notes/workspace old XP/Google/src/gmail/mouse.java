package gmail;
 
import java.util.concurrent.TimeUnit;
 import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class mouse{
 
	public static WebDriver driver;
 
   public static void main(String[] args)   throws InterruptedException{
 
	   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
 
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get("https://www.bing.com/account/general?ru=https%3a%2f%2fwww.bing.com%2f&FORM=O2HV65&id=language_section#language-section");
 
       // WebElement element = driver.findElement(By.xpath(".//*[@id='rpp']"));
        
       // WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector_For_Element_To_Be_Click_After_Hover)));
        //driver.findElement(By.cssSelector(selector_For_Element_To_Be_Click_After_Hover)).click();
        //Actions action = new Actions(driver);
        //WebElement mainMenu = driver.findElement(By.linkText("MainMenu"));
       // action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("submenuxpath"))).click().build().perform();
        
        WebElement wb = driver.findElement(By.xpath(".//*[@id='rpp']"));
        
        Actions mouse = new Actions(driver);
        
        mouse.moveToElement(wb).click().build().perform();
        //b.click().build().perform();
        
        
        //
        
        Select sel = new Select(wb);
        
        sel.selectByIndex(3);
        
        mouse.release();
        
        //mouse.doubleClick(wb);
        Thread.sleep(5000);
       driver.quit();
 
       /* Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
 
        driver.findElement(By.id("rpp")).click();*/
 
        }
 
}