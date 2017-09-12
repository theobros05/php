package candidatepages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import testbase.TestBase;

public class Login extends TestBase

{

	public static void run() throws Exception // code done
	{logger = Logger.getLogger(Login.class.getName());
		driver.get(OR.getProperty("url"));

		logger.info("Opening Techfetch webiste");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getWebElement("candidateLogin").click();
		logger.info("Opening candidate menu");
		
		getWebElement("loginButton").click();

		logger.info("Clicking candidate Login button");
		driver.switchTo().defaultContent();
		
		//driver.switchTo().frame("candidatecontentframe");

		getWebElement("mailId").sendKeys(OR.getProperty("userName"));
		logger.info("Entering mailid");

		getWebElement("password1").sendKeys(OR.getProperty("password"));
		logger.info("Entering password");

		getWebElement("submitButton").click();
		logger.info("Clicking submit button");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	public static void main(String[] args) throws Exception {
		TestBase.loadPropertiesFile();
		TestBase.getBrowser("chrome");
		Login.run();
		Logout.out();

	}
}
