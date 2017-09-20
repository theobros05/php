package candidatepages;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import candidatepages.Login;
import testbase.TestBase;

public class ForwardDash extends TestBase {

	public static void forw() throws Exception // code done
	{      
		
		logger = Logger.getLogger(ForwardDash.class.getName());
	
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("contentframe");

		
		
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
		WebDriverWait wait = new WebDriverWait(driver, 50);

		getWebElement("profileClose").click();
		logger.info("closing profile forward ");
		er.log(Status.INFO, "closing profile forward");
		
		driver.close();
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		er.log(Status.INFO, "Redirecting to logout");
		 Thread.sleep(5000);
	}

	public static void main(String[] args) throws Exception {
		TestBase.getBrowser();
		Login.run();
		ForwardDash.forw();
		Logout.out();

	}

}
