package com.qa.utilities;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtilities {
	
	public static void main(String[] args) throws AWTException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("www.google.com");
		
		WebElement web = driver.findElement(By.xpath(""));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(web).build().perform();
		
		WebElement web1 = driver.findElement(By.xpath(""));
		
		    actions.moveToElement(web1).click().build().perform(); 
			actions.moveToElement(web1).build().perform();

		    //actions.click().perform();
			
			//drag and Drop 
			WebElement webele = driver.findElement(By.xpath("")); //web element that needs to be dragged 

			
			actions.dragAndDropBy(webele, 200, 0).build().perform(); //Move to Right hand side in a Horizontal way
			actions.dragAndDropBy(webele, -50, 0).build().perform(); //Move to left hand side in a Horizontal way

			WebElement webele1 = driver.findElement(By.xpath(""));
			Actions actions1 = new Actions(driver);
			actions1.contextClick(webele1).build().perform(); //Right click
			
			//Performing Double click 
			WebElement webele32 = driver.findElement(By.xpath(""));
			Actions actions12 = new Actions(driver);
			actions12.doubleClick(webele32).build().perform(); 
			
			//Drag and Drop 
			WebElement webele12 = driver.findElement(By.xpath(""));
			
			
			//Performing Double click 
			WebElement webele321 = driver.findElement(By.xpath(""));
			Actions actions123 = new Actions(driver);
			//actions123.clickAndHold(webele12).moveToElement(webele321).release().build().perform();
			actions123.dragAndDrop(webele12, webele321).build().perform();
			
			
			//clicking the link(hyper link)
			WebElement webele3213 = driver.findElement(By.xpath(""));
			Actions actions121 = new Actions(driver);
			actions121.moveToElement(webele3213).click().build().perform();
			
			//opening the links in a new window Tab by Pressing Ctrl Button on KeyBoard and clicking action using Mouse 
			WebElement ele = driver.findElement(By.xpath(""));
			Actions act = new Actions(driver);
			act.keyDown(Keys.CONTROL).moveToElement(ele).click().keyUp(Keys.CONTROL).build()
			.perform();
			
			//Resizing using Drag and Drop by
			
			WebElement we = driver.findElement(By.xpath(""));
			//If it is inside the Frame ,Switch to Frame Element in a Web Page First 
			
			driver.switchTo().frame(we);
			Actions a = new Actions(driver);
			WebElement we1 = driver.findElement(By.xpath(""));
			
			//actions123.clickAndHold(webele12).moveToElement(webele321).release().build().perform();
			a.dragAndDropBy(we1, 100, 200).build().perform();
			
			//Right click actions Performing 
			WebElement rightclick = driver.findElement(By.xpath(""));
			Actions atn = new Actions(driver);
			atn.contextClick(rightclick).build().perform();
			
			WebElement quitoption = driver.findElement(By.xpath(""));
			atn.click(quitoption).build().perform();
			
			//Handling Alert
		Alert alert =	driver.switchTo().alert();
		 String alertmsg = alert.getText();
		 System.out.println(alertmsg);
		 alert.accept();
		 
		 //Tab Key using and Moving to Next Field (input Field)
		 WebElement sendkeys = driver.findElement(By.xpath(""));
		 sendkeys.sendKeys("asdfgh");
		 Actions ns = new Actions(driver);
		 ns.sendKeys(Keys.TAB).sendKeys("fghj").sendKeys(Keys.TAB).
		 sendKeys(Keys.SPACE).sendKeys(Keys.TAB).
		 sendKeys(Keys.ENTER).build().perform();
		 
		 //pause action 
		 ns.sendKeys("fghj").sendKeys(Keys.TAB).pause(Duration.ofSeconds(10)).sendKeys("xxyy");
		 
		 
			
			
		
		
	}	

}
