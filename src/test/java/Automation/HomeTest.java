package Automation;



	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjectModelClass.HomePage;
import com.PageObjectModelClass.LoginPage;
import com.PageObjectModelClass.TierPage;
import com.qa.automationbaseclass.Base;
	import com.qa.utilities.Utilities;
   
	@Listeners(com.Listeners.MyListeners.class)  

	public class HomeTest extends Base {
		
		public HomeTest(){
			super();
		}
		
		public WebDriver driver;
		WebElement target;
		WebElement element1;
		WebElement element2;
		WebElement element3;
		Properties Prop;
		LoginPage loginpage;
		HomePage homepages;
		TierPage tierpages;
		
		
	     @BeforeMethod	
	     public void beforeSetUp() {
		
	    driver =initializeBrowserAndOpenApplicationURL("chrome") ;
	    loginpage = new LoginPage(driver);
	    loginpage.validUserName(prop.getProperty("validUserName"));
	    loginpage.ValidPassword(prop.getProperty("validPassword"));
	    loginpage.clickingOnLoginButton();
		

	     }
	     
	   
		
		@Test(priority=1)
		public void menuChoosing() {
			
		 homepages = new HomePage(driver);
	     homepages.clickingOnMenuButton();
	     
	     tierpages = new TierPage(driver);
	     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	     
	     
	     boolean addbuttonpresence = tierpages.presenceOfAddButton();
	     Assert.assertTrue(addbuttonpresence);
	     
	    
	    
		}

		
		@AfterMethod
		public void afterSetUp() {
			driver.quit();
		}
	}


