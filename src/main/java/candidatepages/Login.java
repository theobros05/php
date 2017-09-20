package candidatepages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

import testbase.TestBase;

public class Login extends TestBase

{

	public static void run() throws Exception // code done
	{
		logger = Logger.getLogger(Login.class.getName());
		logger.setLevel(Level.INFO);
		driver.get(OR.getProperty("url"));

		logger.info("Opening Techfetch webiste");
		//er.log(Status.INFO, "");

		er.log(Status.INFO, "Opening Techfetch webiste");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		getWebElement("candidateLogin").click();
		logger.info("Opening candidate menu");
		er.log(Status.INFO, "Opening candidate menu");

		getWebElement("loginButton").click();

		logger.info("Clicking candidate Login button");
		er.log(Status.INFO, "Clicking candidate Login button");
		driver.switchTo().defaultContent();

		getWebElement("mailId").sendKeys(OR.getProperty("userName"));
		logger.info("Entering mailid");
		er.log(Status.INFO, "Entering mailid");

		getWebElement("password1").sendKeys(OR.getProperty("password"));
		logger.info("Entering password");
		er.log(Status.INFO, "Entering password");

		getWebElement("submitButton").click();
		logger.info("Clicking submit button");
		er.log(Status.INFO, "Clicking submit button");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void main(String[] args) throws Exception {

		TestBase.getBrowser();
		Login.run();
		Logout.out();

	}
}
