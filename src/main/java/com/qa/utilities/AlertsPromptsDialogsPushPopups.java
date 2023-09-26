package com.qa.utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsPromptsDialogsPushPopups {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("www.google.com");
		
		//clicking on the element which will open an alert 
		driver.findElement(By.id("")).click(); 
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		String alertmsg = alert.getText();
		System.out.println(alertmsg);
		alert.accept();
		alert.dismiss();
		
		driver.quit();
		//driver.close();
	 //incase of If input data needs to send to an alert in Java script pop ups
		driver.findElement(By.id("")).click(); 
		WebDriverWait waiting = new WebDriverWait(driver , Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alertpop = driver.switchTo().alert();
		String alertmsge = alert.getText();
		System.out.println(alertmsg);
		
		alert.sendKeys("TestAutomation");
		alert.accept();
		alert.dismiss();
		driver.quit();
		
		//Handling authentication Popus
		WebDriver driver1 = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		//disable pop up notifications 
		WebDriverManager.chromedriver().setup();
		ChromeOptions chrome = new ChromeOptions();
		chrome.addArguments("\"--disable-notifications\"");
	    driver = new ChromeDriver(chrome);
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(10)));
		driver.get("");
	}
}
