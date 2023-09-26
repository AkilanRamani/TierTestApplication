package com.PageObjectModelClass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.Utilities;

public class HomePage {
	
	Properties prop;
	WebDriver driver;
	WebDriver driver1;
	WebElement framePage;
	
	
	 
	@FindBy(xpath= "//a[text()='BPM']\"")
	private WebElement parent;
	
	@FindBy(xpath = "\"//a[@class=\\\"ng-scope ng-binding\\\" and text()=\\\"Offer Management\\\"]")
    private WebElement child;
	
	@FindBy(xpath=" \"//a[@class=\\\"ng-scope ng-binding\\\" and text()=\\\"Off Take - Advanced\\\"]\")")
	private WebElement child1;
	
	@FindBy(xpath = "\"//a[contains(text(),'Tier Master')]\")")
	private WebElement subchild;
	
	@FindBy(xpath= " //iframe[@class=\"ng-scope logout-frame-inactive\"]")
	WebElement frame;
	
	@FindBy(xpath = " //div[@class=\"title-container\"]//span[@class=\"ng-tns-c0-0\" and text()=\"Actual Sales - Excl.TAX (Sales-SR)\"]")
	WebElement actualSales;
	
	@FindBy(xpath = " //iframe[@id=\"mainIndexDynamicIframe\"]")
	WebElement frameelement;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //when the Constructor is invoked ,All the elements of the particular class will be initialized with an Object
		
}
	
	public boolean getDisplayStatusOfParentMenu() {
	boolean parentmenu=	parent.isDisplayed();
	return parentmenu;
		
	}
	
	/*public WebDriver navigateToFrame() {
		WebDriver driver = driver1.switchTo().frame(frame);
		return driver;
	}*/
	public boolean actualSalesIsPresent() {
		driver.switchTo().frame(frameelement);
		boolean sales = actualSales.isDisplayed();
		return sales ;
		
	}
	
	public void clickingOnMenuButton() {
          driver.switchTo().frame(frame);
          Actions actions = new Actions(driver);
		    actions.moveToElement(parent).moveToElement(child).moveToElement(child1).moveToElement(subchild).click().perform();
		    
	}
	
}

	 
	