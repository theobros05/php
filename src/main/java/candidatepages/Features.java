package candidatepages;

import java.util.concurrent.TimeUnit;
import java.util.List;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.TestBase;

public class Features extends TestBase {

    public static void feature() throws Exception {
    	
    	logger = Logger.getLogger(Features.class.getName());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.switchTo().defaultContent();
        
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);

        getWebElement("features_Click").click();
        logger.info("Opening Features Tab");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        getWebElement("demandIndex").click();
        logger.info("Opening DemandIndex Tab");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.switchTo().frame("contentframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        getWebElement("profile").click();
        logger.info("clicking Profile List");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Select select = new Select(getWebElement("profile"));
        logger.info("Selecting Profile List");
        Select select1 = new Select(getWebElement("spealized"));
        logger.info("Selecting Spealized List");
        Select select2 = new Select(getWebElement("date"));
        logger.info("Selecting Date List");
        Select select3 = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ddlstate']"))));
        logger.info("Selecting state List");

        for (int i = 0; i < 1; i++) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            select.selectByIndex(i);
            logger.info("Selecting Profile List");
            for (int i1 = 0; i1 < 1; i1++) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                select1.selectByIndex(i);
                logger.info("Selecting Spealized List");
                for (int i2 = 0; i2 < 1; i2++) {
                    select2.selectByIndex(i);
                    logger.info("Selecting Date List");
                    for (int i3 = 0; i3 < 1; i3++) {

                        select3.selectByVisibleText("CA");
                        logger.info("Selecting state List");
                        getWebElement("seeresult").click();
                        logger.info("clicking Seeresult");
                        Thread.sleep(5000);
                        select3.selectByVisibleText("FL");
                        logger.info("Selecting state List");
                        getWebElement("seeresult").click();
                        logger.info("clicking Seeresult");
                        Thread.sleep(5000);
                        select3.selectByVisibleText("SC");
                        logger.info("Selecting state List");
                        getWebElement("seeresult").click();
                        logger.info("clicking Seeresult");

                        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    }
                }
            }
        }
        Thread.sleep(2000);
     /*   
        Actions action = new Actions(driver);
        getWebElement("profile").click();
        logger.info("clicking Profile List");
        List<WebElement> list = select.getOptions();
        
        for (int i = 0; i < list.size(); i++) {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
            logger.info("Listing Profile Down");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        for (int i1 = 0; i1 < list.size(); i1++) {
            action.sendKeys(Keys.ARROW_UP).build().perform();
            logger.info("Listing Profile UP");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }

        getWebElement("spealized").click();
        logger.info("Selecting Spealized List");
        List<WebElement> list1 = select1.getOptions();
        for (int j = 0; j < list1.size(); j++) {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
            logger.info("Listing Spealized Down");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        for (int j1 = 0; j1 < list1.size(); j1++) {
            action.sendKeys(Keys.ARROW_UP).build().perform();
            logger.info("Listing Spealized Up");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }

        getWebElement("date").click();
        logger.info("clicking Date List");
        List<WebElement> list2 = select2.getOptions();

        for (int k = 0; k < list2.size(); k++) {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
            logger.info("Listing Date Down");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        for (int k1 = 0; k1 < list2.size(); k1++) {
            action.sendKeys(Keys.ARROW_UP).build().perform();
            logger.info("Listing Date Up");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ddlstate']")));
        logger.info("clicking state List");
        List<WebElement> list3 = select3.getOptions();

        for (int m = 0; m < list3.size(); m++) {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
            logger.info("Listing State Down");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        for (int m1 = 0; m1 < list3.size(); m1++) {
            action.sendKeys(Keys.ARROW_UP).build().perform();
            logger.info("Listing State Up");*/
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
       Thread.sleep(5000); 
   
    }

    public static void main(String[] args) throws Exception {
        TestBase.loadPropertiesFile();
        TestBase.getBrowser("chrome");
        Login.run();
        Features.feature();
    }

}