package candidatepages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
 
public class FileUploadWithRobot
{
    public static void main(String args[]) throws Exception
    {
        Robot robot = new Robot();
       // System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
        WebDriver driver = new ChromeDriver();
 
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.findElement(By.id("imagesrc")).click();
 
        robot.setAutoDelay(2000);
 
        StringSelection selection = new StringSelection("D:\\workspace new\\hybrid\\src\\main\\java\\Resourse\\resume.doc");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
 
        robot.setAutoDelay(1000);
 
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
 
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
 
        robot.setAutoDelay(1000);
 
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}