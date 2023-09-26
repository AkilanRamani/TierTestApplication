package com.PageObjectModelClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TierPage {
	
	WebDriver driver;
	String tiervalue;
	String remrarkstier;
	Select selecttier;
	Properties prop;
	@FindBy(xpath="\"//button[contains(text(), \\\"Add\\\")]\")")
	private WebElement addbutton;
	
	@FindBy(xpath="\"//div[@class= \\\"mat-form-field-infix\\\"]//input[@placeholder=\\\"Tier Name\\\"]\")   ")
    private  WebElement tiername ;
	 
	@FindBy(xpath = "\"//div[@class=\\\"mat-select-value\\\"]\") ")
	private WebElement select;
	
	@FindBy(xpath = " \"//div[@class= \\\"mat-form-field-infix\\\"]//textarea\")")
	private WebElement remarksfield;
	
	@FindBy(xpath = "\"//button[contains(@class ,\\\"save-button mat-flat-button mat-primary\\\")]//span[@class=\\\"mat-button-wrapper\\\" and text()='Save']\")  ")
	private WebElement savebutton;
	
	@FindBy(xpath = "\"div[contains(text() ,\\\"Tier Master saved successfully\\\")]\") ")
	private WebElement tiersavemsg;
	
	@FindBy(xpath = "\"//button[@class=\\\"cancel-button mat-stroked-button\\\"]//span[@class=\\\"mat-button-wrapper\\\" and text() = \\\"Cancel\\\"]\") ")
	private WebElement canceltier;
	
	@FindBy(xpath = "\"//span[@class=\\\"ng-tns-c12-9\\\" and text() = \\\"Tier Name was Already Exists\\\"]\") ")
	private WebElement existsTier;
	
	@FindBy(xpath = "\"//mat-error[@class=\\\"mat-error ng-star-inserted\\\"]\") ")
	private WebElement specchar;
	
	@FindBy(xpath = "\"//button[contains(text(),'Send to Outlet')]\") ")
	private WebElement sendoutlet;
	
	@FindBy(xpath = "\"//iframe[@class=\\\"ng-scope logout-frame-inactive\\\"]\") ")
	private WebElement framewindow;
	
	@FindBy(xpath = "\"//a[@href=\\\"javascript:popUp_parm('/RayMedi_HQ/ngx-offers-client/index.html#/off-take/tier-master?tierId=1','500','400','200','200')\\\"]//img\")); ")	
	private WebElement editbutton;
	
	@FindBy(xpath = " \"//button[@class=\\\"save-button mat-flat-button mat-primary\\\"]//span[@class=\\\"mat-button-wrapper\\\" and text()=\\\"Update\\\"]\")")
	private WebElement updatebutton;
	
	@FindBy(xpath = " \"//div[@class=\\\"cdk-live-announcer-element cdk-visually-hidden\\\" and text() = \\\"Tier Master updated successfully\\\"]\")")
	private WebElement updatemessage;
	
	public TierPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnAddButton() {
		driver.switchTo().frame(framewindow);
		addbutton.click();
	}
	public void clickOnSendToOutletButton() {
		driver.switchTo().frame(framewindow);
		sendoutlet.click();
	}
	
	public boolean addButtonExists() {
		WebDriver driverframe = driver.switchTo().frame(framewindow);
		boolean addbuttonpresence = addbutton.isDisplayed();
		return addbuttonpresence;
	}
	
	public void saveTier(String tiervalue ,String remrarkstier) throws InterruptedException
 {
		String parent=driver.getWindowHandle();

		driver.switchTo().frame(framewindow);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	    WebElement addclick =  wait.until(ExpectedConditions.visibilityOf(addbutton));
	    addclick.click();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		driver.manage().window().maximize();

		
		System.out.println(driver.switchTo().window(child_window).getTitle());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		tiername.clear();
		tiername.click();
		tiername.sendKeys(tiervalue);
		selecttier = new Select(select);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selecttier.selectByVisibleText("Active");
	    remarksfield.clear();
		remarksfield.click();
		remarksfield.sendKeys(remrarkstier);
		savebutton.click();
		driver.close();
		}
		}
		
		driver.switchTo().window(parent);
		Thread.sleep(3000);
 }
	public String saveTierMessage() {
		String savetiermessage = tiersavemsg.getText();
		return savetiermessage;
		
	}
	public void cancelTier(String tiervalue ,String remrarkstier) throws InterruptedException {
		
		String parent=driver.getWindowHandle();

		driver.switchTo().frame(framewindow);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	    WebElement addclick =  wait.until(ExpectedConditions.visibilityOf(addbutton));
	    addclick.click();
	    Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		driver.manage().window().maximize();

		
		System.out.println(driver.switchTo().window(child_window).getTitle());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		tiername.clear();
		tiername.click();
		tiername.sendKeys(tiervalue);
		selecttier = new Select(select);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selecttier.selectByVisibleText("Active");
	    remarksfield.clear();
		remarksfield.click();
		remarksfield.sendKeys(remrarkstier);
		savebutton.click();
		driver.close();
		}
		
		
		driver.switchTo().window(parent);
		Thread.sleep(3000);
	}
	}
	public void InActiveTier(String tiervalue ,String remrarkstier) throws InterruptedException
	 {
		
		    String parent=driver.getWindowHandle();

			driver.switchTo().frame(framewindow);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		    WebElement addclick =  wait.until(ExpectedConditions.visibilityOf(addbutton));
		    addclick.click();
		    Set<String>s=driver.getWindowHandles();

			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			driver.manage().window().maximize();

			
			System.out.println(driver.switchTo().window(child_window).getTitle());
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			tiername.clear();
			tiername.click();
			tiername.sendKeys(tiervalue);
			selecttier = new Select(select);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selecttier.selectByVisibleText("InActive");
		    remarksfield.clear();
			remarksfield.click();
			remarksfield.sendKeys(remrarkstier);
		    
			
			
		}
			driver.switchTo().window(parent);
			Thread.sleep(3000);
		}
	 }
			
	public void saveTierWithoutDetails(String tiervalue ,String remrarkstier) throws InterruptedException
	 {
	    String parent =driver.getWindowHandle();

		driver.switchTo().frame(framewindow);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	    WebElement addclick =  wait.until(ExpectedConditions.visibilityOf(addbutton));
	    addclick.click();
	    
	  
	    Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		driver.manage().window().maximize();

		
		System.out.println(driver.switchTo().window(child_window).getTitle());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		tiername.clear();
		tiername.click();
		tiername.sendKeys(tiervalue);
		selecttier = new Select(select);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selecttier.selectByVisibleText("Active");
	    remarksfield.clear();
		remarksfield.click();
		remarksfield.sendKeys(remrarkstier);
		Thread.sleep(5000);
	    
		
		
	}
		driver.switchTo().window(parent);
		Thread.sleep(3000);
	}
	 }
	    

	public boolean saveButtonDisabled() {
		boolean savedisable = savebutton.isDisplayed();
		return savedisable;
		
	}
	public void saveAlreadyExistingTier(String tiervalue ,String remrarkstier) throws InterruptedException
			 {
	    String parent =driver.getWindowHandle();
        
		
		driver.switchTo().frame(framewindow);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	    WebElement addclick =  wait.until(ExpectedConditions.visibilityOf(addbutton));
	    addclick.click();
	    Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		driver.manage().window().maximize();

		
		System.out.println(driver.switchTo().window(child_window).getTitle());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		tiername.clear();
		tiername.click();
		tiername.sendKeys(tiervalue);
		selecttier = new Select(select);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selecttier.selectByVisibleText("Active");
	    remarksfield.clear();
		remarksfield.click();
		remarksfield.sendKeys(remrarkstier);
		savebutton.click();
		driver.close();
		}
		}
		
		driver.switchTo().window(parent);
		Thread.sleep(3000);
 }
	    
	    

	

	public String alreadyExistsTier() {
		String existstiermessage = existsTier.getText();
		return existstiermessage;
		
	}
	
		public String specialCharText() {
		String charvalid =	specchar.getText();
		return charvalid;
		}
		
		public boolean specElementDisplayed() {
		boolean spec =	specchar.isDisplayed();
		return spec;
	
			
		}
		
		public String saveButtonMessage() {
		String saveTierMessage =	tiersavemsg.getText();
		return saveTierMessage;
		}
		public void updateTierName(String tiervalue ,String remrarkstier) throws InterruptedException
		 {
		    String parent=driver.getWindowHandle();

			
			driver.switchTo().frame(framewindow);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		    WebElement addclick =  wait.until(ExpectedConditions.visibilityOf(addbutton));
		    addclick.click();
			
			Set<String>s=driver.getWindowHandles();

			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			driver.manage().window().maximize();

			
			System.out.println(driver.switchTo().window(child_window).getTitle());
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			tiername.clear();
			tiername.click();
			tiername.sendKeys(tiervalue);
			selecttier = new Select(select);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selecttier.selectByVisibleText("Active");
		    remarksfield.clear();
			remarksfield.click();
			remarksfield.sendKeys(remrarkstier);
			savebutton.click();
			driver.close();
			}
			}
			
			driver.switchTo().window(parent);
			Thread.sleep(3000);
	 
			driver.switchTo().frame(framewindow);
			Actions edit = new Actions(driver);
			edit.moveToElement(editbutton).doubleClick();
			Set<String>set=driver.getWindowHandles();

			// Now iterate using Iterator
			Iterator<String> Iterator1= s.iterator();

			while(I1.hasNext())
			{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			driver.manage().window().maximize();

			
			System.out.println(driver.switchTo().window(child_window).getTitle());
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			tiername.clear();
			tiername.click();
			tiername.sendKeys(tiervalue);
			selecttier = new Select(select);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selecttier.selectByVisibleText("Active");
		    remarksfield.clear();
			remarksfield.click();
			remarksfield.sendKeys(remrarkstier);
			updatebutton.click();
			driver.close();
			}
			}
			
			driver.switchTo().window(parent);
			Thread.sleep(3000);
	 }

			
		public boolean updateButtonDisplayed() {
			boolean updatebuttondisdisplayed = updatebutton.isDisplayed();
			return updatebuttondisdisplayed;
			
		}
		
		public String updateButtonTextCapture() {
				String updatetiermessage = updatemessage.getText();
				return updatetiermessage;
		}
		
		public void sentToOutletXml() throws InterruptedException {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			driver.switchTo().frame(framewindow);
			WebDriverWait outletbutton = new WebDriverWait(driver, Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		    WebElement outletbuttonvisible =  outletbutton.until(ExpectedConditions.visibilityOf(sendoutlet));
			outletbuttonvisible.click();
			
			WebDriverWait waitforalert = new WebDriverWait(driver, Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			waitforalert.until(ExpectedConditions.alertIsPresent());
			
			Alert alert = driver.switchTo().alert();
			String alerttext = alert.getText();
			System.out.println(alerttext);
			Thread.sleep(3000);
			Alert alert1 = driver.switchTo().alert();
			String alertmessage = alert1.getText();
			System.out.println(alertmessage);
			alert.accept();
			
			
		}
		public boolean presenceOfAddButton() {
		boolean addbuttonenabled=	addbutton.isDisplayed();
		return addbuttonenabled;
		}
}
		
	/*	public void windowHandles() throws InterruptedException {
			
			String parent=driver.getWindowHandle();

			Set<String>s=driver.getWindowHandles();

			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			
			System.out.println(driver.switchTo().window(child_window).getTitle());

			driver.close();
			}

			}
			Thread.sleep(3000);
			//switch to the parent window
			driver.switchTo().window(parent);

			}
			} */
			
