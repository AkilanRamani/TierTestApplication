package com.qa.utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.io.FileHandler;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class ScreenShotUtils {

	public static void main(String[] args) throws IOException, AWTException {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("www.google.com");
		
      TakesScreenshot screenshot =  ((TakesScreenshot)driver);
      File file =   screenshot.getScreenshotAs(OutputType.FILE);
      File destfile = new File ("./Screenshots/test.png");
      try {
		FileUtils.copyFile(file, destfile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
      
      File scr1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileHandler.copy(scr1,new File ("./Screenshots/test4.png")); 
     
      
      //Taking Screenshot of particular element 
        WebElement element = driver.findElement(By.xpath(""));
        File scrfile  = element.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrfile, new File("./Screenshots/test2.png"));
        
        //Take screenshot of full web page 
        FirefoxDriver driverfox = new FirefoxDriver();
        
        WebDriver driverfoxd = new FirefoxDriver();
        FirefoxDriver shot   =  ((FirefoxDriver)driverfoxd);
        File srcfox = shot.getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcfox, new File("./Screenshots/test9.png"));
       
        File scrfile1  = driverfox.getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrfile1, new File("./Screenshots/test9.png"));
        
        //Robot class can take the screenshot of alerts and an URL of the Application.
        driver.findElement(By.xpath("")); //Provide the DOM location of alert 
        Robot robot = new Robot();
        java.awt.Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        String destination = System.getProperty("user.dir")+"//Screenshots//robotone.png";
        BufferedImage bufferedimage =  robot.createScreenCapture(rectangle);
       ImageIO.write(bufferedimage, "png", new File(destination));
       
      Alert alert =  driver.switchTo().alert();
      alert.accept();
       
     driver.quit();
      
     Screenshot shot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
     String destination1 = System.getProperty("user.dir")+"//Screenshots//fullpage.png";
    ImageIO.write(shot1.getImage(), "png", new File(destination1));
      
        
	}
	

}
