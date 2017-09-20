package candidatepages;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import testbase.TestBase;

public class Forward extends TestBase {

	public static void forw() throws Exception // code done
	{      logger = Logger.getLogger(Forward.class.getName());
	
		Set<String> Wi = driver.getWindowHandles();

		Iterator it = Wi.iterator();
		String main = (String) it.next();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		getWebElement("profileClick").click();
		logger.info("Clicking Profile");
		er.log(Status.INFO, "Clicking Profile");
		Wi = driver.getWindowHandles();
		logger.info("No of Windows:" + Wi.size());
		//System.out.println("No of Windows:" + Wi.size());
		it = Wi.iterator();
		it = Wi.iterator();
		String mmm = (String) it.next();
		String nnn = (String) it.next();
		driver.switchTo().window(nnn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 30);

		getWebElement("profileDownload").click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("Downloading Profile");
		
		er.log(Status.INFO, "Downloading Profile");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*//getWebElement("profileForward").click();
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='forward']"))));
		element.click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("Clicking Forward Button");
		er.log(Status.INFO, "Clicking Forward Button");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jsforwardprofilecontentframe");

		getWebElement("profileForwardToMail").sendKeys(OR.getProperty("profileForwardID"));
		logger.info("Entering Forward Mailid");
		er.log(Status.INFO, "Entering Forward Mailid");
		getWebElement("profileSendButton").click();
		logger.info("Clicking SendButton");
		er.log(Status.INFO, "Clicking SendButton");
		wait = new WebDriverWait(driver, 50);

		getWebElement("profileClose").click();
		logger.info("closing profile forward ");
		er.log(Status.INFO, "closing profile forward");
		*/
		driver.close();
		driver.switchTo().window(mmm);
		driver.switchTo().defaultContent();
		wait = new WebDriverWait(driver, 50);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		er.log(Status.INFO, "Redirecting to logout");
		 Thread.sleep(5000);
	}

	public static void main(String[] args) throws Exception {
		TestBase.getBrowser();
		Login.run();
		Forward.forw();
		Logout.out();

	}

}
