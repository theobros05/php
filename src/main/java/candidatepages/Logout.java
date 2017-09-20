package candidatepages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

import candidatepages.Login;
import testbase.TestBase;

public class Logout extends TestBase {

	public static void out() throws Exception { // code done
		logger = Logger.getLogger(Logout.class.getName());
		
		driver.switchTo().defaultContent();

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		getWebElement("userSetting").click();
		logger.info("Clicking user settings icon ");
		er.log(Status.INFO, "Clicking user settings icon");

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		getWebElement("logoutButton").click();
		logger.info("Clicking logout button ");
		er.log(Status.INFO, "Clicking logout button");

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		logger.info("End of logout ");
		er.log(Status.INFO, "End of logout");
		driver.quit();
	}

	public static void main(String[] args) throws Exception {

		TestBase.getBrowser();
		Login.run();
		Logout.out();

	}

}
