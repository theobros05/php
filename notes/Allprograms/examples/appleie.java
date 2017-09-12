package examples;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class appleie {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.ie.driver","D:\\ie2.45\\IEDriverServer.exe");

	WebDriver driver = new InternetExplorerDriver();

	  
    baseUrl = "https://www.google.co.in/";
    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    System.out.println("Page title is " + driver.getTitle() ) ;
    Thread.sleep(10000);
  }

  @Test
  public void testAppleng() throws Exception {
    driver.get(baseUrl + "/search?q=apple&ie=utf-8&oe=utf-8&client=firefox-b-ab&gfe_rd=cr&ei=xCVOWZaUCMGL8QeF56TIDQ");
    driver.findElement(By.linkText("Apple (India)")).click();
   
   
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

