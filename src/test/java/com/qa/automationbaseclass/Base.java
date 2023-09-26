package com.qa.automationbaseclass;


	
	import java.io.File;
	import java.io.FileInputStream;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.safari.SafariDriver;



	

	public class Base {
		
		
		public  WebDriver driver;
		public Properties prop;
		public Base() {
			
		    prop = new Properties();
			File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\configproperties\\config.properties");
			try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			}
			catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
				
			if(browserName.equalsIgnoreCase("chrome")) {
				
				driver = new ChromeDriver();
				
			}else if(browserName.equalsIgnoreCase("firefox")) {
				
				driver = new FirefoxDriver();
				
			}else if(browserName.equalsIgnoreCase("edge")) {
				
				driver = new EdgeDriver();
				
			}else if(browserName.equalsIgnoreCase("safari")) {
				
				driver = new SafariDriver();
				
			}
			
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions chrome = new ChromeOptions();
			chrome.addArguments("\"--disable-notifications\"");
		    driver = new ChromeDriver(chrome);
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
			driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(10)));
			driver.get(prop.getProperty("url"));
			
			return driver;
			
		}
		
		
		
		
		
	}


