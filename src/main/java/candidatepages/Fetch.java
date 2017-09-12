package candidatepages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.TestBase;

public class Fetch extends TestBase {

	public static void fet() throws Exception {
		// fetching the job based on resume detail
		logger = Logger.getLogger(Fetch.class.getName());
		driver.switchTo().defaultContent();
		getWebElement("myJobs").click();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		logger.info("clicking the my jobs tab");

		getWebElement("fetchJobs").click();
		logger.info("clicking fetch job tab");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		logger.info("move to content frame");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='txtKeyword']"))));
		element.clear();
		element.sendKeys(OR.getProperty("key"));
		logger.info("Entering the keyword");

		getWebElement("keyAll").click();
		logger.info("select the type");

		new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ddlCountry']"))))
				.selectByVisibleText("India");
		logger.info("select the country");

		new Select(getWebElement("splzdarea")).selectByVisibleText("Java, J2EE");
		logger.info("select the specialized skills");

		getWebElement("advoption").click();
		logger.info("click the browse button");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		getWebElement("state").clear();
		getWebElement("state").sendKeys(OR.getProperty("cityname"));
		logger.info("select the state");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkPreferredEmployment_5"))).click();
		//getWebElement("needh1b").click();
		logger.info("Clicking prefered employment");

		getWebElement("securityClearance").click();
		logger.info("Clicking the work authorization");

		getWebElement("nedh1b").click();
		logger.info("Clicking the work authorization");

		getWebElement("h1bWorkpermit").click();
		logger.info("Clicking the work authorization");

		getWebElement("ead").click();
		logger.info("Clicking the work authorization");

		getWebElement("greenCard").click();
		logger.info("Clicking the work authorization");

		getWebElement("remote").click();
		logger.info("Clickingthe check remote option");

		getWebElement("excludeWords").sendKeys(OR.getProperty("exclude"));
		logger.info("Clicking the exclude words");

		new Select(getWebElement("jobPost")).selectByVisibleText("2 Days");
		logger.info("Selecting a job within a days/months/years");

		getWebElement("fetchJob").click();
		
		logger.info("End of fetch");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		logger.info("redirecting to logout");
		 Thread.sleep(5000);
	}

	public static void main(String[] args) throws Exception {
		TestBase.loadPropertiesFile();
		TestBase.getBrowser("chrome");
		Login.run();
		Fetch.fet();

	}
}
