package examples;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class zero {
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

@Before
public void setUp() throws Exception {

	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    driver = new ChromeDriver();
baseUrl = "https://www.google.co.in/";
driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
}

@Test
public void testkl() throws Exception {
driver.get(baseUrl + "/?gfe_rd=cr&ei=gvBMWZKLNNCL8QeJrqmIDQ");
driver.findElement(By.id("lst-ib")).click();
driver.findElement(By.id("lst-ib")).clear();
driver.findElement(By.id("lst-ib")).sendKeys("Zero");
Thread.sleep(10000);
}

@After
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