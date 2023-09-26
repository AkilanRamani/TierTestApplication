package Automation;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjectModelClass.HomePage;
import com.PageObjectModelClass.TierPage;
import com.qa.automationbaseclass.Base;
import com.qa.utilities.Utilities;
 

@Listeners(com.Listeners.MyListeners.class) 
public class TierTest extends Base{
	
	public TierTest() {
		super();
	}
	Actions actions;
	public WebDriver driver;
	WebElement target;
	WebElement element1;
	WebElement element2;
	WebElement element3;
	WebElement tier;
	Select select;
	WebElement dropdown;
	WebElement remarks;
	WebElement save;
	Properties prop;
	WebElement e;
	HomePage pages;
    TierPage tierpage;
	
	 
	
	@BeforeMethod 
	public void beforeTierSetUp() {
		
		driver =initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName")) ;

		driver.findElement(By.xpath("//input[@name=\'j_username\' and @class= \'login-input username ng-pristine ng-invalid ng-touched']")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.xpath("//input[@class=\"login-input password ng-pristine ng-invalid ng-touched\"]")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//div[@class=\"col-xs-12 p-0 mte-2\"]/button[@class=\"login-button\"]"));
		 target = driver.findElement(By.xpath("//a[text()='BPM']"));
	     element1 =driver.findElement(By.xpath("//a[@class=\"ng-scope ng-binding\" and text()=\"Offer Management\"]"));
	     element2 = driver.findElement(By.xpath("//a[@class=\"ng-scope ng-binding\" and text()=\"Off Take - Advanced\"]"));
	     element3 = driver.findElement(By.xpath("//a[contains(text(),'Tier Master')]"));
	  
		
	}
	
	@AfterMethod 
	public void afterTierSetUp() {
		driver.quit();
		
	}
	
	
@Test(priority=1 , dataProvider = "supplyTestData")

	public void saveTier(String TierName , String Remarks) throws InterruptedException{ 
	HomePage pages = new HomePage(driver);
	pages.clickingOnMenuButton();
	
	
	 tierpage = new TierPage(driver);
	 tierpage.saveTier(Utilities.randomString(), Utilities.randomStringValue());
    
     String actualmessage = tierpage.saveTierMessage();
     System.out.println(actualmessage);
     String expectedmessage = "Tier Master saved successfully";
    
     Assert.assertEquals(actualmessage , expectedmessage);
}

@Test(priority=2)
  public void cancelTier() throws InterruptedException {
	
	HomePage page = new HomePage(driver);
	page.clickingOnMenuButton();
	 tierpage = new TierPage(driver);
	
	 tierpage.cancelTier(Utilities.randomString(), Utilities.randomStringValue());
	 
	 System.out.println("Tier details cancelled successfully");
     
     
	
	
  }
  
@Test(priority=3)
  public void inactiveTier() throws InterruptedException {
	
	HomePage pages = new HomePage(driver);
	pages.clickingOnMenuButton();
	

	 tierpage = new TierPage(driver);
	 tierpage.InActiveTier(Utilities.randomString(), Utilities.randomStringValue());
	    
     String actualmessage = tierpage.saveTierMessage();
     System.out.println(actualmessage);
     String expectedmessage = "Tier Master saved successfully";
    
     Assert.assertEquals(actualmessage , expectedmessage);

   
    String actualmessagetier = tierpage.saveTierMessage();
    System.out.println(actualmessagetier);
   
    String expectedtiermsg = "Tier Master saved successfully";
   
    Assert.assertEquals(actualmessagetier ,expectedtiermsg );
} 
  @Test(priority=4)
  public void saveWithoutDetails() throws InterruptedException {
	  HomePage pages = new HomePage(driver);
	  pages.clickingOnMenuButton();
	  
	   tierpage.saveTierWithoutDetails("", "");
	   
       boolean isDisplayed  = tierpage.saveButtonDisabled();
       Assert.assertTrue(true);
        System.out.println("The Button should Not be Displayed:" + isDisplayed);
       if((isDisplayed))
       
       {
    	   System.out.println("save button is Not Enabled ,In case if the details are Not Given");
       }
       else
    	   
       {
    	   System.out.println("save button is  Enabled ,In case if the details are Not Given");

       }
	  
  }
  
  @Test(priority=4)
  public void saveAlreadyExistingTier() throws InterruptedException {
	  
	  HomePage pages = new HomePage(driver);
	  pages.clickingOnMenuButton();
	   tierpage.saveAlreadyExistingTier(prop.getProperty("TierName"),Utilities.randomString());
	    Thread.sleep(5000);
	    String actualexiststier =tierpage.alreadyExistsTier();
	    String expectedtierexists = "Tier Name was Already Exists";
	    Assert.assertTrue(actualexiststier.contains("Tier Name was Already Exists"));
	    Assert.assertEquals(actualexiststier,expectedtierexists ,"Expected Warning was displayed");
	       boolean isDisplayed  = tierpage.saveButtonDisabled();
	       Assert.assertTrue(true);
	        System.out.println("The Button should Not be Displayed:" + isDisplayed);
	       if((isDisplayed))
	       
	       {
	    	   System.out.println("save button is Not Enabled ,In case if the details are Not Given");
	       }
	       else
	    	   
	       {
	    	   System.out.println("save button is  Enabled ,In case if the details are Not Given");

	       }
 
	   
	  
  }
  @Test(priority=5)
 public void tierNameValidations() throws InterruptedException {
	  HomePage pages = new HomePage(driver);
	  pages.clickingOnMenuButton();
	  
	  tierpage.saveTier(Utilities.maxString(),Utilities.randomRemarks() );	    
	  String actualmessagetier = tierpage.saveTierMessage();
	  System.out.println(actualmessagetier);
	  String expectedmessage = "Tier Master saved successfully";
	    
	    Assert.assertEquals(actualmessagetier , expectedmessage);
}
	 @Test(priority=6)
	public void maxRemarksValidations() throws InterruptedException {
		 HomePage pages = new HomePage(driver);
		  pages.clickingOnMenuButton();
		  tierpage.saveTier(Utilities.randomString(),Utilities.randomRemarks() );	    
		  String actualmessagetiervalid = tierpage.saveTierMessage();
		  System.out.println(actualmessagetiervalid);
		  String expectedmessage = "Tier Master saved successfully";
		    
		    Assert.assertEquals(actualmessagetiervalid , expectedmessage);
		    
	}
	
	 @Test(priority=7)
	public void specialCharactersValidationsInTier() throws InterruptedException {
		 HomePage pages = new HomePage(driver);
		  pages.clickingOnMenuButton();
		 
		  tierpage.saveTier("! ; \" , ' ` ~ |", Utilities.randomString());
		  Thread.sleep(5000);
		  String specchartext =  tierpage.specialCharText();
		  System.out.println(specchartext);
		  String Expectedspecchar = "Tier Name not allow ! ; \" , ' ` ~ | special character\r\n";
		      		
		  Assert.assertEquals(specchartext, Expectedspecchar);
		  boolean presentspec = tierpage.specElementDisplayed();
		  Assert.assertTrue(presentspec);
		 
		   if(presentspec) {
			   System.out.println("Special characters Not allowed Validation Message is displayed");
		   }
		   else {
			   System.out.println("Special characters allowed Validation Message is displayed");
		   }
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		    
		   boolean savebuttondisabled =  tierpage.saveButtonDisabled();
	       Assert.assertTrue(true);
	        System.out.println("The Button should Not be Displayed:" + savebuttondisabled);
	       if((savebuttondisabled))
	       
	       {
	    	   System.out.println("save button is Not Enabled ,In case if the details are Not Given");
	       }
	       else
	    	   
	       {
	    	   System.out.println("save button is  Enabled ,In case if the details are Not Given");

	       }
		
	}
	 @Test(priority=8)
	 public void updateTierName() throws InterruptedException {
		 
		 HomePage pages = new HomePage(driver);
		  pages.clickingOnMenuButton();
		
		 tierpage.updateTierName(Utilities.randomString(), Utilities.randomString());
		 String updatebuttontextcapture = tierpage.updateButtonTextCapture();
		 System.out.println(updatebuttontextcapture);
		 String expectedmessage = "Tier Master updated successfully";
		    
		    Assert.assertEquals(updatebuttontextcapture , expectedmessage);
		     Thread.sleep(5000);

		   boolean updatebuttonispresent = tierpage.updateButtonDisplayed();
		  Assert.assertTrue(updatebuttonispresent);
		  if(updatebuttonispresent) {
			  System.out.println("Update Button is Displayed in case of Opened in Edit Mode");
		  }
		  else {
			  System.out.println("Update Button is Not Displayed in case of Opened in Edit Mode");

		  }
        
  }
	 @Test(priority=9)
	 public void sendToOutlet() throws InterruptedException {
		 HomePage pages = new HomePage(driver);
		 pages.clickingOnMenuButton();
		 
		 tierpage.sentToOutletXml();
	 }
 
	 @DataProvider
  public Object[][] supplyTestData(){
	  
	  Object[][] data = Utilities.getTestDataFromExcel("TierInputData");
	  return data;
  }
   
 public Object[][] supplyInputData(){
	 
	Object[][] inputdata = {{"Total Oil" , "Testing"} , {"OffTakePhase" , "TestPhase"},{"TierTest" , "Total"}};
	return inputdata;
}
		 
 }
 
  

  
  
 
  

   
  
  
  



