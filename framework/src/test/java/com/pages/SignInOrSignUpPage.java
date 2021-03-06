package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.framework.configurations.Constants;
import com.framework.helpers.CommonLibrary;

public class SignInOrSignUpPage {
	
	WebDriver driver;
	CommonLibrary comLib = new CommonLibrary();
	
	@FindBy(xpath = "//div[@class='social FC DIB active ']/div[contains(text(),'SIGN IN using Email')]")
	private WebElement signInUsingEmailLink;
	
	@FindBy(xpath = "//input[@id='email-mobile']")
	private WebElement emailIdTextField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[@id='doSignin']")
	private WebElement signInButton;
	
	public SignInOrSignUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickSignInUsingEmailLink(){
		java.util.List<WebElement> f = driver.findElements(By.tagName("iframe"));
		for(int i=1; i<f.size(); i=i+1){
			driver.switchTo().frame(i);
			if(comLib.isDisplayed(driver, signInUsingEmailLink)){
				signInUsingEmailLink.click();
				System.out.println("--Successfully clicked on SignIn using Email link--");
				return;
			}else {
				driver.switchTo().defaultContent();
			}
		}	
	}
	
	public void signIn(String userName, String password){
		comLib.waitForElementVisisbility(driver, emailIdTextField, Constants.longWait);
		emailIdTextField.clear();
		emailIdTextField.click();
		emailIdTextField.sendKeys(userName);
		passwordTextField.clear();
		passwordTextField.click();
		passwordTextField.sendKeys(password);
		signInButton.click();
		System.out.println("--Successfully entered Username and Password--");
		System.out.println("--Successfully clicked on Sign In button--");
	}

}
