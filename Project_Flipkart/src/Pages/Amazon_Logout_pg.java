package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Amazon_Logout_pg {
	
WebDriver driver;
public int TimeoutValue = 80;
	
	public Amazon_Logout_pg (WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
    }

	@FindBy(xpath="//*[@id=\"nav-link-yourAccount\"]/span[2]/span")
	WebElement amazon_accountlink;
	
	@FindBy(partialLinkText="Sign Out")
	WebElement amazon_signout;
	
public void amazon_accountlink()
{
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	Actions action = new Actions(driver);
    action.moveToElement(amazon_accountlink).build().perform();
}
public void amazon_signout()
	
	{
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		amazon_signout.click();
	}
	
}
