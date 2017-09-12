package candidatepages;

import java.util.concurrent.TimeUnit;
import testbase.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Update extends TestBase { // code working need little change

	public static void updat() throws Exception {
		logger = Logger.getLogger(Update.class.getName());

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		getWebElement("MyResume").click();
		logger.info("Opening MyResume");
		WebDriverWait wait = new WebDriverWait(driver, 30);

		getWebElement("AddResume").click();
		logger.info("Selecting AddResume");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		wait = new WebDriverWait(driver, 30);

		getWebElement("Name1").sendKeys(OR.getProperty("firstname"));
		logger.info("Entering FirstName");

		getWebElement("Name2").sendKeys(OR.getProperty("middlename"));
		logger.info("Entering MiddleName");

		getWebElement("Name3").sendKeys(OR.getProperty("lastname"));
		logger.info("Entering LastName");
		wait = new WebDriverWait(driver, 30);

		Select oSelect = new Select(getWebElement("Country"));
		logger.info("Selecting Country");
		oSelect.selectByIndex(12);

		getWebElement("City").sendKeys(OR.getProperty("city"));
		logger.info("Entering City,state or zip");

		getWebElement("MobNo").sendKeys(OR.getProperty("phone(mobile)"));
		logger.info("Entering MobilePhone");

		getWebElement("HomeNo").sendKeys(OR.getProperty("phone(home)"));
		logger.info("Entering HomePhone");
		getWebElement("WorkNo").sendKeys(OR.getProperty("phone(work)"));
		logger.info("Entering WorkPhone");

		getWebElement("ExtensionNo").sendKeys(OR.getProperty("phoneextension"));
		logger.info("Entering Extension");
		Select oSelect1 = new Select(getWebElement("PrefferedTime"));
		oSelect1.selectByIndex(2);
		logger.info("Selecting PrefferedTime");
		Select oSelect2 = new Select(getWebElement("Phone"));
		oSelect2.selectByIndex(2);
		logger.info("Selecting Home");
		Select oSelect3 = new Select(getWebElement("Citizen"));
		oSelect3.selectByIndex(2);
		logger.info("Selecting Citizen");

		getWebElement("WorkAuthorization").click();
		logger.info("Clicking WorkAuthorization");
		// upto here xpath
		getWebElement("Resumeupload").clear();
		logger.info("clearing upload");

		// resume upload in profile tab

		getWebElement("Resumeupload").sendKeys("D:\\workspace new\\hybrid\\src\\main\\java\\Resourse\\resume.doc");
		logger.info("Selecting Resume");
		Thread.sleep(10000);

		getWebElement("Submitt").click();
		logger.info("Clicking Submit button");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		logger.info("Switching to Professional");

		getWebElement("Bachelor").click();
		logger.info("Selecting Bachelor button on Highest degree");

		Select oSelect5 = new Select(getWebElement("ExcpectedSalary"));
		oSelect5.selectByVisibleText("$10K");
		logger.info("Selecting Expected salary per year");

		Select oSelect6 = new Select(getWebElement("ExpectedSalaryHour"));
		oSelect6.selectByVisibleText("$15");
		logger.info("Selecting Expected salary per hour");

		getWebElement("JobTitle").clear();

		getWebElement("JobTitle").sendKeys(OR.getProperty("jobtitle"));
		logger.info("Entering job title");

		Select oSelect7 = new Select(getWebElement("TotalExperience"));
		oSelect7.selectByVisibleText("17");
		logger.info("Selecting total experience");

		// getWebElement(OR.getProperty("ExpValue")).click();

		driver.findElement(By.cssSelector(OR.getProperty("ExpValue"))).click();
		logger.info("Clicking Value ");

		Select oSelect8 = new Select(getWebElement("USAExperience"));
		oSelect8.selectByVisibleText("15");
		logger.info("Selecting USA experience");

		getWebElement("ResumeTitle").clear();

		getWebElement("ResumeTitle").sendKeys(OR.getProperty("resumetitle"));
		logger.info("Entering resume title");

		// getWebElement("Resumeupload"))).clear();
		// getWebElement("Resumeupload"))).sendKeys("D:\\workspace
		// new\\hybrid\\src\\main\\java\\Resourse\\resume.doc");
		// logger.info("Uploading resume");
		// Thread.sleep(10000);
		getWebElement("Professional").click();

		logger.info("Clicking save on professional tab");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		Select oSelect9 = new Select(driver.findElement(By.cssSelector(OR.getProperty("SpecializedArea"))));
		oSelect9.selectByVisibleText("Java, J2EE");

		// Select oSelect9 = new
		// Select(getWebElement(OR.getProperty("SpecializedArea")));
		// oSelect9.selectByVisibleText("Java, J2EE");

		logger.info("Selecting specialized area");
		Select oSelect10 = new Select(driver.findElement(By.cssSelector(OR.getProperty("SpecializedSkill"))));
		oSelect10.selectByVisibleText("Java Front End");

		// Select oSelect10 = new
		// Select(getWebElement(OR.getProperty("SpecializedSkill")));
		// oSelect10.selectByVisibleText("Java Front End");

		logger.info("Selecting specialized skills");
		getWebElement("Skill1").clear();

		getWebElement("Skill1").sendKeys(OR.getProperty("skill"));
		logger.info("Entering skill1");
		Select oSelect11 = new Select(getWebElement("Years1"));
		oSelect11.selectByVisibleText("2");
		logger.info("Selecting years for skill1 ");
		getWebElement("Skills").click();
		logger.info("Clicking save and next button");
		wait = new WebDriverWait(driver, 30);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		getWebElement("BusinessDomain").click();
		logger.info("Clicking preferred employment ");
		getWebElement("PublishToAll").click();
		logger.info("Selecting resume publishing options ");
		getWebElement("prefjob").click();
		logger.info("Selecting domain experience");
		getWebElement("Preferences").click();
		logger.info("Clicking save and next button");
		wait = new WebDriverWait(driver, 30);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		getWebElement("Keywords").clear();
		getWebElement("Keywords").sendKeys(OR.getProperty("keyword"));
		logger.info("Entering keywords ");
		getWebElement("Contarctjobtype").click();
		logger.info("Clicking job type ");
		getWebElement("Contracttype").click();
		getWebElement("Permanentjobtype").click();
		getWebElement("Jobwithtitle").clear();
		getWebElement("Jobwithtitle").sendKeys(OR.getProperty("title"));
		logger.info("Entering job with title ");

		Select oSelect12 = new Select(driver.findElement(By.id(OR.getProperty("Years"))));
		// Select oSelect12 = new Select(getWebElement("Years"));
		oSelect12.selectByVisibleText("2");

		logger.info("Selecting years");

		// driver.findElement(By.cssSelector(prop.getProperty("Yearvalue"))).click();

		getWebElement("Yearvalue").click();
		getWebElement("AlertName").clear();
		getWebElement("AlertName").sendKeys(OR.getProperty("alert"));
		logger.info("Entering alert name ");
		getWebElement("JobAlert").click();
		logger.info("Clicking save and next button end of update");
		driver.switchTo().defaultContent();
		wait = new WebDriverWait(driver, 30);
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	}

	public static void main(String[] args) throws Exception {
		TestBase.loadPropertiesFile();

		TestBase.getBrowser("chrome");
		Login.run();
		Update.updat();

	}

}
