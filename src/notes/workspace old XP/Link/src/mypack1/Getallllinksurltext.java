package mypack1;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Getallllinksurltext {

public static void main(String args[]) throws IOException {
// WebDriver reference but Firefox object
WebDriver driver = new FirefoxDriver();
//Maximize browser window 
driver.manage().window().maximize();
//Navigate to page to get link urls abd texts
driver.navigate().to("http://www.tiliconveli.com");
//Set  timeout
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// Store all link tag imagetags array  
List<WebElement> urltags = driver.findElements(By.tagName("a"));
for (WebElement url : urltags) {
// Fiter only valid link
if ((url.getAttribute("href").trim().length() != 0) && (url.getText().trim().length() != 0)) {
//print page link
System.out.println(url.getText().trim() + " --> " + url.getAttribute("href").trim());

 }
}
//close firefox browser    
driver.quit();
    }

}
