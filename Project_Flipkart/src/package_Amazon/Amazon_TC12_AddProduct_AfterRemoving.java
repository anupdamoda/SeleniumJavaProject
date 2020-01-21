/**
 * 
 */
package package_Amazon;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Amazon_Homepage;
import Pages.Amazon_Login_pg;
import Pages.Amazon_Logout_pg;
import Pages.Amazon_ShoppingCart_pg;

/**
 * @author ANUP
 *
 */

public class Amazon_TC12_AddProduct_AfterRemoving {
	
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
	public void addProduct_Afterremoving()
	{
		
		System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Amazon_Login_pg login_page= PageFactory.initElements(driver,Amazon_Login_pg.class);
		
		login_page.flipkart_login("anup.damoda@gmail.com","starwars1");
	    
	    Amazon_Homepage home = PageFactory.initElements(driver, Amazon_Homepage.class);
	    home.amazon_cart();
	    
	    
	    Amazon_ShoppingCart_pg Cart = PageFactory.initElements(driver, Amazon_ShoppingCart_pg.class);
	    String Product_name = Cart.amazon_getproductname_cart();
	    Cart.remove_cart();
	    
	    home.flipkart_product(Product_name);
	//    Cart.amazon_add_specific_product_name();
	    
	    // Store the current window handle
	    String winHandleBefore = driver.getWindowHandle();

	    // Perform the click operation that opens new window
	    Cart.amazon_add_specific_product_name();

	    // Switch to new window opened
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }
	        // Perform the actions on new window
		    
		    Cart.amazon_add_to_cart();
		    
		    // Close the new window, if that window no more required
		    driver.close();
		   
		    // Switch back to original browser (first window)
		    driver.switchTo().window(winHandleBefore);
	    
	    
	home.amazon_cart();
	   
	    
	    Amazon_Logout_pg amazonsite_signout =PageFactory.initElements(driver,Amazon_Logout_pg.class);
		
		amazonsite_signout.amazon_accountlink();
		amazonsite_signout.amazon_signout();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	//	driver.quit();
		
		}
	}

