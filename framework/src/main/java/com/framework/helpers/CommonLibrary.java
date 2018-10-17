package com.framework.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.configurations.ConfigurationLibrary;

public class CommonLibrary {
	
	public String absolutefilePath = "";
	
	
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param timeInSeconds
	 */
	public void waitForElementVisisbility(WebDriver driver, WebElement element, int timeInSeconds){
		try{
			new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.visibilityOf(element));
		}catch (Exception e) {
			System.out.println("Element not visible");
		}
	}
	
	public Boolean isDisplayed(WebDriver driver, WebElement element) {
		try {
			element.isDisplayed();
			System.out.println("Element displayed!");
			return true;
		} catch (Exception e) {
			System.out.println("Element not displayed!");
			return false;
		}
	}
	
	
	
	/**
	 * To get the list of all the files present under the project folder
	 * 
	 * @param folder
	 * @param fileName
	 * @return
	 */
	public void getListFilesForFolder(final File filePath, String fileName) {
		String temp = "";
		for (final File fileEntry : filePath.listFiles()) {
			if (fileEntry.isDirectory()) {
				getListFilesForFolder(fileEntry, fileName);
			} else {
				if (fileEntry.isFile()) {
					temp = fileEntry.getName();
					if (temp.equals(fileName)) {
						if (absolutefilePath.isEmpty() || absolutefilePath.equals("")) {
							absolutefilePath = filePath.getAbsolutePath() + "\\" + fileEntry.getName();
							absolutefilePath = absolutefilePath.replace("\\", "/");
						}
					}
				}
			}
		}
	}
	
	public String getAbsolutePathOfFile(String fileName) {
		getListFilesForFolder(ConfigurationLibrary.filePath, fileName);
		return absolutefilePath;
	}
	
	public void launchBrowser(WebDriver driver, String environment){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println("URL is => "+getPropertyValue(environment));
		driver.get(getPropertyValue(environment));
	}
	
	public String getPropertyValue(String propertyKey){
		String result = "";
		Properties properties = new Properties();
		File file = new File(ConfigurationLibrary.propertiesFilePath);
		try {
			FileInputStream fileInput = new FileInputStream(file);
			properties.load(fileInput);
			fileInput.close();
		} catch (Exception e) {
			System.out.println("File does not exists!");
		}
		result = properties.getProperty(propertyKey);
		return result;
	}

	public void tearDown(WebDriver driver) {
		driver.close();
		
	}

}
