package obj1;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class yahoo {
	WebDriver driver;
	
   @Test (groups="yahoo-mail-page")
   public void testCase1() {   
	   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	   driver= new ChromeDriver();
	   driver.get("http://yahoomail.com");  
   }

      @Test (groups="Userid")
   public void testCase2() {
	  String id;
	   WebElement element = driver.findElement(By.id("login-username"));
       element.sendKeys("balapriyam95@yahoo.com");
   }


@Test (groups="Password")
      public void testCase3() {
	driver.findElement(By.id("login-signin")).click();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   WebElement element = driver.findElement(By.id("login-passwd"));
    element.sendKeys("9944536923");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
      }

   @Test (groups="signin")
   public void testcase4() throws InterruptedException {
       driver.findElement(By.id("login-signin")).click(); 
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       Thread.sleep(1000);  
   }

   @Test (groups="Signout")
   public void testcase5() throws InterruptedException {
	   
         driver.findElement(By.xpath(".//*[@id='yui_3_10_3_1_1375219693637_127']")).click();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.findElement(By.xpath(".//*[@id='yucs-signout']")).click();
}
}
