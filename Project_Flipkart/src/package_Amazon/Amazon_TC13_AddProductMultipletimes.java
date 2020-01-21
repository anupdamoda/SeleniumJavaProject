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

public class Amazon_TC13_AddProductMultipletimes {
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
		int quantity = 5;
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
	    
	    
	    
	    
	    for (int i=0;i<quantity;i++)
	    {
	    home.flipkart_product("Jeans");
		Cart.amazon_add_product();
	    Cart.amazon_add_to_cart();
	    home.amazon_cart();
	    }
	    
	    
	    
	//    home.flipkart_product(product_name);
	    
	    Amazon_Logout_pg amazonsite_signout =PageFactory.initElements(driver,Amazon_Logout_pg.class);
		
		amazonsite_signout.amazon_accountlink();
		amazonsite_signout.amazon_signout();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
		driver.quit();
		
		}
	}


