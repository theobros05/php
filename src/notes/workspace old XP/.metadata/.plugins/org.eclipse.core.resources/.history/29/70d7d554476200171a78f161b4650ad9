import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class HowToDO {

WebDriver driver;

@BeforeTest
public void setup() throws Exception {
System.setProperty("webdriver.gecko.driver","C:\\Users\\sys\\Downloads\\geckodriver.exe");
	driver = new FirefoxDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
}

@AfterTest
public void tearDown() throws Exception {
	driver.quit();
}
@Test
public void Text3() throws InterruptedException {
driver.findElement(By.xpath(".//*[@id='post-body-4292417847084983089']/div[1]/button[1]")).click();
Alert A3 = driver.switchTo().alert();
String Alert3 = A3.getText();
System.out.println(Alert3);
// To type text In text box of prompt pop up.
//A3.sendKeys("Sakthi");
Thread.sleep(2000);
//A3.accept();
}
}
