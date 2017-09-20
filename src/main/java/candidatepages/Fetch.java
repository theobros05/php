package candidatepages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

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
		er.log(Status.INFO, "clicking the my jobs tab");
		getWebElement("fetchJobs").click();
		logger.info("clicking fetch job menu");
		er.log(Status.INFO, "clicking fetch job menu");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		logger.info("moving to content frame");
		er.log(Status.INFO, "moving to content frame");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='txtKeyword']"))));
		element.clear();
		element.sendKeys(OR.getProperty("key"));
		logger.info("Entering the keyword");
		er.log(Status.INFO, "Entering the keyword\"");

		getWebElement("keyAll").click();
		logger.info("select the type");
		er.log(Status.INFO, "select the type");

		new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ddlCountry']"))))
				.selectByVisibleText("India");
		logger.info("select the country");
		er.log(Status.INFO, "select the country");

		new Select(getWebElement("splzdarea")).selectByVisibleText("Java, J2EE");
		logger.info("select the specialized skills");
		er.log(Status.INFO, "select the specialized skills");

		getWebElement("advoption").click();
		logger.info("click the browse button");
		er.log(Status.INFO, "click the browse button");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		getWebElement("state").clear();
		getWebElement("state").sendKeys(OR.getProperty("cityname"));
		logger.info("select the state");
		er.log(Status.INFO, "select the state");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkPreferredEmployment_5"))).click();
		//getWebElement("needh1b").click();
		logger.info("Clicking prefered employment");
		er.log(Status.INFO, "Clicking prefered employment");

		getWebElement("securityClearance").click();
		logger.info("Clicking security clearance");
		er.log(Status.INFO, "Clicking security clearance");
		getWebElement("nedh1b").click();
		logger.info("Clicking H1B type");
		er.log(Status.INFO, "Clicking H1B type");

		getWebElement("h1bWorkpermit").click();
		logger.info("Clicking H1B work permit");
		er.log(Status.INFO, "Clicking H1B work permit");

		getWebElement("ead").click();
		logger.info("Clicking EAD");
		er.log(Status.INFO, "Clicking EAD");

		getWebElement("greenCard").click();
		logger.info("Clicking Green card");
		er.log(Status.INFO, "Clicking Green card");
		getWebElement("remote").click();
		logger.info("Clicking the check remote option");
		er.log(Status.INFO, "Clicking the check remote option");
		getWebElement("excludeWords").sendKeys(OR.getProperty("exclude"));
		logger.info("Clicking the exclude words");
		er.log(Status.INFO, "Clicking the exclude words");
		new Select(getWebElement("jobPost")).selectByVisibleText("2 Days");
		logger.info("Selecting a job within a days/months/years");
		er.log(Status.INFO, "Selecting a job within a days/months/years");
		getWebElement("fetchJob").click();
		/*
		//wait = new WebDriverWait(driver, 50);
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		getWebElement("myJobs").click();
		
		getWebElement("matchedjobtab").click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		
		getWebElement("matchedjob").click();
		Thread.sleep(2000);
		System.out.println("jobs matched successfully");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		
		
		getWebElement("myJobs").click();
		
		getWebElement("appliedjobtab").click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		
		getWebElement("appliedjob").click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		getWebElement("generatereport").click();
		//Thread.sleep(2000);
		System.out.println("applied jobs successfully");

		
		*/
		
		
		
		logger.info("End of fetch");
		er.log(Status.INFO, "End of fetch");
		driver.switchTo().defaultContent();
		logger.info("redirecting to logout");
		er.log(Status.INFO, "redirecting to logout");
		 Thread.sleep(5000);
	}

	public static void main(String[] args) throws Exception {
		TestBase.getBrowser();
		Login.run();
		Fetch.fet();
		Logout.out();

	}
}
