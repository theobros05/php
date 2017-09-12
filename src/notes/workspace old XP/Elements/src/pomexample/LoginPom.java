package pomexample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPom {

WebDriver driver;
	
By username=By.xpath("//html/body/form/table/tbody/tr[1]/td[2]/input");
By password=By.xpath("//html/body/form/table/tbody/tr[2]/td[2]/input");
By submit=By.xpath("//html/body/form/table/tbody/tr[3]/td[2]/input[1]");

 public LoginPom(WebDriver driver)
 
   {    
    	this.driver=driver;
   }

 public void userlogin()

    {
    	
	driver.findElement(username).sendKeys("mngr86153");
    }
   
 public void passwordtype()

    {
    	driver.findElement(password).sendKeys("EsunenU");
    }

public void clicksubmitbutton()

    {
driver.findElement(submit).click();	
    }
}
