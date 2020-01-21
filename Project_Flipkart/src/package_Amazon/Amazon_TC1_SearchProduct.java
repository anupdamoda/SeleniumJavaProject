package package_Amazon;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Pages.Amazon_Homepage;
import Pages.Amazon_Login_pg;
import Pages.Amazon_Logout_pg;
import Pages.Amazon_ShoppingCart_pg;
import package_Database.ConnectToMySQL_Fetch_Login_Credentials;
import package_Database.ConnectToMySQL2_Insert_Output_DB;



public class Amazon_TC1_SearchProduct {
	
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
	public void aSearchProduct() throws ClassNotFoundException, SQLException
	{
		
		
		
//		logger = extent.startTest("Test Name","Description");
		System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.get("https://amazon.in");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		ConnectToMySQL_Fetch_Login_Credentials login = new ConnectToMySQL_Fetch_Login_Credentials();
		String credentials[] = login.login_credentials();
		
		 // Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		 
		 //get current date time with Date()
		Date date = new Date();
		 
		 // Now format the date
		String date1= dateFormat.format(date);
		
		Amazon_Login_pg login_page= PageFactory.initElements(driver,Amazon_Login_pg.class);
		login_page.flipkart_login(credentials[0],credentials[1]);
		
		Amazon_Homepage search_product =PageFactory.initElements(driver,Amazon_Homepage.class);
		
		search_product.flipkart_product("Pen");
		
		Amazon_ShoppingCart_pg Cart = PageFactory.initElements(driver, Amazon_ShoppingCart_pg.class);
	    String Product_name = Cart.amazon_getproductname_search();
	    String Product_price = Cart.amazon_getproductprice_search();
	    
	    Assert.assertNotNull(Product_name);
	    
	    /*
		 The below two lines handles the single quotes in values that is inserted into mySQL - works perfectly fine
		 */
		String Product_name_substring = Product_name;
		String Product_name_updated = StringUtils.substringBefore(Product_name_substring, "'");
	    
	    String[] output = {"anyvalue","anyvalue","anyvalue","anyvalue","anyvalue","anyvalue","anyvalue","anyvalue"};
	    
	    output[0]="Amazon_0001";
	    output[1]="Pen";
	    output[2]=Product_name_updated;
	    output[3]=null;
	    output[4]=Product_price;
	    output[5]=null;
	    output[6]=null;
	    output[7]=date1;
	    
	    
	    ConnectToMySQL2_Insert_Output_DB db_output = new ConnectToMySQL2_Insert_Output_DB();
		db_output.test_output(output);
	    
		
		
		Amazon_Logout_pg amazonsite_signout =PageFactory.initElements(driver,Amazon_Logout_pg.class);
		
		amazonsite_signout.amazon_accountlink();
		amazonsite_signout.amazon_signout();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
		driver.quit();
	}
	
	
	
	
	

}
