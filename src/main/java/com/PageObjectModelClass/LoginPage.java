package com.PageObjectModelClass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	Properties prop;
	String userame;
	String pass;
	String validusername;
	String validpassword;
	
	@FindBy(xpath = "//input[@name=\'j_username\' and @class= \'login-input username ng-pristine ng-invalid ng-touched']")
     private WebElement username;
	
	@FindBy(xpath = "\"//input[@class=\\\"login-input password ng-pristine ng-invalid ng-touched\\\"]\")")
	private WebElement password;
	
	@FindBy(xpath= " \"//div[@class=\\\"col-xs-12 p-0 mte-2\\\"]/button[@class=\\\"login-button\\\"]\"))")
	private WebElement loginbutton;
	
	@FindBy(xpath = " \"//p[contains(text(),'Invalid Username or Password')]\"  ")
	private WebElement warningmessage ;
	
	
	@FindBy(xpath = " \"//*[@id=\\\"login-wrap\\\"]/div[2]/form[1]/div[1]/p]\"")
	private WebElement usernamerequired;
	
	@FindBy(xpath = "//*[@id=\\\"login-wrap\\\"]/div[2]/form[1]/div[2]/p\") ")
	private WebElement passwordrequired;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //when the Constructor is invoked ,All the elements of the particular class will be initialized with an Object
		
		
	}
	
	public void clickOnUserButton() {
		username.click(); //Actions Performing Methods
		username.sendKeys(prop.getProperty("validUserName"));
	}
	public void clickOnPasswordButton() {
		password.click();
		username.sendKeys(prop.getProperty("validPassword"));
		
	}
	public void clickOnLoginButton() {
		loginbutton.click();
	}
	
	public void clickOnUserName()
	{
		username.clear();
		username.click();
		username.sendKeys(prop.getProperty("Invalidname"));
		
	}
	public void clickOnPasswordButton1() {
		password.clear();
		password.click();
		password.sendKeys(prop.getProperty("InvalidPassword"));
		
		
	}
	 public void clickOnLogin() {
		 loginbutton.click();
	 }
	 
	 public void validUserName(String validusername) {
		 username.clear();
		 username.click();
		 username.sendKeys(validusername);
		 
	 }
	 public void ValidPassword(String validpassword) {
		 password.clear();
		 password.click();
		 password.sendKeys(validpassword);
	 }
	 
	 public void clickingOnLoginButton() {
		 loginbutton.click();
	 }
	 
	 public void invalidUsername(String userame) {
		 username.clear();
		 username.click();
		 username.sendKeys(userame);
	 }
	 
	 public void invalidPass(String pass) {
		 password.clear();
		 password.click();
		 password.sendKeys(pass);
	 }
	 public void loginClick() {
		 loginbutton.click();
	 }
	 
	 public String usernamePassNotMatching() {
		String warningmsg = warningmessage.getText();
		 return warningmsg;
	 }
	 
	 public String userNameRequired() {
		 String namerequired = username.getText();
		return namerequired;
		 
	 }
	 
	 public String passWordRequired() {
		 String namerequired = passwordrequired.getText();
		return namerequired;
		 
	 }
	 
	 
}



