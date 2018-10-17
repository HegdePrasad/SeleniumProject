package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.configurations.Constants;
import com.framework.helpers.CommonLibrary;

public class HomePage {
	
	WebDriver driver;
	CommonLibrary comLib = new CommonLibrary();
	
	@FindBy(xpath = "//div[contains(text(),'redBus India')]")
	private WebElement redbusIndiaButton;
	
	@FindBy(xpath = "//i[@id='i-icon-profile']")
	private WebElement userProfileIcon;
	
	@FindBy(xpath = "//li[@id='signInLink']")
	private WebElement signInLink;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRedBusIndiaButton(){
		comLib.waitForElementVisisbility(driver, redbusIndiaButton, Constants.mediumWait);
		WebElement elem = driver.findElement(By.xpath("//div[contains(text(),'redBus India')]"));
		System.out.println(elem.isDisplayed());
		redbusIndiaButton.click();
	}
	
	public void clickUserProfileIcon(){
		comLib.waitForElementVisisbility(driver, userProfileIcon, Constants.mediumWait);
		userProfileIcon.click();
	}
	
	public void clickSignInLink(){
		comLib.waitForElementVisisbility(driver, signInLink, Constants.mediumWait);
		signInLink.click();
	}
	
	
	
	
	

}
