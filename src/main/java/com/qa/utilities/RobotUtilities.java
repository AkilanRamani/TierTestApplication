package com.qa.utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotUtilities {

	public static void main(String[] args) throws AWTException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("www.google.com");
		
		driver.findElement(By.xpath(""));
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("")); //Provide the DOM location of alert 
		Robot r1 = new Robot();
        
        
        Rectangle rectangle = new Rectangle(25,50,1000,300);
        String destination = System.getProperty("user.dir")+"//Screenshots//robotonetest.png";
        BufferedImage bufferedimage =  robot.createScreenCapture(rectangle);
       ImageIO.write(bufferedimage, "png", new File(destination));
       
       

       java.awt.Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       Rectangle rectangle1 = new Rectangle(dimension);
       String destination1 = System.getProperty("user.dir")+"//Screenshots//robotone.png";
       BufferedImage bufferedimage1 =  robot.createScreenCapture(rectangle1);
      ImageIO.write(bufferedimage1, "png", new File(destination1));
		
		Robot r2 = new Robot();
		r2.mouseWheel(16); //this will scroll down 
		r2.delay(3000);
		r2.mouseWheel(-8); //this will scroll up
		
		
		//uploading a File 
		Robot robotwindow = new Robot();
		
		String path = System.getProperty("user.dir") +"\\Screenshots\\robot2.png";
		StringSelection stringselection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, stringselection);
		
		WebElement target = driver.findElement(By.xpath(""));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(target).click().build().perform();
		
		robot.delay(3000);
		robotwindow.keyPress(KeyEvent.VK_CONTROL);
		robotwindow.keyPress(KeyEvent.VK_V);
		robotwindow.keyRelease(KeyEvent.VK_CONTROL);
		robotwindow.keyRelease(KeyEvent.VK_V);
		
		driver.findElement(By.xpath("")).click(); //click on upload 
		
		driver.findElement(By.xpath(""));
		Robot r3 = new Robot();
		
		
		//downloading a File 
		r3.keyPress(KeyEvent.VK_DOWN);
		r3.keyRelease(KeyEvent.VK_DOWN);
		
		r3.delay(3000);
		
		r3.keyPress(KeyEvent.VK_TAB);
		r3.keyRelease(KeyEvent.VK_TAB);
		
		r3.delay(3000);
		r3.keyPress(KeyEvent.VK_TAB);
		r3.keyRelease(KeyEvent.VK_TAB);
		
		r3.delay(3000);
		
		r3.keyPress(KeyEvent.VK_ENTER);
		r3.keyRelease(KeyEvent.VK_ENTER);
		
		
		Robot r4 = new Robot();
		
		r4.delay(2000);
		r4.mouseMove(250, 275);  //moving mouse to a particular element as Per an Axis
		
		r4.mouseMove(250, 400);
		r4.mousePress(InputEvent.BUTTON1_DOWN_MASK);  //Left click
		r4.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		r4.mousePress(InputEvent.BUTTON3_DOWN_MASK);  //Right click
		r4.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		
	  
		r4.keyPress(KeyEvent.VK_DOWN);
		r4.keyRelease(KeyEvent.VK_DOWN);
		
		r4.delay(2000);
		
		
		r4.keyPress(KeyEvent.VK_ENTER);
		r4.keyRelease(KeyEvent.VK_ENTER);
	}

}
