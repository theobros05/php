package obj1;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class newyahoo {
	WebDriver driver1;
	
@Test(dependsOnMethods={"testCase4"})
	public void testCase1() throws InterruptedException{
	
	
	WebElement myDynamicElement = (new WebDriverWait(driver1, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='yui_3_10_3_1_1375219693637_127']/b")));
    driver1.findElement(By.xpath(".//*[@id='yui_3_16_0_2_1498735011253_194']")).click();
	
	//driver1.findElement(By.xpath(".//*[@id='yui_3_10_3_1_1375219693637_127']/b")).click();
	
	//driver1.findElement(By.id("yui_3_10_3_1_1375219693637_127")).click();

	driver1.findElement(By.id("yucs-signout")).click();
	

}
@Test 
	public void testCase2(){
	driver1.get("https://login.yahoo.com/?.src=fp&.intl=in&.lang=en-IN&.done=https%3a//mail.yahoo.com");
	//driver1.get("https://accounts.google.com//signin") ;
driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
@Test
	public void testCase3(){
	driver1.findElement(By.id("login-username")).sendKeys("balapriyam95@yahoo.com");
	 driver1.findElement(By.id("login-signin")).click();
	 
	 
driver1.findElement(By.id("login-passwd")).sendKeys("9944536923");
driver1.findElement(By.id("login-signin")).click();
	
	}
@Test 
	public void testCase4(){
System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
driver1 = new ChromeDriver();
	}}
