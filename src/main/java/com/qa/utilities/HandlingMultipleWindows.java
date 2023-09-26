package com.qa.utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindows {

	static WebDriver driver = null;
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("www.google.com");
		
		driver.findElement(By.xpath("")); 
		
		//which will Return the ID of a string Type For a parent window 
		
		String parentwindow = driver.getWindowHandle(); 
		
		driver.findElement(By.xpath("")).click(); //Performing a click action in which child window will open 
        
		driver.findElement(By.xpath("")).click();// Performing a click action in which another child window will open 
		
	   driver.findElement(By.xpath("")).getText(); //Text in a child window capturing 
	   
	   Set<String> allwindows = driver.getWindowHandles();
	   Iterator<String> itr = allwindows.iterator();
	   while(itr.hasNext()) {
		   String winghand = itr.next();
		   
		   driver.switchTo().window(winghand);
		   if(driver.getTitle().equals(""))
		   {
			 String childwin =  driver.findElement(By.xpath("")).getText(); //getting the Text of a child window
			 System.out.println(childwin);
			 break;
		   }
  }
	   Iterator<String> itr1 = allwindows.iterator();
	   while(itr1.hasNext()) {
		   String winghand = itr1.next();
		   
		   driver.switchTo().window(winghand);
		   if(driver.getTitle().equals(""))
		   {
			 String childwin =  driver.findElement(By.xpath("")).getText(); //getting the Text of a child window
			 driver.findElement(By.xpath("")).click();
			 System.out.println(childwin);
			 break;
		   }
  }

	   driver.switchTo().window(parentwindow);
	   driver.switchTo().defaultContent();
	   
	   driver.findElement(By.xpath("")).click(); //Performing a click actions on the parent window after navigation
	   driver.close(); //which will close the parent window not the child window 
	   
	   //closing the child window case 
	   Iterator<String> itr2 = allwindows.iterator();
	   while(itr2.hasNext()) {
		   String winghand23 = itr2.next();
		   
		   driver.switchTo().window(winghand23);
		   if(driver.getTitle().equals(""))
		   {
			 String childwin =  driver.findElement(By.xpath("")).getText(); //getting the Text of a child window
			 System.out.println(childwin);
			  
			 driver.close(); //which will close the currently opening child window 
			 break;
		   }
		   
  }
	}   
	
	//Re-usable Method 
   public static void switchToRequiredWindow(String title)	{
	   
		Set<String> parentwindow1 = driver.getWindowHandles(); 

	   Iterator<String> i = parentwindow1.iterator();
	   while(i.hasNext()) {
		   String winghand23 = i.next();
		   
		   driver.switchTo().window(winghand23);
		   if(driver.getTitle().equals(title))
		   {
			 String childwin =  driver.findElement(By.xpath("")).getText(); //getting the Text of a child window
			 System.out.println(childwin);
			 break;
		   }
	   }
}
   
   
}


