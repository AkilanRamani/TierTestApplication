package Automation;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjectModelClass.HomePage;
import com.PageObjectModelClass.LoginPage;
import com.qa.automationbaseclass.Base;
import com.qa.utilities.Utilities;

@Listeners(com.Listeners.MyListeners.class) 

public class LoginTest extends Base  {
	
	public LoginTest() {
		super();
		
	}
	
	public WebDriver driver;
	public Properties prop;
	LoginPage page;
	HomePage pages ;
	
	@BeforeMethod
	public void setUp() {
		
		driver =initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName")) ;
        
	}
   
	@AfterMethod
	public void tearDown() 
	
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyLoginWithValidCredentials() {
		
	    page = new LoginPage(driver);
		page.clickOnUserButton();
		page.clickOnPasswordButton();
		page.clickOnLoginButton();
		
	    HomePage pages = new HomePage(driver);
	   boolean elementframe = pages.actualSalesIsPresent();
	   Assert.assertTrue(elementframe);
	    boolean menustatus =  pages.getDisplayStatusOfParentMenu();
	    Assert.assertTrue(menustatus , "BPM Menu is Displayed");
	}
  
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		
		page = new LoginPage(driver);
        page.clickOnUserName();
        page.clickOnPasswordButton1();
        page.clickOnLogin();
		
        String messagenotmatching = page.usernamePassNotMatching();
		String expectedmessage = "Invalid Username or Password";
		Assert.assertTrue(messagenotmatching.contains(expectedmessage), "Expected warning is displayed");
		
		
		
	}
   @Test(priority=3)
	public void verifyLoginWithInvalidUsernameAndValidPassword() {
		
		
		page = new LoginPage(driver);
		page.invalidUsername(Utilities.maxString());
		page.invalidPass(prop.getProperty("validPassword"));
		page.loginClick();
		
		String messagenotmatching = page.usernamePassNotMatching();
		String expectedmessage = "Invalid Username or Password";
		Assert.assertTrue(messagenotmatching.contains(expectedmessage), "Expected warning is displayed");
		
	}
	@Test(priority=4)
	public void verifyLoginWithValidUsernameAndInvalidPassword() {
		
		page = new LoginPage(driver);
		page.invalidUsername(prop.getProperty("validUserName"));
		page.invalidPass(Utilities.randomString());
		page.loginClick();
		String messagenotmatching = page.usernamePassNotMatching();
		String expectedmessage = "Invalid Username or Password";
		Assert.assertTrue(messagenotmatching.contains(expectedmessage), "Expected warning is displayed");
		
		
	}
	@Test(priority=5)
	public void verifyLoginWithNoDetails() {
		 page = new LoginPage(driver);
		 page.invalidUsername("");
		 page.invalidPass("");
		 page.loginClick();
				
		
		String namenecess = page.userNameRequired();
		String expectedname = "Username is required";
		
		Assert.assertEquals(namenecess.contains(expectedname),"Username is required");
		
	   String passnecess = page.passWordRequired();
	   String expectedpass = "Password is required";
	   Assert.assertTrue(passnecess.contains(expectedpass));
	   


}
	
	
	
}
	

	



	
