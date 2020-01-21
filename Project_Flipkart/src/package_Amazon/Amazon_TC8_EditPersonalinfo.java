

/**
 * @author ANUP
 *
 */
package package_Amazon;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Amazon_Account_pg;
import Pages.Amazon_Homepage;
import Pages.Amazon_Login_pg;
import Pages.Amazon_Logout_pg;




public class Amazon_TC8_EditPersonalinfo {
     
	@BeforeMethod
	public void killbrowsers()
	{
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void editpersonalinfo()
	{
	System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.get("https://www.amazon.in");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Amazon_Login_pg login_page= PageFactory.initElements(driver,Amazon_Login_pg.class);
	
	login_page.flipkart_login("anup.damoda@gmail.com","starwars1");
	
	Amazon_Homepage account_link =PageFactory.initElements(driver,Amazon_Homepage.class);
	
	account_link.account_link();
	
    Amazon_Account_pg edit_personal =PageFactory.initElements(driver,Amazon_Account_pg.class);
	
    edit_personal.amazon_editpersonalinfo();
	
	Amazon_Logout_pg amazonsite_signout =PageFactory.initElements(driver,Amazon_Logout_pg.class);
	
	amazonsite_signout.amazon_accountlink();
	amazonsite_signout.amazon_signout();
	
	driver.close();
	driver.quit();
	
	}
	

}
