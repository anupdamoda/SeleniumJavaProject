package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_Login_pg {
	
	
	WebDriver driver;
	public int TimeoutValue = 140;
	
	public Amazon_Login_pg (WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
    }
	

	@FindBy(xpath="//*[@id=\"nav-link-yourAccount\"]/span[2]/span")
	WebElement amazon_loginbutton;
	
	//@FindBy(xpath="//*[@id=\"nav-flyout-ya-signin\"]/a/span")
	WebElement amazon_Signinbutton;
	
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement amazon_username;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	WebElement amazon_continuebutton;
	
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	WebElement amazon_password;
	
	@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	WebElement amazon_Loginsubmitbutton;
	
	
	
	
	public void flipkart_login(String uid,String pwd)
	
	{
		
	//	amazon_loginbutton.click();
		
		Actions action = new Actions(driver);
	    action.moveToElement(amazon_loginbutton).build().perform();
	    WebDriverWait wait = new WebDriverWait(driver,200);
	    amazon_Signinbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")));
	   
	   
		amazon_Signinbutton.click();
		amazon_username.sendKeys(uid);
		amazon_continuebutton.click();
	    amazon_password.sendKeys(pwd);
		amazon_Loginsubmitbutton.click();
		
	}

	
	
}
