package candidatepages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import candidatepages.Login;
import testbase.TestBase;
public class Logout extends TestBase {

	public static void out() throws Exception { // code done
		logger = Logger.getLogger(Logout.class.getName());
		
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		getWebElement("userSetting").click();
		logger.info("Clicking user settings icon ");
		
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		
		getWebElement("logoutButton").click();
		logger.info("Clicking logout button ");
		
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		logger.info("End of logout ");
		driver.quit();
	}

	public static void main(String[] args) throws Exception {

		TestBase.loadPropertiesFile();
		TestBase.getBrowser("chrome");
		Login.run();
		Logout.out();

	}

}
