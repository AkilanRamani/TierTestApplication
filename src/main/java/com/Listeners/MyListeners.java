package com.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utilities.ExtentReport;

public class MyListeners implements ITestListener {
	
	ExtentReports extentreports;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {  
		 String testName = result.getName();
	    test = extentreports.createTest(testName);
		test.log(Status.INFO, testName + "started successfully");
		 
		 System.out.println("Execution of Test cases started : "+testName);
		
		
		}  
		  
	  
		public void onTestSuccess(ITestResult result) { 
	    String testName = result.getName();
	    test.log(Status.PASS, testName + " test name got successfully Executed ");
		}
	
		public void onTestFailure(ITestResult result) {  
	    String testFailName = result.getName();
	    
	    WebDriver driver = null;
	    
	     IClass c = result.getTestClass();
	     Class<?> s = c.getRealClass();
	    
			try {
				Object obj =  s.getDeclaredField("driver").get(result.getInstance());
				 driver=(WebDriver)obj;
			} catch (IllegalArgumentException e1) {
				
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				
				e1.printStackTrace();
			} catch (NoSuchFieldException e1) {
				
				e1.printStackTrace();
			} catch (SecurityException e1) {
				
				e1.printStackTrace();
			}
		
	      
	   
		
	      TakesScreenshot screenshot =  ((TakesScreenshot)driver);
	      File file =   screenshot.getScreenshotAs(OutputType.FILE);
	      String destinationpath = System.getProperty("user.dir")+"\\Screenshots\\"+testFailName+".png";
	      
	      File destfile = new File ("./Screenshots/test.png");
	      try {
			FileUtils.copyFile(file, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	      test.addScreenCaptureFromBase64String(destinationpath);
	      test.log(Status.INFO, result.getThrowable());

	      test.log(Status.FAIL, testFailName+"got failed");
	    
		System.out.println("Failure of test cases and its details are : "+result.getName());  
		System.out.println(result.getThrowable());
		}  
		  
	 
		public void onTestSkipped(ITestResult result) {  
			String testSkippedName = result.getName();
			test.log(Status.INFO, result.getThrowable());

		    test.log(Status.SKIP,testSkippedName +"got skipped");
			
			System.out.println("Skipped test cases and its details are : "+result.getName());  
			System.out.println(result.getThrowable());
		}  
		  
		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
		 
		System.out.println("Failure of test cases and its details are : "+result.getName());  
		}  
		  
	
		public void onStart(ITestContext context) {  
			
			 extentreports = ExtentReport.generateExtentReport();
			
			System.out.println("Execution of Test cases have been started");
		 
		}  
		  
	 
		public void onFinish(ITestContext context) {  
	      
			//Log all the Information in the Report 
			extentreports.flush();
			
			String pathofextentreport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentsReport.html";
			File extentfile = new File(pathofextentreport);
			URI uri = extentfile.toURI();
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}  
		}  


