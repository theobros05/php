package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

public class Mhover
{
public static void main(String[] args)
{
/* declaration and instantiation of objects/variables */
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
String baseWebUrl = "http://www.flipkart.com/";
driver.get(baseWebUrl);
/* get the actual value of the title */
WebElement s = driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[2]/a"));






Actions b = new Actions(driver);

 
b.moveToElement(s);
 
b.click().build().perform();

/* closing Firefox Browser and System */
driver.close();
//System.exit(0);
}
}