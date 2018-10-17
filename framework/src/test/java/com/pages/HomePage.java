package com.pages;

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
	
	@FindBy(xpath = "//li[@id='signOutLink']")
	private WebElement signOutLink;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRedBusIndiaButton(){
		comLib.waitForElementVisisbility(driver, redbusIndiaButton, Constants.mediumWait);
		redbusIndiaButton.click();
		System.out.println("--Successfully clicked RedBus India button--");
	}
	
	public void clickUserProfileIcon(){
		comLib.waitForElementVisisbility(driver, userProfileIcon, Constants.mediumWait);
		userProfileIcon.click();
		System.out.println("--Successfully clicked UserProfile Icon--");
	}
	
	public void clickSignInLink(){
		comLib.waitForElementVisisbility(driver, signInLink, Constants.mediumWait);
		signInLink.click();
		System.out.println("--Successfully clicked SignIn Link--");
	}
	
	public void clickSignOutLink(){
		comLib.waitForElementVisisbility(driver, signOutLink, Constants.mediumWait);
		signInLink.click();
		System.out.println("--Successfully clicked SignOut Link--");
	}
	
	public void assertLoginSuccess(){
		comLib.waitForElementVisisbility(driver, userProfileIcon, Constants.mediumWait);
		userProfileIcon.click();
		comLib.waitForElementVisisbility(driver, signOutLink, Constants.mediumWait);
		userProfileIcon.click();
		System.out.println("--Successfully Logged in--");
	}
	
	public void signOut(){
		comLib.waitForElementVisisbility(driver, userProfileIcon, Constants.mediumWait);
		userProfileIcon.click();
		comLib.waitForElementVisisbility(driver, signOutLink, Constants.mediumWait);
		signOutLink.click();
		System.out.println("--Successfully Logged Out--");
	}
	
	
	
	
	

}
