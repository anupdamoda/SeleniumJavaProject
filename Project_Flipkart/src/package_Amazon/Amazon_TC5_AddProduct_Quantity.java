package package_Amazon;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Amazon_Homepage;
import Pages.Amazon_Login_pg;
import Pages.Amazon_Logout_pg;
import Pages.Amazon_ShoppingCart_pg;

public class Amazon_TC5_AddProduct_Quantity {
	
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
	
	public void addproduct_quantity()
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
	
	
    Amazon_Homepage Click_cart =PageFactory.initElements(driver,Amazon_Homepage.class);
	
    Click_cart.amazon_cart();
    Click_cart.flipkart_product("Toys");
	
    Amazon_ShoppingCart_pg add_product =PageFactory.initElements(driver,Amazon_ShoppingCart_pg.class);
    
	add_product.amazon_add_product();
	add_product.amazon_quantity(2);
	
	add_product.amazon_add_to_cart();
	
	Amazon_Logout_pg amazonsite_signout =PageFactory.initElements(driver,Amazon_Logout_pg.class);
	
	amazonsite_signout.amazon_accountlink();
	
	amazonsite_signout.amazon_signout();
	
	driver.close();
	driver.quit();
	
	}
}
