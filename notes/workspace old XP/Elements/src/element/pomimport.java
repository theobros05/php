package element;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pomexample.LoginPom;

public class pomimport {

	WebDriver driver;

  @Test

  public void level() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/v4/") ; 
  	LoginPom ss=new LoginPom(driver);
	ss.userlogin();
ss.passwordtype();
	ss.clicksubmitbutton();
Thread.sleep(1000);
 	driver.quit();
	}
  
}
