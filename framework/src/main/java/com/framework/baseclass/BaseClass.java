package com.framework.baseclass;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.framework.helpers.CommonLibrary;

import com.framework.configurations.ConfigurationLibrary;

public class BaseClass {
	
	public WebDriver driver;
	public static CommonLibrary comLib;
	
	public void initilize() {
		comLib = new CommonLibrary();
	}
	
	@BeforeClass
	@Parameters({"browserName","environment"})
	public void beforeClass(@Optional("chromedriver") String browserName, @Optional("Prod") String environment) throws FileNotFoundException{
		initilize();
		if(driver==null){
			System.out.println("Browser Name is => "+browserName);
			System.out.println("Environment name is => "+environment);
			switch(browserName){
			case "chrome":
				System.out.println("Initializing Chrome Driver");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", ConfigurationLibrary.chromeDriverPath);
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;
			case "firefox":
				System.out.println("Initializing Firefox Driver");
				System.setProperty("webdriver.gecko.driver", ConfigurationLibrary.firefoxDriverPath);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			default:
				System.out.println("Initializing Chrome Driver");
				System.setProperty("webdriver.chrome.driver", ConfigurationLibrary.chromeDriverPath);
				driver = new ChromeDriver();
				break;
			}
		}else{
			System.out.println("Driver object already initialized");
		}
		
		comLib.launchBrowser(driver, environment);
	}
	
	@AfterClass
	public void afterClass(){
		comLib.tearDown(driver);
	}
	
	
}
