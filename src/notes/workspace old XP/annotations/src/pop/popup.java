package pop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class popup {
WebDriver driver;

@BeforeTest
public void setup() throws Exception {
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
}

@AfterTest
public void tearDown() throws Exception {
driver.quit();
}
/*
* @Test public void Text() throws InterruptedException {
* driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
* //To locate alert. Alert A1 = driver.switchTo().alert(); //To read the
* text from alert popup. String Alert1 = A1.getText();
* System.out.println(Alert1); Thread.sleep(2000); //To accept/Click Ok on
* alert popup. A1.accept(); }
* 
* 
* 
* @Test public void Text2() throws InterruptedException{
* driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click()
* ; Alert A2 = driver.switchTo().alert(); String Alert22 = A2.getText();
* System.out.println(Alert22); Thread.sleep(2000); A2.dismiss(); }
*/

@Test
public void Text3() throws InterruptedException {
driver.findElement(By.xpath("//button[contains(.,'Show Me Prompt')]")).click();
Alert A3 = driver.switchTo().alert();
//String Alert3 = A3.getText();
A3.sendKeys("This is Pleasanton Test Team");
//System.out.println(Alert3);
// To type text In text box of prompt pop up.
//A3.sendKeys("This is Pleasanton Test Team");
Thread.sleep(10000);
//A3.dismiss();


}

}