package com.qa.utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnElement(WebElement element ,long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public void typeTextIntoElement(WebElement element ,String textToType ,long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		element.clear();
		element.sendKeys(textToType);
		
	}
   public WebElement waitForAnElement(WebElement Webelement ,long durationInSeconds) {
	   WebElement Webelementwait = null;
	   
	   try{WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
	 Webelementwait =	wait.until(ExpectedConditions.elementToBeClickable(Webelement));
	   }
	   catch(Throwable e) {
		   e.printStackTrace();
	   }
	   return Webelementwait;
	   
	   
   }
  public void selectOptinInDropDown(WebElement element , String dropdownoption,long durationInSeconds ) {
	WebElement web =waitForAnElement( element , durationInSeconds);
	Select select = new Select (web);
	select.selectByVisibleText(dropdownoption);
	 
  }
  public void acceptAlert() {
	  
	  Alert alert = waitForAlert(10);
	  alert.accept();
	  
	  
  }
  
  public void dismissAlert() {
	  
	  Alert alert = waitForAlert(10);
	  alert.dismiss();
	  
  }
  public Alert waitForAlert(long durationInSeconds) {
	  
	  Alert alert = null;
	  try {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
      alert = wait.until(ExpectedConditions.alertIsPresent());
		 	
  }
	  catch(Throwable e) {
		  e.printStackTrace();
	  }
	return alert;
	  
}
  public void mouseHoverAndClick(WebElement element , long DurationInSeconds) {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationInSeconds));
      WebElement elementwaiting = wait.until(ExpectedConditions.visibilityOf(element));
      Actions actions = new Actions(driver);
      actions.moveToElement(elementwaiting).click().build().perform();
	  
  }
  public WebElement waitForVisibility(WebElement element , long DurationInSeconds) {
	  WebElement Webelementwait = null;
	   
	   try{WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationInSeconds));
	 Webelementwait =	wait.until(ExpectedConditions.visibilityOf(element));
	   }
	   catch(Throwable e) {
		   e.printStackTrace();
	   }
	   return Webelementwait;
  }
  public void javaScriptClick(WebElement element , long DurationInSeconds) {
	 WebElement visiblewait = waitForVisibility(element , DurationInSeconds);
	 JavascriptExecutor jse = ((JavascriptExecutor)driver);
	 jse.executeScript("arguments[0].click();", visiblewait);
	  
  }
  public void javaScriptType(WebElement element , String textToTyped ,long DurationInSeconds) {
		 WebElement visiblewait = waitForVisibility(element , DurationInSeconds);
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
		 jse.executeScript("arguments[0].value = '"+textToTyped+"'", visiblewait);
  }
  
  
  
  }